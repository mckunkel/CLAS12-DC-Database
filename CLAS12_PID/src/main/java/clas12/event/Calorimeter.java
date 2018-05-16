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

public class Calorimeter {
	private int index;
	private int pindex;
	private int detector;
	private int sector;
	private int layer;
	private double x;
	private double y;
	private double z;
	private double hx;
	private double hy;
	private double hz;
	private double lu;
	private double lv;
	private double lw;
	private double du;
	private double dv;
	private double dw;
	private double m2u;
	private double m2v;
	private double m2w;
	private double path;
	private double time;
	private double energy;
	private double chi2;

	public Calorimeter(int index, int pindex, int detector, int sector, int layer, double x, double y, double z,
			double hx, double hy, double hz, double lu, double lv, double lw, double du, double dv, double dw,
			double m2u, double m2v, double m2w, double path, double time, double energy, double chi2) {
		this.index = index;
		this.pindex = pindex;
		this.detector = detector;
		this.sector = sector;
		this.layer = layer;
		this.x = x;
		this.y = y;
		this.z = z;
		this.hx = hx;
		this.hy = hy;
		this.hz = hz;
		this.lu = lu;
		this.lv = lv;
		this.lw = lw;
		this.du = du;
		this.dv = dv;
		this.dw = dw;
		this.m2u = m2u;
		this.m2v = m2v;
		this.m2w = m2w;
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

	public double getLu() {
		return lu;
	}

	public void setLu(double lu) {
		this.lu = lu;
	}

	public double getLv() {
		return lv;
	}

	public void setLv(double lv) {
		this.lv = lv;
	}

	public double getLw() {
		return lw;
	}

	public void setLw(double lw) {
		this.lw = lw;
	}

	public double getDu() {
		return du;
	}

	public void setDu(double du) {
		this.du = du;
	}

	public double getDv() {
		return dv;
	}

	public void setDv(double dv) {
		this.dv = dv;
	}

	public double getDw() {
		return dw;
	}

	public void setDw(double dw) {
		this.dw = dw;
	}

	public double getM2u() {
		return m2u;
	}

	public void setM2u(double m2u) {
		this.m2u = m2u;
	}

	public double getM2v() {
		return m2v;
	}

	public void setM2v(double m2v) {
		this.m2v = m2v;
	}

	public double getM2w() {
		return m2w;
	}

	public void setM2w(double m2w) {
		this.m2w = m2w;
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
