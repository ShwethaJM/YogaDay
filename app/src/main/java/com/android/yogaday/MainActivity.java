package com.android.yogaday;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        SuryanamaskaraFragment.DetailSuryanamaskara,DetailsSuryanamaskaraFragment.StepsSuryanamaskara {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            HomeFragment homeFragment = new HomeFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayout_for_fragment, homeFragment);
            fragmentTransaction.commit();


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.registration, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_suryanamaskara) {
                // Handle the Suryanamaskara action
                SuryanamaskaraFragment suryanamaskaraFragment = new SuryanamaskaraFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraFragment);
                fragmentTransaction.commit();
            } else if (id == R.id.nav_home) {
                HomeFragment homeFragment = new HomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, homeFragment);
                fragmentTransaction.commit();
            }
        else if (id == R.id.nav_briefYoga) {
            BriefAboutYogaFragment briefAboutYogaFragment = new BriefAboutYogaFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayout_for_fragment, briefAboutYogaFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_basicPosture) {
            BasicPosesFragment basicPosesFragment = new BasicPosesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPosesFragment);
            fragmentTransaction.commit();

        }
        else if (id == R.id.nav_benefits) {
            BenefitsSuryanamaskaraFragment benefitsSuryanamaskaraFragment = new BenefitsSuryanamaskaraFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayout_for_fragment, benefitsSuryanamaskaraFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_contact) {
            ContactUsFragment contactUsFragment = new ContactUsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayout_for_fragment, contactUsFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_suggestion) {
            SuggestionFragment suggestionFragment =  new SuggestionFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suggestionFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_questions) {
            QuestionsFragment questionsFragment =  new QuestionsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.relativeLayout_for_fragment, questionsFragment);
            fragmentTransaction.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void callDetailsSuryanamaskara() {
        DetailsSuryanamaskaraFragment detailsSuryanamaskaraFragment = new DetailsSuryanamaskaraFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.relativeLayout_for_fragment, detailsSuryanamaskaraFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void callStepsSuryanamaskara() {
        SuryanamaskaraStep1Fragment suryanamaskaraStepsFragment = new SuryanamaskaraStep1Fragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraStepsFragment);
        fragmentTransaction.commit();
    }
}
