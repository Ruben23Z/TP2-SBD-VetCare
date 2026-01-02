<%@ page import="java.util.List" %>
<%@ page import="dao.AnimalDAO" %>
<%@ page import="model.Animal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <title>Agendar Serviço - Rececionista</title>
</head>
<body>
<h1>Agendar Serviço</h1>

<form action="RececionistaServlet" method="post">
    <input type="hidden" name="action" value="agendarServico">
    ID do Paciente (Animal): <input type="number" name="idPaciente" required><br>
    ID do Utilizador (Rececionista): <input type="number" name="idUtilizador" required><br>
    Descrição: <input type="text" name="descricao" required><br>
    Data e Hora (AAAA-MM-DDTHH:MM): <input type="datetime-local" name="dataHora" required><br>
    Localidade: <input type="text" name="localidade"><br>
    <button type="submit">Agendar Serviço</button>
</form>
</body>
</html>
