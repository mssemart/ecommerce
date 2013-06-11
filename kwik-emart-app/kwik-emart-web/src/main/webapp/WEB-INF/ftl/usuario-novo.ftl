<!DOCTYPE html>
<html lang="en">
<head>
<#include "/common/header.ftl">
<#include "/validacao-usuario.ftl">
</head>
<body id="home">
	<#include "/common/top.ftl">
	
	<!-- content -->
	<div id="content">
		<div class="inner">
			<div id="main-content">
				<form id="frm_usuario" name="frm_usuario" method="post" action="${rc.getContextPath()}/salvarUsuario" >
					<fieldset>
						<legend>Cadastrar</legend>
						<p><em>(*)</em> Preenchimento obrigat&oacute;rio</p>
						<ol>
							<li class="longdesc">
								<label for="nome">Nome: <em>(*)</em></label>
								<input type="text" name="nome" id="nome" value="" class="required">
							</li>						
							<li class="longdesc">
								<label for="email">Email: <em>(*)</em></label>
								<input type="email" name="email" id="email" value="" class="required email">
							</li>
							<li  class="longdesc">
								<label for="senha">Senha: <em>(*)</em></label>
								<input type="password" name="senha" id="senha" value="">
							</li>
							<li  class="longdesc">
								<label for="telefone">Telefone:</label>
								<input type="text" name="telefone" id="telefone" value="">
							</li>
							<li  class="longdesc">
								<label for="celular">Celular:</label>
								<input type="text" name="celular" id="celular" value="">
							</li>
						</ol>
						<p>
						  <button id="btn_send" name="btn_send" type="button">Criar</button>
						</p>
					</fieldset>
				</form>
			</div>
		</div>		
	</div>	
	<!-- content -->


	<#include "/common/footer.ftl">
</body>
</html>

