---
title: 2020-10-28
date: 2020-10-28 16:34
---
[TOC]
## 串行GC的运行情况
### > **50-100m**的时候运行情况，在堆内存快满的时候触发了fullGC，然后一直fullGC，直到内存溢出
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseSerialGC -Xms50m -Xmx100m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:33:09.385-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.385-0800: [DefNew: 13604K->1664K(15360K), 0.0036059 secs] 13604K->5711K(49536K), 0.0036439 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.391-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.391-0800: [DefNew: 15123K->1658K(15360K), 0.0035305 secs] 19170K->10742K(49536K), 0.0035573 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.397-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.397-0800: [DefNew: 15327K->1636K(15360K), 0.0021796 secs] 24411K->14205K(49536K), 0.0022061 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.402-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.402-0800: [DefNew: 15229K->1627K(15360K), 0.0025426 secs] 27798K->18982K(49536K), 0.0025932 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.410-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.410-0800: [DefNew: 15208K->1658K(15360K), 0.0019345 secs] 32562K->22248K(49536K), 0.0019727 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.414-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.414-0800: [DefNew: 15299K->1654K(15360K), 0.0026235 secs] 35889K->27195K(49536K), 0.0026495 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.419-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.419-0800: [DefNew: 14836K->1653K(15360K), 0.0028676 secs] 40377K->32190K(49536K), 0.0029000 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T16:33:09.424-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.424-0800: [DefNew: 15292K->1655K(15360K), 0.0026509 secs]2020-10-28T16:33:09.427-0800: [Tenured: 35446K->35437K(35544K), 0.0021404 secs] 45830K->36355K(50904K), [Metaspace: 2696K->2696K(1056768K)], 0.0048804 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.434-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.434-0800: [DefNew: 23487K->2941K(26624K), 0.0051308 secs] 58924K->44911K(85688K), 0.0051578 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.443-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.443-0800: [DefNew: 26517K->2939K(26624K), 0.0058879 secs] 68487K->52983K(85688K), 0.0059218 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
2020-10-28T16:33:09.451-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.451-0800: [DefNew: 26426K->2938K(26624K), 0.0050573 secs]2020-10-28T16:33:09.456-0800: [Tenured: 59448K->59424K(59456K), 0.0040224 secs] 76470K->60835K(86080K), [Metaspace: 2696K->2696K(1056768K)], 0.0091479 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:33:09.466-0800: [GC (Allocation Failure) 2020-10-28T16:33:09.466-0800: [DefNew: 27276K->27276K(30720K), 0.0000139 secs]2020-10-28T16:33:09.466-0800: [Tenured: 59424K->68092K(68288K), 0.0094145 secs] 86700K->71317K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0094682 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T16:33:09.480-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.480-0800: [Tenured: 68164K->68281K(68288K), 0.0135064 secs] 98823K->76179K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0135527 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:33:09.501-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.501-0800: [Tenured: 68281K->68281K(68288K), 0.0031734 secs] 98978K->86262K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0032136 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.506-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.506-0800: [Tenured: 68281K->68281K(68288K), 0.0030404 secs] 98964K->91284K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0030932 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.510-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.510-0800: [Tenured: 68281K->68281K(68288K), 0.0018793 secs] 98894K->94485K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0019142 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.513-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.513-0800: [Tenured: 68281K->68205K(68288K), 0.0124653 secs] 98936K->93143K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0125042 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:33:09.527-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.527-0800: [Tenured: 68205K->68205K(68288K), 0.0023706 secs] 98925K->96581K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0024090 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.530-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.530-0800: [Tenured: 68205K->68205K(68288K), 0.0023869 secs] 98890K->97601K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0024209 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.533-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.533-0800: [Tenured: 68274K->68274K(68288K), 0.0020226 secs] 98977K->98435K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0021209 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.535-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.535-0800: [Tenured: 68274K->68203K(68288K), 0.0115698 secs] 98456K->97423K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0116134 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:33:09.547-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.547-0800: [Tenured: 68239K->68239K(68288K), 0.0015709 secs] 98942K->98896K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0016096 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:33:09.548-0800: [Full GC (Allocation Failure) 2020-10-28T16:33:09.548-0800: [Tenured: 68239K->68220K(68288K), 0.0097737 secs] 98896K->98877K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0098077 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3332)
	at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:674)
	at java.lang.StringBuilder.append(StringBuilder.java:208)
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:55)
	at GCLogAnalysis.main(GCLogAnalysis.java:24)
Heap
 def new generation   total 30720K, used 30703K [0x00000007b9c00000, 0x00000007bbd50000, 0x00000007bbd50000)
  eden space 27328K, 100% used [0x00000007b9c00000, 0x00000007bb6b0000, 0x00000007bb6b0000)
  from space 3392K,  99% used [0x00000007bb6b0000, 0x00000007bb9fbf10, 0x00000007bba00000)
  to   space 3392K,   0% used [0x00000007bba00000, 0x00000007bba00000, 0x00000007bbd50000)
 tenured generation   total 68288K, used 68220K [0x00000007bbd50000, 0x00000007c0000000, 0x00000007c0000000)
   the space 68288K,  99% used [0x00000007bbd50000, 0x00000007bffef280, 0x00000007bffef400, 0x00000007c0000000)
 Metaspace       used 2727K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 298K, capacity 386K, committed 512K, reserved 1048576K
```
### >**512m**的时候的运行情况。进行了20来此youngGC ，并没有进行fullGC，因为串行GC只有到内存快满的时候才进行fullGC
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:29:39.331-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.331-0800: [DefNew: 139776K->17471K(157248K), 0.0258908 secs] 139776K->45940K(506816K), 0.0259290 secs] [Times: user=0.01 sys=0.01, real=0.02 secs]
2020-10-28T16:29:39.378-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.378-0800: [DefNew: 157247K->17470K(157248K), 0.0370913 secs] 185716K->85053K(506816K), 0.0371305 secs] [Times: user=0.02 sys=0.02, real=0.04 secs]
2020-10-28T16:29:39.435-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.435-0800: [DefNew: 157246K->17471K(157248K), 0.0300841 secs] 224829K->122680K(506816K), 0.0301184 secs] [Times: user=0.02 sys=0.01, real=0.03 secs]
2020-10-28T16:29:39.490-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.490-0800: [DefNew: 157247K->17471K(157248K), 0.0387688 secs] 262456K->166053K(506816K), 0.0388099 secs] [Times: user=0.03 sys=0.02, real=0.03 secs]
2020-10-28T16:29:39.549-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.549-0800: [DefNew: 157247K->17471K(157248K), 0.0786307 secs] 305829K->217837K(506816K), 0.0786662 secs] [Times: user=0.02 sys=0.01, real=0.08 secs]
2020-10-28T16:29:39.651-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.651-0800: [DefNew: 157247K->17471K(157248K), 0.0651246 secs] 357613K->260742K(506816K), 0.0651772 secs] [Times: user=0.02 sys=0.02, real=0.06 secs]
2020-10-28T16:29:39.740-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.740-0800: [DefNew: 157247K->17471K(157248K), 0.0414160 secs] 400518K->308358K(506816K), 0.0414631 secs] [Times: user=0.03 sys=0.02, real=0.04 secs]
2020-10-28T16:29:39.799-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.799-0800: [DefNew: 157247K->17470K(157248K), 0.0360329 secs] 448134K->350008K(506816K), 0.0360870 secs] [Times: user=0.02 sys=0.01, real=0.04 secs]
2020-10-28T16:29:39.855-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.855-0800: [DefNew: 157246K->157246K(157248K), 0.0000229 secs]2020-10-28T16:29:39.855-0800: [Tenured: 332537K->274753K(349568K), 0.0741403 secs] 489784K->274753K(506816K), [Metaspace: 2696K->2696K(1056768K)], 0.0742481 secs] [Times: user=0.07 sys=0.00, real=0.07 secs]
2020-10-28T16:29:39.952-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.952-0800: [DefNew: 139776K->17470K(157248K), 0.0083339 secs] 414529K->319275K(506816K), 0.0083889 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:29:39.989-0800: [GC (Allocation Failure) 2020-10-28T16:29:39.989-0800: [DefNew: 157246K->157246K(157248K), 0.0000213 secs]2020-10-28T16:29:39.989-0800: [Tenured: 301804K->306609K(349568K), 0.0630310 secs] 459051K->306609K(506816K), [Metaspace: 2696K->2696K(1056768K)], 0.0631100 secs] [Times: user=0.06 sys=0.00, real=0.07 secs]
2020-10-28T16:29:40.080-0800: [GC (Allocation Failure) 2020-10-28T16:29:40.080-0800: [DefNew: 139776K->139776K(157248K), 0.0000194 secs]2020-10-28T16:29:40.080-0800: [Tenured: 306609K->316782K(349568K), 0.0583190 secs] 446385K->316782K(506816K), [Metaspace: 2697K->2697K(1056768K)], 0.0583988 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-28T16:29:40.164-0800: [GC (Allocation Failure) 2020-10-28T16:29:40.164-0800: [DefNew: 139776K->139776K(157248K), 0.0000326 secs]2020-10-28T16:29:40.164-0800: [Tenured: 316782K->318508K(349568K), 0.0657714 secs] 456558K->318508K(506816K), [Metaspace: 2697K->2697K(1056768K)], 0.0659421 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-28T16:29:40.251-0800: [GC (Allocation Failure) 2020-10-28T16:29:40.251-0800: [DefNew: 139699K->139699K(157248K), 0.0000196 secs]2020-10-28T16:29:40.251-0800: [Tenured: 318508K->347597K(349568K), 0.0511703 secs] 458207K->347597K(506816K), [Metaspace: 2697K->2697K(1056768K)], 0.0512429 secs] [Times: user=0.05 sys=0.01, real=0.05 secs]
执行结束!共生成对象次数:7325   
Heap
 def new generation   total 157248K, used 5980K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,   4% used [0x00000007a0000000, 0x00000007a05d70d0, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
  to   space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
 tenured generation   total 349568K, used 347597K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
   the space 349568K,  99% used [0x00000007aaaa0000, 0x00000007bfe13638, 0x00000007bfe13800, 0x00000007c0000000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```
### > 在**1g** 的时候运行情况   youngGC次数明显变少，增加内存一倍，但是生成的对象并没有显示增长，证明增加内存并不能增加串行GC的效率
```
 java -XX:+UseSerialGC -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:30:21.165-0800: [GC (Allocation Failure) 2020-10-28T16:30:21.165-0800: [DefNew: 279616K->34944K(314560K), 0.0558496 secs] 279616K->84427K(1013632K), 0.0559012 secs] [Times: user=0.04 sys=0.02, real=0.06 secs]
2020-10-28T16:30:21.273-0800: [GC (Allocation Failure) 2020-10-28T16:30:21.273-0800: [DefNew: 314560K->34943K(314560K), 0.1051259 secs] 364043K->163335K(1013632K), 0.1051670 secs] [Times: user=0.04 sys=0.04, real=0.10 secs]
2020-10-28T16:30:21.416-0800: [GC (Allocation Failure) 2020-10-28T16:30:21.416-0800: [DefNew: 314559K->34943K(314560K), 0.0683463 secs] 442951K->245761K(1013632K), 0.0683861 secs] [Times: user=0.04 sys=0.02, real=0.07 secs]
2020-10-28T16:30:21.525-0800: [GC (Allocation Failure) 2020-10-28T16:30:21.525-0800: [DefNew: 314559K->34941K(314560K), 0.0640799 secs] 525377K->325165K(1013632K), 0.0641456 secs] [Times: user=0.04 sys=0.03, real=0.06 secs]
2020-10-28T16:30:21.623-0800: [GC (Allocation Failure) 2020-10-28T16:30:21.623-0800: [DefNew: 314077K->34944K(314560K), 0.0580873 secs] 604301K->397797K(1013632K), 0.0581245 secs] [Times: user=0.03 sys=0.02, real=0.06 secs]
2020-10-28T16:30:21.723-0800: [GC (Allocation Failure) 2020-10-28T16:30:21.723-0800: [DefNew: 314560K->34944K(314560K), 0.0670123 secs] 677413K->477772K(1013632K), 0.0670504 secs] [Times: user=0.04 sys=0.03, real=0.07 secs]
2020-10-28T16:30:21.825-0800: [GC (Allocation Failure) 2020-10-28T16:30:21.825-0800: [DefNew: 314560K->34943K(314560K), 0.0612591 secs] 757388K->554217K(1013632K), 0.0613036 secs] [Times: user=0.04 sys=0.02, real=0.06 secs]
2020-10-28T16:30:21.923-0800: [GC (Allocation Failure) 2020-10-28T16:30:21.923-0800: [DefNew: 314559K->34944K(314560K), 0.0686106 secs] 833833K->635386K(1013632K), 0.0686560 secs] [Times: user=0.04 sys=0.03, real=0.07 secs]
执行结束!共生成对象次数:8482
Heap
 def new generation   total 314560K, used 46156K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)
  eden space 279616K,   4% used [0x0000000780000000, 0x0000000780af3348, 0x0000000791110000)
  from space 34944K, 100% used [0x0000000791110000, 0x0000000793330000, 0x0000000793330000)
  to   space 34944K,   0% used [0x0000000793330000, 0x0000000793330000, 0x0000000795550000)
 tenured generation   total 699072K, used 600442K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)
   the space 699072K,  85% used [0x0000000795550000, 0x00000007b9fae848, 0x00000007b9faea00, 0x00000007c0000000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```
### > 在4g的时候的运行情况,只进行了两次GC，并且生成的对象和1g的时候一样
```
java -XX:+UseSerialGC -Xms4g -Xmx4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:30:39.825-0800: [GC (Allocation Failure) 2020-10-28T16:30:39.825-0800: [DefNew: 1118528K->139775K(1258304K), 0.1448043 secs] 1118528K->242630K(4054528K), 0.1448479 secs] [Times: user=0.08 sys=0.06, real=0.15 secs]
2020-10-28T16:30:40.157-0800: [GC (Allocation Failure) 2020-10-28T16:30:40.157-0800: [DefNew: 1258303K->139776K(1258304K), 0.2070223 secs] 1361158K->390469K(4054528K), 0.2070562 secs] [Times: user=0.09 sys=0.07, real=0.21 secs]
执行结束!共生成对象次数:8522
Heap
 def new generation   total 1258304K, used 184486K [0x00000006c0000000, 0x0000000715550000, 0x0000000715550000)
  eden space 1118528K,   3% used [0x00000006c0000000, 0x00000006c2ba99d0, 0x0000000704450000)
  from space 139776K, 100% used [0x0000000704450000, 0x000000070ccd0000, 0x000000070ccd0000)
  to   space 139776K,   0% used [0x000000070ccd0000, 0x000000070ccd0000, 0x0000000715550000)
 tenured generation   total 2796224K, used 250693K [0x0000000715550000, 0x00000007c0000000, 0x00000007c0000000)
   the space 2796224K,   8% used [0x0000000715550000, 0x0000000724a217f0, 0x0000000724a21800, 0x00000007c0000000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```

