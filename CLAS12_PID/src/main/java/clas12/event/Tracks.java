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

public class Tracks {

	private int index;
	private int pindex;
	private int detector;
	private int status;
	private int q;
	private double px_nomm;
	private double py_nomm;
	private double pz_nomm;
	private double vx_nomm;
	private double vy_nomm;
	private double vz_nomm;
	private double NDF_nomm;
	private double NDF;
	private double chi2_nomm;
	private double chi2;

	public Tracks(int index, int pindex, int detector, int status, int q, double px_nomm, double py_nomm,
			double pz_nomm, double vx_nomm, double vy_nomm, double vz_nomm, double nDF_nomm, double nDF,
			double chi2_nomm, double chi2) {
		this.index = index;
		this.pindex = pindex;
		this.detector = detector;
		this.status = status;
		this.q = q;
		this.px_nomm = px_nomm;
		this.py_nomm = py_nomm;
		this.pz_nomm = pz_nomm;
		this.vx_nomm = vx_nomm;
		this.vy_nomm = vy_nomm;
		this.vz_nomm = vz_nomm;
		NDF_nomm = nDF_nomm;
		NDF = nDF;
		this.chi2_nomm = chi2_nomm;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getQ() {
		return q;
	}

	public void setQ(int q) {
		this.q = q;
	}

	public double getPx_nomm() {
		return px_nomm;
	}

	public void setPx_nomm(double px_nomm) {
		this.px_nomm = px_nomm;
	}

	public double getPy_nomm() {
		return py_nomm;
	}

	public void setPy_nomm(double py_nomm) {
		this.py_nomm = py_nomm;
	}

	public double getPz_nomm() {
		return pz_nomm;
	}

	public void setPz_nomm(double pz_nomm) {
		this.pz_nomm = pz_nomm;
	}

	public double getVx_nomm() {
		return vx_nomm;
	}

	public void setVx_nomm(double vx_nomm) {
		this.vx_nomm = vx_nomm;
	}

	public double getVy_nomm() {
		return vy_nomm;
	}

	public void setVy_nomm(double vy_nomm) {
		this.vy_nomm = vy_nomm;
	}

	public double getVz_nomm() {
		return vz_nomm;
	}

	public void setVz_nomm(double vz_nomm) {
		this.vz_nomm = vz_nomm;
	}

	public double getNDF_nomm() {
		return NDF_nomm;
	}

	public void setNDF_nomm(double nDF_nomm) {
		NDF_nomm = nDF_nomm;
	}

	public double getNDF() {
		return NDF;
	}

	public void setNDF(double nDF) {
		NDF = nDF;
	}

	public double getChi2_nomm() {
		return chi2_nomm;
	}

	public void setChi2_nomm(double chi2_nomm) {
		this.chi2_nomm = chi2_nomm;
	}

	public double getChi2() {
		return chi2;
	}

	public void setChi2(double chi2) {
		this.chi2 = chi2;
	}

}
