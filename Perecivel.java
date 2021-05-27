import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class Perecivel extends Produto{
	private boolean refrigerado;
  private String isRef;
  private int codigo;
	private String nome;
	private String fabricante;
	private double quantidade;
	private double valor;
  private LocalDate dtBase;

  public Perecivel(){

  }

  public Perecivel(int codigo, String nome, String fabricante, double quantidade, double valor, LocalDate validade, boolean refrigerado){
    super(codigo, nome, fabricante, quantidade, valor, validade);
    this.codigo = codigo;
    this.nome = nome;
    this.valor = valor;
    this.quantidade = quantidade;
    this.dtBase = validade;
    this.refrigerado = refrigerado;
    this.fabricante = fabricante;
  }

  public String isRefrigerado(boolean vaiqprecisa) {
    if(vaiqprecisa == true){
      this.isRef = "Sim";
    }
    else{
      this.isRef = "Não";
    }
    return " ";
  }

  @Override
  public String toString(){
    isRefrigerado(refrigerado);

    
    String dtCorreto = dtBase.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    return "Codigo: " + codigo + ", Nome: " + nome + ", Validade: " + dtCorreto + ", Refrigerado? " + isRef + " Quantidade: " + quantidade + " Fabricante " + fabricante + " Valor: " + valor;

  }

}
