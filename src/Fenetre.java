package projet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author chenbeh anis
 *
 */
public class Fenetre extends JFrame {
	boolean z0 = true, z1 = true, z2 = true, z3 = true, z4 = true, z5 = true,
			z6 = true, z7 = true, z8 = true;

	private static int tableSize;

	/**
	 * @label d'acceuil
	 */
	JLabel label = new JLabel("DRIVE TEST", 0);
	/**
	 * panel d'acceuil
	 */
	JPanel pan = new JPanel();// panel d'acueill
	/**
	 * panel du boutton creer
	 */
	JPanel pan2 = new JPanel();// panel boutton creer
	/**
	 * panel du boutton consulter
	 */
	JPanel pan3 = new JPanel();// panel boutton consulter
	/**
	 * panel du boutton option
	 */
	JPanel pan4 = new JPanel();// panel boutton option
	/**
	 * champ de texte objet
	 */
	JTextArea texte = new JTextArea("Objet", 5, 25);
	/**
	 * champ de texte champ de date
	 */
	JTextArea texte2 = new JTextArea("ChampDate", 5, 25);
	/**
	 * champ de description
	 */
	JTextArea texte3 = new JTextArea("Description", 5, 25);
	/**
	 * menu principale
	 */
	JMenuBar menubar = new JMenuBar();
	/**
	 * boutton menu analyse
	 */
	JMenu analyse = new JMenu("Analyse");
	/**
	 * boutton menu option
	 */
	JMenuItem option = new JMenuItem("Option");
	/**
	 * boutton menu creer
	 */
	JMenuItem creer = new JMenuItem("Créer");
	/**
	 * boutton menu consulter
	 */
	JMenuItem consulter = new JMenuItem("Consulter");
	/**
	 * boutton menu quitter
	 */
	JMenuItem quitter = new JMenuItem("Quitter");
	/**
	 * boutton retour du menu analyser
	 */
	JButton retour = new JButton("Retour");
	/**
	 * boutton menu fichier du menu analyse
	 */
	JButton fichier = new JButton("fichier");
	/**
	 * boutton enregistrer du menu fichier
	 */
	JButton enregistrez = new JButton("enregistrer");
	/**
	 * boutton analyse
	 */
	JButton ana = new JButton("analyse");
	/**
	 * boutton annuler
	 */
	JButton annuler = new JButton("annuler");
	/**
	 * option longitude
	 */
	JRadioButton longitude = new JRadioButton("Longitude et Lattitude", z0);
	/**
	 * option rxlevel
	 */
	JRadioButton rxlevel = new JRadioButton("RxLevel", z1);
	/**
	 * option radio
	 */
	JRadioButton radio = new JRadioButton("Radio", z2);
	/**
	 * option rscp
	 */
	JRadioButton rscp = new JRadioButton("RCSP", z3);
	/**
	 * option ecno
	 */
	JRadioButton ecno = new JRadioButton("ECNO", z4);
	/**
	 * option debit2G
	 */
	JRadioButton debit2g = new JRadioButton("Debit2g", z5);
	/**
	 * option duree2G
	 */
	JRadioButton duree2g = new JRadioButton("Duree2g", z6);
	/**
	 * option debti3G
	 */
	JRadioButton debit3g = new JRadioButton("Debit3g", z7);
	/**
	 * option duree3G
	 */
	JRadioButton duree3g = new JRadioButton("Duree3g", z8);
	/**
	 * choisir le fichier à analyser
	 */
	JFileChooser fichieranalyse = new JFileChooser();
	JLabel path = new JLabel("veuillez choisir un fichier");
	JDialog opti = new JDialog();
	JFrame resultat = new JFrame("resultat");
	JPanel panresult = new JPanel();
	/**
	 * boutton enregistrer resultat
	 */
	JButton enregistreresult = new JButton("enregistrer dans le fichier");
	JButton annulerresult = new JButton("sortir");
	public static String filename;
	Object[] tetec = { "rxlevel", "rxqual", "rscp", "ecno", "duree2g",
			"debit2g", "duree3g", "debit3g" };
	JTable table = new JTable(new DefaultTableModel(tetec, 0));
	DefaultTableModel model = (DefaultTableModel) table.getModel();
	BufferedReader buf;
	Object[] rempli;

