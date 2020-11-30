package kr.hs.emirim.s2019s11.mirimimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCall = findViewById(R.id.btn_call);
        Button btnPage = findViewById(R.id.btn_homepage);
        Button btnMap = findViewById(R.id.btn_map);
        Button btnSearch = findViewById(R.id.btn_search);
        Button btnSms = findViewById(R.id.btn_sms);
        Button btnCamera = findViewById(R.id.btn_camera);

        btnCall.setOnClickListener(btnListener);
        btnPage.setOnClickListener(btnListener);
        btnMap.setOnClickListener(btnListener);
        btnSearch.setOnClickListener(btnListener);
        btnSms.setOnClickListener(btnListener);
        btnCamera.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            Uri uri = null;
            switch (v.getId()) {
                case R.id.btn_call:
                    uri = Uri.parse("tel:01033337777");
                    intent = new Intent(Intent.ACTION_DIAL, uri);
                    break;
                case R.id.btn_homepage:
                    uri = Uri.parse("http://www.naver.com");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_map:
                    uri = Uri.parse("http://maps.google.com/maps?q=37.46642616688836,126.93282216760826");
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    break;
                case R.id.btn_search:
                    intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra(SearchManager.QUERY, "미림정보과학고");
                    break;
                case R.id.btn_sms:
                    uri = Uri.parse("smsto:"+Uri.encode("010-7777-1235"));
                    intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body", "안녕하세요? 여러분...");
                    intent.setData(uri);
                    break;
                case R.id.btn_camera:
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    break;
            }
            startActivity(intent);
        }
    };
}