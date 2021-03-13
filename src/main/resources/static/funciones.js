function eliminar(id){
	swal({
  title: "Estas seguro de Eliminar?",
  text: "Una vez borrada, no se podra recuperar.",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
  	$.ajax({
  		url:"/eliminar/"+id,
  		success: function(res){
  			console.log(res);
  		},
  	});
    swal("La entrada al diario se ha borrado!", {
      icon: "success",
    }).then((ok)=>{
    	if(ok){
    		location.href="/listar";
    	}
    	
    });
  } else {
    swal("No se ha borrado!");
  }
});
}