
public class blackrock {

	public static void main(String[] args) {
		//System.out.println(en("hello"));
		den(en("hello"));
		

	}
	public static String en(String text){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < text.length(); i++){
			char c = text.charAt(i);
			int ka = c;
			char d = (char) (c+i);
			int k = c + c+i;
			sb.append(c += c+i);
		}
		return sb.reverse().toString();
	}
	
	public static String den(String text){
		StringBuilder sb = new StringBuilder();
		int k = 0;
		for(int i  = text.length()-1; i >= 0; i--){			
			char c = text.charAt(i);
			int aa = (c - k)/2;
			
			sb.append((char)aa);
			k++;
			//sb.append(c -= c-i);
		}
		return sb.toString();
	}
}
