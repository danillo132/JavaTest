package br.com.javaTest.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Classe de persistência que representa a entrega a ser realizada
 * 
 * @author Danillo Santiago
 * @since jul 2022
 *
 */
@Entity
public class EntregaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo de identificação da entrega do tipo Long
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Atributo de peso da entrega do tipo Double
	 */
	private Double peso;

	/**
	 * Atributo de cep de origem da entrega do tipo String
	 */
	private String cepOrigem;

	/**
	 * Atributo de cep de destino da entrega do tipo String
	 */
	private String cepDestino;

	/**
	 * Atributo de nome do destinatário do tipo String
	 */
	private String nomeDestinario;

	/**
	 * Atributo do valor total do frete do tipo Double
	 */
	private Double vlTotalFrete;

	/**
	 * Atributo de data prevista de entrega do tipo LocalDate
	 */
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private LocalDate dataPrevistaEntrega;

	/**
	 * Atributo de data da cotação do tipo LocalDate
	 */
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(iso = ISO.DATE, pattern = "dd/MM/yyyy")
	private LocalDate dataConsulta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getPeso() {
		return peso;
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

	public String getNomeDestinario() {
		return nomeDestinario;
	}

	public void setNomeDestinario(String nomeDestinario) {
		this.nomeDestinario = nomeDestinario;
	}

	public Double getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(Double vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

}
