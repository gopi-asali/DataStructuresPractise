import org.apache.spark.broadcast.Broadcast
import org.apache.spark.sql.{Column, DataFrame, SparkSession}
import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.{col, lit, udf}
import org.apache.spark.sql.types.{DataType, StringType}

import scala.collection.parallel.mutable

object IngsApp {

  //   Functions to avoid multiple ref initiations
  val castOpe: String => DataType => Column = columnName =>
    col(columnName).cast(_)

  def main(args: Array[String]): Unit = {

    val spark: SparkSession =
      SparkSession.builder().appName("INGS").master("local[*]").getOrCreate()

    val localMap = Map("india" -> "Asia")

    val x= "sadasd"

    val regionBC: Broadcast[Map[String, String]] =
      spark.sparkContext.broadcast[Map[String, String]](Map("india" -> "Asia"))
    import spark.implicits._

    val df: DataFrame = spark.sparkContext
      .parallelize(
        Seq(("gopi", 24, "India"), ("ramesh", 42, "UnitedArabEmirates"))
      )
      .toDF("name", "age", "country")

    df.show()



    val finalDf = df.columns.foldLeft(df)((df,columnName) =>{
      val replacedColumn = columnName.replaceAll("","")
      df.withColumnRenamed(columnName,replacedColumn )

    })



//    UDF Functions
    def regionFinderUDF: UserDefinedFunction =
      udf((country: String) => {
//        regionBC.value.getOrElse(country.trim.toLowerCase, null)
        println(x)
        localMap.getOrElse(country.trim.toLowerCase, null)

      })
    val finalColumns: Array[Column] = df.columns.map(col) :+ regionFinderUDF(
      col("country")
    ).as("region")



    df.select(finalColumns: _*)
      .withColumn("agString", castOpe("age")(StringType))
      .addNullColumns(Seq("cty"))
      .show()

  }

//  Implicit classes
  implicit class DataFrameUtils(df: DataFrame) {

    def addNullColumns(columnsList: Seq[String]): DataFrame = {
      val columns = df.columns ++ columnsList.map(column => s"null as $column")
      df.selectExpr(columns: _*)
    }

  }

}
