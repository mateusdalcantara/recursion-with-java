public class Recursion {
    public static final int ONE = 1;
    public static final int ZERO = 0;

    static void factorialWithoutTail(double userInput, double acumulator) {
        if (userInput == ONE || userInput == ZERO) {  // Base case
            System.out.println("The factorial without tail is: " + acumulator);
            return;
        }

        // Recursive case: Multiply accumulator by current number and decrement userInput
        factorialWithoutTail(userInput - 1, acumulator * userInput);
    }

    // Função recursiva com cauda para calcular o fatorial
    static long factorialWithTail(int userInput, long acumulator) {
        if (userInput == 1 || userInput == 0) {  // Caso base
            return acumulator;  // Retorna o valor final do acumulador
        }

        // Chamada recursiva com o valor de userInput decrementado e acumulator multiplicado por userInput
        return factorialWithTail(userInput - 1, acumulator * userInput);
    }

    public static void main(String[] args) {

        int userInput = 5;  // Exemplo de entrada
        factorialWithoutTail(userInput, ONE); // Start the recursion with an accumulator of 1

        long result = factorialWithTail(userInput, ONE);  // Inicia a recursão com o acumulador em 1
        System.out.println("The factorial with tail of " + userInput + " is: " + result);



    }
}