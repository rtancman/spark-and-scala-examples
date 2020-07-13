name := "scala-spark-class1"
organization := "com.sundogsoftware"
version := "0.1"
scalaVersion := "2.12.11"
exportJars := true
mainClass := Some("com.sundogsoftware.spark.MainScala")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.0.0",
  "org.apache.spark" %% "spark-sql" % "3.0.0"
)