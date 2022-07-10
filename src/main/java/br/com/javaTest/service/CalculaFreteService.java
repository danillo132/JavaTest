package br.com.javaTest.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.javaTest.DTO.CepDTO;
import br.com.javaTest.DTO.EntregaDTO;
import br.com.javaTest.model.EntregaEntity;
import br.com.javaTest.repository.EntregaRepository;

/**
 * Classe de serviço que realiza o consumo de API externa com RestTemplate e implementa a regra de negócio
 * do cálculo do frete e do tempo de entrega
 * @author Danillo Santiago
 * @since jul 2022
 */
@Service
public class CalculaFreteService {

	/**
	 * Injeção de dependência do repositório
	 */
	@Autowired
	private EntregaRepository entregaRepository;

	/**
	 * Método responsável pelo consumo da API externa viaCep 
	 * @param cep do tipo String
	 * @return JSON contendo informações como cep, logradouro, complemento, bairro, localidade, uf, ibge,
	 *  gia, ddd e siafi
	 */
	public CepDTO encontrarCep(String cep) {
		return new RestTemplate().getForEntity("https://viacep.com.br/ws/" + cep + "/json/", CepDTO.class).getBody();
	}

	/**
	 * Método responsável pelo cálculo do frete e do tempo de entrega
	 * @param Objeto da classe EntregaEntity
	 * @return um DTO da classe EntregaDTO contendo o valor total do frete, cep de origem, cep de destino e
	 * data prevista de entrega
	 */
	public EntregaDTO calculaPrecoFrete(EntregaEntity entregaEntity) {
		LocalDate dataAtual = LocalDate.now();
		LocalDate entregaUmdia = dataAtual.plusDays(1);
		LocalDate entregaTresDias = dataAtual.plusDays(3);
		LocalDate entregaDezDias = dataAtual.plusDays(10);
		
		Double descontoCinquentaPorCento = entregaEntity.getPeso() - (entregaEntity.getPeso() * 0.5);
		Double descontoSetentaPorCento = entregaEntity.getPeso() - (entregaEntity.getPeso() * 0.75);

		CepDTO cepOrigem = encontrarCep(entregaEntity.getCepOrigem());
		CepDTO cepDestino = encontrarCep(entregaEntity.getCepDestino());

		if (cepOrigem.getDdd().equalsIgnoreCase(cepDestino.getDdd())) {
			entregaEntity.setVlTotalFrete(descontoCinquentaPorCento);
			entregaEntity.setDataConsulta(dataAtual);
			entregaEntity.setDataPrevistaEntrega(entregaUmdia);
		} else if (cepOrigem.getUf().equalsIgnoreCase(cepDestino.getUf())) {
			entregaEntity.setVlTotalFrete(descontoSetentaPorCento);
			entregaEntity.setDataConsulta(dataAtual);
			entregaEntity.setDataPrevistaEntrega(entregaTresDias);
		} else {
			entregaEntity.setVlTotalFrete(entregaEntity.getPeso());
			entregaEntity.setDataConsulta(dataAtual);
			entregaEntity.setDataPrevistaEntrega(entregaDezDias);
		}

		EntregaEntity entregaEntitySaved = entregaRepository.save(entregaEntity);

		return new EntregaDTO(entregaEntitySaved);
	}
}
