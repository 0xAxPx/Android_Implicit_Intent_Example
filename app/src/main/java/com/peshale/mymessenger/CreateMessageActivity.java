package com.peshale.mymessenger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CreateMessageActivity extends AppCompatActivity {

    private static Intent intent;

    static {
        intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onClickTwitter(View view) {
        String message = getMessage();
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo("com.twitter.android", PackageManager.GET_META_DATA);
            intent.setPackage("com.twitter.android");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, getString(R.string.chooser)));
        } catch (PackageManager.NameNotFoundException e) {
            TextView textView = findViewById(R.id.errorText);
            textView.setText("Twitter is not installed on your device!");
        }
    }

    public void onClickWhatsApp(View view) {
        String message = getMessage();
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            intent.setPackage("com.whatsapp");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, getString(R.string.chooser)));
        } catch (PackageManager.NameNotFoundException e) {
            TextView textView = findViewById(R.id.errorText);
            textView.setText("WhatsApp is not installed on your device!");
        }
    }

    public void onClickGmail(View view) {
        String message = getMessage();
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo("com.google.android.gm", PackageManager.GET_META_DATA);
            intent.setPackage("com.google.android.gm");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(intent, getString(R.string.chooser)));
        } catch (PackageManager.NameNotFoundException e) {
            TextView textView = findViewById(R.id.errorText);
            textView.setText("Gmail is not installed on your device!");
        }
    }

    private String getMessage() {
        EditText editText = findViewById(R.id.message);
        return editText.getText().toString();
    }
}