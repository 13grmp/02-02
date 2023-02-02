
const form = document.getElementById("forms")
const nome = document.getElementById("nome")
const descricao = document.getElementById("descricao")
const divselect = document.getElementById("div-select")
const divNome = document.getElementById("div-nome")
const divBotao = document.getElementById("botao")
 
// const idUser = 
// console.log("idUser é: " + idUser)
 
form.addEventListener("submit", (e) => {
    e.preventDefault()
    validarEntradas(nome,descricao)
})
 
 
function validarEntradas(n,d){
    const nomeValue = String(n.value)
    const descricaoValue = String(d.value)
 
    if (nomeValue === "" || nomeValue == null) {
        console.log('Não é permitido algo nulo')
    }else{
        mandarServidor(nomeValue, descricaoValue)
        window.location.replace("http://127.0.0.1:5500/frontend/pages/servicos-cadastrados.html")
    }
}
 
function mandarServidor(n, d) {
    fetch("http://localhost:8080/servicos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            nome: n,
            descricao: d,
            usuario:{
                idUsuario: localStorage.getItem("id")
            }
        }),
    })
    .then((response) => response.json())
    .then((data) => {
        console.log("Success:", data);
    })
    .catch((error) => {
        console.error("Error:", error);
    });
}