- - - - - 
## ParallelGC的运行情况
### > 在100m的运行情况，运行了10次youngGC，然后直到内存溢出一直都是fullGC，与串行相比，并行GC的fullGC并不是内存快满才进行
```
java -XX:+UseParallelGC -Xms100m -Xmx100m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:44:58.429-0800: [GC (Allocation Failure) [PSYoungGen: 25514K->4082K(29696K)] 25514K->9675K(98304K), 0.0042028 secs] [Times: user=0.01 sys=0.02, real=0.01 secs]
2020-10-28T16:44:58.437-0800: [GC (Allocation Failure) [PSYoungGen: 29682K->4079K(29696K)] 35275K->19474K(98304K), 0.0047080 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T16:44:58.449-0800: [GC (Allocation Failure) [PSYoungGen: 29052K->4094K(29696K)] 44446K->27058K(98304K), 0.0032331 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T16:44:58.456-0800: [GC (Allocation Failure) [PSYoungGen: 29665K->4094K(29696K)] 52629K->35308K(98304K), 0.0038862 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T16:44:58.465-0800: [GC (Allocation Failure) [PSYoungGen: 29585K->4083K(29696K)] 60798K->44457K(98304K), 0.0043108 secs] [Times: user=0.02 sys=0.01, real=0.00 secs]
2020-10-28T16:44:58.472-0800: [GC (Allocation Failure) [PSYoungGen: 29683K->4095K(15360K)] 70057K->53978K(83968K), 0.0038276 secs] [Times: user=0.01 sys=0.02, real=0.00 secs]
2020-10-28T16:44:58.478-0800: [GC (Allocation Failure) [PSYoungGen: 15317K->4666K(22528K)] 65200K->56198K(91136K), 0.0011648 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.480-0800: [GC (Allocation Failure) [PSYoungGen: 15334K->8238K(22528K)] 66867K->60358K(91136K), 0.0012282 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.483-0800: [GC (Allocation Failure) [PSYoungGen: 19392K->10203K(22528K)] 71512K->64167K(91136K), 0.0016772 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.487-0800: [GC (Allocation Failure) [PSYoungGen: 20988K->6207K(22528K)] 74952K->66167K(91136K), 0.0028600 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T16:44:58.490-0800: [Full GC (Ergonomics) [PSYoungGen: 6207K->0K(22528K)] [ParOldGen: 59960K->59440K(68608K)] 66167K->59440K(91136K), [Metaspace: 2696K->2696K(1056768K)], 0.0072407 secs] [Times: user=0.03 sys=0.01, real=0.00 secs]
2020-10-28T16:44:58.500-0800: [Full GC (Ergonomics) [PSYoungGen: 11206K->0K(22528K)] [ParOldGen: 59440K->63267K(68608K)] 70646K->63267K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0076036 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.509-0800: [Full GC (Ergonomics) [PSYoungGen: 11249K->0K(22528K)] [ParOldGen: 63267K->66663K(68608K)] 74516K->66663K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0070891 secs] [Times: user=0.03 sys=0.01, real=0.01 secs]
2020-10-28T16:44:58.518-0800: [Full GC (Ergonomics) [PSYoungGen: 11101K->2198K(22528K)] [ParOldGen: 66663K->68064K(68608K)] 77765K->70262K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0043768 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-28T16:44:58.524-0800: [Full GC (Ergonomics) [PSYoungGen: 10747K->4718K(22528K)] [ParOldGen: 68064K->68200K(68608K)] 78811K->72918K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0094373 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]
2020-10-28T16:44:58.534-0800: [Full GC (Ergonomics) [PSYoungGen: 11102K->6816K(22528K)] [ParOldGen: 68200K->68007K(68608K)] 79302K->74824K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0047283 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.540-0800: [Full GC (Ergonomics) [PSYoungGen: 11131K->8779K(22528K)] [ParOldGen: 68007K->68436K(68608K)] 79139K->77215K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0070338 secs] [Times: user=0.04 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.547-0800: [Full GC (Ergonomics) [PSYoungGen: 11192K->9179K(22528K)] [ParOldGen: 68436K->68436K(68608K)] 79629K->77616K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0024744 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:44:58.550-0800: [Full GC (Ergonomics) [PSYoungGen: 11003K->9476K(22528K)] [ParOldGen: 68436K->68167K(68608K)] 79439K->77643K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0096920 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
2020-10-28T16:44:58.560-0800: [Full GC (Ergonomics) [PSYoungGen: 11121K->9699K(22528K)] [ParOldGen: 68167K->68167K(68608K)] 79288K->77866K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0024736 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.563-0800: [Full GC (Ergonomics) [PSYoungGen: 11201K->10015K(22528K)] [ParOldGen: 68167K->67908K(68608K)] 79368K->77923K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0044080 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.568-0800: [Full GC (Ergonomics) [PSYoungGen: 10903K->9371K(22528K)] [ParOldGen: 67908K->68518K(68608K)] 78812K->77889K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0049984 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-28T16:44:58.573-0800: [Full GC (Ergonomics) [PSYoungGen: 11226K->10245K(22528K)] [ParOldGen: 68518K->68518K(68608K)] 79745K->78763K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0013620 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.574-0800: [Full GC (Ergonomics) [PSYoungGen: 11203K->10648K(22528K)] [ParOldGen: 68518K->68476K(68608K)] 79722K->79125K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0063812 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
2020-10-28T16:44:58.581-0800: [Full GC (Ergonomics) [PSYoungGen: 11200K->10583K(22528K)] [ParOldGen: 68476K->68476K(68608K)] 79677K->79059K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0025221 secs] [Times: user=0.01 sys=0.01, real=0.00 secs]
2020-10-28T16:44:58.584-0800: [Full GC (Ergonomics) [PSYoungGen: 11259K->10438K(22528K)] [ParOldGen: 68476K->68476K(68608K)] 79735K->78915K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0018308 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.586-0800: [Full GC (Ergonomics) [PSYoungGen: 10973K->10438K(22528K)] [ParOldGen: 68476K->68476K(68608K)] 79450K->78915K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0017593 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.588-0800: [Full GC (Ergonomics) [PSYoungGen: 11170K->10775K(22528K)] [ParOldGen: 68476K->68476K(68608K)] 79647K->79251K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0025814 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:44:58.590-0800: [Full GC (Ergonomics) [PSYoungGen: 11243K->10775K(22528K)] [ParOldGen: 68476K->68476K(68608K)] 79720K->79251K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0024169 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.593-0800: [Full GC (Ergonomics) [PSYoungGen: 11175K->10981K(22528K)] [ParOldGen: 68476K->68125K(68608K)] 79652K->79107K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0070128 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
2020-10-28T16:44:58.600-0800: [Full GC (Ergonomics) [PSYoungGen: 11070K->10926K(22528K)] [ParOldGen: 68125K->68000K(68608K)] 79196K->78927K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0069761 secs] [Times: user=0.04 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.607-0800: [Full GC (Ergonomics) [PSYoungGen: 10990K->10924K(22528K)] [ParOldGen: 68434K->68434K(68608K)] 79424K->79358K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0018460 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:44:58.609-0800: [Full GC (Allocation Failure) [PSYoungGen: 10924K->10924K(22528K)] [ParOldGen: 68434K->68414K(68608K)] 79358K->79338K(91136K), [Metaspace: 2697K->2697K(1056768K)], 0.0066741 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:41)
	at GCLogAnalysis.main(GCLogAnalysis.java:24)
Heap
 PSYoungGen      total 22528K, used 11160K [0x00000007bdf00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 11264K, 99% used [0x00000007bdf00000,0x00000007be9e6150,0x00000007bea00000)
  from space 11264K, 0% used [0x00000007bf500000,0x00000007bf500000,0x00000007c0000000)
  to   space 11264K, 0% used [0x00000007bea00000,0x00000007bea00000,0x00000007bf500000)
 ParOldGen       total 68608K, used 68414K [0x00000007b9c00000, 0x00000007bdf00000, 0x00000007bdf00000)
  object space 68608K, 99% used [0x00000007b9c00000,0x00000007bdecfb90,0x00000007bdf00000)
 Metaspace       used 2727K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 298K, capacity 386K, committed 512K, reserved 1048576K
```
### > 在**512m**时候的情况 生成了8000多对象
```
java -XX:+UseParallelGC -Xms521m -Xmx521m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:47:18.033-0800: [GC (Allocation Failure) [PSYoungGen: 134144K->22008K(156160K)] 134144K->45320K(512512K), 0.0163984 secs] [Times: user=0.02 sys=0.06, real=0.01 secs]
2020-10-28T16:47:18.075-0800: [GC (Allocation Failure) [PSYoungGen: 156152K->22009K(156160K)] 179464K->93958K(512512K), 0.0246244 secs] [Times: user=0.03 sys=0.11, real=0.03 secs]
2020-10-28T16:47:18.116-0800: [GC (Allocation Failure) [PSYoungGen: 156153K->22015K(156160K)] 228102K->136127K(512512K), 0.0205955 secs] [Times: user=0.04 sys=0.06, real=0.02 secs]
2020-10-28T16:47:18.153-0800: [GC (Allocation Failure) [PSYoungGen: 156159K->22003K(156160K)] 270271K->180347K(512512K), 0.0205624 secs] [Times: user=0.04 sys=0.05, real=0.02 secs]
2020-10-28T16:47:18.193-0800: [GC (Allocation Failure) [PSYoungGen: 156147K->22014K(156160K)] 314491K->225022K(512512K), 0.0276383 secs] [Times: user=0.03 sys=0.06, real=0.03 secs]
2020-10-28T16:47:18.244-0800: [GC (Allocation Failure) [PSYoungGen: 156158K->22000K(81408K)] 359166K->264722K(437760K), 0.0213257 secs] [Times: user=0.04 sys=0.06, real=0.02 secs]
2020-10-28T16:47:18.276-0800: [GC (Allocation Failure) [PSYoungGen: 81100K->39519K(118784K)] 323823K->287704K(475136K), 0.0057742 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-28T16:47:18.292-0800: [GC (Allocation Failure) [PSYoungGen: 98911K->54217K(118784K)] 347096K->307248K(475136K), 0.0073276 secs] [Times: user=0.04 sys=0.01, real=0.00 secs]
2020-10-28T16:47:18.312-0800: [GC (Allocation Failure) [PSYoungGen: 113609K->59381K(118784K)] 366640K->329573K(475136K), 0.0160246 secs] [Times: user=0.06 sys=0.03, real=0.01 secs]
2020-10-28T16:47:18.339-0800: [GC (Allocation Failure) [PSYoungGen: 118773K->40620K(118784K)] 388965K->347089K(475136K), 0.0270011 secs] [Times: user=0.04 sys=0.05, real=0.03 secs]
2020-10-28T16:47:18.366-0800: [Full GC (Ergonomics) [PSYoungGen: 40620K->0K(118784K)] [ParOldGen: 306469K->242352K(356352K)] 347089K->242352K(475136K), [Metaspace: 2696K->2696K(1056768K)], 0.0397880 secs] [Times: user=0.15 sys=0.02, real=0.04 secs]
2020-10-28T16:47:18.417-0800: [GC (Allocation Failure) [PSYoungGen: 59392K->22570K(118784K)] 301744K->264923K(475136K), 0.0028516 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:47:18.430-0800: [GC (Allocation Failure) [PSYoungGen: 81862K->20132K(118784K)] 324215K->284305K(475136K), 0.0054230 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.446-0800: [GC (Allocation Failure) [PSYoungGen: 79256K->21019K(118784K)] 343429K->304016K(475136K), 0.0036594 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.459-0800: [GC (Allocation Failure) [PSYoungGen: 80411K->21802K(118784K)] 363408K->324235K(475136K), 0.0049423 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-28T16:47:18.474-0800: [GC (Allocation Failure) [PSYoungGen: 81109K->20349K(118784K)] 383541K->344048K(475136K), 0.0107549 secs] [Times: user=0.02 sys=0.03, real=0.01 secs]
2020-10-28T16:47:18.485-0800: [Full GC (Ergonomics) [PSYoungGen: 20349K->0K(118784K)] [ParOldGen: 323698K->277160K(356352K)] 344048K->277160K(475136K), [Metaspace: 2697K->2697K(1056768K)], 0.0407447 secs] [Times: user=0.20 sys=0.00, real=0.04 secs]
2020-10-28T16:47:18.540-0800: [GC (Allocation Failure) [PSYoungGen: 59186K->20334K(118784K)] 336347K->297495K(475136K), 0.0021527 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.553-0800: [GC (Allocation Failure) [PSYoungGen: 79726K->19121K(118784K)] 356887K->314776K(475136K), 0.0051605 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.570-0800: [GC (Allocation Failure) [PSYoungGen: 78513K->21194K(118784K)] 374168K->335549K(475136K), 0.0057051 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.576-0800: [Full GC (Ergonomics) [PSYoungGen: 21194K->0K(118784K)] [ParOldGen: 314355K->290038K(356352K)] 335549K->290038K(475136K), [Metaspace: 2697K->2697K(1056768K)], 0.0346032 secs] [Times: user=0.20 sys=0.01, real=0.04 secs]
2020-10-28T16:47:18.623-0800: [GC (Allocation Failure) [PSYoungGen: 59392K->21135K(118784K)] 349430K->311174K(475136K), 0.0039925 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.638-0800: [GC (Allocation Failure) [PSYoungGen: 80527K->19567K(118784K)] 370566K->329596K(475136K), 0.0051276 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-28T16:47:18.655-0800: [GC (Allocation Failure) [PSYoungGen: 78498K->20922K(118784K)] 388527K->349024K(475136K), 0.0066926 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-28T16:47:18.661-0800: [Full GC (Ergonomics) [PSYoungGen: 20922K->0K(118784K)] [ParOldGen: 328101K->300127K(356352K)] 349024K->300127K(475136K), [Metaspace: 2697K->2697K(1056768K)], 0.0366896 secs] [Times: user=0.18 sys=0.01, real=0.03 secs]
2020-10-28T16:47:18.711-0800: [GC (Allocation Failure) [PSYoungGen: 59336K->22071K(118784K)] 359464K->322198K(475136K), 0.0037371 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.726-0800: [GC (Allocation Failure) [PSYoungGen: 81224K->20785K(118784K)] 381351K->340393K(475136K), 0.0057211 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-28T16:47:18.743-0800: [GC (Allocation Failure) [PSYoungGen: 80113K->21881K(118784K)] 399721K->360388K(475136K), 0.0079920 secs] [Times: user=0.03 sys=0.02, real=0.01 secs]
2020-10-28T16:47:18.751-0800: [Full GC (Ergonomics) [PSYoungGen: 21881K->0K(118784K)] [ParOldGen: 338507K->313879K(356352K)] 360388K->313879K(475136K), [Metaspace: 2697K->2697K(1056768K)], 0.0398897 secs] [Times: user=0.21 sys=0.00, real=0.04 secs]
2020-10-28T16:47:18.806-0800: [GC (Allocation Failure) [PSYoungGen: 59354K->17308K(118784K)] 373234K->331188K(475136K), 0.0042389 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
2020-10-28T16:47:18.823-0800: [GC (Allocation Failure) [PSYoungGen: 76619K->22757K(118784K)] 390498K->352130K(475136K), 0.0056113 secs] [Times: user=0.03 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.828-0800: [Full GC (Ergonomics) [PSYoungGen: 22757K->0K(118784K)] [ParOldGen: 329373K->315994K(356352K)] 352130K->315994K(475136K), [Metaspace: 2697K->2697K(1056768K)], 0.0460039 secs] [Times: user=0.21 sys=0.00, real=0.05 secs]
2020-10-28T16:47:18.891-0800: [GC (Allocation Failure) [PSYoungGen: 58962K->24700K(118784K)] 374956K->340695K(475136K), 0.0035497 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T16:47:18.909-0800: [GC (Allocation Failure) [PSYoungGen: 83890K->22316K(118784K)] 399885K->361872K(475136K), 0.0079332 secs] [Times: user=0.04 sys=0.01, real=0.01 secs]
2020-10-28T16:47:18.917-0800: [Full GC (Ergonomics) [PSYoungGen: 22316K->0K(118784K)] [ParOldGen: 339556K->324778K(356352K)] 361872K->324778K(475136K), [Metaspace: 2697K->2697K(1056768K)], 0.0384504 secs] [Times: user=0.19 sys=0.00, real=0.04 secs]
执行结束!共生成对象次数:8037
Heap
 PSYoungGen      total 118784K, used 2649K [0x00000007b5200000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 59392K, 4% used [0x00000007b5200000,0x00000007b5496790,0x00000007b8c00000)
  from space 59392K, 0% used [0x00000007bc600000,0x00000007bc600000,0x00000007c0000000)
  to   space 59392K, 0% used [0x00000007b8c00000,0x00000007b8c00000,0x00000007bc600000)
 ParOldGen       total 356352K, used 324778K [0x000000079f600000, 0x00000007b5200000, 0x00000007b5200000)
  object space 356352K, 91% used [0x000000079f600000,0x00000007b332a9b0,0x00000007b5200000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```
