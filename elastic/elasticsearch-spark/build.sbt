import Dependencies._
import ExcludeDependencies._

ThisBuild / scalaVersion := "2.12.16"
ThisBuild / version := "1.0.0"
ThisBuild / organization := "br.com.rtancman"
ThisBuild / organizationName := "rtancman"
ThisBuild / assembly / assemblyMergeStrategy := {
  case PathList("META-INF", _*) => MergeStrategy.discard
  case "application.conf"       => MergeStrategy.concat
  case "reference.conf"         => MergeStrategy.concat
  case _                        => MergeStrategy.first
}

lazy val root = (project in file("."))
  .settings(
    name := "elasticsearch-spark-examples",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      elasticSpark,
      spark,
      sparkSql
    ),
    excludeDependencies ++= Seq(
      sparkCore2_11,
      sparkSQL2_11,
      sparkYarn2_11,
      sparkStreaming2_11
    )
  )