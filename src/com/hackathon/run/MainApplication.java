package com.hackathon.run;

import java.io.BufferedReader;
import java.io.FileReader;

import com.hackathon.parse.SummaryDetailGeneration;

public class MainApplication {
	public static void main(String[] args) throws Exception {
		BufferedReader brs = new BufferedReader(new FileReader("res/sale_line_1.5M.txt"));
		new SummaryDetailGeneration().generate(brs, null);
		/*brs = new BufferedReader(new FileReader("res/sale_line_1.5M.txt"));
		new StoreAnalysis().analyseStores(brs, null);
		brs = new BufferedReader(new FileReader("res/sale_line_1.5M.txt"));
		new ProductAnalysis().analyseProducts(brs, null);*/
	}
}