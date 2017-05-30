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
package com.IKP.database.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.jlab.detector.decode.CLASDecoder;
import org.jlab.groot.data.H2F;
import org.jlab.groot.graphics.EmbeddedCanvas;
import org.jlab.io.base.DataBank;
import org.jlab.io.base.DataEvent;
import org.jlab.io.evio.EvioDataEvent;
import org.jlab.io.hipo.HipoDataEvent;
import org.jlab.io.task.DataSourceProcessorPane;
import org.jlab.io.task.IDataEventListener;
import org.jlab.service.dc.DCHBEngine;
import org.jlab.service.dc.DCTBEngine;

import com.IKP.utils.Coordinate;

public class CLAS12MainFrame implements IDataEventListener {

	JPanel mainPanel = null;
	DataSourceProcessorPane processorPane = null;
	private JTabbedPane tabbedPane = null;

	private Map<Coordinate, H2F> occupanciesByCoordinate = new HashMap<Coordinate, H2F>();
	private Map<Coordinate, H2F> occupanciesintrack = new HashMap<Coordinate, H2F>();
	private Map<Coordinate, H2F> occupanciesByMySQL = new HashMap<Coordinate, H2F>();

	private EmbeddedCanvas can1 = null;
	private EmbeddedCanvas can2 = null;

	int counter = 0;
	int updateTime = 2000;

	CLASDecoder clasDecoder = new CLASDecoder();

	DCHBEngine enHB = new DCHBEngine();

	DCTBEngine enTB = new DCTBEngine();

	public CLAS12MainFrame() {

		// create main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		processorPane = new DataSourceProcessorPane();
		processorPane.setUpdateRate(100);

		mainPanel.add(tabbedPane);
		mainPanel.add(processorPane, BorderLayout.PAGE_END);

		this.processorPane.addEventListener(this);

		createCanvas();
		addCanvasToPane();
		init();

		enHB.init();
		enTB.init();
	}

	private void createHistograms() {

		for (int i = 0; i < 6; i++) {

			for (int j = 0; j < 6; j++) {
				occupanciesByCoordinate.put(new Coordinate(i, j),
						new H2F("Occupancy all hits SL" + i + "sector" + j, "", 112, 1, 113, 6, 1, 7));
				occupanciesByCoordinate.get(new Coordinate(i, j)).setTitleX("Wire Sector" + (j + 1));
				occupanciesByCoordinate.get(new Coordinate(i, j)).setTitleY("Layer SL" + (i + 1));
				occupanciesintrack.put(new Coordinate(i, j),
						new H2F("Occupancy used in track" + i, "", 112, 1, 113, 6, 1, 7));
				occupanciesintrack.get(new Coordinate(i, j)).setTitleX("Wire Sector" + (j + 1));
				occupanciesintrack.get(new Coordinate(i, j)).setTitleY("Layer SL" + (i + 1));

				occupanciesByMySQL.put(new Coordinate(i, j),
						new H2F("Occupancy all hits SL" + i + "sector" + j, "", 112, 1, 113, 6, 1, 7));
				occupanciesByMySQL.get(new Coordinate(i, j)).setTitleX("Wire Sector" + (j + 1));
				occupanciesByMySQL.get(new Coordinate(i, j)).setTitleY("Layer SL" + (i + 1));

			}
		}
	}

	private void createCanvas() {
		can1 = new EmbeddedCanvas();
		can1.initTimer(updateTime);
		can2 = new EmbeddedCanvas();
		can2.initTimer(updateTime);

		can1.divide(6, 6);
		can2.divide(6, 6);

	}

	private void init() {
		createHistograms();
		drawPlots();
	}

	@Override
	public void dataEventAction(DataEvent event) {
		counter++;
		// if (counter % 200 == 0)
		// System.out.println("done " + counter + " events");

		HipoDataEvent hipo = null;
		if (event instanceof EvioDataEvent) { // starting from raw event
			hipo = (HipoDataEvent) clasDecoder.getDataEvent(event);
		} else {
			hipo = (HipoDataEvent) event;
		}
		if (hipo.getBank("TimeBasedTrkg::TBHits").rows() == 0 && hipo.getBank("DC::tdc").rows() > 0) {
			// run HBT
			enHB.processDataEvent(hipo);
			// Processing TBT
			enTB.processDataEvent(hipo);
			// hipo.show();
		}
		if (hipo.hasBank("TimeBasedTrkg::TBHits"))
			processTBHits(event);
	}

	@Override
	public void timerUpdate() {
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void resetEventListener() {
		counter = 0;
		this.init();
	}

	private void processTBHits(DataEvent event) {
		DataBank bnkHits = event.getBank("TimeBasedTrkg::TBHits");

		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();

		for (int i = 0; i < bnkHits.rows(); i++) {
			occupanciesByCoordinate
					.get(new Coordinate(bnkHits.getInt("superlayer", i) - 1, bnkHits.getInt("sector", i) - 1))
					.fill(bnkHits.getInt("wire", i), bnkHits.getInt("layer", i));

			if (bnkHits.getByte("trkID", i) > 0) {
				occupanciesintrack
						.get(new Coordinate(bnkHits.getInt("superlayer", i) - 1, bnkHits.getInt("sector", i) - 1))
						.fill(bnkHits.getInt("wire", i), bnkHits.getInt("layer", i));
			}

			int key = bnkHits.getInt("trkID", i);
			if (key > 0) {
				if (map1.containsKey(key)) {
					int occurrence = map1.get(key);
					occurrence++;
					map1.put(bnkHits.getInt("trkID", i), occurrence);
				} else
					map1.put(key, 1);
				map2.put(key, bnkHits.getInt("sector", i));
			}
		}
	}

	private void drawPlots() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				can1.cd(6 * i + j);
				can1.draw(occupanciesByCoordinate.get(new Coordinate(i, j)));
				can2.cd(6 * i + j);
				can2.draw(occupanciesintrack.get(new Coordinate(i, j)));
			}
		}
		can1.update();
		can2.update();
	}

	private void addCanvasToPane() {
		tabbedPane.add("Occupancies all", can1);
		tabbedPane.add("Occupancies track", can2);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("DC DataBase");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screensize = null;
		screensize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize((int) (screensize.getHeight() * .75 * 1.618), (int) (screensize.getHeight() * .75));
		CLAS12MainFrame viewer = new CLAS12MainFrame();
		// frame.add(viewer.getPanel());
		frame.add(viewer.mainPanel);
		frame.setVisible(true);

	}

}
