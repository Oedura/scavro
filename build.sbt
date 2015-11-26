// Metadata
organization := "org.oedura"
name := "scavro"
version := "0.9.3-SNAPSHOT"
scalaVersion := "2.10.4"
description := "A thin scala wrapper for reading and writing Avro files"

// Distribution
licenses := Seq("Apache" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
homepage := Some(url("https://github.com/oedura/scavro"))

// Dependencies
resolvers += Resolver.sonatypeRepo("public")
libraryDependencies ++= Seq(
  "org.apache.avro" % "avro" % "1.7.7",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

// Publication
publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  println("isSnapshot: " + isSnapshot.value)
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := {
  <scm>
    <url>git@github.com:oedura/scavro.git</url>
    <connection>scm:git@github.com:oedura/scavro.git</connection>
  </scm>
  <developers>
    <developer>
      <id>BrianLondon</id>
      <name>Brian London</name>
      <url>https://github.com/BrianLondon</url>
    </developer>
  </developers>
}
