package resources;

import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import entities.Seniority;

public class JsonConverter {
	
	public static String convertSeniority(Seniority s){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode main = mapper.createObjectNode();
		
		main.put("idSeniority", s.getIdSeniority());
		main.put("name", s.getName());
		main.put("yearsOfExperience", s.getYearsOfExperience());
		main.put("description", s.getDescription());
		
		return main.toString();
	}
	
	public static String convertSeniorityList(List<Seniority> list){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode main = mapper.createObjectNode();
	
		Iterator<Seniority> it = list.iterator();
		
		while(it.hasNext()){
		main.put("idSeniority", it.next().getIdSeniority());
		main.put("name", it.next().getName());
		main.put("yearsOfExperience", it.next().getYearsOfExperience());
		main.put("description", it.next().getDescription());
	
		}
           return main.toString();

	}

}
