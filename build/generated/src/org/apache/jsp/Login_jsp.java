package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!--estilos css-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilos.css\">\n");
      out.write("        <!--bootrap-->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\n");
      out.write("         <!--sweetalert-->\n");
      out.write("        <link href=\"css/sweetalert.css\" rel=\"stylesheet\">\n");
      out.write("         \n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"LoginController\" method=\"post\">\n");
      out.write("\n");
      out.write("            <div class=\"cuadrado\">    \n");
      out.write("                <div class=\"mitad1\">\n");
      out.write("                    <div class=\"mitad2\">\n");
      out.write("                        <div class=\"dentro mb-3\">\n");
      out.write("                            \n");
      out.write("                              <label class=\"form-label \">Usuario</label>\n");
      out.write("                                  <div class=\"user\">\n");
      out.write("                                      <i class=\"bi bi-person logo\"></i>\n");
      out.write("                                      <input name=\"txt_nombre\" type=\"text\"class=\"form-control\"  placeholder=\"Ingrese su usuario\" >\n");
      out.write("                                   </div>\n");
      out.write("                              \n");
      out.write("                              <label  class=\"form-label\">Password</label>\n");
      out.write("                                   <div class=\"contraseña logo\">\n");
      out.write("                                   <i class=\"bi bi-file-lock\"></i>\n");
      out.write("                                   <input name=\"txt_pass\" type=\"password\" class=\"form-control\" placeholder=\"Ingrese su contraseña\">\n");
      out.write("                                  </div>\n");
      out.write("                             <button type=\"submit\" class=\"btn btn-secondary mt-4 w-100\">Ingresar</button>\n");
      out.write("                         </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"circulo\">      \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("     ");

            if (request.getAttribute("mensaje") != null) {
        
      out.write("\n");
      out.write("        <input type=\"text\" hidden=\"\" id=\"txtmensaje\" value=\"");
      out.print(request.getAttribute("mensaje").toString());
      out.write("\"/>\n");
      out.write("        <script>\n");
      out.write("            window.onload = function () {\n");
      out.write("                 swal(\"\", document.getElementById(\"txtmensaje\").value, \"info\");\n");
      out.write("             };\n");
      out.write("        </script>   \n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <script src=\"js/sweetalert.min.js\"></script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
