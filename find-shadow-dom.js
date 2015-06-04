function doFindShadowDOM(selector) {
  var node = undefined;
  var suffix = [ "", " /deep/", "::shadow" ];
  for (var i = 0; i < suffix.length; i++) {
    try {
      node = document.querySelector(selector.replace(/::shadow/g, suffix[i]));
      if (node) {
        break;
      }
    } catch (e) {
      // meh
    }
  }

  return node;
}

function findShadowDOM(selector, fcn, retryIfNone) {
  var node = doFindShadowDOM(selector);
  if (!node && retryIfNone) {
    setTimeout(function() {
      node = doFindShadowDOM(selector);
      if (fcn && node) {
        fcn(node);
      }
    }, 100);

  } else if (node && fcn) {
    fcn(node);
  }
}