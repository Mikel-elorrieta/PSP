package EJERCICIOS;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textTask;
    private JTextField textIp;
    private JTextField textPrueba;
    private JTextArea textArea;
    private JLabel lblpid1, lblpid2, lblPIDPPrograma, lblpidP, lblPIDPCmd, lblPIDPSPrograma;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ejercicio2 frame = new Ejercicio2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Ejercicio2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 602, 406);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textTask = new JTextField();
        textTask.setBounds(131, 24, 86, 20);
        contentPane.add(textTask);
        textTask.setColumns(10);

        textIp = new JTextField();
        textIp.setColumns(10);
        textIp.setBounds(270, 24, 86, 20);
        contentPane.add(textIp);

        textPrueba = new JTextField();
        textPrueba.setColumns(10);
        textPrueba.setBounds(393, 24, 86, 20);
        contentPane.add(textPrueba);

        JButton textStart = new JButton("Start Programa Sistema");
        textStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ejecutar un programa del sistema y mostrar el PID
                String app = textTask.getText();
                int[] pids = iniciarAppWindowsYObtenerPid(app);
                lblpid1.setText("PID hijo: " + pids[0]);
                lblpidP.setText("PID padre: " + pids[1]);
            }
        });
        textStart.setBounds(128, 67, 150, 23);
        contentPane.add(textStart);

        JButton textStart1 = new JButton("Start Comando CMD");
        textStart1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ejecutar un comando en CMD y mostrar el resultado
                String comando = textIp.getText();
                textArea.setText(comandoCmd(comando));
                lblPIDPCmd.setText("PID: " + obtenerPidProcesoPadre());
                
            }
        });
        textStart1.setBounds(267, 67, 150, 23);
        contentPane.add(textStart1);

        JButton textStart2 = new JButton("Start 5 Programas");
        textStart2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	ejecutarPrograma5(textPrueba.getText(), 5);

                lblPIDPSPrograma.setText("PID: " + obtenerPidProcesoPadre());
            }
        });
        textStart2.setBounds(390, 67, 150, 23);
        contentPane.add(textStart2);

        JLabel lblPID = new JLabel("PID Hijo");
        lblPID.setBounds(10, 116, 69, 14);
        contentPane.add(lblPID);

        JLabel lblPidPadre = new JLabel("PID Padre");
        lblPidPadre.setBounds(10, 170, 69, 14);
        contentPane.add(lblPidPadre);

        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setBounds(10, 218, 69, 14);
        contentPane.add(lblResultado);

        textArea = new JTextArea();
        textArea.setBounds(119, 213, 220, 143);
        contentPane.add(textArea);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(373, 213, 177, 143);
        contentPane.add(textArea_1);

        lblpidP = new JLabel("");
        lblpidP.setBounds(131, 170, 86, 14);
        contentPane.add(lblpidP);

        lblpid1 = new JLabel("");
        lblpid1.setBounds(128, 116, 114, 14);
        contentPane.add(lblpid1);

        lblpid2 = new JLabel("");
        lblpid2.setBounds(270, 116, 100, 14);
        contentPane.add(lblpid2);

        lblPIDPPrograma = new JLabel("");
        lblPIDPPrograma.setBounds(390, 116, 150, 14);
        contentPane.add(lblPIDPPrograma);

        lblPIDPCmd = new JLabel("");
        lblPIDPCmd.setBounds(284, 170, 86, 14);
        contentPane.add(lblPIDPCmd);

        lblPIDPSPrograma = new JLabel("");
        lblPIDPSPrograma.setBounds(432, 170, 86, 14);
        contentPane.add(lblPIDPSPrograma);
    }

    public static int obtenerPidProcesoPadre() {
        String id = ManagementFactory.getRuntimeMXBean().getName();
        String[] ids = id.split("@");
        return Integer.parseInt(ids[0]);
    }
    
    public static int[] iniciarAppWindowsYObtenerPid(String app) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(app);
            Process proceso = processBuilder.start();

            ProcessHandle handle = proceso.toHandle();
            long pidHijo = handle.pid();
            
            long pidPadre = obtenerPidProcesoPadre();

         
            return new int[] {(int) pidHijo, (int) pidPadre};
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new int[] {-1, -1};
    }

    // Método para ejecutar un comando en CMD y obtener el resultado
    public static String comandoCmd(String comando) {
        String respuesta = "";
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", comando);
        try {
            Process p = pb.start();
            InputStream is = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine()) != null) {
                respuesta = respuesta + linea + ("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public static int ejecutarPrograma5(String texto, int veces) {
        int pidHijo = -1 ;
      //  for (int i = 0; i < veces; i++) {
            try {
                ProcessBuilder pb = new ProcessBuilder("java", "EJERCICIOS.ejercicio7.Llamador", texto);
                pb.directory(new File("bin"));

                Process process = pb.start();
                
                ProcessHandle handle = process.toHandle();
                 pidHijo = (int) handle.pid();

                BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String linea;
                while ((linea = outputReader.readLine()) != null) {
                    System.out.println(linea);
                }

                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String errorLinea;
                while ((errorLinea = errorReader.readLine()) != null) {
                    System.err.println("Error: " + errorLinea);
                }

                int exitCode = process.waitFor();
                System.out.println("Proceso hijo " + pidHijo + " terminado con código de salida: " + exitCode);

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            return pidHijo;
      //  }

 
      
    }
}
