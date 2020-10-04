package com.oozeander.spring;

import java.math.BigInteger;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.oozeander.model.Point;
import com.oozeander.model.SimpleTriangle;
import com.oozeander.model.TriangleWithPointList;
import com.oozeander.model.TriangleWithPoints;

@Configuration
@ComponentScan(basePackages = { "com.oozeander.model" })
@Import({ MessagingConfig.class })
public class JavaConfig {
	@Bean(name = "triangle_setter")
	@Scope("singleton")
	SimpleTriangle triangle_setter() {
		SimpleTriangle triangle = new SimpleTriangle();
		triangle.setType("isocèle");
		triangle.setHeight(BigInteger.valueOf(5));
		return triangle;
	}

	@Bean(name = "triangle_constructor")
	@Scope("singleton")
	@Primary
	SimpleTriangle triangle_constructor() {
		return new SimpleTriangle("équilatéral", BigInteger.valueOf(7));
	}

	@Bean(name = "zeroPoint", initMethod = "init", destroyMethod = "destroy")
	@Scope("prototype")
	@Primary
	Point zeroPoint() {
		return new Point(BigInteger.ZERO, BigInteger.ZERO);
	}

	@Bean(name = "triangle_points")
	TriangleWithPoints triangle_points() {
		return new TriangleWithPoints(zeroPoint(), new Point(BigInteger.ZERO, BigInteger.valueOf(5)),
				new Point(BigInteger.valueOf(5), BigInteger.ZERO));
	}

	@Bean(name = "triangle_pointList")
	@Primary
	TriangleWithPointList triangle_pointList() {
		return new TriangleWithPointList(Arrays.asList(zeroPoint(), new Point(BigInteger.ZERO, BigInteger.valueOf(5)),
				new Point(BigInteger.valueOf(5), BigInteger.ZERO)));
	}
}