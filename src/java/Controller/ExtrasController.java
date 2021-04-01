package Controller;

import Model.Extras;
import Service.ExtrasService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class ExtrasController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //addNewExtra
            if (request.getParameter("task").equals("addNewExtra")) {
                JSONObject returnValue = new JSONObject();
                
                if (!request.getParameter("extraName").isEmpty() && !request.getParameter("extraDesc").isEmpty()) {
                    String extraName = request.getParameter("extraName");
                    String extraDesc = request.getParameter("extraDesc");
                    
                    Extras extra = new Extras(0, extraName, extraDesc);
                    
                    String result = ExtrasService.addNewExtra(extra);
                    returnValue.put("result", result);
                }
                else {
                    returnValue.put("result", "A mezők nincsenek megfelelően kitöltve");
                }
                out.print(returnValue.toString());
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
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
