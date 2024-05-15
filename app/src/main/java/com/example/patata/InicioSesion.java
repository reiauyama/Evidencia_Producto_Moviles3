package com.example.patata;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InicioSesion extends AppCompatActivity {
     EditText userNameEditText, emailEditText, passwordEditText;
     Button registerButton;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        // Inicializar Firebase Database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Obtener referencias a los elementos de la interfaz de usuario
        userNameEditText = findViewById(R.id.UserName);
        emailEditText = findViewById(R.id.etEmail);
        passwordEditText = findViewById(R.id.etContraseña);
        registerButton = findViewById(R.id.button);

        // Configurar un OnClickListener para el botón de registro
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos de entrada
                String userName = userNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Guardar la información en la base de datos
                guardarInformacionFirebase(userName, email, password);
            }
        });
    }

    private void guardarInformacionFirebase(String userName, String email, String password) {
        // Crear un nuevo nodo en la base de datos bajo la clave "usuarios"
        DatabaseReference usuariosRef = mDatabase.child("usuarios");

        // Crear un nuevo nodo bajo la clave del nombre de usuario y guardar la información
        DatabaseReference usuarioNuevoRef = usuariosRef.child(userName);
        usuarioNuevoRef.child("email").setValue(email);
        usuarioNuevoRef.child("password").setValue(password);
    }
}