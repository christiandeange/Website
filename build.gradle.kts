plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

group = "sh.christian.website"
version = "3.0.0"

kotlin {
  js(IR) {
    browser {
      commonWebpackConfig {
        cssSupport { enabled.set(true) }
        scssSupport { enabled.set(true) }
      }
      runTask {
        sourceMaps = true
      }

      testTask {
        testLogging.showStandardStreams = true
        useKarma {
          useChromeHeadless()
          useFirefox()
        }
      }
    }
    binaries.executable()
  }
  sourceSets {
    val jsMain by getting {
      dependencies {
        implementation(compose.runtime)
        implementation(compose.web.core)
        implementation(compose.web.svg)
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
        "--version", "3",
      )
    }
  }
}

tasks.register<DeployTask>("deploy") {
  dependsOn(tasks.named("jsBrowserDistribution"))
  inputFolder.set(project.extensions.getByType<BasePluginExtension>().distsDirectory)
}
