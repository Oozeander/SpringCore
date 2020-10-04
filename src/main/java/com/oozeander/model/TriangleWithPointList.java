package com.oozeander.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TriangleWithPointList {
	private List<Point> points;

	public void draw() {
		points.stream().forEach(System.out::println);
	}
}