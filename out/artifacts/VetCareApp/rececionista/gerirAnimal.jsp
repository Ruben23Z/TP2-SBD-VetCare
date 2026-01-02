<%@ page import="java.util.List" %>
<%@ page import="dao.AnimalDAO" %>
<%@ page import="dao.ClienteDAO" %>
<%@ page import="model.Animal" %>
<%@ page import="model.Utilizador.Cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <title>Gerir Animais - Rececionista</title>
</head>
<body>
<h1>Gestão de Animais</h1>

<%-- Mensagens --%>
<%
    String ok = request.getParameter("ok");
    String erro = request.getParameter("erro");
    if ("1".equals(ok)) { %>
<p style="color:green;">Operação realizada com sucesso!</p>
<% } else if ("1".equals(erro)) { %>
<p style="color:red;">Ocorreu um erro. Tente novamente.</p>
<% } %>

<h2>Adicionar Animal</h2>
<form action="RececionistaServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="action" value="salvarAnimal">
    NIF do Cliente: <input type="text" name="clienteNIF" required><br>
    Nome do Animal: <input type="text" name="nome" required><br>
    Espécie: <input type="text" name="especie"><br>
    Raça: <input type="text" name="raca"><br>
    Data Nascimento: <input type="date" name="dataNascimento"><br>
    Foto: <input type="file" name="foto"><br>
    <button type="submit">Salvar Animal</button>
</form>

<h2>Lista de Animais</h2>
<table border="1">
    <tr>
        <th>ID</th><th>Nome</th><th>Cliente</th><th>Espécie</th><th>Raça</th><th>Data Nascimento</th><th>Foto</th><th>Ações</th>
    </tr>
    <%
        AnimalDAO animalDAO = new AnimalDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Animal> animais = animalDAO.findAll();
        for (Animal a : animais) {
            Cliente c = clienteDAO.findById(a.getClienteId());
    %>
    <tr>
        <td><%= a.getId() %></td>
        <td><%= a.getNome() %></td>
        <td><%= (c != null) ? c.getNome() : "Desconhecido" %></td>
        <td><%= a.getEspecie() %></td>
        <td><%= a.getRaca() %></td>
        <td><%= a.getDataNascimento() %></td>
        <td>
            <% if(a.getFotoPath() != null) { %>
            <img src="<%= a.getFotoPath() %>" width="50">
            <% } %>
        </td>
        <td>
            <form action="RececionistaServlet" method="post" style="display:inline;">
                <input type="hidden" name="action" value="editarAnimal">
                <input type="hidden" name="id" value="<%= a.getId() %>">
                <button type="submit">Editar</button>
            </form>
            <form action="RececionistaServlet" method="post" style="display:inline;">
                <input type="hidden" name="action" value="deletarAnimal">
                <input type="hidden" name="id" value="<%= a.getId() %>">
                <button type="submit">Eliminar</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
