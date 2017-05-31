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
package database.objects.dc;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class GsonExample {

	public static void main(String[] args) {

		Test staff = createDummyObject();

		// 1. Convert object to JSON string
		Gson gson = new Gson();
		String json = gson.toJson(staff);
		System.out.println(json);

		// 2. Convert object to JSON string and save into a file directly
		try (FileWriter writer = new FileWriter("staff.json")) {

			gson.toJson(staff, writer);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Test createDummyObject() {

		Test staff = new Test();

		staff.setName("mkyong");
		staff.setAge(35);
		staff.setPosition("Founder");
		staff.setSalary(new BigDecimal("10000"));

		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("python");
		skills.add("shell");

		staff.setSkills(skills);

		return staff;

	}

}
