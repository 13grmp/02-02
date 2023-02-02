const id = localStorage.getItem("id")


document.addEventListener('DOMContentLoaded', () => {

    fetch("http://localhost:8080/agendamentos", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            let divpai = document.getElementById("div-p")
            for (let index = 0; index < data.length; index++) {
                if (data[index].servico.usuario.idUsuario == id) {
                    const nome = data[index].servico.nome
                    const idAgendamento = data[index].idAgendamento
                    const cliente = data[index].servico.usuario.nome
                    const dia = data[index].data
                    const hora = data[index].hora

                    displayNone()

                    divpai.innerHTML += `
                    <div class="row alert alert-success div-agendamento" id=${idAgendamento}>
                        <div class = "col-9">
                        <p class="p-a4"><strong class="a1">${nome}</strong></p> 
                        
                        <p class="p-a4"><strong class="a1">Cliente: </strong>${cliente}</p>
                        <p class="p-a4"><strong class="a1">Dia: </strong>${dia}</p>
                        <p class="p-a4"><strong class="a1">Horário: </strong>${hora}</p>

                        </div>

                        <div class = "col-3" >
                        <a href="../pages/editar-agendamento.html"><img class="a1-img divdiv"id="${idAgendamento}" onclick = "salveId(this.id)"
                        src="../img/edit_square_FILL0_wght400_GRAD0_opsz48.png"></a>

                        <a href=""><img
                        class="a2-img" src="../img/delete_FILL0_wght400_GRAD0_opsz48.png" id = "${idAgendamento}" onclick = "deletaItem(this.id)"></a>

                        
                        </div>
                        <div>


                        </div>
                        
                    </div>
                    `



                }
            }

        })
        .catch((error) => {
            console.error("Error:", error);
        });

})


function displayNone() {

    const divDisplay = document.getElementById("div-p-alert")

    divDisplay.className = "display"
}

function deletaItem(id) {
    console.log(id);
    fetch(`http://localhost:8080/agendamentos/${id}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {

        })
        .catch((error) => {
            console.error("Error:", error);
        });
}