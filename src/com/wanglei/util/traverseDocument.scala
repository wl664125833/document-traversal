package com.wanglei.util
import scala.io.Source
object traverseDocument {
  /**
   * 遍历行
   */
  def main(args: Array[String]): Unit = {
    val fileName = "d:\\file\\www33318189509449.xml"
    val source = Source.fromFile(fileName)
    val lines = source.getLines
    for (line <- lines) {
      println(line)
    }
    source.close; //记得要关闭source  
  }
  def getChar():Unit ={
    val fileName = "d:\\scalaTestFile.txt"  
    val source = Source.fromFile(fileName)  
     
    for(c <- source){  
      println(c)  
    }  
  }
  
}