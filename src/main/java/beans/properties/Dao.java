package beans.properties;

public class Dao {
	private String user;
	private String password;
	private String jdbcURL;
	private String driverClass;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJdbcURL() {
		return jdbcURL;
	}
	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	@Override
	public String toString() {
		return "Dao [user=" + user + ", password=" + password + ", jdbcURL=" + jdbcURL + ", driverClass=" + driverClass
				+ "]";
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	

}
