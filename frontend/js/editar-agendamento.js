//referenciar os elementos html
const form = document.getElementById("form-signin")
const data = document.getElementById("data")
const hora = document.getElementById("hora")
const serv_op = document.getElementById("servico-options")
const id = localStorage.getItem("id")
const idServico = localStorage.getItem("idServico")

document.addEventListener('DOMContentLoaded', () => {
    listarServicos(serv_op)
})


form.addEventListener('submit', (e) => {
    e.preventDefault()
    validarEntradas(data, hora)
})

async function listarServicos(serv_op) {
    await fetch(`http://localhost:8080/servicos`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            }
        })
        .then((response) => response.json())
        .then((data) => {
            console.log("Success:", data);
            for (let i = 0; i < data.length; i++) {
                serv_op.add(new Option(data[i].nome)) //gerando uma option com o nome do servico
                //setando o id do option pra ter como referenciar depois no post
                serv_op.options[i].id = data[i].idServico
            }
        })
        .catch((error) => {
            console.error("Error:", error);
        });
}





function validarEntradas(d, h) {

    const dataValue = String(d.value)
    const horaValue = String(h.value)

    if (dataValue === "" || dataValue == null) {
        console.log('Não é permitido algo nulo')
    } else if (horaValue === "" || horaValue == null) {
        console.log('Não é permitido algo nulo')
    } else {
        mandarServidor(dataValue, horaValue)
        window.location.replace("http://127.0.0.1:5500/frontend/pages/agenda-cliente.html")
    }
}

function mandarServidor(d, h) {



    fetch("http://localhost:8080/agendamentos", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            const idAgendamento = localStorage.getItem("idAgendamento")
            fetch("http://localhost:8080/agendamentos", {
                    method: "PUT",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify({
                        idAgendamento: idAgendamento,
                        data: d,
                        hora: h
                    })
                })
                .then((response) => response.json())
                .catch((error) => {
                    console.error("Error:", error);
            });
        })
        .catch((error) => {
            console.error("Error:", error);
        });


}