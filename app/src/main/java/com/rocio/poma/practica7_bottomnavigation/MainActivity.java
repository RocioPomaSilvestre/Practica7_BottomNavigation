package com.rocio.poma.practica7_bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragmentInicio, fragmentBuscar,fragmentBiblioteca;
        fragmentInicio=new FragmentInicio();
        fragmentBuscar=new FragmentBuscar();
        fragmentBiblioteca=new FragmentBiblioteca();

        BottomNavigationView.OnNavigationItemSelectedListener listener= new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem itemSel) {

                if (itemSel.getItemId()==R.id.itemInicio){
                    //mostrar fragment inicio
                    FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.contenedorPrincipal,fragmentInicio);
                    transaction.commit();
                    return true;
                }else if (itemSel.getItemId()==R.id.itemBuscar){
                    //mostrar fragment Buscar
                    FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.contenedorPrincipal,fragmentBuscar);
                    transaction.commit();
                    return true;
                }else if (itemSel.getItemId()==R.id.itemBiblioteca){
                    //mostrar fragment
                    FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.contenedorPrincipal,fragmentBiblioteca);
                    transaction.commit();
                    return true;
                }
                return false;
            }
        };

        BottomNavigationView navigationView=findViewById(R.id.navBotton);
        navigationView.setOnNavigationItemSelectedListener(listener);
    }
}