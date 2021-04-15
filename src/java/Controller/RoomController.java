package Controller;

import Model.Rooms;
import Service.RoomsService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class RoomController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //addNewRoom
            if (request.getParameter("task").equals("addNewRoom")) {
                JSONObject returnValue = new JSONObject();
                
                if (!request.getParameter("capacity").isEmpty() && !request.getParameter("room_status").isEmpty() && !request.getParameter("extra").isEmpty()) {
                    Integer capacity = Integer.parseInt(request.getParameter("capacity"));
                    Integer roomStatus = Integer.parseInt(request.getParameter("room_status"));
                    Integer extra = Integer.parseInt(request.getParameter("extra"));
                    
                    Rooms room = new Rooms(0, capacity, roomStatus, extra);
                    
                    String result = RoomsService.addNewRoom(room);
                    returnValue.put("result", result);
                }
                else {
                    returnValue.put("result", "A mezők nincsenek megfelelően kitöltve");
                }
                out.print(returnValue.toString());
            }
            
            //updateRoomStatusById
            if (request.getParameter("task").equals("updateRoomStatusById")) {
                JSONObject returnValue = new JSONObject();
                
                if (!request.getParameter("id").isEmpty() && !request.getParameter("status").isEmpty()) {
                    Rooms room = Rooms.getRoomsById(Integer.parseInt(request.getParameter("id")));
                    room.setRoomStatusId(Integer.parseInt(request.getParameter("status")));
                    
                    String result = RoomsService.updateRoomStatusById(room);
                    returnValue.put("result", result);
                }
                else {
                    returnValue.put("result", "A mezők nincsenek jól kitöltve");
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
