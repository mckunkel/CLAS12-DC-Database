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

public class TrackCross {

	private int index;
	private int pindex;
	private int detector;
	private int sector;
	private int layer;
	private double c_x;
	private double c_y;
	private double c_z;
	private double c_ux;
	private double c_uy;
	private double c_uz;

	public TrackCross(int index, int pindex, int detector, int sector, int layer, double c_x, double c_y, double c_z,
			double c_ux, double c_uy, double c_uz) {
		this.index = index;
		this.pindex = pindex;
		this.detector = detector;
		this.sector = sector;
		this.layer = layer;
		this.c_x = c_x;
		this.c_y = c_y;
		this.c_z = c_z;
		this.c_ux = c_ux;
		this.c_uy = c_uy;
		this.c_uz = c_uz;
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

	public double getC_x() {
		return c_x;
	}

	public void setC_x(double c_x) {
		this.c_x = c_x;
	}

	public double getC_y() {
		return c_y;
	}

	public void setC_y(double c_y) {
		this.c_y = c_y;
	}

	public double getC_z() {
		return c_z;
	}

	public void setC_z(double c_z) {
		this.c_z = c_z;
	}

	public double getC_ux() {
		return c_ux;
	}

	public void setC_ux(double c_ux) {
		this.c_ux = c_ux;
	}

	public double getC_uy() {
		return c_uy;
	}

	public void setC_uy(double c_uy) {
		this.c_uy = c_uy;
	}

	public double getC_uz() {
		return c_uz;
	}

	public void setC_uz(double c_uz) {
		this.c_uz = c_uz;
	}

}
