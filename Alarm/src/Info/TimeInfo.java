package Info;


import java.text.DateFormat;
import java.util.Date;

public class TimeInfo {

	public TimeInfo() {
	}
	
	String minute;
	
	String second;
	
	Date date;
	
	DateFormat dateFormat;

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Override
	public String toString() {
		return "TimeInfo [minute=" + minute + ", second=" + second + ", date=" + date + ", dateFormat=" + dateFormat
				+ "]";
	}

	
	
}
