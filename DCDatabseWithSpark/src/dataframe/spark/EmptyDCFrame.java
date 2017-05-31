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
package dataframe.spark;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import database.util.EmptyDataPoint;

public class EmptyDCFrame {

	public static Dataset<Row> getEmptyDCData() {
		SparkSession spSession = SparkConnection.getSession();
		List<EmptyDataPoint> emptyList = new ArrayList<EmptyDataPoint>();
		for (int superLayer = 1; superLayer <= 6; superLayer++) {
			for (int sector = 2; sector <= 2; sector++) {
				for (int wire = 1; wire <= 112; wire++) {
					for (int layer = 1; layer <= 6; layer++) {
						emptyList.add(new EmptyDataPoint(superLayer, sector, wire, layer));
					}
				}
			}
		}
		Encoder<EmptyDataPoint> multiDataEncoder = Encoders.bean(EmptyDataPoint.class);
		Dataset<Row> df = spSession.createDataset(emptyList, multiDataEncoder).toDF();
		return df;
	}

}
