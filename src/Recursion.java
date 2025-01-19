import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;

public class Recursion {

    /**
     * Attention! it's a notations. I does it with the intention to self notes, not for documentation.
     * <p>
     * O que é recursão?
     * <p>
     * É uma função que chama ela mesmo, que tem um base case(regra 1) e uma invocação
     * dela mesma (regra 2 e 3).
     * <p>
     * public void recurcao(int algumValor){
     * if (algum valor == 10){ //Base case (regra 1)
     * return;
     * }
     * return recurcao(algumValor + 1) //Recursive Call (regra 2 e 3)
     * }
     * <p>
     * O objetivo da recursão é pegar um problema e quebrar ele em pequenos pedaços e cada
     * pedaço se tornar ainda menor para cada laço da recursão.
     * <p>
     * De uma forma lúdica, uma recursão é similar ao ato de você escrever uma redação
     * entregar para o professor e o mesmo ler a sua obra e em seguida ele lhe devolve
     * alegando que precisa ser melhorado, em seguida você faz algumas alterações e entrega
     * para o professor, de novo e de novo, até ele aceitar o sua redação.
     * <p>
     * Diferença entre Recursão(recursion) com cauda(with tail) e sem Cauda(without tail).
     * <p>
     * A diferença entre recursão com cauda (tail recursion) e recursão sem cauda
     * (non-tail recursion) está no ponto onde a chamada recursiva é feita e como
     * a pilha de chamadas (stack) é utilizada durante a execução do programa.
     * <p>
     * Na recursão sem cauda {@code factorialWithoutTail}, a última operação realizada
     * na função não é a chamada recursiva, ou seja, a função precisa fazer algo com o
     * resultado da chamada recursiva após a execução dessa chamada. Ou seja, ela vem primeiro!
     * <p>
     * O estado da função precisa ser mantido até a chamada recursiva retornar um valor.
     * Isso pode fazer com que a pilha de chamadas cresça rapidamente, o que pode resultar em
     * overflow de pilha se a recursão for muito profunda.
     * <p>
     * Na recursão com cauda, a última operação realizada na função é a chamada recursiva,
     * ou seja, a função retorna imediatamente o valor da chamada recursiva, sem fazer nada
     * depois disso.
     * <p>
     * <p>
     * Pros e contra(cons) do uso de recursão:
     * <p>
     * Pros:
     * 1 - Elegância e complexidade.
     * 2 - Reduz a necessidade de loops complexos e estrutura de dados auxiliar.
     * 3 - Reduz a complexidade do tempo com memoization.
     * 4 - Funciona perfeitamente com estruturas de dados como Árvores e Grafos.
     * <p>
     * Cons:
     * 1 - Vagareza por conta do aquecimento da CPU
     * 2 - Pode gerar erros na memória / exceções de estouro de pilha.
     * 3 - Pode comprometer a legibilidade do código se implementada de qualquer maneira.
     */

    public static final int ONE = 1;
    public static final int ZERO = 0;

    /**
     * Factorial recursion without tail
     */
    static void factorialWithoutTail(double input, double acumulator) {
        if (input == ONE || input == ZERO) {  // Base case
            System.out.println("The factorial without tail is: " + acumulator);
            return;  // Encerra a recursão
        }

        // Caso recursivo: decrementa input e multiplica o acumulador pelo valor de input
        factorialWithoutTail(input - ONE, acumulator * input);
    }

    /**
     * Factorial recursion with tail
     */
    static long factorialWithTail(int input, long acumulator) {
        if (input == ONE || input == ZERO) {  // Base case
            return acumulator;  // Retorna o valor final do acumulador
        }

        // Caso recursivo: chama a função novamente com o valor de input decrementado e o acumulador multiplicado por input
        return factorialWithTail(input - ONE, acumulator * input);
    }

    /**
     * Way to optimize the Recursion.
     */
    public static class MemoizationExample {

