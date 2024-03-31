package com.MS.filtering;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue staticfilter() {
		SomeBean someBean = new SomeBean("val1","val2","val3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("val1","val2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue ;
	}
	
	
	
	@GetMapping("/filteringList")
	public MappingJacksonValue staticfilterList() {
		List<SomeBean> someBean = List.of(new SomeBean("val1","val2","val3"),new SomeBean("val4","val5","val6")) ;
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("val1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue ;
	}
}
