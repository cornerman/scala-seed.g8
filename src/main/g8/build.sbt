inThisBuild(Seq(
  organization := "com.github.cornerman",
  scalaVersion := "2.12.4",
  crossScalaVersions := Seq("2.11.11", "2.12.4"),
  version      := "0.1.0-SNAPSHOT",
  scalacOptions ++=
    "-encoding" :: "UTF-8" ::
    "-unchecked" ::
    "-deprecation" ::
    "-explaintypes" ::
    "-feature" ::
    "-language:_" ::
    "-Xcheckinit" ::
    "-Xfuture" ::
    "-Xlint" ::
    "-Yno-adapted-args" ::
    // "-Ywarn-dead-code" :: // does not work with js.native
    "-Ywarn-unused:-imports,-params,_" :: // -params does not work with js.native
    "-Ywarn-extra-implicit" ::
    "-Ywarn-infer-any" ::
    "-Ywarn-nullary-override" ::
    "-Ywarn-nullary-unit" ::
    Nil
))

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.4")
enablePlugins(ScalaJSPlugin)

lazy val root = (project in file(".")).
  aggregate(helloJS, helloJVM)

lazy val hello = crossProject.
  settings(
    name := "hello",
    libraryDependencies ++=
      Deps.scalaTest.value % Test ::
      Nil
  )

lazy val helloJS = hello.js
lazy val helloJVM = hello.jvm
