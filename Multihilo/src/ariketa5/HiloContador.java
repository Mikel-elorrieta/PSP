package ariketa5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HiloContador extends JFrame {

	public static contador h1 = new contador();
	public static contador h2 = new contador();
	public static contador h3 = new contador();

	public static JLabel hilo1Label, hilo2Label, hilo3Label;
	public static JLabel pri1Label, pri2Label, pri3Label;

	public HiloContador() {
		// Configuración básica del JFrame
		setTitle("Thread Control");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 508);
		getContentPane().setLayout(new GridLayout(5, 3, 10, 10));

		JPanel panel = new JPanel();
		getContentPane().add(panel);

		JButton hilo1DecreaseButton_1 = new JButton("--");
		hilo1DecreaseButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minPrioritatea(h1);
			}
		});
		panel.add(hilo1DecreaseButton_1);

		JButton hilo1FinButton_1 = new JButton("Fin hilo 1");
		hilo1FinButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h1.pararHilo();
			}
		});
		panel.add(hilo1FinButton_1);

		JButton hilo1IncreaseButton_1 = new JButton("++");
		hilo1IncreaseButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxPrioritatea(h1);
			}
		});
		panel.add(hilo1IncreaseButton_1);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);

		JButton hilo1DecreaseButton_1_1 = new JButton("--");
		hilo1DecreaseButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minPrioritatea(h2);
			}
		});
		panel_1.add(hilo1DecreaseButton_1_1);

		JButton hilo1FinButton_1_1 = new JButton("Fin hilo 2");
		hilo1FinButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h2.pararHilo();
			}
		});
		panel_1.add(hilo1FinButton_1_1);

		JButton hilo1IncreaseButton_1_1 = new JButton("++");
		hilo1IncreaseButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxPrioritatea(h2);
			}
		});
		panel_1.add(hilo1IncreaseButton_1_1);

		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);

		JButton hilo1DecreaseButton_1_2 = new JButton("--");
		hilo1DecreaseButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minPrioritatea(h3);
			}
		});
		panel_2.add(hilo1DecreaseButton_1_2);

		JButton hilo1FinButton_1_2 = new JButton("Fin hilo 3");
		hilo1FinButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h3.pararHilo();
			}
		});
		panel_2.add(hilo1FinButton_1_2);

		JButton hilo1IncreaseButton_1_2 = new JButton("++");
		hilo1IncreaseButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maxPrioritatea(h3);
			}
		});
		panel_2.add(hilo1IncreaseButton_1_2);

		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);

		JButton finalizarTodoButton = new JButton("Finalizar Todos");
		finalizarTodoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				h1.pararHilo();
				h2.pararHilo();
				h3.pararHilo();
			}
		});
		panel_3.add(finalizarTodoButton);

		// Panel para las etiquetas de los contadores de hilos y prioridades
		JPanel panelEtiquetas = new JPanel();
		getContentPane().add(panelEtiquetas);
		panelEtiquetas.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panelEtiquetas.add(panel_4);

		hilo1Label = new JLabel("Hilo 1: ");
		hilo1Label.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(hilo1Label);

		pri1Label = new JLabel("Pri: ");
		pri1Label.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(pri1Label);

		JPanel panel_5 = new JPanel();
		panelEtiquetas.add(panel_5);

		hilo2Label = new JLabel("Hilo 2: ");
		hilo2Label.setFont(new Font("Tahoma", Font.BOLD, 20));

		panel_5.add(hilo2Label);

		pri2Label = new JLabel("Pri: ");
		pri2Label.setFont(new Font("Tahoma", Font.BOLD, 20));

		panel_5.add(pri2Label);

		JPanel panel_6 = new JPanel();
		panelEtiquetas.add(panel_6);

		hilo3Label = new JLabel("Hilo 3: ");
		hilo3Label.setFont(new Font("Tahoma", Font.BOLD, 20));

		panel_6.add(hilo3Label);

		pri3Label = new JLabel("Pri: ");
		pri3Label.setFont(new Font("Tahoma", Font.BOLD, 20));

		panel_6.add(pri3Label);

		setVisible(true);
		setLocationRelativeTo(null);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(HiloContador::new);
		h1.start();
		h2.start();
		h3.start();
		
		do {
			try {
				
				
				Thread.sleep(1000);
//				
				actuVentana();

			} catch (Exception e) {
				// TODO: handle exception
			}

		} while (h1.isAlive() || h2.isAlive() || h3.isAlive());
	}

	public contador maxPrioritatea(contador h) {

		if(h.getPriority() == Thread.MIN_PRIORITY)
		{
		h.setPriority(Thread.NORM_PRIORITY);
		}else {
			h.setPriority(Thread.MAX_PRIORITY);
		}
		return h;

	}

	
	public contador minPrioritatea(contador h) {


		if(h.getPriority() == Thread.MAX_PRIORITY)
		{
		h.setPriority(Thread.NORM_PRIORITY);
		}else {
			h.setPriority(Thread.MIN_PRIORITY);
		}
		return h;

	}

	public static void actuVentana() {

		hilo1Label.setText("Hilo 1: " + h1.getContador());
		hilo2Label.setText("Hilo 2: " + h2.getContador());
		hilo3Label.setText("Hilo 3: " + h3.getContador());

		pri1Label.setText("Pri: " + h1.getPriority());
		pri2Label.setText("Pri: " + h2.getPriority());
		pri3Label.setText("Pri: " + h3.getPriority());

		
	}

}
