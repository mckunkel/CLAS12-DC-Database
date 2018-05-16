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

public class TBCovMat {
	private int index;
	private double C11;
	private double C12;
	private double C13;
	private double C14;
	private double C15;
	private double C22;
	private double C23;
	private double C24;
	private double C25;
	private double C33;
	private double C34;
	private double C35;
	private double C44;
	private double C45;
	private double C55;

	public TBCovMat(int index, double c11, double c12, double c13, double c14, double c15, double c22, double c23,
			double c24, double c25, double c33, double c34, double c35, double c44, double c45, double c55) {
		this.index = index;
		C11 = c11;
		C12 = c12;
		C13 = c13;
		C14 = c14;
		C15 = c15;
		C22 = c22;
		C23 = c23;
		C24 = c24;
		C25 = c25;
		C33 = c33;
		C34 = c34;
		C35 = c35;
		C44 = c44;
		C45 = c45;
		C55 = c55;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double getC11() {
		return C11;
	}

	public void setC11(double c11) {
		C11 = c11;
	}

	public double getC12() {
		return C12;
	}

	public void setC12(double c12) {
		C12 = c12;
	}

	public double getC13() {
		return C13;
	}

	public void setC13(double c13) {
		C13 = c13;
	}

	public double getC14() {
		return C14;
	}

	public void setC14(double c14) {
		C14 = c14;
	}

	public double getC15() {
		return C15;
	}

	public void setC15(double c15) {
		C15 = c15;
	}

	public double getC22() {
		return C22;
	}

	public void setC22(double c22) {
		C22 = c22;
	}

	public double getC23() {
		return C23;
	}

	public void setC23(double c23) {
		C23 = c23;
	}

	public double getC24() {
		return C24;
	}

	public void setC24(double c24) {
		C24 = c24;
	}

	public double getC25() {
		return C25;
	}

	public void setC25(double c25) {
		C25 = c25;
	}

	public double getC33() {
		return C33;
	}

	public void setC33(double c33) {
		C33 = c33;
	}

	public double getC34() {
		return C34;
	}

	public void setC34(double c34) {
		C34 = c34;
	}

	public double getC35() {
		return C35;
	}

	public void setC35(double c35) {
		C35 = c35;
	}

	public double getC44() {
		return C44;
	}

	public void setC44(double c44) {
		C44 = c44;
	}

	public double getC45() {
		return C45;
	}

	public void setC45(double c45) {
		C45 = c45;
	}

	public double getC55() {
		return C55;
	}

	public void setC55(double c55) {
		C55 = c55;
	}

}
