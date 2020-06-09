/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.voyageur.AbstractVoyageur;

import java.util.ArrayList;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class Voyage extends AbstractVoyage {

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur) {
        super(listPlanete, simulatedVoyageur);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param listPlanete
     * @param simulatedVoyageur
     * @param realVoyager
     */
    public Voyage(ArrayList<Planete> listPlanete, AbstractVoyageur simulatedVoyageur, AbstractVoyageur realVoyager) {
        super(listPlanete, simulatedVoyageur, realVoyager);
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showFromPlanete(fr.emac.gipsi.gsi.voyage.Planete)
     */
    @Override
    public int showFromPlanete(Planete p) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#showAll()
     */
    @Override
    public int showAll() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotage()
     */
    @Override
    public void lancement() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyage.AbstractVoyage#pilotageSimuler()
     */
    @Override
    public void lancementSimuler() {
        // TODO Auto-generated method stub
    	    	    	
    	int nbrplanete = listPlanete.size();
    	double[][] distanceplanete = new double[nbrplanete][nbrplanete];
    	
    	
    	for (int i =0; i < nbrplanete; i++) {
    		for (int j =0; j < nbrplanete; j++) {
    			double distancex = Math.pow(listPlanete.get(i).getPos().getX() - listPlanete.get(j).getPos().getX(), 2);
    			double distancey = Math.pow(listPlanete.get(i).getPos().getY() - listPlanete.get(j).getPos().getY(), 2);
    			distanceplanete[i][j] = Math.sqrt(distancex-distancey);
    		}
    	}
    	   	
    	
    	
    	
    	
    	
    	afficheEcran();
    	wait(700);
        getSimulatedvoyageur().goForward();
        afficheEcran();
    	wait(700);
        getSimulatedvoyageur().goForward();
        afficheEcran();
    	wait(700);
        getSimulatedvoyageur().turnRight();
        afficheEcran();
    	wait(700);
        getSimulatedvoyageur().goForward();
        afficheEcran();
    }
}
