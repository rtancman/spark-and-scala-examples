MASTER_ADDRESS?=local[*]
ELASTIC_HOST?=localhost
ELASTIC_PORT?=9200
DATASET_PATH?=file:///`pwd`/tmp/features-sample.parquet
ARGS?=$(MASTER_ADDRESS) $(ELASTIC_HOST) $(ELASTIC_PORT) $(DATASET_PATH)
ELASTICSPARK_JARS=target/scala-2.12/elasticsearch-spark-examples-assembly-1.0.0.jar

compile:
	sbt compile

generatejar: compile
	sbt assembly

spark.shell:
	spark-shell \
	--jars $(ELASTICSPARK_JARS) \
	--conf "es.nodes=localhost" \
	--conf "es.port=9200" \
	--conf "es.write.operation=upsert" \
	--conf "es.index.auto.create=true" \
	--conf "es.mapping.id=id" \

run.containers:
	docker-compose up -d

stop.containers:
	docker-compose kill

run:
	spark-submit \
	--class br.com.rtancman.ElasticsearchSpark \
	--jars $(ELASTICSPARK_JARS) \
	$(ARGS_FEATURES_TO_ELASTIC)