package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDetails {	
	@JsonProperty("Discrepancy")
	private String discrepancy;
	
	@JsonProperty("PWC")
	private String pwc;
	
	@JsonProperty("WUC")
	private String wuc;
	
	@JsonProperty("Event Narrative")
	private String eventNarrative;
	
	@JsonProperty("TMC")
	private String tmc;
	
	@JsonProperty("ATC")
	private String atc;
	
	@JsonProperty("WDC")
	private String wdc;
	
	@JsonProperty("HMC")
	private String hmc;
	
	@JsonProperty("Units")
	private String units;
	
	@JsonProperty("Start Date")
	private String startDate;
	
	@JsonProperty("Stop Date")
	private String stopDate;
	
	@JsonProperty("User")
	private String user;
	
	@JsonProperty("Corrective Action")
	private String correctiveAction;
	
	public String getDiscrepancy() {
		return discrepancy;
	}

	public void setDiscrepancy(String discrepancy) {
		this.discrepancy = discrepancy;
	}

	public String getPwc() {
		return pwc;
	}

	public void setPwc(String pwc) {
		this.pwc = pwc;
	}

	public String getWuc() {
		return wuc;
	}

	public void setWuc(String wuc) {
		this.wuc = wuc;
	}

	public String getEventNarrative() {
		return eventNarrative;
	}

	public void setEventNarrative(String eventNarrative) {
		this.eventNarrative = eventNarrative;
	}

	public String getTmc() {
		return tmc;
	}

	public void setTmc(String tmc) {
		this.tmc = tmc;
	}

	public String getAtc() {
		return atc;
	}

	public void setAtc(String atc) {
		this.atc = atc;
	}

	public String getWdc() {
		return wdc;
	}

	public void setWdc(String wdc) {
		this.wdc = wdc;
	}

	public String getHmc() {
		return hmc;
	}

	public void setHmc(String hmc) {
		this.hmc = hmc;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStopDate() {
		return stopDate;
	}

	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCorrectiveAction() {
		return correctiveAction;
	}

	public void setCorrectiveAction(String correctiveAction) {
		this.correctiveAction = correctiveAction;
	}
}
