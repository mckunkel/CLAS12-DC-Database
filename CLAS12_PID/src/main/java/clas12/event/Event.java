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

public class Event {
	private int NRUN;
	private int NEVENT;
	private double EVNTime;
	private int TYPE;
	private int EvCAT;
	private int NPGP;
	private int TRG;
	private int L1;
	private int L2;
	private int L3;
	private double FC;
	private double FCG;
	private double CLOCK;
	private double CLOCKG;
	private double STTime;
	private double RFTime;
	private int Helic;
	private int PSync;
	private int TSett;
	private int Pattern;
	private int HelicD;
	private double PTIME;

	public Event(int nRUN, int nEVENT, double eVNTime, int tYPE, int evCAT, int nPGP, int tRG, int l1, int l2, int l3,
			double fC, double fCG, double cLOCK, double cLOCKG, double sTTime, double rFTime, int helic, int pSync,
			int tSett, int pattern, int helicD, double pTIME) {
		NRUN = nRUN;
		NEVENT = nEVENT;
		EVNTime = eVNTime;
		TYPE = tYPE;
		EvCAT = evCAT;
		NPGP = nPGP;
		TRG = tRG;
		L1 = l1;
		L2 = l2;
		L3 = l3;
		FC = fC;
		FCG = fCG;
		CLOCK = cLOCK;
		CLOCKG = cLOCKG;
		STTime = sTTime;
		RFTime = rFTime;
		Helic = helic;
		PSync = pSync;
		TSett = tSett;
		Pattern = pattern;
		HelicD = helicD;
		PTIME = pTIME;
	}

	public int getNRUN() {
		return NRUN;
	}

	public void setNRUN(int nRUN) {
		NRUN = nRUN;
	}

	public int getNEVENT() {
		return NEVENT;
	}

	public void setNEVENT(int nEVENT) {
		NEVENT = nEVENT;
	}

	public double getEVNTime() {
		return EVNTime;
	}

	public void setEVNTime(double eVNTime) {
		EVNTime = eVNTime;
	}

	public int getTYPE() {
		return TYPE;
	}

	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}

	public int getEvCAT() {
		return EvCAT;
	}

	public void setEvCAT(int evCAT) {
		EvCAT = evCAT;
	}

	public int getNPGP() {
		return NPGP;
	}

	public void setNPGP(int nPGP) {
		NPGP = nPGP;
	}

	public int getTRG() {
		return TRG;
	}

	public void setTRG(int tRG) {
		TRG = tRG;
	}

	public int getL1() {
		return L1;
	}

	public void setL1(int l1) {
		L1 = l1;
	}

	public int getL2() {
		return L2;
	}

	public void setL2(int l2) {
		L2 = l2;
	}

	public int getL3() {
		return L3;
	}

	public void setL3(int l3) {
		L3 = l3;
	}

	public double getFC() {
		return FC;
	}

	public void setFC(double fC) {
		FC = fC;
	}

	public double getFCG() {
		return FCG;
	}

	public void setFCG(double fCG) {
		FCG = fCG;
	}

	public double getCLOCK() {
		return CLOCK;
	}

	public void setCLOCK(double cLOCK) {
		CLOCK = cLOCK;
	}

	public double getCLOCKG() {
		return CLOCKG;
	}

	public void setCLOCKG(double cLOCKG) {
		CLOCKG = cLOCKG;
	}

	public double getSTTime() {
		return STTime;
	}

	public void setSTTime(double sTTime) {
		STTime = sTTime;
	}

	public double getRFTime() {
		return RFTime;
	}

	public void setRFTime(double rFTime) {
		RFTime = rFTime;
	}

	public int getHelic() {
		return Helic;
	}

	public void setHelic(int helic) {
		Helic = helic;
	}

	public int getPSync() {
		return PSync;
	}

	public void setPSync(int pSync) {
		PSync = pSync;
	}

	public int getTSett() {
		return TSett;
	}

	public void setTSett(int tSett) {
		TSett = tSett;
	}

	public int getPattern() {
		return Pattern;
	}

	public void setPattern(int pattern) {
		Pattern = pattern;
	}

	public int getHelicD() {
		return HelicD;
	}

	public void setHelicD(int helicD) {
		HelicD = helicD;
	}

	public double getPTIME() {
		return PTIME;
	}

	public void setPTIME(double pTIME) {
		PTIME = pTIME;
	}

}