### >在**1g**的情况下，两个GC次数明显变少，生成了10000对象，说明增大堆内存对gc的效率有所提升
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseParallelGC -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:48:51.084-0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43518K(305664K)] 262144K->83572K(1005056K), 0.0293177 secs] [Times: user=0.04 sys=0.13, real=0.03 secs]
2020-10-28T16:48:51.155-0800: [GC (Allocation Failure) [PSYoungGen: 305662K->43518K(305664K)] 345716K->155342K(1005056K), 0.0451206 secs] [Times: user=0.04 sys=0.14, real=0.05 secs]
2020-10-28T16:48:51.239-0800: [GC (Allocation Failure) [PSYoungGen: 305662K->43512K(305664K)] 417486K->221483K(1005056K), 0.0354678 secs] [Times: user=0.07 sys=0.08, real=0.04 secs]
2020-10-28T16:48:51.309-0800: [GC (Allocation Failure) [PSYoungGen: 305656K->43518K(305664K)] 483627K->291367K(1005056K), 0.0505021 secs] [Times: user=0.07 sys=0.08, real=0.05 secs]
2020-10-28T16:48:51.395-0800: [GC (Allocation Failure) [PSYoungGen: 305662K->43513K(305664K)] 553511K->367613K(1005056K), 0.0368523 secs] [Times: user=0.07 sys=0.12, real=0.04 secs]
2020-10-28T16:48:51.465-0800: [GC (Allocation Failure) [PSYoungGen: 305657K->43519K(160256K)] 629757K->440905K(859648K), 0.0429951 secs] [Times: user=0.07 sys=0.10, real=0.04 secs]
2020-10-28T16:48:51.528-0800: [GC (Allocation Failure) [PSYoungGen: 160095K->64216K(232960K)] 557481K->467216K(932352K), 0.0117649 secs] [Times: user=0.06 sys=0.01, real=0.01 secs]
2020-10-28T16:48:51.558-0800: [GC (Allocation Failure) [PSYoungGen: 180952K->87541K(232960K)] 583952K->500077K(932352K), 0.0165712 secs] [Times: user=0.07 sys=0.02, real=0.02 secs]
2020-10-28T16:48:51.594-0800: [GC (Allocation Failure) [PSYoungGen: 204237K->94967K(232960K)] 616774K->526648K(932352K), 0.0222409 secs] [Times: user=0.09 sys=0.03, real=0.02 secs]
2020-10-28T16:48:51.637-0800: [GC (Allocation Failure) [PSYoungGen: 211703K->65206K(232960K)] 643384K->554476K(932352K), 0.0477163 secs] [Times: user=0.05 sys=0.06, real=0.05 secs]
2020-10-28T16:48:51.701-0800: [GC (Allocation Failure) [PSYoungGen: 181826K->42386K(232960K)] 671096K->589712K(932352K), 0.0606031 secs] [Times: user=0.06 sys=0.06, real=0.06 secs]
2020-10-28T16:48:51.780-0800: [GC (Allocation Failure) [PSYoungGen: 159122K->38298K(232960K)] 706448K->623211K(932352K), 0.0188282 secs] [Times: user=0.04 sys=0.06, real=0.01 secs]
2020-10-28T16:48:51.815-0800: [GC (Allocation Failure) [PSYoungGen: 155034K->43694K(232960K)] 739947K->663935K(932352K), 0.0164769 secs] [Times: user=0.04 sys=0.04, real=0.02 secs]
2020-10-28T16:48:51.831-0800: [Full GC (Ergonomics) [PSYoungGen: 43694K->0K(232960K)] [ParOldGen: 620240K->328248K(699392K)] 663935K->328248K(932352K), [Metaspace: 2696K->2696K(1056768K)], 0.0531215 secs] [Times: user=0.25 sys=0.01, real=0.05 secs]
2020-10-28T16:48:51.906-0800: [GC (Allocation Failure) [PSYoungGen: 116736K->41772K(232960K)] 444984K->370020K(932352K), 0.0052502 secs] [Times: user=0.03 sys=0.00, real=0.01 secs]
2020-10-28T16:48:51.927-0800: [GC (Allocation Failure) [PSYoungGen: 158508K->41668K(232960K)] 486756K->406960K(932352K), 0.0100713 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
执行结束!共生成对象次数:10257
Heap
 PSYoungGen      total 232960K, used 141329K [0x00000007aab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 116736K, 85% used [0x00000007aab00000,0x00000007b0c53210,0x00000007b1d00000)
  from space 116224K, 35% used [0x00000007b1d00000,0x00000007b45b1248,0x00000007b8e80000)
  to   space 116224K, 0% used [0x00000007b8e80000,0x00000007b8e80000,0x00000007c0000000)
 ParOldGen       total 699392K, used 365291K [0x0000000780000000, 0x00000007aab00000, 0x00000007aab00000)
  object space 699392K, 52% used [0x0000000780000000,0x00000007964baea8,0x00000007aab00000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```
### > 在**4g**的情况下，只进行了两次youngGC，生成了9000多对象，说明内存对GC的提升也存在一个阈值，超过这个值，无脑加大GC，没有意义
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseParallelGC -Xms4g -Xmx4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:50:28.803-0800: [GC (Allocation Failure) [PSYoungGen: 1048576K->174585K(1223168K)] 1048576K->234517K(4019712K), 0.1162244 secs] [Times: user=0.10 sys=0.32, real=0.12 secs]
2020-10-28T16:50:29.080-0800: [GC (Allocation Failure) [PSYoungGen: 1223161K->174585K(1223168K)] 1283093K->370791K(4019712K), 0.1989326 secs] [Times: user=0.14 sys=0.39, real=0.19 secs]
执行结束!共生成对象次数:9099
Heap
 PSYoungGen      total 1223168K, used 489911K [0x000000076ab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 1048576K, 30% used [0x000000076ab00000,0x000000077deef788,0x00000007aab00000)
  from space 174592K, 99% used [0x00000007b5580000,0x00000007bfffe5b8,0x00000007c0000000)
  to   space 174592K, 0% used [0x00000007aab00000,0x00000007aab00000,0x00000007b5580000)
 ParOldGen       total 2796544K, used 196206K [0x00000006c0000000, 0x000000076ab00000, 0x000000076ab00000)
  object space 2796544K, 7% used [0x00000006c0000000,0x00000006cbf9b860,0x000000076ab00000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```
- - - - - 
## ConcMarkSweepGC
### > 在100兆的时候 ，内存溢出，可以看出，CMS的fullGC策略和并行GC一样，并不是当内存满了才进行fullGC
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseConcMarkSweepGC -Xms100m -Xmx100m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:52:29.297-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.297-0800: [ParNew: 27205K->3392K(30720K), 0.0030731 secs] 27205K->9088K(99008K), 0.0031172 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T16:52:29.305-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.305-0800: [ParNew: 30590K->3391K(30720K), 0.0048590 secs] 36286K->19906K(99008K), 0.0048945 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T16:52:29.315-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.315-0800: [ParNew: 30466K->3377K(30720K), 0.0050775 secs] 46981K->29058K(99008K), 0.0051095 secs] [Times: user=0.03 sys=0.01, real=0.01 secs]
2020-10-28T16:52:29.324-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.324-0800: [ParNew: 30436K->3387K(30720K), 0.0056473 secs] 56117K->39636K(99008K), 0.0056783 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.330-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 36249K(68288K)] 40215K(99008K), 0.0001405 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.330-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.331-0800: [CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.331-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:52:29.331-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.331-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:52:29.334-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.334-0800: [ParNew: 30684K->3390K(30720K), 0.0040833 secs] 66933K->47295K(99008K), 0.0041102 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.341-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.341-0800: [ParNew: 30586K->3390K(30720K), 0.0049719 secs] 74491K->55433K(99008K), 0.0050073 secs] [Times: user=0.03 sys=0.01, real=0.00 secs]
2020-10-28T16:52:29.349-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.349-0800: [ParNew: 30231K->3385K(30720K), 0.0056003 secs] 82275K->65196K(99008K), 0.0056296 secs] [Times: user=0.04 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.358-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.358-0800: [ParNew: 30713K->30713K(30720K), 0.0000155 secs]2020-10-28T16:52:29.358-0800: [CMS2020-10-28T16:52:29.358-0800: [CMS-concurrent-abortable-preclean: 0.001/0.027 secs] [Times: user=0.11 sys=0.01, real=0.02 secs]
 (concurrent mode failure): 61810K->68107K(68288K), 0.0137882 secs] 92524K->69622K(99008K), [Metaspace: 2696K->2696K(1056768K)], 0.0138462 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
2020-10-28T16:52:29.375-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.375-0800: [CMS: 68107K->68136K(68288K), 0.0094718 secs] 98277K->78289K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0095125 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.385-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68136K(68288K)] 78955K(99008K), 0.0001439 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.385-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.386-0800: [CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.386-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:52:29.386-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.386-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:52:29.386-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.386-0800: [GC (CMS Final Remark) [YG occupancy: 16915 K (30720 K)]2020-10-28T16:52:29.386-0800: [Rescan (parallel) , 0.0008519 secs]2020-10-28T16:52:29.387-0800: [weak refs processing, 0.0000156 secs]2020-10-28T16:52:29.387-0800: [class unloading, 0.0002746 secs]2020-10-28T16:52:29.387-0800: [scrub symbol table, 0.0003524 secs]2020-10-28T16:52:29.388-0800: [scrub string table, 0.0002133 secs][1 CMS-remark: 68136K(68288K)] 85052K(99008K), 0.0017748 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.388-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:52:29.388-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.388-0800: [CMS-concurrent-reset-start]
2020-10-28T16:52:29.388-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.391-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.391-0800: [ParNew: 30618K->30618K(30720K), 0.0000189 secs]2020-10-28T16:52:29.391-0800: [CMS: 68136K->67905K(68288K), 0.0093239 secs] 98755K->82937K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0093888 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.401-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 67905K(68288K)] 83100K(99008K), 0.0001564 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.401-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.402-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.402-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:52:29.402-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.402-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:52:29.402-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.402-0800: [GC (CMS Final Remark) [YG occupancy: 20461 K (30720 K)]2020-10-28T16:52:29.402-0800: [Rescan (parallel) , 0.0006071 secs]2020-10-28T16:52:29.403-0800: [weak refs processing, 0.0000114 secs]2020-10-28T16:52:29.403-0800: [class unloading, 0.0002473 secs]2020-10-28T16:52:29.403-0800: [scrub symbol table, 0.0003205 secs]2020-10-28T16:52:29.403-0800: [scrub string table, 0.0001855 secs][1 CMS-remark: 67905K(68288K)] 88366K(99008K), 0.0014204 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.404-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:52:29.404-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.404-0800: [CMS-concurrent-reset-start]
2020-10-28T16:52:29.404-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.406-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.406-0800: [ParNew: 30665K->30665K(30720K), 0.0000195 secs]2020-10-28T16:52:29.406-0800: [CMS: 66996K->68267K(68288K), 0.0095465 secs] 97661K->86366K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0096064 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.415-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68267K(68288K)] 86427K(99008K), 0.0001580 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.416-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.416-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.416-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:52:29.417-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.417-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:52:29.417-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.417-0800: [GC (CMS Final Remark) [YG occupancy: 23513 K (30720 K)]2020-10-28T16:52:29.417-0800: [Rescan (parallel) , 0.0009473 secs]2020-10-28T16:52:29.418-0800: [weak refs processing, 0.0000156 secs]2020-10-28T16:52:29.418-0800: [class unloading, 0.0003102 secs]2020-10-28T16:52:29.418-0800: [scrub symbol table, 0.0003862 secs]2020-10-28T16:52:29.419-0800: [scrub string table, 0.0002026 secs][1 CMS-remark: 68267K(68288K)] 91780K(99008K), 0.0019414 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.419-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:52:29.419-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.419-0800: [CMS-concurrent-reset-start]
2020-10-28T16:52:29.419-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.421-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.421-0800: [ParNew: 30462K->30462K(30720K), 0.0000184 secs]2020-10-28T16:52:29.421-0800: [CMS: 68267K->68198K(68288K), 0.0131314 secs] 98729K->88197K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0131924 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.434-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68198K(68288K)] 88908K(99008K), 0.0001751 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.434-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.435-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.435-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:52:29.435-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.435-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:52:29.435-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.436-0800: [GC (CMS Final Remark) [YG occupancy: 26508 K (30720 K)]2020-10-28T16:52:29.436-0800: [Rescan (parallel) , 0.0001801 secs]2020-10-28T16:52:29.436-0800: [weak refs processing, 0.0000129 secs]2020-10-28T16:52:29.436-0800: [class unloading, 0.0002066 secs]2020-10-28T16:52:29.436-0800: [scrub symbol table, 0.0003371 secs]2020-10-28T16:52:29.436-0800: [scrub string table, 0.0001987 secs][1 CMS-remark: 68198K(68288K)] 94706K(99008K), 0.0009879 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.437-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:52:29.437-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.437-0800: [CMS-concurrent-reset-start]
2020-10-28T16:52:29.437-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.437-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.437-0800: [ParNew: 30235K->30235K(30720K), 0.0000228 secs]2020-10-28T16:52:29.437-0800: [CMS: 68198K->68201K(68288K), 0.0104257 secs] 98433K->92439K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0104956 secs] [Times: user=0.01 sys=0.01, real=0.01 secs]
2020-10-28T16:52:29.448-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68201K(68288K)] 93100K(99008K), 0.0001824 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.448-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.449-0800: [CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.449-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:52:29.449-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.449-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:52:29.449-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.449-0800: [GC (CMS Final Remark) [YG occupancy: 30048 K (30720 K)]2020-10-28T16:52:29.449-0800: [Rescan (parallel) , 0.0001861 secs]2020-10-28T16:52:29.450-0800: [weak refs processing, 0.0000124 secs]2020-10-28T16:52:29.450-0800: [class unloading, 0.0001970 secs]2020-10-28T16:52:29.450-0800: [scrub symbol table, 0.0003095 secs]2020-10-28T16:52:29.450-0800: [scrub string table, 0.0001985 secs][1 CMS-remark: 68201K(68288K)] 98249K(99008K), 0.0009546 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.450-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:52:29.451-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.451-0800: [CMS-concurrent-reset-start]
2020-10-28T16:52:29.451-0800: [GC (Allocation Failure) 2020-10-28T16:52:29.451-0800: [ParNew: 30692K->30692K(30720K), 0.0000170 secs]2020-10-28T16:52:29.451-0800: [CMS2020-10-28T16:52:29.451-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
: 68201K->68176K(68288K), 0.0063511 secs] 98894K->93916K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0064042 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.458-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.458-0800: [CMS: 68176K->67800K(68288K), 0.0059204 secs] 98499K->94363K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0059593 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.464-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 67800K(68288K)] 95090K(99008K), 0.0001542 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.464-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.465-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.465-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:52:29.465-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.465-0800: [CMS2020-10-28T16:52:29.466-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 68194K->67811K(68288K), 0.0049104 secs] 98875K->95404K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0049435 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.471-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.471-0800: [CMS: 67811K->68277K(68288K), 0.0110639 secs] 97935K->96130K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0111043 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.482-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68277K(68288K)] 96822K(99008K), 0.0001752 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.482-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.483-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.483-0800: [CMS2020-10-28T16:52:29.484-0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 68277K->68277K(68288K), 0.0032105 secs] 98822K->96160K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0032445 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.486-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.486-0800: [CMS: 68277K->68252K(68288K), 0.0040752 secs] 98722K->96796K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0041375 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.491-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68252K(68288K)] 97392K(99008K), 0.0001833 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.491-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.491-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.491-0800: [CMS2020-10-28T16:52:29.492-0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 68252K->68252K(68288K), 0.0029354 secs] 98783K->97459K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0029683 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.495-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.495-0800: [CMS: 68252K->68215K(68288K), 0.0112987 secs] 98762K->98003K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0113407 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.506-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68215K(68288K)] 98438K(99008K), 0.0002268 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.506-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.507-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.507-0800: [CMS2020-10-28T16:52:29.508-0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 68215K->68215K(68288K), 0.0034518 secs] 98833K->98582K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0034845 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.510-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.510-0800: [CMS: 68215K->68215K(68288K), 0.0018409 secs] 98897K->98726K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0018773 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.512-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.512-0800: [CMS: 68215K->68285K(68288K), 0.0100485 secs] 98726K->98707K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0100857 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:52:29.523-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68285K(68288K)] 98951K(99008K), 0.0001811 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.523-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.523-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.523-0800: [CMS2020-10-28T16:52:29.525-0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
 (concurrent mode failure): 68285K->68285K(68288K), 0.0037978 secs] 98951K->98437K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0038502 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.527-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.527-0800: [CMS: 68285K->68285K(68288K), 0.0017687 secs] 98991K->98707K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0018163 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.529-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68285K(68288K)] 98889K(99008K), 0.0002577 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.529-0800: [CMS-concurrent-mark-start]
