package br.edu.ifba.web3j.beans;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.5.
 */
@SuppressWarnings("rawtypes")
public class DadosMedicoBeans extends Contract {
    private static final String BINARY = "60806040526000805534801561001457600080fd5b50610acd806100246000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80630d3466f0146100515780632150c51814610285578063b6cb58a5146102dd578063d64377bc146102f7575b600080fd5b61006e6004803603602081101561006757600080fd5b50356105b1565b60405180878152602001806020018060200180602001806020018060200186810386528b818151815260200191508051906020019080838360005b838110156100c15781810151838201526020016100a9565b50505050905090810190601f1680156100ee5780820380516001836020036101000a031916815260200191505b5086810385528a5181528a516020918201918c019080838360005b83811015610121578181015183820152602001610109565b50505050905090810190601f16801561014e5780820380516001836020036101000a031916815260200191505b5086810384528951815289516020918201918b019080838360005b83811015610181578181015183820152602001610169565b50505050905090810190601f1680156101ae5780820380516001836020036101000a031916815260200191505b5086810383528851815288516020918201918a019080838360005b838110156101e15781810151838201526020016101c9565b50505050905090810190601f16801561020e5780820380516001836020036101000a031916815260200191505b50868103825287518152875160209182019189019080838360005b83811015610241578181015183820152602001610229565b50505050905090810190601f16801561026e5780820380516001836020036101000a031916815260200191505b509b50505050505050505050505060405180910390f35b61028d610898565b60408051602080825283518183015283519192839290830191858101910280838360005b838110156102c95781810151838201526020016102b1565b505050509050019250505060405180910390f35b6102e56108f1565b60408051918252519081900360200190f35b6105af600480360360a081101561030d57600080fd5b810190602081018135600160201b81111561032757600080fd5b82018360208201111561033957600080fd5b803590602001918460018302840111600160201b8311171561035a57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156103ac57600080fd5b8201836020820111156103be57600080fd5b803590602001918460018302840111600160201b831117156103df57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561043157600080fd5b82018360208201111561044357600080fd5b803590602001918460018302840111600160201b8311171561046457600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b8111156104b657600080fd5b8201836020820111156104c857600080fd5b803590602001918460018302840111600160201b831117156104e957600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295949360208101935035915050600160201b81111561053b57600080fd5b82018360208201111561054d57600080fd5b803590602001918460018302840111600160201b8311171561056e57600080fd5b91908080601f0160208091040260200160405190810160405280939291908181526020018383808284376000920191909152509295506108f7945050505050565b005b60026020818152600092835260409283902080546001808301805487519281161561010002600019011695909504601f810185900485028201850190965285815290949193909290919083018282801561064c5780601f106106215761010080835404028352916020019161064c565b820191906000526020600020905b81548152906001019060200180831161062f57829003601f168201915b50505060028085018054604080516020601f60001961010060018716150201909416959095049283018590048502810185019091528181529596959450909250908301828280156106de5780601f106106b3576101008083540402835291602001916106de565b820191906000526020600020905b8154815290600101906020018083116106c157829003601f168201915b5050505060038301805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815294959493509083018282801561076e5780601f106107435761010080835404028352916020019161076e565b820191906000526020600020905b81548152906001019060200180831161075157829003601f168201915b5050505060048301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156107fe5780601f106107d3576101008083540402835291602001916107fe565b820191906000526020600020905b8154815290600101906020018083116107e157829003601f168201915b5050505060058301805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815294959493509083018282801561088e5780601f106108635761010080835404028352916020019161088e565b820191906000526020600020905b81548152906001019060200180831161087157829003601f168201915b5050505050905086565b606060018054806020026020016040519081016040528092919081815260200182805480156108e657602002820191906000526020600020905b8154815260200190600101908083116108d2575b505050505090505b90565b60005481565b600080546001908101808355815480830183557fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf6018190556040805160c08101825282815260208181018b81528284018b9052606083018a90526080830189905260a0830188905293865260028152919094208451815591518051929361098693908501929190910190610a00565b50604082015180516109a2916002840191602090910190610a00565b50606082015180516109be916003840191602090910190610a00565b50608082015180516109da916004840191602090910190610a00565b5060a082015180516109f6916005840191602090910190610a00565b5050505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610a4157805160ff1916838001178555610a6e565b82800160010185558215610a6e579182015b82811115610a6e578251825591602001919060010190610a53565b50610a7a929150610a7e565b5090565b6108ee91905b80821115610a7a5760008155600101610a8456fea265627a7a72315820ed63f5276c75bc1c2a1a8fc06c39b3ddf71ddbfd93adf2121dc4d4a0f0a6237764736f6c634300050b0032";

    public static final String FUNC_DADOS = "dados";

    public static final String FUNC_GETKEYS = "getKeys";

    public static final String FUNC_TASKCOUNT = "taskCount";

    public static final String FUNC_SALVARDADOSMEDICO = "salvarDadosMedico";

    @Deprecated
    protected DadosMedicoBeans(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DadosMedicoBeans(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected DadosMedicoBeans(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected DadosMedicoBeans(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple6<BigInteger, String, String, String, String, String>> dados(BigInteger param0) {
        final Function function = new Function(FUNC_DADOS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple6<BigInteger, String, String, String, String, String>>(function,
                new Callable<Tuple6<BigInteger, String, String, String, String, String>>() {
                    @Override
                    public Tuple6<BigInteger, String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<BigInteger, String, String, String, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue());
                    }
                });
    }

    public RemoteFunctionCall<List> getKeys() {
        final Function function = new Function(FUNC_GETKEYS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> taskCount() {
        final Function function = new Function(FUNC_TASKCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> salvarDadosMedico(String _doenca, String _dataNotificacao, String _localidade, String _idade, String _sexo) {
        final Function function = new Function(
                FUNC_SALVARDADOSMEDICO, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_doenca), 
                new org.web3j.abi.datatypes.Utf8String(_dataNotificacao), 
                new org.web3j.abi.datatypes.Utf8String(_localidade), 
                new org.web3j.abi.datatypes.Utf8String(_idade), 
                new org.web3j.abi.datatypes.Utf8String(_sexo)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static DadosMedicoBeans load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DadosMedicoBeans(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static DadosMedicoBeans load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DadosMedicoBeans(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static DadosMedicoBeans load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new DadosMedicoBeans(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static DadosMedicoBeans load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new DadosMedicoBeans(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<DadosMedicoBeans> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DadosMedicoBeans.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DadosMedicoBeans> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DadosMedicoBeans.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<DadosMedicoBeans> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(DadosMedicoBeans.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<DadosMedicoBeans> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(DadosMedicoBeans.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
