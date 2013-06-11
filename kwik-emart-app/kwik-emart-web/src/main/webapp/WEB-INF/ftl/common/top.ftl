<!--top-->
<div id="header">
	<div class="inner">
		<p class="logo"><a href="${rc.getContextPath()}" title="Kwik-E-Mart e-Commerce - Inform&aacute;tica, Eletr&ocirc;nicos, Telefonia, Eletrodom&eacute;sticos e muito mais. Bem Vindo!"></a></p>
		<div class="utilities home">
			<div id="contacts">
			    <form id="frm_search" name="frm_search" method="post" action="${rc.getContextPath()}/pesquisa">
				    <input type="text" name="palavraChave" id="palavraChave" value="" class="required">
				    <button id="btn_search" name="btn_search" type="submit">Pesquisar</button>
			    </form>
				<p>
					<a href='${rc.getContextPath()}/login'>Login</a>&nbsp;&nbsp;
					<a href='${rc.getContextPath()}/criarUsuario'>Cadastre-se</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href='${rc.getContextPath()}/cadastrarProduto'>Cadastrar Produtos</a>
				</p>			
			</div>
		</div>
	</div>
</div>
<!--top-->