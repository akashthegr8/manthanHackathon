package com.hackathon.cleanse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) throws IOException {
		FileWriter[] fws = new FileWriter[2];
		BufferedReader[] brs = new BufferedReader[2];
		fws[0] = new FileWriter("res/new50k.txt");
		brs[0] = new BufferedReader(new FileReader("res/sale_line_50K.txt"));
		fws[1] = new FileWriter("res/new15m.txt");
		brs[1] = new BufferedReader(new FileReader("res/sale_line_1.5M.txt"));
		for (int i = 0; i < brs.length; i++) {
			Set<String> lines = new HashSet<String>();
			String line;
			while ((line = brs[i].readLine()) != null) {
				String sp[] = line.split("|");
				if (lines.add(sp[0] + sp[3] + sp[4] + sp[7] + sp[8])) {
					System.out.println(line);
				} else {
					fws[i].write(line + "\n");
				}

			}
			brs[i].close();
			fws[i].close();
		}

	}
}
