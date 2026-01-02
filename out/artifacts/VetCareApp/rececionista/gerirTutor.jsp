<%@ page import="java.util.List" %>
<%@ page import="dao.ClienteDAO" %>
<%@ page import="model.Utilizador.Cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <title>Gerir Clientes - Rececionista</title>
    <link rel="stylesheet" href="../styles.css">
</head>
<body>
<h1>Gestão de Clientes</h1>

<%-- Mensagens de sucesso/erro --%>
<%
    String ok = request.getParameter("ok");
    String erro = request.getParameter("erro");
    if ("1".equals(ok)) { %>
<p style="color:green;">Operação realizada com sucesso!</p>
<% } else if ("1".equals(erro)) { %>
<p style="color:red;">Ocorreu um erro. Tente novamente.</p>
<% } %>

<h2>Adicionar Cliente</h2>
<form action="<%= request.getContextPath() %>/RececionistaServlet" method="post">
    <input type="hidden" name="action" value="criarCliente">

    <input type="hidden" name="cargo" value="Cliente">

    Tipo de Cliente:
    <select name="tipoCliente" required>
        <option value="Particular">Particular</option>
        <option value="Empresa">Empresa</option>
    </select><br>

    Username: <input type="text" name="username" required><br>
    Password: <input type="password" name="password" required><br>

    Nome: <input type="text" name="nomeCliente" required><br>
    NIF: <input type="text" name="nif" pattern="\d{9}" required title="9 dígitos"> <br>


    Email: <input type="email" name="email" required><br>
    Telefone: <input type="tel"
                     name="telefone"
                     pattern="\+[0-9]{1,4} [0-9]{9}"
                     placeholder="+351 987 654 321" required>

    Rua: <input type="text" name="rua" required><br>
    País: <input type="text" name="pais" value="Portugal" required><br>
    Distrito: <input type="text" name="distrito" required><br>
    Concelho: <input type="text" name="concelho" required><br>
    Freguesia: <input type="text" name="freguesia" required><br>

    Capital Social (Empresa):
    <input type="number" name="capitalSocial"><br>

    Preferência Linguística (Particular):
    <input type="text" name="prefLinguistica"><br>

    <button type="submit">Criar Cliente</button>
</form>

<h2>Lista de Clientes</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>NIF</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>Ações</th>
    </tr>
    <%
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> clientes = dao.findAll();
        for (Cliente c : clientes) {
    %>
    <tr>
        <td><%= c.getiDUtilizador() %>
        </td>
        <td><%= c.getNome() %>
        </td>
        <td><%= c.getNIF() %>
        </td>
        <td><%= c.getEmail() %>
        </td>
        <td><%= c.getTelefone() %>
        </td>
        <td>
            <form action="<%= request.getContextPath() %>/RececionistaServlet" method="get">
                <input type="hidden" name="action" value="editarCliente">
                <input type="hidden" name="idUtilizador" value="<%= c.getiDUtilizador() %>">
                <button type="submit">Editar</button>
            </form>


            <form action="${pageContext.request.contextPath}/RececionistaServlet"
                  method="post"
                  onsubmit="return confirm('Tem a certeza que deseja eliminar este cliente?');">

                <input type="hidden" name="action" value="eliminarCliente">
                <input type="hidden" name="idUtilizador" value="<%= c.getiDUtilizador() %>">

                <button type="submit">🗑 Eliminar</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
