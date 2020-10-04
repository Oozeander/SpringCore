package com.oozeander.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleTriangle {
	private String type;
	private BigInteger height;

	public void draw() {
		System.out.println("Triangle " + getType() + " drawn, height : " + getHeight());
	}
}