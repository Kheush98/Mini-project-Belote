public class Joueur {
    String name;
    int score;
    int counter;
    Carte[] carte;

    public Joueur(String name) {
        this.name = name;
        this.score = 0;
        this.counter = 0;
        this.carte = new Carte[13];
    }

    public void ajoutCarte(Carte carte) {
        if(counter < 13) {
            this.carte[counter] = carte;
            counter++;
        } else {
            System.out.println("Vous avez atteint le maximum de carte");
        }
    }

    public Carte jouerEnPremier() {
        Carte carte;
        for(int i = 0; i < this.carte.length; i++) {
            if(this.carte[i] != null) {
                carte = this.carte[i];
                this.carte[i] = null;
                counter--;
                return carte;
            }
        }

        return null;
    }

    public Carte play(int signe) {
        counter--;
        for(int i = 0; i < this.carte.length; i++) {
            if(this.carte[i].signe == signe) {
                return this.carte[i];
            }
        }

        return this.carte[counter];
    }

    public void tourGagnant(Carte[] carte) {
        for(Carte newCarte : carte) {
            score += newCarte.value;
        }
    }
}
