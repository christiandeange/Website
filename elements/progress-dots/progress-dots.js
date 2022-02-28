import {PolymerElement} from '@polymer/polymer/polymer-element.js';
import {html} from '@polymer/polymer/lib/utils/html-tag.js';

var colourMap = {
  'blue': '#3696D2',
  'grey': '#D2D2D2',
};

class ProgressDots extends PolymerElement {
  static get template() {
    return html`
    <style>
      .dot {
        -webkit-print-color-adjust: exact;
        display: inline-block;
        border-radius: 50%;
        margin-left: 3px;
        width: 12px;
        height: 12px;
      }

      dom-bind {
        display: inherit !important;
      }
    </style>

    <dom-bind>
      <template is="dom-repeat" items="{{dotsArray}}">
        <div class="dot" style\$="background: {{item}};"></div>
      </template>
    </dom-bind>
`;
  }

  static get is() {return 'progress-dots';}
  static get properties() {
    return {
      dots: {
        type: String,
        value: '',
      },
    };
  }

  ready() {
    super.ready();
    this.dotsArray = this.dots.split(' ').map(function(item) {
      return colourMap[item] || item;
    });
  }
}

customElements.define(ProgressDots.is, ProgressDots);
