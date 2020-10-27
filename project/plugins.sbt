// assembly
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")
// scripted plugin for testing sbt plugins
libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value
