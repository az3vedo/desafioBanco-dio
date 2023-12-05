package contas;

import lombok.Builder;
import lombok.Getter;


public class ContaPoupanca extends Conta {
	@Getter private ContaCorrente contaPrincipal;
	
	@Builder
	public ContaPoupanca(ContaCorrente contaPrincipal, int agencia, int numero, double saldo) {
		super(contaPrincipal.getProprietario(), agencia, numero, saldo);
		this.contaPrincipal = contaPrincipal;
	}
	
	@Override
	public void gerarExtrato() {
		System.out.println("=============Extrato Bancario=============");
		System.out.println("================Poupança==================");
		System.out.format("\t\tAg:%d No.:%d \n", this.getAgencia(), this.getNumero());
		System.out.println("==============Conta titular===============");
		System.out.format("\t\tAg:%d No.:%d \n", this.getContaPrincipal().getAgencia(), this.getContaPrincipal().getNumero());
		System.out.format("Cliente: %s \n", this.getProprietario().getNome());
		System.out.format("\t\s\s\s\sSaldo atual: %.2f\n", this.saldo);
		System.out.println("==========================================");
	}
}
