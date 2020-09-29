package com.example.saffy.a2travel;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SupportActivity extends AppCompatActivity {
    Button contactcall, contactmessage;
    TextView telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        contactcall = findViewById(R.id.contactcall);
        contactmessage = findViewById(R.id.contactmessage);
        telephone = findViewById(R.id.telephone);

        final Intent call = new Intent(Intent.ACTION_VIEW);
        contactcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call.setData(Uri.parse("tel:" + 555));
                startActivity(call);
            }
        });
        final Intent message = new Intent(Intent.ACTION_SENDTO);
        contactmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setData(Uri.parse("sms:" + 555));
                startActivity(message);
            }
        });

    }

    public void setlocale(String language) {
        Locale myLocale = new Locale(language);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = myLocale;
        resources.updateConfiguration(configuration, displayMetrics);
        Intent ii = new Intent(this, MainActivity.class);
        startActivity(ii);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_home) {
            Intent intent = new Intent(SupportActivity.this, HomePageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_search) {
            Intent intent_search = new Intent(SupportActivity.this, SearchActivity.class);
            startActivity(intent_search);
            return true;
        }
        if (id == R.id.action_support) {
            Toast.makeText(getApplicationContext(), "This is Support page ", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_arabic) {
            setlocale("ar");
            finish();
            return true;
        }
        if (id == R.id.action_english) {
            setlocale("en");
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
