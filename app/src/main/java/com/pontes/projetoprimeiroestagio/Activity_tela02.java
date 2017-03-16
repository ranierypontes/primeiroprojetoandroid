package com.pontes.projetoprimeiroestagio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Activity_tela02 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ItemClickListener  {

    protected TextView tvNomeContato;
    protected TextView tvPerfilContato;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private ArrayList listData;
    private MeusContatos meusContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela02);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        meusContatos = new MeusContatos();
        listData = new ArrayList<>();
        listData = (ArrayList) meusContatos.listDados();
        recyclerView = (RecyclerView) findViewById(R.id.rvListaDeContatos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(listData, this);
        adapter.setItemClick(this);
        recyclerView.setAdapter(adapter);

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navMenu01) {
            startActivity(new Intent(Activity_tela02.this, Activity_tela05.class));
        } else if (id == R.id.navMenu02) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.br")));
        } else if (id == R.id.navSair) {
            Toast.makeText(this, "Sair!", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void editarContato(View view) {
        tvNomeContato = (TextView) findViewById(R.id.tvNomeContato);
        tvPerfilContato = (TextView) findViewById(R.id.tvPerfil);
        startActivity(new Intent(Activity_tela02.this, Activity_tela04.class));
    }

    @Override
    public void setOnclickListener(int pocisao) {
        Contato contato = (Contato) listData.get(pocisao);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contato.getTelefone()));
        startActivity(intent);
        adapter.notifyDataSetChanged();
    }
}
