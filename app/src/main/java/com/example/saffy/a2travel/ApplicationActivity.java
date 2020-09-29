package com.example.saffy.a2travel;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ApplicationActivity extends AppCompatActivity {
    RadioButton radioButton;
     Spinner spinner;
    String offer = "";
    LinearLayout linearLayout;
    Button cancel;
     EditText edt_name, edt_nationality, edt_ssn, edt_email;
     EditText edt_phone, edt_from, edt_Num_Of_Persom, edt_visanum;
    RadioGroup rg_paying;
     RadioButton radioButtonSelected;
    Button btn_book;
String DataParseUrl;
    String name1, ssn1, email1, phone1, no_ofperson1, date1, rooms1, payment1, no_visa1, offer1,n1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);



        radioButton = findViewById(R.id.rb_visa);
        spinner = findViewById(R.id.spin_Order_Of_Room);
        linearLayout = findViewById(R.id.linearvisa);
        cancel = findViewById(R.id.btn_cancel);
        edt_name = findViewById(R.id.edt_name);
        edt_nationality = findViewById(R.id.edt_nationality);
        edt_ssn = findViewById(R.id.edt_ssn);
        edt_email = findViewById(R.id.edt_email);
        edt_phone = findViewById(R.id.edt_phone);
        edt_from = findViewById(R.id.edt_from);
        edt_Num_Of_Persom = findViewById(R.id.edt_Num_Of_Persom);
        rg_paying = findViewById(R.id.rg_paying);
        edt_visanum = findViewById(R.id.edt_visanum);
        btn_book = findViewById(R.id.btn_book);

        Intent intent = getIntent();
        if (intent != null) {
            String place = intent.getStringExtra("offer");
            offer = place;

        }

        int selectedId = rg_paying.getCheckedRadioButtonId();
        radioButtonSelected = findViewById(selectedId);

        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ApplicationActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        });


        String[] items = new String[]{"Single", "Double", "Suite"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.custum_spinner, items);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataParseUrl  = "http://10.0.2.2/information2/u.php";
                SendDataToServer(name1, ssn1, email1, phone1, no_ofperson1, date1, no_visa1,n1);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);
        return true;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_home) {
            Intent intent = new Intent(ApplicationActivity.this, HomePageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_support) {
            Intent intent = new Intent(ApplicationActivity.this, SupportActivity.class);
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
            Intent intent_search = new Intent(ApplicationActivity.this, SearchActivity.class);
            startActivity(intent_search);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
    public void GetDataFromEditText(){

        name1=edt_name.getText().toString();
                ssn1=edt_ssn.getText().toString();
        email1=edt_email.getText().toString();
                phone1=edt_phone.getText().toString();
        no_ofperson1=edt_Num_Of_Persom.getText().toString();
                date1=edt_from.getText().toString();
    ;
        no_visa1=edt_visanum.getText().toString();

        n1  = edt_nationality.getText().toString();;


    }
    public void SendDataToServer(final String name, final String ssn,final String email,
                                 final String phone,final String no_ofperson,final String date
            ,final String no_visa,final String nationality){
        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String QuickName = name ;
                String Quickssn = ssn ;
                String Quickemail = email ;
                String Quickphone = phone ;
                String Quickno_ofperson = no_ofperson ;
                String Quickdate = date ;

                String Quickno_visa = no_visa ;

                String Quicknationality = nationality ;



                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("name", QuickName));
                nameValuePairs.add(new BasicNameValuePair("RRN", Quickssn));
                nameValuePairs.add(new BasicNameValuePair("email", Quickemail));
                nameValuePairs.add(new BasicNameValuePair("phone", Quickphone));
                nameValuePairs.add(new BasicNameValuePair("no_ofperson", Quickno_ofperson));
                nameValuePairs.add(new BasicNameValuePair("date", Quickdate));

                nameValuePairs.add(new BasicNameValuePair("no_visa", Quickno_visa));


                nameValuePairs.add(new BasicNameValuePair("nationality", Quicknationality));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(DataParseUrl);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Submit Successfully";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(ApplicationActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(name);
    }
}
