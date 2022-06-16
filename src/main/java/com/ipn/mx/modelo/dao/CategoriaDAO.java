/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkdestiny
 */
public class CategoriaDAO {
    private static final String SQL_INSERT="CALL spInsertar(?, ?);";
    private static final String SQL_UPDATE="CALL spActualizar (?, ? ,?);";
    private static final String SQL_DELETE="CALL spEliminar(?);";
    private static final String SQL_READ="select * from categoria where idCategoria = ?;";
    private static final String SQL_READ_ALL="select * from categoria;";
 
    private Connection conexion;
    
     public Connection obtenerConexion() {
        //obtener conexion
        String usuario = "nqbwexzkhkyokp";
        String clave = "44e6c9fed0157519e329b0f2449647e087be9004d2fdcdc99a185d390cebe97a";
        String url = "jdbc:postgresql://ec2-34-225-159-178.compute-1.amazonaws.com:5432/dcllhv8me3p40t";
        //String url = "jdbc:mysql://localhost:3306/EscuelaWeb?
        //serverTimeZone=America/Mexico_City&allowPublicKeyRetrieval=true&
        //useSSL=false";

        String driverBD = "org.postgresql.Driver";

        try {
            Class.forName(driverBD);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion;
    }

   public void create(CategoriaDTO dto) throws SQLException{
       obtenerConexion();
       CallableStatement cs = null;
       try{
           cs = conexion.prepareCall(SQL_INSERT);
           cs.setString(1, dto.getEntidad().getNombreCategoria());
           cs.setString(2, dto.getEntidad().getDescripcionCategoria());
           cs.executeUpdate();
       }finally{
           if (cs != null) cs.close();
           if (conexion != null) conexion.close();
       }
   }
   public void update(CategoriaDTO dto) throws SQLException{
       obtenerConexion();
       CallableStatement cs = null;
       try{
           cs = conexion.prepareCall(SQL_UPDATE);
           cs.setInt(1, dto.getEntidad().getIdCategoria());
           cs.setString(2, dto.getEntidad().getNombreCategoria());
           cs.setString(3, dto.getEntidad().getDescripcionCategoria());
           cs.executeUpdate();
       }finally{
           if (cs != null) cs.close();
           if (conexion != null) conexion.close();
       }
   }
   public void delete(CategoriaDTO dto) throws SQLException{
       obtenerConexion();
       CallableStatement cs = null;
               
       try{
           cs = conexion.prepareCall(SQL_DELETE);
           cs.setInt(1, dto.getEntidad().getIdCategoria());
           cs.executeUpdate();
       }finally{
           if (cs != null) cs.close();
           if (conexion != null) conexion.close();
       }
   }
   public CategoriaDTO read(CategoriaDTO dto) throws SQLException{
       obtenerConexion();
       PreparedStatement ps = null;
       ResultSet rs = null;
       try{
           ps = conexion.prepareStatement(SQL_READ);
           ps.setInt(1, dto.getEntidad().getIdCategoria());
           rs = ps.executeQuery();
           List resultados = obtenerResultados(rs);
           if (resultados.size() > 0){
               return (CategoriaDTO) resultados.get(0);
           }else{
               return null;
           }
       }finally{
           if (ps != null) ps.close();
           if (conexion != null) conexion.close();
       }
   }
   
   public List readAll() throws SQLException{
       obtenerConexion();
       PreparedStatement ps = null;
       ResultSet rs = null;
       try{
           ps = conexion.prepareStatement(SQL_READ_ALL);
           rs = ps.executeQuery();
           List resultados = obtenerResultados(rs);
           if (resultados.size() > 0){
               return  resultados;
           }else{
               return null;
           }
       }finally{
           if (ps != null) ps.close();
           if (conexion != null) conexion.close();
       }
   }

    private List obtenerResultados(ResultSet rs) throws SQLException{
        List resultados = new ArrayList();
        while (rs.next()) {     
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setIdCategoria(rs.getInt("idCategoria"));
            dto.getEntidad().setNombreCategoria(rs.getString("nombreCategoria"));
            dto.getEntidad().setDescripcionCategoria(rs.getString("descripcionCategoria"));
            resultados.add(dto);
        }
        return resultados;
    }
    
    
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        CategoriaDTO dto = new CategoriaDTO();
        try{
            System.out.println(dao.readAll());
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
