<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-PT">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel Veterinário | VetCare</title>
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
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .page-container {
            width: 100%;
            max-width: 900px;
        }

        .header {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            padding: 30px;
            margin-bottom: 25px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .header h1 {
            color: #2d3748;
            font-size: 28px;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .header p {
            color: #718096;
            font-size: 15px;
        }

        .container {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
        }

        .btn-agenda {
            display: block;
            width: 100%;
            padding: 24px;
            background: linear-gradient(135deg, #48bb78 0%, #38a169 100%);
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 12px;
            font-size: 18px;
            font-weight: 600;
            margin-bottom: 35px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(72, 187, 120, 0.3);
            position: relative;
            overflow: hidden;
        }

        .btn-agenda::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: rgba(255, 255, 255, 0.1);
            transition: left 0.5s ease;
        }

        .btn-agenda:hover::before {
            left: 100%;
        }

        .btn-agenda:hover {
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(72, 187, 120, 0.4);
        }

        .section-divider {
            display: flex;
            align-items: center;
            margin: 35px 0;
            color: #cbd5e0;
        }

        .section-divider::before,
        .section-divider::after {
            content: '';
            flex: 1;
            border-bottom: 2px solid #e2e8f0;
        }

        .section-divider span {
            padding: 0 15px;
            color: #718096;
            font-weight: 600;
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        .search-section h3 {
            color: #2d3748;
            font-size: 20px;
            font-weight: 600;
            margin-bottom: 20px;
            text-align: center;
        }

        .search-box {
            position: relative;
            margin-bottom: 25px;
        }

        .search-input-wrapper {
            position: relative;
        }

        .search-icon {
            position: absolute;
            left: 20px;
            top: 50%;
            transform: translateY(-50%);
            color: #a0aec0;
            font-size: 18px;
            pointer-events: none;
        }

        input[type="text"] {
            width: 100%;
            padding: 16px 20px 16px 50px;
            font-size: 15px;
            border: 2px solid #e2e8f0;
            border-radius: 12px;
            outline: none;
            background: white;
            transition: all 0.3s ease;
            color: #2d3748;
        }

        input[type="text"]:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        input[type="text"]::placeholder {
            color: #cbd5e0;
        }

        .results {
            position: absolute;
            width: 100%;
            background: white;
            border: 2px solid #e2e8f0;
            max-height: 300px;
            overflow-y: auto;
            z-index: 1000;
            display: none;
            border-radius: 12px;
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.12);
            margin-top: 8px;
        }

        .results::-webkit-scrollbar {
            width: 8px;
        }

        .results::-webkit-scrollbar-track {
            background: #f7fafc;
            border-radius: 0 12px 12px 0;
        }

        .results::-webkit-scrollbar-thumb {
            background: #cbd5e0;
            border-radius: 4px;
        }

        .results::-webkit-scrollbar-thumb:hover {
            background: #a0aec0;
        }

        .result-item {
            padding: 16px 20px;
            cursor: pointer;
            border-bottom: 1px solid #e2e8f0;
            transition: all 0.2s ease;
        }

        .result-item:last-child {
            border-bottom: none;
        }

        .result-item:hover {
            background: linear-gradient(135deg, #f0f4ff 0%, #e9f0ff 100%);
            padding-left: 24px;
        }

        .result-item strong {
            font-size: 16px;
            color: #2d3748;
            display: block;
            margin-bottom: 4px;
        }

        .result-item span {
            color: #718096;
            font-size: 13px;
        }

        .no-results {
            padding: 20px;
            text-align: center;
            color: #718096;
            font-size: 14px;
        }

        .footer {
            text-align: center;
            margin-top: 25px;
            padding-top: 25px;
            border-top: 2px solid #e2e8f0;
        }

        .btn-logout {
            color: #e53e3e;
            text-decoration: none;
            font-weight: 600;
            font-size: 15px;
            padding: 10px 20px;
            border-radius: 8px;
            transition: all 0.3s ease;
            display: inline-block;
        }

        .btn-logout:hover {
            background: #fed7d7;
            color: #c53030;
        }

        .loading-spinner {
            display: none;
            text-align: center;
            padding: 20px;
            color: #718096;
        }

        .loading-spinner::after {
            content: '';
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 3px solid #e2e8f0;
            border-top-color: #667eea;
            border-radius: 50%;
            animation: spin 0.8s linear infinite;
        }

        @keyframes spin {
            to {
                transform: rotate(360deg);
            }
        }

        .info-card {
            background: linear-gradient(135deg, #f0f4ff 0%, #e9f0ff 100%);
            border-left: 4px solid #667eea;
            padding: 16px 20px;
            border-radius: 8px;
            margin-bottom: 25px;
        }

        .info-card p {
            color: #4a5568;
            font-size: 14px;
            line-height: 1.6;
            margin: 0;
        }

        @media (max-width: 768px) {
            body {
                padding: 15px;
            }

            .header {
                padding: 20px;
            }

            .header h1 {
                font-size: 22px;
            }

            .container {
                padding: 25px 20px;
            }

            .btn-agenda {
                padding: 20px;
                font-size: 16px;
            }

            .search-section h3 {
                font-size: 18px;
            }

            input[type="text"] {
                padding: 14px 16px 14px 45px;
                font-size: 14px;
            }

            .results {
                max-height: 250px;
            }
        }
    </style>
</head>
<body>

<div class="page-container">
    <div class="header">
        <h1>Área do Veterinário</h1>
        <p>Gerencie consultas e acesse fichas clínicas dos pacientes</p>
    </div>

    <div class="container">
        <a href="${pageContext.request.contextPath}/VeterinarioServlet?action=listaChamada" class="btn-agenda">
            Minha Lista de Chamada (Hoje)
        </a>

        <div class="info-card">
            <p>Acesse rapidamente os agendamentos do dia ou pesquise um paciente específico pelo nome do tutor.</p>
        </div>

        <div class="section-divider">
            <span>Pesquisa de Pacientes</span>
        </div>

        <div class="search-section">
            <h3>Pesquisar Paciente por Tutor</h3>
            <div class="search-box">
                <div class="search-input-wrapper">
                    <span class="search-icon">🔍</span>
                    <input type="text"
                           id="searchTutor"
                           placeholder="Digite o nome do tutor para pesquisar..."
                           autocomplete="off"
                           onkeyup="buscarAnimais()">
                </div>
                <div id="loadingSpinner" class="loading-spinner"></div>
                <div id="searchResults" class="results"></div>
            </div>
        </div>

        <div class="footer">
            <a href="${pageContext.request.contextPath}/logout.jsp" class="btn-logout">
                Terminar Sessão
            </a>
        </div>
    </div>
</div>

<script>
    let searchTimeout;

    function buscarAnimais() {
        clearTimeout(searchTimeout);

        let termo = document.getElementById("searchTutor").value.trim();
        let resultsDiv = document.getElementById("searchResults");
        let loadingDiv = document.getElementById("loadingSpinner");

        if (termo.length < 2) {
            resultsDiv.style.display = "none";
            loadingDiv.style.display = "none";
            return;
        }

        loadingDiv.style.display = "block";
        resultsDiv.style.display = "none";

        searchTimeout = setTimeout(() => {
            fetch('${pageContext.request.contextPath}/VeterinarioServlet?action=buscarAnimaisAJAX&termo=' + encodeURIComponent(termo))
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Erro na pesquisa');
                    }
                    return response.json();
                })
                .then(data => {
                    loadingDiv.style.display = "none";
                    resultsDiv.innerHTML = "";

                    if (data.length > 0) {
                        resultsDiv.style.display = "block";
                        data.forEach(animal => {
                            let div = document.createElement("div");
                            div.className = "result-item";
                            div.innerHTML = "<strong>" + escapeHtml(animal.nome) + "</strong> <br> <span>Tutor NIF: " + escapeHtml(animal.dono) + "</span>";
                            div.onclick = function () {
                                window.location.href = "${pageContext.request.contextPath}/VeterinarioServlet?action=consultarFicha&idPaciente=" + animal.id;
                            };
                            resultsDiv.appendChild(div);
                        });
                    } else {
                        resultsDiv.innerHTML = "<div class='no-results'>Nenhum paciente encontrado para este tutor.</div>";
                        resultsDiv.style.display = "block";
                    }
                })
                .catch(err => {
                    console.error(err);
                    loadingDiv.style.display = "none";
                    resultsDiv.innerHTML = "<div class='no-results' style='color: #e53e3e;'>Erro ao realizar pesquisa. Tente novamente.</div>";
                    resultsDiv.style.display = "block";
                });
        }, 300);
    }

    function escapeHtml(text) {
        const map = {
            '&': '&amp;',
            '<': '&lt;',
            '>': '&gt;',
            '"': '&quot;',
            "'": '&#039;'
        };
        return text.replace(/[&<>"']/g, m => map[m]);
    }

    document.addEventListener('click', function (event) {
        const searchBox = document.querySelector('.search-box');
        const resultsDiv = document.getElementById('searchResults');

        if (!searchBox.contains(event.target)) {
            resultsDiv.style.display = 'none';
        }
    });

    document.getElementById('searchTutor').addEventListener('focus', function () {
        const resultsDiv = document.getElementById('searchResults');
        if (resultsDiv.children.length > 0) {
            resultsDiv.style.display = 'block';
        }
    });
</script>

</body>
</html>