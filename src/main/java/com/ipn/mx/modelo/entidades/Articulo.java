package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author escom
 */

@Data
@NoArgsConstructor
public class Articulo implements Serializable{
    private int idArticulo;
    private String nombre;
    private int cantidad;
    private float precio;
    
    
}
