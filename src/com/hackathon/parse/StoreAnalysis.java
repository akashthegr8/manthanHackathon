package com.hackathon.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import org.json.simple.JSONObject;

import com.hackathon.dao.Store;

public class StoreAnalysis {
	public void analyseStores(BufferedReader br, FileWriter fw) throws IOException {

		HashMap<String, HashMap<String, Store>> storeData = new HashMap<String, HashMap<String, Store>>();
		String line = br.readLine();
		String rows;
		HashSet<String> storeNames = new HashSet<String>();
		HashSet<String> weekNames = new HashSet<String>();
		while ((rows = br.readLine()) != null) {
			String[] values = rows.split("\\|");
			if (!storeData.containsKey(values[8])) {
				storeData.put(values[8], new HashMap<String, Store>());
			}
			storeNames.add(values[8]);
			HashMap<String, Store> singleInfo = storeData.get(values[8]);
			if (!singleInfo.containsKey(values[1])) {
				singleInfo.put(values[1], new Store());
			}
			weekNames.add(values[1]);
			Store store = singleInfo.get(values[1]);
			store.setSales(store.getSales() + Float.parseFloat(values[10]));
			store.setPurchasedUnits(store.getPurchasedUnits() + Float.parseFloat(values[9]));
			store.setMembers(values[4]);
			store.setTransactions(values[3]);
			if (values.length >= 12 && !values[11].equals(""))
				store.setDiscount(store.getDiscount() + Float.parseFloat(values[11]), false);
		}

		/*
		 * Collection<HashMap<String, Store>> stores = storeData.values();
		 * Iterator iterator = stores.iterator(); while(iterator.hasNext()){
		 * HashMap<String, Store> store = (HashMap<String, Store>)
		 * iterator.next();
		 * 
		 * }
		 */
		// System.out.println(storeNames.size() + " " + weekNames.size());

		for (String storeName : storeNames) {
			if (storeName.equals("store_description"))
				continue;

			HashMap<String, Store> stores = storeData.get(storeName);
			for (String weekName : weekNames) {

				if (weekName.equals("week_name"))
					continue;
				Store store = stores.get(weekName);
				if (store != null) {
					store.setMemberCount();
					store.setTransactionCount();
					store.setAverageBasketValue();
					store.setAverageSales();
					store.setDiscount(0, true);
				}
			}
		}
		
		
		
		
		File file = new File("res/storeData.json");
		FileWriter fwr = new FileWriter(file);
		System.out.printf("File is located at %s%n", file.getAbsolutePath());
		fwr.write(new JSONObject(storeData).toJSONString());
		fwr.close();
		

	}
}
