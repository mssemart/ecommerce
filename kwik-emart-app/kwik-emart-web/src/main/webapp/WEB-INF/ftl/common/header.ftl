<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Kwik-E-Mart e-Commerce - Inform&aacute;tica, Eletr&ocirc;nicos, Telefonia, Eletrodom&eacute;sticos e muito mais. Bem Vindo!</title>
<meta name="keywords" content="">
<meta name="description" content="">
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/reset.css">
<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/style.css">
<meta name="viewport" content="width=device-width; initial-scale=1.0;">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<!--[if (IE 8) & (!IEMobile)]>
	<script src="${rc.getContextPath()}/js/css3-mediaqueries.js"></script>
<![endif]-->
<!--[if (gte IE 6)&(lte IE 8)]>
	<script type="text/javascript" src="${rc.getContextPath()}/js/selectivizr.js"></script>
<![endif]-->
<!--[if lte IE 7]>
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/fixed-ie.css" media="screen">
<![endif]-->
<!--[if lte IE 6]>
	<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/ie6.css" media="screen">
	<script src="${rc.getContextPath()}/js/DD_belatedPNG_0.0.8a-min.js"></script>
	<script src="${rc.getContextPath()}/js/scripts-png.js"></script>
<![endif]-->

<link type="text/css" href="${rc.getContextPath()}/css/ui-lightness/jquery-ui-1.8.17.custom.css" rel="stylesheet" />

<script type="text/javascript" src="${rc.getContextPath()}/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/jquery-ui-1.8.17.custom.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/jquery.maskedinput-1.3.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/jquery.maskmoney.js"></script>

<script type="text/javascript">
$(document).ready(function()
{
	$('#dlg_box').dialog
	({
		autoOpen: false,
		modal: true
	});
});

function send_post_ajax(url,form)
{
	alert("SendAjax");
	$.ajax({
		url : url,
		type:'POST',
		data: $(form).serialize(),
		dataType : "json",
		success : function(result)
		{
			alert("OK");
		}		

	});
	alert("RetSendAjax");
}

function msgbox_info(title,msg)
{
	$("#dlg_box_content").html(msg);
	$('#dlg_box').dialog({title: title});
	$('#dlg_box').dialog
	({
		buttons: 
		{
			"OK": function() 
			{ 
				$('#dlg_box').dialog( "close" );
			} 
		}
	});
	$(dlg_box).dialog('open');
}
</script>

