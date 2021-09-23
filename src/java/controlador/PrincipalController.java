package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Blob;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import metodos.GenerarSerie;
import metodos.metodos;
import metodos.metodos_clientes;
import metodos.metodos_detalleventas;
import metodos.metodos_difunto;
import metodos.metodos_funeraria;
import metodos.metodos_grupos;
import metodos.metodos_materiales;
import metodos.metodos_servicios;
import metodos.metodos_ventas;
import modelo.Cliente;
import modelo.Cliente_Documento;
import modelo.DetalleVentas;
import modelo.Difunto;
import modelo.Difunto_Documento;
import modelo.Funeraria;
import modelo.Grupos;
import modelo.Materiales;
import modelo.Roles;
import modelo.Servicios;
import modelo.Ventas;

/**
 *
 * @author usuario
 */
@MultipartConfig
@WebServlet(name = "PrincipalController", urlPatterns = {"/PrincipalController"})
public class PrincipalController extends HttpServlet {

    Roles roles = new Roles();
    metodos mensajero = new metodos();
    List<Roles> mostrar;
    List<Roles> ultimoCodigo;

    List<Materiales> lista1 = new ArrayList<>();
    List<DetalleVentas> lista2 = new ArrayList<>();

    Cliente cliente = new Cliente();
    metodos_clientes mensajero_cliente = new metodos_clientes();

    Cliente_Documento cliente_doc = new Cliente_Documento();

    Difunto difunto = new Difunto();
    metodos_difunto difuntodao = new metodos_difunto();

    Difunto_Documento df = new Difunto_Documento();

    Funeraria funeraria = new Funeraria();
    metodos_funeraria mf = new metodos_funeraria();

    Servicios servicios = new Servicios();
    Materiales materiales = new Materiales();

    metodos_servicios ms = new metodos_servicios();

    metodos_grupos mg = new metodos_grupos();

    metodos_materiales mm = new metodos_materiales();

    Ventas ventas = new Ventas();
    metodos_ventas mv = new metodos_ventas();

    DetalleVentas detalleventas = new DetalleVentas();
    metodos_detalleventas mdv = new metodos_detalleventas();

    Grupos grupos = new Grupos();
    int cant = 1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");
        int rol_id = 1;
        String rol_nombres = "";
        String rol_usuario = "";
        String rol_contraseña = "";
        String rol_estado = "";
        String rol_rol = "";

        int cliente_id = 1;
        int cliente_docu_id = 1;

        int difunto_id = 1;

        int id_servicios = 1;

        int id_funeraria = 1;
        String cedula = "";
        double totalpagar;

        int idv = 1;

        String numeroserie;

