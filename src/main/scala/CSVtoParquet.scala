import org.apache.spark.sql.SparkSession

case class CoinbaseHourlyETHUSD(
  date: String,
  symbol: String,
  open: Double,
  high: Double,
  low: Double,
  close: Double,
  volumeETH: Double,
  volumeUSD: Double
)

object CSVtoParquet {
  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("CSV to Parquet").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
