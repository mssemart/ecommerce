<link type='text/css' href='${rc.getContextPath()}/css/pagination.css'  rel='stylesheet' />
<script type="text/javascript" src="${rc.getContextPath()}/js/pagination.js"></script>
<script type="text/javascript">
	var num_page = 4;

	function pageselectCallback(page_index, jq)
	{
		p = (page_index * num_page);
		var num_entries = jQuery('#hiddenresult article').length;
		
		$('#list').empty();
		for(i=p;i<(p+num_page);i++)
		{
			new_content = jQuery('#hiddenresult article:eq('+i+')').clone();
			$('#list').append(new_content);		
		}
		
		return false;
	}
		
	function initPagination() 
	{
		// count entries inside the hidden content
		var num_entries = jQuery('#hiddenresult article').length;
		// Create content inside pagination element
		$("#pagination").pagination
		(
			num_entries, 
			{
				callback: pageselectCallback,
				items_per_page:num_page // Show only one item per page
			}
		);
	}
	
	$(document).ready
	(
		function()
		{
			initPagination();
		}
	); 
</script>
