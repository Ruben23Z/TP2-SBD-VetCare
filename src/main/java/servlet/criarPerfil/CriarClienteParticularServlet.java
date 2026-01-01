package servlet.criarPerfil;

import dao.ClienteDAO;
import dao.ParticularDAO;
import dao.UtilizadorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utilizador.Cliente;
import model.Utilizador.Particular;
import model.Utilizador.Utilizador;

import java.io.IOException;

@WebServlet("/criarClienteParticular")
public class CriarClienteParticularServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            // 1️⃣ Criar Utilizador
            Utilizador u = new Utilizador(false, false, true, false, req.getParameter("username"), req.getParameter("password"));

            UtilizadorDAO udao = new UtilizadorDAO();
            int idUtilizador = udao.inserir(u);

            // 2️⃣ Criar Cliente
            Cliente c = new Cliente(idUtilizador, req.getParameter("nif"), req.getParameter("nome"), req.getParameter("email"), req.getParameter("telefone"), req.getParameter("rua"), req.getParameter("pais"), req.getParameter("distrito"), req.getParameter("concelho"), req.getParameter("freguesia"));

            ClienteDAO cdao = new ClienteDAO();
            cdao.inserir(c, idUtilizador);

            // 3️⃣ Criar Particular
            Particular p = new Particular(idUtilizador, c.getNIF(), c.getNome(), c.getEmail(), c.getTelefone(), c.getRua(), c.getPais(), c.getDistrito(), c.getConcelho(), c.getFreguesia(), req.getParameter("prefLinguistica"));

            ParticularDAO pdao = new ParticularDAO();
            pdao.inserir(p);

            resp.sendRedirect("login.jsp?registo=ok");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
