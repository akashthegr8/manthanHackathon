package com.hackathon.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gson.Gson;

public class ValueString {
		HashMap<String, Integer> male = new HashMap<String, Integer>();
		HashMap<String, Integer> female = new HashMap<String, Integer>();
		HashMap<String, Integer> NA = new HashMap<String, Integer>();

		public ValueString() {

			male.put("gender", 0);
			female.put("gender", 1);
			NA.put("gender", 2);

		}
		public HashMap<String, Integer> getNA() {
			return NA;
		}

		public void setNA(HashMap<String, Integer> nA) {
			NA = nA;
		}

		public HashMap<String, Integer> getMale() {
			return male;
		}

		public HashMap<String, Integer> getFemale() {
			return female;
		}

		public void setMale(HashMap<String, Integer> male) {
			this.male = male;
		}

		public void setFemale(HashMap<String, Integer> female) {
			this.female = female;
		}

		public void set(String gender, String marital_status) {
			if (gender.equalsIgnoreCase("male")) {
				if (!male.containsKey(marital_status))
					male.put(marital_status, 0);
				male.put(marital_status, male.get(marital_status) + 1);
			} else if (gender.equalsIgnoreCase("female")) {
				if (!female.containsKey(marital_status))
					female.put(marital_status, 0);
				female.put(marital_status, female.get(marital_status) + 1);
			} else {
				if (!NA.containsKey(marital_status))
					NA.put(marital_status, 0);
				NA.put(marital_status, NA.get(marital_status) + 1);
			}

		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return new Gson().toJson(this);
//			return new JSONObject(male).toJSONString() + new JSONObject(female).toJSONString() + new JSONObject(NA).toJSONString();
		}
		public void setTotal() {
			int count = 0;
			Collection<Integer> c = male.values();
			Iterator i = c.iterator();
			while(i.hasNext()){
				count = count + (int) i.next();
			}
			male.put("totalcount", count);
			count = 0;
			c = female.values();
			i = c.iterator();
			while(i.hasNext()){
				count = count + (int) i.next();
			}
			female.put("totalcount", count);
			count = 0;
			c = NA.values();
			i = c.iterator();
			while(i.hasNext()){
				count = count + (int) i.next();
			}
			NA.put("totalcount", count);
		}

}
