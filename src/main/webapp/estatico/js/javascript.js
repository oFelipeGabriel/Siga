function mostrarClasse(cod,id){
    var i;
    var mats = document.getElementById("materiasEscolhidas");
    var mt;
    var final;
    var materia;
    var materias = document.getElementsByClassName(cod);

    for(i=0;i<materias.length;i++){
        var h = materias[i].getAttribute("class").split(" ");
        var m = document.getElementsByClassName(h[2]);
        for(var k=0;k<m.length;k++){
            var c = m[k].getAttribute("class").split(" ");
            if(m[k].getAttribute("class").includes(cod)){
              m[k].style.backgroundColor = "green";
            }else{
                if(mats.value.includes(c[1])){
                    var z = mats.value.split(",");
                    for(itera=0;itera<z.length;itera++){
                        if(z[itera]==c[1]){
                            z[itera] = "";
                        }
                    }
                    mats.value = z.toString();
                }
              var r = document.getElementsByClassName(c[1]);
              for(x=0;x<r.length;x++){
                  r[x].style.backgroundColor = "red";
              }  
              m[k].style.backgroundColor = "red";
            }
        }
    }
    if(!mats.value.includes((cod))){
        mats.value = mats.value+cod+",";
    }

}

document.getElementById("sigaLogo").addEventListener("click", mudarCor);

function mudarCor(){
    var siga = document.getElementById("sigaLogo");
    if(siga.style.backgroundColor == "red"){
        siga.style.backgroundColor = "cyan";
        defineCampos();
    }else{
        siga.style.backgroundColor = "red";
    }
}

function defineCampos() {
    document.getElementById("sigaLogo").innerHTML = "Seguindo";
}