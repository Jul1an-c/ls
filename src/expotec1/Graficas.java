package expotec1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Graficas extends JFrame {

    private final Font font1 = new Font("Arial", Font.BOLD, 50);
    private final Font font2 = new Font("Arial", Font.BOLD, 20);

    public Graficas() {
        //Caracteristicas de la JFRAME  
        this.setLayout(null);
        this.setTitle("Graficas ");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#5BC0F8"));

        this.Inicializar();
    }

    public void Inicializar() {
        this.Etiquetas();
        this.Botones();
    }

    public void Etiquetas() {

        JLabel Estadisticas = new JLabel("ESTADISTICAS");
        Estadisticas.setBounds(320, 90, 500, 100);
        Estadisticas.setForeground(Color.WHITE);
        Estadisticas.setFont(font1);

        this.add(Estadisticas);

        JLabel img = new JLabel(new ImageIcon("img/estadisticas.png"));
        img.setBounds(200, 260, 256, 256);

        this.add(img);

    }

    public void Botones() {
        JButton reposiciondetarjeta = new JButton("<html><center>Vehiculos<br></center></html>");
        reposiciondetarjeta.setBounds(636, 280, 200, 45);
        reposiciondetarjeta.setForeground(Color.BLACK);
        reposiciondetarjeta.setBackground(Color.decode("#FFC93C"));
        LineBorder bordesr = new LineBorder(Color.BLACK, 2);
        reposiciondetarjeta.setBorder(bordesr);
        this.add(reposiciondetarjeta);

        JButton Datos = new JButton("<html><center>Motocicletas<br></center></html>");
        Datos.setBounds(636, 410, 200, 45);
        Datos.setForeground(Color.BLACK);
        Datos.setBackground(Color.decode("#FFC93C"));
        LineBorder border1 = new LineBorder(Color.BLACK, 2);
        Datos.setBorder(border1);
        this.add(Datos);

        JButton pagodemensualidad = new JButton("<html><center>Pagos<br></center></html>");
        pagodemensualidad.setBounds(636, 345, 200, 45);
        pagodemensualidad.setForeground(Color.BLACK);
        pagodemensualidad.setBackground(Color.decode("#FFC93C"));
        LineBorder border2 = new LineBorder(Color.BLACK, 2);
        pagodemensualidad.setBorder(border2);
        this.add(pagodemensualidad);

        // Acción del botón reposiciondetarjeta
        ActionListener evento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultPieDataset dataset = new DefaultPieDataset();
                dataset.setValue("Abril", 120);
                dataset.setValue("Mayo", 180);
                dataset.setValue("Junio", 220);

                JFreeChart chart = ChartFactory.createPieChart3D(
                        "Ventas por Mes - Gráfica 2", // Título del gráfico
                        dataset, // Datos para el gráfico
                        true, // Mostrar leyenda
                        true, // Mostrar tooltips
                        false // No permitir interacción
                );

                ChartFrame frame = new ChartFrame("Gráfico de Ventas 2", chart);
                frame.setBounds(150, 150, 400, 500);
                frame.setVisible(true);
            }
        };
        reposiciondetarjeta.addActionListener(evento1);

        // Acción del botón Datos
        ActionListener evento2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                dataset.addValue(100, "Ventas", "Enero");
                dataset.addValue(150, "Ventas", "Febrero");
                dataset.addValue(200, "Ventas", "Marzo");

                JFreeChart chart = ChartFactory.createBarChart(
                        "Ventas por Mes", // Título del gráfico
                        "Mes", // Etiqueta del eje X
                        "Ventas", // Etiqueta del eje Y
                        dataset, // Datos para el gráfico
                        PlotOrientation.HORIZONTAL,
                        true,
                        true,
                        false
                );

                ChartFrame frame = new ChartFrame("Gráfico de Ventas", chart);
                frame.pack();
                frame.setVisible(true);
            }
        };
        Datos.addActionListener(evento2);

        // Acción del botón pagodemensualidad
        ActionListener evento3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultPieDataset dataset = new DefaultPieDataset();
                dataset.setValue("Enero", 100);
                dataset.setValue("Febrero", 150);
                dataset.setValue("Marzo", 200);

                JFreeChart chart = ChartFactory.createPieChart3D(
                        "Ventas por Mes - Gráfica 1", // Título del gráfico
                        dataset, // Datos para el gráfico
                        true, // Mostrar leyenda
                        true, // Mostrar tooltips
                        false // No permitir interacción
                );

                ChartFrame frame = new ChartFrame("Gráfico de Ventas 1", chart);
                frame.setBounds(150, 150, 400, 500);
                frame.setVisible(true);
            }
        };
        pagodemensualidad.addActionListener(evento3);
    }
}
