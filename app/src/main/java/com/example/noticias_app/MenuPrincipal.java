package com.example.noticias_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity {

    TextView NombrePrincipal, CorreoPrincipal;
    ProgressBar progressBarDatos;
    Button CerrarSesion;

    String nombre = "", correo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Agenda Online");
        }

        NombrePrincipal = findViewById(R.id.NombrePrincipal);
        CorreoPrincipal = findViewById(R.id.CorreoPrincipal);
        CerrarSesion = findViewById(R.id.CerrarSesion);

        // Recuperar los valores pasados desde la actividad Registro
        Intent intent = getIntent();
        if (intent != null) {
            nombre = intent.getStringExtra("nombre");
            correo = intent.getStringExtra("correo");

            // Establecer los valores en los TextView correspondientes
            NombrePrincipal.setText(nombre);
            CorreoPrincipal.setText(correo);

            //progressBarDatos = findViewById(R.id.ConfirmarContraseñaET);  Mofificar bien
        }

        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SalirAplicacion();
                finish();
                System.exit(0);
            }
        });
    }

    private void SalirAplicacion() {
        startActivity(new Intent(MenuPrincipal.this, MainActivity.class));
        Toast.makeText(this, "Sesion Cerrada", Toast.LENGTH_SHORT).show();
    }
}

