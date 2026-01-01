package servlet.criarPerfil;

import dao.RececionistaDAO;
import dao.UtilizadorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utilizador.Utilizador;

import java.io.IOException;

@WebServlet("/criarRececionista")
public class CriarRececionistaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Utilizador u = new Utilizador(false, true, false, false,
                    req.getParameter("username"), req.getParameter("password"));

            UtilizadorDAO udao = new UtilizadorDAO();
            int id = udao.inserir(u);

            RececionistaDAO rdao = new RececionistaDAO();
            rdao.inserir(id);

            resp.sendRedirect("gerente/menuGerente.jsp?ok=1");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
