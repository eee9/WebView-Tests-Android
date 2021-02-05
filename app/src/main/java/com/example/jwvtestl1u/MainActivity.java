package com.example.jwvtestl1u;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

  private WebView webView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    webView = (WebView) findViewById(R.id.webView1);
    webView.setWebChromeClient(new WebChromeClient() {
      // This is for html alert. By default it is disabled.
      @Override
      public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return super.onJsAlert(view, url, message, result);
      }
    });

    webView.getSettings().setJavaScriptEnabled(true);           // for JS
    webView.setWebViewClient(new WebViewClient());              // for all links in the WebView, not a browser intents
    webView.setWebChromeClient(new WebChromeClient());
    webView.setBackgroundColor(Color.CYAN);                    // now it is actual
    //webView.getSettings().setBuiltInZoomControls(true);         // allow zoom
    //webView.getSettings().setDisplayZoomControls(false);        // turn off zoom's controls
    webView.loadUrl("http://www.google.com");
    //webView.loadData("<html><body>Hi me.<hr/><button onclick='alert(10)'>Test</button></body></html>","text/html", "UTF-8");
    //webView.loadData(HTML, "text/html", "UTF-8");
  }

  private String _htmlines(int lines) {
    String res = "";
    for(int i = 1; i <= lines; i++) {
      res += i + ". +html line added for tests.<br/>\n";
    }
    return res;
  }

  private String HTML = "" +
      "<html>\n" +
      "  <meta charset=\"utf-8\" />\n" +
      "  <meta name=\"theme-color\" content=\"#000000\" />\n" +
      "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n" +
      "  <title>L1U. List content</title>\n" +
      "<script>\n" +
      "  function onTest2() {\n" +
      "    var upper = document.getElementById('upper_div');\n" +
      "    upper.style.color = 'black';\n" +
      "  }\n" +
      "  function onTest3() {\n" +
      "    var body_tag = document.getElementById('body_tag');\n" +
      "    if (body_tag.scrollTo) {" +
      "      body_tag.scrollTo({top: 123});\n" +
      "      /* alert('OK.'); */" +
      "    } else {" +
      "      alert('body_tag.scrollTo() not exists !');" +
      "    }" +
      "  }\n" +
      "  function onTest4() {\n" +
      "    window.scrollTo(0, 321);\n" +
      "  }\n" +
      "  function onBScroll() {\n" +
      "    var body_tag = document.getElementById('body_tag');\n" +
      "    var counter_tag = document.getElementById('counter_tag');\n" +
      "    counter_tag.innerHTML = body_tag.scrollTop;\n" +
      "  }\n" +
      "</script>\n" +
      "<body id='body_tag' onscroll='onBScroll();'>" +
      "  <div style='font-size:22px; color:black;'>" +
      "    r01, L25. WebView Tests." +
      "  </div>" +
      "  <button onclick='alert(10);'>alert(10)</button> &nbsp;&nbsp;&nbsp;&nbsp;" +
      "  <button onclick='onTest2();'>upper -> black</button><br/>" +
      "  <button onclick='onTest3();'>body_tag.scrollTo({top: 123})</button><br/>" +
      "  <button onclick='window.scrollTo(0, 231);'>window.scrollTo(0, 231)</button>\n" +
      "  <div id='upper_div' style='font-size:14px; color:green;'>" +
         _htmlines(12) +
      "  </div>" +
      "  <hr/>" +
      "    <div id='counter_tag' style='font-size:22px;color:red;font-weight:bold'>0</div>" +
      "    <button onclick='window.scrollTo(0, 0);'>go top</button>\n" +
      "  <hr/>" +
      "  <div style='font-size:14px; color:blue;'>" +
         _htmlines(75) +
      "  </div>" +
      "</body>" +
      "</html>";
}