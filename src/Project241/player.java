package Project241;

import java.awt.EventQueue;
import java.util.LinkedHashSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class player {
    private JFrame frame;
    private JTextArea textArea;
    private List<User> allPlayers;

    public player(List<User> allPlayers) {
    	 this.allPlayers = allPlayers;
        initialize();
        displayUniquePlayerNames(allPlayers);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Catch me, if you can");
        frame.setSize(660, 825);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        JLabel background = new JLabel();
        background.setIcon(new ImageIcon(input.class.getResource("/image/ranking.png")));
        background.setBounds(0, 0, 700, 800);

        textArea = new JTextArea();
        textArea.setBounds(85, 79, 489, 542);
        textArea.setEditable(false);
        frame.getContentPane().add(textArea);

        JButton MenuBtn = new JButton("Menu");
        MenuBtn.setIcon(new ImageIcon(pageMenu.class.getResource("/image/btnmenu.PNG")));
        MenuBtn.setBounds(461, 671, 113, 60);
        frame.getContentPane().add(MenuBtn);
        MenuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == MenuBtn) {
                    pageMenu menu = new pageMenu();
                    frame.setVisible(false);
                }
            }
        });

        JButton btnDelete = new JButton("New button");
        btnDelete.setBounds(85, 671, 113, 60);
        btnDelete.setIcon(new ImageIcon(pageMenu.class.getResource("/image/btnDelete.PNG")));
        frame.getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnDelete) {
                    // เรียกใช้เมดทอด deleteLatestPlayer จากคลาส FileUser
                    FileUser fileUser = new FileUser(null, 0);
                    fileUser.deleteLatestPlayer();
                    JOptionPane.showMessageDialog(null, "Delete is successful");
                    new pageMenu();
                    // หลังจากลบข้อมูลเสร็จ สามารถปรับปรุงหน้า GUI หรือทำอย่างอื่นต่อได้ตามต้องการ
                }
            }
        });

        frame.getContentPane().add(background);
        frame.setVisible(true);
    }

    private void displayUniquePlayerNames(List<User> allPlayers) {
        LinkedHashSet<String> uniqueNames = new LinkedHashSet<>();
        StringBuilder namesText = new StringBuilder();

        for (User player : allPlayers) {
            String playerName = player.getName();

            // Check if the name is not already in the set
            if (uniqueNames.add(playerName)) {
                namesText.append(playerName).append("\n");
                System.out.println("Displaying: " + playerName);
            }
        }

        textArea.setText(namesText.toString());
    }
}
