package br.com.rtancman

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object ElasticsearchSpark {

  def getSparkSession(
      sparkHost: String,
      elasticHost: String,
      elasticPort: String
  ): SparkSession = {
    SparkSession
      .builder()
      .appName("elasticsearch-spark-example-1")
      .master(sparkHost)
      .config("es.nodes", elasticHost)
      .config("es.port", elasticPort)
      .getOrCreate()
  }

  def main(args: Array[String]) {
    if (args.length < 3) {
      println(
        """[Error] Needs spark master address, elasticsearch host and port arguments.
          |   Usage: spark-submit ... local[*] localhost 9200 someDataSet.parquet
          |""".stripMargin
      )
      System.exit(1)
    }

    val sparkHost :: elasticHost :: elasticPort :: datasetPath :: _ =
      args.map(_.toString()).toList

    val spark = getSparkSession(sparkHost, elasticHost, elasticPort)

    import spark.implicits._

    val df = spark.read.parquet(datasetPath)

    df.write
      .format("org.elasticsearch.spark.sql")
      .option("es.resource", "elasticsearch-spark-example-1")
      .option("es.write.operation", "upsert")
      .option("es.index.auto.create", "true")
      .option("es.nodes.wan.only", "true")
      .option("es.mapping.id", "id")
      .option("es.spark.dataframe.write.null", "true")
      .save()

    spark.close()
  }
}
