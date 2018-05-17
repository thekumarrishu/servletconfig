/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import model.League;
/**
 *
 * @author INNOCENT
 */
public class addleagueform extends HttpServlet {
   //There are the default seasons for the user
   private static final String DEFAULT_SEASONS = "Spring,Summer,Fall,Winter";
   
   //This variable holds the set of seasons
   
   private String[] SEASONS;
   
   //The init method configures the set of seasons.
   
   public void init()
   {
       String seasonslist = getInitParameter("season-list");
       if ( seasonslist == null)
       {
           seasonslist=DEFAULT_SEASONS;
       }
       SEASONS = seasonslist.split(",");
   }
   private void generateview(HttpServletRequest request, HttpServletResponse response)throws IOException
   {
       //set page title
       
       String pagetitle = "Duke's Soccer League: Add a New League";
       
       List errormsg = (List) request.getAttribute("errormsg");
        // specify the content type in HTML
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       
       
       //Generate the HTML page
       
       out.println("<html>");
       out.println("<head>");
       out.println("<title>"+pagetitle+"</title>");
       out.println("</head>");
       out.println("<body bgcolor='white'>");
       
       //generate page heading
       
       out.println("<!-- page Heading -->");
       out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
        out.println("  <td><h3>" + pagetitle + "</h3></td>");
        out.println("</tr>");
        out.println("</table>");
        // report any error 
        
      if (errormsg !== null)
      {
          out.println("<p>");
          out.println("<font color ="red"> Please correct the following errors:");
          out.println("<ul");
          Iterator items = errormsg.iterator();
          while(items.hasNext())
          {
              String message = (String)items.next();
              out.println("<li>"+message+"</li>");
          }
          out.println("</ul>");
          out.println("</font>");
          out.println("</p>");
      }
      //Generate main body
      out.println("<p>");
      out.println("This form allows you to create a new soccer league.");
      out.println("</p>");
      out.println("<form action='addleague' method='POST'>");
      
      //repopulate the yeat field
      
      String year = request.getParameter("year");
      if ( year== null )
      {
          year="";
      }
      out.println("Year : <input type ='text' name ='year' value='" + year + "'/> <br/><br/>");
    
      //Repopulate the season field
      
      String season = request.getParameter ("season");
      out.println ("Season : <select name = 'season'>");
      if ((season == null)||season.equals("UNKNOWN"))
      {
          out.println("<option value = 'UNKNOWN'>select..</option>");
      }
      for (int i = 0;i< SEASONS.length;i++)
      {
          out.println("<option value = '" + SEASONS[i] + "'");
          if(SEASONS[i].equal(season))
          {
              out.println("Selected");
          }
          out.println();
      }
      out.println("</select></br></br>");
      
      
      //repopulate the title field
      
      String title = request.getParameter("title");
      if ( title==null)
      {
          title="";
      }
      out.println("Title: <input type = 'text' name = 'tittle' value = '"+title+"'/></br></br>");
      out.println("<input type = 'submit' value = 'Add League'/>");
      out.println("</form>");
      
      out.println("</body>");
      out.println("</html>");
   }
}
      