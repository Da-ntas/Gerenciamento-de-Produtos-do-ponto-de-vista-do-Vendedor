import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Eletronico extends Produto{
	private double voltagem;//110, 220, bivolt
	private double potencia;
	private String classEfic; //A, B, C, D, E
  private int codigo;
	private String nome;
	private String fabricante;
	private double quantidade;
	private double valor;	

  public Eletronico(int codigo, String nome, String fabricante, double quantidade, double valor, double voltagem, double potencia, String classEfic, LocalDate nd){
    super(codigo, nome, fabricante, quantidade, valor, nd);
    this.codigo = codigo;
    this.nome = nome;
    this.quantidade = quantidade;
    this.valor = valor;
    this.voltagem = voltagem;
    this.fabricante = fabricante;
    this.potencia = potencia;
    this.classEfic = classEfic;
  }

  @Override
  public String toString(){
    return "Codigo: " + codigo + " Nome: " + nome + " Voltagem: " + voltagem + " Potencia: " + potencia + " Classificação de eficiencia: " + classEfic + " Quantidade: " + quantidade + " Fabricante " + fabricante + " Valor: " + valor;
  }
  
  
}
