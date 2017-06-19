package Gui;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import Models.pokemon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Entrada extends JFrame {

	public JFrame frmP;
	private JButton botonanterior;
	private JButton botonsiguiente;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JTextPane textnombre;
	private JTextPane textnumero;
	private JTextPane textnivel;
	private JTextPane textregion;
	private JLabel lblNumero;
	private JLabel lblNivelevolucion;
	private JLabel lblRegin;
	private JLabel lblContador;
	private JLabel lblTipo;
	private JComboBox<?> selectipo;
	private JLabel lblComentarios;
	private JTextArea textcomentarios;
	private JButton botoninsertar;
	private JButton botonbuscar;
	private JButton botonagregar;
	pokemon c1;
	protected int indice = 0;



	/**
	 * Create the application.
	 */
	public Entrada() {
		initialize();
		modoLeer();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmP = new JFrame();
		frmP.setTitle("Pokedex v1.0");
		frmP.getContentPane().setBackground(new Color(255, 204, 0));
		frmP.setBounds(100, 100, 860, 683);
		frmP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmP.getContentPane().setLayout(null);

		botonanterior = new JButton("<");
		botonanterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActualizaContador();
				AnteriorPokemon();
				ImprimirPokemon();
				
			}
		});
		botonanterior.setBounds(43, 47, 97, 60);
		frmP.getContentPane().add(botonanterior);

		botonsiguiente = new JButton(">");
		botonsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ActualizaContador();
				SiguientePokemon();
				ImprimirPokemon();
				
			}
		});
		botonsiguiente.setBounds(626, 47, 97, 60);
		frmP.getContentPane().add(botonsiguiente);

		lblNewLabel = new JLabel("POKEDEX");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(178, 47, 239, 60);
		frmP.getContentPane().add(lblNewLabel);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.BLUE);
		lblNombre.setBounds(43, 186, 85, 31);
		frmP.getContentPane().add(lblNombre);

		textnombre = new JTextPane();
		textnombre.setBounds(143, 186, 175, 40);
		frmP.getContentPane().add(textnombre);

		textnumero = new JTextPane();
		textnumero.setBounds(143, 253, 175, 40);
		frmP.getContentPane().add(textnumero);

		textnivel = new JTextPane();
		textnivel.setBounds(143, 320, 175, 40);
		frmP.getContentPane().add(textnivel);

		textregion = new JTextPane();
		textregion.setBounds(143, 388, 175, 40);
		frmP.getContentPane().add(textregion);

		lblNumero = new JLabel("Numero:");
		lblNumero.setForeground(Color.BLUE);
		lblNumero.setBounds(43, 262, 85, 31);
		frmP.getContentPane().add(lblNumero);

		lblNivelevolucion = new JLabel("Evolucion:");
		lblNivelevolucion.setForeground(Color.BLUE);
		lblNivelevolucion.setBounds(37, 320, 91, 31);
		frmP.getContentPane().add(lblNivelevolucion);

		lblRegin = new JLabel("Regi\u00F3n:");
		lblRegin.setForeground(Color.BLUE);
		lblRegin.setBounds(43, 397, 85, 31);
		frmP.getContentPane().add(lblRegin);

		lblContador = new JLabel("");
		lblContador.setForeground(new Color(51, 51, 255));
		lblContador.setHorizontalAlignment(SwingConstants.CENTER);
		lblContador.setBounds(461, 54, 125, 53);
		frmP.getContentPane().add(lblContador);

		lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(Color.BLUE);
		lblTipo.setBounds(489, 191, 69, 20);
		frmP.getContentPane().add(lblTipo);

		selectipo = new JComboBox();
		selectipo.setModel(new DefaultComboBoxModel(new String[] { "Fuego", "Aire", "Agua", "Tierra" }));
		selectipo.setBounds(545, 188, 165, 26);
		frmP.getContentPane().add(selectipo);

		lblComentarios = new JLabel("Comentarios:");
		lblComentarios.setForeground(Color.BLUE);
		lblComentarios.setBounds(489, 264, 122, 26);
		frmP.getContentPane().add(lblComentarios);

		textcomentarios = new JTextArea();
		textcomentarios.setBounds(488, 334, 195, 94);
		frmP.getContentPane().add(textcomentarios);

		botoninsertar = new JButton("Insertar nuevo Pokemon");
		botoninsertar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modoEditar();
			}
		});
		botoninsertar.setBounds(79, 535, 239, 60);
		frmP.getContentPane().add(botoninsertar);

		botonbuscar = new JButton("Buscar Pokemon");
		botonbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				modoLeer();
				ActualizaContador();
			}
		});
		botonbuscar.setBounds(484, 535, 239, 60);
		frmP.getContentPane().add(botonbuscar);

		botonagregar = new JButton("Agregar a pokedex");
		botonagregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean ok = true;
				// VALIDAR NUMERO
				try {
					@SuppressWarnings("unused")
					int num = Integer.parseInt(textnumero.getText());
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El numero no esta correctamente introducido!", "Error",
							JOptionPane.ERROR_MESSAGE);
					ok = false;
				}

				c1 = new pokemon(textnombre.getText(), Integer.parseInt(textnumero.getText()), textnivel.getText(),
						textregion.getText(), selectipo.getSelectedIndex(), textcomentarios.getText());

				if (ok) {
					if (!Contenedor.Lista.pokedex.isEmpty()) {

						for (pokemon c : Contenedor.Lista.pokedex) {
							if (c.getNombre().equals(textnombre.getText())||c.getNumero()==Integer.parseInt(textnumero.getText())) {
								JOptionPane.showMessageDialog(null, "Ya tienes a este pokemon en tu pokedex!!", " ",
										JOptionPane.ERROR_MESSAGE);
								break;
							} else {
								Contenedor.Lista.pokedex.add(c1);
								JOptionPane.showMessageDialog(null, "Pokemon agregado con exito", "",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}
					} else {
						Contenedor.Lista.pokedex.add(c1);
						JOptionPane.showMessageDialog(null, "Pokemon agregado con exito", "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		botonagregar.setBackground(new Color(255, 102, 153));
		botonagregar.setBounds(151, 472, 167, 29);
		frmP.getContentPane().add(botonagregar);
	}

	
	/** Modo lectura
	 * 
	 */
	public void modoLeer() {

		botonanterior.setEnabled(true);
		botonsiguiente.setEnabled(true);
		botonbuscar.setEnabled(false);
		botoninsertar.setEnabled(true);
		botonagregar.setEnabled(false);
		botonagregar.setVisible(false);

		// editable
		
		textnombre.setEditable(false);
		textnumero.setEditable(false);
		textnivel.setEditable(false);
		textregion.setEditable(false);
		lblTipo.setFocusable(false);
		selectipo.setEditable(false);
		textcomentarios.setEditable(false);

		// enable
		textnombre.setEnabled(false);
		textnumero.setEnabled(false);
		textnivel.setEnabled(false);
		textregion.setEnabled(false);
		lblTipo.setEnabled(false);
		selectipo.setEnabled(false);
		
		textcomentarios.setEnabled(false);
		

	}

	/** Modo Editar
	 * 
	 */
	public void modoEditar() {
		botonagregar.setEnabled(true);
		botonagregar.setVisible(true);
		botonanterior.setEnabled(false);
		botonsiguiente.setEnabled(false);
		botonbuscar.setEnabled(true);
		botoninsertar.setEnabled(false);
		selectipo.setVisible(true);
	
		

		// editable
		textnombre.setEditable(true);
		textnumero.setEditable(true);
		textnivel.setEditable(true);
		textregion.setEditable(true);
		lblTipo.setFocusable(true);
		selectipo.setEditable(true);
		textcomentarios.setEditable(true);

		// enable
		textnombre.setEnabled(true);
		textnumero.setEnabled(true);
		textnivel.setEnabled(true);
		textregion.setEnabled(true);
		lblTipo.setEnabled(true);
		selectipo.setEnabled(true);
		textcomentarios.setEnabled(true);

	}

	/** Rellena con un pokemon de la lista los texts
	 * 
	 */
	public void ImprimirPokemon() {
		
		if(!Contenedor.Lista.pokedex.isEmpty()){
		pokemon p = Contenedor.Lista.pokedex.get(indice);

		textnombre.setText(p.getNombre());
		textnumero.setText(Integer.toString(p.getNumero()));
		textnivel.setText(p.getEvolucion());
		textregion.setText(p.getRegion());
		textcomentarios.setText(p.getComentario());
		selectipo.setSelectedIndex(p.getTipo());
		
		}
	}
  /** actualiza el indice
   * 
   * @return
   */
	public int SiguientePokemon() {
		++indice;
		if (indice == Contenedor.Lista.pokedex.size()) {
			indice = 0;
		}
		return indice;

	}
/** Actualiza indice
 * 
 * @return
 */
	public int AnteriorPokemon() {
		--indice;
		if (indice < 0) {
			indice = Contenedor.Lista.pokedex.size()-1;
		}
		return indice;

	}

	/** Actualiza el label de contador 
	 * 
	 */
	public void ActualizaContador() {
		lblContador.setText((indice + 1) + " de " + Contenedor.Lista.pokedex.size());
	}
}
