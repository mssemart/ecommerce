package br.com.emart.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7957675148198231959L;

	@Id
	@GeneratedValue
	@Column(name = "codigo_endereco")
	private Long codigoEndereco;

	private String logradouro;

	@Column(name = "numero_logradouro")
	private String numeroLogradouro;
	private String bairro;
	private String sigla;
	private String cep;

	@Column(name = "tipo_endereco")
	private int tipoEndereco;

	
    @ManyToOne  
    @JoinColumn(name="codigo_usuario")
    private Usuario usuario;  	
	
	public Long getCodigoEndereco() {
		return codigoEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public String getSigla() {
		return sigla;
	}

	public String getCep() {
		return cep;
	}

	public int getTipoEndereco() {
		return tipoEndereco;
	}

	public void setCodigoEndereco(Long codigoEndereco) {
		this.codigoEndereco = codigoEndereco;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setTipoEndereco(int tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {
		Endereco value = (Endereco) obj;

		return this.codigoEndereco == value.getCodigoEndereco();
	}

}