2020-10-28T16:52:29.530-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.530-0800: [CMS2020-10-28T16:52:29.531-0800: [CMS-concurrent-mark: 0.001/0.002 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 68285K->68285K(68288K), 0.0032001 secs] 98968K->98637K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0032322 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.533-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.533-0800: [CMS: 68285K->68285K(68288K), 0.0020551 secs] 98838K->98624K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0020865 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.535-0800: [Full GC (Allocation Failure) 2020-10-28T16:52:29.535-0800: [CMS: 68285K->68285K(68288K), 0.0013652 secs] 98624K->98624K(99008K), [Metaspace: 2697K->2697K(1056768K)], 0.0013925 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.537-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 68285K(68288K)] 98624K(99008K), 0.0001921 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.537-0800: [CMS-concurrent-mark-start]
Exception in thread "main" 2020-10-28T16:52:29.537-0800: [CMS-concurrent-mark: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.537-0800: [CMS-concurrent-preclean-start]
java.lang.OutOfMemoryError: Java heap space
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:41)
	at GCLogAnalysis.main(GCLogAnalysis.java:24)
2020-10-28T16:52:29.538-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.538-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:52:29.538-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.538-0800: [GC (CMS Final Remark) [YG occupancy: 30460 K (30720 K)]2020-10-28T16:52:29.538-0800: [Rescan (parallel) , 0.0002430 secs]2020-10-28T16:52:29.538-0800: [weak refs processing, 0.0000115 secs]2020-10-28T16:52:29.538-0800: [class unloading, 0.0001634 secs]2020-10-28T16:52:29.538-0800: [scrub symbol table, 0.0002479 secs]2020-10-28T16:52:29.539-0800: [scrub string table, 0.0001987 secs][1 CMS-remark: 68285K(68288K)] 98746K(99008K), 0.0009238 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:52:29.539-0800: [CMS-concurrent-sweep-start]
Heap
 par new generation   total 30720K, used 30460K [0x00000007b9c00000, 0x00000007bbd50000, 0x00000007bbd50000)
  eden space 27328K, 100% used [0x00000007b9c00000, 0x00000007bb6b0000, 0x00000007bb6b0000)
  from space 3392K,  92% used [0x00000007bba00000, 0x00000007bbd0f2b8, 0x00000007bbd50000)
  to   space 3392K,   0% used [0x00000007bb6b0000, 0x00000007bb6b0000, 0x00000007bba00000)
 concurrent mark-sweep generation total 68288K, used 68285K [0x00000007bbd50000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2727K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 298K, capacity 386K, committed 512K, reserved 1048576K
```
### > **512g**  的时候，生成9428个对象
```
(base)  ✘ yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:55:37.543-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.543-0800: [ParNew: 139776K->17471K(157248K), 0.0458118 secs] 139776K->52428K(506816K), 0.0459142 secs] [Times: user=0.03 sys=0.05, real=0.04 secs]
2020-10-28T16:55:37.616-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.616-0800: [ParNew: 157247K->17472K(157248K), 0.0310491 secs] 192204K->90922K(506816K), 0.0310863 secs] [Times: user=0.03 sys=0.05, real=0.03 secs]
2020-10-28T16:55:37.668-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.668-0800: [ParNew: 157203K->17467K(157248K), 0.0269689 secs] 230653K->137524K(506816K), 0.0270891 secs] [Times: user=0.17 sys=0.01, real=0.03 secs]
2020-10-28T16:55:37.714-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.714-0800: [ParNew: 157243K->17472K(157248K), 0.0266996 secs] 277300K->179824K(506816K), 0.0267833 secs] [Times: user=0.14 sys=0.02, real=0.03 secs]
2020-10-28T16:55:37.760-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.760-0800: [ParNew: 156842K->17469K(157248K), 0.0304570 secs] 319195K->220448K(506816K), 0.0304963 secs] [Times: user=0.15 sys=0.01, real=0.03 secs]
2020-10-28T16:55:37.791-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 202979K(349568K)] 220908K(506816K), 0.0002845 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:37.791-0800: [CMS-concurrent-mark-start]
2020-10-28T16:55:37.793-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:37.793-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:55:37.793-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:37.793-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:55:37.809-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.809-0800: [ParNew: 156818K->17471K(157248K), 0.0284342 secs] 359798K->261131K(506816K), 0.0284738 secs] [Times: user=0.13 sys=0.02, real=0.03 secs]
2020-10-28T16:55:37.857-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.857-0800: [ParNew: 157247K->17470K(157248K), 0.0371368 secs] 400907K->314795K(506816K), 0.0371918 secs] [Times: user=0.17 sys=0.02, real=0.04 secs]
2020-10-28T16:55:37.911-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.911-0800: [ParNew: 157197K->157197K(157248K), 0.0000194 secs]2020-10-28T16:55:37.911-0800: [CMS2020-10-28T16:55:37.911-0800: [CMS-concurrent-abortable-preclean: 0.003/0.117 secs] [Times: user=0.35 sys=0.04, real=0.12 secs]
 (concurrent mode failure): 297325K->253427K(349568K), 0.0597715 secs] 454523K->253427K(506816K), [Metaspace: 2696K->2696K(1056768K)], 0.0598415 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-28T16:55:37.993-0800: [GC (Allocation Failure) 2020-10-28T16:55:37.993-0800: [ParNew: 139776K->17470K(157248K), 0.0072154 secs] 393203K->301937K(506816K), 0.0072570 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]
2020-10-28T16:55:38.000-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 284466K(349568K)] 302638K(506816K), 0.0001628 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.000-0800: [CMS-concurrent-mark-start]
2020-10-28T16:55:38.001-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.001-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:55:38.002-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.002-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:55:38.020-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.020-0800: [ParNew: 157246K->17471K(157248K), 0.0216154 secs] 441713K->343510K(506816K), 0.0216675 secs] [Times: user=0.13 sys=0.01, real=0.02 secs]
2020-10-28T16:55:38.043-0800: [CMS-concurrent-abortable-preclean: 0.001/0.041 secs] [Times: user=0.15 sys=0.01, real=0.04 secs]
2020-10-28T16:55:38.043-0800: [GC (CMS Final Remark) [YG occupancy: 24329 K (157248 K)]2020-10-28T16:55:38.043-0800: [Rescan (parallel) , 0.0008268 secs]2020-10-28T16:55:38.044-0800: [weak refs processing, 0.0000124 secs]2020-10-28T16:55:38.044-0800: [class unloading, 0.0002826 secs]2020-10-28T16:55:38.044-0800: [scrub symbol table, 0.0004196 secs]2020-10-28T16:55:38.044-0800: [scrub string table, 0.0001479 secs][1 CMS-remark: 326038K(349568K)] 350367K(506816K), 0.0017620 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.045-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:55:38.045-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.045-0800: [CMS-concurrent-reset-start]
2020-10-28T16:55:38.046-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.063-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.063-0800: [ParNew: 157247K->17470K(157248K), 0.0190422 secs] 449899K->358561K(506816K), 0.0190802 secs] [Times: user=0.10 sys=0.01, real=0.02 secs]
2020-10-28T16:55:38.082-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 341090K(349568K)] 358705K(506816K), 0.0001628 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.082-0800: [CMS-concurrent-mark-start]
2020-10-28T16:55:38.084-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.084-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:55:38.084-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.084-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:55:38.084-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.084-0800: [GC (CMS Final Remark) [YG occupancy: 33499 K (157248 K)]2020-10-28T16:55:38.084-0800: [Rescan (parallel) , 0.0008665 secs]2020-10-28T16:55:38.085-0800: [weak refs processing, 0.0000131 secs]2020-10-28T16:55:38.085-0800: [class unloading, 0.0001951 secs]2020-10-28T16:55:38.085-0800: [scrub symbol table, 0.0002884 secs]2020-10-28T16:55:38.086-0800: [scrub string table, 0.0001442 secs][1 CMS-remark: 341090K(349568K)] 374590K(506816K), 0.0015501 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.086-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:55:38.086-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.086-0800: [CMS-concurrent-reset-start]
2020-10-28T16:55:38.087-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.102-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.102-0800: [ParNew: 157246K->17471K(157248K), 0.0083140 secs] 434179K->335492K(506816K), 0.0083586 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]
2020-10-28T16:55:38.110-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 318020K(349568K)] 335754K(506816K), 0.0001462 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.110-0800: [CMS-concurrent-mark-start]
2020-10-28T16:55:38.113-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.113-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:55:38.113-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.113-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:55:38.113-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.113-0800: [GC (CMS Final Remark) [YG occupancy: 34935 K (157248 K)]2020-10-28T16:55:38.113-0800: [Rescan (parallel) , 0.0002782 secs]2020-10-28T16:55:38.113-0800: [weak refs processing, 0.0000126 secs]2020-10-28T16:55:38.113-0800: [class unloading, 0.0002348 secs]2020-10-28T16:55:38.114-0800: [scrub symbol table, 0.0003205 secs]2020-10-28T16:55:38.114-0800: [scrub string table, 0.0001458 secs][1 CMS-remark: 318020K(349568K)] 352956K(506816K), 0.0010417 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.114-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:55:38.115-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.115-0800: [CMS-concurrent-reset-start]
2020-10-28T16:55:38.115-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.129-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.129-0800: [ParNew: 157247K->17471K(157248K), 0.0103968 secs] 437947K->340296K(506816K), 0.0104318 secs] [Times: user=0.06 sys=0.00, real=0.01 secs]
2020-10-28T16:55:38.139-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 322825K(349568K)] 340440K(506816K), 0.0001175 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.139-0800: [CMS-concurrent-mark-start]
2020-10-28T16:55:38.141-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:55:38.141-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:55:38.141-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.141-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:55:38.141-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.141-0800: [GC (CMS Final Remark) [YG occupancy: 31073 K (157248 K)]2020-10-28T16:55:38.141-0800: [Rescan (parallel) , 0.0007775 secs]2020-10-28T16:55:38.142-0800: [weak refs processing, 0.0000091 secs]2020-10-28T16:55:38.142-0800: [class unloading, 0.0002351 secs]2020-10-28T16:55:38.142-0800: [scrub symbol table, 0.0003052 secs]2020-10-28T16:55:38.143-0800: [scrub string table, 0.0001469 secs][1 CMS-remark: 322825K(349568K)] 353899K(506816K), 0.0015163 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.143-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:55:38.143-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.143-0800: [CMS-concurrent-reset-start]
2020-10-28T16:55:38.144-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.158-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.158-0800: [ParNew: 157247K->17471K(157248K), 0.0111037 secs] 444285K->348380K(506816K), 0.0111379 secs] [Times: user=0.07 sys=0.00, real=0.02 secs]
2020-10-28T16:55:38.170-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 330908K(349568K)] 348668K(506816K), 0.0001229 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.170-0800: [CMS-concurrent-mark-start]
2020-10-28T16:55:38.171-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.171-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:55:38.171-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.171-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:55:38.171-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.172-0800: [GC (CMS Final Remark) [YG occupancy: 32812 K (157248 K)]2020-10-28T16:55:38.172-0800: [Rescan (parallel) , 0.0008762 secs]2020-10-28T16:55:38.172-0800: [weak refs processing, 0.0000102 secs]2020-10-28T16:55:38.172-0800: [class unloading, 0.0002407 secs]2020-10-28T16:55:38.173-0800: [scrub symbol table, 0.0003319 secs]2020-10-28T16:55:38.173-0800: [scrub string table, 0.0001432 secs][1 CMS-remark: 330908K(349568K)] 363721K(506816K), 0.0016662 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.173-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:55:38.174-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.174-0800: [CMS-concurrent-reset-start]
2020-10-28T16:55:38.174-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.189-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.189-0800: [ParNew (promotion failed): 157243K->157243K(157248K), 0.0120955 secs]2020-10-28T16:55:38.201-0800: [CMS: 345710K->328398K(349568K), 0.0562666 secs] 458929K->328398K(506816K), [Metaspace: 2697K->2697K(1056768K)], 0.0684395 secs] [Times: user=0.14 sys=0.01, real=0.07 secs]
2020-10-28T16:55:38.258-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 328398K(349568K)] 328406K(506816K), 0.0002054 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.258-0800: [CMS-concurrent-mark-start]
2020-10-28T16:55:38.259-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.259-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:55:38.260-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
2020-10-28T16:55:38.260-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:55:38.279-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.279-0800: [ParNew: 139776K->139776K(157248K), 0.0000258 secs]2020-10-28T16:55:38.279-0800: [CMS2020-10-28T16:55:38.279-0800: [CMS-concurrent-abortable-preclean: 0.001/0.019 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
 (concurrent mode failure): 328398K->337423K(349568K), 0.0587033 secs] 468174K->337423K(506816K), [Metaspace: 2697K->2697K(1056768K)], 0.0587830 secs] [Times: user=0.06 sys=0.00, real=0.06 secs]
