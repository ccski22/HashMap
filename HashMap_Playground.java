package assignment3_f20;

public class HashMap_Playground {
/*
 * you will test your own HashMap implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create TreeMap objects,
 * put data into them, take data out, look for values stored
 * in it, checking size, and looking at the HMCells to see if they 
 * are all linked up correctly chains in the hash table
 * 
*/
	public static int hash (String key, int tabSize) {
	    int hval = 7;
	    for (int i=0; i<key.length(); i++) {
	      hval = (hval*31) + key.charAt(i);
	    }
	    hval = hval % tabSize;
	    if (hval<0) { hval += tabSize; }
	    return hval;
	  }
  public static void main(String[] args) {
    // sample manual tests are shown
    // it is up to you to test it thoroughly and make sure
    // the methods behave as requested above in the interface
  
    // do not simple depend on the oracle test we will give
    // use the oracle tests as a way of checking AFTER you have done
    // your own testing
	  
	  
/* I and S hash to the same index
 * so, we need to check if S is chained on correctly
 */
	  /*
	 HashMap oracle = new HashMap_imp(2);
	 Value v1 = new Value_imp(1, 100, 20);
	 Value v2 = new Value_imp(2, 100, 20);
	 System.out.println(oracle.put("I", v1)); // expect null
	 System.out.println(oracle.hasKey("S")); // expect false
	 System.out.println(oracle.put("S", v2)); // expect null
	 System.out.println(oracle.hasKey("S")); // expect true
	 System.out.println(oracle.size()); // expected 2
	 */
	
    HashMap hm = new HashMap_imp(40);
    
    
    System.out.println("testing sizes, expect 40 and 0");
    System.out.println(hm.getTable().length); // expect 40
    System.out.println(hm.size()); // expect 0

   Value v1 = new Value_imp(12345, 87.3, 21);
    Value v2 = new Value_imp(23456, 75.54, 25);
    Value v3 = new Value_imp(34567, 99.013, 19);
    Value v4 = new Value_imp(45678, 55.70, 35);
    Value v5 = new Value_imp(56789, 77.91, 32);
    Value v6 = new Value_imp(67890, 83.03, 24);
    
    hm.put("Jenny", v1);
    hm.put("Bill",v2); 
    hm.put("Steve",v3);   hm.put("Alan",v4);
    hm.put("Gail",v5);    hm.put("Zed",v6);
    hm.put("Wilma",v6);   hm.put("Lauren",v6);
    hm.put("Xray",v6);
    
    System.out.println("Testing size and lambda, expect 9 and 0.225");
    System.out.println(hm.size()); // expect 9
    System.out.println(hm.lambda()); // expect 0.225
    
    
    System.out.println("\nTesting hasKey, expect true, false");
    System.out.println(hm.hasKey("Bill")); // expect true
    System.out.println(hm.hasKey("Zorro")); // expect false
    hm.extend();
    System.out.println("\nTesting extend, expect 9, true, false");
    System.out.println(hm.size()); // expect 9
    System.out.println(hm.hasKey("Bill")); // expect true
    System.out.println(hm.hasKey("Zorro")); // expect false
 
    System.out.println("\nTesting max and min key, expect Zed, Alan");
    System.out.println(hm.maxKey()); // expect "Zed"
    System.out.println(hm.minKey()); // expect "Alan"

    
    System.out.println("\nTesting get method, expect 23456, 24, null");
    System.out.println(hm.get("Bill").getIdNum()); // expect 23456
    System.out.println(hm.get("Lauren").getAge()); // expect 24
    System.out.println(hm.get("Ashley")); // expect null
    
    System.out.println ("\nExpect: Alan, Lauren, Bill, Xray, Zed, Wilma, Gail, Steve");
    String [] keys = hm.getKeys();
  
    System.out.println("\nTesting remove, expect false, 8");
    hm.remove("Gail");
    System.out.println(hm.hasKey("Gail")); // expect false
    System.out.println(hm.size()); 	// expect 8
    

    

    // etc...

  }

}