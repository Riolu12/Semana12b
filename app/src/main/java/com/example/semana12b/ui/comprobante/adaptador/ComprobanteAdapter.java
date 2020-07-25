package com.example.semana12b.ui.comprobante.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.semana12b.MainActivity;
import com.example.semana12b.ui.comprobante.entidad.Comprobante;
import com.example.semana12b.R;

import java.util.List;

public class ComprobanteAdapter extends ArrayAdapter<Comprobante> {
    private Context context;
    private List<Comprobante> comprobantes;

    public ComprobanteAdapter(Context context, int resource, List<Comprobante> comprobantes) {
        super(context, resource, comprobantes);
        this.context = context;
        this.comprobantes = comprobantes;
    }

    @Override
    public View getView(final int pos, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_main, parent, false);


        TextView txtId = (TextView) rowView.findViewById(R.id.txtIdComprobante);
        TextView txtFechaRegistro = (TextView) rowView.findViewById(R.id.txtComprobanteFechaRegistro);
        TextView txtFechaPago = (TextView) rowView.findViewById(R.id.txtComprobanteFechaPago);
        TextView txtEstado = (TextView) rowView.findViewById(R.id.txtComprobanteEstado);
        TextView txtPedido = (TextView) rowView.findViewById(R.id.txtComprobantePedido);
        TextView txtCliente = (TextView) rowView.findViewById(R.id.txtComprobanteCliente);
        TextView txtUsuario = (TextView) rowView.findViewById(R.id.txtComprobanteUsuario);

        txtId.setText(String.format("#ID: %d", comprobantes.get(pos).getIdcomprobante()));
        txtFechaRegistro.setText(String.format("FECHAREG: %s", comprobantes.get(pos).getFechaRegistro()));
        txtFechaPago.setText(String.format("FECHAPAGO: %s", comprobantes.get(pos).getFechaPago()));
        txtEstado.setText(String.format("ESTADO: %s", comprobantes.get(pos).getEstado()));
        txtPedido.setText(String.format("PEDIDO: %s", comprobantes.get(pos).getIdpedido()));
        txtCliente.setText(String.format("CLIENTE: %s", comprobantes.get(pos).getIdcliente()));
        txtUsuario.setText(String.format("USUARIO: %s", comprobantes.get(pos).getIdusuario()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("var_id", String.valueOf(comprobantes.get(pos).getIdcomprobante()));
                intent.putExtra("var_fechaRegistro", comprobantes.get(pos).getFechaRegistro());
                intent.putExtra("var_fechaPago", comprobantes.get(pos).getFechaPago());
                intent.putExtra("var_estado", comprobantes.get(pos).getEstado());
                intent.putExtra("var_pedido", comprobantes.get(pos).getIdpedido());
                intent.putExtra("var_cliente", comprobantes.get(pos).getIdcliente());
                intent.putExtra("var_usuario", comprobantes.get(pos).getIdusuario());
                intent.putExtra("var_metodo", "VER");
                context.startActivity(intent);
            }
        });

        return rowView;
    }

}

