package esanchez.devel.weather.exception;

public class LocationException extends Exception {

	private String error;
	private String description;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "LocationException [" + (error != null ? "error=" + error + ", " : "")
				+ (description != null ? "description=" + description : "") + "]";
	}
}
