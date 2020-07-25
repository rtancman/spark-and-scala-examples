name := "scala-spark-class1"
organization := "com.sundogsoftware"
version := "0.2"
scalaVersion := "2.12.11"
exportJars := true
mainClass := Some("com.sundogsoftware.spark.MainScala")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.0.0",
  "org.apache.spark" %% "spark-sql" % "3.0.0",
  "org.apache.spark" %% "spark-mllib" % "3.0.0",
  "org.twitter4j" % "twitter4j-core" % "4.0.7",
  "org.twitter4j" % "twitter4j-stream" % "4.0.7",
  "org.apache.bahir" %% "spark-streaming-twitter" % "2.4.0"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}
test in assembly := {}
assemblyJarName in assembly := "scala-spark-class-assembly.jar"