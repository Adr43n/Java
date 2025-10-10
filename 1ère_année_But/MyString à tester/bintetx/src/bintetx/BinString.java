package bintetx;

public class BinString {
	 public String convert(String s) { return binarise(sum(s)); }
	 public int sum(String s) {
	 if (s == null || s=="") return 0;
	 if (s.length ()==1) return charToInt(s.charAt(0));
	 return charToInt(s.charAt(s.length()-1)) +
	 10 * sum(s.substring(0, s.length() -1));
	 }
	 public String binarise(int x) {
	 if (x==0) return "";
	 if (x%2==1) return binarise(x/2) + "1";
	 return binarise(x/2) + "0";
	 }

	 private int charToInt(char c) {
	 if (c < '0' || c > '9') throw new IllegalArgumentException();
	 return (c - '0');
	 }
	}

