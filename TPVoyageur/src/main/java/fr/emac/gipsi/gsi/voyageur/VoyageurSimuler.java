/**
 *
 */
package fr.emac.gipsi.gsi.voyageur;

import fr.emac.gipsi.gsi.voyage.Position;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class VoyageurSimuler extends AbstractVoyageur {

    /**
     *
     */
    public VoyageurSimuler() {
        // TODO Auto-generated constructor stub
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#forward()
     */
    @Override
    protected void forward() {
        // TODO Auto-generated method stub
    	String directionactuelle = getDirection();
    	Position positiontete = getPosTete();
    	Position positionbody = getPosBody();
    	
    	int xt = positiontete.getX();
    	int yt = positiontete.getY();
    	
    	int xb = positionbody.getX();
    	int yb = positionbody.getY();
    	
    	Position bonnetete;
    	Position bonbody;
    	
    	switch (directionactuelle) {
    		case "N":
    			bonnetete= new Position(xt - 1, yt);
    			setPosTete(bonnetete);
    			bonbody= new Position(xb - 1, yb);
    			setPosBody(bonbody);
    			break;
    		case "E":
    			bonnetete= new Position(xt,yt + 1);
    			setPosTete(bonnetete);
    			bonbody= new Position(xb,yb + 1);
    			setPosBody(bonbody);
    			break;
    		case "O":
    			bonnetete= new Position(xt,yt - 1);
    			setPosTete(bonnetete);
    			bonbody= new Position(xb,yb - 1);
    			setPosBody(bonbody);
    			break;
    		case "S":
    			bonnetete= new Position(xt + 1, yt);
    			setPosTete(bonnetete);
    			bonbody= new Position(xb + 1, yb);
    			setPosBody(bonbody);
    			break;
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#backward()
     */
    @Override
    protected void backward() {
        // TODO Auto-generated method stub
    	String directionactuelle = getDirection();
    	Position positiontete = getPosTete();
    	Position positionbody = getPosBody();
    	
    	int xt = positiontete.getX();
    	int yt = positiontete.getY();
    	
    	int xb = positionbody.getX();
    	int yb = positionbody.getY();
    	
    	Position bonnetete;
    	Position bonbody;
    	
    	switch (directionactuelle) {
    		case "N":
    			bonnetete= new Position(xt + 1, yt);
    			setPosTete(bonnetete);
    			bonbody= new Position(xb + 1, yb);
    			setPosBody(bonbody);
    			break;
    		case "E":
    			bonnetete= new Position(xt,yt - 1);
    			setPosTete(bonnetete);
    			bonbody= new Position(xb,yb - 1);
    			setPosBody(bonbody);
    			break;
    		case "O":
    			bonnetete= new Position(xt,yt + 1);
    			setPosTete(bonnetete);
    			bonbody= new Position(xb,yb + 1);
    			setPosBody(bonbody);
    			break;
    		case "S":
    			bonnetete= new Position(xt - 1, yt);
    			setPosTete(bonnetete);
    			bonbody= new Position(xb - 1, yb);
    			setPosBody(bonbody);
    			break;
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#left()
     */
    @Override
    protected void left() {
        // TODO Auto-generated method stub
    	String directionactuelle = getDirection();
    	Position positiontete = getPosTete();
    	
    	int xt = positiontete.getX();
    	int yt = positiontete.getY();
    	
    	Position bonnetete;
    	    	
    	switch (directionactuelle) {
    		case "N":
    			bonnetete= new Position(xt + 1, yt - 1);
    			setPosTete(bonnetete);
    			setDirection("O");
    			break;
    		case "E":
    			bonnetete= new Position(xt - 1, yt - 1);
    			setPosTete(bonnetete);
    			setDirection("N");
    			break;
    		case "O":
    			bonnetete= new Position(xt + 1, yt + 1);
    			setPosTete(bonnetete);
    			setDirection("S");
    			break;
    		case "S":
    			bonnetete= new Position(xt - 1, yt + 1);
    			setPosTete(bonnetete);
    			setDirection("E");
    			break;
    	}
    }

    /* (non-Javadoc)
     * @see fr.emac.gipsi.gsi.voyageur.AbstractVoyageur#right()
     */
    @Override
    protected void right() {
        // TODO Auto-generated method stub
    	String directionactuelle = getDirection();
    	Position positiontete = getPosTete();
    	
    	int xt = positiontete.getX();
    	int yt = positiontete.getY();
    	
    	Position bonnetete;
    	
    	switch (directionactuelle) {
    		case "N":
    			bonnetete= new Position(xt + 1, yt + 1);
    			setPosTete(bonnetete);
    			setDirection("E");
    			break;
    		case "E":
    			bonnetete= new Position(xt + 1, yt - 1);
    			setPosTete(bonnetete);
    			setDirection("S");
    			break;
    		case "O":
    			bonnetete= new Position(xt - 1, yt + 1);
    			setPosTete(bonnetete);
    			setDirection("N");
    			break;
    		case "S":
    			bonnetete= new Position(xt - 1, yt - 1);
    			setPosTete(bonnetete);
    			setDirection("O");
    			break;
    	}
    }
}
