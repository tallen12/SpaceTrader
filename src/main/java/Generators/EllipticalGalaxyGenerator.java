package Generators;

import model.Galaxy;
import model.Position;
import model.StarType;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;

//#todo account for min distance between systems

/**
 * @author Michael Lane
 */
public class EllipticalGalaxyGenerator extends GalaxyGenerator {

	private double _xSD;
	private double _ySD;
	private double _xBound;
	private double _yBound;
	private double _tiltRads;

	/**
	 * Maybe use this for experimenting?
	 */
    public EllipticalGalaxyGenerator(
        String name, 
        int numSystems,
        double xSD,
        double ySD,
        double xBound,
        double yBound,
        double tiltRads) {
		
        super(name, numSystems);
		setXSD(xSD);
		setYSD(ySD);
		setXBound(xBound);
		setYBound(yBound);
		setTiltRads(tiltRads);
    }
        

	/**
	 * 
	 */
	public EllipticalGalaxyGenerator(
		String name, 
		double systemNumMean, 
		double systemNumSD,
		double xSD,
		double ySD,
		double xBound,
		double yBound,
		double tiltRads) {

		super(name, systemNumMean, systemNumSD);
		setXSD(xSD);
		setYSD(ySD);
		setXBound(xBound);
		setYBound(yBound);
		setTiltRads(tiltRads);

	}

    @Override
	public Galaxy generate() {

		NormalDistribution xDistr = new NormalDistribution(0, _xSD);
		NormalDistribution yDistr = new NormalDistribution(0, _ySD);
		Galaxy gax = new Galaxy();
		
		for (int i = 0; i < numSystems; i++) {


			// randomly generate position
			double x = xDistr.sample();
			double y = yDistr.sample();
			Position pos = new Position(x, y);

			// if this position is too far away from the origin, then loop again
			if (1 >
				(Math.pow(_xBound, 2)*Math.pow(_yBound, 2))
				/
				(Math.pow(y, 2)*Math.pow(_xBound, 2) + Math.pow(x, 2)*Math.pow(_yBound, 2))
			) {
				i--;			

			// otherwise make the system in all its glory
			} else {
				pos = pos.rotate(_tiltRads);
				StarType starType;
				StarSystemGenerator systemGen = 
					new SimpleStarSystemGenerator("TempName", pos, 9, 2, 100, 20, 9*100*1.5, gax);
				gax.addSystem(systemGen.generate());
			}
		}
                
		return gax;
	}

	public final void setXSD(double xSD) {

		if (xSD <= 0) {
			throw new IllegalArgumentException("xSD must be positive");
		}
		_xSD = xSD;
	}

	public final void setYSD(double ySD) {

		if (ySD <= 0) {
			throw new IllegalArgumentException("ySD must be positive");
		}
		_ySD = ySD;
	}

	public final void setXBound(double xBound) {

		if (xBound <= 0) {
			throw new IllegalArgumentException("xBound must be positive");
		}
		_xBound = xBound;
	}

	public final void setYBound(double yBound) {

		if (yBound <= 0) {
			throw new IllegalArgumentException("yBound must be positive");
		}
		_yBound = yBound;
	}

	public final void setTiltRads(double tiltRads) {

		_tiltRads = tiltRads;
	}
}