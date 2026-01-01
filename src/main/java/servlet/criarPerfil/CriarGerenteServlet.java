package servlet.criarPerfil;

import dao.GerenteDAO;
import dao.UtilizadorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utilizador.Utilizador;

import java.io.IOException;

@WebServlet("/criarGerente")
public class CriarGerenteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Utilizador u = new Utilizador(false, false, false, true, req.getParameter("username"), req.getParameter("password"));

            UtilizadorDAO udao = new UtilizadorDAO();
            int id = udao.inserir(u);

            GerenteDAO gdao = new GerenteDAO();
            gdao.inserir(id);

            resp.sendRedirect("gerente/criarAtualizarVet.jsp?ok=1");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
