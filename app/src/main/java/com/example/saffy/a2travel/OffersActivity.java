package com.example.saffy.a2travel;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.saffy.a2travel.OffersArrayAdapterClass;

import java.util.ArrayList;
import java.util.Locale;

public class OffersActivity extends AppCompatActivity {

    ListView lv_ShowOffer;
    OfferClass OfferOne, OfferTwo, OfferThree, OfferFour;
    ArrayList<OfferClass> offer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);


        lv_ShowOffer = findViewById(R.id.lv_showoffer);
        final OffersArrayAdapterClass offer_adapter = new OffersArrayAdapterClass(getApplicationContext(), offer);

        Intent intent = getIntent();
        if (intent != null) {
            String place = intent.getStringExtra("place");
            if (place.equals("OfferOne")) {
                OfferOne = new OfferClass(R.drawable.greece1, "Athens", "2000$ - 10 days");
                OfferTwo = new OfferClass(R.drawable.greece2, "Olympia", "2200$ - 12 days");
                OfferThree = new OfferClass(R.drawable.greece3, "Mycenae", "1900$ - 10 days");
                OfferFour = new OfferClass(R.drawable.greece4, "Rhodes", "2150$ - 11 days");

                offer.add(OfferOne);
                offer.add(OfferTwo);
                offer.add(OfferThree);
                offer.add(OfferFour);

            } else if (place.equals("OfferTwo")) {
                OfferOne = new OfferClass(R.drawable.france1, "Paris", "1700$ - 8 days");
                OfferTwo = new OfferClass(R.drawable.france2, "Loire Valley", "1800$ - 8 days");
                OfferThree = new OfferClass(R.drawable.france3, "Cannes", "1900$ - 10 days");
                OfferFour = new OfferClass(R.drawable.france4, "Monte Carlo", "2100$ - 10 days");

                offer.add(OfferOne);
                offer.add(OfferTwo);
                offer.add(OfferThree);
                offer.add(OfferFour);

            } else if (place.equals("OfferThree")) {
                OfferOne = new OfferClass(R.drawable.turky1, "Istanbul", "1500$ - 6 days");
                OfferTwo = new OfferClass(R.drawable.turky2, "Marmara Sea", "1700$ - 8 days");
                OfferThree = new OfferClass(R.drawable.turky3, "Bursa", "1650$ - 7 days");
                OfferFour = new OfferClass(R.drawable.turky4, "Mount Olympus", "2000$ - 9 days");

                offer.add(OfferOne);
                offer.add(OfferTwo);
                offer.add(OfferThree);
                offer.add(OfferFour);
            } else {
                OfferOne = new OfferClass(R.drawable.italy1, "Milan", "2100$ - 8 days");
                OfferTwo = new OfferClass(R.drawable.italy2, "Verona", "2150$ - 9 days");
                OfferThree = new OfferClass(R.drawable.italy3, "Rome", "2200 - 9 days");
                OfferFour = new OfferClass(R.drawable.italy4, "Capri", "2500$ - 7 days");

                offer.add(OfferOne);
                offer.add(OfferTwo);
                offer.add(OfferThree);
                offer.add(OfferFour);
            }

        }


        offer_adapter.notifyDataSetChanged();
        lv_ShowOffer.setAdapter(offer_adapter);
        lv_ShowOffer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0) {
                    Intent intent1 = new Intent(OffersActivity.this, MoreDelailsActivity.class);
                    intent1.putExtra("place", OfferOne.getGet_place_name());
                    intent1.putExtra("image", OfferOne.getGet_image());
                    startActivity(intent1);
                } else if (i == 1) {
                    Intent intent1 = new Intent(OffersActivity.this, MoreDelailsActivity.class);
                    intent1.putExtra("place", OfferTwo.getGet_place_name());
                    intent1.putExtra("image", OfferTwo.getGet_image());
                    startActivity(intent1);
                } else if (i == 2) {
                    Intent intent1 = new Intent(OffersActivity.this, MoreDelailsActivity.class);
                    intent1.putExtra("place", OfferThree.getGet_place_name());
                    intent1.putExtra("image", OfferThree.getGet_image());
                    startActivity(intent1);
                } else {
                    Intent intent1 = new Intent(OffersActivity.this, MoreDelailsActivity.class);
                    intent1.putExtra("place", OfferFour.getGet_place_name());
                    intent1.putExtra("image", OfferFour.getGet_image());
                    startActivity(intent1);
                }

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
            Intent intent = new Intent(OffersActivity.this, HomePageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_search) {
            Intent intent_search = new Intent(OffersActivity.this, SearchActivity.class);
            startActivity(intent_search);
            return true;
        }
        if (id == R.id.action_support) {
            Intent intent = new Intent(OffersActivity.this, SupportActivity.class);
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
}
