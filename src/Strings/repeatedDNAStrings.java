package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
https://leetcode.com/problems/repeated-dna-sequences/description/
https://discuss.leetcode.com/topic/27517/7-lines-simple-java-o-n
 */
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
