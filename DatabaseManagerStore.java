package com.seniordesign.titlesearch;
/*
 * DatabaseMangerStore() file
 */


import java.util.Collection;

/*
 * Define the API for a store
 */

public interface DatabaseManagerStore {
	public Collection<WarrantyDeed> getAll();
	
	
	public Object getDB();
	

	public WarrantyDeed get(String id);
	/*
	 * Put a WarrantyDeed to the store
	 */
	public void store(WarrantyDeed wd);
	public void store1(WarrantyDeed wd);
	
	public void delete(String id);
}
