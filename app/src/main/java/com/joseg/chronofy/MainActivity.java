package com.joseg.chronofy;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.joseg.chronofy.CustomAdapter.BrickAdapter;
import com.joseg.chronofy.DataModel.BrickModel;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<BrickModel> bricks;
    ListView listView;
    private static BrickAdapter brickAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pone como View a activity_main.xml
        setContentView(R.layout.activity_main);

        // El activity_main tiene una toolbar.
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Creamos la main_list_view de bricks
        listView = findViewById(R.id.main_list_view);
        bricks = new ArrayList<>();
        bricks.add(new BrickModel("Estudiar", "Ahora ponte a estudiar", 0));

        brickAdapter = new BrickAdapter(bricks, getApplicationContext());

        listView.setAdapter(brickAdapter);

        // El activity_main tiene un botón flotante (fab)
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bricks.add(new BrickModel("Estudiar", "Ahora ponte a estudiar", 0));
                brickAdapter.notifyDataSetChanged();
                Snackbar.make(view, "Añadido nuevo elemento", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // El activity_main tiene un DrawerLayout, sobre el cual se crea el menú lateral
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // En la toolbar se pone el acceso al menú lateral que ocupará lo que ocupa el drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerSlideAnimationEnabled(false);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        // Este es el menú lateral a desplegar
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        // Al botón de atrás añadimos la función de cerrar el drawer_layout en caso de estar abierto
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Añade las opciones al menú de tres puntos de la toolbar
        getMenuInflater().inflate(R.menu.main, menu);
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
            // En caso de pulsar el botón de opciones...

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
