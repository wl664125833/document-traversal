package com.wanglei.util

import java.io.File
import scala.io.Source
import scala.util.matching.Regex
import java.lang.String
import util.control.Breaks._
import java.lang.Exception
object subDir2 {
  //遍历某目录下所有的文件和子文件  
  val regex = new Regex("(P|p)(M|m)(A|a)(R|r)(T|t)")
//    var path = "E:\\eclipse_work\\nmcccimweb\\WebRoot\\nmcc15\\jsp\\report\\"
  var path = "D:\\www\\"
  def main(args: Array[String]) : Unit = {
      
      try {
        for (d <- subDir(new File(path))) {
          breakable {
            var prefix = d.getName().substring(d.getName().lastIndexOf(".") + 1)
            if (prefix.equals("jsp") || prefix.equals("JSP")) {
              val source = Source.fromFile(d)
              if(source == null) break()
              val lines = source.getLines
              for (line <- lines) {
                if (!((regex.findFirstIn(line)).isEmpty)) {
                  println("文件名：" + d.getParent + "\t宏：" + line)
                  break()
                }
              }
              source.close //记得要关闭source 
            }else{
              break()
            }
          }
        }
      } catch {
          case t: Exception=>  t.printStackTrace()
      }
  }
  //遍历目录与文件
  def subDir(dir: File): Iterator[File] = {
    val dirs = dir.listFiles().filter(_.isDirectory())
    val files = dir.listFiles().filter(_.isFile())
    files.toIterator ++ dirs.toIterator.flatMap(subDir _)
  }
  //获取文件中的制字符
  def getChar(): Unit = {
    val fileName = "d:\\scalaTestFile.txt"
    val source = Source.fromFile(fileName)

    for (c <- source) {
      println(c)
    }
  }
}