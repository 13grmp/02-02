//referenciar os elementos html

const data = document.getElementById("data")
const hora = document.getElementById("hora")
const serv_op = document.getElementById("servico-options")
const id = localStorage.getItem("id")

document.addEventListener('DOMContentLoaded', () => {
    listarServicos(serv_op)
})

document.addEventListener('submit', () => {
    console.log("MANDOU?")
    fazAgendamento(data, hora,serv_op, id);
})

async function listarServicos(serv_op){
    await fetch(`http://localhost:8080/servicos`,{
        method:"GET",
        headers: {
            "Content-Type": "application/json",
        }
    }) 
    .then((response) => response.json())
        .then((data) => {
            console.log("Success:", data);
            for(let i = 0; i < data.length; i++){
                serv_op.add(new Option(data[i].nome)) //gerando uma option com o nome do servico
                //setando o id do option pra ter como referenciar depois no post
                serv_op.options[i].id = data[i].idServico
                console.log(serv_op.options[i].id)
            }
        })
        .catch((error) => {
            console.error("Error:", error);
        });
    }

async function fazAgendamento(data, hora,serv_op, id){
    await fetch(`http://localhost:8080/agendamentos`,{
        method:"POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            // nome: "nerdola"
            data: data.value,
            hora: hora.value,
            servico:{
                idServico: serv_op.options[serv_op.selectedIndex].id
            },
            usuario:{
                idUsuario: id
            }
        })
    }) 
    .then((response) => response.json())
        .then((data) => {
            console.log("Success:", data);
        })
        .catch((error) => {
            console.error("Error:", error);
        });
}