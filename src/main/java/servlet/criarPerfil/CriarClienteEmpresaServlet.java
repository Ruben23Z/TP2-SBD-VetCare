package servlet.criarPerfil;

import dao.ClienteDAO;
import dao.EmpresaDAO;
import dao.UtilizadorDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utilizador.Cliente;
import model.Utilizador.Empresa;
import model.Utilizador.Utilizador;

import java.io.IOException;

@WebServlet("/criarClienteEmpresa")
public class CriarClienteEmpresaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // 1️⃣ Utilizador
            Utilizador u = new Utilizador(
                    false, false, true, false,
                    req.getParameter("username"),
                    req.getParameter("password")
            );

            UtilizadorDAO udao = new UtilizadorDAO();
            int idUtilizador = udao.inserir(u);

            // 2️⃣ Cliente
            Cliente c = new Cliente(
                    idUtilizador,
                    req.getParameter("nif"),
                    req.getParameter("nome"),
                    req.getParameter("email"),
                    req.getParameter("telefone"),
                    req.getParameter("rua"),
                    req.getParameter("pais"),
                    req.getParameter("distrito"),
                    req.getParameter("concelho"),
                    req.getParameter("freguesia")
            );

            ClienteDAO cdao = new ClienteDAO();
            cdao.inserir(c, idUtilizador);

            // 3️⃣ Empresa
            Empresa e = new Empresa(
                    req.getParameter("nif"),
                    Integer.parseInt(req.getParameter("capitalSocial"))
            );

            EmpresaDAO edao = new EmpresaDAO();
            edao.inserir(e);

            resp.sendRedirect("login.jsp?registo=ok");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
