package Task2;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yat Rehani
 */
@WebServlet(urlPatterns = {"/submit", "/getResults"})
public class ClickerServlet extends HttpServlet {
    
    ClickerModel cm = null;  // The "business model" for this app

    // Initiate this servlet by instantiating the model that it will use.
    @Override
    public void init() {
        cm = new ClickerModel();
    }

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
            String nextView = null;
            request = processRequestForMobile(request, response);
        
        
            if(request.getServletPath()=="/index")
                nextView="index.jsp";
            
            else{
                                    
            String s = cm.getResults();
            if(s.length()>0){
                nextView="result.jsp";
                request.setAttribute("results", s);
            }
            else
                nextView="noresult.jsp";
            }
            // Transfer control over the correct "view"
            RequestDispatcher view = request.getRequestDispatcher(nextView);
            view.forward(request, response);
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
        
        request = processRequestForMobile(request, response);
        cm.postAnswer(request.getParameter("answer"));   
        // Transfer control over the correct "view"
        RequestDispatcher view = request.getRequestDispatcher("submit.jsp");
        view.forward(request, response);
    }
    
    protected HttpServletRequest processRequestForMobile(HttpServletRequest request, HttpServletResponse response){
         String ua = request.getHeader("User-Agent");

        boolean mobile;
        // prepare the appropriate DOCTYPE for the view pages
        if (ua != null && ((ua.indexOf("Android") != -1) || (ua.indexOf("iPhone") != -1))) {
            mobile = true;
            /*
             * This is the latest XHTML Mobile doctype. To see the difference it
             * makes, comment it out so that a default desktop doctype is used
             * and view on an Android or iPhone.
             */
            request.setAttribute("doctype", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            mobile = false;
            request.setAttribute("doctype", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }
        return request;
    }

}
