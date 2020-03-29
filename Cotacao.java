
public class Cotacao {
	
	private String dataDoPedido;
	private String prazoDeRecebimento;
	private String observacao;
	private int quantidade;
	private float unidade;
	private Produto produto;
	
	public Cotacao(String dataDoPedido, String prazoDeRecebimento, int quantidade, float unidade, String observacao, Produto produto) {
		this.dataDoPedido = dataDoPedido;
		this.prazoDeRecebimento = prazoDeRecebimento;
		this.observacao = observacao;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.produto.setDescricao(produto.getDescricao());
		this.produto.setFornecedor(produto.getFornecedor());
		this.produto.setNome(produto.getNome());
		this.produto.setPreco(produto.getPreco());
	}

	public String getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(String dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	public String getPrazoDeRecebimento() {
		return prazoDeRecebimento;
	}

	public void setPrazoDeRecebimento(String prazoDeRecebimento) {
		this.prazoDeRecebimento = prazoDeRecebimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getUnidade() {
		return unidade;
	}

	public void setUnidade(float unidade) {
		this.unidade = unidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
