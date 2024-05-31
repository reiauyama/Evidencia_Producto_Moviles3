package com.example.patata.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.patata.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class InicioSesion extends AppCompatActivity {
    EditText userNameEditText, emailEditText, passwordEditText;
    Button registerButton, loginButton;
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
        loginButton = findViewById(R.id.loginButton);

        // Configurar un OnClickListener para el botón de registro
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos de entrada
                String userName = userNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Verificar si algún campo está vacío
                if (userName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(InicioSesion.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Verificar si el nombre de usuario ya existe
                    verificarUsuarioExistente(userName, email, password);
                }
            }
        });

        // Configurar un OnClickListener para el botón de inicio de sesión
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos de entrada
                String userName = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Verificar si algún campo está vacío
                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(InicioSesion.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Verificar las credenciales del usuario
                    verificarCredencialesUsuario(userName, password);
                }
            }
        });
    }

    private void verificarUsuarioExistente(final String userName, final String email, final String password) {
        DatabaseReference usuariosRef = mDatabase.child("usuarios");


        // addListenerForSingleValueEvent es la instancia para ValueEventListener
        usuariosRef.child(userName).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override //DataSnapshot funciona para leer los datos (Verifica la existencia de nodos)
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // El usuario ya existe, mostrar mensaje de error
                    Toast.makeText(InicioSesion.this, "Usuario ya existente", Toast.LENGTH_SHORT).show();
                } else {
                    // El usuario no existe, guardar la información en Firebase
                    guardarInformacionFirebase(userName, email, password);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

    private void verificarCredencialesUsuario(final String userName, final String password) {
        DatabaseReference usuariosRef = mDatabase.child("usuarios");

        usuariosRef.child(userName).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // El usuario existe, verificar la contraseña
                    String passwordRegistrada = dataSnapshot.child("password").getValue(String.class);
                    if (password.equals(passwordRegistrada)) {
                        // Las credenciales son correctas, iniciar sesión
                        Toast.makeText(InicioSesion.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                        // Aquí puedes agregar la lógica para cambiar de actividad o guardar el estado del usuario
                    } else {
                        // La contraseña es incorrecta
                        Toast.makeText(InicioSesion.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // El usuario no existe
                    Toast.makeText(InicioSesion.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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

        // Mostrar un mensaje de éxito
        Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
    }
}
