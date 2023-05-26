package LFA;
import java.util.Stack;

public class AutomatoPilha {

/*Defina um AP para a linguagem abaixo e faça a implementação desse autômato em alguma linguagem de programação.
L = {wXwr  | w pertence a {a|b}* e wr é w invertido}*/




    public static boolean verifica(String entrada) {
        int estadoAtual = 0;
        Stack<Character> pilha = new Stack<>();

        System.out.println("Entrada: "+entrada);
        System.out.println("Estado\t| a\t| b\t| X\t| Pilha");
        System.out.println("-------------------------------------------");
       
        for (int i = 0; i < entrada.length(); i++) {
            char c = entrada.charAt(i);

            switch (estadoAtual) {
                case 0:
                    if (c == 'a' || c == 'b') {
                        pilha.push(c);
                    } else if (c == 'X') {
                        estadoAtual = 1;
                    } else {
                        return false;
                    }
                    break;

                case 1:
                    if (c == 'a' && !pilha.isEmpty() && pilha.peek() == 'a') {
                        pilha.pop();
                    } else if (c == 'b' && !pilha.isEmpty() && pilha.peek() == 'b') {
                        pilha.pop();
                    } else {
                        return false;
                    }
                    break;

                default:
                    return false;
            }

            String pilhaString = pilha.toString().replace(", ", "");

            System.out.println(estadoAtual + "\t| \t| \t| \t| " + pilhaString);
        }

        return pilha.isEmpty() && estadoAtual == 1;
    }

    public static void main(String[] args) {
    	// Pode adicionar entradas para verificar se é valida ou não
        String[] entradas = { "bbaXabb","aXb","aaaXaaa","bbaaXaabb" };

        for (String entrada : entradas) {
            boolean aceito = verifica(entrada);
            String tabelaTransicao = gerarTabelaTransicao();
            String estados = gerarEstados();
            System.out.println("Aceito: " + aceito);
            System.out.println("Tabela de Transicao:\n" + tabelaTransicao);
            System.out.println("Estados: " + estados);
            System.out.println("---------------------------------------------------\n");       
           
            System.out.println();
        }
    }

    public static String gerarTabelaTransicao() {
        StringBuilder tabela = new StringBuilder();
        tabela.append("Estado\t| a\t| b\t| X\t|\n");
        tabela.append("---------------------------------------------------\n");
        tabela.append("0\t| 0\t| 0\t| 1\t| \n");
        tabela.append("1\t| 1\t| 1\t| -\t| \n");
        return tabela.toString();
    }

    public static String gerarEstados() {
        return "{0, 1}";
    }




}
