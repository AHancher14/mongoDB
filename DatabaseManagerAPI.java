package com.seniordesign.titlesearch;



/*
 * This file will contain the get functions for the warranty and trust deeds
 */
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;


import com.google.gson.Gson;

@ApplicationPath("api")
@Path("/WarrantyDeed")
public class DatabaseManagerAPI extends Application {
	DatabaseManagerStore store = DatabaseManagerStoreInstance.getInstance();
	
	
	/*
	 * gets the warrantyDeed based on the book and page number
	 * @return the warrantyDeed
	 */
	@GET
	@Path("/")
	@Produces("{application/json")
	public WarrantyDeed getWarrantyDeed(String bookNumber, String pageNumber) {
		WarrantyDeed wd = new WarrantyDeed();
		
		//List<String> bookNum = new ArrayList<String>();
		for (WarrantyDeed deed : store.getAll()) {
			System.out.println(deed);
			//We know that we have bookNumber in the parameter, so we first need to get 
			//the bookNumer from the list and then compare it
			String bookNumber1 = deed.getBookNumber();
			if(bookNumber.equals(bookNumber1)) {
				//List<String> pageNum = new ArrayList<String>();
				String pageNumber1 = deed.getPageNumber();
				if(pageNumber.equals(pageNumber1)) {
					wd = deed;
					
					break;
					
				}
			}
			else {
				wd = null;
			}
		}
		return wd;
	}
	
	/**
	 * Returns a warranty deed document based on the id string
	 * @param id
	 * @return
	 */
	
	public WarrantyDeed getWarrantyDeed1(String id) {
		WarrantyDeed wd = new WarrantyDeed();
		for (WarrantyDeed deed : store.getAll()) {
			String ids = deed.getID();
			if(id.equals(ids)) {
				wd = deed;
			
				break;
			}
			else {
				wd = null;
			}
		}
		
		return wd;
	}
	
	/**
	 * Returns a warranty deed based on the grantors
	 * @param name
	 * @return
	 */
	public WarrantyDeed getWarrantyDeed2(String name) {
		WarrantyDeed wd = new WarrantyDeed();
		for (WarrantyDeed deed : store.getAll()) {
			String[] names = deed.getGrantors();
			for(int i = 0; i < names.length; i++) {
				if(name.equals(names[i])) {
					wd = deed;
					System.out.println("Hi");
					break;
				}
				else {
					wd = null;
				}
			}
		}
		return wd;
	}
	/*
	 * takes in a warrantyDeed object and passes it on to the database
	 */
	public void setWarrantyDeed(WarrantyDeed wd) {
		store.store(wd);
		
	}
	
	
	/**
	 * Testing function for the moment
	 * @param args
	 */
	public static void main(String[] args) {
		DatabaseManagerStore store = DatabaseManagerStoreInstance.getInstance();
		
		WarrantyDeed deed = new WarrantyDeed();
		
		deed.setText("OF git/MW Before me, the undersigned Notary Public in and for the said County and State, personally appeared D0 ?(UL H?A/i It (MA with whom I am personal] ac uainted (or prove to me n the basis of satisfactory evidence), a?d who, upon oath, acknowledged h self to be the e??i? Emmons Development, LLC, Sole Member of Lakewood Ranches, LLC, the within named bargamor, a limited liability company, and that ihe executed the within instrument for the purposes stated therein by signing the name of Emmomve pment, LLC, as Sole Member of Lakewood Ranches, LLC, by MW self as such gent . Witness my hand and of?cial seal this the day of Fab 2019. My Commission expires: a /Z?I \" I WW??Mt/?b Notary Public? 1/ a ? 1-11th . wMAUSSA LOUISE BEVAN STAFFORD } Notary Public- State 01 Florida ?.?-= a 0?; 5%: Q; : Commisston#FF 206091 9? '32, ?533; My Comm Explres Mar 29 2019 ?? ?1 1?0 / tary Assn. at ?W ?535..? Bonded through National No [2 PGSZAL?WARRANTY DEED STELLA BATCH: 47901 02/11/2019 - 10:48 AM, g ._ MORTGAGE TAX, JANET H. DAVIS REGISTER OF DEEDS STATE OF TENNESSEE COUNTY OF DAVIDSON, 2' Z, Liability Company,, plural, the plural the singular, and the use of any gender shall be applicable to all genders., Lakewood Ranches, LLC BY: Emmons Development, LLC, Its Sole Member BY: MOM WW]");
		deed.setBookNumber("200");
		deed.setPageNumber("941");
		deed.setYearBought("2000");
		deed.setIsLatest(true);
		String[] grantors = {"Jay Patel", "John Doe", "Hi", "AJ"};
		String[] grantees = {"Grantee 1", "Grantee 2"};
		deed.setGrantors(grantors);
		deed.setGrantees(grantees);
		deed.setTransactionDate("2019-02-19");
		deed.setParentBookNumber("194");
		deed.setParentPageNumber("2864");
		
		
	
		DatabaseManagerAPI api = new DatabaseManagerAPI();
		api.setWarrantyDeed(deed);
		//api.getWarrantyDeed1("25-94-194-2864");
		
		
		
		//store.persist(deed);
		//deed = store.get("208-941-194-2864");
//		WarrantyDeed deed2 = manager.createWarrantyDeed("WD207-949.pdf");
//		manager.addWarrantyDeedToHouseHistory(deed2);
	}
	
	
}








