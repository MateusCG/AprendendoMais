package busca_binaria;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Mateus Cavalcante
 */
@SuppressWarnings("unchecked")
public class Tabelas_hash {

    private int qtd_chaves, qtd_total;
    LinkedList<Object>[] lista;

    public Tabelas_hash(int qtd_total, int qtd_chaves) {
        this.qtd_total = qtd_total;
        this.qtd_chaves = qtd_chaves;
        lista = new LinkedList[qtd_total];
    }

    public int[] chave(String chaves) {
        int valores[] = new int[qtd_chaves];
        String[] split = chaves.split(" ", qtd_chaves);
        for (int j = 0; j < split.length; j++) {
            valores[j] = Integer.parseInt(split[j]);
        }
        return valores;
    }

    public void inserirChaves(String chaves) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = new LinkedList<>();
        }
        for (int i = 0; i < chave(chaves).length; i++) {
            int index = chave(chaves)[i] % qtd_total;
            lista[index].add(chave(chaves)[i]);
        }
    }

    public void printChaves() {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(i + " -> ");
            Object[] subLista = lista[i].toArray();
            for (int j = 0; j < subLista.length; j++) {
                System.out.print(subLista[j] + " -> ");
            }
            System.out.println("\\");
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String qtdTestes = sc.nextLine();
        Tabelas_hash[] hash = new Tabelas_hash[Integer.parseInt(qtdTestes)];

        for (int i = 0; i < hash.length; i++) {
            String valoresMap = sc.nextLine();
            String[] valores = valoresMap.split(" ");
            hash[i] = new Tabelas_hash(Integer.parseInt(valores[0]), Integer.parseInt(valores[1]));
            String chaves = sc.nextLine();
            hash[i].inserirChaves(chaves);
        }
        for (int i = 0; i < hash.length; i++) {
            System.out.println("");
            hash[i].printChaves();
        }
        sc.close();
    }
}
