const form = document.getElementById("forms")
const nome = document.getElementById("nome")
const descricao = document.getElementById("descricao")
const divselect = document.getElementById("div-select")
const divNome = document.getElementById("div-nome")
const divBotao = document.getElementById("botao")


const idServico = localStorage.getItem("idServico")

form.addEventListener('submit', (e) => {
    e.preventDefault()
    validarEntradas(nome, descricao)
})

function validarEntradas(n, d) {
    
    const nomeValue = String(n.value)
    const descricaoValue = String(d.value)

    if (nomeValue === "" || nomeValue == null) {
        console.log('Não é permitido algo nulo')
    } else {
        mandarServidor(nomeValue, descricaoValue)
        // window.location.replace("http://127.0.0.1:5500/frontend/pages/servicos-cadastrados.html")
    }
}

function mandarServidor(n,d) {


    const idServico = localStorage.getItem("idServico")
    fetch("http://localhost:8080/servicos", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            for (let index = 0; index < data.length; index++) {
                if (idServico == data[index].idServico) {
                        fetch("http://localhost:8080/servicos", {
                                method: "PUT",
                                headers: {
                                    "Content-Type": "application/json",
                                },
                                body: JSON.stringify({
                                    idServico:idServico,
                                    nome:n,
                                    descricao:d
                                })
                            })
                            .then((response) => response.json())
                            .catch((error) => {
                                console.error("Error:", error);
                            });

                    
                }
            }

        })
        .catch((error) => {
            console.error("Error:", error);
        });


}