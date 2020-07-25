package com.example.semana12b.ui.comprobante;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.semana12b.MainActivity;
import com.example.semana12b.R;
import com.example.semana12b.ui.comprobante.entidad.Comprobante;
import com.example.semana12b.ui.comprobante.servicio.ServicioRest;
import com.example.semana12b.ui.comprobante.util.ConnectionRest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComprobanteActivity  extends AppCompatActivity {


    ServicioRest servicio;
    EditText edtIdComprobante, edtComprobanteFechaRegistro, edtComprobanteFechaPago, edtComprobanteEstado, edtComprobantePedido, edtComprobanteCliente, edtComprobanteUsuario;
    Button btnSave, btnDel ;
    TextView txtIdComprobante;
    final String metodo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprobante);

        setTitle("CRUD de Comprobante");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtIdComprobante = (TextView) findViewById(R.id.txtIdComprobante);
        edtIdComprobante = (EditText) findViewById(R.id.edtIdComprobante);
        edtComprobanteFechaRegistro=(EditText) findViewById(R.id.edtComprobanteFechaRegistro);
        edtComprobanteFechaPago=(EditText) findViewById(R.id.edtComprobanteFechaPago);
        edtComprobanteEstado=(EditText) findViewById(R.id.edtComprobanteEstado);
        edtComprobantePedido=(EditText) findViewById(R.id.edtComprobantePedido);
        edtComprobanteCliente=(EditText) findViewById(R.id.edtComprobanteCliente);
        edtComprobanteUsuario=(EditText) findViewById(R.id.edtComprobanteUsuario);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDel = (Button) findViewById(R.id.btnRolDel);

        servicio = ConnectionRest.getConnection().create(ServicioRest.class);
        Bundle extras = getIntent().getExtras();
        final String metodo=extras.getString("var_metodo");
        final String var_id = extras.getString("var_id");

        if (metodo.equals("VER")) {
            String var_fechaRegistro = extras.getString("var_fechaRegistro");
            String var_fechaPago = extras.getString("var_fechaPago");
            String var_estado = extras.getString("var_estado");
            String var_pedido = extras.getString("var_pedido");
            String var_cliente = extras.getString("var_cliente");
            String var_usuario = extras.getString("var_usuario");

            edtIdComprobante.setText(var_id);
            edtComprobanteFechaRegistro.setText(var_fechaRegistro);
            edtComprobanteFechaPago.setText(var_fechaPago);
            edtComprobanteEstado.setText(var_estado);
            edtComprobantePedido.setText(var_pedido);
            edtComprobanteCliente.setText(var_cliente);
            edtComprobanteUsuario.setText(var_usuario);
            edtIdComprobante.setFocusable(false);
        }else if (metodo.equals("REGISTRAR")) {
            txtIdComprobante.setVisibility(View.INVISIBLE);
            edtIdComprobante.setVisibility(View.INVISIBLE);
            btnDel.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Comprobante u = new Comprobante();
                u.setFechaRegistro(edtComprobanteFechaRegistro.getText().toString());
                u.setFechaPago(edtComprobanteFechaPago.getText().toString());
                u.setEstado(edtComprobanteEstado.getText().toString());
                u.setIdpedido(edtComprobantePedido.getText().toString());
                u.setIdcliente(edtComprobanteCliente.getText().toString());
                u.setIdusuario(edtComprobanteUsuario.getText().toString());
                if (metodo.equals("VER")) {
                    u.setIdcomprobante(Integer.parseInt(var_id));
                    mensaje("Se pulsó  actualizar");
                    update(u);
                } else if (metodo.equals("REGISTRAR")) {
                    mensaje("Se pulsó agregar");
                    add(u);
                }

                Intent intent = new Intent(ComprobanteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensaje("Se pulsó eliminar");
                delete(Integer.parseInt(var_id));
                Intent intent = new Intent(ComprobanteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void add(Comprobante u) {
        Call<Comprobante> call = servicio.registraComprobante(u);
        call.enqueue(new Callback<Comprobante>() {
            @Override
            public void onResponse(Call<Comprobante> call, Response<Comprobante> response) {
                if (response.isSuccessful()) {
                    mensaje("Registro exitoso");
                }
            }
            @Override
            public void onFailure(Call<Comprobante> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void update(Comprobante u) {
        Call<Comprobante> call = servicio.actualizaComprobante(u);
        call.enqueue(new Callback<Comprobante>() {
            @Override
            public void onResponse(Call<Comprobante> call, Response<Comprobante> response) {
                if (response.isSuccessful()) {
                    mensaje("Actualización exitosa");
                }
            }
            @Override
            public void onFailure(Call<Comprobante> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void delete(int id) {
        Call<Comprobante> call = servicio.eliminaComprobante(id);
        call.enqueue(new Callback<Comprobante>() {
            @Override
            public void onResponse(Call<Comprobante> call, Response<Comprobante> response) {
                if (response.isSuccessful()) {
                    mensaje("Eliminación exitosa");
                }
            }
            @Override
            public void onFailure(Call<Comprobante> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void mensaje(String msg) {
        Toast toast1 = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
        toast1.show();
    }

}

