package model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@JsonRootName(value = "doc")
public class EventRecord {
	@JsonProperty("Site")
	private String site;
	
	@JsonProperty("Event ID")
	private String eventId;
	
	@JsonProperty("Event Type")
	private String eventType;
	
	@JsonProperty("Event Details")
	private List<EventDetails> eventDetails;
	
	@JsonProperty("Associated Parts")
	private List<AssociatedParts> associatedParts;
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getEventId() {
		return eventId;
	}
	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	public String getEventType() {
		return eventType;
	}
	
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	
	public List<EventDetails> getEventDetails() {
		if (eventDetails == null) {
			eventDetails = new ArrayList<EventDetails>();
		}
		
 		return eventDetails;
	}
	
	public void setEventDetails(List<EventDetails> eventDetails) {
		this.eventDetails = eventDetails;
	}
	
	public List<AssociatedParts> getAssociatedParts() {
		if (associatedParts == null) {
			associatedParts = new ArrayList<AssociatedParts>();
		}
		
		return associatedParts;
	}
	
	public void setAssociatedParts(List<AssociatedParts> associatedParts) {
		this.associatedParts = associatedParts;
	}
	
	// output this object to a JSON string to writing to a file
	public String toJsonString() {
		String json = null;
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		try {
			json = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return json;
	}
}
