package com.github.fpopic.my_sbt_plugin

import sbt.Keys._
import sbt.{Def, _}
import sbtassembly.AssemblyPlugin

object MySbtPlugin extends AutoPlugin {
  override def requires: Plugins = AssemblyPlugin

  override def trigger: PluginTrigger = noTrigger

  object autoImport {
    lazy val doSomething = taskKey[Unit]("Does something")
  }

  import autoImport._

  override def projectSettings: Seq[Def.Setting[_]] = Def.settings(
    doSomething := Def.task {
      val log = sbt.Keys.sLog.value
      log.info("Doing something...")
    }.value
  )

}
