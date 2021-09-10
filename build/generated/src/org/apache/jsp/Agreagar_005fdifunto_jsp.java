package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Agreagar_005fdifunto_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_out_value_nobody.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- link de bootrap-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"card card-register mx-auto mt-1 col-md-6\">\n");
      out.write("                <div class=\"card-header bg-light\">Agregar nuevo Difunto al Cliente: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientes.cliente_nombres}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form action=\"\" method=\"post\">\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <div class=\"form-row\">\n");
      out.write("                                <div class=\"col-md-12 \">\n");
      out.write("                                    <label>CODIGO DEL CLIENTE</label>\n");
      out.write("                                    <input class=\"col-md-12 form-control\"name=\"txt_codigo\"  readonly=\"\"  value =\"");
      if (_jspx_meth_c_out_0(_jspx_page_context))
        return;
      out.write("\"/>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-12 \">\n");
      out.write("                                    <label>CEDULA DEL DIFUNTO</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_cedula\" type=\"number\"  placeholder=\"Ingrese su Cedula de identidad\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-12 \">\n");
      out.write("                                    <label>APELLIDOS Y NOMBRES</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_nombre\" type=\"text\"  placeholder=\"Ingrese sus nombres Completos\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-4\">\n");
      out.write("                                    <label>EDAD</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_edad\" type=\"number\"  placeholder=\"Ingrese la edad\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-8 \">\n");
      out.write("                                    <label>SEXO</label>\n");
      out.write("                                    <select name=\"seleccion_sexo\" class=\"col-md-12\">\n");
      out.write("                                        <option value=\"\"> ---seleccionar-- </option>\n");
      out.write("                                        <option value=\"HOMBRE\">HOMBRE</option>                        \n");
      out.write("                                        <option value=\"MUJER\">MUJER</option>  \n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 \">\n");
      out.write("                                    <label>FECHA NACIMIENTO</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_fecha_nacimiento\" type=\"date\"   required=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-6 \">\n");
      out.write("                                    <label>FECHA DEFUNCION</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_fecha_defuncion\" type=\"date\"   required=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-md-12\">\n");
      out.write("                                    <label>CAUSA DEL DECESO</label>\n");
      out.write("                                    <input class=\"form-control\" name=\"txt_deceso\" type=\"text\"  placeholder=\"Ingrese la causa del deceso\" required=\"\">\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <button type=\"submit\" name=\"guardar\" class=\"btn btn-secondary mt-1 w-100\">guardar</button>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_c_out_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent(null);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${clientes.cliente_id}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
