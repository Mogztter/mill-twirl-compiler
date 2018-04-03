// build.sc
import mill._
import mill.scalalib._

object app extends ScalaModule {
  def scalaVersion = "2.12.4"
  def twirlVersion = "1.3.15"
  override def ivyDeps = Agg(
    ivy"com.typesafe.play::twirl-compiler:$twirlVersion",
    ivy"org.scala-lang.modules::scala-parser-combinators:1.1.0"
  )
}