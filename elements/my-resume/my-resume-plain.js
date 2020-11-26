import { html } from '@polymer/polymer/lib/utils/html-tag.js';
import { PolymerElement } from '@polymer/polymer/polymer-element.js';

import '../progress-dots/progress-dots.js';

class MyResumePlain extends PolymerElement {
  static get template() {
    return html`
  <style>
  a {
    color: #000000;
    text-decoration: none;
  }

  .header {
    font-size: 1.3em;
    text-decoration: none;
    color: #555;
    font-weight: 100;
    margin-bottom: 10px;
  }

  .job {
    font-size: 0.8em;
    line-height: 1.5em;
  }

  .skill {
    width: 75px;
    display: inline-block;
  }

  .inforow {
    display: flex;
  }

  .infocolumn {
    display: inline-block;
    vertical-align: text-top;
  }

  .header {
    padding-top: 30px;
  }

  .flex1 { flex: 1; }
  .flex2 { flex: 2; }
  .flex3 { flex: 3; }
  .flex4 { flex: 4; }
  .flex5 { flex: 5; }
  .flex6 { flex: 6; }
  .flex7 { flex: 7; }
  .flex8 { flex: 8; }
  .flex9 { flex: 9; }
  .flex10 { flex: 10; }

  .point {
    display: block;
    font-weight: normal;
  }

  .position {
    font-weight: 500;
    margin-right: 8px;
  }

  .date {
    color: #777;
    font-style: italic;
  }

  /* Phone */
  @media screen and (max-width: 699px) {
    .inforow {
      display: block;
    }

    .infocolumn {
      width: 100%;
    }

    .header, .center-when-small {
      text-align: center;
    }
  }
  </style>

  <div>
    <div class="spacer"></div>

    <div class="inforow">
      <div class="infocolumn flex1">
        <div class="header">skills</div>

        <div class="center-when-small">
          <div class="job point">
            <div class="skill">kotlin</div>
            <progress-dots dots="blue blue blue blue blue"></progress-dots>
          </div>
          <div class="job point">
            <div class="skill">java</div>
            <progress-dots dots="blue blue blue blue blue"></progress-dots>
          </div>
          <div class="job point">
            <div class="skill">python</div>
            <progress-dots dots="blue blue blue blue grey"></progress-dots>
          </div>
          <div class="job point">
            <div class="skill">bash</div>
            <progress-dots dots="blue blue blue blue grey"></progress-dots>
          </div>
          <div class="job point">
            <div class="skill">ruby</div>
            <progress-dots dots="blue blue blue grey grey"></progress-dots>
          </div>
        </div>
      </div>

      <div class="infocolumn flex2">
        <div class="header">work</div>

        <div class="">
          <span class="job position">Android Engineer | Square</span>
          <span class="job date">2017 – present</span>
        </div>

        <div class="job point">Developing new features addressing the needs of businesses and individual sellers using Square Point of Sale. Designed a native onboarding experience for Canadian sellers. Started development of <a href="https://developer.squareup.com/docs/terminal-api/overview">Terminal API</a> for anyone to take payments with Square Terminal.</div>

        <br>

        <div class="">
          <span class="job position">Android Developer | CareZone</span>
          <span class="job date">2016 – 2017</span>
        </div>

        <div class="job point">Developed an internal app for inventory management that performs barcode scanning and recording a user's signature. Took full responsibility for development, testing, and internal distribution.</div>

        <br>

        <div class="">
          <span class="job position">Android Developer Intern | CareZone</span>
          <span class="job date">2015</span>
        </div>

        <div class="job point">Integrated features using the Google Places Android API, and developed a new feature enabling users to track their vitals and visualize their recorded history.</div>

        <br>

        <div class="">
          <span class="job position">Software Engineering Intern | Google</span>
          <span class="job date">2014</span>
        </div>

        <div class="job point">Worked with multiple teams on designing and creating new Google Play Services APIs. Redesigned the Play Services permissions flow to conform to Material Design.</div>

        <br>
        <div class="">
          <span class="job position">Android Developer Intern | CareZone</span>
          <span class="job date">2013</span>
        </div>

        <div class="job point">Worked with a small team of developers and designers to build an app from the ground up that allows users to manage health information for their loved ones.</div>
      </div>
    </div>

    <div class="inforow">
      <div class="infocolumn flex1">
        <div class="header">education</div>

        <div class="center-when-small">
          <span class="job position">University of Waterloo</span>
          <span class="job date">2016</span>
        </div>

        <div class="job point center-when-small">Bachelor of Software Engineering</div>
        <div class="job point center-when-small">Graduated with Distinction</div>
      </div>

      <div class="infocolumn flex2">
        <div class="header">android projects</div>

        <div class="job position"><a href="https://github.com/christiandeange/hubbub" target="blank">Hubbub</a></div>
        <div class="job point">Monitors GitHub's website + API status and sends push notifications to your Android device when GitHub experiences technical difficulties.</div>
        <br>

        <div class="job position"><a href="https://github.com/christiandeange/uwaterloo-api" target="blank">UWaterloo API</a></div>
        <div class="job point">Comprehensive Android wrapper library for the UWaterloo Open Data API, giving access to course information, food locations, events, and more.</div>
        <br>

      </div>
    </div>

  </div>
`;
  }

  static get is() { return 'my-resume-plain'; }
  static get properties() { return {}; }
}

customElements.define(MyResumePlain.is, MyResumePlain);
