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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainFrameServiceImpl implements MainFrameService {
	private List<Integer> runsComplete;
	public boolean wantsToExecute;

	public MainFrameServiceImpl() {
		this.runsComplete = new ArrayList<>();
		this.wantsToExecute = false;
	}

	public List<Integer> getRunList() {
		return this.runsComplete;
	}

	@Override
	public void runWriteProcess() {
		System.out.println("This is the write process");
	}

	public void runScript() throws IOException, InterruptedException {

		System.out.println("I will execute a script here");
		// // String scriptName = "SubmitStatusTablesToCCDB.sh";// Hello.bash
		// String scriptName = "Hello.bash";
		//
		// File file = new File(scriptName);
		//
		// if (file.exists()) {
		// if (!file.canExecute()) {
		// file.setExecutable(true);
		// file.setReadable(true);
		// file.setWritable(true);
		// }
		//
		// String command = "./" + scriptName;
		//
		// ProcessBuilder processBuilder = new ProcessBuilder(command);
		// // Sets the source and destination for subprocess standard I/O to be
		// // the
		// // same as those of the current Java process.
		// processBuilder.inheritIO();
		// Process process = processBuilder.start();
		//
		// int exitValue = process.waitFor();
		// if (exitValue != 0) {
		// // check for errors
		// new BufferedInputStream(process.getErrorStream());
		// throw new RuntimeException("execution of script failed!");
		// }
		// }
	}

	public void setWantsToExecute(boolean wantsToExecute) {
		this.wantsToExecute = wantsToExecute;
	}

	public boolean getWantsToExecute() {
		return wantsToExecute;
	}
}
