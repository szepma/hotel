package Controller;

import Model.Bookings;
import Service.BookingService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class BookingController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //addNewBooking
            if (request.getParameter("task").equals("addNewBooking")) {
                JSONObject returnValue = new JSONObject();
                
                if (!request.getParameter("arrival").isEmpty() && !request.getParameter("leave").isEmpty() && !request.getParameter("noGuests").isEmpty() && !request.getParameter("guest").isEmpty() && !request.getParameter("sevices").isEmpty() && !request.getParameter("status").isEmpty() && !request.getParameter("room").isEmpty()) {
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    
                    Date bookingDate = formatter.parse(formatter.format(new Date()));
                    Date arrivalDate = formatter.parse(request.getParameter("arrival"));
                    Date leaveDate = formatter.parse(request.getParameter("leave"));
                    Integer noGuest = Integer.parseInt(request.getParameter("noGuests"));
                    Integer guest = Integer.parseInt(request.getParameter("guest"));
                    Integer service = Integer.parseInt(request.getParameter("sevices"));
                    Integer status = Integer.parseInt(request.getParameter("status"));
                    Integer room = Integer.parseInt(request.getParameter("room"));

                    Bookings bo = new Bookings(0, bookingDate, arrivalDate, leaveDate, noGuest, guest, service, status, room);

                    String result = BookingService.addNewBooking(bo);
                    returnValue.put("result", result);
                }
                else {
                    returnValue.put("result", "A mezők nincsenek megfelelően kitöltve");
                }
                out.print(returnValue);
            }   
            //end
            
            //updateBookingStatusById
            if (request.getParameter("task").equals("updateBookingStatusById")) {
                JSONObject returnValue = new JSONObject();
                
                if (!request.getParameter("id").isEmpty() && !request.getParameter("status").isEmpty()) {
                    Bookings bo = Bookings.getBookingsById(Integer.parseInt(request.getParameter("id")));
                    bo.setBookingstatusid(Integer.parseInt(request.getParameter("status")));
                    
                    String result = BookingService.updateBookingStatusById(bo);
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
