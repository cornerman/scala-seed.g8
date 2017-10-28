import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Deps {
  // hack to expand %%% in settings, needs .value in build.sbt
  import Def.{setting => dep}

  val scalaTest = dep("org.scalatest" %%% "scalatest" % "3.0.4")
  val shapeless = dep("com.chuusai" %%% "shapeless" % "2.3.2")
  val cats = new {
    val core = dep("org.typelevel" %%% "cats-core" % "1.0.0-MF")
  }
  val scalaReflect = dep("org.scala-lang" % "scala-reflect")
}
