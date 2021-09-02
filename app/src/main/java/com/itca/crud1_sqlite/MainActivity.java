package com.itca.crud1_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etcodigo, etdescripcion, etprecio;
    private Button btnAlta, btnConsultaCodigo, btnConsultaDescripcion, btnEliminar, btnModificar, btnSalir, btnNuevo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcodigo = findViewById(R.id.etcodigo);
        etdescripcion = findViewById(R.id.etdescripcion);
        etprecio = findViewById(R.id.etprecio);

        btnAlta = findViewById(R.id.btnAlta);
        btnConsultaCodigo = findViewById(R.id.btnConsultaCodigo);
        btnConsultaDescripcion = findViewById(R.id.btnConsultaDescripcion);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnModificar = findViewById(R.id.btnModificar);
        btnSalir = findViewById(R.id.btnSalir);
        btnNuevo = findViewById(R.id.btnNuevo);

        btnAlta.setOnClickListener(this);
        btnConsultaCodigo.setOnClickListener(this);
        btnConsultaDescripcion.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnModificar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
        btnNuevo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAlta:
                //Toast.makeText(this, "Has hecho clic en botón Alta", Toast.LENGTH_SHORT).show();
                String codigo = etcodigo.getText().toString();
                String descripcion = etdescripcion.getText().toString();
                String precio = etprecio.getText().toString();

                if(codigo.isEmpty()){
                    etcodigo.setError("Campo obligatorio.");
                }else if(descripcion.isEmpty()){
                    etdescripcion.setError("Campo obligatorio");
                }else if(precio.isEmpty()){
                    etprecio.setError("Campo obligatorio");
                }else{
                    Toast.makeText(this, "Has superado la validación", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btnConsultaCodigo:
                //Toast.makeText(this, "Has hecho clic en botón consultar por código", Toast.LENGTH_SHORT).show();


                break;
            case R.id.btnConsultaDescripcion:
                //Toast.makeText(this, "Has hecho clic en botón consultar por descripción", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnEliminar:
                Toast.makeText(this, "Has hecho clic en botón Eliminar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnModificar:
                Toast.makeText(this, "Has hecho clic en botón Modificar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnSalir:
                Toast.makeText(this, "Has hecho clic en botón Salir", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnNuevo:
                Toast.makeText(this, "Has hecho clic en botón Nuevo", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}