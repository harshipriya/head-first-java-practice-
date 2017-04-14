import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class MyServlet extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
String title="PhraseoMatic ";
response.setContentType("text/html");
printWriter out=response.getWriter();

out.println("<HTML><HEAD><TITLE>");
out.println("PHRASEOMATIC");
out.println("</TITLE></HEAD><BODY>");
out.println("Title");
out.println("<p>"+PhaseOMatic.makePhrase());
out.println("<p><a href=\"MyServlet\">make other phrase</a></p>");
out.println("</BODY><HTML>");
out.close();

}
}