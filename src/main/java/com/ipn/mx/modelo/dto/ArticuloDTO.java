/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Articulo;
import lombok.Data;

/**
 *
 * @author Fernando Mtz
 */
@Data
public class ArticuloDTO {
    private Articulo entidad;

    public ArticuloDTO() {
        entidad = new Articulo();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("idArticulo").append(getEntidad().getIdArticulo()).append("\n");
        sb.append("nombre").append(getEntidad().getNombre()).append("\n");
        sb.append("cantidad").append(getEntidad().getCantidad()).append("\n");
        sb.append("precio").append(getEntidad().getPrecio()).append("\n");
        
        return sb.toString();
    }
}
