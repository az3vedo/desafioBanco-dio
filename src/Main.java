import contas.FactoryContas;
import exceptions.InsufficientFundsError;
import clientes.Cliente;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class Main {
	public static void main(String[] args) throws Exception {
		
		Cliente cli = new Cliente("Gabriel");
		
		ContaCorrente novaConta = FactoryContas.novaContaCorrente(cli, 1, 1);
		novaConta.gerarExtrato();
		
		novaConta.depositar(1800);
		novaConta.gerarExtrato();
		novaConta.sacar(600);
		novaConta.gerarExtrato();
		
		try {
			ContaPoupanca poupanca = FactoryContas.novaContaPoupanca(novaConta, 1, 2, 300);
			poupanca.gerarExtrato();
//			System.out.println(poupanca.getContaPrincipal().getSaldo());
		} catch (InsufficientFundsError e) {
			System.out.println("Erro: Conta Poupança necessita de um depósito inicial");
		}
		
		
	}
}
