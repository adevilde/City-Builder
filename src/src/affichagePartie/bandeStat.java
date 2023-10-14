package src.affichagePartie;

import src.menus.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.AttributeSet.ColorAttribute;

public class bandeStat extends JPanel implements ComponentListener {

    private JFrame fenetre;

    private JPanel statFinances, titre, annonces;
    private statHabitants statHabitants;
    private Bouton_Pause pause;

    private JLabel energieIcon, argentIcon, bonheurIcon;

    public bandeStat(JFrame fenetre) {
        super();
        this.fenetre = fenetre;

		this.setLayout(null);
        this.setBackground(Color.BLACK);

        this.statHabitants = new statHabitants();
        this.statFinances = new JPanel();
        this.titre = new JPanel();
        this.annonces = new JPanel();
        this.pause = new Bouton_Pause(this.fenetre, this);        

        this.add(this.statHabitants);
        this.add(this.statFinances);
        this.add(this.titre);
        this.add(this.annonces);
        this.add(this.pause);

        this.fenetre.getContentPane().add(this);
		this.fenetre.addComponentListener((ComponentListener) this);

        updatePosition();
		this.setVisible(true);
    }

    public void pause() {
        this.pause.setVisible(false);
    }

    private void setFinances() {
        this.argentIcon = new JLabel();
        this.energieIcon = new JLabel();
        
        this.statFinances.add(this.argentIcon);
        this.statFinances.add(this.energieIcon);

    }

    

    private void updatePosition() {
        this.setBounds(0, 0, this.fenetre.getWidth(), this.fenetre.getHeight()/10); 

        int poslartitre = 27*this.getWidth()/80;
        int pos_hauteur = this.getHeight()/20;
        int largeurtitre = this.getWidth()/3;
        int hauteur = 9*this.getHeight()/10;
        this.titre.setBounds(poslartitre, pos_hauteur, largeurtitre, hauteur);

        int largeurstat = 3*this.getWidth()/20;
        this.statFinances.setBounds(this.getWidth()/80, pos_hauteur, largeurstat, hauteur);
        this.statHabitants.setBounds(7*this.getWidth()/40, pos_hauteur, largeurstat, hauteur);

        this.annonces.setBounds(41*this.getWidth()/60, pos_hauteur, this.getWidth()/4, hauteur);
        this.pause.setBounds(113*this.getWidth()/120, 1*this.getHeight()/10, 4*this.getHeight()/5, 4*this.getHeight()/5);

        this.statHabitants.updatePosition();

    }

    @Override
	public void componentResized(ComponentEvent e){
        updatePosition();
    }
	
	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}

    static class bordureArrondie implements Border {

        @Override
        public Insets getBorderInsets(Component c) {
            // TODO Auto-generated method stub
            return new Insets(0, 0, 0, 0);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

        @Override
        public void paintBorder(Component arg0, Graphics g, int x, int y, int width, int height) {
            g.setColor(Color.BLUE);//ou une autre couleur que tu peux rendre paramétrable
            int arc = 25;//tu peux aussi le rendre configurable
            int adjustXY = 1;//pour ajuster le dessin en x et y
            int adjustWH = 2;//idem pour width et height
            //pour eviter les escalier sur l'arrondi
            Graphics2D graphique = (Graphics2D)g;
            graphique.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphique.drawRoundRect(x+adjustXY, y+adjustXY, width-adjustWH, height-adjustWH, arc, arc); 
            
        }

    }
}
