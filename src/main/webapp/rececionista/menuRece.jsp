<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    if (session == null || !"Rececionista".equals(session.getAttribute("cargo"))) {
        response.sendRedirect("../login.jsp?erro=3");
        return;
    }
    String utilizadorNome = ((model.Utilizador.Utilizador) session.getAttribute("utilizador")).getUsername();
%>
<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel Rececionista - VetCare</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; margin: 0; padding: 0; }
        header { background: #2f80ed; color: #fff; padding: 20px; text-align: center; }
        main { padding: 20px; }
        h2 { margin-top: 0; }
        .menu { display: flex; flex-wrap: wrap; gap: 20px; margin-top: 30px; }
        .card { background: #fff; border-radius: 8px; box-shadow: 0 2px 6px rgba(0,0,0,0.15); flex: 1 1 250px; padding: 30px; text-align: center; transition: transform 0.2s; }
        .card:hover { transform: scale(1.05); }
        .card a { text-decoration: none; color: #2f80ed; font-weight: bold; font-size: 18px; display: block; margin-top: 15px; }
        .logout { position: absolute; top: 20px; right: 20px; background: #eb5757; color: #fff; padding: 8px 15px; border-radius: 5px; text-decoration: none; }
        .message { margin-top: 15px; padding: 10px; border-radius: 5px; color: #155724; background: #d4edda; display: inline-block; }
    </style>
</head>
<body>
<header>
    <h1>Bem-vindo, <%= utilizadorNome %>!</h1>
    <a class="logout" href="../logout.jsp">Logout</a>
</header>

<main>
    <h2>Painel do Rececionista</h2>

    <%
        String ok = request.getParameter("ok");
        String erro = request.getParameter("erro");
        if ("1".equals(ok)) {
    %>
    <div class="message">✅ Ação realizada com sucesso!</div>
    <% } else if ("1".equals(erro)) { %>
    <div class="message" style="background:#f8d7da; color:#721c24;">⚠️ Ocorreu um erro! Verifique os dados e tente novamente.</div>
    <% } %>

    <div class="menu">
        <div class="card">
            <h3>Clientes</h3>
            <p>Adicionar, atualizar ou remover clientes (Particulares/Empresas)</p>
            <a href="gerirTutor.jsp">Gerir Clientes</a>
        </div>

        <div class="card">
            <h3>Animais</h3>
            <p>Adicionar, atualizar ou remover animais dos clientes</p>
            <a href="gerirAnimal.jsp">Gerir Animais</a>
        </div>

        <div class="card">
            <h3>Agendamento de Serviços</h3>
            <p>Agendar, cancelar ou reagendar serviços veterinários</p>
            <a href="agendarServico.jsp">Agendar Serviços</a>
        </div>
    </div>
</main>
</body>
</html>
