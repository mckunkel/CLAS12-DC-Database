/*  +__^_________,_________,_____,________^-.-------------------,
 *  | |||||||||   `--------'     |          |                   O
 *  `+-------------USMC----------^----------|___________________|
 *    `\_,---------,---------,--------------'
 *      / X MK X /'|       /'
 *     / X MK X /  `\    /'
 *    / X MK X /`-------'
 *   / X MK X /
 *  / X MK X /
 * (________(                @author m.c.kunkel
 *  `------'
*/
package clas12.event;

public class Scintillator {
	private int index;
	private int pindex;
	private int detector;
	private int sector;
	private int layer;
	private int component;
	private double x;
	private double y;
	private double z;
	private double hx;
	private double hy;
	private double hz;
	private double path;
	private double time;
	private double energy;
	private double chi2;

	public Scintillator(int index, int pindex, int detector, int sector, int layer, int component, double x, double y,
			double z, double hx, double hy, double hz, double path, double time, double energy, double chi2) {
		this.index = index;
		this.pindex = pindex;
		this.detector = detector;
		this.sector = sector;
		this.layer = layer;
		this.component = component;
		this.x = x;
		this.y = y;
		this.z = z;
		this.hx = hx;
		this.hy = hy;
		this.hz = hz;
		this.path = path;
		this.time = time;
		this.energy = energy;
		this.chi2 = chi2;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPindex() {
		return pindex;
	}

	public void setPindex(int pindex) {
		this.pindex = pindex;
	}

	public int getDetector() {
		return detector;
	}

	public void setDetector(int detector) {
		this.detector = detector;
	}

	public int getSector() {
		return sector;
	}

	public void setSector(int sector) {
		this.sector = sector;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getComponent() {
		return component;
	}

	public void setComponent(int component) {
		this.component = component;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getHx() {
		return hx;
	}

	public void setHx(double hx) {
		this.hx = hx;
	}

	public double getHy() {
		return hy;
	}

	public void setHy(double hy) {
		this.hy = hy;
	}

	public double getHz() {
		return hz;
	}

	public void setHz(double hz) {
		this.hz = hz;
	}

	public double getPath() {
		return path;
	}

	public void setPath(double path) {
		this.path = path;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public double getChi2() {
		return chi2;
	}

	public void setChi2(double chi2) {
		this.chi2 = chi2;
	}

}
