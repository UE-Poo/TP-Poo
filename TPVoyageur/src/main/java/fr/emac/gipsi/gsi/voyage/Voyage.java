/**
 *
 */
package fr.emac.gipsi.gsi.voyage;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
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
		
		int[] dejavisite = new int[Trajet.size()];
		boolean pasencorevu = true;
			
    	for (int i =0; i < Trajet.size(); i++) {
    		
    		if (i==0) {
    			wait(3000);
    			goToPlanete(listPlanete.get(Trajet.get(i)));
    			
    			/* Animation prise de photo de la planète */
    			AbstractAnimation ab = new AnimationFlash();
        		ab.setEcranDeb(ListScreen.Pixar1());
        		ab.setEcranFin(ListScreen.Pixar2());
        		ab.runAnimation();        		
        		ab.wait(300);        		
        		AbstractAnimation ac = new AnimationFlash();
        		ac.setEcranDeb(ListScreen.Pixar2());
        		ac.setEcranFin(ListScreen.Pixar3());
        		ac.runAnimation();
        		ac.wait(300);        		
        		AbstractAnimation ad = new AnimationFlash();
        		ad.setEcranDeb(ListScreen.Pixar3());
        		ad.setEcranFin(ListScreen.Pixar4());
        		ad.runAnimation();        		
        		ad.wait(300);        		
        		AbstractAnimation ae = new AnimationFlash();
        		ae.setEcranDeb(ListScreen.Pixar4());
        		ae.setEcranFin(ListScreen.Pixar5());
        		ae.runAnimation();        		
        		ae.wait(300);        		
        		AbstractAnimation af = new AnimationFlash();
        		af.setEcranDeb(ListScreen.Pixar5());
        		af.setEcranFin(ListScreen.Pixar6());
        		af.runAnimation();
        		af.wait(300);        		
        		AbstractAnimation ag = new AnimationFlash();
        		ag.setEcranDeb(ListScreen.Pixar6());
        		ag.setEcranFin(ListScreen.Pixar7());
        		ag.runAnimation();        		
        		ag.wait(300);
        		AbstractAnimation ah = new AnimationFlash();
        		ah.setEcranDeb(ListScreen.Pixar6());
        		ah.setEcranFin(listPlanete.get(Trajet.get(i)).getImage());
        		ah.runAnimation();        		
        		ah.wait(1000);
        		
        		
        		/*Animation de prise d'échantillon */
        		AbstractAnimation b = new AnimationFlash();
        		b.setEcranDeb(ListScreen.Pince1()); 
        		b.setEcranFin(ListScreen.Pince2()); 
        		b.runAnimation();
        		b.wait(300); 
        		AbstractAnimation c = new AnimationFlash(); 
        		c.setEcranDeb(ListScreen.Pince2()); 
        		c.setEcranFin(ListScreen.Pince3()); 
        		c.runAnimation(); 
        		c.wait(300); 
        		AbstractAnimation d = new AnimationFlash(); 
        		d.setEcranDeb(ListScreen.Pince3()); 
        		d.setEcranFin(ListScreen.Pince4()); 
        		d.runAnimation();
        		d.wait(300); 
        		AbstractAnimation e = new AnimationFlash(); 
        		e.setEcranDeb(ListScreen.Pince4()); 
        		e.setEcranFin(ListScreen.Pince5()); 
        		e.runAnimation();
        		e.wait(300); 
        		AbstractAnimation f = new AnimationFlash(); 
        		f.setEcranDeb(ListScreen.Pince5()); 
        		f.setEcranFin(ListScreen.Pince6()); 
        		f.runAnimation(); 
        		f.wait(300);
        		
        		
        		dejavisite[i]=Trajet.get(i);
        		       		
        		
        		
    		}
    		
    		if (i !=0) {
    			wait(3000);
    			goToPlanete(listPlanete.get(Trajet.get(i)));
    			
    			for(int j=0; j<nbrplanete;j++) {
    				if (dejavisite[j] == Trajet.get(i)) {
    					pasencorevu=false;
    					break;
    				}
    				else {
    					pasencorevu =true;
    				}
    			}
    			if(pasencorevu) {
    				/* Animation prise de photo de la planète */
        			AbstractAnimation ab = new AnimationFlash();
            		ab.setEcranDeb(ListScreen.Pixar1());
            		ab.setEcranFin(ListScreen.Pixar2());
            		ab.runAnimation();        		
            		ab.wait(300);        		
            		AbstractAnimation ac = new AnimationFlash();
            		ac.setEcranDeb(ListScreen.Pixar2());
            		ac.setEcranFin(ListScreen.Pixar3());
            		ac.runAnimation();
            		ac.wait(300);        		
            		AbstractAnimation ad = new AnimationFlash();
            		ad.setEcranDeb(ListScreen.Pixar3());
            		ad.setEcranFin(ListScreen.Pixar4());
            		ad.runAnimation();        		
            		ad.wait(300);        		
            		AbstractAnimation ae = new AnimationFlash();
            		ae.setEcranDeb(ListScreen.Pixar4());
            		ae.setEcranFin(ListScreen.Pixar5());
            		ae.runAnimation();        		
            		ae.wait(300);        		
            		AbstractAnimation af = new AnimationFlash();
            		af.setEcranDeb(ListScreen.Pixar5());
            		af.setEcranFin(ListScreen.Pixar6());
            		af.runAnimation();
            		af.wait(300);        		
            		AbstractAnimation ag = new AnimationFlash();
            		ag.setEcranDeb(ListScreen.Pixar6());
            		ag.setEcranFin(ListScreen.Pixar7());
            		ag.runAnimation();        		
            		ag.wait(300);
            		AbstractAnimation ah = new AnimationFlash();
            		ah.setEcranDeb(ListScreen.Pixar6());
            		ah.setEcranFin(listPlanete.get(Trajet.get(i)).getImage());
            		ah.runAnimation();        		
            		ah.wait(1000);
            		wait(1000);
            		
            		
            		/*Animation de prise d'échantillon */
            		AbstractAnimation b = new AnimationFlash();
            		b.setEcranDeb(ListScreen.Pince1()); 
            		b.setEcranFin(ListScreen.Pince2()); 
            		b.runAnimation();
            		b.wait(300); 
            		AbstractAnimation c = new AnimationFlash(); 
            		c.setEcranDeb(ListScreen.Pince2()); 
            		c.setEcranFin(ListScreen.Pince3()); 
            		c.runAnimation(); 
            		c.wait(300); 
            		AbstractAnimation d = new AnimationFlash(); 
            		d.setEcranDeb(ListScreen.Pince3()); 
            		d.setEcranFin(ListScreen.Pince4()); 
            		d.runAnimation();
            		d.wait(300); 
            		AbstractAnimation e = new AnimationFlash(); 
            		e.setEcranDeb(ListScreen.Pince4()); 
            		e.setEcranFin(ListScreen.Pince5()); 
            		e.runAnimation();
            		e.wait(300); 
            		AbstractAnimation f = new AnimationFlash(); 
            		f.setEcranDeb(ListScreen.Pince5()); 
            		f.setEcranFin(ListScreen.Pince6()); 
            		f.runAnimation(); 
            		f.wait(300);
            		
            		wait(1000);
            		
            		
    	    		dejavisite[i]=Trajet.get(i);
    			
    				
    			}
    		}
    		
    		
    		
    		
    		
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
