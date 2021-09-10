package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Inicio_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if (session.getAttribute("Roles") != null) {


      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- sweealert!-->\n");
      out.write("        <link  href=\"css/sweetalert.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!--estilos css-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/estilos.css\">\n");
      out.write("        <!-- link de bootrap para los iconos!-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\">\n");
      out.write("        <!--bootrap-->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Inicio</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
                      if (request.getAttribute("mensaje") != null && request.getAttribute("tipo") != null) {
        
      out.write("\n");
      out.write("        <input type=\"text\" hidden=\"\"  id=\"txt_mensaje\" value=\"");
      out.print(request.getAttribute("mensaje"));
      out.write("\"/>\n");
      out.write("        <input type=\"text\" hidden=\"\"   id=\"txt_tipo\" value=\"");
      out.print(request.getAttribute("tipo"));
      out.write("\" />\n");
      out.write("        <script>\n");
      out.write("            var mensaje = document.getElementById(\"txt_mensaje\").value;\n");
      out.write("            var tipo = document.getElementById(\"txt_tipo\").value;\n");
      out.write("            window.onload = function () {\n");
      out.write("                swal(\"mensaje\", mensaje, tipo);\n");
      out.write("            };\n");
      out.write("        </script>   \n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("        <div> \n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light container-fluid bg-success\">\n");
      out.write("\n");
      out.write("                <div class=\"d-flex flex-row\">\n");
      out.write("                    <a  href=\"PrincipalController?menu=principal\"><img class=\"logo_jesus\"> </a> \n");
      out.write("                    <h2>Funenaria \"San Jose\"</h2>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("                <div class=\"container-fluid \">\n");
      out.write("\n");
      out.write("                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                        <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("\n");
      out.write("                        <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("                            <li class=\"nav-item dropdown\">\n");
      out.write("                                <a style=\" border: none\" class=\"btn btn-outline-success dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                    Empleados\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"PrincipalController?menu=empleado&accion=nuevo\" target=\"myframe\"><i class=\"bi bi-file-person-fill\"></i>  Nuevo</a></li>\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"PrincipalController?menu=empleado&accion=listar\"target=\"myframe\"><i class=\"bi bi-gear\"></i>  Acciones</a></li>\n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item dropdown\">\n");
      out.write("                                <a style=\" border: none\" class=\" btn btn-outline-success dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                    Clientes\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"PrincipalController?menu=cliente&accion=nuevo_cliente\" target=\"myframe\"><i class=\"bi bi-person-check\"></i>  Nuevo</a></li>\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"PrincipalController?menu=cliente&accion=listar_clientes\" target=\"myframe\"><i class=\"bi bi-gear\"></i>  Acciones</a></li>  \n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item dropdown\">\n");
      out.write("                                <a style=\" border: none\" class=\" btn btn-outline-success dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                    Servicios\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"PrincipalController?menu=servicios&accion=listar_servicios\" target=\"myframe\">Servicos Exequiales</a></li>\n");
      out.write("                                   \n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item dropdown\">\n");
      out.write("                                <a style=\" border: none\" class=\" btn btn-outline-success dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                    Inventario General\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"PrincipalController?menu=grupos&accion=listar_grupos\" target=\"myframe\">Grupos</a></li>\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"\" target=\"myframe\">Insumos y materiales</a></li>\n");
      out.write("                                   \n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"nav-item dropdown\">\n");
      out.write("                                <a style=\" border: none\" class=\" btn btn-outline-success dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                    Factura\n");
      out.write("                                </a>\n");
      out.write("                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"PrincipalController?menu=factura&accion=cargar_datos_funeraria&txt_codigo=1\" target=\"myframe\">Nueva</a></li>\n");
      out.write("                                    \n");
      out.write("                                </ul>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <div class=\"dropdown \">\n");
      out.write("                            <button style=\"border: none\" class=\"btn btn-outline-success dropdown-toggle\" type=\"button\" id=\"dropdownMenuButton1\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n");
      out.write("                                Usuario: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Roles.rol_nombres}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                            </button>\n");
      out.write("                            <ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton1\">                                  \n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"#\">Cargo: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Roles.rol_rol}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></li>\n");
      out.write("                                <li><a class=\"dropdown-item\" href=\"Login.jsp\">Salir</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"m-1 bg-white\" style=\"height: 550px;\">\n");
      out.write("            <iframe name=\"myframe\" style=\"height: 100%; width: 100%\">\n");
      out.write("\n");
      out.write("            </iframe>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"js/sweetalert.min.js\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("</html>\n");

    } else {
        response.sendRedirect("Login.jsp");
    }

      out.write('\n');
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
