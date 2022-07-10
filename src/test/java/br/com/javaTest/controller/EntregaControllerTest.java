package br.com.javaTest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.javaTest.DTO.EntregaDTO;
import br.com.javaTest.model.EntregaEntity;
import br.com.javaTest.repository.EntregaRepository;
import br.com.javaTest.service.CalculaFreteService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * Classe de teste para o controller EntregaController
 * 
 * @author Danillo Santiago
 * @since jul 2022
 */
@WebMvcTest(EntregaController.class)
public class EntregaControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private EntregaController entregaController;

	@MockBean
	private CalculaFreteService calculaFreteService;

	@MockBean
	private EntregaRepository entregaRepository;

	@Autowired
	private WebApplicationContext applicationContext;

	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.entregaController);
		this.mockMvc = webAppContextSetup(applicationContext).build();
	}

	/**
	 * Teste unitário do endpoint calcularFrete Caso tenha sucesso retorna status
	 * code 200 e um objeto da classe EntregaDTO
	 * 
	 * @throws Exception
	 */
	@Test
	public void deveRetornarSucesso_QuandoCalcularFrete() throws Exception {
		MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
				MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

		EntregaEntity entregaEntity = new EntregaEntity();
		entregaEntity.setCepOrigem("05398120");
		entregaEntity.setCepDestino("07262130");
		entregaEntity.setNomeDestinario("Felipe Silveira");
		entregaEntity.setPeso(1600.00);

		EntregaDTO entregaDTO = new EntregaDTO();
		entregaDTO.setVlTotalFrete("1.600,00");
		entregaDTO.setCepDestino("22061030");
		entregaDTO.setCepOrigem("05398120");
		entregaDTO.setDataPrevistaEntrega(LocalDate.of(2022, 07, 20));

		Mockito.when(this.calculaFreteService.calculaPrecoFrete(entregaEntity)).thenReturn(entregaDTO);

		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

		ObjectWriter objectWriter = mapper.writer().withDefaultPrettyPrinter();

		String requestJson = objectWriter.writeValueAsString(entregaEntity);

		mockMvc.perform(post("/entrega/calcularFrete").contentType(APPLICATION_JSON_UTF8).content(requestJson))
				.andExpect(status().isOk());
	}
}
