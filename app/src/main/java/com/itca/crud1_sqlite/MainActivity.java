package com.itca.crud1_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion.db", null, 1);
    //final SQLiteDatabase bd = admin.getWritableDatabase();

    private EditText etcodigo, etdescripcion, etprecio;
    private Button btnAlta, btnConsultaCodigo, btnConsultaDescripcion, btnEliminar, btnModificar, btnSalir, btnNuevo;

    String codigo, descripcion, precio;
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
        SQLiteDatabase bd = admin.getWritableDatabase();
        switch (view.getId()){
            case R.id.btnAlta:
                codigo = etcodigo.getText().toString();
                descripcion = etdescripcion.getText().toString();
                precio = etprecio.getText().toString();
                ContentValues registro = new ContentValues();
                registro.put("codigo", codigo);
                registro.put("descripcion", descripcion);
                registro.put("precio", precio);
                //bd.insert("articulos", null, registro);
                if(codigo.isEmpty()){
                    etcodigo.setError("Campo obligatorio.");
                }else if(descripcion.isEmpty()){
                    etdescripcion.setError("Campo obligatorio");
                }else if(precio.isEmpty()){
                    etprecio.setError("Campo obligatorio");
                }else{
                    bd.insert("articulos", null, registro);
                    bd.close();
                    etcodigo.setText(null);
                    etdescripcion.setText(null);
                    etprecio.setText(null);
                    Toast.makeText(this, "Registro guardado correctamente.", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnConsultaCodigo:
                //Toast.makeText(this, "Has hecho clic en botón consultar por código", Toast.LENGTH_SHORT).show();
                codigo = etcodigo.getText().toString();
                if(codigo.isEmpty()) {
                    etcodigo.setError("Campo obligatorio.");
                }else{
                    Cursor fila = bd.rawQuery("select descripcion, precio from articulos where codigo="+codigo, null);
                    if(fila.moveToFirst()){
                        etdescripcion.setText(fila.getString(0));
                        etprecio.setText(fila.getString(1));
                    }else{
                        Toast.makeText(this, "No existe un artículo con dicho código.", Toast.LENGTH_SHORT).show();
                    }
                    bd.close();
                }
                break;
            case R.id.btnConsultaDescripcion:
                //Toast.makeText(this, "Has hecho clic en botón consultar por descripción", Toast.LENGTH_SHORT).show();
                descripcion = etdescripcion.getText().toString();
                if(descripcion.isEmpty()) {
                    etdescripcion.setError("Campo obligatorio.");
                }else{
                    Cursor fila = bd.rawQuery("select codigo, precio from articulos where descripcion = '" + descripcion + "'", null);
                    if(fila.moveToFirst()){
                        etcodigo.setText(fila.getString(0));
                        etprecio.setText(fila.getString(1));
                    }else{
                        Toast.makeText(this, "No existe un artículo con dicho código.", Toast.LENGTH_SHORT).show();
                    }
                    bd.close();
                }
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