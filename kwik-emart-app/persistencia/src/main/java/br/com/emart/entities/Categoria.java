package br.com.emart.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

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
@Table(name = "categoria")
@NamedQuery(name = "Categoria.findByActive", query = "from Categoria c where c.ativo = true")
public class Categoria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3737074306376282203L;

	@Id
	@GeneratedValue
	@Column(name = "codigo_categoria")
	private Long codigoCategoria;

	private String nome;
	private String descricao;
	private boolean ativo;

	@OneToMany(mappedBy = "categoria", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Collection <Produto> produtos;	
	
	
	public Categoria() {
		produtos = new ArrayList<Produto>();
	}
	
	
	public Long getCodigoCategoria() {
		return codigoCategoria;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(Produto produto) {
		if (!getProdutos().contains(produto)) {
			getProdutos().add(produto);
			if (produto.getCategoria() != null) {
				produto.getCategoria().getProdutos().remove(produto);
			}
			produto.setCategoria(this);
		}
	}	
	
	@Override
	public boolean equals(Object obj) {
		Categoria cat = (Categoria) obj;
		return this.codigoCategoria == cat.getCodigoCategoria();
	}

}