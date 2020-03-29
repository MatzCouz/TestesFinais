import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class main {

    static int itemSelected = 0;
	
	public static void main(String[] args) {
		
		
		
		JFrame frame = new JFrame("ACME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 250);
		
		JPanel panelTop = new JPanel();
		JPanel panelBottom = new JPanel();

		
		JButton cadastrarProdutos = new JButton("CADASTRAR PRODUTOS");
        JButton cadastrarCotacoes = new JButton("CADASTRAR COTAÇÕES");
        JButton consultarCotacoes = new JButton("CONSULTAR COTAÇÕES");
        JButton exportarCotacoes =  new JButton("EXPORTAR COTAÇÕES");
        
        
        
        cadastrarProdutos.setPreferredSize(new Dimension(180, 30)); 
        cadastrarCotacoes.setPreferredSize(new Dimension(180, 30)); 
        consultarCotacoes.setPreferredSize(new Dimension(180, 30)); 
        exportarCotacoes.setPreferredSize(new Dimension(180, 30)); 

        
        JLabel labelCadastro = new JLabel("PAINEL DE CADASTRO", JLabel.CENTER);
        JLabel labelConsultas = new JLabel("PAINEL DE CONSULTA", JLabel.CENTER);
        JLabel labelFinish = new JLabel("                                 ", JLabel.CENTER);

        

        
        frame.add(labelCadastro);
        frame.add(cadastrarProdutos);
        frame.add(cadastrarCotacoes);
        frame.add(labelConsultas);
        frame.add(consultarCotacoes);
        frame.add(exportarCotacoes);
        frame.add(labelFinish);
    
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setLocation(500, 300);
        frame.setVisible(true);
        
        cadastrarProdutos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registrarProduto();
			}
		});
        
        cadastrarCotacoes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				registrarCotacao();
			}
		});
        
        consultarCotacoes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				consultarCotacao();
			}
		});
        
	}
	
	public static void consultarCotacao() {
		
		
		
		JFrame frame = new JFrame("CONSULTAR COTAÇÃO");
	    frame.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent w)
	        {
	        frame.dispose();
	        }       
	    });
	    frame.setSize(370, 350);
		
		
		JLabel labelPesquisa = new JLabel("CONSULTAR COTAÇÕES POR NOME DE PRODUTO", JLabel.CENTER);
		JButton pesquisa = new JButton("PESQUISAR");
		JTextField textPesquisa = new JTextField(20);
		TextArea textArea = new TextArea("Lista dos valores", 10, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
		
		
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        frame.add(labelPesquisa);
        frame.add(textPesquisa);
        frame.add(pesquisa);
        frame.add(textArea);
        
        
        frame.setLocation(500, 300);
		frame.setVisible(true);
		
	}
	
	public static void registrarProduto() {
		
		
		JFrame frame2 = new JFrame("CADASTRAR PRODUTO");
		frame2.setSize(260, 300);
	    frame2.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent w)
	        {
	        frame2.dispose();
	        }       
	    });
		
        JLabel labelNome = new JLabel("NOME DO PRODUTO:", JLabel.RIGHT);
        JLabel labelFornecedor = new JLabel("FORNECEDOR: ", JLabel.RIGHT);
        JLabel labelDescricao = new JLabel("DESCRIÇÃO: ", JLabel.RIGHT);

        JTextField textNome = new JTextField(20);
        JTextField textFornecedor = new JTextField(20);
        TextArea textDescricao = new TextArea("", 3, 29, TextArea.SCROLLBARS_VERTICAL_ONLY);
        
        JButton saveProduct = new JButton("SALVAR");        
        
        frame2.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        frame2.add(labelNome);
        frame2.add(textNome);
        frame2.add(labelFornecedor);
        frame2.add(textFornecedor);
        frame2.add(labelDescricao);
        frame2.add(textDescricao);
        frame2.add(saveProduct);
        
        frame2.setLocation(500, 300);
		frame2.setVisible(true);
		
		saveProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(textNome.getText().compareTo("") == 0)
		            JOptionPane.showMessageDialog(null, "Campo do nome não pode ser vazio!","ERRO", JOptionPane.INFORMATION_MESSAGE);
				if(textFornecedor.getText().compareTo("") == 0 )
		            JOptionPane.showMessageDialog(null, "Campo do fornecedor não pode ser vazio!","ERRO", JOptionPane.INFORMATION_MESSAGE);
				if(textDescricao.getText().compareTo("") == 0 )
		            JOptionPane.showMessageDialog(null, "Campo da descrição não pode ser vazio!","ERRO", JOptionPane.INFORMATION_MESSAGE);

				System.out.println(textNome.getText());
				System.out.println(textFornecedor.getText());
				System.out.println(textDescricao.getText());
			
			
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public static void registrarCotacao() {
		
		
		JFrame frame2 = new JFrame("CADASTRAR COTAÇÃO");
	    frame2.addWindowListener(new WindowAdapter(){
	        public void windowClosing(WindowEvent w)
	        {
	        frame2.dispose();
	        }       
	    });		
	    frame2.setSize(350, 400);
		
		JLabel labelNome = new JLabel("NOME DO PRODUTO: ", JLabel.LEFT);
		JLabel labelData = new JLabel("DATA DO PEDIDO: ", JLabel.LEFT);
        JLabel labelPrazo = new JLabel("PRAZO DE ENTREGA: ", JLabel.LEFT);
        JLabel labelObservacao = new JLabel("OBSERVAÇÃO: ", JLabel.LEFT);
        JLabel labelQuantidade = new JLabel("QUANTIDADE: ", JLabel.LEFT);
        JLabel labelPreco = new JLabel("PREÇO: ", JLabel.LEFT);
        JLabel labelFornecedor = new JLabel("FORNECEDORES: ", JLabel.LEFT);
        JLabel labelProdutos = new JLabel("PRODUTOS: ", JLabel.LEFT);
        JLabel label = new JLabel("             ", JLabel.LEFT);


        JTextField textData = new JTextField(10);
        JTextField textPrazo = new JTextField(10);
        JTextField textPreco = new JTextField(10);
        JTextField textQuantidade = new JTextField(10);
        JTextArea textObservacao = new JTextArea();

        
        
        JComboBox listaProdutos = new JComboBox();
        JComboBox listaFornecedores = new JComboBox();
        
        
        for(int i=0; i<10; i++) {
        	listaProdutos.addItem(i + "aaa");
        }
        
        for(int i=0; i<10; i++) {
        	listaFornecedores.addItem("a" + i);
        }
        
        
		listaProdutos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
				itemSelected = listaProdutos.getSelectedIndex();
				System.out.println(itemSelected);
				
				
			}
				
			
		});
        
		System.out.println(itemSelected);

                
        JButton saveProduct = new JButton("SALVAR");        
        
        saveProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textPreco.getText().compareTo("") == 0)
		            JOptionPane.showMessageDialog(null, "Campo de preço não pode ser vazio!","ERRO", JOptionPane.INFORMATION_MESSAGE);
				if(textQuantidade.getText().compareTo("") == 0 )
		            JOptionPane.showMessageDialog(null, "Campo de quantidade não pode ser vazio!","ERRO", JOptionPane.INFORMATION_MESSAGE);
				if(textData.getText().compareTo("") == 0)
		            JOptionPane.showMessageDialog(null, "Campo de data do pedido não pode ser vazio!","ERRO", JOptionPane.INFORMATION_MESSAGE);
				if(textPrazo.getText().compareTo("") == 0 )
		            JOptionPane.showMessageDialog(null, "Campo de prazo não pode ser vazio!","ERRO", JOptionPane.INFORMATION_MESSAGE);
				
				String regex = "^(0?[1-9]|[12][0-9]|3[01])(/|-)(0?[1-9]|1[012])(/|-)((19|20)\\d\\d)$";
				if(!Pattern.matches(regex, textData.getText())) {
		            JOptionPane.showMessageDialog(null, "Campo de data com formato errado!","ERRO", JOptionPane.INFORMATION_MESSAGE);

				}				
			}
		});
        
        frame2.getContentPane().setLayout(new GridLayout(16, 1));
        
        frame2.add(labelNome);
        frame2.add(listaProdutos);
        frame2.add(labelFornecedor);
        frame2.add(listaFornecedores);
        frame2.add(labelData);
        frame2.add(textData);
        frame2.add(labelPrazo);
        frame2.add(textPrazo);
        frame2.add(labelQuantidade);
        frame2.add(textQuantidade);
        frame2.add(labelPreco);
        frame2.add(textPreco);
        frame2.add(labelObservacao);
        frame2.add(textObservacao);
        frame2.add(textObservacao);
        frame2.add(label);
        frame2.add(saveProduct);
        
        
        frame2.setLocation(500, 300);
		frame2.setVisible(true);
	}
}
