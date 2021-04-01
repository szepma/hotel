package Controller;

import Model.RoomStatus;
import Service.RoomStatusService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class RoomStatusController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //addNewStatus
            if (request.getParameter("task").equals("addNewRoomStatus")) {
                JSONObject returnValue = new JSONObject();
                
                if (!request.getParameter("status").isEmpty()) {
                    String status = request.getParameter("status");
                    
                    RoomStatus rs = new RoomStatus(0, status);
                    
                    String result = RoomStatusService.addNewRoomStatus(rs);
                    returnValue.put("result", result);
                }
                else {
                    returnValue.put("result", "A mezők nincsenek megfelelően kitöltve");
                }
                out.print(returnValue.toString());
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
