const id = localStorage.getItem("id")


document.addEventListener('DOMContentLoaded', () => {

    fetch("http://localhost:8080/servicos", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            let divpai = document.getElementById("div-p")
            for (let index = 0; index < data.length; index++) {
                if (data[index].usuario.idUsuario == id) {
                    const nome = data[index].nome
                    const idServico = data[index].idServico

                    displayNone()

                    divpai.innerHTML += `
                    <div class="row alert alert-success div-agendamento" id=${idServico}>
                        <div class = "col-9">
                        <p class="p-a4"><strong class="a1">${nome}</strong></p> 

                        </div>

                        <div class = "col-3" >
                        <a href="../pages/editar-servicos.html"><img class="a1-img divdiv"id="${idServico}" onclick = "salveId(this.id)"
                        src="../img/edit_square_FILL0_wght400_GRAD0_opsz48.png"></a>

                        <a href=""><img class="a2-img" src="../img/delete_FILL0_wght400_GRAD0_opsz48.png" id = "${idServico}" onclick = "deletaItem(this.id)"></a>
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

function salveId(id){
    localStorage.setItem("idServico", id)
}
function displayNone() {

    const divDisplay = document.getElementById("div-p-alert")

    divDisplay.className = "display"
}

function deletaItem(id) {
    fetch(`http://localhost:8080/servicos/${id}`, {
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