package com.example.todo.utils;

/**
 * @author invdeshmuk
 *
 */
public class StringUtils {

	/**
	 * Checks If Sting is Empty
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(final String str) {
		return str == null || "".equals(str);
	}

	/**
	 * Checks If Sting is Blank
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(final String str) {
		return str == null || "".equals(str) || "".equals(str.trim());
	}

	/**
	 * Checks If Sting is Not Empty
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(final String str) {
		return !(str == null || "".equals(str));
	}

	/**
	 * Checks If Sting is Not Blank
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(final String str) {
		return !(str == null || "".equals(str) || "".equals(str.trim()));
	}
}
