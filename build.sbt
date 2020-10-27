import sbt._

Global / onChangedBuildSource := ReloadOnSourceChanges

/** @note Scala 2.12 because [[SbtPlugin]] requires [[ScriptedPlugin]] that doesn't yet support 2.13. */
Global / scalaVersion := "2.12.12"

lazy val scriptedSettings = Def.settings(
  // is this guy the same as `.enablePlugins(SbtPlugin)` ?
  sbtPlugin := true,
  // default is sbt-test
  sbtTestDirectory := sourceDirectory.value / "sbt-test",
  // add plugin version as a system property
  scriptedLaunchOpts := {
    scriptedLaunchOpts.value ++
      Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
  },
  scriptedBufferLog := false
)


lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin, AssemblyPlugin)
  .settings(
    scriptedSettings,
    name := "poc-sbt-plugin",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.12.12"
  )


// addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.15.0")
