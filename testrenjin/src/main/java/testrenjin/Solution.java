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
package testrenjin;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Solution {
	public int solution(int[] A) {
		int[] arr = {1,2,3,4};
	
        List<Object> list = Arrays.stream(A).boxed().collect(Collectors.toList());
		List<Integer> lista = Arrays.stream(arr).boxed().collect(Collectors.toList());

        System.out.println(lista);
        

}
