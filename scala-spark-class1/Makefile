PROJECT_CLASS?=DegreesOfSeparation
ARGS?=

compile:
	sbt compile

package:
	sbt  package

generatejar: compile package

spark.run:
	spark-submit --class com.sundogsoftware.spark.$(PROJECT_CLASS) target/scala-2.12/scala-spark-class1_2.12-0.1.jar $(ARGS)