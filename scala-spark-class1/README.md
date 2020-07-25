# spark examples

## datasets
- https://grouplens.org/

## generate jars
```bash
make generatejar
```

## run on cloud
- [Amazon Elastic MapReduce](https://aws.amazon.com/emr/)
- [Dataproc](https://cloud.google.com/dataproc)

## stream examples
- [Twitter live streaming](https://dzone.com/articles/twitter-live-streaming-with-spark-streaming-using)

## Troubleshooting, and Managing Dependencies

1. spark-ui in 127.0.0.1:4040 when you are running scritps on spark. Documentation [here](https://spark.apache.org/docs/latest/monitoring.html).
2. Logs:
    - In standalone mode, they're in the web UI 
    - you need to collect them after the fact using `yarn logs -applicationID <app ID>`
3. Java or Scala package that's not pre-loaded
    - Bundle them into your jar
    - Use `-jars` with `spark-submit`
    
## books
- [Learning Spark](https://www.oreilly.com/library/view/learning-spark/9781449359034/)
- [Learning Scala](https://www.oreilly.com/library/view/learning-scala/9781449368814/)
- [Advanced Analytics with Spark](https://www.oreilly.com/library/view/advanced-analytics-with/9781491912751/)