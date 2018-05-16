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
package databaseextras;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteScript {

	public static void main(String[] args) {

		ExecuteScript obj = new ExecuteScript();
		try {
			obj.runScript();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void runScript() throws IOException, InterruptedException {
		ProcessBuilder processBuilder = new ProcessBuilder("./exampleJavaShell.sh");
		// Sets the source and destination for subprocess standard I/O to be the
		// same as those of the current Java process.
		processBuilder.inheritIO();
		Process process = processBuilder.start();

		int exitValue = process.waitFor();
		if (exitValue != 0) {
			// check for errors
			new BufferedInputStream(process.getErrorStream());
			throw new RuntimeException("execution of script failed!");
		}
	}

	private void MethodI() {
		String domainName = "google.com";

		StringBuilder command = new StringBuilder();
		command.append("setenv CCDB_CONNECTION mysql://clas12writer:geom3try@clasdb.jlab.org/clas12 \n");
		command.append(
				"ccdb add calibration/dc/tracking/wire_status -r 102-2147483647 Run_3432.txt #from java script 1 \n");
		command.append(
				"ccdb add calibration/dc/tracking/wire_status -r 103-2147483647 Run_3432.txt #from java script 2 \n");
		command.append(
				"ccdb add calibration/dc/tracking/wire_status -r 104-2147483647 Run_3432.txt #from java script 3 \n");

		System.out.println(command.toString());
		String output = this.executeCommand(command.toString());

		System.out.println(output);
	}

	private void MethodII() {
		String scriptName = "/myScript.sh";
		String commands[] = new String[] { scriptName, "myArg1", "myArg2" };

		Runtime rt = Runtime.getRuntime();
		Process process = null;
		try {
			process = rt.exec(commands);
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

}
