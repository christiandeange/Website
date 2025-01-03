import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalDistributionDsl

plugins {
  kotlin("multiplatform")
  kotlin("plugin.compose")
  id("org.jetbrains.compose")
}

group = "sh.christian.website"
version = "3.0.0"

val distributions = extensions.getByType<BasePluginExtension>().distsDirectory

kotlin {
  js(IR) {
    browser {
      @OptIn(ExperimentalDistributionDsl::class)
      distribution {
        outputDirectory = distributions
      }
    }
    binaries.executable()
  }
  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(compose.runtime)
        implementation(compose.html.core)
        implementation(compose.html.svg)
      }
    }
  }
}

abstract class DeployTask
@Inject constructor(
  objects: ObjectFactory,
  private val execOperations: ExecOperations,
) : DefaultTask() {
  @get:Input
  @get:Option(
    option = "project-id",
    description = "The ID of the project to upload the site to",
  )
  val projectId: Property<String> = objects.property()

  @get:Input
  @get:Option(
    option = "promote",
    description = "Promote this deploy to make this the main service",
  )
  val promote: Property<Boolean> = objects.property<Boolean>().convention(false)

  @get:Input
  @get:Option(
    option = "version",
    description = "The version of the service to deploy",
  )
  val version: Property<String> = objects.property()

  @get:InputDirectory
  @get:PathSensitive(PathSensitivity.RELATIVE)
  val inputFolder: DirectoryProperty = objects.directoryProperty()

  @TaskAction
  fun deployProject() {
    execOperations.exec {
      workingDir(inputFolder.asFile.get())
      commandLine(
        "gcloud", "app", "deploy",
        "--project", projectId.get(),
        if (promote.get()) "--promote" else "--no-promote",
        "--version", version.get(),
      )
    }
  }
}

tasks.register<DeployTask>("deploy") {
  dependsOn(tasks.named("jsBrowserDistribution"))

  inputFolder = distributions
  version = project.version.toString().substringBefore('.')
}
