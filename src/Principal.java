import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 - Inserir todos os funcionários, na mesma ordem e informações da tabela
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 - Remover o funcionário “João” da lista.
        funcionarios.remove(1);

        // 3.3 - Imprimir todos os funcionários com todas suas informações
        listarFuncionarios(funcionarios);

        // 3.4 - Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        for (Funcionario funcionario : funcionarios) {
            ajustaSalario(funcionario);
        }

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionariosMap = new HashMap<>();
        for (Funcionario funcionario : funcionarios) {
            if (!funcionariosMap.containsKey(funcionario.getFuncao())) {
                List<Funcionario> funcionarioList = new ArrayList<>();
                funcionarioList.add(funcionario);
                funcionariosMap.put(funcionario.getFuncao(), funcionarioList);
            } else {
                funcionariosMap.get(funcionario.getFuncao()).add(funcionario);
            }
        }

        // 3.6 - Imprimir os funcionários, agrupados por função.
        System.out.println("======== FUNCONÁRIOS POR FUNÇÃO ========");
        for (Map.Entry<String, List<Funcionario>> entry : funcionariosMap.entrySet()) {
            String funcao = entry.getKey();
            List<Funcionario> funcionariosList = entry.getValue();
            System.out.println("Função: " + funcao);
            System.out.println("Funcionários: " + funcionariosList);
            System.out.println("=============================");
        }

        // 3.8 - Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("======== ANIVERSÁRIO NO MÊS 10 OU NO MÊS 12 ========");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDataNascimento().getMonth().getValue() == 10 || funcionario.getDataNascimento().getMonth().getValue() == 12) {
                System.out.println(funcionario);
            }
        }

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println("======== FUNCIONÁRIO DE MAIOR IDADE ========");
        Collections.sort(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        System.out.println(funcionarios.get(0));

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        Collections.sort(funcionarios, (f1, f2) -> String.CASE_INSENSITIVE_ORDER.compare(f1.getNome(), f2.getNome()));
        System.out.println("======== ORDEM ALFABÉTICA ========");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
        // 3.11 – Imprimir o total dos salários dos funcionários.
        System.out.println("======== TOTAL DE SALÁRIOS ========");
        BigDecimal salarioTotal = new BigDecimal("0.0");
        for (Funcionario funcionario : funcionarios) {
            salarioTotal = salarioTotal.add(funcionario.getSalario());
        }
        System.out.println(salarioTotal);
        // 3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println("======== QUANTIDADE DE SALÁRIOS MÍNIMOS ========");
        for (Funcionario funcionario : funcionarios) {
          double qntdSalariosMin = funcionario.getSalario().doubleValue() / 1212.00;
            System.out.println(funcionario.getNome() + " : " + qntdSalariosMin + " salários mínimos.");
        }
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    private static void ajustaSalario(Funcionario funcionario) {
        BigDecimal salarioAtual = funcionario.getSalario();
        BigDecimal aumento = salarioAtual.multiply(new BigDecimal("0.1"));
        BigDecimal novoSalario = salarioAtual.add(aumento);
        funcionario.setSalario(novoSalario);
    }
}