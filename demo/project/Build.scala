import org.oedura.scavro.plugin.AvroCodegenPlugin
import sbt._
import sbt.Keys._
import AvroCodegenPlugin.autoImport._


object DemoBuild extends Build {
  lazy val demoSettings = baseAvroCodegenSettings ++ Seq(
    // General settings
    organization := "org.oedura",
    name := "scavrodemo",
    version := "1.0.1",
    scalaVersion := "2.10.4",
    libraryDependencies ++= Seq(
      "org.oedura" %% "scavro" % "1.0.1",
      "org.apache.avro" % "avro" % "1.7.7",
      "org.apache.avro" % "avro-tools" % "1.7.7",
      "org.scalatest" %% "scalatest" % "2.2.4" % "test"
    ),

    resolvers ++= Seq(
      //       "Local Maven" at Path.userHome.asFile.toURI.toURL + ".ivy2/local",
      Resolver.sonatypeRepo("releases"),
      Resolver.sonatypeRepo("snapshots")
    ),

    // scavro plugin settings
    avroSchemaFiles := Seq(
      (resourceDirectory in Compile).value / "item.avsc"
    ),

    mainClass in (Compile, run) := Some("org.oedura.scavrodemo.ReadWriteDemo")
  )

  lazy val root = Project(id = "demo", base = file("."))
    .settings(demoSettings: _*)
    .settings(excludeFilter in unmanagedResources := "*.avsc")
}
