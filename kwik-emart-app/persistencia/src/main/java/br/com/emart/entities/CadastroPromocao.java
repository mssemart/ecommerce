package br.com.emart.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "cadastro_promocao")
public class CadastroPromocao {
	@Id
	@GeneratedValue
	@Column(name = "codigo_cadastro_promocao")
	private Long codigoCadastroPromocao;
	private String nome;
	private String email;

	@Column(name = "data_cadastro")
	private Date dataCadastro;
	private boolean ativo;

	public Long getCodigoCadastroPromocao() {
		return codigoCadastroPromocao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setCodigoCadastroPromocao(Long codigoCadastroPromocao) {
		this.codigoCadastroPromocao = codigoCadastroPromocao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public boolean equals(Object obj) {
		CadastroPromocao value = (CadastroPromocao) obj;

		return this.codigoCadastroPromocao == value.getCodigoCadastroPromocao();
	}

}