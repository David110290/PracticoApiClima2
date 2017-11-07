package com.example.david.practicoapiclima;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AgregarActivity extends AppCompatActivity {
    private CiudadSQLiteHelper ciudadSQLiteHelper;
    private SQLiteDatabase db;

    public EditText edtNombre;
    private EditText edtId;
    private Button btnCargar;
    private String Nombre;
    private int Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        edtId= (EditText) findViewById(R.id.edtId);
        edtNombre= (EditText) findViewById(R.id.edtNombre);
        btnCargar= (Button) findViewById(R.id.btnAceptar);

        ciudadSQLiteHelper = new CiudadSQLiteHelper(this, "DBciudad", null, 1);
        db = ciudadSQLiteHelper.getWritableDatabase();
        //Id=Integer.parseInt(edtId.getText().toString());
        //Nombre= edtNombre.getText().toString();

        btnCargar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(!edtId.getText().toString().equals("") && !edtNombre.getText().toString().equals("")) {
                    Nombre = edtNombre.getText().toString();
                    Id = Integer.parseInt(edtId.getText().toString());

                    ContentValues nuevoRegistro = new ContentValues();
                    nuevoRegistro.put("id",Id);
                    nuevoRegistro.put("nombre",Nombre);
                    db.insert("ciudades", null, nuevoRegistro);

                    Toast.makeText(AgregarActivity.this, "Nueva Ciudad Guarda", Toast.LENGTH_LONG).show();

                    edtNombre.setText("");
                    edtId.setText("");
                }

                else{
                    Toast.makeText(AgregarActivity.this, "Faltan Datos Por Completar" , Toast.LENGTH_LONG).show();
                }

            }


        });


    }
}
