<script type="text/javascript">
$(document).ready(function()
{
	$('#nome').focus();
	$("#telefone").mask("(99) 9999-9999");
	$("#celular").mask("(99) 99999-9999");

	$("#frm_usuario").validate
	({
		rules: 
		{
			nome: { required: true },
			email: { required: true }, 
			senha: { required: true } 			
		},
	
		messages: 
		{
			nome: { required: "Por favor informar o nome!" } ,
			email: { required: "Por favor informar o E-mail!" }, 
			senha: { required: "Por favor informar a senha!" } 			
		}
	});
	
	$('#btn_send').click(function() 
	{
		$("#frm_usuario").submit();
	});
});
</script>