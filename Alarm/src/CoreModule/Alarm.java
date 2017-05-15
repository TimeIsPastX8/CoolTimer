package CoreModule;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.Timer;

import Info.AlarmInfo;
import Info.ConstInfo;
import Info.JFramInfo;
import Info.TimeInfo;
import Util.AlarmUtil;
import javazoom.jl.player.Player;

public class Alarm {
	
	private Timer timer;
	
	public Alarm() {
		super();
	}

	
	private TimeInfo setTimeZone(){
		
		TimeInfo timeInfo = new TimeInfo();
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Seoul"); 
	    
		timeInfo.setDate(new Date());
	    timeInfo.setDateFormat(new SimpleDateFormat("HHmm"));
	    timeInfo.getDateFormat().setTimeZone(timeZone);
	    
	    return timeInfo;
	}
	
	public String setSound(){
		
		String path = AlarmUtil.getPath();
		return path;
	}

	public void makeNoise(int min, int sec){
		
		// Set TimeZone
		// Default : Republic of Korea(South KOREA, Seoul))
		AlarmInfo.getInstance().setTimeInfo(setTimeZone());
		
		// Set Sound
		// Default : 
		AlarmInfo.getInstance().setSound(this.setSound());

		this.start(min, sec);
		
	}
	
	
	private void start (int CoolTimeMin, int CoolTimeSec){
		
		Timer timer = new Timer(1000, new ActionListener() {
			
	    	SimpleDateFormat secDateFormat   = new java.text.SimpleDateFormat("mmss");
			String time_minus_10  = ConstInfo.BLANK;
			String minute = ConstInfo.BLANK;
			String second = ConstInfo.BLANK;
			
		    public void actionPerformed(ActionEvent e) {
				
    			time_minus_10   = getSecondPlus10(new Date(), secDateFormat, CoolTimeSec);
    			minute = time_minus_10.substring(0, 2);
    			second = time_minus_10.substring(2, 4);
    			
    			AlarmInfo.getInstance().getTimeInfo().setMinute(minute);
				AlarmInfo.getInstance().getTimeInfo().setSecond(second);
				
				System.out.println("time : " + minute + " : " + second);
		
				if ((Integer.parseInt(minute) % CoolTimeMin) == 0){
					if (Integer.parseInt(second) == 00){
						soundStart();
					}
				}
		    }
		});
		
		timer.start();
	}
		
	private void soundStart(){
		
		try { 
			FileInputStream fis = new FileInputStream(AlarmInfo.getInstance().getSound()); 
			Player playMp3 = new Player(fis); 
			playMp3.play(); 
		} catch (Exception e) { 
			System.out.println(e); 
		}
	}
	
	private String getSecondPlus10(Date date, SimpleDateFormat second, int CoolTimeSec){
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.SECOND, CoolTimeSec);
		
		return second.format(cal.getTime()); 
	}
	
}