	/**
	 * action associee au bouton enregister
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionenregisterz implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			z0 = longitude.isSelected();
			z1 = rxlevel.isSelected();
			z2 = radio.isSelected();
			z3 = rscp.isSelected();
			z4 = ecno.isSelected();
			z5 = debit2g.isSelected();
			z6 = duree2g.isSelected();
			z7 = debit3g.isSelected();
			z8 = duree3g.isSelected();
			opti.dispose();
		}
	}

	/**
	 * action associée au boutton retour du sous-menu Créer
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionretour implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			pan2.setVisible(false);
			pan.setVisible(true);
			setContentPane(pan);

		}
	}

	/**
	 * action associée au sous-menu Créer
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actioncreer implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			pan2.removeAll();
			opti.setVisible(false);
			pan.setVisible(false);
			pan3.setVisible(false);
			pan2.setLayout(new BoxLayout(pan2, BoxLayout.PAGE_AXIS));
			pan2.add(new JLabel("objet:"));
			pan2.add(texte);
			pan2.add(new JLabel("champ date:"));
			pan2.add(texte2);
			pan2.add(new JLabel("description:", 0));
			pan2.add(texte3);
			pan2.add(fichier);
			pan2.add(path);
			fichier.addActionListener(new Actionselect());
			ana.addActionListener(new actionanalyse());
			pan2.add(ana);
			pan2.add(retour);
			retour.addActionListener(new actionretour());
			setContentPane(pan2);
			pan2.setVisible(true);
		}
	}

	/**
	 * action associer au boutton quitter du sous-menu analyse
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionquitter implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	/**
	 * action associee boutton fichier du sous-menu creer
	 * 
	 * @author chenbeh anis
	 *
	 */
	public class Actionselect implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {

