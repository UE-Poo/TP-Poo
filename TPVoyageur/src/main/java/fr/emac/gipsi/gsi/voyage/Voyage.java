/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.ecran.ListScreen;
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
		
		ArrayList<Integer> Trajet= new ArrayList<Integer>();
		double[][] distanceplanete;
		
		distanceplanete = matricedistance();		
		Trajet = bestRoad(distanceplanete,0);
		
		for (int i =0; i < Trajet.size(); i++) {
			System.out.println(Trajet.get(i));
		}
		
    	for (int i =0; i < Trajet.size(); i++) {
    		wait(3000);
    		goToPlanete(listPlanete.get(Trajet.get(i)));   		
    		
    	}
 

    }
    	
    private double[][] matricedistance() {
    	
    	int nbrplanete = listPlanete.size();
    	double[][] distanceplanete = new double[nbrplanete][nbrplanete];
    	int[] listeaccessible;
    	double[][] nouvelledistance = new double[nbrplanete][nbrplanete];
    	int k;
    	
    	for (int i = 0; i < nouvelledistance.length; i++) {
    		  for (int j = 0; j < nouvelledistance[i].length; j++) {
    		    nouvelledistance[i][j] = 0;
    		  }
    	}
    	
    	
    	for (int i =0; i < nbrplanete; i++) {
    		for (int j =0; j < nbrplanete; j++) {
    			double distancex = Math.pow(listPlanete.get(i).getPos().getX() - listPlanete.get(j).getPos().getX(), 2);
    			double distancey = Math.pow(listPlanete.get(i).getPos().getY() - listPlanete.get(j).getPos().getY(), 2);
    			distanceplanete[i][j] = Math.sqrt(distancex+distancey);
    		
    		}
    	}
    	
    	
    	for (int i =0; i < nbrplanete; i++) {
    		listeaccessible = accessibilite(listPlanete.get(i));
    		
    		for(int j =0; j<listeaccessible.length;j++) {
    			k=listeaccessible[j];
    			nouvelledistance[k][i] = distanceplanete[i][k];
    			
    		}	
    	}
    	return nouvelledistance;
    }
    
    
    private int[] accessibilite (Planete p) {
    	
    	ArrayList<Planete> Accessibilite = p.getListAccessibilite();
    	
    	int nbrplaneteaccessible = Accessibilite.size();
    	int nbrplanete = listPlanete.size();
    	int[] indiceplaneteaccessible = new int[nbrplaneteaccessible];
    	
    	for (int i =0; i < nbrplaneteaccessible; i++) {
    		for (int j =0; j < nbrplanete; j++) {
    			if (Accessibilite.get(i)  == listPlanete.get(j)) {
    				indiceplaneteaccessible[i]=j;
    			}
    		}
    	}
    	return indiceplaneteaccessible;
    		
    }
    
    private int[] nbrePlaneteAccessibleparPlanete() {
    	
    	int nbrplanete = listPlanete.size();
    	int[] nbraccesparplanete = new int[nbrplanete];
    	int[] listeaccessible;
    	
    	
    	for (int j =0; j < nbrplanete; j++) {
    		listeaccessible = accessibilite(listPlanete.get(j));
    		nbraccesparplanete[j] = listeaccessible.length;
    	}
    	return nbraccesparplanete;
    }
    
    
    
       
    private ArrayList<Integer> bestRoad(double[][] distanceplanete, int x) {
    	
    	/* Faire à chaque planète un calcul comptant le nombre d'accessibilité de chaque planète d'ou l'on a accés à partir de cette planete
    	 * Si il y a une acces d'une planète qui est égale à 1 (ça veut dire qu'on peut y aller que de cette planète) alors on y va et on reviens sur cette planète
    	 * (sauf si c'est la dernière planète à visiter bien sur)
    	 * Si pas de planète avec acces = 1 alors on choisit la planète la plus proche et toutes les planètes accessible depuis la planète de départ prennent -1 en acces
    	 * Ensuite on réitère le même process sur chaque planète jusqu'a arrivé à la fin 
    	 */
    	
    	
    	/*
    	 * 
    	 * 
    	 * 
    	 * 
    	 * looooooooooooooollllllcskqol,ckj,fqpl
    	 * dqj,slkdj,lqksdkj
    	 * dpklqs,jlmkd,qpsol
    	 * d;mlqs,ml
    	 * d,qspl,dm
    	 * dqlk^kdl$
    	 * ,dqmslk
    	 * 
    	 * 
    	 * 
    	 */
    	
    	ArrayList<Integer> Trajet= new ArrayList<Integer>();
    	Trajet.add(x);
    	
    	int nbrplanete = listPlanete.size();
    	int nouvelleplanete;

    	
    	int[] nbraccesparplanete = nbrePlaneteAccessibleparPlanete();
    	boolean nonarret = true;
    	    	
    	for (int i =0; i < nbrplanete-1; i++) {
    		
    		double a = distanceplanete[x][0];
    		nouvelleplanete = 0;
    		
    		while (a == 0) {
    			nouvelleplanete++;
    			a = distanceplanete[x][nouvelleplanete];
    		}

    		for (int j =0; j < nbrplanete; j++) {
    			
    			if (distanceplanete[x][j] != 0) {

    				if (nbraccesparplanete[j] == 1) {
						Trajet.add(j);				
						for (int h =0; h < nbrplanete; h++) {
							distanceplanete[h][j] = 0 ;
						}
						nonarret = false;
						nbraccesparplanete[j]--;
						break;
					}
					nbraccesparplanete[j]--;
					
					if (distanceplanete[x][j]<a) {
	    				 a = distanceplanete[x][j];
	    				 nouvelleplanete= j;
	    				 
					}
					nonarret = true;				
    			}
    			
    		}
    		    		    		
    		if (nonarret) {    			
    			for (int h =0; h < nbrplanete; h++) {
        			distanceplanete[h][x] = 0 ;
        		}
    			x = nouvelleplanete;
    		}
    		
    		Trajet.add(x);
    	}
    	return Trajet;
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
    	 		if (b>0) {
    	 			getSimulatedvoyageur().turnLeft();
    	 		}
    	 		else if (b<0) {
    	 			getSimulatedvoyageur().turnRight();
    	 		}
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
    	 		if (b>0) {
    	 			getSimulatedvoyageur().turnRight();
    	 		}
    	 		else if (b<0) {
    	 			getSimulatedvoyageur().turnLeft();
    	 		}
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
    					getSimulatedvoyageur().goForward();
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
    	 		if (a>0) {
    	 			getSimulatedvoyageur().turnRight();
    	 		}
    	 		else if (a<0) {
    	 			getSimulatedvoyageur().turnLeft();
    	 		}
    	 		
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
    					getSimulatedvoyageur().goForward();
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
    	 		if (a>0) {
    	 			getSimulatedvoyageur().turnLeft();
    	 		}
    	 		else if (a<0) {
    	 			getSimulatedvoyageur().turnRight();
    	 		}
    	 		
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
