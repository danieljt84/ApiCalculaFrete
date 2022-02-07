package br.com.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.controller.form.EnderecoForm;

@Service
public class EnderecoService {

	public EnderecoForm buscaEnderecoPorCep(String cep) {
		RestTemplate template = new RestTemplate();
		return template.getForObject("https://viacep.com.br/ws/{cep}/json", EnderecoForm.class, cep);
	}

}
