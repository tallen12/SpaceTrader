import model.Galaxy;
import model.StarSystem;
import Generators.Util;
import Generators.EllipticalGalaxyGenerator;
import Generators.GalaxyGenerator;
import javax.swing.*;
import java.util.*;
import java.awt.Graphics;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;

public class M4Demo extends JPanel{

	private static int FRAME_SIZE_FACTOR = 20;
	private static double BOUND_FACTOR = 4; 
	private static double SYSTEM_NUM_MEAN = 10000;
	private static double SYSTEM_NUM_SD = 100;
	private static double X_SD = 4;
	private static double Y_SD = 2;
	private static double SCALE = 1;
	private static int FRAME_SIZE = (int) (SCALE * FRAME_SIZE_FACTOR * BOUND_FACTOR * Math.max(X_SD, Y_SD));
	private static int DOT_SIZE = 2;

	private static Galaxy gax;

	public static void main(String[] args) {

		// EllipticalGalaxy test
		GalaxyGenerator gaxGen = new EllipticalGalaxyGenerator(
			"Fartdust",
			SYSTEM_NUM_MEAN, 
			SYSTEM_NUM_SD, 
			X_SD, Y_SD, 
			BOUND_FACTOR*X_SD, BOUND_FACTOR*Y_SD, 
			Util.sampleFromUniformReal(0, Math.PI)
		);
		gax = gaxGen.generate();
		List<StarSystem> systems = gax.getSystems();
                
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setTitle("WAT");
		frame.setSize((int)(FRAME_SIZE), (int)(FRAME_SIZE));
		frame.add(new M4Demo());
	}

	public void paintComponent(Graphics g) {

		List<StarSystem> systems = gax.getSystems();
		int shift = (int) (FRAME_SIZE/2.0 - DOT_SIZE/2.0);
		for (StarSystem system : systems) {
			int x = (int) (system.getPosition().x*FRAME_SIZE_FACTOR/2.0) + shift;
			int y = (int) (system.getPosition().y*FRAME_SIZE_FACTOR/2.0) + shift;

			g.fillOval(x, y, DOT_SIZE, DOT_SIZE);
		}

		// // final int OVAL_W = 400;
		// final int OVAL_H = 80;
		// final int MAIN_DOT_DIAM = 20;
		// final int INCIDENT_DOT_DIAM = 10;

		// // draw oval
		// g.drawOval(
		// 	(int) ((FRAME_SIZE - OVAL_W)/2.0), 
		// 	(int) ((FRAME_SIZE - OVAL_H)/2.0), 
		// 	OVAL_W, OVAL_H
		// );

		// // sample main dot
		// UniformRealDistribution distr = 
		// 	new UniformRealDistribution(-FRAME_SIZE/2.0, FRAME_SIZE/2.0);
		// double x = distr.sample();
		// double y = distr.sample();

		// // draw main dot
		// g.fillOval(
		// 	(int) (x + (FRAME_SIZE - MAIN_DOT_DIAM)/2.0),
		// 	(int) (-y + (FRAME_SIZE - MAIN_DOT_DIAM)/2.0),
		// 	MAIN_DOT_DIAM, MAIN_DOT_DIAM
		// );
		// // System.out.println("main dot = (" + x + ", " + y + ")");

		// // calculate incident dot
		// Position pos = new Position(x, y);
		// double theta = pos.toAngle();
		// // System.out.println("theta = " + theta);
		// double incidentX = 
		// 	((OVAL_H/2.0) * (OVAL_W/2.0) * x)
		// 	/
		// 	Math.sqrt(
		// 		(Math.pow(y, 2)*Math.pow(OVAL_W/2.0, 2) + Math.pow(x, 2)*Math.pow(OVAL_H/2.0, 2))
		// 	); 
		// double incidentY = 
		// 	((OVAL_H/2.0) * (OVAL_W/2.0) * y)
		// 	/
		// 	Math.sqrt(
		// 		(Math.pow(y, 2)*Math.pow(OVAL_W/2.0, 2) + Math.pow(x, 2)*Math.pow(OVAL_H/2.0, 2))
		// 	); 
		// // System.out.println("incident dot = (" + incidentX + ", " + incidentY + ")");
		// g.fillOval(
		// 	(int) (incidentX + (FRAME_SIZE - INCIDENT_DOT_DIAM)/2.0),
		// 	(int) (-incidentY + (FRAME_SIZE - INCIDENT_DOT_DIAM)/2.0),
		// 	INCIDENT_DOT_DIAM, INCIDENT_DOT_DIAM
		// );

		// g.drawLine(
		// 	(int) (FRAME_SIZE/2.0), (int) (FRAME_SIZE/2.0), 
		// 	(int) (x + FRAME_SIZE/2.0), (int) (-y + FRAME_SIZE/2.0)
		// );

		// if (1 <= 
		// 	(Math.pow(OVAL_W/2.0, 2)*Math.pow(OVAL_H/2.0, 2))
		// 	/
		// 	(Math.pow(y, 2)*Math.pow(OVAL_W/2.0, 2) + Math.pow(x, 2)*Math.pow(OVAL_H/2.0, 2))
		// ) {
		// 	System.out.println("inside oval");
		// } else {
		// 	System.out.println("outsie oval");
		// }


		// double y = OVAL_H * Math.sqrt(1 - Math.pow(x / (OVAL_W/2.0), 2)) / 2.0;


	}
}