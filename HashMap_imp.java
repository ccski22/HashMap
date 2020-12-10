// put this Interface and Implementation into your code as is
// the grader may need these methods to examine the structure
// that your code creates
//-------------------------------------------------------------------
// you may add methods and structure as you need to
// for example, you may want a toString to help with your debugging
// but to not remove what we have given here
//-------------------------------------------------------------------


package assignment3_f20;

import static org.junit.Assert.assertNotNull;

public class HashMap_imp implements HashMap { 
  HMCell[] tab;
  int nelts;

  
  //-------------------------------------------------------------
 
  HashMap_imp (int num) { 
    this.tab = new HMCell[num];
    this.nelts = 0; 
    
  }

  //-------------------------------------------------------------
  
  public int hash (String key, int tabSize) {
    int hval = 7;
    for (int i=0; i<key.length(); i++) {
      hval = (hval*31) + key.charAt(i);
    }
    hval = hval % tabSize;
    if (hval<0) { hval += tabSize; }
    return hval;
  }
  
  //-------------------------------------------------------------

  @Override
  public HMCell[] getTable() { return this.tab; }

@Override
public Value put(String k, Value v) {
	HMCell t = tab[hash(k, tab.length)];
	HMCell h = new HMCell_imp (k, v);
	Value replaced;
	
	if(t == null ) {
	//if( ((nelts+1)/(double)tab.length) >= 1) { extend();}
		tab[hash(k, tab.length)] = h;
		nelts++;
		if( ((nelts+1)/(double)tab.length) >= 1) { extend();}
		return null;
		} 
	
		while(t != null) {
		if(t.getKey().compareTo(k) == 0) { // we have found the key
		// now change the value
		replaced = t.getValue();
		t.setValue(v);
		return replaced;
		} else if (t.getNext() == null){
			//if( ((nelts+1)/(double)tab.length) >= 1) { extend(); }
			t.setNext(h);
			nelts++;
			if( ((nelts+1)/(double)tab.length) >= 1) { extend();}
			return null;
			}
		t = t.getNext();
		}
		if(lambda() >=1) {extend();};
	return null;
}

@Override
public Value get(String k) {
	if(size() == 0 || this.tab == null || !hasKey(k)) { // if empty table return null
		return null;
	}
		HMCell t  = tab[hash(k, tab.length)]; //hashed index

		while(t != null) {
			if(t.getKey().compareTo(k) == 0) {
				return t.getValue();
			} else { t = t.getNext();}
		}
	return null;
	
}

@Override
public void remove(String k) {
	HMCell t = tab[hash(k,  tab.length)];
	HMCell preT = null;
	
	if(t == null) {
		return;
	}
	
	if(t.getKey().compareTo(k) == 0) {
		tab[hash(k, tab.length)] = t.getNext();
		nelts--;
	} else {
		preT = t;
		t = t.getNext();
		while (t != null) {
			if(t.getKey().compareTo(k) == 0) {
				preT.setNext(t.getNext());
				nelts--;
			} 
			preT = t;
			t = t.getNext();
		}
	}
}


@Override
public boolean hasKey(String k) {

	int idx =  hash(k, tab.length); // index that the key would be inside of
	if(tab[idx] == null) { 
		return false;
	} 
	HMCell t = tab[idx]; // list to search for the index

	
			while(t != null) {
				if(t.getKey().compareTo(k) == 0) {
					return true;
					} else { t = t.getNext();}
			} // end while loop
	return false;
}

@Override
public int size() {
return nelts;
}

@Override
public String maxKey() {
	String m = null;
	
	if(size() == 0) {
		return null;
	} 
	for(int i = 0 ; i < tab.length ; i++) {
		if(tab[i] != null) { 
			if(m == null) {
				m = tab[i].getKey() ;
			} else {
				if(m.compareTo(tab[i].getKey()) < 0) {
					m = tab[i].getKey();
				}
			}
		}
			
	}
	
	
	return m;
}

@Override 
public String minKey() {
String m= null;
	
	if(size() == 0) {
		return null;
	} 
	
	
	for(int i = 0 ; i < tab.length ; i++) {
		if(tab[i] != null) { 
			if(m == null) {
				m = tab[i].getKey() ;
			} else {
				if(m.compareTo(tab[i].getKey()) > 0) {
					m = tab[i].getKey();
				}
			}
		}
			
	}
	
	
	return m;
}

@Override

public String[] getKeys() {
	
	String [] keys = new String[size()];
	
	int count = 0;
	HMCell current;
	
	for(int i = 0; i < tab.length; i++) {
		current = tab[i];
		
		while(current != null) {
			keys[count] = current.getKey();
			count ++;
			current = current.getNext();
		}
	}
	
	return keys;
}

@Override
// done, needs to be checked
public double lambda() {
	double lambda;
if(size() == 0 || tab==null || tab.length ==0) {return 0;}
else {
	double length = tab.length;
	lambda = nelts/ length;
}
return lambda;
}

@Override
// need to finish
public double extend() {
// allocate a new array twice as long as original hash map
	// go through old array and find every key and rehash using new size
	// link the cell with that key into the new table array
	// unlink it from the old table and move it to the new table 
	// when rehashing is complete, make the HashMap object reference new array
	String [] keys = getKeys();
	Value [] values = new Value[size()];
	for(int i = 0 ; i < size() ; i++) {
		values[i] = get(keys[i]);
	}
	HMCell [] extendedTab = new HMCell[2*tab.length];

	this.nelts = 0;
	this.tab = extendedTab;
	
	for(int i = 0 ; i < keys.length ; i++) {
		put(keys[i], values[i]);
	}
	return lambda();
}
  


  
}// end class
