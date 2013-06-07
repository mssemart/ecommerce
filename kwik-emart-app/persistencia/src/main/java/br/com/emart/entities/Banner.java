package br.com.emart.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "banner")
public class Banner {
	@Id
	@GeneratedValue
	@Column(name = "codigo_banner")
	private Long codigoBanner;
	private String titulo;

	@Column(name = "banner_url")
	private String bannerUrl;

	@Column(name = "diretorio_imagem")
	private String diretorioImagem;

	@Column(name = "data_inicio")
	private Date dataInicio;

	@Column(name = "data_fim")
	private Date dataFim;

	public Long getCodigoBanner() {
		return codigoBanner;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public String getDiretorioImagem() {
		return diretorioImagem;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setCodigoBanner(Long codigoBanner) {
		this.codigoBanner = codigoBanner;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public void setDiretorioImagem(String diretorioImagem) {
		this.diretorioImagem = diretorioImagem;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public boolean equals(Object obj) {
		Banner value = (Banner) obj;

		return this.codigoBanner == value.getCodigoBanner();
	}

}