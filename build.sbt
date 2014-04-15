// Project info

name := "play-java8-presentation"

organization := "au.id.jazzy"

version := "2.0.0-SNAPSHOT"

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

// Dependencies
libraryDependencies ++= Seq(
    "com.typesafe.play" %% "play-java" % "2.3-M1",
    "com.typesafe.play" %% "play-java-ws" % "2.3-M1"
)


