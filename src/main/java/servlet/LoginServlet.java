package servlet;
import dao.UtilizadorDAO;
import model.Utilizador.Utilizador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 1️⃣ Validar credenciais no XML
        Integer idUtilizador = autenticarXML(username, password, request);

        if (idUtilizador == null) {
            response.sendRedirect("login.jsp?erro=1");
            return;
        }

        // 2️⃣ Ir à BD buscar o perfil
        try {
            UtilizadorDAO dao = new UtilizadorDAO();
            Utilizador u = dao.findById(idUtilizador);

            if (u == null) {
                response.sendRedirect("login.jsp?erro=2");
                return;
            }

            // 3️⃣ Criar sessão
            HttpSession session = request.getSession(true);
            session.setAttribute("utilizador", u);

            // 4️⃣ Redirecionar por perfil
            if (u.isGerente()) {
                response.sendRedirect("src/main/webapp/gerente/criarAtualizarVet.jsp");
            } else if (u.isVeterinario()) {
                response.sendRedirect("src/main/webapp/veterinario/fichaAnimal.jsp");
            } else if (u.isRececionista()) {
                response.sendRedirect("src/main/webapp/rececionista/menuRece.jsp");
            } else if (u.isCliente()) {
                response.sendRedirect("src/main/webapp/cliente/consultar.jsp");
            } else {
                response.sendRedirect("login.jsp?erro=3");
            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // 🔐 Autenticação no XML
    private Integer autenticarXML(String user, String pass, HttpServletRequest request) {

        try {
            String path = request.getServletContext()
                    .getRealPath("/WEB-INF/UtilizadoresXML.xml");

            File xml = new File(path);

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml);

            NodeList lista = doc.getElementsByTagName("utilizador");

            for (int i = 0; i < lista.getLength(); i++) {
                Element e = (Element) lista.item(i);

                String u = e.getElementsByTagName("username").item(0).getTextContent();
                String p = e.getElementsByTagName("password").item(0).getTextContent();

                if (u.equals(user) && p.equals(pass)) {
                    return Integer.parseInt(
                            e.getElementsByTagName("idUtilizador").item(0).getTextContent()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
