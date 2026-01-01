<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>VetCare - Registo</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; }
        .container { width: 500px; margin: 40px auto; background: #fff; padding: 25px; border-radius: 8px; }
        h2 { text-align: center; }
        .hidden { display: none; }
        label { display: block; margin-top: 12px; }
        input, select { width: 100%; padding: 8px; margin-top: 4px; }
        button { margin-top: 20px; width: 100%; padding: 10px; }
    </style>

    <script>
        function mostrarFormulario() {
            const cargo = document.getElementById("cargo").value;
            document.querySelectorAll(".form-cargo").forEach(div => {
                div.classList.add("hidden");
                div.querySelectorAll("input, select").forEach(el => el.required = false);
            });
            if (!cargo) return;
            const ativo = document.getElementById("form-" + cargo);
            ativo.classList.remove("hidden");
            ativo.querySelectorAll("input, select").forEach(el => {
                if(el.name !== "capitalSocial" && el.name !== "prefLinguistica") el.required = true;
            });
        }

        function validarFormulario() {
            const cargo = document.getElementById("cargo").value;
            if (cargo === "Cliente") {
                const telefone = document.querySelector("[name='telefone']").value;
                const nif = document.querySelector("[name='nif']").value;

                if (!/^\+[0-9]{1,4} [0-9]{9}$/.test(telefone)) {
                    alert("Telefone inválido. Use o formato +351 9XXXXXXXX");
                    return false;
                }
                if (!/^\d{9}$/.test(nif)) {
                    alert("NIF inválido (9 dígitos).");
                    return false;
                }

                const tipo = document.querySelector("[name='tipoCliente']").value;
                if(tipo === "Empresa") {
                    const capital = document.querySelector("[name='capitalSocial']").value;
                    if(!capital || Number(capital) <= 0) {
                        alert("Capital social obrigatório e maior que 0 para empresas.");
                        return false;
                    }
                }
            }
            return true;
        }
    </script>
</head>

<body>
<div class="container">
    <h2>Registo VetCare</h2>

    <form action="registro" method="post" onsubmit="return validarFormulario()">

        <!-- LOGIN -->
        <label>Username</label>
        <input type="text" name="username" required minlength="4">

        <label>Password</label>
        <input type="password" name="password" required minlength="6">

        <!-- CARGO -->
        <label>Cargo</label>
        <select name="cargo" id="cargo" required onchange="mostrarFormulario()">
            <option value="">-- Escolha --</option>
            <option value="Cliente">Cliente</option>
            <option value="Veterinario">Veterinário</option>
            <option value="Rececionista">Rececionista</option>
            <option value="Gerente">Gerente</option>
        </select>

        <!-- ================= CLIENTE ================= -->
        <div id="form-Cliente" class="form-cargo hidden">

            <label>Tipo de Cliente</label>
            <select name="tipoCliente" required>
                <option value="Particular">Particular</option>
                <option value="Empresa">Empresa</option>
            </select>

            <label>Nome</label>
            <input type="text" name="nomeCliente" required>

            <label>NIF</label>
            <input type="text" name="nif" required pattern="\d{9}" title="9 dígitos">

            <label>Email</label>
            <input type="email" name="email" required>

            <label>Telefone</label>
            <input type="text" name="telefone" required placeholder="+351 912345678"
                   pattern="^\+[0-9]{1,4} [0-9]{9}$" title="Formato: +<código país> <número (9 dígitos)>">

            <label>Rua</label>
            <input type="text" name="rua" required>

            <label>País</label>
            <input type="text" name="pais" value="Portugal" required>

            <label>Distrito</label>
            <input type="text" name="distrito" required>

            <label>Concelho</label>
            <input type="text" name="concelho" required>

            <label>Freguesia</label>
            <input type="text" name="freguesia" required>

            <!-- Particular -->
            <div>
                <label>Preferência Linguística</label>
                <input type="text" name="prefLinguistica">
            </div>

            <!-- Empresa -->
            <div>
                <label>Capital Social (€)</label>
                <input type="number" name="capitalSocial" min="1">
            </div>

        </div>

        <!-- ================= VETERINÁRIO ================= -->
        <div id="form-Veterinario" class="form-cargo hidden">
            <label>Nome</label>
            <input type="text" name="nomeVet" required>
            <label>Idade</label>
            <input type="number" name="idade" min="21" required>
            <label>Especialidade</label>
            <input type="text" name="especialidade" required>
        </div>

        <!-- ================= RECECIONISTA ================= -->
        <div id="form-Rececionista" class="form-cargo hidden">
            <p>Rececionista não requer dados adicionais.</p>
        </div>

        <!-- ================= GERENTE ================= -->
        <div id="form-Gerente" class="form-cargo hidden">
            <p>Gerente não requer dados adicionais.</p>
        </div>

        <button type="submit">Criar Conta</button>
    </form>
</div>
</body>
</html>
