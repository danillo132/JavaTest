package br.com.javaTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaTest.DTO.EntregaDTO;
import br.com.javaTest.model.EntregaEntity;
import br.com.javaTest.service.CalculaFreteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller responsável pelo end point da classe EntregaEntity
 * @author Danillo Santiago
 * @since jul 2022
 */
@RestController
@RequestMapping(value = "/entrega")
@Api(value = "API REST para calcular entrega e frete")
@CrossOrigin(origins = "*")
public class EntregaController {

	/**
	 * Injeção de dependência do serviço
	 */
	@Autowired
	private CalculaFreteService calculaFreteService;

	/**
	 * Endpoint responsável pelo cálculo do preço da entrega e do frete
	 * @param Objeto da classe EntregaEntity
	 * @return objeto da classe EntregaDTO e Status Code 200
	 */
	@PostMapping(value = "/calcularFrete")
	@ApiOperation(value = "Endpoint responsável pelo cálculo do preço e da entrega do frete, este método retorna "
			+ "um DTO da classe entrega com os atributos: Valor total do frete, CEP de origem, CEP de destino e data prevista de entrega")
	public ResponseEntity<EntregaDTO> calcularFrete(@RequestBody EntregaEntity entregaEntity) {

		EntregaDTO entregaDTO = calculaFreteService.calculaPrecoFrete(entregaEntity);

		return new ResponseEntity<EntregaDTO>(entregaDTO, HttpStatus.OK);
	}
}
