import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Test {
	
	int a = 1;
	String b = "inicio";
	

	public static void main(String[] args) throws ParseException, Exception {
//		testDate();
//		testModifObjets();
//		testModifObjet();
		shouldFindIntruder();
//		testBraces();
	}
	
	static List<String>  open = Arrays.asList("(","{","[");
	static List<String> close = Arrays.asList(")","}","]");
	static List<String> opened = new ArrayList<String>();
	static List<String> closed = new ArrayList<String>();
	
	static Map<String,String> valids = new HashMap<String, String>();
	
	
	public static void testBraces() {
		List<String>  braces = Arrays.asList("([{}])","([}])","(})","(}","()");
		
		for(String brace : braces) {
			if(isValidBrace(brace)) {
				System.out.println("valido");
			} else {
				System.out.println("No valido");
			}
		}
		
	}
	/*
	 * busca el primer valor no repetico
	 */
	
	public static boolean isValidBrace(String braces) {
		valids.put("(", ")");
		valids.put("{", "}");
		valids.put("[", "]");
	
	    boolean isValid = true;
	    char[] charArray = braces.toCharArray();
	    int index = 0;
	    int lastElenem = charArray.length -1;
	    double midd = lastElenem / 2;
	    for(char ch : charArray) {
	    	char aux = charArray[lastElenem];
	    	if(!String.valueOf(aux).equalsIgnoreCase(valids.get(String.valueOf(ch)))){
	    		isValid = false;
	    		break;
	    	}
	    	if(index < midd) {
	    		lastElenem--;
	    	}else {
	    		break;
	    	}
	    	index ++;
	    }
	    
	    return isValid;
	}
	
	public static void shouldFindIntruder() {
	    Integer actual = Test.findIntruder(Arrays.asList(1,1,7,7,8,5,7,8));
	    System.out.println(actual);
	    
	    actual = Test.findIntruder(Arrays.asList(1,1,7,7,8,3,5,7,8));
	    System.out.println(actual);
	  }
	
	public static Integer findIntruder( List<Integer> elements ) {
	    Integer dup = null;
	    for (Integer i : elements){
	    	if(elements.indexOf(i) == elements.lastIndexOf(i)) {
	    		dup = i;
	    		break;
	    	}
	    }
	    return dup;
	  }	
	
	public static void testDate() {
		Date d1 = new Date();
		d1 = new Date(d1.getTime() + TimeUnit.DAYS.toMillis(-1));
		Date d2 = new Date();
		System.out.println("<<<<<<<<<<<<<<   Test Date   <<<<<<<<<<<<<<");
		if (d1BeforeD2(d1, d2)) {
			System.out.println("anterior");
		} else {
			System.out.println("posterior");
		}
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	
	public static void testModifObjets() {
		
		System.out.println("<<<<<<<<<<<<<<   Objetos Primitivos   <<<<<<<<<<<<<<");
		String  a1 = "1";
		String  b1 = a1;
		a1 = "2";
		System.out.println(a1);
		System.out.println(b1);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		System.out.println("<<<<<<<<<<<<<<   Objeto Arary    <<<<<<<<<<<<<<");
		ArrayList<String> lista1 = new ArrayList<String>();
		lista1.add("prueba");
		ArrayList<String> lista2 = new ArrayList<String>();
		lista2.addAll(lista1); // copia los objetos y no modifica la lista original
		lista1.add("otra");
		System.out.println("Lista 1: " + lista1);
		System.out.println("Lista 2: " + lista2);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
	
		int a = 2;
		String b = "StringOrig";
		Integer i = new Integer(1);
		System.out.println("<<<<<<<<<<<<<<       Antes Modif      <<<<<<<<<<<<<<");
		System.out.println("Int: " + a);
		System.out.println("String: " + b);
		System.out.println("Array: " + lista1);
		System.out.println("Integer: " + i);
		
		testModif(a, b, lista1, i);
		
		System.out.println("<<<<<<<<<<<<<<       Modificados      <<<<<<<<<<<<<<");
		System.out.println("Int: " + a);
		System.out.println("String: " + b);
		System.out.println("Array: " + lista1);
		System.out.println("Integer:" + i);
	}
	
	public static void testModifObjet() {
		Test t = new Test();
		t.a = 2;
		t.b = "modif";
		System.out.println("<<<<<<<<<<<<<<       Test Objetos      <<<<<<<<<<<<<<");
		System.out.println("Objeto original: " + t.a + " - " + t.b);
		
		otherTest(t);
		System.out.println("Objeto modificado: " + t.a + " - " + t.b);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	public static void otherTest(Test t) {
//		t = new Test();
		t.a = 5;
		t.b = "modif en metodo";
	}

	public static void testModif(int a, String b, ArrayList<String> c, Integer i) {
		a = 10;
		b = "Modificado";
		c.add("Agregado");
		Integer o = new Integer(2);
		i = o;
	}
	
	public static boolean d1BeforeD2(Date d1, Date d2) {
		if (d1 != null && d2 != null) {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(d1);
			c2.setTime(d2);
			if (c1.get(Calendar.YEAR) <= c2.get(Calendar.YEAR) 
					&& c1.get(Calendar.MONTH) <= c2.get(Calendar.MONDAY)
					&& c1.get(Calendar.DAY_OF_MONTH) < c2.get(Calendar.DAY_OF_MONTH)) {
				return true;
			}
		}
		return false;
	}
}
