package com.example.semana12b.ui.servicio;

import com.example.semana12b.ui.entidad.Comprobante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServicioRest {
    //Crud de Comprobante


    @GET("comprobante")
    public abstract Call<List<Comprobante>> listaComprobante();


    @PUT("comprobante")
    public abstract Call<Comprobante> actualizaComprobante(@Body Comprobante opcion);

    @DELETE("comprobante/{idComprobante}")
    public abstract Call<Comprobante> eliminaComprobante(@Path("idComprobante") int id);

    @PUT("comprobante")
    public abstract Call<Comprobante> registraComprobante(@Body Comprobante comprobante);
}
