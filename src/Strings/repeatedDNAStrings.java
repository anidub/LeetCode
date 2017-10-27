package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class repeatedDNAStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> findRepeatedDnaSequences(String s) {
	    Set seen = new HashSet(), repeated = new HashSet();
	    for (int i = 0; i + 9 < s.length(); i++) {
	        String ten = s.substring(i, i + 10);
	        if (!seen.add(ten))
	            repeated.add(ten);
	    }
	    return new ArrayList(repeated);
	}
}
