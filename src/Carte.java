import java.util.Random;

public class Carte {
    int signe;
    String name;
    int value;

    public Carte(int signe, String name, int value) {
        this.signe = signe;
        this.name = name;
        this.value = value;
    }

    public void printOut() {
        System.out.println(name + ":" + signe + ";" + value );
    }

    //Melanger les cartes
    public static Carte[] melange(Carte[] cartes) {
        Carte[] newCartes = new Carte[cartes.length];
        int index;
        Random random = new Random();
        for(int i = cartes.length - 1; i >= 0; i--) {
            index = random.nextInt(i+1);
            newCartes[i] = cartes[index];
            newCartes[index] = cartes[i];
        }

        return newCartes;
    }
}