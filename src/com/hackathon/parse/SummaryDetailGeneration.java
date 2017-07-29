package com.hackathon.parse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.json.simple.JSONObject;

import com.hackathon.dao.ValueInt;
import com.hackathon.dao.ValueString;

public class SummaryDetailGeneration {
	public void generate(BufferedReader br, FileWriter fw) throws IOException {

		String line = br.readLine();
		String columnNames[] = line.split("\\|");
		float rc = 0.0f;

		// Create rows hashmaps
		HashMap<String, ValueInt> counts = new HashMap<String, ValueInt>();
		ValueString stringCounts = new ValueString();

		String rows = null;
		while ((rows = br.readLine()) != null) {
			String[] values = rows.split("\\|");
			for (int i = 9; i < columnNames.length ; i++) {
				if (!counts.containsKey(columnNames[i]))
					counts.put(columnNames[i], new ValueInt());
				ValueInt v = counts.get(columnNames[i]);
				if (i>=values.length || values[i] == null || values[i].equals("NULL") || values[i].equals("")) {
					v.setNullCount(v.getNullCount() + 1);
					v.getList().add((float) 0);
				} else {
					v.setHeader(columnNames[i]);
					float val = (float) Float.parseFloat(values[i]);
					if (val == 0)
						v.setZeroCount(v.getZeroCount() + 1);
					if (val < v.getMin())
						v.setMin(val);
					if (val > v.getMax())
						v.setMax(val);
					v.setMean(v.getMean() + val);

					v.getList().add(val);
				}
			}
			rc++;
			stringCounts.set(values[5], values[6]);

		}
		
		stringCounts.setTotal();

		for (int i = 9; i < columnNames.length ; i++) {
			
			ValueInt v = counts.get(columnNames[i]);
			v.setTotalcount(rc);
			if(v.getMin() == Float.MAX_VALUE)
				v.setMin((float) 0);
			if(v.getMax() == -1)
				v.setMax((float) 0);
			ArrayList<Float> arlist = v.getList();
			Collections.sort(v.getList());
			v.setMean(v.getMean() / rc);
			v.setMedian(arlist.get( (int) (rc / 2)));
			for (int l = 0; l < arlist.size(); l++) {
				arlist.set(l, (float) (arlist.get(l) - v.getMean()));
				arlist.set(l, (float) Math.pow(arlist.get(l), 2));
				v.setStandarddeviation(v.getStandarddeviation() + arlist.get(l));
			}
			v.setStandarddeviation((float) Math.sqrt(v.getStandarddeviation()));
		}

//		System.out.println(new JSONObject(counts).toJSONString());
		System.out.println(stringCounts);
		
		File file = new File("res/generatedColumns.json");
		FileWriter fwr = new FileWriter(file);
		System.out.printf("File is located at %s%n", file.getAbsolutePath());
		fwr.write(new JSONObject(counts).toJSONString());
		fwr.close();
		file = new File("res/generatedColumnsGender.json");
		fwr = new FileWriter(file);
		System.out.printf("File is located at %s%n", file.getAbsolutePath());
		fwr.write(stringCounts.toString());
		fwr.close();

	}
}
