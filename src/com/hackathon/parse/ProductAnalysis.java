package com.hackathon.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.hackathon.dao.Product;

public class ProductAnalysis {
	public void analyseProducts(BufferedReader br, FileWriter fw) throws IOException {
		HashMap<String, Product> products = new HashMap<String, Product>();
		HashSet<String> productNames = new HashSet<String>();
		String rows = br.readLine();
		while ((rows = br.readLine()) != null) {
			String[] values = rows.split("\\|");
			if(!products.containsKey(values[7]))
				products.put(values[7], new Product());
			productNames.add(values[7]);
			Product data = products.get(values[7]);
			data.setMembers(values[4]);
			data.setTransactions(values[3]);
			data.setPurchaseunit(data.getPurchaseunit()+ Float.parseFloat(values[9]));
			
		}
		
		for(String p : productNames){
			Product product = products.get(p);
			if(p!=null){
				product.setMembercount();
				product.setTransactioncount();
		}
		}
		File file = new File("res/productData.json");
		FileWriter fwr = new FileWriter(file);
		System.out.printf("File is located at %s%n", file.getAbsolutePath());
		fwr.write(new JSONObject(products).toJSONString());
		fwr.close();
	}
}
