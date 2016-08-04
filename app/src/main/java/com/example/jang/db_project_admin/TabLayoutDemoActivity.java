package com.example.jang.db_project_admin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class TabLayoutDemoActivity extends AppCompatActivity {
    Spinner spincategory, spingrade,spinner;
    ArrayAdapter<CharSequence> adspincategory;
    ArrayAdapter<CharSequence> adspingrade;
    ArrayAdapter<CharSequence> adspin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_demo);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        init();

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setPrompt("검색 조건을 선택하세요");


        adspin = ArrayAdapter.createFromResource(this, R.array.grade,android.R.layout.simple_spinner_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adspin);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("aaaajj","aaaajj");
                Toast.makeText(TabLayoutDemoActivity.this,
                        adspin.getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        spingrade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(SearchActivity.this,
////                        adspin.getItem(position) + "을 선택 했습니다.", Toast.LENGTH_SHORT).show();
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });



        TabLayout tabLayout =
                (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.addTab(tabLayout.newTab().setIcon(
                android.R.drawable.ic_dialog_email));
        tabLayout.addTab(tabLayout.newTab().setIcon(
                android.R.drawable.ic_dialog_dialer));
//        tabLayout.addTab(tabLayout.newTab().setIcon(
//                android.R.drawable.ic_dialog_map));
//        tabLayout.addTab(tabLayout.newTab().setIcon(
//                android.R.drawable.ic_dialog_info));

        final ViewPager viewPager =
                (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new TabPagerAdapter
                (getSupportFragmentManager(),
                        tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new
                TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new
                TabLayout.OnTabSelectedListener() {
                   @Override
                   public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                   }

                   @Override
                   public void onTabUnselected(TabLayout.Tab tab) {

                   }

                   @Override
                   public void onTabReselected(TabLayout.Tab tab) {

                   }
        });

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void init()
    {


////        spincategory = (Spinner)findViewById(R.id.spincategory_fragment);
//        spingrade = (Spinner)findViewById(R.id.spingrade_fragment);
//
//        spincategory.setPrompt("선택");
//        spingrade.setPrompt("선택");
//
//        adspincategory = ArrayAdapter.createFromResource(this, R.array.category,    android.R.layout.simple_spinner_item);
//        adspincategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spincategory.setAdapter(adspincategory);
//
//        adspingrade = ArrayAdapter.createFromResource(this, R.array.grade,    android.R.layout.simple_spinner_item);
//        adspingrade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spingrade.setAdapter(adspingrade);


        try{
//            spinner = (Spinner) findViewById(R.id.spinner);
//            spinner.setPrompt("검색 조건을 선택하세요");
//
//
//            adspin = ArrayAdapter.createFromResource(this, R.array.category,    android.R.layout.simple_spinner_item);
//
//            adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            spinner.setAdapter(adspin);
        }catch(Exception e)
        {

        }


    }
}


