package src;

import javax.swing.*;
import java.awt.*;
import src.menus.*;

public class Executable {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame fenetre = new JFrame();
				
				fenetre.setTitle("City-Builder");
				fenetre.setSize(960, 540);
				fenetre.setLocationRelativeTo(null);
				fenetre.setLayout(null);				
	
				//MenuPrincipal princ = new MenuPrincipal(fenetre); princ.afficher();
				MenuPause pause = new MenuPause(fenetre); pause.afficher();
				fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
				
				fenetre.setVisible(true);
				
			}
		});
	}
}
