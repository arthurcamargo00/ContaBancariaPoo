

public class Main {
    public static void main(String[] args) {
        System.out.println("      BANCO HORIZONTE - BATERIA DE TESTES DO SISTEMA ");

        ContaBancaria conta1 = new ContaBancaria("1001", "Ana Souza", "123.456.789-00", "Centro", "Corrente");
        ContaBancaria conta2 = new ContaBancaria("1002", "Carlos Oliveira", "234.567.890-11", "Centro", "Poupança");
        ContaBancaria conta3 = new ContaBancaria("1003", "Mariana Lima", "345.678.901-22", "Norte", "Corrente");

        System.out.println("--- CHECKLIST DE TESTES (ETAPA 11) ---\n");

        System.out.println("Teste 1: Verificar saldo inicial igual a zero");
        conta1.consultarSaldo();
        System.out.println();

        System.out.println("Teste 2: Depositar R$ 500,00 na conta 1001");
        conta1.depositar(500.00);
        System.out.println();

        System.out.println("Teste 3: Sacar R$ 100,00 da conta 1001");
        conta1.sacar(100.00);
        System.out.println();

        System.out.println("Teste 4: Tentar depositar R$ 0,00");
        conta1.depositar(0.00);
        System.out.println();

        System.out.println("Teste 5: Tentar sacar R$ 1000,00 (acima do saldo de R$ 400,00)");
        conta1.sacar(1000.00);
        System.out.println();

        System.out.println("Teste 6: Alterar nome do titular da conta 1001");
        conta1.alterarTitular("Ana Souza Silva");
        System.out.println();

        System.out.println("Teste 7: Bloquear conta 1001 e tentar realizar saque de R$ 50,00");
        conta1.bloquearConta();
        conta1.sacar(50.00);
        System.out.println();

        System.out.println("Teste 8: Consultar saldo da conta bloqueada");
        conta1.consultarSaldo();
        System.out.println();

        System.out.println("Teste 9: Desbloquear conta 1001 e depositar R$ 200,00");
        conta1.desbloquearConta();
        conta1.depositar(200.00);
        System.out.println();

        System.out.println("Teste 10: Transferir R$ 150,00 da conta 1001 (Ana) para a conta 1002 (Carlos)");
        conta1.transferir(150.00, conta2);
        System.out.println();

        System.out.println("Teste 11: Tentar transferir R$ 2000,00 da conta 1001 para a conta 1003");
        conta1.transferir(2000.00, conta3);
        System.out.println();

        System.out.println("Teste 12: Relatório final de todas as contas do sistema\n");
        conta1.emitirRelatorio();
        conta2.emitirRelatorio();
        conta3.emitirRelatorio();
    }
}