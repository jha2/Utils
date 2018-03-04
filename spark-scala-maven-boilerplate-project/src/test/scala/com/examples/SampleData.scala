package com.examples

object SampleCombinedAccessLogRecords {

  val data =
    """
      128.159.77.122 - - [28/Jul/1995:13:32:11 -0400] "GET /facilities/lf.html HTTP/1.0" 200 1214
      128.159.77.122 - - [28/Jul/1995:13:32:11 -0400] "GET /images/lf-logo.gif HTTP/1.0" 404 -
      192.138.199.30 - - [28/Jul/1995:13:32:11 -0400] "GET /elv/uplink2.htm HTTP/1.0" 200 2031
      139.169.210.47 - - [28/Jul/1995:13:32:11 -0400] "GET /shuttle/technology/images/srb_mod_compare_1-small.gif HTTP/1.0" 200 36902
      163.205.53.14 - - [28/Jul/1995:13:32:12 -0400] "GET /images/shuttle-patch-small.gif HTTP/1.0" 200 4179
      proxy0.research.att.com - - [28/Jul/1995:13:32:12 -0400] "GET /images/launch.gif HTTP/1.0" 200 240458
      tty13.maze.ppp.uab.edu - - [28/Jul/1995:13:32:13 -0400] "GET /history/apollo/images/footprint-small.gif HTTP/1.0" 200 18149
      alyssa.prodigy.com - - [28/Jul/1995:13:32:14 -0400] "GET /shuttle/countdown/liftoff.html HTTP/1.0" 200 5220
      slipper12055.iaccess.za - - [28/Jul/1995:13:32:16 -0400] "GET /images/MOSAIC-logosmall.gif HTTP/1.0" 200 363
      163.205.53.14 - - [28/Jul/1995:13:32:16 -0400] "GET /images/KSC-logosmall.gif HTTP/1.0" 200 1204
      163.205.53.14 - - [28/Jul/1995:13:32:16 -0400] "GET /images/launch-logo.gif HTTP/1.0" 200 1713
      maynard.isi.uconn.edu - - [28/Jul/1995:13:32:17 -0400] "GET /shuttle/technology/sts-newsref/sts_egress.html HTTP/1.0" 200 86379
      139.169.210.47 - - [28/Jul/1995:13:32:18 -0400] "GET /shuttle/technology/images/srb_mod_compare_3-small.gif HTTP/1.0" 200 55666
      tornado.umd.edu - - [28/Jul/1995:13:32:18 -0400] "GET /shuttle/missions/sts-74/mission-sts-74.html HTTP/1.0" 200 3790
      199.0.2.27 - - [28/Jul/1995:13:32:19 -0400] "GET / HTTP/1.0" 200 7280
      gk-east.usps.gov - - [28/Jul/1995:13:32:19 -0400] "GET /facts/faq.html HTTP/1.0" 200 18290
      cam2-2.agt.gmeds.com - - [28/Jul/1995:13:32:20 -0400] "GET /images/ksclogosmall.gif HTTP/1.0" 200 3635
      199.0.2.27 - - [28/Jul/1995:13:32:20 -0400] "GET /images/NASA-logosmall.gif HTTP/1.0" 200 786
      199.0.2.27 - - [28/Jul/1995:13:32:20 -0400] "GET /images/MOSAIC-logosmall.gif HTTP/1.0" 200 363
    """.split("\n").filter(_!= "")

  val badRecord = """
199.0.2.27 - - [28/Jul/1995:13:32:20 -0400] "GET /images/MOSAIC-logosmall.gif HTTP/1.0" 200 -
""".split("\n").filter(_ != "")


}
