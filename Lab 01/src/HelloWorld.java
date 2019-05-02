import java.util.Arrays;

public class HelloWorld {

    enum GatunekPiwa{
        LAGER, PILZNER, PORTER, STOUT, PIWO_Z_BIEDRONKI
    }

    public static void main(String[] args) {
        zad1();
        zad2();
        zad3();
    }

    public static void zad1() {
        int rand[] = new int[6];
        for(int i=0; i<6; i++)
            rand[i] = (int) Math.ceil(Math.random() * 49);
        Arrays.sort(rand);
        for(int i=0; i<6; i++)
            System.out.println(rand[i]);

        System.out.println("\n\n");
    }
    public static void zad2(){
        Integer rand[] = new Integer[6];
        for(int i=0; i<6; i++)
            rand[i] = (int) Math.ceil(Math.random() * 49);

        for(int i=0; i<6; i++)
            System.out.println(rand[i]);

        System.out.println("\n\n");
    }
    public static void zad3() {
        GatunekPiwa piwa[] = new GatunekPiwa[3];
        for (int i = 0; i < 3; i++) {
            piwa[i] = GatunekPiwa.values()[(int) Math.ceil(Math.random() * GatunekPiwa.values().length)];
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(piwa[i]);
        }
        for (int i = 0; i < 3; i++)
            switch (piwa[i]){
                case LAGER:
                case PILZNER:
                    System.out.println("piwo jasne");
                    break;
                case PORTER:
                case STOUT:
                    System.out.println("piwo ciemne");
                    break;
                case PIWO_Z_BIEDRONKI:
                    System.out.println("piwo tanie");
                    break;
            }
    }
}
