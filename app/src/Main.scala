import java.lang
import java.nio.file.Files

import scala.io.Codec

object Main {

  def main(args: Array[String]): Unit = {
    val classLoader = Main.getClass.getClassLoader
    val clt = classLoader.loadClass("play.twirl.compiler.TwirlCompiler")
    val module = classLoader.loadClass("play.twirl.compiler.TwirlCompiler$").getField("MODULE$")
    val compileMethod = clt.getMethods.find(_.getName == "compile").get
    val temporaryPath = Files.createTempDirectory("twirl")
    val temporaryDirector = temporaryPath.toFile
    compileMethod.invoke(module,
      new java.io.File(Main.getClass.getResource("./views/hello.scala.html").toURI),
      new java.io.File(Main.getClass.getResource("./views").toURI),
      temporaryDirector,
      "html",
      Seq.empty,
      Seq.empty,
      Codec.UTF8,
      new lang.Boolean(false))
    println(s"Compilation success: $temporaryPath/html/hello.template.scala")
  }
}
