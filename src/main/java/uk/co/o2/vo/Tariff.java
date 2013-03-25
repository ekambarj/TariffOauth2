package uk.co.o2.vo;

public class Tariff {

	private String tariffName;

	private String tariffID;

	private String tariffDescription;

	private String tariffDuration;

	private String tariffStatus;
/**
 * 
 * @return
 */
	
	public String getTariffName() {
		return tariffName;
	}
/**
 * 
 * @param tariffName
 */
	public void setTariffName(String tariffName) {
		this.tariffName = tariffName;
	}

	public String getTariffID() {
		return tariffID;
	}

	public void setTariffID(String tariffID) {
		this.tariffID = tariffID;
	}

	public String getTariffDescription() {
		return tariffDescription;
	}

	public void setTariffDescription(String tariffDescription) {
		this.tariffDescription = tariffDescription;
	}



	public String getTariffStatus() {
		return tariffStatus;
	}

	public void setTariffStatus(String tariffStatus) {
		this.tariffStatus = tariffStatus;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tariff [tariffName = " + tariffName + " ,tariffID = "
				+ tariffID + ",tariffDescription = " + tariffDescription
				+ ",tariffDuration = " + tariffDuration + ",tariffStatus = "
				+ tariffStatus+ " ]";

	}
	public String getTariffDuration() {
		return tariffDuration;
	}
	public void setTariffDuration(String tariffDuration) {
		this.tariffDuration = tariffDuration;
	}

}
