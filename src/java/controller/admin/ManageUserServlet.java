/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDTO;

/**
 *
 * @author HuuThanh
 */
@WebServlet(name = "ManageUserServlet", urlPatterns = {"/ManageUserServlet"})
public class ManageUserServlet extends HttpServlet {

    private final String MANAGEUSERPAGE = "admin_users.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
//            String action = request.getParameter("action");
//            if (action == null) {
//                    UserDAO dao = new UserDAO();
//                    List<UserDTO> user1 = dao.getUser();
//                    request.setAttribute("user", user1);
//                    request.getRequestDispatcher("admin/customer.jsp").forward(request, response);
//                }
//                if (action.equals("update")) {
//                    String user_id = request.getParameter("user_id");
//                    String isAdmin = request.getParameter("permission");
//                    int id = Integer.parseInt(user_id);
//                    UserDAO dao = new UserDAO();
//                    dao.setAdmin(id, isAdmin);
//                    response.sendRedirect("customermanager");
//                }
            
            UserDAO uDao = new UserDAO();
            List<UserDTO> list = uDao.getData();

            request.setAttribute("LISTUSERS", list);
            request.setAttribute("action", "MNGUSER");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(MANAGEUSERPAGE).forward(request, response);
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
