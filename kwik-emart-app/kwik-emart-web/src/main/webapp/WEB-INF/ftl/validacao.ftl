<script type="text/javascript">
$(document).ready(function()
{
	$("#frm_search").validate
	({
		rules: 
		{
			palavraChave: { required: true }
		},
	
		messages: 
		{
			palavraChave: { required: "Por favor informar um produto!" } 
		}
	});
});
</script>