        /**
         * Memoization é uma técnica de otimização usada em programação,
         * especialmente em algoritmos recursivos, para armazenar resultados
         * de cálculos anteriores e evitar recomputações desnecessárias de subproblemas
         * que já foram resolvidos. Essencialmente, a memoização é uma forma de cache de
         * resultados de funções, o que pode melhorar significativamente o desempenho,
         * especialmente em algoritmos que têm uma grande sobreposição de subproblemas,
         * como em problemas de programação dinâmica.
         * <p>
         * Como funciona a Memoização?
         * <p>
         * Armazenamento de Resultados:
         * Quando uma função é chamada com determinados parâmetros,
         * se o resultado dessa chamada já foi calculado anteriormente, a função simplesmente
         * retorna o valor armazenado (ao invés de recalcular o resultado). Isso é feito
         * normalmente em uma estrutura de dados como um dicionário (hash map) ou uma tabela.
         * <p>
         * Reutilização de Resultados:
         * Se o mesmo conjunto de parâmetros for passado para a função mais de uma vez, ao
         * invés de recalcular a resposta, a função recupera o valor diretamente da memória,
         * economizando tempo de execução.
         * <p>
         * Aumento de Eficiência:
         * A memoização é particularmente útil em algoritmos recursivos que têm muitos cálculos
         * repetidos, como o cálculo de números de Fibonacci ou problemas combinatórios, onde a
         * subestrutura ótima é reutilizada várias vezes.
         */

        // Mapa para armazenar os resultados dos métodos A, B e C
        private Map<String, String> memo = new HashMap<>();

        // Método A
        public String A() {
            //if (memo.containsKey("A")) {
            //    return memo.get("A");  // Retorna o valor armazenado
            //}
            String result = "hello " + B();
            memo.put("A", result);  // Armazena o resultado de A
            return memo.get("A");
            //return result;
        }

        // Método B
        public String B() {
            String result = "my " + C();
            memo.put("B", result);  // Armazena o resultado de B
            return memo.get("B");
        }

        // Método C
        public String C() {
            String result = "friends";
            memo.put("C", result);  // Armazena o resultado de C
            return memo.get("C");
        }
    }

    /**
     * Recursion with String
     */
    public String reverseString(String input) {
        //what is the base case? One letter or Empty String.
        if (input.equals("")) {
            return "";
        }
        // what is the smallest amount of work I can do in each iteration?
        return reverseString(input.substring(1)) + input.charAt(0);
        //reverseString shrinks the problem space. input.charAt(0) is a smallest unit of work to contribute.

        /*
         * First invoking the reverse string:
         *
         *   a
         *   n
         *   a
         *   n
         *   a
         *   b
         *
         * Doing Recursion:
         *
         * a
         * an
         * ana
         * anan
         * anana
         * ananab
         *
         * */
    }

    public static void main(String[] args) {
        MemoizationExample example = new MemoizationExample();
        Recursion stringReverse = new Recursion();

        // Declaração da variável para armazenar a entrada do usuário
        int userInput;

        // Solicita a entrada do usuário através de uma caixa de diálogo
        userInput = Integer.parseInt(JOptionPane.showInputDialog("Informe algum número para saber o fatorial: "));

        // Verifica se o número informado é negativo, pois fatorial não é definido para números negativos
        if (userInput < ZERO) {
            System.out.println("Valor inválido.");  // Informa que o valor é inválido
            return;  // Encerra o programa caso o valor seja negativo
        } else {
            // Chama a função recursiva sem cauda para calcular o fatorial
            factorialWithoutTail(userInput, ONE);
        }

        // Chama a função recursiva com cauda para calcular o fatorial e armazena o resultado
        long result = factorialWithTail(userInput, ONE);

        // Imprime o resultado do fatorial calculado pela função com cauda
        System.out.println("The factorial with tail of " + userInput + " is: " + result);

        // imprime a memoization
        System.out.println(example.C());  // friends
        System.out.println(example.B());  // my friends
        System.out.println(example.A());  // hello my friends

        String userStringInput = JOptionPane.showInputDialog("Digite uma string para inverter");
        if (userStringInput != null && !userStringInput.trim().isEmpty()) {
            String reversedString = stringReverse.reverseString(userStringInput);
            System.out.println("String original: " + userStringInput);
            System.out.println("String invertida: " + reversedString);
        } else {
            System.out.println("Entrada inválida...");
        }

    }
}
