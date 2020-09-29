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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Locale;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    String place1 = "Greece", place2 = "Italy", place3 = "France", place4 = "Turkey";
    String inf1 = "2000$ - 10 days", inf2 = "2200$ - 8 days", inf3 = "2500$ - 8 days", inf4 = "1900$ - 6 days";
    Button btn_right, btn_left;
    ListView lv_offers;
    ArrayList<OfferClass> offer = new ArrayList<>();
    ImageView greece, france, italy, turkey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        viewFlipper = findViewById(R.id.viewFlipper);
        btn_right = findViewById(R.id.btn_right);
        btn_left = findViewById(R.id.btn_left);
        lv_offers = findViewById(R.id.lv_offers);
        greece = findViewById(R.id.iv_greece);
        france = findViewById(R.id.iv_france);
        turkey = findViewById(R.id.iv_turkia);
        italy = findViewById(R.id.iv_italia);
        btn_right.setOnClickListener(this);
        btn_left.setOnClickListener(this);


        greece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, OffersActivity.class);
                intent.putExtra("place", "OfferOne");
                startActivity(intent);
            }
        });
        france.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, OffersActivity.class);
                intent.putExtra("place", "OfferTwo");
                startActivity(intent);
            }
        });
        turkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, OffersActivity.class);
                intent.putExtra("place", "OfferThree");
                startActivity(intent);
            }
        });
        italy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, OffersActivity.class);
                intent.putExtra("place", "OfferFour");
                startActivity(intent);
            }
        });

        final OffersArrayAdapterClass offer_adapter = new OffersArrayAdapterClass(getApplicationContext(), offer);
        OfferClass OfferOne = new OfferClass(R.drawable.greece1, place1, inf1);
        OfferClass OfferTwo = new OfferClass(R.drawable.italy1, place2, inf2);
        OfferClass OfferThree = new OfferClass(R.drawable.france1, place3, inf3);
        OfferClass OfferFour = new OfferClass(R.drawable.turky1, place4, inf4);

        offer.add(OfferOne);
        offer.add(OfferTwo);
        offer.add(OfferThree);
        offer.add(OfferFour);

        offer_adapter.notifyDataSetChanged();
        lv_offers.setAdapter(offer_adapter);

        lv_offers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {

                    Intent intent1 = new Intent(HomePageActivity.this, MoreDelailsActivity.class);
                    intent1.putExtra("place", place1);
                    intent1.putExtra("image", R.drawable.greece1);
                    startActivity(intent1);
                } else if (i == 1) {
                    Intent intent1 = new Intent(HomePageActivity.this, MoreDelailsActivity.class);
                    intent1.putExtra("place", place2);
                    intent1.putExtra("image", R.drawable.italy1);
                    startActivity(intent1);
                } else if (i == 2) {
                    Intent intent1 = new Intent(HomePageActivity.this, MoreDelailsActivity.class);
                    intent1.putExtra("place", place3);
                    intent1.putExtra("image", R.drawable.france1);
                    startActivity(intent1);
                } else {
                    Intent intent1 = new Intent(HomePageActivity.this, MoreDelailsActivity.class);
                    intent1.putExtra("place", place4);
                    intent1.putExtra("image", R.drawable.turky1);
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
            Toast.makeText(getApplicationContext(), "This is the home page ", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.action_support) {
            Intent intent = new Intent(HomePageActivity.this, SupportActivity.class);
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
            Intent intent = new Intent(HomePageActivity.this, SearchActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view == btn_right) {
            viewFlipper.showNext();
        } else if (view == btn_left) {
            viewFlipper.showPrevious();
        }

    }


}
