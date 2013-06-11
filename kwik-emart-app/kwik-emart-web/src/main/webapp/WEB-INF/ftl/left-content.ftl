<div id="left-content">
	<ul>
		<#if categorias??>
			<#list categorias as categoria>	
		    <li><a href='${rc.getContextPath()}/produtosPorCategoria?codigoCategoria=${categoria.codigoCategoria}'>${categoria.nome}</a></li>
		    </#list>
	    </#if>
	</ul>
</div>