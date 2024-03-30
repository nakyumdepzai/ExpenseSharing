/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Controller;

import es.Model.calculateDAO;
import es.Model.pairDTO;
import es.Model.personDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CalculateServlet", urlPatterns = {"/CalculateServlet"})
public class CalculateServlet extends HttpServlet {

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
        ArrayList<personDTO> p = new ArrayList<>();
        ArrayList<pairDTO> pair = new ArrayList<>();
        ArrayList<personDTO> plon = new ArrayList<>();
        ArrayList<personDTO> pbe = new ArrayList<>();
        //get parameter from jsp
        int numberOfPeople = Integer.parseInt(request.getParameter("numberOfPeople"));
        try {
            //call DAO
            calculateDAO dao = new calculateDAO();
            dao.nhapTienShareNow(numberOfPeople, request, p);
            dao.chia2Mang(numberOfPeople, p, plon, pbe);
            dao.setPair(numberOfPeople, p, pair);
            pair = dao.tinhTien(pair, plon, pbe);
            for (int i = 0; i < numberOfPeople; i++) {
                String name = request.getParameter("person" + (i + 1));
                double flex = Double.parseDouble(request.getParameter("amount" + (i + 1)));
                personDTO person = new personDTO();
                person.setName(name);
                person.setFlex(flex);
                p.add(person);
            }
            //set diff
            request.setAttribute("p", p);
            request.setAttribute("pair", pair);
        } finally {
            RequestDispatcher dispatcher = request.getRequestDispatcher("shareNow.jsp");
            dispatcher.forward(request, response);
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
