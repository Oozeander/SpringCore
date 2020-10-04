package com.oozeander;

import java.util.Locale;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.oozeander.model.Circle;
import com.oozeander.model.DatabaseConnection;
import com.oozeander.model.SimpleTriangle;
import com.oozeander.model.TriangleWithPointList;
import com.oozeander.model.TriangleWithPoints;
import com.oozeander.spring.JavaConfig;

public class App {
	public static void main(String[] args) {
		// XML Config
		/*
		 * AbstractApplicationContext ctx = new
		 * ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		 * ctx.registerShutdownHook();
		 *
		 * SimpleTriangle triangle = ctx.getBean("triangle_constructor",
		 * SimpleTriangle.class); triangle.draw();
		 *
		 * ctx.getBean(TriangleWithPoints.class).draw();
		 * ctx.getBean("triangle_pointList", TriangleWithPointList.class).draw();
		 *
		 * System.out.println(ctx.getBean("mySet") + "\n" + ctx.getBean("myMap") + "\n"
		 * + ctx.getBean("myProps"));
		 *
		 * ctx.getBean("triangleInherited", TriangleWithPointList.class).draw();
		 * ctx.getBean(Circle.class).draw();
		 *
		 * System.out.println(ctx.getMessage("greeting", null, "Nothing here...",
		 * Locale.ENGLISH) + "\n" + ctx.getMessage("greeting", null, "Rien ici...",
		 * Locale.FRANCE) + "\n" + ctx.getMessage("intro", new Object[] { "Billel", 24
		 * }, "Nothing here...", Locale.ENGLISH) + "\n" + ctx.getMessage("intro", new
		 * Object[] { "Billel", 24 }, "Rien ici...", Locale.FRANCE));
		 * System.out.println(ctx.getBean(DatabaseConnection.class));
		 *
		 * ctx.close();
		 */

		// Java Config
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(new Class<?>[] { JavaConfig.class });
		ctx.registerShutdownHook();

		SimpleTriangle triangle = ctx.getBean("triangle_constructor", SimpleTriangle.class);
		triangle.draw();

		ctx.getBean(TriangleWithPoints.class).draw();
		ctx.getBean("triangle_pointList", TriangleWithPointList.class).draw();

		ctx.getBean(Circle.class).draw();

		System.out.println(ctx.getMessage("greeting", null, "Nothing here...", Locale.ENGLISH) + "\n"
				+ ctx.getMessage("greeting", null, "Rien ici...", Locale.FRANCE) + "\n"
				+ ctx.getMessage("intro", new Object[] { "Billel", 24 }, "Nothing here...", Locale.ENGLISH) + "\n"
				+ ctx.getMessage("intro", new Object[] { "Billel", 24 }, "Rien ici...", Locale.FRANCE));
		System.out.println(ctx.getBean(DatabaseConnection.class));

		ctx.close();
	}
}