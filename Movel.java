import java.util.ArrayList;
class Movel extends Produto {
	private String tipo_de_material;
  private int codigo;
	private String nome;
	private String fabricante;
	private double quantidade;
	private double valor;	

  public Movel(int codigo, String nome, String fabricante, double quantidade, double valor, String tipoMat){
    super(codigo, nome, fabricante, quantidade, valor);
    this.codigo = codigo;
    this.valor = valor;
    this.nome = nome;
    this.fabricante = fabricante;
    this.quantidade = quantidade;
    this.tipo_de_material = tipoMat;
  }

  @Override
  public String toString(){
    return "Codigo: " + codigo + " Nome: " + nome + " Tipo de material: " + tipo_de_material + " Quantidade: " + quantidade + " Fabricante " + fabricante + " Valor: " + valor;
  }

  
}