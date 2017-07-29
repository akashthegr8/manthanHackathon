package com.hackathon.dao;

import java.util.ArrayList;

import com.google.gson.Gson;

public class ValueInt {
	private Float nullCount, zeroCount, min, max, mean, median, standarddeviation;
	float totalcount;
	public float getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(float totalcount) {
		this.totalcount = totalcount;
	}

	String header;
	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	private ArrayList<Float> list = new ArrayList<Float>();

	public ArrayList<Float> getList() {
		return list;
	}

	public void setList(ArrayList<Float> list) {
		this.list = list;
	}

	public Float getNullCount() {
		return nullCount;
	}

	public void setNullCount(Float nullCount) {
		this.nullCount = nullCount;
	}

	public Float getZeroCount() {
		return zeroCount;
	}

	public void setZeroCount(Float zeroCount) {
		this.zeroCount = zeroCount;
	}

	public Float getMin() {
		return min;
	}

	public void setMin(Float min) {
		this.min = min;
	}

	public Float getMax() {
		return max;
	}

	public void setMax(Float max) {
		this.max = max;
	}

	public Float getMean() {
		return mean;
	}

	public void setMean(Float mean) {
		this.mean = mean;
	}

	public Float getMedian() {
		return median;
	}

	public void setMedian(Float median) {
		this.median = median;
	}

	public Float getStandarddeviation() {
		return standarddeviation;
	}

	public void setStandarddeviation(Float standarddeviation) {
		this.standarddeviation = standarddeviation;
	}

	public ValueInt() {
		nullCount = 0f;
		zeroCount = 0f;
		min = Float.MAX_VALUE;
		max = -1f;
		mean = 0f;
		median = 0f;
		standarddeviation = 0f;

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		this.list.clear();;
		return new Gson().toJson(this).toString();
	}
	
}