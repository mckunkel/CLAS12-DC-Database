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

public class ForwardTagger {
	private int index;
	private int pindex;
	private int detector;
	private int size;
	private double x;
	private double y;
	private double z;
	private double dx;
	private double dy;
	private double radius;
	private double path;
	private double time;
	private double energy;
	private double chi2;

	public ForwardTagger(int index, int pindex, int detector, int size, double x, double y, double z, double dx,
			double dy, double radius, double path, double time, double energy, double chi2) {
		this.index = index;
		this.pindex = pindex;
		this.detector = detector;
		this.size = size;
		this.x = x;
		this.y = y;
		this.z = z;
		this.dx = dx;
		this.dy = dy;
		this.radius = radius;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
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
