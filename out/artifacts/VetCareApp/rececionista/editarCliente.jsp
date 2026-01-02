<%@ page import="dao.ClienteDAO" %>
<%@ page import="model.Utilizador.Cliente" %>
<%
    int id = Integer.parseInt(request.getParameter("idUtilizador"));
    Cliente c = new ClienteDAO().findById(id);
%>

<h2>Editar Cliente</h2>

<form action="<%= request.getContextPath() %>/RececionistaServlet" method="post">
    <input type="hidden" name="action" value="atualizarCliente">
    <input type="hidden" name="idUtilizador" value="<%= c.getiDUtilizador() %>">

    Nome: <input type="text" name="nomeCliente" value="<%= c.getNome() %>" required><br>
    NIF: <input type="text" name="nif" value="<%= c.getNIF() %>" required><br>
    Email: <input type="email" name="email" value="<%= c.getEmail() %>" required><br>
    Telefone: <input type="text" name="telefone" value="<%= c.getTelefone() %>"><br>

    Rua: <input type="text" name="rua" value="<%= c.getRua() %>"><br>
    País: <input type="text" name="pais" value="<%= c.getPais() %>"><br>
    Distrito: <input type="text" name="distrito" value="<%= c.getDistrito() %>"><br>
    Concelho: <input type="text" name="concelho" value="<%= c.getConcelho() %>"><br>
    Freguesia: <input type="text" name="freguesia" value="<%= c.getFreguesia() %>"><br>

    <button type="submit">Guardar Alterações</button>
</form>
