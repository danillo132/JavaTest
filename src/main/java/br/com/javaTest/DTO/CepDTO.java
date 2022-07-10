package br.com.javaTest.DTO;

import java.io.Serializable;

/**
 * Classe CepDTO responsável pela transfêrencia de dados do objeto de maneira
 * segura e eficiente
 * 
 * @author Danillo Santiago
 * @since jul 2022
 */
public class CepDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo de cep do tipo String
	 */
	private String cep;

	/**
	 * Atributo de logradouro do tipo String
	 */
	private String logradouro;

	/**
	 * Atributo de complemento do tipo String
	 */
	private String complemento;

	/**
	 * Atributo de bairro do tipo String
	 */
	private String bairro;

	/**
	 * Atributo de localidade do tipo String
	 */
	private String localidade;

	/**
	 * Atributo de UF do tipo String
	 */
	private String uf;

	/**
	 * Atributo iBGE do tipo String
	 */
	private String ibge;

	/**
	 * Atributo GIA do tipo String
	 */
	private String gia;

	/**
	 * Atributo DDD do tipo String
	 */
	private String ddd;

	/**
	 * Atributo SIAFI do tipo String
	 */
	private String siafi;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

}
