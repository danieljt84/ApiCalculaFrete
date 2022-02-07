package br.com.controller.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import br.com.model.Frete;

public class FreteForm {
	@NotBlank@Length(max = 50, min = 10)@Pattern(regexp="^[a-zA-Z\\s]*$",message = "Somente letras")
	private String nomeDestinatario;
	@NotBlank@Length(min = 8,max = 8)
	@Pattern(regexp="^[0-9]*$",message = "Somente dígitos")
	private String cepOrigem;
	@NotBlank@Length(min = 8,max = 8)
	@Pattern(regexp="^[0-9]*$",message = "Somente dígitos")
	private String cepDestino;
	@NotNull@DecimalMin("0.001")
 	private double peso;
	
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public Frete converteParaEntidade(ModelMapper modelMapper){
	    Frete frete = modelMapper.map(this, Frete.class);
	    return frete;
	}
}
