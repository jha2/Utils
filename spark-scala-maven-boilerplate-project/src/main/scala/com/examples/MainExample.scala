package com.examples

import org.apache.spark.SparkContext._

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.log4j.Logger

object MainExample {

  def main(arg: Array[String]) {

    var logger = Logger.getLogger(this.getClass())

    if (arg.length < 2) {
      logger.error("=> wrong parameters number")
      System.err.println("Usage: MainExample <path-to-files> <output-path>")
      System.exit(1)
    }

    val jobName = "FrequentVisitors"

    val conf = new SparkConf().setAppName(jobName)
    val sc = new SparkContext(conf)

    val pathToFiles = arg(0)
    val outputPath = arg(1)

    logger.info("=> jobName \"" + jobName + "\"")
    logger.info("=> pathToFiles \"" + pathToFiles + "\"")

    val parser = new AccessLogParser
    val log = sc.textFile(pathToFiles)

    //Get  a list of URIs
    val uris = log.map(line => parser.parseRecordReturningNullObjectOnFailure(line).request)
      .filter(request => request != "")
      .map(request => request.split(" ")(1)) // a request looks like "GET /foo HTTP/1.1"

    // works: use the previous example to get to a series of "(URI, COUNT)" pairs; (MapReduce like)
    val uriCount = log.map(parser.parseRecordReturningNullObjectOnFailure(_).request)
      .filter(request => request != "") // filter out records that wouldn't parse properly
      .map(_.split(" ")(1)) // get the uri field
      .map(uri => (uri, 1)) // create a tuple for each record
      .reduceByKey((a, b) => a + b) // reduce to get this for each record: (/java/java_oo/up.png,2)
      .collect

    //Now that I have the hit count for each URI, I can get what I want, the data sorted, with the highest number of hits listed first
    import scala.collection.immutable.ListMap
    val uriHitCount = ListMap(uriCount.toSeq.sortWith(_._2 > _._2): _*)

    //print the top 20 most hit uris
    uriHitCount.take(20).foreach(println)


    //Writing results to file
    import java.io._
    val file = new File(outputPath)
    val bw = new BufferedWriter(new FileWriter(file))
    for {
      record <- uriHitCount
      val uri = record._1
      val count = record._2
    } bw.write(s"$count => $uri\n")
    bw.close

  }
}
