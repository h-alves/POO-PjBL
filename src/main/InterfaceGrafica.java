package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceGrafica extends JFrame {

    private ArrayList<Departamento> listaDepartamentos;
    private ArrayList<FolhaPagamento> listaFolhas;

    public InterfaceGrafica(ArrayList<Departamento> listaDepartamentos, ArrayList<FolhaPagamento> listaFolhas) {
        super("PjBL - POO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());
        
        this.listaDepartamentos = listaDepartamentos;
        this.listaFolhas = listaFolhas;
        
        exibirTelaInicial();
    }
    
    private void exibirTelaInicial() {
    	JPanel homePanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel("PjBL - POO");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        homePanel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(new FlowLayout());
        JButton departamentosButton = new JButton("Departamentos");
        buttonsPanel.add(departamentosButton);
        
        JButton folhaPagamentoButton = new JButton("Folha de Pagamento");
        buttonsPanel.add(folhaPagamentoButton);
        
        homePanel.add(buttonsPanel, BorderLayout.CENTER);

        // Adicione os listeners de ação para os botões
        departamentosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaDepartamentos(listaDepartamentos);
            }
        });
        folhaPagamentoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaFolhaPagamento(listaFolhas);
            }
        });

        add(homePanel, BorderLayout.CENTER);
    	
        // Atualize a janela principal com o painel inicial
        getContentPane().removeAll();
        add(homePanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void exibirTelaDepartamentos(ArrayList<Departamento> listaDepartamentos) {
        // Crie o painel para a tela de departamentos
        JPanel departamentosPanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Departamentos");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JButton voltarButton = new JButton("Voltar");
    	voltarButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			exibirTelaInicial();
    		}
    	});
    	
    	JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	titlePanel.add(voltarButton);
    	titlePanel.add(titleLabel);
        
        departamentosPanel.add(titlePanel, BorderLayout.NORTH);
        
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        // Crie os botões dinamicamente com base na lista de departamentos
        for (Departamento departamento : listaDepartamentos) {
            JButton departamentoButton = new JButton(departamento.getNome());
            // Defina a função do botão para ir para a tela do departamento selecionado
            departamentoButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    exibirTelaDepartamentoSelecionado(departamento,listaDepartamentos);
                }
            });
            buttonsPanel.add(departamentoButton);
        }
        departamentosPanel.add(buttonsPanel, BorderLayout.CENTER);

        // Atualize a janela principal com o painel de departamentos
        getContentPane().removeAll();
        add(departamentosPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void exibirTelaDepartamentoSelecionado(Departamento departamento, ArrayList<Departamento> listaDepartamentos) {
        // Painel principal
        JPanel departamentoSelecionadoPanel = new JPanel(new BorderLayout());
        
        JLabel titleLabel = new JLabel(departamento.getNome());
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

    	JButton voltarButton = new JButton("Voltar");
    	voltarButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			exibirTelaDepartamentos(listaDepartamentos);
    		}
    	});

        JLabel mediaVendasLabel = new JLabel("Média de Vendas: " + departamento.mediaVendaFuncionarios());
        mediaVendasLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(voltarButton);
        titlePanel.add(titleLabel);
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titlePanel, BorderLayout.NORTH);
        topPanel.add(mediaVendasLabel, BorderLayout.CENTER);

        departamentoSelecionadoPanel.add(titlePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton listarFuncionariosButton = new JButton("Listar Funcionários");
        // Defina a função do botão para ir para a tela de funcionários
        listarFuncionariosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exibirTelaFuncionarios(departamento,listaDepartamentos);
            }
        });
        buttonPanel.add(listarFuncionariosButton);
        departamentoSelecionadoPanel.add(buttonPanel, BorderLayout.CENTER);

        // Atualize a janela principal com o painel do departamento selecionado
        getContentPane().removeAll();
        add(departamentoSelecionadoPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void exibirTelaFuncionarios(Departamento departamento, ArrayList<Departamento> listaDepartamentos) {
    	JPanel funcionariosPanel = new JPanel();
    	funcionariosPanel.setLayout(new BoxLayout(funcionariosPanel, BoxLayout.Y_AXIS));
    	
    	//Titulo
    	
    	JLabel titleLabel = new JLabel("Funcionários");
    	titleLabel.setHorizontalAlignment(JLabel.CENTER);
    	
    	JButton voltarButton = new JButton("Voltar");
    	voltarButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			exibirTelaDepartamentoSelecionado(departamento,listaDepartamentos);
    		}
    	});
    	
    	JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	titlePanel.add(voltarButton);
    	titlePanel.add(titleLabel);
    	
    	funcionariosPanel.add(titlePanel, BorderLayout.NORTH);
    	
    	//Gerentes
    	ArrayList<Gerente> gerentes = departamento.getGerentes();
    	
    	if(gerentes.size() > 0) {
	    	JLabel gerenteLabel = new JLabel("Gerentes:");
	    	gerenteLabel.setHorizontalAlignment(JLabel.LEADING);
	    	
	    	JPanel gerentesPanel = new JPanel();
	    	gerentesPanel.setLayout(new BoxLayout(gerentesPanel, BoxLayout.Y_AXIS));
	    	
	    	gerentesPanel.add(gerenteLabel);
	    	
	
	    	for(Gerente g: gerentes) {
	    		JPanel gerentePanel = new JPanel(new FlowLayout());
	    		
	    		JLabel gerenteNomeLabel = new JLabel(g.getNome());
	
	    		JButton gerenteButton = new JButton("Remover");
	            gerenteButton.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                	departamento.removerFuncionario(g);
	                	exibirTelaFuncionarios(departamento,listaDepartamentos);
	                }
	            });
	            gerentePanel.add(gerenteNomeLabel);
	            gerentePanel.add(gerenteButton);
	            
	            gerentesPanel.add(gerentePanel);
	    	}
	    	
	    	funcionariosPanel.add(gerentesPanel, BorderLayout.CENTER);
    	}
    	
    	//Linha vazia
    	funcionariosPanel.add(Box.createVerticalStrut(10));
    	
    	//Vendedores:
    	ArrayList<Vendedor> vendedores = departamento.getVendedores();
    	
    	if(vendedores.size() > 0) {
	    	JLabel vendedorLabel = new JLabel("Vendedores:");
	    	vendedorLabel.setHorizontalAlignment(JLabel.LEADING);
	    	
	    	JPanel vendedoresPanel = new JPanel();
	    	vendedoresPanel.setLayout(new BoxLayout(vendedoresPanel, BoxLayout.Y_AXIS));
	    	
	    	vendedoresPanel.add(vendedorLabel);
	    	
	    	
	    	for(Vendedor v: vendedores) {
	    		JPanel vendedorPanel = new JPanel(new FlowLayout());
	    		
	    		JLabel vendedorNomeLabel = new JLabel(v.getNome());
	
	    		JButton vendedorButton = new JButton("Remover");
	            vendedorButton.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    departamento.removerFuncionario(v);
	                	exibirTelaFuncionarios(departamento,listaDepartamentos);
	                }
	            });
	            vendedorPanel.add(vendedorNomeLabel);
	            vendedorPanel.add(vendedorButton);
	            
	            vendedoresPanel.add(vendedorPanel);
	    	}
	    	
	    	funcionariosPanel.add(vendedoresPanel, BorderLayout.CENTER);
    	}
    	
    	if(vendedores.size() <= 0 && gerentes.size() <= 0) {
    		JLabel nenhumLabel = new JLabel("Nenhum Funcionário");
    		nenhumLabel.setHorizontalAlignment(JLabel.CENTER);
    		
    		JPanel nenhumPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    		nenhumPanel.add(nenhumLabel);

        	funcionariosPanel.add(nenhumPanel, BorderLayout.NORTH);
    	}
    	
        // Atualize a janela principal com o painel dos funcionários departamento selecionado
        getContentPane().removeAll();
        add(funcionariosPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void exibirTelaFolhaPagamento(ArrayList<FolhaPagamento> listaFolhas) {
    	JPanel folhaPagamentoPanel = new JPanel();
    	folhaPagamentoPanel.setLayout(new BoxLayout(folhaPagamentoPanel, BoxLayout.Y_AXIS));
    	
    	JLabel titleLabel = new JLabel("Folha de Pagamento");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        
        JButton voltarButton = new JButton("Voltar");
    	voltarButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			exibirTelaInicial();
    		}
    	});
    	
    	JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    	titlePanel.add(voltarButton);
    	titlePanel.add(titleLabel);
        
        folhaPagamentoPanel.add(titlePanel, BorderLayout.NORTH);
        
        //For de todos os departamentos, cada index do for printa todos as folha de pagamento
        for(Departamento d: listaDepartamentos) {
        	JLabel departamentoLabel = new JLabel(d.getNome());
        	departamentoLabel.setHorizontalAlignment(JLabel.CENTER);
        	
	    	JPanel departamentoPanel = new JPanel();
	    	departamentoPanel.setLayout(new BoxLayout(departamentoPanel, BoxLayout.Y_AXIS));
	    	departamentoPanel.add(departamentoLabel);
        	
        	for(FolhaPagamento f: listaFolhas) {
        		if(f.getDepartamento() == d) {
        			JLabel mesLabel = new JLabel(f.getMes().name());
        			mesLabel.setHorizontalAlignment(JLabel.CENTER);
        			
        			JLabel salarioLabel = new JLabel(""+f.getTotalSalarios());
        			salarioLabel.setHorizontalAlignment(JLabel.CENTER);
        			
        			JPanel folhaPanel = new JPanel(new FlowLayout());
        			folhaPanel.add(mesLabel);
        			folhaPanel.add(salarioLabel);
        			
        	    	departamentoPanel.add(folhaPanel);
        		}
        	}
            folhaPagamentoPanel.add(departamentoPanel, BorderLayout.CENTER);
        }
    	
    	// Atualize a janela principal com o painel das folhas de pagamento
        getContentPane().removeAll();
        add(folhaPagamentoPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
}
