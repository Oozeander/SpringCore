package com.oozeander.model;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Circle {
	@Value("5")
	private BigInteger diameter;
	@Autowired
	@Qualifier("zeroPoint")
	private Point center;

	public void draw() {
		System.out.println(
				"Center : [" + getCenter().getX() + ", " + getCenter().getY() + "]" + ", Diameter : " + getDiameter());
	}
}