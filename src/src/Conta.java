public abstract class Conta implements IConta {

    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 100;

    protected int agencia;
    protected int numero;
    protected double saldo;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    protected void imprimirInfos() {
        System.out.println(String.format("Agencia: " + this.agencia));
        System.out.println(String.format("Conta: " + this.numero));
        System.out.println(String.format("Saldo: %.2f" + this.saldo));
    }


    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }
}
