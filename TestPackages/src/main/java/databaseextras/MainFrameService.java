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
import java.util.List;

public interface MainFrameService {
	public List<Integer> getRunList();

	public void runWriteProcess();

	public void runScript() throws IOException, InterruptedException;

	public void setWantsToExecute(boolean wantsToExecute);

	public boolean getWantsToExecute();
}
