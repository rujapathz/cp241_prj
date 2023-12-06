package Project241;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Card extends JButton {
    
    private int id;
    
    final private char backIcon;
   
    final private char frontIcon;
    
    private boolean isFlipped = false;
    
    private boolean isFlippable = true;

    
    public Card(int id, char backIcon, char frontIcon) {
        super(new ImageIcon("/src/image/" + backIcon + ".png"));

        // กำหนดลักษณะต่าง ๆ ของ Card
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        this.id = id;
        this.backIcon = backIcon;
        this.frontIcon = frontIcon;
        this.setBorder(new MetalBorders.ButtonBorder());

        // ตั้งค่าขนาดของรูปภาพให้เท่ากับ Card
        int preferredSize = this.getPreferredSize().width; // ให้ขนาดเท่ากับขนาดของปุ่ม
        Image img = new ImageIcon("src/image/" + backIcon + ".png").getImage();
        Image newImg = img.getScaledInstance(preferredSize, preferredSize, Image.SCALE_SMOOTH);

        super.setIcon(new ImageIcon(newImg));
    
    }

    // getters
    public int getId() {
        return id;
    }

    public char getFrontIcon() {
        return frontIcon;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public boolean isFlippable() {
        return isFlippable;
    }

    // setters
    public void setFlippable(boolean flippable) {
        isFlippable = flippable;
    }

    // พลิกหน้าการ์ด
    public void flip() {
        isFlipped = !isFlipped;

        int preferredSize = this.getPreferredSize().width; // ให้ขนาดเท่ากับขนาดของปุ่ม
        Image img = new ImageIcon("src/image/" + this.actualIcon() + ".png").getImage();
        Image newImg = img.getScaledInstance(preferredSize, preferredSize, Image.SCALE_SMOOTH);

        super.setIcon(new ImageIcon(newImg));
       
        revalidate();
        repaint();
    }

    // ไอคอนที่กำลังใช้อยู่ในปัจจุบัน
    public char actualIcon() {
        return isFlipped ? frontIcon : backIcon;
    }
    
    
}
