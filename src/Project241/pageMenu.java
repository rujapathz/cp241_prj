package Project241;

import javax.swing.*;

import Project241.CardMatchingGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;
import java.util.ArrayList;



public class pageMenu extends JFrame {
	
	 String name = null;
	 int score = 0;
	JFrame frame = new JFrame();
	 private String selectedPlayerName; 
	 private ranking myRanking;
	
	
	 FileUser user = new FileUser(name,score);
	
	 public pageMenu(List<String> latestPlayer) {
		    if (!latestPlayer.isEmpty()) {
		        this.name = latestPlayer.get(latestPlayer.size() - 1);
		        System.out.println("Latest Player Name: " + name);
		    } else {
		        System.out.println("No players found.");
		    }
		}
	
	
	

    public pageMenu() {
    	frame.setTitle("Catch me ,if you can");
        frame.setSize(1450, 950);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
        JPanel window = new JPanel();
        window.setLayout(null);
        window.setBounds(0, 0, 1450, 950);

        
        JLabel background = new JLabel("background");
        background.setIcon(new ImageIcon(pageMenu.class.getResource("/image/main.png")));
        background.setBounds(0, 0, 1436, 860);
        
        JButton btnstr = new JButton("start");
        btnstr.setIcon(new ImageIcon(pageMenu.class.getResource("/image/btnstart.png")));
        btnstr.setBounds(275, 425, 225, 142);
        
       
        btnstr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnstr){
					// ใช้ retrive(); สำหรับผู้เล่นที่กด start
					List<User> latestPlayers = user.getLatestPlayer();
					if (!latestPlayers.isEmpty()) {
		                User latestPlayer = latestPlayers.get(latestPlayers.size() - 1);
		                new CardMatchingGame(latestPlayer.getName());
		                frame.setVisible(false);
		            } else {
		            	 JOptionPane.showMessageDialog(null, "ไม่เคยมีใครเคยเล่นเกมนี้มาก่อน", "warning", JOptionPane.WARNING_MESSAGE);
		            }
        		}
				
			}
        });
        
        
        
        JButton btnnewplayer = new JButton();
        btnnewplayer.setIcon(new ImageIcon(pageMenu.class.getResource("/image/btnnewplayer.png")));
        btnnewplayer.setBounds(275, 609, 225, 142);
       
        
        btnnewplayer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnnewplayer){
    				 input ip = new input(); 
    				 frame.setVisible(false);
					
        		}
				
			}
        	
        });
        
        
        JLabel logo = new JLabel("");
        logo.setIcon(new ImageIcon(pageMenu.class.getResource("/image/logo.PNG")));
        logo.setBounds(22, -49, 800, 550);
        window.add(logo);
        
        
        
        JButton btnscore = new JButton("");
        btnscore.setIcon(new ImageIcon(pageMenu.class.getResource("/image/btnscore.PNG")));
        btnscore.setBounds(1231, 609, 168, 71);
        window.add(btnscore);
        
       
        btnscore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnscore) {
                    FileUser fileUser = new FileUser(name, score);
                    List<User> allPlayers = fileUser.getLatestPlayer();

                    // เรียก showRankings จากตัวแปร myRanking
                    myRanking = new ranking();
                    myRanking.setPlayers(allPlayers);  // ตั้งค่า players ให้กับ myRanking
                    myRanking.showRankings();  // เรียก showRankings() เพื่อแสดงผล
                    frame.setVisible(false);
                    
                }
            }
        });

        
        JButton listPlayer = new JButton("Player");
        listPlayer.setIcon(new ImageIcon(pageMenu.class.getResource("/image/btnplayer.png")));
        listPlayer.setBounds(1258, 26, 168, 58);
        window.add(listPlayer);
        listPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == listPlayer) {
                    FileUser fileUser = new FileUser(name, score);
                    List<User> allPlayers = fileUser.getLatestPlayer();

                    // นำ allPlayerNames ไปใช้ตามที่คุณต้องการ (แสดงใน JTextArea, JList, JComboBox, เป็นต้น)
                    player py = new player(allPlayers);
                    frame.setVisible(false); 
                }
            }
        });
        
        
        
        
        
        window.add(btnstr);
        window.add(btnnewplayer);
	    window.add(background);
        frame.getContentPane().add(window);
        
        
        
       
        
        
        
        
        

    }
}
