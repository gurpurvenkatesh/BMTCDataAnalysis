package store;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.json.JsonArray;


import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class BMTCRouteStoreParser {

	private String route_no;
	private Float distance;
	private String origin;
	private String destination;
	private String map_link;
	private String busstops_link;
	private String time;
	private String busstop;
	private String departure_from_origin;
	private String arrival_at_destination;
	private String departure_from_destination;
	private String arrival_at_origin;
	
	public String parseMapContent(String[] mapContnt) throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		Object obj = new Object();
		
		Map<String, Object> map = new HashMap<String, Object>();
		String result = null;
		
		for( int i = 0; i <= mapContnt.length - 1; i++)
		{
			//map = mapper.readValue(mapContnt[i], new TypeReference<Map<String, Object>>(){});
		}		
		
		result = "JayaNagar";
		return result;
	}
	
	public void parser(String row) throws JsonParseException, JsonMappingException, IOException{
		String[] field = row.split(",");
		String result = null;
		String[] strArray = field[7].split(",");
		
		result = parseMapContent(strArray);
		
		route_no = field[0].trim();
		distance = new Float(field[1].substring(0, field[1].indexOf(" KM")));
		origin = field[2].trim();
		destination = field[3].trim();
		map_link = field[4].trim();
		busstops_link = field[5].trim();		
		time = field[6].trim();
		busstop = result;				
		departure_from_origin = field[8].trim();
		arrival_at_destination = field[9].trim();
		departure_from_destination = field[10].trim();
		arrival_at_origin = field[11].trim();
	}
	
	public String getRoute_no() {
		return route_no;
	}	
	public void setRoute_no(String route_no) {
		this.route_no = route_no;
	}	
	public Float getDistance() {
		return distance;
	}	
	public void setDistance(Float distance) {
		this.distance = distance;
	}	
	public String getOrigin() {
		return origin;
	}	
	public void setOrigin(String origin) {
		this.origin = origin;
	}	
	public String getDestination() {
		return destination;
	}	
	public void setDestination(String destination) {
		this.destination = destination;
	}	
	public String getMap_link() {
		return map_link;
	}	
	public void setMap_link(String map_link) {
		this.map_link = map_link;
	}	
	public String getBusstops_link() {
		return busstops_link;
	}	
	public void setBusstops_link(String busstops_link) {
		this.busstops_link = busstops_link;
	}	
	public String getTime() {
		return time;
	}	
	public void setTime(String time) {
		this.time = time;
	}	
	public String getDeparture_from_origin() {
		return departure_from_origin;
	}	
	public void setDeparture_from_origin(String departure_from_origin) {
		this.departure_from_origin = departure_from_origin;
	}	
	public String getArrival_at_destination() {
		return arrival_at_destination;
	}	
	public void setArrival_at_destination(String arrival_at_destination) {
		this.arrival_at_destination = arrival_at_destination;
	}	
	public String getDeparture_from_destination() {
		return departure_from_destination;
	}	
	public void setDeparture_from_destination(String departure_from_destination) {
		this.departure_from_destination = departure_from_destination;
	}	
	public String getArrival_at_origin() {
		return arrival_at_origin;
	}	
	public void setArrival_at_origin(String arrival_at_origin) {
		this.arrival_at_origin = arrival_at_origin;
	}

	public String getBusstop() {
		return busstop;
	}

	public void setBusstop(String busstop) {
		this.busstop = busstop;
	}	
}
