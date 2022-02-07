package br.com.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.stereotype.Service;

import br.com.controller.dto.FreteDTO;
import br.com.controller.form.EnderecoForm;
import br.com.controller.form.FreteForm;
import br.com.model.Frete;
import br.com.repository.FreteRepository;

@Service
public class FreteService {
	@Autowired
    ModelMapper modelMapper;
	@Autowired
	FreteRepository freteRepository;
	@Autowired
	EnderecoService enderecoService;
	
	
	public FreteDTO cadastrar(FreteForm freteForm) {
		FreteDTO freteDTO = new FreteDTO();
		EnderecoForm enderecoOrigemForm = enderecoService.buscaEnderecoPorCep(freteForm.getCepOrigem());
		EnderecoForm enderecoDestinoForm = enderecoService.buscaEnderecoPorCep(freteForm.getCepDestino());
		Frete frete = freteForm.converteParaEntidade(modelMapper);
		frete.calculaFrete(enderecoOrigemForm.converteParaEntidade(modelMapper),enderecoDestinoForm.converteParaEntidade(modelMapper));		
		frete = freteRepository.save(frete);
		return freteDTO.converteParaDto(frete,modelMapper);
	}
}
