package Info;


public class AlarmInfo {

	private static AlarmInfo instance;
	private AlarmInfo () {}
	
	static {
		try {
			System.out.println("instance create...");
			instance = new AlarmInfo();
		} catch (Exception e) {
			throw new RuntimeException ("Exception creating StaticAlarmInfoInitalization instance.");
		}
	}
	
	public static AlarmInfo getInstance(){
		return instance;
	}
	
	TimeInfo timeInfo = new TimeInfo();
	
	String Sound = "";

	public TimeInfo getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(TimeInfo timeInfo) {
		this.timeInfo = timeInfo;
	}

	public String getSound() {
		return Sound;
	}

	public void setSound(String sound) {
		Sound = sound;
	}
	
	
}
