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

public class Particle {

	private int pid;
	private double px;
	private double py;
	private double pz;
	private double vx;
	private double vy;
	private double vz;
	private int charge;
	private double beta;
	private double chi2pid;
	private int status;

	public Particle(int pid, double px, double py, double pz, double vx, double vy, double vz, int charge, double beta,
			double chi2pid, int status) {
		this.pid = pid;
		this.px = px;
		this.py = py;
		this.pz = pz;
		this.vx = vx;
		this.vy = vy;
		this.vz = vz;
		this.charge = charge;
		this.beta = beta;
		this.chi2pid = chi2pid;
		this.status = status;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public double getPx() {
		return px;
	}

	public void setPx(double px) {
		this.px = px;
	}

	public double getPy() {
		return py;
	}

	public void setPy(double py) {
		this.py = py;
	}

	public double getPz() {
		return pz;
	}

	public void setPz(double pz) {
		this.pz = pz;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public double getVz() {
		return vz;
	}

	public void setVz(double vz) {
		this.vz = vz;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public double getBeta() {
		return beta;
	}

	public void setBeta(double beta) {
		this.beta = beta;
	}

	public double getChi2pid() {
		return chi2pid;
	}

	public void setChi2pid(double chi2pid) {
		this.chi2pid = chi2pid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
