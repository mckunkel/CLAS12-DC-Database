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
package testing;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import dataframe.spark.SparkConnection;

public class MWE {
	SparkSession spSession = null;
	Dataset<Row> df1 = null;
	Dataset<Row> df2 = null;

	public MWE() {
		Logger.getLogger("org").setLevel(Level.OFF);
		Logger.getLogger("akka").setLevel(Level.OFF);
		this.spSession = SparkConnection.getSession();

		makeDataOne();
		makeDataTwo();
		subtractDF();
	}

	public void makeDataOne() {
		List<DataPool> l1 = new ArrayList<DataPool>();
		for (int i = 0; i < 10; i++) {
			DataPool dataPool = new DataPool(1, 1, i, i + 1);
			l1.add(dataPool);
		}
		Encoder<DataPool> encoder = Encoders.bean(DataPool.class);
		this.df1 = spSession.createDataset(l1, encoder).toDF();
	}

	public void makeDataTwo() {
		List<DataPool> l1 = new ArrayList<DataPool>();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				DataPool dataPool = new DataPool(1, 1, i, i * i);
				l1.add(dataPool);
			} else {
				DataPool dataPool = new DataPool(1, 1, i, i + 1);
				l1.add(dataPool);
			}
		}
		Encoder<DataPool> encoder = Encoders.bean(DataPool.class);
		this.df2 = spSession.createDataset(l1, encoder).toDF();

	}

	public void subtractDF() {
		// first lets view df1 and df2
		System.out.println("df1:");
		df1.show();
		System.out.println("df2:");
		df2.show();

		// lets subtract the datasets and show it
		Dataset<Row> subDf = df1.except(df2);
		System.out.println("subDf:");
		subDf.show();

		// lets subtract the datasets the other way and show it
		Dataset<Row> subDf2 = df2.except(df1);
		System.out.println("subDf2:");
		subDf2.show();

	}

	public static void main(String[] args) {

		MWE mwe = new MWE();

	}
}
