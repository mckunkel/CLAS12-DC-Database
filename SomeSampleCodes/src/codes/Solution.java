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
package codes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public int solution(int[] A) {

		List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		int retValue = 0;
		System.out.println("List size is " + list.size() + " and one more is " + (list.size() + 1));
		for (int i = 1; i <= list.size() + 1; i++) {
			System.out.println(i);
			if (!list.contains(i)) {
				retValue = i;
				break;
			}
		}
		return retValue;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = { 1, 2, 3 };
		System.out.println(s.solution(arr));

	}

}