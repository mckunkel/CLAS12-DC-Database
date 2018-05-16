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

public class Cherenkov {
	private int index;
	private int pindex;
	private int detector;
	private int sector;
	private double x;
	private double y;
	private double z;
	private double theta;
	private double phi;
	private double dtheta;
	private double dphi;
	private double path;
	private double time;
	private int nphe;
	private double chi2;

	public Cherenkov(int index, int pindex, int detector, int sector, double x, double y, double z, double theta,
			double phi, double dtheta, double dphi, double path, double time, int nphe, double chi2) {
		this.index = index;
		this.pindex = pindex;
		this.detector = detector;
		this.sector = sector;
		this.x = x;
		this.y = y;
		this.z = z;
		this.theta = theta;
		this.phi = phi;
		this.dtheta = dtheta;
		this.dphi = dphi;
		this.path = path;
		this.time = time;
		this.nphe = nphe;
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

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getPhi() {
		return phi;
	}

	public void setPhi(double phi) {
		this.phi = phi;
	}

	public double getDtheta() {
		return dtheta;
	}

	public void setDtheta(double dtheta) {
		this.dtheta = dtheta;
	}

	public double getDphi() {
		return dphi;
	}

	public void setDphi(double dphi) {
		this.dphi = dphi;
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

	public int getNphe() {
		return nphe;
	}

	public void setNphe(int nphe) {
		this.nphe = nphe;
	}

	public double getChi2() {
		return chi2;
	}

	public void setChi2(double chi2) {
		this.chi2 = chi2;
	}

}
