package com.example.noticias_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    EditText NombreET, CorreoET, ContraseñaET, ConfirmarContraseñaET;
    Button RegistrarUsuario;
    RadioGroup  GeneroRg;
    TextView TengoUnaCuentaTXT;

    String nombre = "", correo = "", password = "", confirmarPassword = "";
    int generoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Registrar");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        NombreET = findViewById(R.id.NombreET);
        CorreoET = findViewById(R.id.CorreoET);
        ContraseñaET = findViewById(R.id.ContraseñaET);
        ConfirmarContraseñaET = findViewById(R.id.ConfirmarContraseñaET);
        RegistrarUsuario = findViewById(R.id.RegistrarUsuario);
        TengoUnaCuentaTXT = findViewById(R.id.TengoUnaCuentaTXT);
        GeneroRg = findViewById(R.id.GeneroRg);

        RegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                ValidarDatos();
            }
        });

        TengoUnaCuentaTXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                startActivity(new Intent(Registro.this, Login.class));
                //finish();
            }
        });
    }

    private void  ValidarDatos() {
        nombre = NombreET.getText().toString();
        correo = CorreoET.getText().toString();
        password = ContraseñaET.getText().toString();
        confirmarPassword = ConfirmarContraseñaET.getText().toString();
        generoSeleccionado = GeneroRg.getCheckedRadioButtonId();

        if(TextUtils.isEmpty(nombre)){
            Toast.makeText(this,"Ingrese nombre", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this,"Ingrese correo", Toast.LENGTH_SHORT).show();
        } else if (generoSeleccionado == -1) {
            Toast.makeText(this, "Seleccione su género", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,"Ingrese contraseña", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(confirmarPassword)) {
            Toast.makeText(this,"Confirme contraseña", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirmarPassword)) {
            Toast.makeText(this,"Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Registro Exitoso", Toast.LENGTH_SHORT).show();

            //Enviar valores a menu principal
            Intent intent = new Intent(Registro.this, MenuPrincipal.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("correo", correo);
            startActivity(intent);

            finish();
            //CrearCuenta();
        }
    }

    private void CrearCuenta() {
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}