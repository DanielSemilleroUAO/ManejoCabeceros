/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author delga
 */
@WebServlet("/ServletHeaders")
public class Servlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String metodoHttp = req.getMethod();
        String uri = req.getRequestURI();
        Enumeration<String> cabeceros = req.getHeaderNames();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Headers HTTP</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Headers HTTP</h1>");
        out.print("<br />");
        out.print("Metodo Http: " + metodoHttp);
        out.print("<br />");
        out.print("URI solicitada: " + uri);
        while (cabeceros.hasMoreElements()) {
            String nombreCabecero = (String) cabeceros.nextElement();
            out.print("<br />");
            out.print("<b>" + nombreCabecero + "</b>: " + req.getHeader(nombreCabecero));
        }
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
    
}
