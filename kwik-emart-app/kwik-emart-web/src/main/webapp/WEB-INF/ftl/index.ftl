<!DOCTYPE html>
<html lang="en">
<head>
<#include "/common/header.ftl">
<#include "/validacao.ftl">
<#include "/common/paginacao.ftl">
</head>
<body id="home">
	<#include "/common/top.ftl">
	
	<!-- content -->
	<div id="content">
		<div class="inner">
			<#include "/left-content.ftl">
		
			<div id="main-content">
				<div id="list"></div>
				<div id="pagination"></div>
			</div>
			
			<#include "/right-content.ftl">
			
		</div>		
		
	</div>	
	<!-- content -->

	<div id="hiddenresult" style="display:none;">
		<#if produtos??>
			<#list produtos as produto>
		    <article>
			    <div class="detail-product">
			    		
				  <div class="entry-details">
					<img  src="${rc.getContextPath()}/img/catalog/${produto.imagem}"  width="100" height="100" />
				  </div>

				    <header class="entry-header">
					    <h2 class="entry-title">${produto.nome}</h2>
				    </header>
				    
				    <div class="entry-content">
					    <p>
						    ${produto.descricao}
					    </p>
					    <p>
						    Valor  R$ ${produto.valorUnitario?string("#,##0.00")}
					    </p>
				    </div>	
				    
			    </div>
		    </article>
	    	</#list>
	    </#if>
	</div>

	<#include "/common/footer.ftl">
</body>
</html>

