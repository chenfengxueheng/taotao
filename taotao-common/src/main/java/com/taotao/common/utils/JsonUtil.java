package com.taotao.common.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	//定义Jackson对象
	private static final ObjectMapper mapper = new ObjectMapper();
	
	/**  
     * 将对象转换成json字符串  
     * @param data  
     * @return  
     */  
	public static String objectToJson(Object data){
		try {
			String json = mapper.writeValueAsString(data);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**  
     * 将json串转化为对象  
     * @param jsonData  
     * @param objectType  
     * @return  
     */  
	public static <T> List<T>jsonToObjectList(String jsonData, Class<T> objectType){
		try {
			JavaType javaType=mapper.getTypeFactory().constructParametricType(List.class, objectType);
			List<T> list =(List<T>) mapper.readValue(jsonData, objectType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();  
		}
		return null;  
	}
}
