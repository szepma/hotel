package Controller;

import Model.Guests;
import Service.GuestService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class GuestController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //addNewGuest
            if (request.getParameter("task").equals("addNewGuest")) {
                JSONObject returnValue = new JSONObject();
                
                if (!request.getParameter("firstname").isEmpty() && !request.getParameter("lastname").isEmpty() && !request.getParameter("email").isEmpty() && !request.getParameter("mobile").isEmpty() && !request.getParameter("address").isEmpty()) {
                    String firstName = request.getParameter("firstname");
                    String lastName = request.getParameter("lastname");
                    String email = request.getParameter("email");
                    String mobile = request.getParameter("mobile");
                    Integer address = Integer.parseInt(request.getParameter("address"));
                    
                    Guests gu = new Guests(0, firstName, lastName, email, mobile, address);
                    
                    String result = GuestService.addNewGuest(gu);
                    returnValue.put("result", result);
                }
                else {
                    returnValue.put("result", "A mezők nincsenek megfelelően kitöltve -- Guest");
                }
                out.print(returnValue.toString());
            }
            //end
            
            //checkGuest
            if (request.getParameter("task").equals("checkGuest")) {
                JSONObject returnValue = new JSONObject();
                
                Guests guest = GuestService.checkGuest(request.getParameter("email"));
                
                if (guest.getGuestid() == -1) {
                    returnValue.put("result", "Nincs ilyen");
                }
                else {
                    returnValue.put("result", guest.getGuestid());
                }
                out.print(returnValue);
            }
        }
        catch (Exception ex) {
            System.out.println("JSON hiba");
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
