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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;

public class MoreDelailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView place_name;
    String city = "";
    int i=0;
    ProgressBar progressBar;
    ListView lv_place_info;
    Button reservation;
    public String placename = "";
    ArrayList<String> PlaceInfoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_more_delails);
        imageView = findViewById(R.id.iv_place);
        place_name = findViewById(R.id.tv_palceName);
        lv_place_info = findViewById(R.id.lv_palceInfo);
        progressBar = findViewById(R.id.progressbar);
        reservation = findViewById(R.id.btn_reservation);


        Intent intent = getIntent();
        if (intent != null) {
            String place = intent.getStringExtra("place");
            int image = intent.getIntExtra("image", 1);
            if (place.equals("Greece")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/lequq";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "Greece";
                i=0;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Italy")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/firoi";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "italy";
                i=0;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("France")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/8fpky";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "farnce";
                i=0;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Turkey")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/yia5u";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "turky";
                i=0;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Athens")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/lequq";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "Greece";
                i=0;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Paris")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/8fpky";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "farnce";
                i=0;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Istanbul")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/yia5u";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "turky";
                i=0;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Milan")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/firoi";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "italy";
                i=0;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Olympia")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/lequq";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "Greece";
                i=1;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Loire Valley")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/8fpky";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "farnce";
                i=1;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Marmara Sea")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/yia5u";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "turky";
                i=1;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Verona")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/firoi";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "italy";
                i=1;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Mycenae")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/lequq";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "Greece";
                i=2;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Cannes")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/8fpky";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "farnce";
                i=2;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Bursa")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/yia5u";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "turky";
                i=2;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Rome")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/firoi";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "italy";
                i=2;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Rhodes")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/lequq";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "Greece";
                i=3;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Monte Carlo")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/8fpky";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "farnce";
                i=3;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Mount Olympus")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/yia5u";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "turky";
                i=3;
                place_name.setText(place);
                imageView.setImageResource(image);
            } else if (place.equals("Capri")) {
                final String USGS_REQUEST_URL = "https://api.myjson.com/bins/firoi";
                ShowInfoAsyncTask showInfoAsyncTask = new ShowInfoAsyncTask();
                showInfoAsyncTask.execute(USGS_REQUEST_URL);
                city = "italy";
                i=3;
                place_name.setText(place);
                imageView.setImageResource(image);
            }


        }

        reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MoreDelailsActivity.this, ApplicationActivity.class);
                intent.putExtra("offer", placename);
                startActivity(intent);
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
            Intent intent = new Intent(MoreDelailsActivity.this, HomePageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_search) {
            Intent intent_search = new Intent(MoreDelailsActivity.this, SearchActivity.class);
            startActivity(intent_search);
            return true;
        }
        if (id == R.id.action_support) {
            Intent intent = new Intent(MoreDelailsActivity.this, SupportActivity.class);
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

        return super.onOptionsItemSelected(item);
    }

    public class ShowInfoAsyncTask extends AsyncTask<String,Void,ArrayList<String>>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<String> doInBackground(String... strings) {

            URL url=null;

            try {
                url=new URL(strings[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            String jsonShowInfo="";

            try {
                jsonShowInfo=makeHttpRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ArrayList<String> places=extractPlacesFromJson(jsonShowInfo);


            return places;
        }

        @Override
        protected void onPostExecute(ArrayList<String> places) {
            super.onPostExecute(places);
            progressBar.setVisibility(View.GONE);


            ArrayAdapter<String> placesAdapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,places);

            lv_place_info.setAdapter(placesAdapter);

        }


        protected ArrayList<String> extractPlacesFromJson(String jsonString){
            try {
                JSONObject root=new JSONObject(jsonString);

                JSONArray country=root.getJSONArray(city);
                for(i=0; i<country.length();i++){
                    JSONObject shows=country.getJSONObject(i);
                    if(i==0) {
                        JSONArray days = shows.getJSONArray("show one");
                        for (int a = 0; a < days.length(); a++) {
                            JSONObject day = days.getJSONObject(a);
                            PlaceInfoList.add(String.valueOf(day));
                        }

                    }
                    else if(i==1) {
                        JSONArray days = shows.getJSONArray("show two");
                        for (int a = 0; a < days.length(); a++) {
                            JSONObject day = days.getJSONObject(a);
                            PlaceInfoList.add(String.valueOf(day));
                        }

                    }
                    else if(i==2) {
                        JSONArray days = shows.getJSONArray("show three");
                        for (int a = 0; a < days.length(); a++) {
                            JSONObject day = days.getJSONObject(a);
                            PlaceInfoList.add(String.valueOf(day));
                        }

                    }
                    else {
                        JSONArray days = shows.getJSONArray("show four");
                        for (int a = 0; a < days.length(); a++) {
                            JSONObject day = days.getJSONObject(a);
                            PlaceInfoList.add(String.valueOf(day));
                        }
                    }
                    break;
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            return PlaceInfoList;
        }

        /**
         * Make an HTTP request to the given URL and return a String as the response.
         */
        private String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";
            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } catch (IOException e) {
                // TODO: Handle the exception
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    // function must handle java.io.IOException here
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

        /**
         * Convert the {@link InputStream} into a String which contains the
         * whole JSON response from the server.
         */
        private String readFromStream(InputStream inputStream) throws IOException {
            StringBuilder output = new StringBuilder();
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            }
            return output.toString();
        }

    }
}
