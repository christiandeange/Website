package sh.christian.website.composable

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.ATarget.Blank
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.AttrBuilderContext
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement
import sh.christian.website.icon.EmailIcon
import sh.christian.website.icon.GitHubIcon
import sh.christian.website.sheet.MyResume
import sh.christian.website.sheet.MyResume.flex1
import sh.christian.website.sheet.MyResume.flex2
import sh.christian.website.sheet.MyResume.infocolumn
import sh.christian.website.sheet.MyResume.inforow
import sh.christian.website.sheet.MyResume.links
import sh.christian.website.sheet.MyResume.name
import sh.christian.website.sheet.MyResume.phoneCentered
import sh.christian.website.sheet.MyResume.resumeHeader
import kotlin.text.Typography.nbsp

@Composable
fun MyResume(
  attrs: AttrBuilderContext<HTMLElement>? = null,
) {
  Style(MyResume)

  Div(attrs) {
    Div(attrs = { classes(resumeHeader) }) {
      Name()
      Links()
    }

    Div(attrs = { classes(inforow) }) {
      Div(attrs = { classes(infocolumn, flex1) }) {
        Sidebar()
      }
      Div(attrs = { classes(infocolumn, flex2) }) {
        WorkHistory()
      }
    }
  }
}

@Composable
private fun Name() {
  Div(attrs = { classes(name) }) {
    Text("christian de${nbsp}angelis")
  }
}

@Composable
private fun Links() {
  Div(attrs = { classes(links) }) {
    Link {
      GitHubIcon()
      A(
        href = "https://github.com/christiandeange",
        attrs = { target(Blank) },
      ) {
        Text("christiandeange")
      }
    }

    Link {
      EmailIcon()
      A(
        href = "mailto:me@christian.sh",
        attrs = { target(Blank) },
      ) {
        Text("me@christian.sh")
      }
    }
  }
}

@Composable
private fun Sidebar() {
  Section("Skills") {
    Div(attrs = { classes(phoneCentered) }) {
      Skill("Kotlin", 5)
      Skill("Java", 5)
      Skill("Gradle", 5)
      Skill("Bash", 4)
      Skill("Python", 3)
    }
    Br()
  }

  Section("Education") {
    Job("University of Waterloo", "2016") {
      Point("Bachelor of Software Engineering")
      Point("Graduated with Distinction")
    }
  }

  Section("Patents") {
    Job(
      {
        A(
          href = "https://patents.google.com/patent/US20220237580A1",
          attrs = { target(Blank) },
        ) {
          Text("US 2022/0237580 A1")
        }
      }, "2022"
    ) {
      Point(
        "Multi-device authorization."
      )
    }

    Job(
      {
        A(
          href = "https://patents.google.com/patent/US11216795B2",
          attrs = { target(Blank) },
        ) {
          Text("US 11216795 B2")
        }
      }, "2019"
    ) {
      Point(
        "Pairing merchant Point${nbsp}of${nbsp}Sale with payment${nbsp}reader${nbsp}terminal " +
            "via server Application${nbsp}Programming${nbsp}Interface."
      )
    }
  }
}

@Composable
private fun WorkHistory() {
  Section("Work") {
    Job("Software Engineer | Stripe", "2022 – present") {
      Point("Enhancing the Terminal integration experience, building the product that developers use to create in-person payment flows. Maintaining the Terminal SDK for Android, the Terminal docs, and building internal- and external-facing tools to help developers build better integrations.")
    }

    Job("Senior Android Engineer | Square", "2020 – 2022") {
      Point {
        Text("Started development of ")
        A(
          href = "https://developer.squareup.com/docs/terminal-api/overview",
          attrs = { target(Blank) },
        ) {
          Text("Terminal API")
        }
        Text(" to enable merchants with their own existing point of sale system to take payments with Square Terminal. Assisted in maintaining our Gradle Enterprise instance and creating internal build tools for developer efficiency and dependency management.")
      }
    }

    Job("Android Engineer | Square", "2017 – 2020") {
      Point {
        Text("Developing new features addressing the needs of small businesses and individual sellers using ")
        A(
          href = "https://squareup.com/payments",
          attrs = { target(Blank) },
        ) {
          Text("Square Point of Sale")
        }
        Text(". Designed a native onboarding experience for Canadian sellers.")
      }
    }

    Job("Android Developer | CareZone", "2016 – 2017") {
      Point("Developed an internal app for inventory management that performs barcode scanning and recording a user's signature. Took full responsibility for development, testing, and distribution for internal employees.")
    }

    Job("Android Developer Intern | CareZone", "2015") {
      Point("Integrated features using the Google Places Android API, and developed a new feature enabling users to track their vitals and visualize their recorded history.")
    }

    Job("Software Engineering Intern | Google", "2014") {
      Point("Worked with multiple teams on designing and creating new Google Play Services APIs. Redesigned the Play Services permissions flow to conform to Material Design.")
    }

    Job("Android Developer Intern | CareZone", "2013") {
      Point("Worked with a small team of developers and designers to build an app from the ground up that allows users to manage health information for their loved ones.")
    }
  }
}
