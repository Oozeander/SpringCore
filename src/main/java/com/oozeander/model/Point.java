package com.oozeander.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
	private BigInteger x, y;

	public void destroy() {
		System.out.println("Destruction of Point[" + getX() + ", " + getY() + "]");
	}

	public void init() {
		System.out.println("Creation of Point[" + getX() + ", " + getY() + "]");
	}
}