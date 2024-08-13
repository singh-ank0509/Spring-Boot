package com.ank.uber.config;

import org.locationtech.jts.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ank.uber.dtos.PointDto;
import com.ank.uber.utils.GeometryUtil;

@Configuration
public class MapperConfig {

	@Bean
	public ModelMapper modelMappe() {
		ModelMapper mapper = new ModelMapper();
		
		mapper.typeMap(PointDto.class, Point.class).setConverter(context -> {
			PointDto pointDto = context.getSource();
			Point point = GeometryUtil.createPoint(pointDto);
			return point;
		});
		
		mapper.typeMap(Point.class, PointDto.class).setConverter(context -> {
			Point point = context.getSource();
			double[] coordinates = {
					point.getX(),
					point.getY()				
			};
			
			return new PointDto(coordinates);
		});
		
		
		return mapper;
	}
}
