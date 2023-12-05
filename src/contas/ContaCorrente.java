package contas;

import clientes.Cliente;
import lombok.Builder;


public class ContaCorrente extends Conta {
	
	@Builder
	public ContaCorrente(Cliente cliente, int agencia, int numero, double saldo) {
		super(cliente, agencia, numero, saldo);
	}
}
