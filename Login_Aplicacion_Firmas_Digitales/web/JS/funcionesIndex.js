 
 function resetearFormulario()
 {
     document.getElementById("formularioInscr").reset();
     var avisoPass = document.getElementById("avisoPass");
     var btnEnviar = document.getElementById("btnEnviar");
     avisoPass.innerHTML = "------------------------";
     avisoPass.style.color = "black";
     btnEnviar.disabled = true;
 }
 
 function cargarElementosDinamicos(url,elemento)
 {
     var request = new XMLHttpRequest();
     request.open("GET", url, false);
     request.send(null);
     elemento.innerHTML = request.responseText;
 }
 
 function cargarRegistroUsuario()
 {
     cargarElementosDinamicos("Vista/altaUsuario.jsp", document.getElementById("contenidoDinamico"));
 }

 function cargarLoginUsuarios()
 {
     cargarElementosDinamicos("Vista/Login.jsp", document.getElementById("contenidoDinamico"));
 }
 
 function coincidenciaPasswords()
 {
     var txtPass = document.getElementById("txtPass");
     var txtConfPass = document.getElementById("txtConfPass");
     var avisoPass = document.getElementById("avisoPass");
     var btnEnviar = document.getElementById("btnEnviar");
     btnEnviar.disabled = true;
     
     if(txtPass.value.length === 0 || txtConfPass.value.length === 0)
     {
         avisoPass.innerHTML = "¡NO DEBE HABER CAMPOS VACIOS!";
         avisoPass.style.color = "blue";
         btnEnviar.disabled = true;
     }
     else if (txtPass.value !== txtConfPass.value)
     {
         avisoPass.innerHTML = "¡LAS CONTRASEÑAS NO COINCIDEN!";
         avisoPass.style.color = "red";
         btnEnviar.disabled = true;
     }
     else
     {
         avisoPass.innerHTML = "¡Contraseñas Validas!";
         avisoPass.style.color = "green";
         btnEnviar.disabled = false;
     }
 }

