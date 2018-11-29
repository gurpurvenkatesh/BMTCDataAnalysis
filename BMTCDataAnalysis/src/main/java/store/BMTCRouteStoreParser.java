package store;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.json.JsonArray;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class BMTCRouteStoreParser {

	private Text route_no;
	private FloatWritable distance;
	private Text origin;
	private Text destination;
	private Text map_link;
	private Text busstops_link;
	private Text time;
	private Text busstop;
	private Text departure_from_origin;
	private Text arrival_at_destination;
	private Text departure_from_destination;
	private Text arrival_at_origin;
	
	public Text parseMapContent(String[] mapContnt) throws JsonParseException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, LatlonsParser> map = new HashMap<String, LatlonsParser>();
		String result = null;
		/*
		for( int i = 0; i <= mapContnt.length - 1; i++)
		{
			map = mapper.readValue(mapContnt[i], new TypeReference<Map<String, LatlonsParser>>(){});
			for (String key : map.keySet())  
				result = result + "," + map.get("busstop");
		}*/		
		
		return new Text("Jayanagara 9th Block,JAYANAGARA 9TH BLOCK");
	}
	
	public void parser(String row) throws JsonParseException, JsonMappingException, IOException{
		String[] field = row.split(",");
		Text result = null;
		String strArray[] = field[7].split(",");
		
		result = parseMapContent(strArray);
		
		route_no = new Text(field[0].trim());
		distance = new FloatWritable(Float.parseFloat(field[1].substring(0, field[1].indexOf(" KM"))));
		origin = new Text(field[2].trim());
		destination = new Text(field[3].trim());
		map_link = new Text(field[4].trim());
		busstops_link = new Text(field[5].trim());		
		time = new Text(field[6].trim());
		busstop = result;				
		departure_from_origin = new Text(field[8].trim());
		arrival_at_destination = new Text(field[9].trim());
		departure_from_destination = new Text(field[10].trim());
		arrival_at_origin = new Text(field[11].trim());
	}
	
	public Text getRoute_no() {
		return route_no;
	}	
	public void setRoute_no(Text route_no) {
		this.route_no = route_no;
	}	
	public FloatWritable getDistance() {
		return distance;
	}	
	public void setDistance(FloatWritable distance) {
		this.distance = distance;
	}	
	public Text getOrigin() {
		return origin;
	}	
	public void setOrigin(Text origin) {
		this.origin = origin;
	}	
	public Text getDestination() {
		return destination;
	}	
	public void setDestination(Text destination) {
		this.destination = destination;
	}	
	public Text getMap_link() {
		return map_link;
	}	
	public void setMap_link(Text map_link) {
		this.map_link = map_link;
	}	
	public Text getBusstops_link() {
		return busstops_link;
	}	
	public void setBusstops_link(Text busstops_link) {
		this.busstops_link = busstops_link;
	}	
	public Text getTime() {
		return time;
	}	
	public void setTime(Text time) {
		this.time = time;
	}	
	public Text getDeparture_from_origin() {
		return departure_from_origin;
	}	
	public void setDeparture_from_origin(Text departure_from_origin) {
		this.departure_from_origin = departure_from_origin;
	}	
	public Text getArrival_at_destination() {
		return arrival_at_destination;
	}	
	public void setArrival_at_destination(Text arrival_at_destination) {
		this.arrival_at_destination = arrival_at_destination;
	}	
	public Text getDeparture_from_destination() {
		return departure_from_destination;
	}	
	public void setDeparture_from_destination(Text departure_from_destination) {
		this.departure_from_destination = departure_from_destination;
	}	
	public Text getArrival_at_origin() {
		return arrival_at_origin;
	}	
	public void setArrival_at_origin(Text arrival_at_origin) {
		this.arrival_at_origin = arrival_at_origin;
	}

	public Text getBusstop() {
		return busstop;
	}

	public void setBusstop(Text busstop) {
		this.busstop = busstop;
	}	
}
