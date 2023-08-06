package com.systelab.kata;

import java.util.StringTokenizer;

/**
 * 
 * Class to help to deal with Strings. It allowes to convert and String[] to String and back. [Util to
 * encode/decode PK to be send back and forward]
 */
public class StringHelper {

    /*
     * TO UNDERSTANT HOW THIS CLASS WORKS HAVE A LOOK AT THE UNIT TEST.
     * 
     * {"hola" "lala"} encodes into "hola_lala" {"hola$1_$2_" "_lala_"} encodes into "hola$11$2$12$2_$2lala$2"
     */
    private static String SEPARATOR = "_";
    private static String REPLACER = "$";
    private static String SEPARATOR_REPLACER = "$2";
    private static String REPLACER_REPLACER = "$1";

    private StringHelper() {
    }

    /**
     * Decodes a String into String[]. If it has been encode using StringHelper.StringArrayToString.
     * 
     * @param str
     *            String to decode.
     * @return String[]. i.e hola_que_tal <br>
     *         returns {"hola","que","tal"}
     */
    public static String[] stringToStringArray(String str) {
	java.util.ArrayList stringArray = new java.util.ArrayList();
	int fromPos = 0;
	int toPos;
	toPos = str.indexOf(SEPARATOR);
	while (toPos != -1) {
	    stringArray.add((str.substring(fromPos, toPos)));
	    fromPos = toPos + 1;
	    toPos = str.indexOf(SEPARATOR, fromPos);
	}
	stringArray.add((str.substring(fromPos)));

	return (String[]) stringArray.toArray(new String[stringArray.size()]);
    }

    /**
     * Encodes String[] into String. You can use StringHelper.StringToStringArray after to reverse.
     * 
     * @param stringArray
     *            String[] to encode.
     * @return decode String. i.e {"hola","que","tal"} <br>
     *         returns hola_que_tal
     */
    public static String stringArrayToString(String[] stringArray) {
	// It would be good if all parsers had a format.
	StringBuilder sb = new StringBuilder("");

	if (stringArray.length > 0) {
	    sb.append((stringArray[0]));
	    for (int i = 1; i < stringArray.length; ++i) {
		sb.append(SEPARATOR);
		sb.append((stringArray[i]));
	    }
	}
	return sb.toString();
    }

    /**
     * It replaces subString into String.
     * 
     * @param s
     *            original string.
     * @param oldToken
     *            searchString.
     * @param newToken
     *            replaceString.
     * @return new replaced string.
     */
    public static String replaceSubString(String s, String oldToken, String newToken) {
	// recursive funtion to replace strings.
	return replaceSubString(s, oldToken, newToken, 0);
    }

    /**
     * set string ready for javaScript messaging. Post: all occurrences of a single quote (') are replaced with the
     * 2-character string (\').
     */
    public static String cleanForJavaScript(String str) {
	return replaceSubString(replaceSubString(str, "'", "\\'"), "\n", "<br>");
    }

    /**
     * It replaces subString into String.
     * 
     * @param s
     *            original string.
     * @param oldToken
     *            searchString.
     * @param newToken
     *            replaceString.
     * @param fromPos
     *            position where to start replacing.
     * @return new replaced string.
     */
    public static String replaceSubString(String s, String oldToken, String newToken, int fromPos) {

		// recursive funtion to replace strings.
	if (s == null || oldToken == null || newToken == null) {
	    return s;
	}
	int tokenPos = s.indexOf(oldToken, fromPos);
	if (tokenPos == -1) {
	    return s;
	}
	String start = s.substring(0, tokenPos);
	String end = s.substring(tokenPos + oldToken.length());
	return replaceSubString(start + newToken + end, oldToken, newToken, tokenPos + newToken.length());
    }

    /**
     * Null-safe concatenation of Strings. If one of the two Strings is null, returns the other. If both are,
     * returns null. Otherwise, the regular concatenation
     * 
     * @param s1
     *            can be null
     * @param s2
     *            can be null
     * @return the concatenation of both - only null if both parameters are
     */
    public static String concatenate(String s1, String s2) {
	if (s1 == null && s2 != null)
	    return s2;
	else if (s1 != null && s2 == null)
	    return s1;
	else if (s1 != null && s2 != null)
	    return s1 + s2;
	else
	    return null;
    }

    /**
     * @param s
     * @return true iff the string is not null and is at least 1 character long
     */
    public static boolean hasValue(String s) {
	return s != null && s.length() > 0;
    }

    /**
     * Return the same string if it is not null nor empty. Otherwise returns the empty string
     * 
     * @param s
     *            - can be null
     * @return a String - never null
     * @see #hasValue(String)
     */
    public static String getSafeValue(String s) {
	return hasValue(s) ? s : "";
    }

    /**
     * @param string
     * @return String trimmed without the front 0s.
     */
    public static String getStringWithoutFrontZeros(String string) {
	String aux = string.trim();
	int index = 0;
	// check if string has '%' at the first position. If yes, set index to 1
	// LIS ID: user can search for %000123. This method should return %123
	boolean hasPercentage = false;
	if (aux.charAt(0) == '%') {
	    aux = aux.substring(1); // take out '%'
	    hasPercentage = true;
	}
	while (index < aux.length() && aux.charAt(index) == '0')
	    index++;
	String res = aux.substring(index);
	if (hasPercentage) {
	    res = '%' + res;
	}
	return res;
    }

}
