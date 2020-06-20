/**
 * 
 */
package fr.emac.gipsi.gsi.launch;

import fr.emac.gipsi.gsi.animation.AbstractAnimation;
import fr.emac.gipsi.gsi.animation.AnimationByColumn;
import fr.emac.gipsi.gsi.animation.AnimationFlash;
import fr.emac.gipsi.gsi.ecran.ListScreen;

/**
 * @author Truptil Sebastien - sebastien.truptil@gmail.com
 *
 */
public class LaunchAnimation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*AbstractAnimation aa = new AnimationFlash();
		aa.setEcranDeb(ListScreen.first());
		aa.setEcranFin(ListScreen.second());
		
		aa.runAnimation();

		aa.wait(1000);
		
		AbstractAnimation ab = new AnimationFlash();
		ab.setEcranDeb(ListScreen.second());
		ab.setEcranFin(ListScreen.first());
		
		ab.runAnimation();
		
		ab.wait(1000);
		
		AbstractAnimation ac = new AnimationByColumn();
		ac.setEcranDeb(ListScreen.first());
		ac.setEcranFin(ListScreen.smiley());
		
		ac.runAnimation();
		*/
		
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
		
		ag.wait(00);
		
	}

}
