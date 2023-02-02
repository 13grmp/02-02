const form = document.getElementById("form-signin")
const email = document.getElementById("inputEmail")
const senha =  document.getElementById("inputSenha")


form.addEventListener("submit", (e) => {
    e.preventDefault()
    validarEntrada(email,senha)
})


function validarEntrada(e,s){
    
    const emailValue = String(e.value)
    const senhaValue = String(s.value)

    
    if(emailValue === "" || emailValue === null){

    }else if(senhaValue === ""|| senhaValue === null){

    }else{
        
        fetch("http://localhost:8080/usuarios", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            for (let i = 0; i < data.length; i++) {
                if(data[i].email === emailValue){
                    if(data[i].senha === senhaValue){
  
                        
                        localStorage.setItem("nome", data[i].nome)
                        localStorage.setItem("email", data[i].email)
                        localStorage.setItem("id", data[i].idUsuario)

                        if(data[i].tipoUsuario.idTipoUsuario === 1){
                            console.log("cheguei")
                            window.location.replace("http://127.0.0.1:5500/frontend/pages/agendar-servico.html")
                        }else if((data[i].tipoUsuario.idTipoUsuario === 2)){
                            console.log("cheguei")
                            window.location.replace("http://127.0.0.1:5500/frontend/pages/servicos-cadastrados.html")
                        }                    
                    }else{
                        console.log("senha invalida")
                    }
                } else{
                    console.log("email invalido")
                }   
            }
        })
        .catch((error) => {
            console.error("Error:", error);
        });   
    }
}