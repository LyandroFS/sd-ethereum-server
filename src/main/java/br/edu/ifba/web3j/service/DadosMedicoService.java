package br.edu.ifba.web3j.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.gas.DefaultGasProvider;

import br.edu.ifba.web3j.beans.DadosMedicoBeans;
import br.edu.ifba.web3j.pojo.DadosMedico;

@Service
public class DadosMedicoService {
	
	Web3j web3 = Web3j.build(new HttpService("URL Client"));
	Credentials credentials = Credentials.create("KEY");
	private String enderecoContrato = "End Contract";
	
	public List<DadosMedico> loadDadosMedicos(String doenca) throws Exception{

		List<DadosMedico> list = new ArrayList<DadosMedico>();
		
		DadosMedicoBeans contract = DadosMedicoBeans.load(enderecoContrato, web3, credentials,  DefaultGasProvider.GAS_PRICE,DefaultGasProvider.GAS_LIMIT);
		
		
		RemoteFunctionCall<BigInteger> total = contract.taskCount();
		BigInteger t = total.send();
		
		RemoteFunctionCall<List> keys = contract.getKeys();
		List<BigInteger> keyList = keys.send();
		
		//RemoteFunctionCall<Tuple6<BigInteger, String, String, String, String, String>> tuple = null;
		Tuple6<BigInteger, String, String, String, String, String>	tuple6 = null;
		for (BigInteger id : keyList) {
			tuple6 = contract.dados(id).send();
			
			if(tuple6.component2().equals(doenca)) {
				
			/*	System.out.println("===========================================");
				System.out.println(tuple6.component1());
				System.out.println(tuple6.component2());
				System.out.println(tuple6.component3());
				System.out.println(tuple6.component4());
				System.out.println(tuple6.component5());
				System.out.println(tuple6.component6());
				System.out.println("");	*/
				list.add(new DadosMedico(tuple6.component1(), tuple6.component2(), tuple6.component3(), tuple6.component4(), tuple6.component5(), tuple6.component6()));
			}
		}
		web3.shutdown();
		return list;
	}
		
	public List<DadosMedico> loadDadosMedicos() throws Exception{

		List<DadosMedico> list = new ArrayList<DadosMedico>();
		
		DadosMedicoBeans contract = DadosMedicoBeans.load(enderecoContrato, web3, credentials,  DefaultGasProvider.GAS_PRICE,DefaultGasProvider.GAS_LIMIT);
		
		
		RemoteFunctionCall<BigInteger> total = contract.taskCount();
		BigInteger t = total.send();
		
		
		RemoteFunctionCall<List> keys = contract.getKeys();
		List<BigInteger> keyList = keys.send();
		
		//RemoteFunctionCall<Tuple6<BigInteger, String, String, String, String, String>> tuple = null;
		Tuple6<BigInteger, String, String, String, String, String>	tuple6 = null;
		for (BigInteger id : keyList) {
			tuple6 = contract.dados(id).send();
			list.add(new DadosMedico(tuple6.component1(),tuple6.component2(), tuple6.component3(), tuple6.component4(), tuple6.component5(), tuple6.component6()));
		}
		web3.shutdown();
		return list;
	}
	
	public TransactionReceipt salvarDadosMedico(String doenca, String dataNotificacao, String localidade, String idade, String sexo) throws Exception {
		DadosMedicoBeans contract = DadosMedicoBeans.load(enderecoContrato, web3, credentials,  DefaultGasProvider.GAS_PRICE,DefaultGasProvider.GAS_LIMIT);
		TransactionReceipt transactionReceipt = contract.salvarDadosMedico(doenca, dataNotificacao, localidade,idade,sexo).send();
		web3.shutdown();
		return transactionReceipt;
	}
	
	public BigInteger totalRegistro() throws Exception{
		DadosMedicoBeans contract = DadosMedicoBeans.load(enderecoContrato, web3, credentials,  DefaultGasProvider.GAS_PRICE,DefaultGasProvider.GAS_LIMIT);
		RemoteFunctionCall<BigInteger> total = contract.taskCount();
		BigInteger t = total.send();
		web3.shutdown();
		return t;
	}
}