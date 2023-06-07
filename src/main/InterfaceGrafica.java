package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class InterfaceGrafica extends JFrame {
    private Departamento departamento;

    public InterfaceGrafica(Departamento departamento) {
        this.departamento = departamento;

        Dimension buttonSize = new Dimension(200, 50);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton adicionarFuncionarioButton = new JButton("Adicionar Funcionário");
        adicionarFuncionarioButton.addActionListener(e -> departamento.adicionarFuncionario(new Gerente("Fulano",100,"01-01-01",departamento,1000)));
        adicionarFuncionarioButton.setPreferredSize(buttonSize);
        adicionarFuncionarioButton.setMinimumSize(buttonSize);
        buttonPanel.add(adicionarFuncionarioButton);

        JButton listarFuncionariosButton = new JButton("Listar Funcionários");
        listarFuncionariosButton.addActionListener(e -> departamento.listarFuncionarios());
        listarFuncionariosButton.setPreferredSize(buttonSize);
        listarFuncionariosButton.setMinimumSize(buttonSize);
        buttonPanel.add(listarFuncionariosButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());

        JPanel innerTextPanel = new JPanel();
        innerTextPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel centerTextLabel = new JLabel(departamento.getNome());
        centerTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        innerTextPanel.add(centerTextLabel);

        textPanel.add(innerTextPanel, BorderLayout.CENTER);

        mainPanel.add(textPanel, BorderLayout.NORTH);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 200);
        setLocationRelativeTo(null);
        setResizable(false); // Impede redimensionamento
        setVisible(true);
    }

    public static void main(String[] args) {
        Departamento departamento = new Departamento("Nome do Departamento");
        InterfaceGrafica interfaceGrafica = new InterfaceGrafica(departamento);
    }
}