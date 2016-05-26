package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssociatedParts {
	@JsonProperty("Part Number")
	private String partNumber;
	
	@JsonProperty("FSC")
	private String fsc;
	
	@JsonProperty("WUC")
	private String wuc;
	
	@JsonProperty("Ref-Symbol")
	private String refSymbol;
	
	@JsonProperty("HMC")
	private String hmc;
	
	@JsonProperty("Serial Number")
	private String serialNumber;
	
	@JsonProperty("Op-Time")
	private String opTime;
	
	@JsonProperty("350-Tag Number")
	private String tagNumber;
	
	@JsonProperty("QTY")
	private String qty;

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getFsc() {
		return fsc;
	}

	public void setFsc(String fsc) {
		this.fsc = fsc;
	}

	public String getWuc() {
		return wuc;
	}

	public void setWuc(String wuc) {
		this.wuc = wuc;
	}

	public String getRefSymbol() {
		return refSymbol;
	}

	public void setRefSymbol(String refSymbol) {
		this.refSymbol = refSymbol;
	}

	public String getHmc() {
		return hmc;
	}

	public void setHmc(String hmc) {
		this.hmc = hmc;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getOpTime() {
		return opTime;
	}

	public void setOpTime(String opTime) {
		this.opTime = opTime;
	}

	public String getTagNumber() {
		return tagNumber;
	}

	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}
	
	
}
