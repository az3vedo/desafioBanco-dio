package contas;

import clientes.Cliente;
import exceptions.InsufficientFundsError;

public class FactoryContas {
	public static ContaCorrente novaContaCorrenteComSaldo(Cliente cliente, int agencia, int numero, double saldo) {
		/**
		 * Retorna um objeto ContaCorrente criada utilizando os parâmetros recebidos
		 * 
		 * @param 	agencia Número da agência responsável pela conta
		 * @param 	numero Número que a conta receberá como identificação
		 * @param	saldo Valor depositado para a abertura da conta
		 * @return 	Objeto ContaCorrente
		 * 
		 * @see ContaCorrente
		 */
		return new ContaCorrente(cliente, agencia, numero, saldo);
	}
	
	public static ContaCorrente novaContaCorrente(Cliente cliente, int agencia, int numero) {
		/**
		 * Retorna um objeto ContaCorrente criada utilizando os parâmetros recebidos
		 * 
		 * @param 	agencia Número da agência responsável pela conta
		 * @param 	numero Número que a conta receberá como identificação
		 * @return 	Objeto ContaCorrente
		 * 
		 * @see ContaCorrente
		 */
		return new ContaCorrente(cliente, agencia, numero, 0d);
	}
	
	public static ContaPoupanca novaContaPoupanca(ContaCorrente conta, int agencia, int numero, double saldo ) throws Exception {
		/**
		 * Retorna um objeto ContaPoupança criada utilizando os parâmetros recebidos
		 * 
		 * @param conta Objeto da conta corrente para a qual será criada a ContaPoupança
		 * @param 	agencia Número da agência responsável pela conta
		 * @param 	numero Número que a conta receberá como identificação
		 * @param	saldo Valor depositado para a abertura da conta
		 * @return 	Objeto ContaPoupança
		 * 
		 * @see ContaPoupança
		 */
		if (saldo <= 0.00) {
			throw new InsufficientFundsError();
		} else {
			return new ContaPoupanca(conta, agencia, numero, saldo);			
		}
	}
}
