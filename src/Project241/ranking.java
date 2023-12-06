package Project241;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
public class ranking {
	private List<User> players;
	private JFrame frame;
	private JTextArea textArea;
	private int currentRank = -1;
	
	public ranking(List<User> players) {
        // กรองเอาเฉพาะผู้เล่นที่ไม่ซ้ำชื่อ
        this.players = players.stream().distinct().collect(Collectors.toList());
    }
	
	 public ranking() {
	        frame = new JFrame();
	        frame.setTitle("Catch me, if you can");
	        frame.setSize(660, 825);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
		 	frame.setResizable(false);
	        
	        JPanel window = new JPanel();
	        window.setLayout(null);
	        window.setBounds(0, 0, 650, 800);
	        
	        JLabel background = new JLabel();
	        background.setIcon(new ImageIcon(input.class.getResource("/image/ranking.png")));
	        background.setBounds(0, 0, 700, 800);
	        
	        textArea = new JTextArea();
	        textArea.setBounds(85, 79, 489, 542);
	        textArea.setEditable(false);
	        frame.getContentPane().add(textArea);

	        JButton findMe = new JButton("My Ranking");
	        findMe.setIcon(new ImageIcon(input.class.getResource("/image/btnmyRank.png")));
	        findMe.setBounds(83, 649, 112, 82);
	        window.add(findMe);
	        findMe.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
			        if (e.getSource() == findMe) {
			            String playerName = JOptionPane.showInputDialog(null, "Enter your name:");
			            currentRank = findKey(playerName);

			            if (currentRank != -1) {
			                JOptionPane.showMessageDialog(null, "Your rank is: " + currentRank, "Ranking", JOptionPane.INFORMATION_MESSAGE);
			            } else {
			                JOptionPane.showMessageDialog(null, "Player not found", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
			    }
			});

	        
	        JButton findNext = new JButton("Next Rank");
	        findNext.setIcon(new ImageIcon(input.class.getResource("/image/btnnextRank.png")));
	        findNext.setBounds(280, 649, 112, 82);
	        window.add(findNext);
	        findNext.addActionListener(new ActionListener() {

				@Override
				 public void actionPerformed(ActionEvent e) {
			        if (e.getSource() == findNext) {
			            if (currentRank != -1 && currentRank < players.size()) {
			                User nextPlayer = players.get(currentRank);
			                currentRank++;
			                JOptionPane.showMessageDialog(null, (currentRank) + " " + nextPlayer.getName() + " " + nextPlayer.getScore(), "Ranking", JOptionPane.INFORMATION_MESSAGE);
			            } else {
			                JOptionPane.showMessageDialog(null, "No next rank available", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
			    }
			});
	        
	        JButton exit = new JButton("Exit");
	        exit.setIcon(new ImageIcon(input.class.getResource("/image/btnexit.png")));
	        exit.setBounds(490, 649, 112, 82);
	        window.add(exit);
	        exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==exit){
						 frame.dispose();
	        		}
					
				}
	        });
	        
	        JButton Menubtn = new JButton("Menu");
	        Menubtn.setIcon(new ImageIcon(input.class.getResource("/image/btnmenu.png")));
	        Menubtn.setBounds(501, 61, 103, 69);
	        window.add(Menubtn);
	        Menubtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==Menubtn){
						pageMenu menu = new pageMenu();
						frame.setVisible(false);
	        		}
					
				}
	        });
	        
	        
	        window.add(background);
	        frame.getContentPane().add(window);
	        
	        
	     
	    }
	 
	 public void showRankings() {
	        SwingUtilities.invokeLater(() -> {
	            // เรียงจากน้อยไปมาก
	            players.sort(Comparator.comparingInt(User::getScore));

	            StringBuilder rankingsText = new StringBuilder();

	            for (int i = 0; i < players.size(); i++) {
	                User player = players.get(i);
	                rankingsText.append("Rank ").append(i + 1).append(": ")
	                        .append(player.getName()).append(", Score: ").append(player.getScore())
	                        .append("\n");
	            }

	            textArea.setText(rankingsText.toString());
	        });
	    }

	 public void setPlayers(List<User> players) {
	        // กรองเอาเฉพาะผู้เล่นที่ไม่ซ้ำชื่อ
	        this.players = players.stream().distinct().collect(Collectors.toList());
	    }
	 
	 public int findKey(String playerName) {
	        // หาตำแหน่ง (index) ของผู้เล่นที่ต้องการ
	        for (int i = 0; i < players.size(); i++) {
	            User player = players.get(i);
	            if (player.getName().equals(playerName)) {
	                return i + 1; // อันดับเริ่มจาก 1
	            }
	        }

	        return -1; // ไม่พบผู้เล่น
	    }

	}

