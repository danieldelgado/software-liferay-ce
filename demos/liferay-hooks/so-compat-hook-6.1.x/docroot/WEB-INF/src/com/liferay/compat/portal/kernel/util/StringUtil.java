package com.liferay.compat.portal.kernel.util;

import com.liferay.portal.kernel.util.LocaleUtil;

import java.util.Locale;

/**
 * @author Brian Wing Shun Chan
 */
public class StringUtil extends com.liferay.portal.kernel.util.StringUtil {

	public static boolean equalsIgnoreCase(String s1, String s2) {
		if (s1 == s2) {
			return true;
		}

		if ((s1 == null) || (s2 == null)) {
			return false;
		}

		if (s1.length() != s2.length()) {
			return false;
		}

		for (int i = 0; i < s1.length(); i++) {
			char c1 = s1.charAt(i);

			char c2 = s2.charAt(i);

			if (c1 == c2) {
				continue;
			}

			if ((c1 > 127) || (c2 > 127)) {
				return s1.equalsIgnoreCase(s2);
			}

			int delta = c1 - c2;

			if ((delta != 32) && (delta != -32)) {
				return false;
			}
		}

		return true;
	}

	public static String toLowerCase(String s) {
		return toLowerCase(s, null);
	}

	public static String toLowerCase(String s, Locale locale) {
		StringBuilder sb = null;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c > 127) {

				// Found non-ascii char, fallback to the slow unicode detection

				if (locale == null) {
					locale = LocaleUtil.getDefault();
				}

				return s.toLowerCase(locale);
			}

			if ((c >= 'A') && (c <= 'Z')) {
				if (sb == null) {
					sb = new StringBuilder(s);
				}

				sb.setCharAt(i, (char)(c + 32));
			}
		}

		if (sb == null) {
			return s;
		}

		return sb.toString();
	}

	public static String toUpperCase(String s) {
		return toUpperCase(s, null);
	}

	public static String toUpperCase(String s, Locale locale) {
		StringBuilder sb = null;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c > 127) {

				// Found non-ascii char, fallback to the slow unicode detection

				if (locale == null) {
					locale = LocaleUtil.getDefault();
				}

				return s.toLowerCase(locale);
			}

			if ((c >= 'a') && (c <= 'z')) {
				if (sb == null) {
					sb = new StringBuilder(s);
				}

				sb.setCharAt(i, (char)(c - 32));
			}
		}

		if (sb == null) {
			return s;
		}

		return sb.toString();
	}

}