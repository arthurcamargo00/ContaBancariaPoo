
public class ContaBancaria {
    private String numero;
    private String titular;
    private String cpf;
    private String agencia;
    private String tipoConta;
    private double saldo;
    private String situacao;

    public ContaBancaria(String numero, String titular, String cpf, String agencia, String tipoConta) {
        this.numero = numero;
        this.titular = titular;
        this.cpf = cpf;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
        this.saldo = 0.0; 
        this.situacao = "Ativa"; 
    }

   
    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getSituacao() {
        return situacao;
    }

    
    public void exibirDados() {
        System.out.println("------------------------------");
        System.out.println("Banco Horizonte");
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular);
        System.out.println("CPF: " + this.cpf);
        System.out.println("Agência: " + this.agencia);
        System.out.println("Tipo: " + this.tipoConta);
        System.out.printf("Saldo: R$ %.2f\n", this.saldo);
        System.out.println("Situação: " + this.situacao);
        System.out.println("------------------------------");
    }

   
    public boolean depositar(double valor) {
        if (this.situacao.equalsIgnoreCase("Bloqueada")) {
            System.out.println("[FALHA] Não é possível depositar: A conta " + this.numero + " está BLOQUEADA.");
            return false;
        }
        if (valor <= 0) {
            System.out.println("[FALHA] O valor do depósito deve ser maior que zero.");
            return false;
        }
        this.saldo += valor;
        System.out.printf("[SUCESSO] Depósito de R$ %.2f realizado na conta %s. Novo saldo: R$ %.2f\n", valor, this.numero, this.saldo);
        return true;
    }

   
    public boolean sacar(double valor) {
        if (this.situacao.equalsIgnoreCase("Bloqueada")) {
            System.out.println("[FALHA] Operação recusada: A conta " + this.numero + " está BLOQUEADA.");
            return false;
        }
        if (valor <= 0) {
            System.out.println("[FALHA] O valor do saque deve ser maior que zero.");
            return false;
        }
        if (valor > this.saldo) {
            System.out.printf("[FALHA] Saque recusado na conta %s: Saldo insuficiente (Saldo atual: R$ %.2f).\n", this.numero, this.saldo);
            return false;
        }
        this.saldo -= valor;
        System.out.printf("[SUCESSO] Saque de R$ %.2f realizado na conta %s. Novo saldo: R$ %.2f\n", valor, this.numero, this.saldo);
        return true;
    }

    
    public double consultarSaldo() {
        System.out.printf("[CONSULTA] Conta %s (%s) | Saldo Atual: R$ %.2f\n", this.numero, this.titular, this.saldo);
        return this.saldo;
    }

    
    public boolean alterarTitular(String novoNome) {
        if (novoNome == null || novoNome.trim().isEmpty()) {
            System.out.println("[FALHA] Alteração não realizada: O novo nome do titular não pode estar vazio.");
            return false;
        }
        String nomeAntigo = this.titular;
        this.titular = novoNome.trim();
        System.out.println("[SUCESSO] Titular da conta " + this.numero + " alterado de '" + nomeAntigo + "' para '" + this.titular + "'.");
        return true;
    }

    
    public void bloquearConta() {
        this.situacao = "Bloqueada";
        System.out.println("[INFO] A conta " + this.numero + " de " + this.titular + " foi BLOQUEADA.");
    }

    
    public void desbloquearConta() {
        this.situacao = "Ativa";
        System.out.println("[INFO] A conta " + this.numero + " de " + this.titular + " foi DESBLOQUEADA.");
    }

    
    public boolean transferir(double valor, ContaBancaria contaDestino) {
        if (this.situacao.equalsIgnoreCase("Bloqueada")) {
            System.out.println("[FALHA] Transferência não realizada: A conta de origem (" + this.numero + ") está BLOQUEADA.");
            return false;
        }
        if (contaDestino.getSituacao().equalsIgnoreCase("Bloqueada")) {
            System.out.println("[FALHA] Transferência não realizada: A conta de destino (" + contaDestino.getNumero() + ") está BLOQUEADA.");
            return false;
        }
        if (valor <= 0) {
            System.out.println("[FALHA] O valor da transferência deve ser maior que zero.");
            return false;
        }
        if (valor > this.saldo) {
            System.out.printf("[FALHA] Transferência recusada: A conta %s não possui saldo suficiente (R$ %.2f).\n", this.numero, this.saldo);
            return false;
        }

        
        this.saldo -= valor;
        contaDestino.saldo += valor;
        System.out.printf("[SUCESSO] Transferência de R$ %.2f da conta %s para a conta %s realizada com sucesso!\n", valor, this.numero, contaDestino.getNumero());
        return true;
    }

    public void emitirRelatorio() {
        System.out.printf("RELATÓRIO DA CONTA | Nº: %-5s | Titular: %-18s | Agência: %-8s | Tipo: %-8s | Saldo: R$ %7.2f | Status: %s\n",
                this.numero, this.titular, this.agencia, this.tipoConta, this.saldo, this.situacao);
    }
}