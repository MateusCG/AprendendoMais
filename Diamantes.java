package busca_binaria;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Mateus
 */
public class Diamantes {

    private int qtd_Diamantes(Stack a) {
        int abertos = 0, fechados = 0, achados = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals('<')) {
                abertos++;
            } else {
                if (a.get(i).equals('>')) {
                    fechados++;
                }
            }
        }
        if (abertos < fechados) {
            achados = abertos;
        } else {
            achados = fechados;
        }
        return achados;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testes = sc.nextInt();
        Stack pilha[] = new Stack[testes];
        for (int i = 0; i < testes; i++) {
            pilha[i] = new Stack();
        }
        for (int i = 0; i < pilha.length; i++) {
            String mina = sc.next();
            char[] fragmentos = mina.toCharArray();
            for (int j = 0; j < fragmentos.length; j++) {
                pilha[i].add(fragmentos[j]);
            }
        }
        Diamantes rico = new Diamantes();

        for (int i = 0; i < pilha.length; i++) {
            System.out.println(rico.qtd_Diamantes(pilha[i]));
        }
    }
}
