package com.ank.uber.utils;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Component;

import com.ank.uber.dtos.PointDto;

@Component
public class GeometryUtil {

	public static Point createPoint(PointDto pointDto) {
		GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
		Coordinate coordinate = new Coordinate(pointDto.getCoordinates()[0], pointDto.getCoordinates()[1]);
		
		Point point = geometryFactory.createPoint(coordinate);
		return point;
	}
}
