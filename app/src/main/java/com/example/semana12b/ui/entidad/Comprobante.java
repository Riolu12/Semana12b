package com.example.semana12b.ui.entidad;

public class Comprobante {
    private int idcomprobante;
    private String fechaRegistro;
    private String fechaPago;
    private String estado;
    private String idpedido;
    private String idcliente;
    private String idusuario;


    public int getIdcomprobante() {
        return idcomprobante;
    }

    public void setIdcomprobante(int idcomprobante) {
        this.idcomprobante = idcomprobante;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(String idpedido) {
        this.idpedido = idpedido;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

}
