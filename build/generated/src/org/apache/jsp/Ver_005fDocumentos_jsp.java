package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.Cliente;
import java.util.ArrayList;
import metodos.metodos_clientes;
import modelo.Cliente_Documento;

public final class Ver_005fDocumentos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- link datatables-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css\">\n");
      out.write("        <!-- sweealert!-->\n");
      out.write("        <link  href=\"css/sweetalert.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- link de bootrap para los iconos!-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css\">\n");
      out.write("        <!-- link de bootrap-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- este sweetalert es para mostrarse al momento eliminar-->\n");
      out.write("        ");

            if (request.getAttribute("alerta") != null && request.getAttribute("tipo2") != null) {
        
      out.write("\n");
      out.write("        <input type=\"text\" hidden=\"\"  id=\"txt_mensaje1\" value=\"");
      out.print(request.getAttribute("alerta"));
      out.write("\"/>\n");
      out.write("        <input type=\"text\" hidden=\"\"   id=\"txt_tipo1\" value=\"");
      out.print(request.getAttribute("tipo2"));
      out.write("\" />\n");
      out.write("        <script>\n");
      out.write("            var mensaje2 = document.getElementById(\"txt_mensaje1\").value;\n");
      out.write("            var tipo2 = document.getElementById(\"txt_tipo1\").value;\n");
      out.write("\n");
      out.write("            window.onload = function () {\n");
      out.write("                swal(\"mensaje\", mensaje2, tipo2);\n");
      out.write("            };\n");
      out.write("        </script>   \n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"card-header bg-light text-center\">Documentos de la funeraria</div>\n");
      out.write("            <table id=\"DOCUMENTOS\" class=\"table table-sm  table-hover\">\n");
      out.write("                <thead>                        \n");
      out.write("                    <tr>\n");
      out.write("                        <th>ACCIONES</th>\n");
      out.write("                        <th>NOMBRES DEL DOCUMENTO</th>\n");
      out.write("                        <th>ARCHIVO</th>\n");
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody id=\"employed_data\">\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    <script src=\"  //cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("                                    $(document).ready(function () {\n");
      out.write("                                        $('#DOCUMENTOS').DataTable({\n");
      out.write("                                            \"language\": {\n");
      out.write("                                                \"lengthMenu\": \" _MENU_ vistas por pagina\",\n");
      out.write("                                                \"zeroRecords\": \"Datos no encontrados\",\n");
      out.write("                                                \"sSearch\": \"Buscar\",\n");
      out.write("                                                \"info\": \"Pagina _PAGE_ de _PAGES_\",\n");
      out.write("                                                \"infoEmpty\": \"Datos no disponibles en la tabla\",\n");
      out.write("                                                \"infoFiltered\": \"( _MAX_ Datos en la tabla)\",\n");
      out.write("\n");
      out.write("                                                \"oPaginate\": {\n");
      out.write("                                                    \"sFirst\": \"Primero\",\n");
      out.write("                                                    \"sLast\": \"Último\",\n");
      out.write("                                                    \"sNext\": \"Siguiente\",\n");
      out.write("                                                    \"sPrevious\": \"Anterior\"\n");
      out.write("                                                }\n");
      out.write("\n");
      out.write("                                            }\n");
      out.write("                                        });\n");
      out.write("                                    });\n");
      out.write("    </script>\n");
      out.write("    <script src=\"js/sweetalert.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("                                    function eliminar_doc(ide1) {\n");
      out.write("                                        swal({\n");
      out.write("                                            title: \"¿Seguro que quieres eliminar este empleado?\",\n");
      out.write("                                            text: \"El dato se eliminara permanentemente\",\n");
      out.write("                                            type: \"warning\",\n");
      out.write("                                            showCancelButton: true,\n");
      out.write("                                            confirmButtonClass: \"btn-danger\",\n");
      out.write("                                            confirmButtonText: \"SI\",\n");
      out.write("                                            cancelButtonText: \"No\",\n");
      out.write("                                            closeOnConfirm: false,\n");
      out.write("                                            closeOnCancel: false\n");
      out.write("                                        },\n");
      out.write("                                                function (isConfirm) {\n");
      out.write("                                                    if (isConfirm) {\n");
      out.write("                                                        window.location = \"PrincipalController?menu=cliente&accion=eliminar_documento&codigo_d=\" + ide1;\n");
      out.write("                                                    } else {\n");
      out.write("                                                        swal(\"Cancelado\", \"tu archivo esta seguro :)\", \"error\");\n");
      out.write("                                                    }\n");
      out.write("                                                });\n");
      out.write("\n");
      out.write("                                    }\n");
      out.write("    </script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("documentos");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${documentos}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                        <tr>\n");
          out.write("                            <td>\n");
          out.write("                                \n");
          out.write("                                <a href=\"#\" onclick=\"eliminar_doc(");
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write(")\"><i class=\"btn btn-white bi bi-person-x-fill\"></i></a>\n");
          out.write("                                <a href=\"#\" ><i class=\"bi bi-cloud-download-fill\"></i></a>\n");
          out.write("\n");
          out.write("                            </td>\n");
          out.write("                            <td>");
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                            <td>                          \n");
          out.write("                                <a href=\"pdf?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${documentos.getCliente_docu_id()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" target=\"_blank\"><i class=\"bi bi-file-earmark-pdf\"></i></a> \n");
          out.write("                            </td>\n");
          out.write("                        </tr>\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${documentos.getCliente_docu_id()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${documentos.nombre_docu}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }
}
