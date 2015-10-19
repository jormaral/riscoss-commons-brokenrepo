package eu.riscoss.rdc;

/**
 * @author Mirko Morandini
 */

import java.util.Collection;

public class LicenseEntryOlex {
	public int count;
	private final String name;
	public String licensetype="unknown";

	public LicenseEntryOlex(int c, String n) {
		count=c;
		name=n;
	}
	public LicenseEntryOlex matches(String s){
		if (name.contains(s))
			return this;
		return null;
	}
	
	private LicenseEntryOlex endsWith(String s){
		if (name.endsWith(s))
			return this;
		return null;
	}
	
	/**
	 * For matching a license string (using endsWith)
	 * @param si list of licenses for a licenseType
	 * @param licenseType e.g. copyleft, permissive, commercial
	 * @return
	 */
	public boolean matchesOneOf(Collection<String> si, String licenseType){
		for (String string : si) {
			if (!string.isEmpty()){
				if (endsWith(string)!=null){
					this.licensetype=licenseType;
					return true;
				}
			}
		}
		return false;
	}
	

	
	/**
	 * returns the first word of the stored name, that matches a license or null if none
	 * @param s the license
	 */
	private String containsWord(String s) {
		String[] wordList = name.trim().split(" ");
		for (String word : wordList) {
			if (word.trim() != null)
				if (word.trim().equalsIgnoreCase(s.trim()))
					return word;
		}
		return null;
	}
	
	@Override
	public String toString(){
		return count+" \t"+name+" \t\tType "+licensetype;
	}
	
	public String getName() {
		return name;
	}
}
