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
package com.IKP.utils;

public class ConsistencyCheck {

	public static boolean isBoolean(Object object, byte value) {

		if (value == 1 || value == 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		ConsistencyCheck check = new ConsistencyCheck();
		boolean isWorking = isBoolean(check, (byte) 1);
		System.err.println("not a boolean " + isWorking + "this class name is " + check.getClass().getSimpleName());
	}

}
