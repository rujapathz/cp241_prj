package Project241;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class showScore {

	private JFrame frame;
	private String name;
	private int score;

	
	public showScore(String name,int score) {
		this.name = name;
		this.score = score;
		
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 514, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel background = new JLabel("background");
        background.setIcon(new ImageIcon(pageMenu.class.getResource("/image/inputpage.png")));
        background.setBounds(0, 0, 500, 300);
        
		
		JButton rankbtn = new JButton("Rank");
		rankbtn.setIcon(new ImageIcon(showScore.class.getResource("/image/btnScoreInput.png")));
		rankbtn.setBounds(22, 225, 95, 51);
		frame.getContentPane().add(rankbtn);
		rankbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rankbtn){
					FileUser fileUser = new FileUser(name, score);
                    List<User> allPlayers = fileUser.getLatestPlayer();
					 ranking rk = new ranking();
					 rk.setPlayers(allPlayers);  // ตั้งค่า players ให้กับ myRanking
					 rk.showRankings();  // เรียก showRankings() เพื่อแสดงผล
					 frame.setVisible(false); 
					
        		}
				
			}
        	
        });
		
		JButton restartbtn = new JButton("restart");
		restartbtn.setIcon(new ImageIcon(showScore.class.getResource("/image/btnRestart.png")));
		restartbtn.setBounds(346, 225, 95, 51);
		frame.getContentPane().add(restartbtn);
		restartbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==restartbtn){
					 CardMatchingGame cdm = new CardMatchingGame(name);
					 cdm.restart();
					 frame.setVisible(false); 
					
        		}
				
			}
        	
        });
		
		
		JTextArea textname = new JTextArea();
		textname.setBounds(39, 92, 367, 40);
		textname.setText(this.name+":"+this.score);
		textname.setEditable(false);
		frame.getContentPane().add(textname);
		frame.getContentPane().add(background);
		
		
	}
}
