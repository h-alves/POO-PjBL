package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceGrafica extends JFrame {
    public InterfaceGrafica() {
        setTitle("PjBL");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel, BorderLayout.CENTER);
        
        JLabel titleLabel = new JLabel("posto de gasosa");
        mainPanel.add(titleLabel);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 8, 8));
        mainPanel.add(buttonPanel);
        
        JButton button1 = new JButton("Adicionar Funcionário");
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLUE);
        button1.setOpaque(true);
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("a");
            }
        });
        buttonPanel.add(button1);
        
        JButton button2 = new JButton("Remover Funcionário");
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLUE);
        button2.setOpaque(true);
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("b");
            }
        });
        buttonPanel.add(button2);
        
        JButton button3 = new JButton("Listar Funcionários");
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLUE);
        button3.setOpaque(true);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("c");
            }
        });
        buttonPanel.add(button3);
        
        JButton button4 = new JButton("Média de Vendas");
        button4.setForeground(Color.WHITE);
        button4.setBackground(Color.BLUE);
        button4.setOpaque(true);
        button4.setBorderPainted(false);
        button4.setFocusPainted(false);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("d");
            }
        });
        buttonPanel.add(button4);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfaceGrafica frame = new InterfaceGrafica();
                frame.setVisible(true);
            }
        });
    }
}