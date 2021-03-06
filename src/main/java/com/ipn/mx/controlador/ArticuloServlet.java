/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando Mtz
 */
@WebServlet(name = "ArticuloServlet", urlPatterns = {"/ArticuloServlet"})
public class ArticuloServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String accion = request.getParameter("accion");
        if (accion.equals("listaDeArticulos")) {
            listadoArticulos(request, response);
        }else if(accion.equals("nuevo")) {
            crearArticulo(request, response);
        }else if(accion.equals("actualizar")) {
            actualizarArticulo(request, response);
        }else if(accion.equals("eliminar")) {
            eliminarArticulo(request, response);
        } else if(accion.equals("guardar")) {
            almacenarArticulo(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listadoArticulos(HttpServletRequest request, HttpServletResponse response) {
    
    }
    
    private void crearArticulo(HttpServletRequest request, HttpServletResponse response) {
    
    }
    
    private void actualizarArticulo(HttpServletRequest request, HttpServletResponse response) {
    
    }
    
    private void eliminarArticulo(HttpServletRequest request, HttpServletResponse response) {
    
    }
    
    private void almacenarArticulo(HttpServletRequest request, HttpServletResponse response) {
    
    }
    
}
