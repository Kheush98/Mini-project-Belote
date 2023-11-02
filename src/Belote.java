public class Belote {
    static Carte[] cartes;
    static Joueur[] joueurs;

    public Belote() {
        // Creation des joueurs
        Joueur[] joueurs = new Joueur[4];
        joueurs[0] = new Joueur("Doudou");
        joueurs[1] = new Joueur("Lamine");
        joueurs[2] = new Joueur("Fatou");
        joueurs[3] = new Joueur("Dieynaba");
        
        // Creation des 52 cartes
        Carte[] cartes = new Carte[52];
        int index = 0;
        for(int j = 0; j < 4; j++) {
            for(int i = 0; i < 13; i++) {
                cartes[index] = new Carte(j, String.valueOf(i+1), i+1);
                index++;
            }
        }

        //Distribution des cartes
        index = 0;
        Carte[] newCartes = Carte.melange(cartes);
        for(int j = 0; j < 4; j++) {
            for(int i = 0; i < 13; i++) {
                joueurs[j].ajoutCarte(newCartes[index]);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        new Belote();
        int maxValue;
        Carte[] carteTour = new Carte[4];
        int nombreTour = 1;
        int indexGagnant = 0;

        do {
            System.out.println("Tour "+nombreTour);
            carteTour[0] = Belote.joueurs[indexGagnant].jouerEnPremier();
            if (carteTour[0] == null) {
                break;
            }
            carteTour[0].printOut();
            maxValue = carteTour[0].value;
            for(int i = 0; i < 4; i++){
                if(i != indexGagnant){
                    carteTour[i] = Belote.joueurs[i].play(carteTour[0].signe);
                    System.out.println(joueurs[i].name+" :");
                    carteTour[i].printOut();
                    if (maxValue < carteTour[i].value) {
                        maxValue = carteTour[i].value;
                        indexGagnant = i;
                    }
                }
            }
            //Mise à jour score du gagnant
            joueurs[indexGagnant].tourGagnant(carteTour);
            System.out.println("Gagnant du tour "+nombreTour+": "+joueurs[indexGagnant].name);
            nombreTour++;
        }while(true);

    }
}
