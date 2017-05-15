package Info;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import CoreModule.Alarm;

public class JFramInfo extends JFrame {

	@Override
	public void dispose() {
		super.dispose();
	}

	JPanel panel = new JPanel();
	JButton button_3_Minute = new JButton("3_Minute_Cool_Timer");
//	JButton button_5_Minute = new JButton("5_Minute_Cool_Timer");
//	JButton button_10_Minute = new JButton("10_Minute_Cool_Timer");
//	JButton button_15_Minute = new JButton("15_Minute_Cool_Timer");
//	JButton button_30_Minute = new JButton("30_Minute_Cool_Timer");
	
	JLabel timeLabel = new JLabel("READY", JLabel.CENTER);
	
	public JFramInfo(){
		
		super("Timer For Counting");
		
		// Add the JPanel to JFrame
		getContentPane().add(panel);
		this.panel.setLayout(null);
		
		button_3_Minute.setBounds(33, 25, 90, 23);
		this.panel.add(button_3_Minute);
		
//		button_5_Minute.setBounds(33, 58, 90, 23);
//		this.panel.add(button_5_Minute);
//		
//		button_10_Minute.setBounds(33, 91, 90, 23);
//		this.panel.add(button_10_Minute);
//		
//		button_30_Minute.setBounds(33, 157, 90, 23);
//		this.panel.add(button_30_Minute);
//		
//		button_15_Minute.setBounds(33, 124, 90, 23);
//		this.panel.add(button_15_Minute);

		timeLabel.setBounds(33, 202, 90, 36);
		this.panel.add(timeLabel);
		
		// Set Size of JFrame
		this.setSize(177, 300);
		
		showButton();

		// Action Close Button
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Show WindowLayer
		this.setVisible(true);

		
	}
	
	public void showButton(){
		
		Alarm alarm = new Alarm();
		
		button_3_Minute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				alarm.makeNoise(ConstInfo.MINUTE_3, ConstInfo.SECOND_30);
				
				Timer timer = new Timer(1000, new ActionListener() {
					 public void actionPerformed(ActionEvent e) {
						 timeLabel.setText(AlarmInfo.getInstance().getTimeInfo().getMinute() + " : " + AlarmInfo.getInstance().getTimeInfo().getSecond());
					 }
				});
				timer.start();
			}
		});

		
//		button_5_Minute.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				alarm.makeNoise(ConstInfo.MINUTE_5, ConstInfo.SECOND_30);
//				
//				Timer timer = new Timer(1000, new ActionListener() {
//					 public void actionPerformed(ActionEvent e) {
//						 lblNewLabel.setText(AlarmInfo.getInstance().getTimeInfo().getMinute() + " : " + AlarmInfo.getInstance().getTimeInfo().getSecond());
//					 }
//				});
//				timer.start();
//			}
//		});
//
//		
//		button_10_Minute.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				alarm.makeNoise(ConstInfo.MINUTE_10, ConstInfo.SECOND_30);
//				
//				Timer timer = new Timer(1000, new ActionListener() {
//					 public void actionPerformed(ActionEvent e) {
//						 lblNewLabel.setText(AlarmInfo.getInstance().getTimeInfo().getMinute() + " : " + AlarmInfo.getInstance().getTimeInfo().getSecond());
//					 }
//				});
//				timer.start();
//			}
//		});
//
//		
//		button_15_Minute.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				alarm.makeNoise(ConstInfo.MINUTE_15, ConstInfo.SECOND_30);
//				
//				Timer timer = new Timer(1000, new ActionListener() {
//					 public void actionPerformed(ActionEvent e) {
//						 lblNewLabel.setText(AlarmInfo.getInstance().getTimeInfo().getMinute() + " : " + AlarmInfo.getInstance().getTimeInfo().getSecond());
//					 }
//				});
//				timer.start();
//			}
//		});
//
//		
//		button_30_Minute.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				alarm.makeNoise(ConstInfo.MINUTE_30, ConstInfo.SECOND_30);
//				
//				Timer timer = new Timer(1000, new ActionListener() {
//					 public void actionPerformed(ActionEvent e) {
//						 lblNewLabel.setText(AlarmInfo.getInstance().getTimeInfo().getMinute() + " : " + AlarmInfo.getInstance().getTimeInfo().getSecond());
//					 }
//				});
//				timer.start();
//			}
//		});
	}
}
