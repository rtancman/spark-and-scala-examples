## Elasticsearch Spark

Some example to use elastic and spark with [elasticsearch-hadoop](https://github.com/elastic/elasticsearch-hadoop).

### How to run local for development

#### 1) Install spark

```bash
wget https://archive.apache.org/dist/spark/spark-3.2.2/spark-3.2.2-bin-hadoop2.7.tgz
tar x spark-3.2.2-bin-hadoop2.7.tgz
export SPARK_HOME=`pwd`/spark-3.2.2-bin-hadoop2.7
export PATH=$PATH:$SPARK_HOME:$SPARK_HOME/bin:$SPARK_HOME/sbin
# test
spark-shell
```

#### 2) Compile spark jobs

```bash
sdk install java 17.0.2-open
sdk use java 17.0.2-open
sdk install scala 2.12.16
sdk use scala 2.12.16
make generatejar
```
**Notes:** The elastic-spark needs to compile with `sdk use java 8.0.275.hs-adpt`.

#### 3) Run project locally
```bash
make run.containers load.parquet-samples generatejar
make run
```