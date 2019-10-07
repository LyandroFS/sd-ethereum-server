package br.edu.ifba.web3j.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import br.edu.ifba.web3j.pojo.DadosMedico;
import br.edu.ifba.web3j.service.DadosMedicoService;

@RestController
public class DadosMedicoController {

	@Autowired
	private DadosMedicoService dadosMedicoService;
	
	@CrossOrigin
	@GetMapping("/dados-medico-list")
	public List<DadosMedico> loadDadosMedicos() throws Exception {
		return dadosMedicoService.loadDadosMedicos();	
	}
	
	@GetMapping("/dados-medico-list/{doenca}")
	public List<DadosMedico> loadDadosMedicosByDoenca(@PathVariable("doenca") String doenca) throws Exception {
		return dadosMedicoService.loadDadosMedicos(doenca);	
	}
	
	@CrossOrigin
	@RequestMapping(value = "/criar-dados-medico", method = { RequestMethod.GET, RequestMethod.POST })
    public String authenticateUserByCpfMailCn(
    		@RequestParam(value = "doenca", required = true) String doenca,
    		@RequestParam(value = "dataNotificacao", required = true) String dataNotificacao,
    		@RequestParam(value = "localidade", required = true) String localidade,
    		@RequestParam(value = "idade", required = true) String idade,
    		@RequestParam(value = "sexo", required = true) String sexo
    		) throws Exception{
		
			TransactionReceipt transactionReceipt = dadosMedicoService.salvarDadosMedico(doenca, dataNotificacao, localidade, idade, sexo);
			return transactionReceipt.getTransactionHash();
	}
	
	@GetMapping("/total-registros")
	public BigInteger totalRegistros() throws Exception {
		return dadosMedicoService.totalRegistro();	
	}
}