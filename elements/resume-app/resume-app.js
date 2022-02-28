import {PolymerElement} from '@polymer/polymer';
import '@polymer/app-route/app-location.js';
import '@polymer/app-route/app-route.js';
import '@polymer/iron-icons/iron-icons.js';
import '@polymer/paper-icon-button/paper-icon-button.js';
import '@polymer/paper-styles/typography.js';

import '../my-resume/my-resume.js';

const $documentContainer = document.createElement('template');

$documentContainer.innerHTML = `<dom-module id="resume-app">

<template>
  <style>

  #my-resume {
    width: calc(100% - 64px);
    height: 100%;
    padding: 0 32px;
    margin: 0px auto;
  }

  #icons {
    padding: 32px;
    position: fixed;
  }

  #icons paper-icon-button {
    border-radius: 50%;
    background-color: white;
    border: solid 1px black;
  }

  @media (min-width: calc(8.5in + 64px)) {
    #my-resume {
      width: 8.5in;
    }
  }

  @media print {
    body {
      background: white;
      overflow: inherit;
    }

    #my-resume {
      width: inherit;
      max-width: inherit;
      max-height: inherit;
      margin: 0 auto;
      background: white;
      overflow: visible;
      position: absolute;
      top: 0;
    }

    #icons {
      display: none;
    }
  }

  </style>

  <app-location route="{{route}}"></app-location>
  <app-route route="{{route}}" pattern="/:path" data="{{routeData}}"></app-route>

  <!-- Main Content -->
  <div class="content">
    <div id="icons">
      <paper-icon-button id="prticon" on-click="tapPrint" icon="print"></paper-icon-button>
    </div>
    <div id="my-resume">
      <my-resume></my-resume>
    </div>
  </div>
</template>


</dom-module>`;

document.head.appendChild($documentContainer.content);

class ResumeApp extends PolymerElement {
  static get is() {return 'resume-app';}

  static get properties() {return {};}

  static get observers() {
    return [
      '_routeChanged(routeData.*)',
    ];
  }

  connectedCallback() {
    super.connectedCallback();

    if (this.route.path === undefined) {
      this.go();
    }
  }

  _routeChanged(changeRecord) {
    var path = changeRecord.value.path || '';
    if (path !== '') {
      this.go();
    }
  }

  go(path) {
    path = path || '';
    this.set('route.path', '/' + path);
  }

  tapPrint() {
    setTimeout(function() {window.print();}, 420);
  }
}

customElements.define(ResumeApp.is, ResumeApp);
