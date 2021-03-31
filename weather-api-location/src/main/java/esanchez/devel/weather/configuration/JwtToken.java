package esanchez.devel.weather.configuration;

public class JwtToken {

	private String id;
	private String issuer;
	private String subject;
	private int timeToLive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}

	@Override
	public String toString() {
		return "JwtToken [id=" + id + ", issuer=" + issuer + ", subject=" + subject + ", timeToLive=" + timeToLive
				+ "]";
	}
}
