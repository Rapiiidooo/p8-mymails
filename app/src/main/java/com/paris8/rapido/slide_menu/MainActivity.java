package com.paris8.rapido.slide_menu;

import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    RelativeLayout drawerPane;
    ListView navListView;

    List<NavItem> listNavItem;
    List<Fragment> listFragment;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main);
        drawerPane = (RelativeLayout) findViewById(R.id.drawer_pane);
        navListView = (ListView) findViewById(R.id.navigation_list_view);

        listNavItem = new ArrayList<NavItem>();
        listNavItem.add(new NavItem("HOME", "Home Page", R.drawable.gmail_mdpi));
        listNavItem.add(new NavItem("SETTINGS", "Settings Page", R.drawable.gmail_mdpi));
        listNavItem.add(new NavItem("ABOUT", "About us", R.drawable.gmail_mdpi));

        NavListAdapter navListAdapter = new NavListAdapter(getApplicationContext(), R.layout.item_navigation_list, listNavItem);
        navListView.setAdapter(navListAdapter);

        listFragment = new ArrayList<Fragment>();
        listFragment.add(new Home());
        listFragment.add(new Frag2());
        listFragment.add(new Frag3());

        // Charge le premier frag par default
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, listFragment.get(0)).commit();

        setTitle(listNavItem.get(0).getTitle());
        navListView.setItemChecked(0,true);
        drawerLayout.closeDrawer(drawerPane);

        //Initialise le listener pour les objets de la nav
        navListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, listFragment.get(position)).commit();

                setTitle(listNavItem.get(position).getTitle());
                navListView.setItemChecked(position,true);
                drawerLayout.closeDrawer(drawerPane);
            }
        });

        //Creer le listener pour le drawerLayout
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed)
        {
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }
}
