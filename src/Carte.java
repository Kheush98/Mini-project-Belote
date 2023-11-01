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
}