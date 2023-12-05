package contas;
import clientes.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public abstract class Conta implements IConta {
	private final Cliente proprietario;
	private final int agencia;
	private final int numero;
	@Setter protected double saldo;
	 
	@Override
	public void sacar(double valor) {
		if (this.getSaldo() >= valor) {
			this.setSaldo( this.getSaldo()-valor );
		}
	}
	
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	@Override
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	@Override
	public void gerarExtrato() {
		System.out.println("=============Extrato Bancario=============");
		System.out.format("\t\tAg:%d No.:%d \n", this.agencia, this.numero);
		System.out.format("Cliente: %s \n", this.proprietario.getNome());
		System.out.format("\t\s\s\s\sSaldo atual: %.2f\n", this.saldo);
		System.out.println("==========================================");
	}
}
