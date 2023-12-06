package Project241;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class input {
    
    private JFrame frame;
    private int score= 0;

    public input() {
        frame = new JFrame();
        frame.setTitle("Catch me, if you can");
        frame.setSize(514, 335);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        
        JPanel window = new JPanel();
        window.setLayout(null);
        window.setBounds(0, 0,550, 300);
        
        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(input.class.getResource("/image/inputpage.png")));
        background.setBounds(0, 0, 500, 300);
        
        JLabel text = new JLabel();
        text.setText("Your Name:");
        text.setBounds(168, 60, 143, 30);  // ตำแหน่งและขนาดของ JLabel
        text.setFont(new Font("Arial", Font.BOLD, 23));  // กำหนด font และขนาด
        text.setForeground(Color.black );  // กำหนดสี
        text.setVisible(true);
        
        JTextField nameField = new JTextField();
        Font thaiFont = new Font("TH Baijam", Font.PLAIN, 16); // เลือกฟอนต์ภาษาไทยที่ต้องการ
		nameField.setFont(thaiFont);
        nameField.setBounds(35, 115, 424, 30);
        window.add(nameField);
        
        JButton submitButton = new JButton();
        submitButton.setBounds(179, 172, 100, 65);
        ImageIcon submitIcon = new ImageIcon((input.class.getResource("/image/btnnext.png")));
        submitButton.setIcon(submitIcon);
        
        
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	try {
                    if (e.getSource() == submitButton) {
                        String name = nameField.getText();

                        if (name.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Input your name now !!", "warning", JOptionPane.WARNING_MESSAGE);
                        } else {
                            // กระทำเมื่อมีชื่อที่กรอกแล้ว
                            new CardMatchingGame(name);
                            FileUser user = new FileUser(name, score);
                            frame.setVisible(false);
                            
                        }
                    }
                } catch (Exception ex) {
                    // จับข้อผิดพลาดทั่วไป
                    ex.printStackTrace();
        
                
    }
            	 
            	} 
            
        	});
        window.add(submitButton);
        
        window.add(text);
        window.add(background);
        frame.getContentPane().add(window);
    
    }
}

