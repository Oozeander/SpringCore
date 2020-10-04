package com.oozeander.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TriangleWithPoints {
	private Point pointA, pointB, pointC;

	public void draw() {
		System.out.println("PointA = [" + getPointA().getX() + ", " + getPointB().getY() + "], " + "PointB = ["
				+ getPointB().getX() + ", " + getPointB().getY() + "], " + "PointC = [" + getPointC().getX() + ", "
				+ getPointC().getY() + "]");
	}
}