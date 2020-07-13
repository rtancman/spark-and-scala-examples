PROJECT_CLASS?=DegreesOfSeparation
ARGS?=

build:
	sbt build

package: build
	sbt  package

generatejar: build package

spark.run:
	spark-submit --class com.sundogsoftware.spark.$(PROJECT_CLASS) target/scala-2.12/scala-spark-class1_2.12-0.1.jar $(ARGS)