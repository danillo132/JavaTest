package br.com.javaTest.DTO;

import java.text.DecimalFormat;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.javaTest.model.EntregaEntity;

/**
 * Classe EntregaDTO responsável pela transfêrencia de dados do objeto de
 * maneira segura e eficiente
 * 
 * @author Danillo Santiago
 * @since jul 2022
 */
public class EntregaDTO {

	/**
	 * Atributo do valor total do frete do tipo String
	 */
	private String vlTotalFrete;

	/**
	 * Atributo de cep de origem da entrega do tipo String
	 */
	private String cepOrigem;

	/**
	 * Atributo de cep de destino da entrega do tipo String
	 */
	private String cepDestino;

	/**
	 * Atributo de data prevista de entrega do tipo LocalDate
	 */
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPrevistaEntrega;

	/**
	 * Método construtor responsável pela transferência entre a classe de
	 * persistência e o DTO
	 * 
	 * @param Objeto da classe EntregaEntity
	 */
	public EntregaDTO(EntregaEntity entregaEntity) {
		this.vlTotalFrete = new DecimalFormat("#,##0.00").format(entregaEntity.getVlTotalFrete());
		this.cepOrigem = entregaEntity.getCepOrigem();
		this.cepDestino = entregaEntity.getCepDestino();
		this.dataPrevistaEntrega = entregaEntity.getDataPrevistaEntrega();
	}
	
	public EntregaDTO() {
		
	}

	public String getVlTotalFrete() {
		return vlTotalFrete;
	}

	public void setVlTotalFrete(String vlTotalFrete) {
		this.vlTotalFrete = vlTotalFrete;
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

	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}

	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}

}
