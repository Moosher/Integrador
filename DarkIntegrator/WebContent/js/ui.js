$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar, .content').toggleClass('active');
        $('.collapse.in').toggleClass('in');
        $('a[aria-expanded=true]').attr('aria-expanded', 'false');
    });
});

$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').trigger('focus')
});

$("#subveiculo").click(function(){
	var check = $("#cmbmodelo").val();
	console.log(check);
	if(check == "van"){
		$("#capacidade").val("1");
		$("#prioridade").val("1");
	}
	
	if(check == "caminhao"){
		$("#capacidade").val("3");
		$("#prioridade").val("2");
	}
	
	if(check == "carreta"){
		$("#capacidade").val("10");
		$("#prioridade").val("3");
	}
	
	console.log($("#capacidade").val());
	console.log($("#prioridade").val());

});

$(".dropA").click(function(){	
	$(".dropC").collapse('hide');

});

document.getElementById("codloc").onkeypress = function(e) {
    var chr = String.fromCharCode(e.which);
    if ("-".indexOf(chr) >= 0)
        return false;
    if ("e".indexOf(chr) >= 0)
    	return false
};

document.getElementById("peso").onkeypress = function(e) {
	var chr = String.fromCharCode(e.which);
	if ("-".indexOf(chr) >= 0)
		return false;
	if ("e".indexOf(chr) >= 0)
		return false
};