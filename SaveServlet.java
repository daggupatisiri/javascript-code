
package controller;

import dao.IUserDetailDao;
import dao.UserDetailDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDetail;
public class SaveServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IUserDetailDao dao=new UserDetailDaoImpl();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username,password,fullname,email,address,role;
            username=request.getParameter("username");
            password=request.getParameter("password");
            fullname=request.getParameter("fullname");
            email=request.getParameter("email"); 
            address=request.getParameter("address"); 
            role=request.getParameter("role");
            
            UserDetail user=new UserDetail();
            user.setUsername(username);
            user.setPassword(password);
            user.setFullname(fullname);
            user.setEmail(email);
            user.setAddress(address);
            user.setRole(role);
            
            int status=dao.save(user);
                out.println("<p>Record status..</p>"+status);
            if(status>0)
            {
                out.println("<p>Record saved successfully...</p>");
                request.getRequestDispatcher("index.html").include(request, response);
            }
            else{
                out.println("Sorry! unable to save record.");
            }
               
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
