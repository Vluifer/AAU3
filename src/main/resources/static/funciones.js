/* Con esta funcion eliminamos medianmte una ventana modal que hemos tomado de la pagina SweetAlert
y lo acomodamos a nuestra necesidad */
function eliminar(cedula){
    swal({
        title: "Esta seguro?",
        text: "Una vez eliminado, ¡no podrá recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((OK)=>{
        if(OK){
            $.ajax({
                url:"/usuario/eliminar/"+cedula,
                success: function(res) {
                    console.log(res);
                }
            });
          swal("¡El registro ha sido eliminado!", {
            icon: "success",
          }).then((OK)=>{
            if(OK){
                location.href="/usuario/listar";
            };
          });
        } else {
          swal("El registro no fue eliminado!");
        }
      });
}

function eliminarD(id){
    swal({
        title: "Esta seguro?",
        text: "Una vez eliminado, ¡no podrá recuperado!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((OK)=>{
        if(OK){
            $.ajax({
                url:"/docente/eliminar/"+id,
                success: function(res) {
                    console.log(res);
                }
            });
          swal("¡El registro ha sido eliminado!", {
            icon: "success",
          }).then((OK)=>{
            if(OK){
                location.href="/docente/listard";
            };
          });
        } else {
          swal("El registro no fue eliminado!");
        }
      });
}