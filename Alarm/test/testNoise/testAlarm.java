package testNoise;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class testAlarm {

	public static void main(String[] args){
		
//		JFramInfo frame	= new JFramInfo();
		
		String 	path = "C://WORK//makePro//alarm//mp3//bELL.mp3";
		System.out.println(path);
		
		try { 
			FileInputStream fis = new FileInputStream(path); 
			Player playMp3 = new Player(fis); 
			playMp3.play(); 
		} catch (Exception e) { 
			System.out.println(e); 
		}
	}
}
