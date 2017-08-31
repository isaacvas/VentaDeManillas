package com.example.cesar.ventademanillas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private TextView valor;
    private EditText cant;
    private Resources resources;
    private Spinner material, dije, tipo;
    private String ma[], di[], ti[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        valor = (TextView)findViewById(R.id.lblvalor);
        cant = (EditText)findViewById(R.id.txtCantidad);
        material= (Spinner)findViewById(R.id.cmbMaterial);
        dije = (Spinner)findViewById(R.id.cmbDije);
        tipo = (Spinner)findViewById(R.id.cmbMaterial);
        resources = this.getResources();
        ma = resources.getStringArray(R.array.material);
        di = resources.getStringArray(R.array.dije);
        ti = resources.getStringArray(R.array.tipo);
    }

}
