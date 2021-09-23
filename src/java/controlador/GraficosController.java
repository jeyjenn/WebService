package controlador;

import conexion.Conexion;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartUtils;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

@WebServlet(name = "GraficosController", urlPatterns = {"/GraficosController"})
public class GraficosController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String menu = request.getParameter("menu");

        if (menu.equals("barras")) {

            response.setContentType("image/JPEG");
            OutputStream out = response.getOutputStream();

            try {
                Connection con;
                Conexion conn = new Conexion();
                con = conn.ConectarBD();

                PreparedStatement iniciar;
                ResultSet resultado;

                try {
                    iniciar = con.prepareStatement("SELECT fecha_emision, count(id_ventas)FROM ventas GROUP BY fecha_emision");
                    resultado = iniciar.executeQuery();

                    DefaultCategoryDataset data = new DefaultCategoryDataset();
                    while (resultado.next()) {
                        data.setValue(resultado.getInt(2), resultado.getString(1), resultado.getString(1));
                    }
                    JFreeChart grafico2 = ChartFactory.createBarChart("VENTAS DIARIAS", "DIAS", "RANGO", data, PlotOrientation.VERTICAL, true, true, true);

                    ChartUtilities.writeChartAsPNG(out, grafico2, 400, 400);
                    request.getRequestDispatcher("Vacio.jsp").forward(request, response);

                } catch (Exception ex) {
                }

            } catch (Exception e) {
            }

        }

        if (menu.equals("torta")) {
            response.setContentType("image/JPEG");
            OutputStream out = response.getOutputStream();

            try {
                Connection con;
                Conexion conn = new Conexion();
                con = conn.ConectarBD();

                PreparedStatement iniciar;
                ResultSet resultado;

                try {
                    iniciar = con.prepareStatement("SELECT fecha_emision, count(id_ventas)FROM ventas GROUP BY fecha_emision");
                    resultado = iniciar.executeQuery();

                    DefaultPieDataset data = new DefaultPieDataset();
                    while (resultado.next()) {
                        data.setValue(resultado.getString(1), resultado.getInt(2));

                    }
                    JFreeChart grafico2 = ChartFactory.createPieChart("VENTAS DIARIAS", data, true, true, true);

                    ChartUtilities.writeChartAsPNG(out, grafico2, 400, 400);
                    request.getRequestDispatcher("Vacio.jsp").forward(request, response);

                } catch (Exception ex) {
                }

            } catch (Exception e) {
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

}
