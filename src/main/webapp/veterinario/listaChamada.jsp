<%@ page import="java.util.List" %>
<%@ page import="model.ServicoMedicoAgendamento" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ServicoMedicoAgendamento> agenda = (List<ServicoMedicoAgendamento>) request.getAttribute("agenda");
%>
<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Chamada | VetCare</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }

        .page-container {
            max-width: 1200px;
            margin: 0 auto;
        }

        .header {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            padding: 25px 30px;
            margin-bottom: 25px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
            flex-wrap: wrap;
            gap: 20px;
        }

        .header h1 {
            color: #2d3748;
            font-size: 26px;
            font-weight: 600;
        }

        .btn-back {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: #fff;
            padding: 10px 25px;
            border-radius: 25px;
            text-decoration: none;
            font-weight: 600;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(102, 126, 234, 0.3);
        }

        .btn-back:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(102, 126, 234, 0.4);
        }

        .container {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
        }

        .info-banner {
            background: linear-gradient(135deg, #fef5e7 0%, #fdebd0 100%);
            border-left: 4px solid #f39c12;
            padding: 18px 24px;
            border-radius: 10px;
            margin-bottom: 30px;
            display: flex;
            align-items: center;
            gap: 15px;
        }

        .info-banner .icon {
            font-size: 24px;
        }

        .info-banner p {
            color: #7d6608;
            font-size: 15px;
            font-weight: 500;
            margin: 0;
            line-height: 1.5;
        }

        .empty-state {
            background: linear-gradient(135deg, #fff3cd 0%, #ffeaa7 100%);
            border-left: 4px solid #f39c12;
            padding: 30px;
            border-radius: 12px;
            text-align: center;
        }

        .empty-state p {
            color: #856404;
            font-size: 16px;
            font-weight: 500;
            margin: 0;
        }

        .stats-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 20px;
            margin-bottom: 30px;
        }

        .stat-card {
            background: linear-gradient(135deg, #f7fafc 0%, #edf2f7 100%);
            padding: 20px;
            border-radius: 12px;
            border-left: 4px solid #667eea;
            text-align: center;
        }

        .stat-card .stat-value {
            font-size: 32px;
            font-weight: 700;
            color: #2d3748;
            margin-bottom: 5px;
        }

        .stat-card .stat-label {
            font-size: 13px;
            color: #718096;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0;
            margin-top: 15px;
        }

        thead tr {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
        }

        th {
            padding: 16px;
            text-align: left;
            color: white;
            font-weight: 600;
            font-size: 13px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        th:first-child {
            border-radius: 10px 0 0 0;
        }

        th:last-child {
            border-radius: 0 10px 0 0;
        }

        td {
            padding: 18px 16px;
            border-bottom: 1px solid #e2e8f0;
            font-size: 14px;
            color: #2d3748;
        }

        tbody tr {
            transition: all 0.2s ease;
        }

        tbody tr:hover {
            background-color: #f7fafc;
            transform: scale(1.01);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
        }

        tbody tr:last-child td {
            border-bottom: none;
        }

        .datetime-cell {
            display: flex;
            flex-direction: column;
            gap: 4px;
        }

        .date-text {
            font-weight: 600;
            color: #2d3748;
        }

        .time-text {
            color: #718096;
            font-size: 13px;
        }

        .patient-id {
            font-weight: 600;
            color: #667eea;
            font-size: 15px;
        }

        .service-description {
            color: #4a5568;
            line-height: 1.5;
        }

        .location-text {
            color: #718096;
            font-size: 13px;
        }

        .status-badge {
            display: inline-block;
            padding: 6px 14px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .status-ativo {
            background: #c6f6d5;
            color: #22543d;
        }

        .status-pendente {
            background: #feebc8;
            color: #7c2d12;
        }

        .status-reagendado {
            background: #bee3f8;
            color: #2c5282;
        }

        .status-cancelado {
            background: #fed7d7;
            color: #742a2a;
        }

        .btn-ficha {
            background: linear-gradient(135deg, #4299e1 0%, #3182ce 100%);
            color: white;
            padding: 10px 20px;
            border-radius: 8px;
            text-decoration: none;
            font-weight: 600;
            font-size: 13px;
            display: inline-block;
            transition: all 0.3s ease;
            box-shadow: 0 2px 8px rgba(66, 153, 225, 0.3);
        }

        .btn-ficha:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 12px rgba(66, 153, 225, 0.4);
        }

        .section-title {
            color: #2d3748;
            font-size: 18px;
            font-weight: 600;
            margin-bottom: 20px;
            padding-bottom: 10px;
            border-bottom: 2px solid #e2e8f0;
        }

        @media (max-width: 1024px) {
            table {
                font-size: 13px;
            }

            th, td {
                padding: 12px;
            }
        }

        @media (max-width: 768px) {
            .header {
                padding: 20px;
            }

            .header h1 {
                font-size: 20px;
            }

            .container {
                padding: 25px 20px;
            }

            .stats-grid {
                grid-template-columns: 1fr;
            }

            table {
                font-size: 12px;
            }

            th, td {
                padding: 10px 8px;
            }

            .btn-ficha {
                padding: 8px 12px;
                font-size: 12px;
            }

            .datetime-cell {
                font-size: 12px;
            }
        }
    </style>
</head>
<body>

<div class="page-container">
    <div class="header">
        <h1>Lista de Chamada</h1>
        <a href="${pageContext.request.contextPath}/VeterinarioServlet?action=dashboard" class="btn-back">
            Voltar ao Menu
        </a>
    </div>

    <div class="container">
        <% if (agenda == null || agenda.isEmpty()) { %>

        <div class="empty-state">
            <p>Não existem agendamentos previstos para hoje ou datas futuras.</p>
        </div>

        <% } else { %>

        <div class="stats-grid">
            <div class="stat-card">
                <div class="stat-value"><%= agenda.size() %></div>
                <div class="stat-label">Total de Consultas</div>
            </div>
            <div class="stat-card">
                <div class="stat-value">
                    <%= agenda.stream().filter(s -> "pendente".equalsIgnoreCase(s.getEstado())).count() %>
                </div>
                <div class="stat-label">Pendentes</div>
            </div>
            <div class="stat-card">
                <div class="stat-value">
                    <%= agenda.stream().filter(s -> "ativo".equalsIgnoreCase(s.getEstado())).count() %>
                </div>
                <div class="stat-label">Confirmadas</div>
            </div>
        </div>

        <div class="info-banner">
            <span class="icon">ℹ️</span>
            <p>Clique em "Abrir Ficha" para visualizar o histórico clínico completo de cada paciente.</p>
        </div>

        <h2 class="section-title">Agendamentos</h2>

        <table>
            <thead>
            <tr>
                <th style="width: 15%">Data e Hora</th>
                <th style="width: 12%">Paciente</th>
                <th style="width: 35%">Descrição / Serviço</th>
                <th style="width: 13%">Local</th>
                <th style="width: 12%">Estado</th>
                <th style="width: 13%">Ação</th>
            </tr>
            </thead>
            <tbody>
            <% for (ServicoMedicoAgendamento s : agenda) {
                String estadoClass = "status-" + (s.getEstado() != null ? s.getEstado().toLowerCase() : "pendente");
            %>
            <tr>
                <td>
                    <div class="datetime-cell">
                        <span class="date-text"><%= s.getDataHoraAgendada().toLocalDate() %></span>
                        <span class="time-text"><%= s.getDataHoraAgendada().toLocalTime() %></span>
                    </div>
                </td>
                <td>
                    <span class="patient-id">ID: <%= s.getIdPaciente() %></span>
                </td>
                <td>
                    <span class="service-description"><%= s.getDescricao() %></span>
                </td>
                <td>
                    <span class="location-text"><%= s.getLocalidade() %></span>
                </td>
                <td>
                    <span class="status-badge <%= estadoClass %>">
                        <%= s.getEstado() %>
                    </span>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/VeterinarioServlet?action=consultarFicha&idPaciente=<%= s.getIdPaciente() %>"
                       class="btn-ficha">
                        Abrir Ficha
                    </a>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>

        <% } %>
    </div>
</div>

</body>
</html>