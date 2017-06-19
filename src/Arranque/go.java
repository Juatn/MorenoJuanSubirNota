package Arranque;

import javax.swing.UIManager;

public class go {

	public static void main(String[] args) {
		Gui.Entrada window = new Gui.Entrada();
		 for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
	            if("Nimbus".equals(laf.getName()))
	                try {
	                UIManager.setLookAndFeel(laf.getClassName());
	            } catch (Exception ex) {
	            }
	        }
		window.frmP.setVisible(true);

	}

	}