			JFileChooser choix = new JFileChooser();
			choix.showOpenDialog(null);
			File f = choix.getSelectedFile();
			filename = f.getAbsolutePath();
			path.setText(f.getName());
		}
	}

	/**
	 * action associée au sous-menu Consulter
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionconsulter implements ActionListener {
		JButton Quitter = new JButton("Quitter");

		public synchronized void actionPerformed(ActionEvent e) {
			int k = 0;

			try {
				InputStream ips = new FileInputStream(
						"C://Users//user4//Desktop//analyse.txt");
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);
				String ligne;
				Object[] C = { "", "", "", "", "", "", "", "" };

				if (tableSize != 0) {
					for (int i = 0; i < tableSize; i++) {
						model.removeRow(i);
						tableSize--;
					}

				}

				while ((ligne = br.readLine()) != null) {
					System.out.println(ligne);
					if (!ligne.equals("")) {
						C[k] = ligne;
						k++;
					}
					if (k == 8) {
						model.addRow(new Object[] { C[0], C[1], C[2], C[3],
								C[4], C[5], C[6], C[7] });
						k = 0;
						tableSize++;
					}
				}

				br.close();
			} catch (Exception j) {
				j.printStackTrace();
			}

			pan3.removeAll();
			pan3.setLayout(new BoxLayout(pan3, BoxLayout.PAGE_AXIS));
			pan.setVisible(false);
			pan2.setVisible(false);
			JScrollPane pancons = new JScrollPane(table,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			pancons.repaint();
			// ajout de l'action quitter
			Quitter.addActionListener(new actionquitter());

			Quitter.setAlignmentX(JButton.CENTER_ALIGNMENT);
			pan3.add(pancons);
			pan3.add(Quitter);
			setContentPane(pan3);
			pan3.setVisible(true);
		}
	}

	/**
	 * action associee au sous-menu Quitter
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionQui implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	/**
	 * action associee au bouton annuler
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionanu implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			opti.setVisible(false);
			opti.dispose();
		}
	}

	/**
	 * action associee au boutton analyser au sous menu creer
	 * 
	 * @author chenbeh anis
	 *
	 */

	private class actionanalyse implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			testfi anal = new testfi();
			String case1 = null, case2 = null, case3 = null, case4 = null, case5 = ""
					+ anal.getDebit1(), case6 = "" + anal.getDuration1(), case7 = ""
					+ anal.getDebit2(), case8 = "" + anal.getDuration2();
			if (-110 <= anal.getRxleve() && anal.getRxleve() <= -95)
				case1 = "Pas de couverture";
			if (-95 < anal.getRxleve() && anal.getRxleve() <= -85)
				case1 = "Mauvaise couverture";
			if (-85 < anal.getRxleve() && anal.getRxleve() <= -75)
				case1 = "Assez bonne couverture";
			if (-75 < anal.getRxleve() && anal.getRxleve() <= -65)
				case1 = "Bonne couverture";
			if (-65 <= anal.getRxleve() && anal.getRxleve() <= -46)
				case1 = "Tres bonne couverture";
			if (0 <= anal.getRxQual() && anal.getRxQual() <= 2)
				case2 = "Tres bonne couverture";
			if (2 < anal.getRxQual() && anal.getRxQual() <= 4)
				case2 = "Bonne couverture";
			if (4 < anal.getRxQual() && anal.getRxQual() <= 6)
				case2 = "Assez Bonne couverture";
			if (6 < anal.getRxQual() && anal.getRxQual() <= 7)
				case2 = "Mauvaise couverture";
			if (anal.getRSCP() <= -119)
				case3 = "Mauvaise couverture";
			if (-119 < anal.getRSCP() && anal.getRSCP() <= -104)
				case3 = "Assez bonne couverture";
			if (-104 < anal.getRSCP() && anal.getRSCP() <= -94)
				case3 = "Bonne couverture";
			if (-94 <= anal.getRSCP())
				case3 = "Trés bonne couverture";
			if (-9 <= anal.getEcNo())
				case4 = "Tres bonne couverture";
			if (-13 <= anal.getEcNo() && anal.getEcNo() < -9)
				case4 = "Bonne couverture";
			if (-18 <= anal.getEcNo() && anal.getEcNo() < -13)
				case4 = "Assez Bonne couverture";
			if (anal.getEcNo() < -18)
				case4 = "Mauvaise couverture";
			if (z1 == false) {
				case1 = "-";
			}
			if (z2 == false) {
				case2 = "-";
			}
			if (z3 == false) {
				case3 = "-";
			}
			if (z4 == false) {
				case4 = "-";
			}
			if (z5 == false) {
				case5 = "-";
			}
			if (z6 == false) {
				case6 = "-";
			}
			if (z7 == false) {
				case5 = "-";
			}
			if (z8 == false) {
				case6 = "-";
			}
			Object[][] body = { { case1, case2, case3, case4, case5, case6,
					case7, case8 } };
			Object[] tete = { "rxlevel", "rxqual", "rscp", "ecno", "duree2g",
					"debit2g", "duree3g", "debit3g" };
			JTable result = new JTable(body, tete);
			result.setSize(500, 100);
			result.setRowHeight(30);
			JScrollPane pantable = new JScrollPane(result,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			panresult.removeAll();
			panresult.add(pantable);
			panresult.add(enregistreresult);
			enregistreresult
					.addActionListener(new actionenregistrerdanslefichier());
			/**
			 * Si les champs de texte sont vides un message d'erreur apparait.
			 */
			if (texte.getText().equals("") || texte2.getText().equals("")
					|| texte3.getText().equals("") || filename==null) {

				JOptionPane jop3 = new JOptionPane();
				jop3.showMessageDialog(null,
						"Veuillez remplir tous les champs svp !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
			/**
			 * Si le fichier n'est pas l'extension ".xlsx" l'utilisateur voit un
			 * message d'erreur qui l'incite à choisir un fichier Excel.
			 */
			else if (!filename.endsWith(".xlsx") ) {
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null,
						"Le fichier n'est pas de type Excel !", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
			else if (anal.isErreur()==true){
				JOptionPane jop2 = new JOptionPane();
				jop2.showMessageDialog(null,
					"Le fichier est vide", "Erreur",
					JOptionPane.ERROR_MESSAGE);}
			else{
			annulerresult.addActionListener(new actionsortir());
			panresult.add(annulerresult);
			setContentPane(panresult);
			resultat.add(panresult);
			resultat.setSize(700, 600);
			pan4.repaint();
			pan4.setEnabled(false);
			resultat.setVisible(true);
		    
			}}
	}

	/**
	 * action associe au bouton dans le fichier
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionsortir implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			resultat.dispose();
			
		}
	}

	/**
	 * action associe au boutton enregistreresult dans le fichier
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionenregistrerdanslefichier implements ActionListener {
		BufferedWriter fic;

		public synchronized void actionPerformed(ActionEvent e) {
			try {
				testfi anal = new testfi();
				String case1 = null, case2 = null, case3 = null, case4 = null;
				fic = new BufferedWriter(new FileWriter(
						"C://Users//user4//Desktop//analyse.txt", true));
				if (-110 <= anal.getRxleve() && anal.getRxleve() <= -95)
					case1 = "Pas de couverture";
				if (-95 < anal.getRxleve() && anal.getRxleve() <= -85)
					case1 = "Mauvaise couverture";
				if (-85 < anal.getRxleve() && anal.getRxleve() <= -75)
					case1 = "Assez bonne couverture";
				if (-75 < anal.getRxleve() && anal.getRxleve() <= -65)
					case1 = "Bonne couverture";
				if (-65 <= anal.getRxleve() && anal.getRxleve() <= -46)
					case1 = "Tres bonne couverture";
				if (0 <= anal.getRxQual() && anal.getRxQual() <= 2)
					case2 = "Tres bonne couverture";
				if (2 < anal.getRxQual() && anal.getRxQual() <= 4)
					case2 = "Bonne couverture";
				if (4 < anal.getRxQual() && anal.getRxQual() <= 6)
					case2 = "Assez Bonne couverture";
				if (6 < anal.getRxQual() && anal.getRxQual() <= 7)
					case2 = "Mauvaise couverture";
				if (anal.getRSCP() <= -119)
					case3 = "Mauvaise couverture";
				if (-119 < anal.getRSCP() && anal.getRSCP() <= -104)
					case3 = "Assez bonne couverture";
				if (-104 < anal.getRSCP() && anal.getRSCP() <= -94)
					case3 = "Bonne couverture";
				if (-94 <= anal.getRSCP())
					case3 = "Tres bonne couverture";
				if (-9 <= anal.getEcNo())
					case4 = "Tres bonne couverture";
				if (-13 <= anal.getEcNo() && anal.getEcNo() < -9)
					case4 = "Bonne couverture";
				if (-18 <= anal.getEcNo() && anal.getEcNo() < -13)
					case4 = "Assez Bonne couverture";
				if (anal.getEcNo() < -18)
					case4 = "Mauvaise couverture";
				if (z1 == true) {
					fic.write(case1);
					fic.newLine();
				}
				if (z1 == false) {
					fic.write("-");
					fic.newLine();
				}
				if (z2 == true) {
					fic.write(case2);
					fic.newLine();
				}
				if (z2 == false) {
					fic.write("-");
					fic.newLine();
				}
				if (z3 == true) {
					fic.write(case3);
					fic.newLine();
				}
				if (z3 == false) {
					fic.write("-");
					fic.newLine();
				}
				if (z4 == true) {
					fic.write(case4);
					fic.newLine();
				}
				if (z4 == false) {
					fic.write("-");
					fic.newLine();
				}
				if (z5 == true) {
					fic.write("" + anal.getDebit1());
					fic.newLine();
				}
				if (z5 == false) {
					fic.write("-");
					fic.newLine();
				}
				if (z6 == true) {
					fic.write("" + anal.getDuration1());
					fic.newLine();
				}
				if (z6 == false) {
					fic.write("-");
					fic.newLine();
				}
				if (z7 == true) {
					fic.write("" + anal.getDebit2());
					fic.newLine();
				}
				if (z7 == false) {
					fic.write("-");
					fic.newLine();
				}
				if (z8 == true) {
					fic.write("" + anal.getDuration2());
					fic.newLine();
				}
				if (z8 == false) {
					fic.write("-");
					fic.newLine();
				}

				fic.newLine();

				fic.close();
			} catch (IOException j) {
				j.printStackTrace();
			}

			resultat.setVisible(false);
		}

	}

	/**
	 * action associee au sous-menu Option
	 * 
	 * @author chenbeh anis
	 *
	 */
	private class actionoption implements ActionListener {
		public synchronized void actionPerformed(ActionEvent e) {
			opti.setSize(600, 400);
			pan4.setLayout(new BoxLayout(pan4, BoxLayout.PAGE_AXIS));
			pan4.add(longitude);
			pan4.add(rxlevel);
			pan4.add(radio);
			pan4.add(rscp);
			pan4.add(ecno);
			pan4.add(duree2g);
			pan4.add(debit2g);
			pan4.add(duree3g);
			pan4.add(debit3g);
			enregistrez.addActionListener(new actionenregisterz());
			enregistrez.setAlignmentX(CENTER_ALIGNMENT);
			pan4.add(enregistrez);
			annuler.setAlignmentX(CENTER_ALIGNMENT);
			annuler.addActionListener(new actionanu());
			pan4.add(annuler);
			opti.setContentPane(pan4);
			// pan4.setVisible(true);
			// opti.add(pan4);
			opti.setVisible(true);
		}
	}

	public Fenetre() {
		this.setSize(500, 500);
		/**
		 * ajout des sous-menu
		 */
		/**
		 * ajout de l'action Créer
		 */
		creer.addActionListener(new actioncreer());
		this.analyse.add(creer);
		/**
		 * ajout de l'action Consulter
		 */
		consulter.addActionListener(new actionconsulter());
		this.analyse.add(consulter);
		/**
		 * ajout d'un separateur
		 */
		this.analyse.addSeparator();
		/**
		 * ajout de l'action du sous-menu Quitter
		 */
		quitter.addActionListener(new actionQui());

		this.analyse.add(quitter);
		/**
		 * ajout des bouttons menu
		 */
		setLayout(null);

		this.menubar.add(analyse);
		this.menubar.add(option);
		/**
		 * ajout de la barre menu
		 */
		this.setJMenuBar(menubar);
		option.addActionListener(new actionoption());
		pan.add(label);
		this.setContentPane(pan);
		this.setTitle("DRIVE TEST");
		this.setVisible(true);
	
	
	}
	}
