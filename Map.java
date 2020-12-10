package assignment3_f20;



// ADT operations

public interface Map {
	
  public Value put ( String k, Value v ); 
  /*if key is NOT in the structure
  add a new cell to the structure and put the key into it, the value into it
  and return null
if key IS in the structure
  do not add a new cell
  instead, replace the Value object in the existing cell
           with the new Value object
           return the old Value object (the one being replaced) */
  public Value get (String k);     
  /*
   *  if key is NOT in the structure
         return null (this includes when the structure is empty, size 0)
      if key IS in the structure
         return the Value object from the cell containing the key
   */
  public void remove (String k);    
  /* 
   *  if the key IS in the structure
        take the whole cell out of the structure... the (key,value) pair will not be in the
        structure after
      if the key is NOT in the structure
        make no changes to the state of the structure 
   */
  public boolean hasKey(String k);      
  /*
   * if key IS in the structure (meaning there is a (key,value) pair for the key), 
        return true
      if key is NOT in the structure, return false
      in both cases, no change to the structure tate 
   */
  public int size();
  /*
   * no change to state of tree nodes
   */
}
