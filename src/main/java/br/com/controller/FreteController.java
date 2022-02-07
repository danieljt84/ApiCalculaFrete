package br.com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controller.dto.FreteDTO;
import br.com.controller.form.FreteForm;
import br.com.service.FreteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/frete")
@Api(value = "Frete")
public class FreteController {
	
	@Autowired
	FreteService service;
	
	@PostMapping
	@ApiOperation(value = "Cadastra os dados do frete e retorna o objeto detalhado")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um objeto do tipo frete com detalhamento"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	public ResponseEntity<FreteDTO> cadastrar(@RequestBody@Valid FreteForm form) {
		try {
			FreteDTO dto = service.cadastrar(form);
			return ResponseEntity.ok(dto);
		}catch (Exception e) {
		    return ResponseEntity.badRequest().build();
		}
	}
	
	//Função que captura o erro(s) e retorna com a mensagem sobre o mesmo
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}

}
