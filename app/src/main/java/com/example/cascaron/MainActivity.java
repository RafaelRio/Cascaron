package com.example.cascaron;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.cascaron.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setSupportActionBar(binding.include.toolbar);
        setContentView(binding.getRoot());

        //Personalizar navigation drawer
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Inicializar el controlador de navegacion en la aplicacion
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //Metodo que configura el componente NavigationView
        setUpNavigationView();

        Set<Integer> topLevelDestination = new HashSet<>();
        topLevelDestination.add(R.id.busquedaAgrupacion);
        topLevelDestination.add(R.id.aboutUsFragment);
        topLevelDestination.add(R.id.calendarioFragment);
        topLevelDestination.add(R.id.ventanaPrincipal);
        topLevelDestination.add(R.id.agrupacionListFragment);
        topLevelDestination.add(R.id.informacionEventoFragment);
        topLevelDestination.add(R.id.settingsFragment);

        NavigationUI.setupWithNavController(binding.navigationview, navController);

        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestination)
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    private void setUpNavigationView() {
        binding.navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.agrupacionListFragment:
                        abrirListadoAgrupaciones();
                        break;
                    case R.id.busquedaAgrupacion:
                        abrirBusquedaAplicaciones();
                        break;
                    case R.id.informacionEventoFragment:
                        abrirListEventos();
                        break;
                    case R.id.calendarioFragment:
                        abrirCalendario();
                        break;
                    case R.id.aboutUsFragment:
                        abrirAboutUs();
                    case R.id.settingsFragment:
                        abrirSettings();
                        break;
                    /*case R.id.action_actionSettings:
                        showSettings();
                        binding.navigationview.getCheckedItem().setChecked(false);
                        break;*/
                }
                binding.drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void abrirSettings() {navController.navigate(R.id.settingsFragment);
    }

    private void abrirListEventos() {navController.navigate(R.id.informacionEventoFragment);
    }

    private void abrirListadoAgrupaciones() {
        navController.navigate(R.id.agrupacionListFragment);
    }

    private void abrirBusquedaAplicaciones() {
        navController.navigate(R.id.busquedaAgrupacion);
    }

    private void abrirCalendario() {
        navController.navigate(R.id.calendarioFragment);
    }

    private void abrirAboutUs() {
        navController.navigate(R.id.aboutUsFragment);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        return super.onCreateOptionsMenu(menu);
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//
//            default:
//                //Si lsos fragments modifican el menu de la Activity se devuelve false
//                return false;
//        }
//
//    }
}