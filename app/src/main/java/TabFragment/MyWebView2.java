package TabFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.paris8.rapido.slide_menu.R;

/**
 * Created by Rapido on 12/11/2016.
 */

public class MyWebView2 extends Fragment {

    private WebView webView;
    private String link;

    public MyWebView2 ()
    {
        this.link = "https://accounts.google.com/ServiceLogin?hl=fr";
    }

    public MyWebView2 (String str)
    {
        this.link = str;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.web_layout, container, false);

        webView = (WebView) v.findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl(this.link);
        webView.setWebViewClient(new WebViewClient());

        return v;
    }
}