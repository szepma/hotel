package Controller;

import Model.Addresses;
import Service.AddressService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class AddressController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            //addNewAddress
            if (request.getParameter("task").equals("addNewAddress")) {
                JSONObject returnValue = new JSONObject();
                
                if (!request.getParameter("houseNumber").isEmpty() &&
                        !request.getParameter("city").isEmpty() &&
                        !request.getParameter("street").isEmpty()) {
                    Integer houseNumber = Integer.parseInt(request.getParameter("houseNumber"));
                    Integer city = Integer.parseInt(request.getParameter("city"));
                    Integer street = Integer.parseInt(request.getParameter("street"));
                    
                    Addresses ad = new Addresses(0, houseNumber, city, street);
                    
                    String result = AddressService.addNewAddress(ad);
                    returnValue.put("result", result);
                }
                else {
                    returnValue.put("result", "A mezők nincsenek megfelelően kitöltve - Address");
                }
                out.print(returnValue.toString());
            }
            //end
            
            //checkAddress
            if (request.getParameter("task").equals("checkAddress")) {
                JSONObject returnValue = new JSONObject();
                
                Addresses address = AddressService.checkAddress(Integer.parseInt(request.getParameter("house")),
                        Integer.parseInt(request.getParameter("city")),
                        Integer.parseInt(request.getParameter("street")));
                
                if (address.getAddressid() == -1) {
                    returnValue.put("result", "Nincs ilyen");
                }
                else {
                    returnValue.put("result", address.getAddressid());
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
