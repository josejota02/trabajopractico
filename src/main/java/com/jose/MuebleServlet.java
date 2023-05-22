/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jose;

import com.jose.dao.MuebleDAO;
import com.jose.dao.MuebleDAOImpl;
import com.jose.model.Mueble;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/MuebleServlet")
public class MuebleServlet extends HttpServlet {

    private MuebleDAO muebleDao;

public MuebleServlet() {
    super();
    muebleDao = new MuebleDAOImpl();
}

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  this.procesarSolicitud(req, resp);
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    this.procesarSolicitud(req, resp);
}

protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    switch (request.getParameter("action")) {
        case "list":
            // this.list(request, response);
            break;
        case "create":
            this.create(request, response);
            break;
        case "read":
            // this.read(request, response);
            break;
        case "update":
            //this.update(request, response);
            break;
        case "delete":
            // this.delete(request, response);
            break;
        case "showRegister":
            this.showRegister(request, response);
            break;
        case "index":
            this.index(request, response);
            break;
        default:
           this.index(request, response);
            break;
    }
    
}

private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
}

private void showRegister(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
    RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
    dispatcher.forward(request, response);
}

private void create (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
    String nombre = request.getParameter("nombre");
    String color = request.getParameter("color");
    String diseno = request.getParameter("diseno");
    String precio = request.getParameter("precio");
    
    // Crear el objeto que se envía al BD
    Mueble objMueble = new Mueble();
    objMueble.setNombre(nombre);
    objMueble.setColor(color);
    objMueble.setDiseno(diseno);
    objMueble.setPrecio(precio);
    
    muebleDao.insert(objMueble);
    
    // Redireccionar al "index"
    this.index(request, response);
}
}


