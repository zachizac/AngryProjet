package ObserverPattern;

/**
 * Created by MERTZ on 23/02/2017.
 */
public interface Observable {

    public void ajouterObservateur(Observer o);

    public void supprimerObservateur(Observer o);

    public void notifierObservateurs();
}
