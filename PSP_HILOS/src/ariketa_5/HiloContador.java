package ariketa_5;

import javax.swing.*;
import java.awt.*;

public class HiloContador extends JFrame {

    public HiloContador() {
        // Configuración básica del JFrame
        setTitle("Thread Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 419);
        getContentPane().setLayout(new GridLayout(5, 3, 10, 10));
        
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        
        JButton hilo1DecreaseButton_1 = new JButton("--");
        panel.add(hilo1DecreaseButton_1);
        
        JButton hilo1FinButton_1 = new JButton("Fin hilo 1");
        panel.add(hilo1FinButton_1);
        
        JButton hilo1IncreaseButton_1 = new JButton("++");
        panel.add(hilo1IncreaseButton_1);
        
        JPanel panel_1 = new JPanel();
        getContentPane().add(panel_1);
        
        JButton hilo1DecreaseButton_1_1 = new JButton("--");
        panel_1.add(hilo1DecreaseButton_1_1);
        
        JButton hilo1FinButton_1_1 = new JButton("Fin hilo 1");
        panel_1.add(hilo1FinButton_1_1);
        
        JButton hilo1IncreaseButton_1_1 = new JButton("++");
        panel_1.add(hilo1IncreaseButton_1_1);
        
        JPanel panel_2 = new JPanel();
        getContentPane().add(panel_2);
        
        JButton hilo1DecreaseButton_1_2 = new JButton("--");
        panel_2.add(hilo1DecreaseButton_1_2);
        
        JButton hilo1FinButton_1_2 = new JButton("Fin hilo 1");
        panel_2.add(hilo1FinButton_1_2);
        
        JButton hilo1IncreaseButton_1_2 = new JButton("++");
        panel_2.add(hilo1IncreaseButton_1_2);
        
        JPanel panel_3 = new JPanel();
        getContentPane().add(panel_3);
        
        JButton finalizarTodoButton = new JButton("Finalizar Todos");
        panel_3.add(finalizarTodoButton);
        
        // Panel para las etiquetas de los contadores de hilos y prioridades
        JPanel panelEtiquetas = new JPanel();
        panelEtiquetas.setLayout(new GridLayout(2, 3, 10, 10));  // 2 filas, 3 columnas para etiquetas
        add(panelEtiquetas);

        // Etiquetas para los contadores de hilos
        JLabel hilo1Label = new JLabel("Hilo 1: 0");
        panelEtiquetas.add(hilo1Label);

        JLabel hilo2Label = new JLabel("Hilo 2: 0");
        panelEtiquetas.add(hilo2Label);

        JLabel hilo3Label = new JLabel("Hilo 3: 0");
        panelEtiquetas.add(hilo3Label);

        // Etiquetas para las prioridades
        JLabel pri1Label = new JLabel("Pri: 0");
        panelEtiquetas.add(pri1Label);

        JLabel pri2Label = new JLabel("Pri: 0");
        panelEtiquetas.add(pri2Label);

        JLabel pri3Label = new JLabel("Pri: 0");
        panelEtiquetas.add(pri3Label);

        // Mostrar la ventana centrada en la pantalla
        setVisible(true);
        setLocationRelativeTo(null);

        // Mostrar la ventana centrada en la pantalla
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HiloContador::new);
    }
}
