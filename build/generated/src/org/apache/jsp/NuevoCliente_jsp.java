package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class NuevoCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <!--bootrap-->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\n");
      out.write("        <!--sweetalert-->\n");
      out.write("         <link href=\"css/sweetalert.css\" rel=\"stylesheet\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("            ");

        if(request.getAttribute("mensaje")!= null && request.getAttribute("tipo")!=null) {
    
      out.write("\n");
      out.write("    <input type=\"text\" hidden=\"\"  id=\"txt_mensaje\" value=\"");
      out.print(request.getAttribute("mensaje"));
      out.write("\"/>\n");
      out.write("    <input type=\"text\" hidden=\"\"   id=\"txt_tipo\" value=\"");
      out.print(request.getAttribute("tipo"));
      out.write("\" />\n");
      out.write("    <script>\n");
      out.write("            var mensaje = document.getElementById(\"txt_mensaje\").value;\n");
      out.write("            var tipo = document.getElementById(\"txt_tipo\").value;\n");
      out.write("             window.onload = function () {\n");
      out.write("                       swal(\"mensaje\",mensaje,tipo);\n");
      out.write("                      };\n");
      out.write("    </script>   \n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"card card-register mx-auto mt-1 col-md-6\">\n");
      out.write("                <div class=\"card-header bg-light\">Registrar nuevo cliente</div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form action=\"PrincipalController?menu=cliente&accion=guardar\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"form-row\">\n");
      out.write("                                <div class=\"col-md-12 mb-2\">\n");
      out.write("                                    <label>CEDULA</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_cedula\" type=\"number\"  placeholder=\"Ingrese su Cedula de identidad\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-12 mb-2\">\n");
      out.write("                                    <label>NOMBRES COMPLETOS</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_nombre\" type=\"text\"  placeholder=\"Ingrese sus nombres Completos\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col-md-12 mb-2\">\n");
      out.write("                                    <label>TELEFONO</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_telefono\" type=\"number\"  placeholder=\"Ingrese numero telefonico\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-12 mb-2\">\n");
      out.write("                                    <label>CORREO</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_correo\" type=\"email\" placeholder=\"Ingrese su correo electronico\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" name=\"guardar\" class=\"btn btn-secondary mt-4 w-100\">guardar</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("     <script src=\"js/sweetalert.min.js\"></script>\n");
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