        if (menu.equals("principal")) {

            request.getRequestDispatcher("Inicio.jsp").forward(request, response);

        }
        if (menu.equals("servicios")) {
            switch (accion) {
                case "listar_servicios":
                    List lista_servicios = ms.Listar_Servicios();
                    request.setAttribute("servicios", lista_servicios);
                    request.getRequestDispatcher("Servicios.jsp").forward(request, response);
                    break;
                case "eliminar_servicio":

                    int id_servicio = Integer.parseInt(request.getParameter("ser_cod"));
                    servicios.setId_servicio(id_servicio);
                    ms.eliminarServicio(servicios);

                    lista_servicios = ms.Listar_Servicios();
                    request.setAttribute("servicios", lista_servicios);

                    request.setAttribute("alerta", "datos eliminados correctamente");
                    request.setAttribute("tipo2", "success");

                    request.getRequestDispatcher("Servicios.jsp").forward(request, response);
                    break;
                case "pasar":
                    id_servicios = Integer.parseInt(request.getParameter("id_servicio"));
                    lista1 = mm.Listar_por_servicio(id_servicios);
                    request.setAttribute("doc", lista1);

                    request.getRequestDispatcher("modal.jsp").forward(request, response);
                    break;

                case "guardar":

                    String cod_serv = request.getParameter("txt_cod");
                    String nomb_ser = request.getParameter("txt_nombre");
                    String foto = request.getParameter("txt_foto");
                    double valor = Double.valueOf(request.getParameter("txt_valor"));

                    servicios.setId_servicio(0);
                    servicios.setCod_servicio(cod_serv);
                    servicios.setNombre_servicio(nomb_ser);
                    servicios.setFoto_servicio(foto);
                    servicios.setValor_servicio(valor);
                    ms.insertar_servicio(servicios);
                    //retorn la vista de la lista de servicios   
                    lista_servicios = ms.Listar_Servicios();
                    request.setAttribute("servicios", lista_servicios);
                    request.getRequestDispatcher("Servicios.jsp").forward(request, response);
                    break;

            }
        }
        if (menu.equals("grupos")) {
            switch (accion) {
                case "listar_grupos":
                    List lista_grupos = mg.Listar_Grupos();
                    request.setAttribute("grupos", lista_grupos);
                    request.getRequestDispatcher("Grupos.jsp").forward(request, response);
                    break;

                case "eliminar_grupo":

                    int id_grupo = Integer.parseInt(request.getParameter("grupo_cod"));
                    grupos.setId_grupo(id_grupo);
                    mg.eliminarGrupo(grupos);

                    lista_grupos = mg.Listar_Grupos();
                    request.setAttribute("grupos", lista_grupos);

                    request.setAttribute("alerta", "datos eliminados correctamente");
                    request.setAttribute("tipo2", "success");

                    request.getRequestDispatcher("Grupos.jsp").forward(request, response);
                    break;
            }
        }

