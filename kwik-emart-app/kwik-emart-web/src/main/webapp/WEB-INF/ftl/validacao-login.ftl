<script type="text/javascript">
$(document).ready(function()
{
	$("#frm_usuario").validate
	({
		rules: 
		{
			email: { required: true }, 
			senha: { required: true } 			
		},
	
		messages: 
		{
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