import java.util.HashMap;

public class HashMapTest {
    private static final int TAMANHO = 100000;

    public static void main (String[] args){

        HashMap<Integer, Produto> mapa = new HashMap<>();

        for (int i = 0; i < TAMANHO; i++){
            mapa.put(i, new Produto(i, "produto" + i, i*20));
        }

        long startTime = System.currentTimeMillis();

        for (int qnt = 0; qnt < TAMANHO; qnt++){
            Produto p = mapa.get(qnt);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Tempo de execução: " + (endTime - startTime) + " ms");
    }
}