        if (menu.equals("materiales")) {
            switch (accion) {
                case "pasar_datos":
                    request.setAttribute("grupos", mg.Listar_Grupos());
                    request.setAttribute("servicios", ms.Listar_Servicios());
                    request.getRequestDispatcher("Agregar_material.jsp").forward(request, response);
                    break;
                case "agregar":
                    int op_grupo = Integer.parseInt(request.getParameter("seleccion_grupo"));
                    int op_servicio = Integer.parseInt(request.getParameter("seleccion_servicio"));
                    String cod_producto = request.getParameter("txt_codigo");
                    String nombre_producto = request.getParameter("nombre_producto");
                    double precio = Double.parseDouble(request.getParameter("txt_precio"));
                    int stock = Integer.parseInt(request.getParameter("txt_stock"));

                    materiales.setId_producto(0);
                    grupos.setId_grupo(op_grupo);
                    servicios.setId_servicio(op_servicio);
                    materiales.setCod_producto(cod_producto);
                    materiales.setNombre_producto(nombre_producto);
                    materiales.setPrecio(precio);
                    materiales.setStock(stock);
                    materiales.setGrupos(grupos);
                    materiales.setServicios(servicios);
                    mm.guardarMateriales(materiales);

                    request.setAttribute("mensaje", "datos Guardados Correctamente");
                    request.setAttribute("tipo", "success");
                    request.getRequestDispatcher("Vacio.jsp").forward(request, response);
                    break;
            }
        }
        if (menu.equals("factura")) {

            switch (accion) {

                case "cargar_datos_funeraria":
                    //numero de serie
                    numeroserie = mv.GenerarSerie();
                    if (numeroserie.isEmpty()) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    //lista los servicio
                    request.setAttribute("servicios", ms.Listar_Servicios());

                    request.getRequestDispatcher("Factura.jsp").forward(request, response);
                    break;

                case "buscar":
                    numeroserie = mv.GenerarSerie();
                    if (numeroserie.isEmpty()) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }

                    cedula = request.getParameter("txt_cedula");
                    cliente = mensajero_cliente.validar_cedula(cedula);
                    if (cliente.getCliente_cedula() != null) {

                        try {
                            cedula = request.getParameter("txt_cedula");
                            cliente = mensajero_cliente.buscar_cedula(cedula);
                            request.setAttribute("clientes", cliente);

                            request.setAttribute("servicios", ms.Listar_Servicios());
                            request.getRequestDispatcher("Factura.jsp").forward(request, response);

                        } catch (Exception e) {

                        }

                    } else {
                        request.setAttribute("mensaje", "la cedula ingresada no existe");
                        request.setAttribute("tipo", "error");
                        request.getRequestDispatcher("Factura.jsp").forward(request, response);

                    }
                    break;

                case "cargar1":
                    totalpagar = 0.0;

                    //numero serie
                    numeroserie = mv.GenerarSerie();
                    if (numeroserie.isEmpty()) {
                        numeroserie = "00000001";
                        request.setAttribute("nserie", numeroserie);
                    } else {
                        int incrementar = Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    //cojo los datos del cliente
                    cedula = request.getParameter("txt_cedula");
                    cliente = mensajero_cliente.buscar_cedula(cedula);
                    request.setAttribute("clientes", cliente);

                    request.setAttribute("servicios", ms.Listar_Servicios());

                    id_servicios = Integer.parseInt(request.getParameter("txt_codigo"));
                    //paso el codigo seleecionado a la vista
                    request.getSession().setAttribute("pasar", Integer.parseInt(request.getParameter("txt_codigo")));
                    lista1 = mm.Listar_por_servicio(id_servicios);

                    request.setAttribute("doc", lista1);
                    for (int i = 0; i < lista1.size(); i++) {
                        totalpagar = totalpagar + lista1.get(i).getPrecio();
                    }
                    request.setAttribute("totalpagar", totalpagar);
                    request.getRequestDispatcher("Factura.jsp").forward(request, response);
                    break;

                case "nueva_venta":

                    try {

                        String cliente_cedula = request.getParameter("txt_cedula");
                        cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
                        String cliente_nombres = request.getParameter("txt_nombres");
                        Date fecha = Date.valueOf(LocalDate.now());
                        Double total = Double.parseDouble(request.getParameter("txttotal"));
                        String numero = request.getParameter("numero");

                        //Guardar ventas
                        idv = Integer.parseInt(mv.IdVentas());

                        ventas.setId_ventas(idv);
                        cliente.setCliente_id(cliente_id);
                        ventas.setFecha_emision(fecha);
                        cliente.setCliente_cedula(cliente_cedula);
                        cliente.setCliente_nombres(cliente_nombres);
                        ventas.setValor_servicio(total);
                        ventas.setNumeroSerie(numero);

                        ventas.setCliente(cliente);
                        mv.guardarVenta(ventas);

                        //cojo el codigo para guaedar
                        id_servicios = Integer.parseInt(request.getParameter("id_servicio"));
                        //Guardar Detalle ventas

                        for (int i = 0; i < lista1.size(); i++) {

                            detalleventas = new DetalleVentas();

                            detalleventas.setId_detalleventas(0);
                            ventas.setId_ventas(idv);
                            servicios.setId_servicio(id_servicios);

                            materiales.setId_producto(lista1.get(i).getId_producto());
                            materiales.setNombre_producto(lista1.get(i).getNombre_producto());
                            materiales.setPrecio(lista1.get(i).getPrecio());
                            detalleventas.setCant(cant);

                            detalleventas.setVentas(ventas);
                            detalleventas.setServicios(servicios);
                            detalleventas.setMateriales(materiales);
                            mdv.guardarVenta(detalleventas);

                        }
                        //aqui paso los datos a la factura
                        totalpagar = 0.0;
                        request.setAttribute("cabecera", mf.Listar_cabecera());
                        cedula = request.getParameter("txt_cedula");
                        cliente = mensajero_cliente.buscar_cedula(cedula);
                        request.setAttribute("clientes", cliente);

                        id_servicios = Integer.parseInt(request.getParameter("id_servicio"));
                        lista1 = mm.Listar_por_servicio(id_servicios);
                        request.setAttribute("doc", lista1);
                        for (int i = 0; i < lista1.size(); i++) {
                            totalpagar = totalpagar + lista1.get(i).getPrecio();
                        }
                        request.setAttribute("totalpagar", totalpagar);
                        //cojo el numero de lafactura
                        request.setAttribute("ns", request.getParameter("numero"));

                        request.setAttribute("mensaje", "venta generada exitosamente");
                        request.setAttribute("tipo", "success");

                        request.getRequestDispatcher("ImprimirFactura.jsp").forward(request, response);

                    } catch (Exception e) {

                        //numero serie
                        numeroserie = mv.GenerarSerie();
                        if (numeroserie.isEmpty()) {
                            numeroserie = "00000001";
                            request.setAttribute("nserie", numeroserie);
                        } else {
                            int incrementar = Integer.parseInt(numeroserie);
                            GenerarSerie gs = new GenerarSerie();
                            numeroserie = gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);
                        }
                        request.setAttribute("mensaje", "debe ingresar datos");
                        request.setAttribute("tipo", "error");
                        request.getRequestDispatcher("Factura.jsp").forward(request, response);
                    }
                    break;

                case "imprimir":
                    break;

            }
        }

        if (menu.equals("difunto")) {

            switch (accion) {
                case "cargar_datos_del_cliente":
                    cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
                    cliente = mensajero_cliente.Cargar_Datos(cliente_id);
                    request.setAttribute("clientes", cliente);
                    request.getRequestDispatcher("Agreagar_difunto.jsp").forward(request, response);
                    break;
                case "guardar_difunto":
                    try {
                        cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
                        String difunto_cedula = request.getParameter("txt_cedula");
                        String difunto_nombres = request.getParameter("txt_nombre");
                        int difunto_edad = Integer.parseInt(request.getParameter("txt_edad"));
                        String difunto_sexo = request.getParameter("seleccion_sexo");
                        String difunto_nacimiemto = request.getParameter("txt_fecha_nacimiento");
                        String difunto_defuncion = request.getParameter("txt_fecha_defuncion");
                        String difunto_causa = request.getParameter("txt_deceso");

                        difunto.setDifunto_id(0);
                        cliente.setCliente_id(cliente_id);
                        difunto.setDifunto_cedula(difunto_cedula);
                        difunto.setDifunto_nombres(difunto_nombres);
                        difunto.setDifunto_edad(difunto_edad);
                        difunto.setDifunto_sexo(difunto_sexo);
                        difunto.setD_fecha_nacimiento(difunto_nacimiemto);
                        difunto.setD_fecha_deceso(difunto_defuncion);
                        difunto.setDifunto_causa(difunto_causa);
                        difunto.setCliente(cliente);

                        difuntodao.insertar_difunto(difunto);

                        request.setAttribute("mensaje", "datos Guardados Correctamente");
                        request.setAttribute("tipo", "success");

                        request.getRequestDispatcher("Vacio.jsp").forward(request, response);
                    } catch (Exception e) {

                        request.setAttribute("mensaje", "Error al guardar los datos");
                        request.setAttribute("tipo", "error");

                        cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
                        cliente = mensajero_cliente.Cargar_Datos(cliente_id);
                        request.setAttribute("clientes", cliente);
                        request.getRequestDispatcher("Agreagar_difunto.jsp").forward(request, response);
                    }
                    break;
                case "listar":
                    cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));

                    List lista_difunto = difuntodao.Listar_por_id__difunto(cliente_id);
                    request.setAttribute("documentos", lista_difunto);

                    request.getRequestDispatcher("CargarDocu_difunto.jsp").forward(request, response);
                    break;
                case "cargar":
                    difunto_id = Integer.parseInt(request.getParameter("txt_codigo_difunto"));
                    difunto = difuntodao.Cargar_Datos_dif(difunto_id);
                    request.setAttribute("difunto", difunto);
                    request.getRequestDispatcher("Guardar_doc_difunto.jsp").forward(request, response);
                    break;
                case "guardar":
                    
                    
                    difunto_id = Integer.parseInt(request.getParameter("txt_codigo"));

                    String nombre_archvio = request.getParameter("txt_nombre");

                    InputStream inputStream = null;
                    try {
                        Part filePart = request.getPart("fichero");
                        if (filePart.getSize() > 0) {
                            System.out.println(filePart.getName());
                            System.out.println(filePart.getSize());
                            System.out.println(filePart.getContentType());
                            inputStream = filePart.getInputStream();
                        }
                    } catch (Exception e) {

                    }

                    df.setDifunto_docu_id(0);
                    difunto.setDifunto_id(difunto_id);
                    df.setDifunto_nombre_archivo(nombre_archvio);

                    if (inputStream != null) {
                        df.setDifunto_pdf(inputStream);

                    }
                    df.setDifunto(difunto);

                    difuntodao.insertar_doc_difunto(df);

                    request.setAttribute("mensaje", "datos Guardados Correctamente");
                    request.setAttribute("tipo", "success");
                    
                   
                       
                    lista_difunto = difuntodao.Listar_por_id__difunto(cliente_id);
                    request.setAttribute("documentos", lista_difunto);
                    
                    request.getRequestDispatcher("CargarDocu_difunto.jsp").forward(request, response);
                    break;
                case "listar_pdf":
                    difunto_id = Integer.parseInt(request.getParameter("txt_codigo_difunto"));

                    List pdf = difuntodao.Listar_pdf_difunto(difunto_id);
                    request.setAttribute("pdf", pdf);

                    request.getRequestDispatcher("Ver_pdf_difunto.jsp").forward(request, response);
                    break;

            }

        }

        if (menu.equals("empleado")) {
            switch (accion) {
                case "nuevo":

                    //muestra el ultimo codigo generado
                    ultimoCodigo = mensajero.GenerarCodigo();
                    request.setAttribute("lista", ultimoCodigo);
                    request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
                    break;

                case "listar":
                    List lista = mensajero.Listar();
                    request.setAttribute("roles", lista);
                    request.getRequestDispatcher("MostrarEmpleados.jsp").forward(request, response);
                    break;

                case "guardar":

                    try {

                        rol_id = Integer.parseInt(request.getParameter("txt_codigo"));
                        rol_nombres = request.getParameter("txt_nombre");
                        rol_usuario = request.getParameter("txt_usuario");
                        rol_contraseña = request.getParameter("txt_pass");
                        rol_estado = request.getParameter("seleccion_estado");
                        rol_rol = request.getParameter("seleccion_rol");

                        if (rol_nombres.equals("")) {
                            throw new Exception("debe ingresar nombres");
                        }

                        if (rol_usuario.equals("")) {
                            throw new Exception("debe ingresar usuarios");
                        }
                        if (rol_contraseña.equals("")) {
                            throw new Exception("debe ingresar contraseña");
                        }
                        if (rol_estado.equals("")) {
                            throw new Exception("debe seleccionar estado");
                        }
                        if (rol_rol.equals("")) {
                            throw new Exception("debe seleccionar rol");
                        }

                        roles.setRol_id(rol_id);
                        roles.setRol_nombres(rol_nombres);
                        roles.setRol_usuario(rol_usuario);
                        roles.setRol_contraseña(rol_contraseña);
                        roles.setRol_estado(rol_estado);
                        roles.setRol_rol(rol_rol);
                        mensajero.insertar(roles);

                        request.setAttribute("mensaje", "datos guardados correctamente");
                        request.setAttribute("tipo", "success");
                        //muestra el ultimo codigo generado
                        ultimoCodigo = mensajero.GenerarCodigo();
                        request.setAttribute("lista", ultimoCodigo);
                        request.getRequestDispatcher("Vacio.jsp").forward(request, response);

                    } catch (Exception e) {
                        request.setAttribute("mensaje", "debe ingresar datos");
                        request.setAttribute("tipo", "error");
                        //muestra el ultimo codigo generado
                        ultimoCodigo = mensajero.GenerarCodigo();
                        request.setAttribute("lista", ultimoCodigo);
                        request.getRequestDispatcher("NuevoEmpleado.jsp").forward(request, response);
                    }

                    break;

                case "editar":
                    rol_id = Integer.parseInt(request.getParameter("txt_codigo"));
                    roles = mensajero.editar(rol_id);
                    request.setAttribute("empleado", roles);
                    request.getRequestDispatcher("ModificarEmpleado.jsp").forward(request, response);
                    break;

                case "eliminar1":
                    request.setAttribute("alerta", "datos eliminados correctamente");
                    request.setAttribute("tipo2", "success");

                    int rol_id1 = Integer.parseInt(request.getParameter("codigo"));
                    roles.setRol_id(rol_id1);
                    mensajero.eliminarEmpleado(roles);
                    lista = mensajero.Listar();
                    request.setAttribute("roles", lista);
                    request.getRequestDispatcher("MostrarEmpleados.jsp").forward(request, response);
                    break;

                case "eliminar2":

                    int rol_id2 = Integer.parseInt(request.getParameter("codigo"));
                    roles.setRol_id(rol_id2);
                    mensajero.eliminarEmpleado(roles);

                    request.setAttribute("alerta", "datos eliminados correctamente");
                    request.setAttribute("tipo2", "success");

                    lista = mensajero.Listar();
                    request.setAttribute("roles", lista);
                    request.getRequestDispatcher("MostrarEmpleados.jsp").forward(request, response);
                    break;

                case "actualizar":
                    actualizar(request, response);
                    break;
            }
        }

        if (menu.equals("cliente")) {
            switch (accion) {
                case "nuevo_cliente":
                    request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
                    break;
                case "guardar":
                    String cliente_cedula1 = request.getParameter("txt_cedula");
                    cliente = mensajero_cliente.validar_cedula(cliente_cedula1);
                    if (cliente.getCliente_cedula() != null) {

                        try {

                            request.setAttribute("mensaje", "la cedula ingresada ya existe");
                            request.setAttribute("tipo", "error");

                            request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);

                        } catch (Exception e) {

                        }

                    } else {

                        try {
                            String cliente_cedula = request.getParameter("txt_cedula");
                            String cliente_nombres = request.getParameter("txt_nombre");
                            String cliente_telefono = request.getParameter("txt_telefono");
                            String cliente_correo = request.getParameter("txt_correo");

                            if (cliente_nombres.equals("")) {
                                throw new Exception("debe ingresar nombres");
                            }
                            if (cliente_cedula.length() <= 9 || cliente_cedula.length() >= 11) {
                                throw new Exception("debe ingresar una cedula valida");
                            }
                            if (cliente_telefono.length() <= 9 || cliente_telefono.length() >= 11) {
                                throw new Exception("debe ingresar un telefono valido");
                            }

                            if (cliente_correo.equals("")) {
                                throw new Exception("debe ingresar un correo");
                            }
                            cliente.setCliente_id(0);
                            cliente.setCliente_cedula(cliente_cedula);
                            cliente.setCliente_nombres(cliente_nombres);
                            cliente.setCliente_telefono(cliente_telefono);
                            cliente.setCliente_correo(cliente_correo);
                            mensajero_cliente.insertar_cliente(cliente);

                            request.setAttribute("mensaje", "datos guardados correctamente");
                            request.setAttribute("tipo", "success");
                            request.getRequestDispatcher("Vacio.jsp").forward(request, response);

                        } catch (Exception e) {
                            request.setAttribute("mensaje", e.getMessage());
                            request.setAttribute("tipo", "error");
                            request.getRequestDispatcher("NuevoCliente.jsp").forward(request, response);
                        }
                    }
                    break;

                case "listar_clientes":
                    List lista_clientes = mensajero_cliente.Listar_cliente();
                    request.setAttribute("clientes", lista_clientes);
                    request.getRequestDispatcher("MostrarClientes.jsp").forward(request, response);
                    break;

                case "cargar":
                    cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
                    cliente = mensajero_cliente.Cargar_Datos(cliente_id);
                    request.setAttribute("clientes", cliente);

                    //mitad de la pantalla
                    List mostrar2 = mensajero_cliente.Listar_por_id(cliente_id);
                    request.setAttribute("documentos", mostrar2);
                    request.getRequestDispatcher("Cargar_Documentos.jsp").forward(request, response);
                    break;

                case "guardar_docu":
                    try {
                        cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));

                        String cliente_docu_nombres = request.getParameter("txt_nombre");

                        InputStream inputStream = null;
                        try {
                            Part filePart = request.getPart("fichero");
                            if (filePart.getSize() > 0) {
                                System.out.println(filePart.getName());
                                System.out.println(filePart.getSize());
                                System.out.println(filePart.getContentType());
                                inputStream = filePart.getInputStream();
                            }
                        } catch (Exception e) {

                        }

                        if (inputStream.equals("")) {
                            throw new Exception("archivo pdf no seleccionado");
                        }

                        cliente_doc.setCliente_docu_id(0);
                        cliente.setCliente_id(cliente_id);
                        cliente_doc.setNombre_docu(cliente_docu_nombres);

                        cliente_doc.setCliente(cliente);

                        if (inputStream != null) {
                            cliente_doc.setArchivopdf(inputStream);
                        }

                        mensajero_cliente.insertar_doc_cliente(cliente_doc);

                        request.setAttribute("mensaje", "Archivo pdf guardado Correctamente");
                        request.setAttribute("tipo", "success");

                        mostrar2 = mensajero_cliente.Listar_por_id(cliente_id);
                        request.setAttribute("documentos", mostrar2);

                        cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
                        cliente = mensajero_cliente.Cargar_Datos(cliente_id);
                        request.setAttribute("clientes", cliente);

                        request.getRequestDispatcher("Cargar_Documentos.jsp").forward(request, response);

                    } catch (Exception e) {
                        request.setAttribute("mensaje", "archivo pdf no seleccionado");
                        request.setAttribute("tipo", "error");

                        cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
                        cliente = mensajero_cliente.Cargar_Datos(cliente_id);
                        request.setAttribute("clientes", cliente);
                        request.getRequestDispatcher("Cargar_Documentos.jsp").forward(request, response);
                    }
                    break;
                case "editar":
                    cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
                    cliente = mensajero_cliente.Cargar_Datos(cliente_id);
                    request.setAttribute("clientes", cliente);
                    request.getRequestDispatcher("ModificarClientes.jsp").forward(request, response);
                    break;
                case "actualizar_cliente":
                    actualizar_cliente(request, response);
                    break;

                case "eliminar_cliente":
                    request.setAttribute("alerta", "datos eliminados correctamente");
                    request.setAttribute("tipo2", "success");

                    cliente_id = Integer.parseInt(request.getParameter("codigo_cliente"));
                    cliente.setCliente_id(cliente_id);

                    mensajero_cliente.eliminarCliente(cliente);

                    lista_clientes = mensajero_cliente.Listar_cliente();
                    request.setAttribute("clientes", lista_clientes);
                    request.getRequestDispatcher("MostrarClientes.jsp").forward(request, response);
                    break;

                case "eliminar_documento":
                    request.setAttribute("alerta", "datos eliminados correctamente");
                    request.setAttribute("tipo2", "success");

                    cliente_docu_id = Integer.parseInt(request.getParameter("codigo_d"));
                    cliente_doc.setCliente_docu_id(cliente_docu_id);
                    mensajero_cliente.eliminarDocumento(cliente_doc);

                    lista_clientes = mensajero_cliente.Listar_cliente();
                    request.setAttribute("clientes", lista_clientes);
                    request.getRequestDispatcher("MostrarClientes.jsp").forward(request, response);
                    break;

            }

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

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int rol_id = 1;
        String rol_nombres = "";
        String rol_usuario = "";
        String rol_contraseña = "";
        String rol_estado = "";
        String rol_rol = "";

        rol_nombres = request.getParameter("txt_nombre");
        roles = mensajero.validar_cedula(rol_nombres);
        if (roles.getRol_nombres() != null) {

            try {

                request.setAttribute("mensaje", "la cedula ingresada ya existe");
                request.setAttribute("tipo", "error");

                rol_id = Integer.parseInt(request.getParameter("txt_codigo"));
                roles = mensajero.editar(rol_id);
                request.setAttribute("empleado", roles);
                request.getRequestDispatcher("ModificarEmpleado.jsp").forward(request, response);

            } catch (Exception e) {

            }

        } else {

            try {

                rol_id = Integer.parseInt(request.getParameter("txt_codigo"));
                rol_nombres = request.getParameter("txt_nombre");
                rol_usuario = request.getParameter("txt_usuario");
                rol_contraseña = request.getParameter("txt_pass");
                rol_estado = request.getParameter("seleccion_estado");
                rol_rol = request.getParameter("seleccion_rol");
                if (rol_nombres.equals("")) {
                    throw new Exception("debe ingresar nombres");
                }

                if (rol_usuario.equals("")) {
                    throw new Exception("debe ingresar usuarios");
                }
                if (rol_contraseña.equals("")) {
                    throw new Exception("debe ingresar contraseña");
                }
                if (rol_estado.equals("")) {
                    throw new Exception("debe seleccionar estado");
                }
                if (rol_rol.equals("")) {
                    throw new Exception("debe seleccionar rol");
                }

                roles.setRol_id(rol_id);
                roles.setRol_nombres(rol_nombres);
                roles.setRol_usuario(rol_usuario);
                roles.setRol_contraseña(rol_contraseña);
                roles.setRol_estado(rol_estado);
                roles.setRol_rol(rol_rol);
                mensajero.Actualizar(roles);

                request.setAttribute("mensaje", "datos actualizados correctamente");
                request.setAttribute("tipo", "success");

                List lista = mensajero.Listar();
                request.setAttribute("roles", lista);
                request.getRequestDispatcher("MostrarEmpleados.jsp").forward(request, response);

            } catch (Exception e) {
                request.setAttribute("mensaje", "debe ingresar datos");
                request.setAttribute("tipo", "error");

                rol_id = Integer.parseInt(request.getParameter("txt_codigo"));
                roles = mensajero.editar(rol_id);
                request.setAttribute("empleado", roles);
                request.getRequestDispatcher("ModificarEmpleado.jsp").forward(request, response);

            }
        }
    }

    private void actualizar_cliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cliente_id = 1;
        String cliente_nombres = "";
        String cliente_cedula = "";
        String cliente_telefono = "";
        String cliente_correo = "";

        try {

            cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
            cliente_cedula = request.getParameter("txt_cedula");
            cliente_nombres = request.getParameter("txt_nombre");
            cliente_telefono = request.getParameter("txt_telefono");
            cliente_correo = request.getParameter("txt_correo");

            if (cliente_nombres.equals("")) {
                throw new Exception("debe ingresar nombres");
            }
            if (cliente_cedula.length() <= 9 || cliente_cedula.length() >= 11) {
                throw new Exception("debe ingresar una cedula valida");
            }
            if (request.getParameter("txt_telefono").length() <= 9) {
                throw new Exception("debe ingresar un numero de telefono valido");
            }
            if (cliente_correo.equals("")) {
                throw new Exception("debe ingresar un correo");
            }

            cliente.setCliente_id(cliente_id);
            cliente.setCliente_cedula(cliente_cedula);
            cliente.setCliente_nombres(cliente_nombres);
            cliente.setCliente_telefono(cliente_telefono);
            cliente.setCliente_correo(cliente_correo);

            mensajero_cliente.Actualizar_cliente(cliente);

            request.setAttribute("mensaje", "datos actualizados correctamente");
            request.setAttribute("tipo", "success");

            List lista_clientes = mensajero_cliente.Listar_cliente();
            request.setAttribute("clientes", lista_clientes);
            request.getRequestDispatcher("MostrarClientes.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("mensaje", e.getMessage());
            request.setAttribute("tipo", "error");

            cliente_id = Integer.parseInt(request.getParameter("txt_codigo"));
            cliente = mensajero_cliente.Cargar_Datos(cliente_id);
            request.setAttribute("clientes", cliente);
            request.getRequestDispatcher("ModificarClientes.jsp").forward(request, response);

        }
    }

}
