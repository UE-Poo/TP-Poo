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
		afficheEcran();
		
		int t;
		int[] trajet;
		double[][] distanceplanete;
		
		distanceplanete = matricedistance();
		trajet = bestRoad(distanceplanete,0);
		
    	
    	for (int i =0; i < nbrplanete; i++) {
    		wait(3000);
    		goToPlanete(listPlanete.get(trajet[i]));
    		afficheEcran();
    	}

    	
    	}
    	
    private double[][] matricedistance() {
    	
    	int nbrplanete = listPlanete.size();
    	double[][] distanceplanete = new double[nbrplanete][nbrplanete];
    	
    	
    	for (int i =0; i < nbrplanete; i++) {
    		for (int j =0; j < nbrplanete; j++) {
    			double distancex = Math.pow(listPlanete.get(i).getPos().getX() - listPlanete.get(j).getPos().getX(), 2);
    			double distancey = Math.pow(listPlanete.get(i).getPos().getY() - listPlanete.get(j).getPos().getY(), 2);
    			distanceplanete[i][j] = Math.sqrt(distancex+distancey);
    		
    		}
    	}
    	return distanceplanete;
    }
    
    
       
    private int[] bestRoad(double[][] distanceplanete, int x) {
    	
    	int nbrplanete = listPlanete.size();
    	int[] bestroad = new int[nbrplanete];
    	int nouvelleplanete;
    	bestroad[0] = x;
    	    	
    	for (int i =0; i < nbrplanete-1; i++) {
    		
    		double a = distanceplanete[x][0];
    		nouvelleplanete = 0;
    		
    		while (a == 0) {
    			nouvelleplanete++;
    			a = distanceplanete[x][nouvelleplanete];
    			System.out.println(a);
    			System.out.print("------------");
    		}
    		
    		
    		
    		for (int j =0; j < nbrplanete; j++) {
    			if (distanceplanete[x][j]>0 && distanceplanete[x][j]<a) {
    				
    				 a = distanceplanete[x][j];
    				 nouvelleplanete= j;
    			}
    		}
    		for (int h =0; h < nbrplanete; h++) {
    			distanceplanete[h][x] = 0 ;
    		}
    		x = nouvelleplanete;
    		bestroad[i+1] = x ;

    	}
    	return bestroad;
    }
   
    
    private  void goToPlanete(Planete p) {
    	Position positionbody = getSimulatedvoyageur().getPosBody();
    	Position positionplanete = p.getPos();
    	
    	String directionactuelle = getSimulatedvoyageur().getDirection();
    	
    	
    	int xb = positionbody.getX();
    	int yb = positionbody.getY();
    	
    	int px = positionplanete.getX();
    	int py = positionplanete.getY();
    	
    	int a = xb - px;
 		int b = yb - py;
    	
    	
    	switch (directionactuelle) {
    	 	case "N":
    	 		while (Math.abs(a)>0) {
    				if (a>0) {
    					getSimulatedvoyageur().goForward();
    					afficheEcran();
    			    	wait(700);
    					a--;
    				}
    				else {
    					getSimulatedvoyageur().goBackward();
    					afficheEcran();
    			    	wait(700);
    					a++;
    				}
    			}
    	 		getSimulatedvoyageur().turnRight();
    	 		afficheEcran();
    	    	wait(700);
    			while (Math.abs(b)>0) {
    				if (b>0) {
    					getSimulatedvoyageur().goBackward();
    					afficheEcran();
    			    	wait(700);
    					b--;
    				}
    				else {
    					getSimulatedvoyageur().goForward();
    					afficheEcran();
    			    	wait(700);
    					b++;
    				}
    			}
    			break;
    			
    	 	case "S":
    	 		while (Math.abs(a)>0) {
    				if (a>0) {
    					getSimulatedvoyageur().goBackward();
    					afficheEcran();
    			    	wait(700);
    					a--;
    				}
    				else {
    					getSimulatedvoyageur().goForward();
    					afficheEcran();
    			    	wait(700);
    					a++;
    				}
    			}
    	 		getSimulatedvoyageur().turnRight();
    	 		afficheEcran();
    	    	wait(700);
    			while (Math.abs(b)>0) {
    				if (b>0) {
    					getSimulatedvoyageur().goForward();
    					afficheEcran();
    			    	wait(700);
    					b--;
    				}
    				else {
    					getSimulatedvoyageur().goBackward();
    					afficheEcran();
    			    	wait(700);
    					b++;
    				} 	
    			}
    			break;
    			
    	 	case "O":
    	 		while (Math.abs(b)>0) {
    				if (b>0) {
    					getSimulatedvoyageur().goForward();
    					afficheEcran();
    			    	wait(700);
    					b--;
    				}
    				else {
    					getSimulatedvoyageur().goBackward();
    					afficheEcran();
    			    	wait(700);
    					b++;
    				}	
    			}
    	 		getSimulatedvoyageur().turnRight();
    	 		afficheEcran();
    	    	wait(700);
    	 		while (Math.abs(a)>0) {
    				if (a>0) {
    					getSimulatedvoyageur().goForward();
    					afficheEcran();
    			    	wait(700);
    					a--;
    				}
    				else {
    					getSimulatedvoyageur().goBackward();
    					afficheEcran();
    			    	wait(700);
    					a++;
    				}
    			}    			
    			break;
    			
    	 	case "E":
    	 		while (Math.abs(b)>0) {
    				if (b>0) {
    					getSimulatedvoyageur().goBackward();
    					afficheEcran();
    			    	wait(700);
    					b--;
    				}
    				else {
    					getSimulatedvoyageur().goForward();
    					afficheEcran();
    			    	wait(700);
    					b++;
    				} 	
    			}
    	 		getSimulatedvoyageur().turnRight();
    	 		afficheEcran();
    	    	wait(700);
    	 		while (Math.abs(a)>0) {
    				if (a>0) {
    					getSimulatedvoyageur().goBackward();
    					afficheEcran();
    			    	wait(700);
    					a--;
    				}
    				else {
    					getSimulatedvoyageur().goForward();
    					afficheEcran();
    			    	wait(700);
    					a++;
    				}
    			}    			
    			break;
 			
    	}
    	
    }
    
}
