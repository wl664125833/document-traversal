//遍历某目录下所有的子目录  
import java.io.PrintWriter  
import java.io.File  
import scala.reflect.io.Directory  
  
object subDir{  
  def main(args:Array[String]):Unit = {  
      for(d <- subDir(new File("d:\\file\\")))  
        println(d)  
  }  
   
  def subDir(dir:File):Iterator[File] ={  
    val children = dir.listFiles().filter(_.isDirectory())  
    children.toIterator ++ children.toIterator.flatMap(subDir _)  
  } 
  
}  
  