2020-10-28T16:55:38.360-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.360-0800: [ParNew: 139776K->139776K(157248K), 0.0000211 secs]2020-10-28T16:55:38.360-0800: [CMS: 337423K->342967K(349568K), 0.0516786 secs] 477199K->342967K(506816K), [Metaspace: 2697K->2697K(1056768K)], 0.0517527 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2020-10-28T16:55:38.412-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 342967K(349568K)] 346135K(506816K), 0.0002604 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.413-0800: [CMS-concurrent-mark-start]
2020-10-28T16:55:38.415-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.415-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:55:38.415-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.415-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:55:38.415-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.416-0800: [GC (CMS Final Remark) [YG occupancy: 12884 K (157248 K)]2020-10-28T16:55:38.416-0800: [Rescan (parallel) , 0.0014484 secs]2020-10-28T16:55:38.417-0800: [weak refs processing, 0.0000189 secs]2020-10-28T16:55:38.417-0800: [class unloading, 0.0005438 secs]2020-10-28T16:55:38.418-0800: [scrub symbol table, 0.0005547 secs]2020-10-28T16:55:38.418-0800: [scrub string table, 0.0002579 secs][1 CMS-remark: 342967K(349568K)] 355852K(506816K), 0.0029352 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.419-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:55:38.419-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.419-0800: [CMS-concurrent-reset-start]
2020-10-28T16:55:38.420-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:55:38.441-0800: [GC (Allocation Failure) 2020-10-28T16:55:38.441-0800: [ParNew: 139776K->139776K(157248K), 0.0000208 secs]2020-10-28T16:55:38.441-0800: [CMS: 342067K->346716K(349568K), 0.0542877 secs] 481843K->346716K(506816K), [Metaspace: 2697K->2697K(1056768K)], 0.0543623 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
2020-10-28T16:55:38.495-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 346716K(349568K)] 347022K(506816K), 0.0001904 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:55:38.495-0800: [CMS-concurrent-mark-start]
执行结束!共生成对象次数:9428
Heap
 par new generation   total 157248K, used 5868K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,   4% used [0x00000007a0000000, 0x00000007a05bb368, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
 concurrent mark-sweep generation total 349568K, used 346716K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```
### > **1g** 的情况下，GC的次数明显变少，生成了12656个对象，看来加大内存，程序的效率明显提升
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseConcMarkSweepGC -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:56:42.733-0800: [GC (Allocation Failure) 2020-10-28T16:56:42.733-0800: [ParNew: 279616K->34944K(314560K), 0.0302953 secs] 279616K->86369K(1013632K), 0.0303413 secs] [Times: user=0.05 sys=0.15, real=0.03 secs]
2020-10-28T16:56:42.804-0800: [GC (Allocation Failure) 2020-10-28T16:56:42.804-0800: [ParNew: 314560K->34944K(314560K), 0.0308199 secs] 365985K->157860K(1013632K), 0.0308576 secs] [Times: user=0.06 sys=0.13, real=0.03 secs]
2020-10-28T16:56:42.867-0800: [GC (Allocation Failure) 2020-10-28T16:56:42.867-0800: [ParNew: 314560K->34943K(314560K), 0.0461551 secs] 437476K->237191K(1013632K), 0.0461906 secs] [Times: user=0.29 sys=0.03, real=0.05 secs]
2020-10-28T16:56:42.947-0800: [GC (Allocation Failure) 2020-10-28T16:56:42.947-0800: [ParNew: 314441K->34944K(314560K), 0.0464188 secs] 516689K->316934K(1013632K), 0.0464534 secs] [Times: user=0.30 sys=0.02, real=0.05 secs]
2020-10-28T16:56:43.026-0800: [GC (Allocation Failure) 2020-10-28T16:56:43.026-0800: [ParNew: 314560K->34943K(314560K), 0.0514112 secs] 596550K->390722K(1013632K), 0.0514511 secs] [Times: user=0.25 sys=0.03, real=0.05 secs]
2020-10-28T16:56:43.078-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 355778K(699072K)] 391074K(1013632K), 0.0002560 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:56:43.078-0800: [CMS-concurrent-mark-start]
2020-10-28T16:56:43.081-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:56:43.081-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:56:43.082-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:56:43.082-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:56:43.113-0800: [GC (Allocation Failure) 2020-10-28T16:56:43.113-0800: [ParNew: 314559K->34941K(314560K), 0.0466387 secs] 670338K->470218K(1013632K), 0.0466737 secs] [Times: user=0.29 sys=0.03, real=0.05 secs]
2020-10-28T16:56:43.194-0800: [GC (Allocation Failure) 2020-10-28T16:56:43.194-0800: [ParNew: 314557K->34943K(314560K), 0.0436758 secs] 749834K->543101K(1013632K), 0.0437168 secs] [Times: user=0.28 sys=0.02, real=0.04 secs]
2020-10-28T16:56:43.272-0800: [GC (Allocation Failure) 2020-10-28T16:56:43.272-0800: [ParNew: 314559K->34943K(314560K), 0.0443758 secs] 822717K->620024K(1013632K), 0.0444116 secs] [Times: user=0.28 sys=0.03, real=0.04 secs]
2020-10-28T16:56:43.352-0800: [GC (Allocation Failure) 2020-10-28T16:56:43.352-0800: [ParNew: 314559K->34943K(314560K), 0.0461398 secs] 899640K->695324K(1013632K), 0.0461771 secs] [Times: user=0.26 sys=0.02, real=0.04 secs]
2020-10-28T16:56:43.399-0800: [CMS-concurrent-abortable-preclean: 0.009/0.317 secs] [Times: user=1.25 sys=0.10, real=0.31 secs]
2020-10-28T16:56:43.399-0800: [GC (CMS Final Remark) [YG occupancy: 47848 K (314560 K)]2020-10-28T16:56:43.399-0800: [Rescan (parallel) , 0.0010294 secs]2020-10-28T16:56:43.400-0800: [weak refs processing, 0.0000243 secs]2020-10-28T16:56:43.400-0800: [class unloading, 0.0002284 secs]2020-10-28T16:56:43.400-0800: [scrub symbol table, 0.0002706 secs]2020-10-28T16:56:43.401-0800: [scrub string table, 0.0001438 secs][1 CMS-remark: 660381K(699072K)] 708230K(1013632K), 0.0017576 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
2020-10-28T16:56:43.401-0800: [CMS-concurrent-sweep-start]
2020-10-28T16:56:43.402-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:56:43.402-0800: [CMS-concurrent-reset-start]
2020-10-28T16:56:43.404-0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:56:43.432-0800: [GC (Allocation Failure) 2020-10-28T16:56:43.432-0800: [ParNew: 314559K->34942K(314560K), 0.0198216 secs] 846397K->649995K(1013632K), 0.0198559 secs] [Times: user=0.13 sys=0.00, real=0.02 secs]
2020-10-28T16:56:43.452-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 615053K(699072K)] 650139K(1013632K), 0.0001005 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:56:43.452-0800: [CMS-concurrent-mark-start]
2020-10-28T16:56:43.454-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
2020-10-28T16:56:43.454-0800: [CMS-concurrent-preclean-start]
2020-10-28T16:56:43.454-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
2020-10-28T16:56:43.455-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-28T16:56:43.484-0800: [GC (Allocation Failure) 2020-10-28T16:56:43.484-0800: [ParNew: 314558K->314558K(314560K), 0.0000312 secs]2020-10-28T16:56:43.484-0800: [CMS2020-10-28T16:56:43.484-0800: [CMS-concurrent-abortable-preclean: 0.001/0.030 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
 (concurrent mode failure): 615053K->337715K(699072K), 0.0755863 secs] 929611K->337715K(1013632K), [Metaspace: 2697K->2697K(1056768K)], 0.0756975 secs] [Times: user=0.07 sys=0.00, real=0.08 secs]
执行结束!共生成对象次数:12656
Heap
 par new generation   total 314560K, used 258520K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)
  eden space 279616K,  92% used [0x0000000780000000, 0x000000078fc76168, 0x0000000791110000)
  from space 34944K,   0% used [0x0000000791110000, 0x0000000791110000, 0x0000000793330000)
  to   space 34944K,   0% used [0x0000000793330000, 0x0000000793330000, 0x0000000795550000)
 concurrent mark-sweep generation total 699072K, used 337715K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```
### > 升级成4g，生成了12293个对象，GC次数变少，看来和串行并行GC一样，内存加大到一定程度 对程序造成的效益就没有了
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseConcMarkSweepGC -Xms4g -Xmx4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T16:58:11.136-0800: [GC (Allocation Failure) 2020-10-28T16:58:11.136-0800: [ParNew: 545275K->68095K(613440K), 0.0573997 secs] 545275K->155520K(4126208K), 0.0574489 secs] [Times: user=0.08 sys=0.27, real=0.06 secs]
2020-10-28T16:58:11.269-0800: [GC (Allocation Failure) 2020-10-28T16:58:11.269-0800: [ParNew: 613439K->68094K(613440K), 0.0564480 secs] 700864K->276664K(4126208K), 0.0564878 secs] [Times: user=0.11 sys=0.23, real=0.06 secs]
2020-10-28T16:58:11.392-0800: [GC (Allocation Failure) 2020-10-28T16:58:11.392-0800: [ParNew: 613438K->68096K(613440K), 0.0760568 secs] 822008K->394795K(4126208K), 0.0761267 secs] [Times: user=0.43 sys=0.04, real=0.07 secs]
2020-10-28T16:58:11.532-0800: [GC (Allocation Failure) 2020-10-28T16:58:11.532-0800: [ParNew: 613440K->68096K(613440K), 0.0796942 secs] 940139K->514674K(4126208K), 0.0797327 secs] [Times: user=0.42 sys=0.04, real=0.08 secs]
2020-10-28T16:58:11.675-0800: [GC (Allocation Failure) 2020-10-28T16:58:11.675-0800: [ParNew: 613440K->68096K(613440K), 0.0857116 secs] 1060018K->643482K(4126208K), 0.0857523 secs] [Times: user=0.42 sys=0.04, real=0.09 secs]
2020-10-28T16:58:11.823-0800: [GC (Allocation Failure) 2020-10-28T16:58:11.823-0800: [ParNew: 613440K->68094K(613440K), 0.0998125 secs] 1188826K->768325K(4126208K), 0.0998833 secs] [Times: user=0.47 sys=0.06, real=0.10 secs]
执行结束!共生成对象次数:12293
Heap
 par new generation   total 613440K, used 89964K [0x00000006c0000000, 0x00000006e9990000, 0x00000006e9990000)
  eden space 545344K,   4% used [0x00000006c0000000, 0x00000006c155bb70, 0x00000006e1490000)
  from space 68096K,  99% used [0x00000006e1490000, 0x00000006e570f878, 0x00000006e5710000)
  to   space 68096K,   0% used [0x00000006e5710000, 0x00000006e5710000, 0x00000006e9990000)
 concurrent mark-sweep generation total 3512768K, used 700231K [0x00000006e9990000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2703K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 295K, capacity 386K, committed 512K, reserved 1048576K
```
## G1GC
### > G1在100m的表现情况，内存溢出，可以看出g1的fullGC比较频繁
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseG1GC -Xms100m -Xmx100m -XX:+PrintGC -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T18:03:20.563-0800: [GC pause (G1 Evacuation Pause) (young) 28M->11M(100M), 0.0036896 secs]
2020-10-28T18:03:20.577-0800: [GC pause (G1 Evacuation Pause) (young) 41M->21M(100M), 0.0047434 secs]
2020-10-28T18:03:20.596-0800: [GC pause (G1 Evacuation Pause) (young) 65M->36M(100M), 0.0056428 secs]
2020-10-28T18:03:20.608-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 63M->44M(100M), 0.0039256 secs]
2020-10-28T18:03:20.612-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.612-0800: [GC concurrent-root-region-scan-end, 0.0001552 secs]
2020-10-28T18:03:20.612-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.612-0800: [GC concurrent-mark-end, 0.0005257 secs]
2020-10-28T18:03:20.613-0800: [GC remark, 0.0008391 secs]
2020-10-28T18:03:20.613-0800: [GC cleanup 48M->48M(100M), 0.0003521 secs]
2020-10-28T18:03:20.621-0800: [GC pause (G1 Evacuation Pause) (young)-- 78M->59M(100M), 0.0028482 secs]
2020-10-28T18:03:20.624-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 59M->59M(100M), 0.0022277 secs]
2020-10-28T18:03:20.627-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.627-0800: [GC concurrent-root-region-scan-end, 0.0000348 secs]
2020-10-28T18:03:20.627-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.627-0800: [GC concurrent-mark-end, 0.0005484 secs]
2020-10-28T18:03:20.627-0800: [GC remark, 0.0007308 secs]
2020-10-28T18:03:20.628-0800: [GC cleanup 63M->63M(100M), 0.0004069 secs]
2020-10-28T18:03:20.633-0800: [GC pause (G1 Evacuation Pause) (young) 81M->66M(100M), 0.0014410 secs]
2020-10-28T18:03:20.635-0800: [GC pause (G1 Evacuation Pause) (mixed) 70M->65M(100M), 0.0011480 secs]
2020-10-28T18:03:20.638-0800: [GC pause (G1 Evacuation Pause) (young) 76M->68M(100M), 0.0006146 secs]
2020-10-28T18:03:20.639-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 69M->68M(100M), 0.0008704 secs]
2020-10-28T18:03:20.639-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.639-0800: [GC concurrent-root-region-scan-end, 0.0000435 secs]
2020-10-28T18:03:20.639-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.640-0800: [GC concurrent-mark-end, 0.0005289 secs]
2020-10-28T18:03:20.640-0800: [GC remark, 0.0007742 secs]
2020-10-28T18:03:20.641-0800: [GC cleanup 72M->72M(100M), 0.0004331 secs]
2020-10-28T18:03:20.643-0800: [GC pause (G1 Evacuation Pause) (young) 81M->73M(100M), 0.0010567 secs]
2020-10-28T18:03:20.645-0800: [GC pause (G1 Evacuation Pause) (mixed) 80M->74M(100M), 0.0009298 secs]
2020-10-28T18:03:20.647-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 76M->75M(100M), 0.0008385 secs]
2020-10-28T18:03:20.647-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.647-0800: [GC concurrent-root-region-scan-end, 0.0000595 secs]
2020-10-28T18:03:20.647-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.648-0800: [GC concurrent-mark-end, 0.0004792 secs]
2020-10-28T18:03:20.648-0800: [GC remark, 0.0006237 secs]
2020-10-28T18:03:20.649-0800: [GC cleanup 79M->79M(100M), 0.0002368 secs]
2020-10-28T18:03:20.649-0800: [GC pause (G1 Evacuation Pause) (young) 82M->76M(100M), 0.0005493 secs]
2020-10-28T18:03:20.651-0800: [GC pause (G1 Evacuation Pause) (mixed) 83M->78M(100M), 0.0005541 secs]
2020-10-28T18:03:20.652-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 84M->79M(100M), 0.0004758 secs]
2020-10-28T18:03:20.653-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.653-0800: [GC concurrent-root-region-scan-end, 0.0000873 secs]
2020-10-28T18:03:20.653-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.653-0800: [GC concurrent-mark-end, 0.0003906 secs]
2020-10-28T18:03:20.653-0800: [GC remark, 0.0005051 secs]
2020-10-28T18:03:20.654-0800: [GC cleanup 83M->83M(100M), 0.0002535 secs]
2020-10-28T18:03:20.655-0800: [GC pause (G1 Evacuation Pause) (young)-- 87M->86M(100M), 0.0007118 secs]
2020-10-28T18:03:20.656-0800: [GC pause (G1 Humongous Allocation) (mixed)-- 88M->88M(100M), 0.0005811 secs]
2020-10-28T18:03:20.656-0800: [Full GC (Allocation Failure)  88M->73M(100M), 0.0094322 secs]
2020-10-28T18:03:20.667-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 77M->74M(100M), 0.0010336 secs]
2020-10-28T18:03:20.668-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.668-0800: [GC concurrent-root-region-scan-end, 0.0000742 secs]
2020-10-28T18:03:20.668-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.668-0800: [GC concurrent-mark-end, 0.0004787 secs]
2020-10-28T18:03:20.668-0800: [GC remark, 0.0012328 secs]
2020-10-28T18:03:20.670-0800: [GC cleanup 78M->78M(100M), 0.0002726 secs]
2020-10-28T18:03:20.670-0800: [GC pause (G1 Evacuation Pause) (young)-- 79M->77M(100M), 0.0007074 secs]
2020-10-28T18:03:20.671-0800: [GC pause (G1 Evacuation Pause) (mixed)-- 79M->78M(100M), 0.0008296 secs]
2020-10-28T18:03:20.672-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark)-- 79M->79M(100M), 0.0006749 secs]
2020-10-28T18:03:20.673-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.673-0800: [GC concurrent-root-region-scan-end, 0.0000115 secs]
2020-10-28T18:03:20.673-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.673-0800: [GC pause (G1 Humongous Allocation) (young) 79M->79M(100M), 0.0004667 secs]
2020-10-28T18:03:20.674-0800: [Full GC (Allocation Failure)  79M->75M(100M), 0.0017692 secs]
2020-10-28T18:03:20.676-0800: [GC concurrent-mark-abort]
2020-10-28T18:03:20.676-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 76M->75M(100M), 0.0004918 secs]
2020-10-28T18:03:20.676-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.676-0800: [GC concurrent-root-region-scan-end, 0.0000082 secs]
2020-10-28T18:03:20.676-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.677-0800: [GC pause (G1 Evacuation Pause) (young)-- 79M->78M(100M), 0.0009646 secs]
2020-10-28T18:03:20.678-0800: [GC concurrent-mark-end, 0.0013786 secs]
2020-10-28T18:03:20.678-0800: [GC remark, 0.0004987 secs]
2020-10-28T18:03:20.678-0800: [GC cleanup 79M->79M(100M), 0.0002448 secs]
2020-10-28T18:03:20.679-0800: [GC pause (G1 Evacuation Pause) (young)-- 79M->79M(100M), 0.0004407 secs]
2020-10-28T18:03:20.679-0800: [Full GC (Allocation Failure)  79M->76M(100M), 0.0016508 secs]
2020-10-28T18:03:20.681-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 78M->77M(100M), 0.0004974 secs]
2020-10-28T18:03:20.681-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.682-0800: [GC concurrent-root-region-scan-end, 0.0000560 secs]
2020-10-28T18:03:20.682-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.682-0800: [GC pause (G1 Evacuation Pause) (young)-- 79M->79M(100M), 0.0014444 secs]
2020-10-28T18:03:20.683-0800: [Full GC (Allocation Failure)  79M->77M(100M), 0.0015968 secs]
2020-10-28T18:03:20.685-0800: [GC concurrent-mark-abort]
2020-10-28T18:03:20.685-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark)-- 79M->79M(100M), 0.0004639 secs]
2020-10-28T18:03:20.686-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.686-0800: [GC concurrent-root-region-scan-end, 0.0000076 secs]
2020-10-28T18:03:20.686-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.686-0800: [GC pause (G1 Humongous Allocation) (young) 79M->79M(100M), 0.0004061 secs]
2020-10-28T18:03:20.686-0800: [Full GC (Allocation Failure)  79M->78M(100M), 0.0018443 secs]
2020-10-28T18:03:20.688-0800: [GC concurrent-mark-abort]
2020-10-28T18:03:20.688-0800: [GC pause (G1 Evacuation Pause) (young)-- 79M->79M(100M), 0.0010835 secs]
2020-10-28T18:03:20.690-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark)-- 79M->79M(100M), 0.0015510 secs]
2020-10-28T18:03:20.691-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.691-0800: [GC concurrent-root-region-scan-end, 0.0000120 secs]
2020-10-28T18:03:20.691-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.691-0800: [GC pause (G1 Humongous Allocation) (young) 79M->79M(100M), 0.0006561 secs]
2020-10-28T18:03:20.692-0800: [Full GC (Allocation Failure)  79M->78M(100M), 0.0095436 secs]
2020-10-28T18:03:20.702-0800: [GC concurrent-mark-abort]
2020-10-28T18:03:20.702-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark)-- 78M->78M(100M), 0.0011514 secs]
2020-10-28T18:03:20.703-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.703-0800: [GC concurrent-root-region-scan-end, 0.0000129 secs]
2020-10-28T18:03:20.703-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.703-0800: [GC pause (G1 Humongous Allocation) (young) 78M->78M(100M), 0.0013023 secs]
2020-10-28T18:03:20.704-0800: [Full GC (Allocation Failure)  78M->78M(100M), 0.0018095 secs]
2020-10-28T18:03:20.706-0800: [GC concurrent-mark-abort]
2020-10-28T18:03:20.706-0800: [GC pause (G1 Evacuation Pause) (young) 79M->78M(100M), 0.0005657 secs]
2020-10-28T18:03:20.707-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark)-- 79M->79M(100M), 0.0010321 secs]
2020-10-28T18:03:20.708-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.708-0800: [GC concurrent-root-region-scan-end, 0.0000100 secs]
2020-10-28T18:03:20.708-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.708-0800: [GC pause (G1 Humongous Allocation) (young) 79M->79M(100M), 0.0014499 secs]
2020-10-28T18:03:20.710-0800: [Full GC (Allocation Failure)  79M->79M(100M), 0.0017267 secs]
2020-10-28T18:03:20.712-0800: [GC concurrent-mark-abort]
2020-10-28T18:03:20.712-0800: [GC pause (G1 Evacuation Pause) (young) 79M->79M(100M), 0.0006051 secs]
2020-10-28T18:03:20.712-0800: [GC pause (G1 Evacuation Pause) (young) (initial-mark) 79M->79M(100M), 0.0004536 secs]
2020-10-28T18:03:20.713-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.713-0800: [GC concurrent-root-region-scan-end, 0.0000096 secs]
2020-10-28T18:03:20.713-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.713-0800: [Full GC (Allocation Failure)  79M->79M(100M), 0.0015325 secs]
2020-10-28T18:03:20.714-0800: [Full GC (Allocation Failure)  79M->79M(100M), 0.0013230 secs]
2020-10-28T18:03:20.716-0800: [GC concurrent-mark-abort]
2020-10-28T18:03:20.716-0800: [GC pause (G1 Evacuation Pause) (young) 79M->79M(100M), 0.0004119 secs]
2020-10-28T18:03:20.716-0800: [GC pause (G1 Evacuation Pause) (young) (initial-mark) 79M->79M(100M), 0.0004066 secs]
2020-10-28T18:03:20.717-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:03:20.717-0800: [GC concurrent-root-region-scan-end, 0.0000092 secs]
2020-10-28T18:03:20.717-0800: [GC concurrent-mark-start]
2020-10-28T18:03:20.717-0800: [Full GC (Allocation Failure)  79M->270K(100M), 0.0012996 secs]
2020-10-28T18:03:20.718-0800: [GC concurrent-mark-abort]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at GCLogAnalysis.generateGarbage(GCLogAnalysis.java:44)
	at GCLogAnalysis.main(GCLogAnalysis.java:24)
```
### > 512m下的情况，生成了10000对象
```
(base)  yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGC -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T18:05:02.020-0800: [GC pause (G1 Evacuation Pause) (young) 28M->8982K(512M), 0.0034479 secs]
2020-10-28T18:05:02.035-0800: [GC pause (G1 Evacuation Pause) (young) 45M->17M(512M), 0.0040788 secs]
2020-10-28T18:05:02.055-0800: [GC pause (G1 Evacuation Pause) (young) 62M->33M(512M), 0.0071746 secs]
2020-10-28T18:05:02.092-0800: [GC pause (G1 Evacuation Pause) (young) 111M->64M(512M), 0.0087395 secs]
2020-10-28T18:05:02.146-0800: [GC pause (G1 Evacuation Pause) (young) 193M->100M(512M), 0.0113380 secs]
2020-10-28T18:05:02.182-0800: [GC pause (G1 Evacuation Pause) (young) 219M->135M(512M), 0.0110598 secs]
2020-10-28T18:05:02.240-0800: [GC pause (G1 Evacuation Pause) (young) 317M->190M(512M), 0.0179814 secs]
2020-10-28T18:05:02.276-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 296M->221M(512M), 0.0085407 secs]
2020-10-28T18:05:02.284-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.285-0800: [GC concurrent-root-region-scan-end, 0.0001531 secs]
2020-10-28T18:05:02.285-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.286-0800: [GC concurrent-mark-end, 0.0014695 secs]
2020-10-28T18:05:02.286-0800: [GC remark, 0.0008467 secs]
2020-10-28T18:05:02.287-0800: [GC cleanup 230M->229M(512M), 0.0006641 secs]
2020-10-28T18:05:02.288-0800: [GC concurrent-cleanup-start]
2020-10-28T18:05:02.288-0800: [GC concurrent-cleanup-end, 0.0000358 secs]
2020-10-28T18:05:02.334-0800: [GC pause (G1 Evacuation Pause) (young)-- 407M->305M(512M), 0.0283246 secs]
2020-10-28T18:05:02.364-0800: [GC pause (G1 Evacuation Pause) (mixed) 309M->287M(512M), 0.0073174 secs]
2020-10-28T18:05:02.372-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 290M->288M(512M), 0.0022143 secs]
2020-10-28T18:05:02.374-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.374-0800: [GC concurrent-root-region-scan-end, 0.0001150 secs]
2020-10-28T18:05:02.374-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.375-0800: [GC concurrent-mark-end, 0.0010119 secs]
2020-10-28T18:05:02.376-0800: [GC remark, 0.0016911 secs]
2020-10-28T18:05:02.377-0800: [GC cleanup 297M->296M(512M), 0.0006387 secs]
2020-10-28T18:05:02.378-0800: [GC concurrent-cleanup-start]
2020-10-28T18:05:02.378-0800: [GC concurrent-cleanup-end, 0.0000093 secs]
2020-10-28T18:05:02.398-0800: [GC pause (G1 Evacuation Pause) (young) 404M->320M(512M), 0.0043232 secs]
2020-10-28T18:05:02.404-0800: [GC pause (G1 Evacuation Pause) (mixed) 334M->281M(512M), 0.0031016 secs]
2020-10-28T18:05:02.411-0800: [GC pause (G1 Evacuation Pause) (mixed) 307M->277M(512M), 0.0041043 secs]
2020-10-28T18:05:02.416-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 279M->277M(512M), 0.0017695 secs]
2020-10-28T18:05:02.418-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.418-0800: [GC concurrent-root-region-scan-end, 0.0001056 secs]
2020-10-28T18:05:02.418-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.418-0800: [GC concurrent-mark-end, 0.0008195 secs]
2020-10-28T18:05:02.419-0800: [GC remark, 0.0014521 secs]
2020-10-28T18:05:02.420-0800: [GC cleanup 280M->280M(512M), 0.0005454 secs]
2020-10-28T18:05:02.442-0800: [GC pause (G1 Evacuation Pause) (young) 417M->316M(512M), 0.0038669 secs]
2020-10-28T18:05:02.448-0800: [GC pause (G1 Evacuation Pause) (mixed) 329M->292M(512M), 0.0065524 secs]
2020-10-28T18:05:02.455-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 293M->292M(512M), 0.0024533 secs]
2020-10-28T18:05:02.457-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.457-0800: [GC concurrent-root-region-scan-end, 0.0001052 secs]
2020-10-28T18:05:02.457-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.460-0800: [GC concurrent-mark-end, 0.0024970 secs]
2020-10-28T18:05:02.460-0800: [GC remark, 0.0017392 secs]
2020-10-28T18:05:02.462-0800: [GC cleanup 300M->300M(512M), 0.0005738 secs]
2020-10-28T18:05:02.481-0800: [GC pause (G1 Evacuation Pause) (young)-- 421M->338M(512M), 0.0044232 secs]
2020-10-28T18:05:02.488-0800: [GC pause (G1 Evacuation Pause) (mixed) 354M->316M(512M), 0.0065217 secs]
2020-10-28T18:05:02.500-0800: [GC pause (G1 Evacuation Pause) (mixed) 341M->322M(512M), 0.0031746 secs]
2020-10-28T18:05:02.504-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 323M->323M(512M), 0.0015505 secs]
2020-10-28T18:05:02.505-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.505-0800: [GC concurrent-root-region-scan-end, 0.0000793 secs]
2020-10-28T18:05:02.505-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.507-0800: [GC concurrent-mark-end, 0.0012183 secs]
2020-10-28T18:05:02.507-0800: [GC remark, 0.0017977 secs]
2020-10-28T18:05:02.509-0800: [GC cleanup 329M->329M(512M), 0.0006042 secs]
2020-10-28T18:05:02.523-0800: [GC pause (G1 Evacuation Pause) (young) 412M->344M(512M), 0.0041456 secs]
2020-10-28T18:05:02.530-0800: [GC pause (G1 Evacuation Pause) (mixed) 361M->317M(512M), 0.0051591 secs]
2020-10-28T18:05:02.541-0800: [GC pause (G1 Evacuation Pause) (mixed) 343M->317M(512M), 0.0028223 secs]
2020-10-28T18:05:02.544-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 318M->317M(512M), 0.0009692 secs]
2020-10-28T18:05:02.545-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.545-0800: [GC concurrent-root-region-scan-end, 0.0001044 secs]
2020-10-28T18:05:02.545-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.546-0800: [GC concurrent-mark-end, 0.0010987 secs]
2020-10-28T18:05:02.546-0800: [GC remark, 0.0015962 secs]
2020-10-28T18:05:02.548-0800: [GC cleanup 324M->324M(512M), 0.0006793 secs]
2020-10-28T18:05:02.563-0800: [GC pause (G1 Evacuation Pause) (young) 415M->346M(512M), 0.0058261 secs]
2020-10-28T18:05:02.573-0800: [GC pause (G1 Evacuation Pause) (mixed) 364M->326M(512M), 0.0060854 secs]
2020-10-28T18:05:02.579-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 327M->327M(512M), 0.0010035 secs]
2020-10-28T18:05:02.580-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.580-0800: [GC concurrent-root-region-scan-end, 0.0000939 secs]
2020-10-28T18:05:02.580-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.582-0800: [GC concurrent-mark-end, 0.0014050 secs]
2020-10-28T18:05:02.582-0800: [GC remark, 0.0020336 secs]
2020-10-28T18:05:02.584-0800: [GC cleanup 335M->335M(512M), 0.0007308 secs]
2020-10-28T18:05:02.599-0800: [GC pause (G1 Evacuation Pause) (young) 406M->346M(512M), 0.0037765 secs]
2020-10-28T18:05:02.606-0800: [GC pause (G1 Evacuation Pause) (mixed) 368M->331M(512M), 0.0101100 secs]
2020-10-28T18:05:02.620-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 340M->334M(512M), 0.0022494 secs]
2020-10-28T18:05:02.622-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.622-0800: [GC concurrent-root-region-scan-end, 0.0001174 secs]
2020-10-28T18:05:02.622-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.623-0800: [GC concurrent-mark-end, 0.0011841 secs]
2020-10-28T18:05:02.624-0800: [GC remark, 0.0014241 secs]
2020-10-28T18:05:02.625-0800: [GC cleanup 341M->341M(512M), 0.0006114 secs]
2020-10-28T18:05:02.639-0800: [GC pause (G1 Evacuation Pause) (young) 403M->355M(512M), 0.0045852 secs]
2020-10-28T18:05:02.647-0800: [GC pause (G1 Evacuation Pause) (mixed) 376M->345M(512M), 0.0059248 secs]
2020-10-28T18:05:02.653-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 347M->345M(512M), 0.0031093 secs]
2020-10-28T18:05:02.657-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.657-0800: [GC concurrent-root-region-scan-end, 0.0001211 secs]
2020-10-28T18:05:02.657-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.659-0800: [GC concurrent-mark-end, 0.0019146 secs]
2020-10-28T18:05:02.659-0800: [GC remark, 0.0022690 secs]
2020-10-28T18:05:02.661-0800: [GC cleanup 353M->352M(512M), 0.0005434 secs]
2020-10-28T18:05:02.662-0800: [GC concurrent-cleanup-start]
2020-10-28T18:05:02.662-0800: [GC concurrent-cleanup-end, 0.0000110 secs]
2020-10-28T18:05:02.671-0800: [GC pause (G1 Evacuation Pause) (young) 401M->362M(512M), 0.0063977 secs]
2020-10-28T18:05:02.681-0800: [GC pause (G1 Evacuation Pause) (mixed) 382M->349M(512M), 0.0052006 secs]
2020-10-28T18:05:02.687-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 350M->349M(512M), 0.0025063 secs]
2020-10-28T18:05:02.689-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.689-0800: [GC concurrent-root-region-scan-end, 0.0001038 secs]
2020-10-28T18:05:02.689-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.691-0800: [GC concurrent-mark-end, 0.0011097 secs]
2020-10-28T18:05:02.691-0800: [GC remark, 0.0013510 secs]
2020-10-28T18:05:02.692-0800: [GC cleanup 357M->357M(512M), 0.0006178 secs]
2020-10-28T18:05:02.702-0800: [GC pause (G1 Evacuation Pause) (young) 403M->363M(512M), 0.0029746 secs]
2020-10-28T18:05:02.709-0800: [GC pause (G1 Evacuation Pause) (mixed) 391M->352M(512M), 0.0059098 secs]
2020-10-28T18:05:02.716-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 356M->353M(512M), 0.0014894 secs]
2020-10-28T18:05:02.717-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.717-0800: [GC concurrent-root-region-scan-end, 0.0001113 secs]
2020-10-28T18:05:02.717-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.719-0800: [GC concurrent-mark-end, 0.0013507 secs]
2020-10-28T18:05:02.719-0800: [GC remark, 0.0016459 secs]
2020-10-28T18:05:02.721-0800: [GC cleanup 359M->359M(512M), 0.0005904 secs]
2020-10-28T18:05:02.729-0800: [GC pause (G1 Evacuation Pause) (young) 399M->362M(512M), 0.0026128 secs]
2020-10-28T18:05:02.735-0800: [GC pause (G1 Evacuation Pause) (mixed) 387M->356M(512M), 0.0053174 secs]
2020-10-28T18:05:02.741-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 356M->356M(512M), 0.0012852 secs]
2020-10-28T18:05:02.742-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.742-0800: [GC concurrent-root-region-scan-end, 0.0000526 secs]
2020-10-28T18:05:02.742-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.743-0800: [GC concurrent-mark-end, 0.0010899 secs]
2020-10-28T18:05:02.743-0800: [GC remark, 0.0013048 secs]
2020-10-28T18:05:02.745-0800: [GC cleanup 363M->363M(512M), 0.0005451 secs]
2020-10-28T18:05:02.751-0800: [GC pause (G1 Evacuation Pause) (young) 397M->365M(512M), 0.0030026 secs]
2020-10-28T18:05:02.758-0800: [GC pause (G1 Evacuation Pause) (mixed) 392M->354M(512M), 0.0058494 secs]
2020-10-28T18:05:02.765-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 356M->354M(512M), 0.0032348 secs]
2020-10-28T18:05:02.768-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.768-0800: [GC concurrent-root-region-scan-end, 0.0000844 secs]
2020-10-28T18:05:02.768-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.770-0800: [GC concurrent-mark-end, 0.0013650 secs]
2020-10-28T18:05:02.770-0800: [GC remark, 0.0019481 secs]
2020-10-28T18:05:02.772-0800: [GC cleanup 363M->363M(512M), 0.0006938 secs]
2020-10-28T18:05:02.778-0800: [GC pause (G1 Evacuation Pause) (young) 396M->366M(512M), 0.0029166 secs]
2020-10-28T18:05:02.785-0800: [GC pause (G1 Evacuation Pause) (mixed) 390M->359M(512M), 0.0050158 secs]
2020-10-28T18:05:02.790-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 362M->360M(512M), 0.0016513 secs]
2020-10-28T18:05:02.792-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.792-0800: [GC concurrent-root-region-scan-end, 0.0001797 secs]
2020-10-28T18:05:02.792-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.794-0800: [GC concurrent-mark-end, 0.0014960 secs]
2020-10-28T18:05:02.794-0800: [GC remark, 0.0015698 secs]
2020-10-28T18:05:02.795-0800: [GC cleanup 369M->369M(512M), 0.0006166 secs]
2020-10-28T18:05:02.801-0800: [GC pause (G1 Evacuation Pause) (young) 397M->368M(512M), 0.0025583 secs]
2020-10-28T18:05:02.807-0800: [GC pause (G1 Evacuation Pause) (mixed) 394M->360M(512M), 0.0044852 secs]
2020-10-28T18:05:02.812-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 361M->360M(512M), 0.0011212 secs]
2020-10-28T18:05:02.813-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.813-0800: [GC concurrent-root-region-scan-end, 0.0000997 secs]
2020-10-28T18:05:02.813-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.814-0800: [GC concurrent-mark-end, 0.0012774 secs]
2020-10-28T18:05:02.815-0800: [GC remark, 0.0021851 secs]
2020-10-28T18:05:02.817-0800: [GC cleanup 366M->366M(512M), 0.0005946 secs]
2020-10-28T18:05:02.822-0800: [GC pause (G1 Evacuation Pause) (young) 397M->368M(512M), 0.0021574 secs]
2020-10-28T18:05:02.828-0800: [GC pause (G1 Evacuation Pause) (mixed) 392M->363M(512M), 0.0047622 secs]
2020-10-28T18:05:02.834-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 366M->364M(512M), 0.0020740 secs]
2020-10-28T18:05:02.836-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.836-0800: [GC concurrent-root-region-scan-end, 0.0000450 secs]
2020-10-28T18:05:02.836-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.837-0800: [GC concurrent-mark-end, 0.0013334 secs]
2020-10-28T18:05:02.837-0800: [GC remark, 0.0015851 secs]
2020-10-28T18:05:02.839-0800: [GC cleanup 370M->370M(512M), 0.0006632 secs]
2020-10-28T18:05:02.844-0800: [GC pause (G1 Evacuation Pause) (young) 399M->375M(512M), 0.0018843 secs]
2020-10-28T18:05:02.849-0800: [GC pause (G1 Evacuation Pause) (mixed) 397M->366M(512M), 0.0068262 secs]
2020-10-28T18:05:02.856-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 367M->366M(512M), 0.0027224 secs]
2020-10-28T18:05:02.859-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.859-0800: [GC concurrent-root-region-scan-end, 0.0000954 secs]
2020-10-28T18:05:02.859-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.861-0800: [GC concurrent-mark-end, 0.0016567 secs]
2020-10-28T18:05:02.861-0800: [GC remark, 0.0012393 secs]
2020-10-28T18:05:02.862-0800: [GC cleanup 374M->374M(512M), 0.0005614 secs]
2020-10-28T18:05:02.867-0800: [GC pause (G1 Evacuation Pause) (young) 397M->373M(512M), 0.0023798 secs]
2020-10-28T18:05:02.874-0800: [GC pause (G1 Evacuation Pause) (mixed) 398M->365M(512M), 0.0046058 secs]
2020-10-28T18:05:02.879-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 365M->365M(512M), 0.0013732 secs]
2020-10-28T18:05:02.880-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.880-0800: [GC concurrent-root-region-scan-end, 0.0000464 secs]
2020-10-28T18:05:02.880-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.881-0800: [GC concurrent-mark-end, 0.0014198 secs]
2020-10-28T18:05:02.882-0800: [GC remark, 0.0019809 secs]
2020-10-28T18:05:02.884-0800: [GC cleanup 372M->372M(512M), 0.0006538 secs]
2020-10-28T18:05:02.888-0800: [GC pause (G1 Evacuation Pause) (young) 395M->375M(512M), 0.0016916 secs]
2020-10-28T18:05:02.894-0800: [GC pause (G1 Evacuation Pause) (mixed) 400M->370M(512M), 0.0046367 secs]
2020-10-28T18:05:02.900-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 372M->371M(512M), 0.0025621 secs]
2020-10-28T18:05:02.902-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.902-0800: [GC concurrent-root-region-scan-end, 0.0001119 secs]
2020-10-28T18:05:02.902-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.904-0800: [GC concurrent-mark-end, 0.0012279 secs]
2020-10-28T18:05:02.904-0800: [GC remark, 0.0018663 secs]
2020-10-28T18:05:02.906-0800: [GC cleanup 379M->379M(512M), 0.0006518 secs]
2020-10-28T18:05:02.910-0800: [GC pause (G1 Evacuation Pause) (young) 401M->377M(512M), 0.0028127 secs]
2020-10-28T18:05:02.918-0800: [GC pause (G1 Evacuation Pause) (mixed) 406M->374M(512M), 0.0046482 secs]
2020-10-28T18:05:02.923-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 377M->376M(512M), 0.0036060 secs]
2020-10-28T18:05:02.927-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.927-0800: [GC concurrent-root-region-scan-end, 0.0002304 secs]
2020-10-28T18:05:02.927-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.929-0800: [GC concurrent-mark-end, 0.0017083 secs]
2020-10-28T18:05:02.929-0800: [GC remark, 0.0021784 secs]
2020-10-28T18:05:02.931-0800: [GC cleanup 383M->383M(512M), 0.0006425 secs]
2020-10-28T18:05:02.936-0800: [GC pause (G1 Evacuation Pause) (young) 404M->385M(512M), 0.0030930 secs]
2020-10-28T18:05:02.942-0800: [GC pause (G1 Evacuation Pause) (mixed)-- 412M->390M(512M), 0.0065767 secs]
2020-10-28T18:05:02.949-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 391M->391M(512M), 0.0010839 secs]
2020-10-28T18:05:02.950-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.950-0800: [GC concurrent-root-region-scan-end, 0.0000541 secs]
2020-10-28T18:05:02.950-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.952-0800: [GC concurrent-mark-end, 0.0011526 secs]
2020-10-28T18:05:02.952-0800: [GC remark, 0.0014362 secs]
2020-10-28T18:05:02.953-0800: [GC cleanup 399M->398M(512M), 0.0006006 secs]
2020-10-28T18:05:02.954-0800: [GC concurrent-cleanup-start]
2020-10-28T18:05:02.954-0800: [GC concurrent-cleanup-end, 0.0000177 secs]
2020-10-28T18:05:02.958-0800: [GC pause (G1 Evacuation Pause) (young) 421M->402M(512M), 0.0029610 secs]
2020-10-28T18:05:02.966-0800: [GC pause (G1 Evacuation Pause) (mixed)-- 427M->411M(512M), 0.0038430 secs]
2020-10-28T18:05:02.970-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 412M->411M(512M), 0.0016804 secs]
2020-10-28T18:05:02.972-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.972-0800: [GC concurrent-root-region-scan-end, 0.0001468 secs]
2020-10-28T18:05:02.972-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.973-0800: [GC concurrent-mark-end, 0.0016472 secs]
2020-10-28T18:05:02.973-0800: [GC remark, 0.0012697 secs]
2020-10-28T18:05:02.975-0800: [GC cleanup 420M->420M(512M), 0.0008188 secs]
2020-10-28T18:05:02.979-0800: [GC pause (G1 Evacuation Pause) (young)-- 443M->436M(512M), 0.0023092 secs]
2020-10-28T18:05:02.984-0800: [GC pause (G1 Evacuation Pause) (mixed)-- 447M->442M(512M), 0.0010288 secs]
2020-10-28T18:05:02.986-0800: [GC pause (G1 Evacuation Pause) (mixed)-- 449M->446M(512M), 0.0018620 secs]
2020-10-28T18:05:02.988-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 447M->446M(512M), 0.0012533 secs]
2020-10-28T18:05:02.989-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:05:02.989-0800: [GC concurrent-root-region-scan-end, 0.0000339 secs]
2020-10-28T18:05:02.989-0800: [GC concurrent-mark-start]
2020-10-28T18:05:02.990-0800: [GC pause (G1 Evacuation Pause) (young)-- 450M->449M(512M), 0.0016988 secs]
2020-10-28T18:05:02.992-0800: [GC concurrent-mark-end, 0.0029535 secs]
2020-10-28T18:05:02.992-0800: [GC pause (G1 Evacuation Pause) (young)-- 450M->450M(512M), 0.0012460 secs]
2020-10-28T18:05:02.993-0800: [Full GC (Allocation Failure)  450M->332M(512M), 0.0370634 secs]
2020-10-28T18:05:03.031-0800: [GC remark, 0.0000459 secs]
2020-10-28T18:05:03.031-0800: [GC concurrent-mark-abort]
执行结束!共生成对象次数:10018
```
### >1g的情况下，gc明显变少，生成9000对象，可见提升堆内存，对程序并没有提升
```
(base)  ✘ yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseG1GC -Xms1g -Xmx1g -XX:+PrintGC -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T18:06:25.627-0800: [GC pause (G1 Evacuation Pause) (young) 67M->22M(1024M), 0.0055963 secs]
2020-10-28T18:06:25.644-0800: [GC pause (G1 Evacuation Pause) (young) 76M->41M(1024M), 0.0054362 secs]
2020-10-28T18:06:25.663-0800: [GC pause (G1 Evacuation Pause) (young) 96M->60M(1024M), 0.0056845 secs]
2020-10-28T18:06:25.687-0800: [GC pause (G1 Evacuation Pause) (young) 132M->88M(1024M), 0.0103949 secs]
2020-10-28T18:06:25.942-0800: [GC pause (G1 Evacuation Pause) (young) 565M->214M(1024M), 0.0925625 secs]
2020-10-28T18:06:26.037-0800: [GC pause (G1 Evacuation Pause) (young) 224M->218M(1024M), 0.0098478 secs]
2020-10-28T18:06:26.101-0800: [GC pause (G1 Evacuation Pause) (young) 426M->282M(1024M), 0.0173674 secs]
2020-10-28T18:06:26.157-0800: [GC pause (G1 Evacuation Pause) (young) 482M->329M(1024M), 0.0160936 secs]
2020-10-28T18:06:26.229-0800: [GC pause (G1 Evacuation Pause) (young) 602M->397M(1024M), 0.0382460 secs]
2020-10-28T18:06:26.295-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 527M->428M(1024M), 0.0108468 secs]
2020-10-28T18:06:26.306-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:06:26.306-0800: [GC concurrent-root-region-scan-end, 0.0001988 secs]
2020-10-28T18:06:26.306-0800: [GC concurrent-mark-start]
2020-10-28T18:06:26.311-0800: [GC concurrent-mark-end, 0.0044067 secs]
2020-10-28T18:06:26.311-0800: [GC remark, 0.0021584 secs]
2020-10-28T18:06:26.313-0800: [GC cleanup 446M->431M(1024M), 0.0009325 secs]
2020-10-28T18:06:26.314-0800: [GC concurrent-cleanup-start]
2020-10-28T18:06:26.314-0800: [GC concurrent-cleanup-end, 0.0000318 secs]
2020-10-28T18:06:26.390-0800: [GC pause (G1 Evacuation Pause) (young) 731M->485M(1024M), 0.0209880 secs]
2020-10-28T18:06:26.415-0800: [GC pause (G1 Evacuation Pause) (mixed) 505M->411M(1024M), 0.0090521 secs]
2020-10-28T18:06:26.425-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 412M->411M(1024M), 0.0029849 secs]
2020-10-28T18:06:26.428-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:06:26.428-0800: [GC concurrent-root-region-scan-end, 0.0001036 secs]
2020-10-28T18:06:26.428-0800: [GC concurrent-mark-start]
2020-10-28T18:06:26.429-0800: [GC concurrent-mark-end, 0.0014214 secs]
2020-10-28T18:06:26.429-0800: [GC remark, 0.0014060 secs]
2020-10-28T18:06:26.431-0800: [GC cleanup 417M->417M(1024M), 0.0008243 secs]
2020-10-28T18:06:26.504-0800: [GC pause (G1 Evacuation Pause) (young)-- 841M->573M(1024M), 0.0128756 secs]
2020-10-28T18:06:26.520-0800: [GC pause (G1 Evacuation Pause) (mixed) 582M->529M(1024M), 0.0137341 secs]
2020-10-28T18:06:26.535-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 533M->529M(1024M), 0.0011205 secs]
2020-10-28T18:06:26.536-0800: [GC concurrent-root-region-scan-start]
2020-10-28T18:06:26.537-0800: [GC concurrent-root-region-scan-end, 0.0001615 secs]
2020-10-28T18:06:26.537-0800: [GC concurrent-mark-start]
2020-10-28T18:06:26.538-0800: [GC concurrent-mark-end, 0.0013458 secs]
2020-10-28T18:06:26.538-0800: [GC remark, 0.0017567 secs]
2020-10-28T18:06:26.540-0800: [GC cleanup 539M->531M(1024M), 0.0007936 secs]
2020-10-28T18:06:26.541-0800: [GC concurrent-cleanup-start]
2020-10-28T18:06:26.541-0800: [GC concurrent-cleanup-end, 0.0000144 secs]
执行结束!共生成对象次数:9318
```
### > 4g的情况下，和1g的情况类似，生成10000对象，gc次数明显减少
```
(base)  ✘ yangxinyuan@yPro  ~/java/java_training_camp/workspace/Week01-JVM  java -XX:+UseG1GC -Xms4g -Xmx4g -XX:+PrintGC -XX:+PrintGCDateStamps GCLogAnalysis
正在执行...
2020-10-28T18:07:42.141-0800: [GC pause (G1 Evacuation Pause) (young) 204M->73M(4096M), 0.0225981 secs]
2020-10-28T18:07:42.196-0800: [GC pause (G1 Evacuation Pause) (young) 251M->132M(4096M), 0.0210850 secs]
2020-10-28T18:07:42.244-0800: [GC pause (G1 Evacuation Pause) (young) 310M->196M(4096M), 0.0241248 secs]
2020-10-28T18:07:42.294-0800: [GC pause (G1 Evacuation Pause) (young) 374M->251M(4096M), 0.0220315 secs]
2020-10-28T18:07:42.343-0800: [GC pause (G1 Evacuation Pause) (young) 429M->303M(4096M), 0.0203361 secs]
2020-10-28T18:07:42.390-0800: [GC pause (G1 Evacuation Pause) (young) 481M->367M(4096M), 0.0253246 secs]
2020-10-28T18:07:42.441-0800: [GC pause (G1 Evacuation Pause) (young) 545M->425M(4096M), 0.0226157 secs]
2020-10-28T18:07:42.491-0800: [GC pause (G1 Evacuation Pause) (young) 619M->488M(4096M), 0.0235743 secs]
2020-10-28T18:07:42.570-0800: [GC pause (G1 Evacuation Pause) (young) 758M->573M(4096M), 0.0323041 secs]
2020-10-28T18:07:42.643-0800: [GC pause (G1 Evacuation Pause) (young) 845M->658M(4096M), 0.0298137 secs]
执行结束!共生成对象次数:10292
```





## 4G的堆内存下，压测
```
java -XX:+UseSerialGC -Xms4g -Xmx4g -jar gateway-server-0.0.1-SNAPSHOT.jar
(base)  yangxinyuan@yPro  ~  wrk -c40 -d30s  http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.23ms   18.77ms 268.37ms   93.89%
    Req/Sec    10.90k     3.98k   21.93k    64.60%
  648792 requests in 30.06s, 77.46MB read
Requests/sec:  21582.84
Transfer/sec:      2.58MB

java -XX:+UseParallelGC -Xms4g -Xmx4g -jar gateway-server-0.0.1-SNAPSHOT.jar
(base)  yangxinyuan@yPro  ~  wrk -c40 -d30s  http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.30ms   15.18ms 350.87ms   95.05%
    Req/Sec    15.55k     6.43k   38.97k    69.63%
  924259 requests in 30.03s, 110.35MB read
Requests/sec:  30773.14
Transfer/sec:      3.67MB

java -XX:+UseConcMarkSweepGC -Xms4g -Xmx4g -jar gateway-server-0.0.1-SNAPSHOT.jar
(base)  yangxinyuan@yPro  ~  wrk -c40 -d30s  http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     5.55ms   18.35ms 309.57ms   93.81%
    Req/Sec    17.33k     8.06k   33.69k    57.69%
  1031959 requests in 30.08s, 123.21MB read
Requests/sec:  34304.47
Transfer/sec:      4.10MB


 java -XX:+UseG1GC -Xms4g -Xmx4g -jar gateway-server-0.0.1-SNAPSHOT.jar
(base)  yangxinyuan@yPro  ~  wrk -c40 -d30s  http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     6.75ms   19.18ms 261.17ms   92.47%
    Req/Sec    12.64k     5.72k   25.85k    63.30%
  750112 requests in 30.02s, 89.56MB read
Requests/sec:  24985.22
Transfer/sec:      2.98MB
```
## 512m堆内存，压测
```
java -XX:+UseSerialGC -Xms512m -Xmx512m -jar gateway-server-0.0.1-SNAPSHOT.jar
(base)  yangxinyuan@yPro  ~  wrk -c40 -d30s  http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.35ms   11.96ms 226.03ms   95.63%
    Req/Sec    17.20k     6.83k   36.22k    63.65%
  1024168 requests in 30.06s, 122.28MB read
Requests/sec:  34070.07
Transfer/sec:      4.07MB



java -XX:+UseParallelGC -Xms512m -Xmx512m -jar gateway-server-0.0.1-SNAPSHOT.jar
(base)  ✘ yangxinyuan@yPro  ~  wrk -c40 -d30s  http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.59ms   15.43ms 246.60ms   94.23%
    Req/Sec    16.87k     7.35k   29.98k    61.20%
  1005258 requests in 30.08s, 120.02MB read
Requests/sec:  33416.47
Transfer/sec:      3.99MB





java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -jar gateway-server-0.0.1-SNAPSHOT.jar

(base)  yangxinyuan@yPro  ~  wrk -c40 -d30s  http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.45ms   11.87ms 213.30ms   95.48%
    Req/Sec    16.00k     6.74k   29.85k    63.55%
  953407 requests in 30.06s, 113.83MB read
Requests/sec:  31712.52
Transfer/sec:      3.79MB




 java -XX:+UseG1GC -Xms512m -Xmx512m -jar gateway-server-0.0.1-SNAPSHOT.jar
(base)  yangxinyuan@yPro  ~  wrk -c40 -d30s  http://localhost:8088/api/hello
Running 30s test @ http://localhost:8088/api/hello
  2 threads and 40 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.57ms   15.34ms 307.90ms   94.37%
    Req/Sec    15.75k     7.06k   37.04k    57.86%
  938347 requests in 30.08s, 112.03MB read
Requests/sec:  31190.43
Transfer/sec:      3.72MB
```

## 总结

- 堆内存越大，GC次数越少
- 堆内存对程序性能的影响有个阈值，查过这个阈值，加大内存堆程序影响不大
- SerialGC 压测，出乎意料的优秀
- ParallelGC 压测，吞吐量提升，延迟降低
- ConcMarkSweepGC 压测，吞吐量明显提升
- G1GC 压测 ，吞吐量不明显


