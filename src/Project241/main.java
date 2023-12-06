package Project241;

import java.awt.EventQueue;

//import project.Input;

public class main {
    public static void main(String[] args) {
    	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					try {
						pageMenu menu = new pageMenu();
						menu.frame.setVisible(true);
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
			});
		}
}