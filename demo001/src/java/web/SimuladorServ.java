/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dao.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import logica.Prestamo;

/**
 *
 * @author Vinni
 */
@WebServlet(name = "SimuladorServ", urlPatterns = {"/Calcular"})
public class SimuladorServ extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nombre = request.getParameter("nombre");
            String fecha = request.getParameter("fecha");
            String valor = request.getParameter("valor");
            String plazo = request.getParameter("plazo");

            Date fechaX = null;
            if (fecha.isEmpty()) {

                return;
            } else {
                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    fechaX = sd.parse(fecha);
                } catch (ParseException ex) {

                }

            }
            int plazoN = Integer.parseInt(plazo);
            Double valorN = Double.parseDouble(valor);
            Cliente elCliente = new Cliente(nombre, fechaX);

            Prestamo pre = new Prestamo(elCliente, plazoN, valorN);
            Double res = pre.hacerSimulacion();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            //out.println("<h3>Se realiza la simulacion y el valor a pagar es: </h3>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>$ " + res + "</h1>");
            out.println("<label for=\"name\">Nombre:</label>");
            out.println("<input type=\"text\" id=\"name\" name=\"nombre\" value=\""+nombre+"\"/>");
            out.println("<br/>");
            out.println("<label for=\"name\">Fecha</label>");
            out.println("<input type=\"text\" id=\"fecha\" name=\"fecha\" value=\""+fecha+"\"/>");
            out.println("<br/>");
            out.println("<label for=\"name\">Valor</label>");
            out.println("<input type=\"text\" id=\"valor\" name=\"valor\" value=\""+valor+"\"/>");
            out.println("<br/>");
            out.println("<label for=\"name\">Plazo:</label>");
            out.println("<input type=\"text\" id=\"plazo\" name=\"plazo\" value=\""+plazo+"\"/>");
            out.println("<br/>");
            out.println("<label for=\"name\">Pago mes</label>");
            out.println("<input type=\"text\" id=\"pago\" name=\"pago\" value=\""+res+"\"/>");
            out.println("<br/>");            
            out.println("</body>");
            out.println("</html>");
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

}
