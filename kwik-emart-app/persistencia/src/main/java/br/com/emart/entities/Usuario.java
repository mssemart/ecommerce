package br.com.emart.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQuery(name = "Usuario.findByEmail", query = "from Usuario u where LOWER(u.email) = LOWER(?1)")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8971455164267379878L;

	public Usuario() {
		enderecos = new ArrayList<Endereco>();
	}

	@Id
	@GeneratedValue
	@Column(name = "codigo_usuario")
	private Long codigoUsuario;

	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String celular;

	@Column(name = "tipo_usuario")
	private int tipoUsuario;

	@OneToMany(mappedBy = "usuario", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Collection<Endereco> enderecos;

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public boolean equals(Object obj) {
		Usuario value = (Usuario) obj;

		return this.codigoUsuario == value.getCodigoUsuario();
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public void addEndereco(Endereco endereco) {
		if (!getEnderecos().contains(endereco)) {
			getEnderecos().add(endereco);
			if (endereco.getUsuario() != null) {
				endereco.getUsuario().getEnderecos().remove(endereco);
			}
			endereco.setUsuario(this);
		}
	}

}