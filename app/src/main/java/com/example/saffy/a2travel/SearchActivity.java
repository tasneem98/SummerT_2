package com.example.saffy.a2travel;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SearchActivity extends AppCompatActivity {

    Button btn_search, btn_ok, btn_update, btn_delete, btn_cancel;
    LinearLayout linearSearsh, linear, linear_delete_update, linear_ok_cancel;
    TextView tv_name;
    RadioButton radioButton;
    Spinner spinner;
    LinearLayout linearVisa;

    EditText edt_search;
    EditText edt_name, edt_nationality, edt_ssn, edt_email;
    EditText edt_phone, edt_from, edt_Num_Of_Persom, edt_visanum, edt_offer;
    RadioButton radioButtonVisa;
    RadioButton radioButtonCash;
    RadioGroup rg_paying;
    RadioButton radioButtonSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        btn_search = findViewById(R.id.btn_search);
        btn_ok = findViewById(R.id.btn_ok);
        linearSearsh = findViewById(R.id.linearsearch);
        linear = findViewById(R.id.linear);
        linear_delete_update = findViewById(R.id.lineardatabase_delete_updata);
        linear_ok_cancel = findViewById(R.id.linearOkCancel);
        tv_name = findViewById(R.id.tv_yourname);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        btn_cancel = findViewById(R.id.btn_cancel);
        radioButton = findViewById(R.id.rb_visa);
        spinner = findViewById(R.id.spin_Order_Of_Room);
        linearVisa = findViewById(R.id.linearvisa);
        radioButtonVisa = findViewById(R.id.rb_visa);
        radioButtonCash = findViewById(R.id.rb_cash);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearVisa.setVisibility(View.VISIBLE);
            }
        });


        String[] items = new String[]{"Room type : ", "Single", "Double", "Suite"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custum_spinner, items);
        spinner.setAdapter(adapter);


        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_name.setVisibility(View.VISIBLE);
                linear_delete_update.setVisibility(View.VISIBLE);

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearSearsh.setVisibility(View.GONE);
                tv_name.setVisibility(View.GONE);
                linear_delete_update.setVisibility(View.GONE);
                linear.setVisibility(View.VISIBLE);
                linear_ok_cancel.setVisibility(View.VISIBLE);


            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear.setVisibility(View.GONE);
                linear_ok_cancel.setVisibility(View.GONE);
                linearSearsh.setVisibility(View.VISIBLE);


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
            Intent intent = new Intent(SearchActivity.this, HomePageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_support) {
            Intent intent = new Intent(SearchActivity.this, SupportActivity.class);
            startActivity(intent);
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
        if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "This is the Search page ", Toast.LENGTH_SHORT).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
