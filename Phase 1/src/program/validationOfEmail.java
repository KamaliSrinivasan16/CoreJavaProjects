package program;
import java.util.*;
import java.util.regex.*;

public class validationOfEmail {

	public static void main(String[] args) {
		
		ArrayList<String> email = new ArrayList<String>();
		
		System.out.println("Validation of an e-mail: \n");
		
		//mails id
		email.add("abcd@email.com");
		email.add("ab_cd@email.com");
		email.add("ab*cd@emailcom");
		email.add("a.bc-d@email.com");
		email.add("_abcd_@email.co.in");
		email.add("ab#cd@email.com");
		
		String a = "^[A-Za-z0-9_.-]+@(.+)$";
		
		Pattern p = Pattern.compile(a);
		
		for(String s : email)
		{
			Matcher m = p.matcher(s);
			System.out.println(s+" : "+m.matches()+"\n");
		}

	}

}
