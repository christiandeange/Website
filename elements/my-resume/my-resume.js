import '@polymer/iron-icons/iron-icons.js';
import {html} from '@polymer/polymer/lib/utils/html-tag.js';
import {PolymerElement} from '@polymer/polymer/polymer-element.js';

import './my-resume-plain.js';
import '../custom-icons.js';

class MyResume extends PolymerElement {
  static get template() {
    return html`
    <style>

    #first-name {
      margin: 0px 20px;
    }

    .name-container {
      padding: 20px 0px;
      text-align: right;
      height: auto;
    }

    .name-container, page-resume-plain {
      display: block;
    }

    .name {
      width: 100%;
      padding-top: 50px;
      font-size: 3em;
      text-align: right;
      font-family: 'Roboto Slab', 'Lato', 'Roboto', 'Helvetica Neue', Helvetica, Arial, sans-serif;
      font-weight: 300;
      text-transform: lowercase;
    }

    .name span {
      display: inline-block;
    }

    .links {
      margin: 20px 0px 0px 0px;
    }

    div.links iron-icon {
      width: 1.5em;
      height: 1.5em;
      padding: 5px;
      margin-left: 20px;
      margin-right: 5px;
      font-style: normal;
      color: black;
    }

    a {
      text-decoration: none;
      color: black;
    }

    @media print {
      html, body {
        margin: 0px;
        padding: 0px;
        max-width: none;
      }

      my-resume-plain {
        margin-top: 0px;
      }
    }

    </style>

    <div class="name-container">
      <div class="name center-when-small"><span id="first-name">Christian</span><span>De Angelis</span></div>
      <div class="links center-when-small">
        <iron-icon icon="custom-icons:github"></iron-icon><a href="https://github.com/christiandeange" target="blank">christiandeange</a>
        <iron-icon icon="mail"></iron-icon><a href="mailto:me@christian.sh" target="blank">me@christian.sh</a>
      </div>
    </div>

    <my-resume-plain></my-resume-plain>
`;
  }

  static get is() {return 'my-resume';}

  static get properties() {return {};}
}

customElements.define(MyResume.is, MyResume);
