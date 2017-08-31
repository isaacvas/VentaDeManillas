package com.example.cesar.ventademanillas;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    private TextView valor;
    private EditText cant;
    private Resources resources;
    private Spinner material, dije, tipo;
    private String ma[], di[], ti[];
    private RadioButton dolar, peso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        valor = (TextView) findViewById(R.id.lblvalor);
        cant = (EditText) findViewById(R.id.txtCantidad);
        material = (Spinner) findViewById(R.id.cmbMaterial);
        dije = (Spinner) findViewById(R.id.cmbDije);
        tipo = (Spinner) findViewById(R.id.cmbMaterial);
        resources = this.getResources();
        ma = resources.getStringArray(R.array.material);
        di = resources.getStringArray(R.array.dije);
        ti = resources.getStringArray(R.array.tipo);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ma);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, di);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ti);
        material.setAdapter(adapter1);
        dije.setAdapter(adapter2);
        tipo.setAdapter(adapter3);
    }

    public boolean validar() {
        if (cant.getText().toString().isEmpty()) {
            cant.setError(resources.getString(R.string.message_error_uno));
            return false;
        } else {
            if (Integer.parseInt(cant.getText().toString()) == 0) {
                cant.setError(resources.getString(R.string.message_error_uno));
                return false;
            }
        }
        if (!dolar.isChecked() && !peso.isChecked()) {
            Toast.makeText(this, R.string.message_error_dos, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }
    public void calcular(View v){
        int spinnerMaterial, spinnerDije, spinnerTipo, cantidad;
        double valorPagar = 0, producto;
        boolean dol;
        valor.setText("");

        if (validar()){
            cantidad = Integer.parseInt(cant.getText().toString());
            spinnerMaterial = material.getSelectedItemPosition();
            spinnerDije = dije.getSelectedItemPosition();
            spinnerTipo = tipo.getSelectedItemPosition();

            if (dolar.isChecked()){

                producto = 1;
            }else {
                producto = 3200;
            }

            if (spinnerMaterial == 0 && spinnerDije == 0 &&  spinnerTipo == 0) {
                valorPagar = cantidad * 100 * producto;
            }else if(spinnerMaterial == 0 && spinnerDije == 0 &&  spinnerTipo == 1){
                    valorPagar =  cantidad * 100*producto;
            }else if(spinnerMaterial == 0 && spinnerDije == 0 && spinnerTipo == 2){
                 valorPagar =  cantidad * 80*producto;
            }else if(spinnerMaterial == 0 && spinnerDije == 0 &&  spinnerTipo == 3){
                 valorPagar =  cantidad * 70*producto;
            }else if(spinnerMaterial == 0 && spinnerDije == 1 &&  spinnerTipo == 0){
                 valorPagar =  cantidad * 120*producto;
            }else if(spinnerMaterial == 0 && spinnerDije == 1 &&  spinnerTipo == 1){
                valorPagar =  cantidad * 120*producto;
            }else if(spinnerMaterial == 0 && spinnerDije == 1 &&  spinnerTipo == 2){
                 valorPagar =  cantidad * 100*producto;
            }else if(spinnerMaterial == 0 && spinnerDije == 1 &&  spinnerTipo == 3){
                 valorPagar =  cantidad * 90*producto;
            }else if(spinnerMaterial == 1 && spinnerDije == 0 &&  spinnerTipo == 0){
                 valorPagar =  cantidad * 90*producto;
            }else if(spinnerMaterial == 1 && spinnerDije == 0 &&  spinnerTipo == 1){
                valorPagar =  cantidad * 90*producto;
            }else if(spinnerMaterial == 1 && spinnerDije == 0 &&  spinnerTipo == 2){
                 valorPagar =  cantidad * 70*producto;
            }else if(spinnerMaterial == 1 && spinnerDije == 0 &&  spinnerTipo == 3){
                 valorPagar =  cantidad * 50*producto;
            }else if(spinnerMaterial == 1 && spinnerDije == 1 &&  spinnerTipo == 0){
                 valorPagar =  cantidad * 110*producto;
            }else if(spinnerMaterial == 1 && spinnerDije == 1 &&  spinnerTipo == 1){
                valorPagar =  cantidad * 110*producto;
            }else if(spinnerMaterial == 1 && spinnerDije == 1 &&  spinnerTipo == 2){
                 valorPagar =  cantidad * 90*producto;
            }else if(spinnerMaterial == 1 && spinnerDije == 1 &&  spinnerTipo == 3){
                 valorPagar =  cantidad * 80*producto;
            }

            valor.setText("" + String.format("%.2f",  valorPagar) );
        }
    }



    public void borrar(View v){
        cant.setText("");
        material.setSelection(0);
        dije.setSelection(0);
        tipo.setSelection(0);
        dolar.setChecked(false);
        peso.setChecked(false);
        valor.setText("");
    }


}
