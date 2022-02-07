package br.com.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDestinatario;
	private String cepOrigem;
	private String cepDestino;
	private Double peso;
	private BigDecimal vlTotalFrete;
	private LocalDate dataPrevistaEntrega;
	private LocalDate dataConsulta;

	public Frete() {
		this.dataConsulta = LocalDate.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getCepOrigem() {
		return cepOrigem;
	}

	public void setCepOrigem(String cepOrigem) {
		this.cepOrigem = cepOrigem;
	}

	public String getCepDestino() {
		return cepDestino;
	}

	public void setCepDestino(String cepDestino) {
		this.cepDestino = cepDestino;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public BigDecimal getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(BigDecimal vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public void calculaFrete(Endereco enderecoOrigem, Endereco enderecoDestino){
		this.vlTotalFrete = new BigDecimal(this.peso*1.0);
		this.dataPrevistaEntrega = LocalDate.now().plusDays(10);
		
		if(enderecoOrigem.getDdd().equals(enderecoDestino.getDdd())) {
			this.vlTotalFrete = new BigDecimal(this.vlTotalFrete.doubleValue()*0.5);
			this.dataPrevistaEntrega = LocalDate.now().plusDays(1);
			return;
		}
		if(enderecoOrigem.getUf().equals(enderecoDestino.getUf())){
			this.vlTotalFrete = new BigDecimal(this.vlTotalFrete.doubleValue()*0.25);
			this.dataPrevistaEntrega = LocalDate.now().plusDays(3);
			return;
		}
	}
}
