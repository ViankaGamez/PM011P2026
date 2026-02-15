package com.example.pm011p2026;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pm011p2026.Configuraciones.SQLiteConexion;
import com.example.pm011p2026.Configuraciones.Transacciones;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido, edad, correo;
    ImageView foto;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        edad = (EditText) findViewById(R.id.edad);
        correo = (EditText) findViewById(R.id.correo);
        foto = (ImageView) findViewById(R.id.foto);
        btnAgregar = (Button) findViewById(R.id.boton);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Hola", Toast.LENGTH_LONG).show();

                AddPersona();
            }
        });

    }

    private void AddPersona() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.dbname,null, Transacciones.dbversion);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombre, nombre.getText().toString());
        valores.put(Transacciones.apellido, apellido.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.foto, "");

        Long resultado = db.insert(Transacciones.tbPersonas, Transacciones.id, valores);
        Toast.makeText(getApplicationContext(), "Registro Ingresado " + resultado.toString(), Toast.LENGTH_LONG).show();

        db.close();
    }

    private void LimpiarPantalla(){
        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        correo.setText("");
        nombre.requestFocus();
    }
}