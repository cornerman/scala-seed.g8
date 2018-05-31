inThisBuild(Seq(
  organization := "com.github.cornerman",
  version      := "0.1.0-SNAPSHOT",

  scalaVersion := "2.12.6",
  crossScalaVersions := Seq("2.11.12", "2.12.4"),

  resolvers ++=
    ("jitpack" at "https://jitpack.io") ::
    Nil
))

lazy val commonSettings = Seq(
  scalacOptions ++=
    "-encoding" :: "UTF-8" ::
    "-unchecked" ::
    "-deprecation" ::
    "-explaintypes" ::
    "-feature" ::
    "-language:_" ::
    "-Xfuture" ::
    "-Xlint" ::
    "-Ypartial-unification" ::
    "-Yno-adapted-args" ::
    "-Ywarn-infer-any" ::
    "-Ywarn-value-discard" ::
    "-Ywarn-nullary-override" ::
    "-Ywarn-nullary-unit" ::
    Nil,

  scalacOptions ++= {
    CrossVersion.partialVersion(scalaVersion.value) match {
      case Some((2, 12)) =>
        "-Ywarn-extra-implicit" ::
        Nil
      case _ =>
        Nil
    }
  },

  addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.7")
)

enablePlugins(ScalaJSPlugin)

lazy val root = (project in file("."))
  .aggregate(helloJS, helloJVM)
  .settings(commonSettings)

lazy val hello = crossProject
  .settings(commonSettings)
  .settings(
    name := "hello",
    libraryDependencies ++=
      Deps.scalaTest.value % Test ::
      Nil
  )

lazy val helloJS = hello.js
lazy val helloJVM = hello.jvm
