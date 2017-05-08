$(document).ready(function() {
	// Comprobar compatibilidad de navegador
	var bw = new Browser(); 
	if(bw.code == "ie" && bw.version <= 8){
		window.location = '../../mvc/login/navegador';
	}
	else if (bw.code == "ff" && bw.version <= 10) {
		window.location = '../../mvc/login/navegador';
	}
	
	$('#ingresar').click(function() {
		var i = 0;
		if($("#txtUsuario").val() == ''){
			alert("Debe ingresar el nombre de usuario.");
			i++;
		}else{
			if($("#txtClave").val() == ''){
				alert("Debe ingresar la contraseña.");
				i++;
			}
		}
		if(i == 0){
			//$("#form").attr("action","guardar");
			$("#form").submit();
		}
	});
	
	$("#txtClave").keypress(function(e) {
        if(e.which == 13) {
            jQuery(this).blur();
            jQuery('#ingresar').focus().click();
        }
	});
	
});