package br.com.emart.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@NamedQueries({
	@NamedQuery(name = "Produto.findByActive",  query = "from Produto p where p.ativo = true"),
	@NamedQuery(name = "Produto.findByShowCase",query = "from Produto p where p.ativo = true and (p.destaque = true or p.promocao = true)"),
	@NamedQuery(name = "Produto.findByKeyWord", query = "from Produto p where p.ativo = true and LOWER(p.palavraChave) like LOWER(?1)")
})

public class Produto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4307385628173432206L;

	@Id
	@GeneratedValue
	@Column(name = "codigo_produto")
	private Long codigoProduto;

	private String titulo;

	private String nome;

	private String descricao;

	@Column(name = "valor_unitario")
	private BigDecimal valorUnitario;

	@Column(name = "valor_custo")
	private BigDecimal valorCusto;

	@Column(name = "valor_promocao")
	private BigDecimal valorPromocao;

	@Column(name = "palavra_chave")
	private String palavraChave;
	
	private String imagem;

	private boolean ativo;

	private boolean destaque;

	private boolean promocao;

	@Column(name = "data_criacao")
	private Date dataCriacao;

	@Column(name = "data_ultima_atualizacao")
	private Date dataUltimaAtualizacao;

	@ManyToOne
	@JoinColumn(name = "codigo_categoria")
	private Categoria categoria;

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public BigDecimal getValorPromocao() {
		return valorPromocao;
	}

	public void setValorPromocao(BigDecimal valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	
	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isDestaque() {
		return destaque;
	}

	public void setDestaque(boolean destaque) {
		this.destaque = destaque;
	}

	public boolean isPromocao() {
		return promocao;
	}

	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataUltimaAtualizacao() {
		return dataUltimaAtualizacao;
	}

	public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
		this.dataUltimaAtualizacao = dataUltimaAtualizacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	public String getPalavraChave() {
		return palavraChave;
	}

	public void setPalavraChave(String palavraChave) {
		this.palavraChave = palavraChave;
	}

	@Override
	public boolean equals(Object obj) {
		Produto value = (Produto) obj;

		return this.codigoProduto == value.getCodigoProduto();
	}

}