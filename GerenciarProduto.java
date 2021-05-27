import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class GerenciarProduto {
	private ArrayList<Produto> prods = new ArrayList<Produto>();
	private Produto val;
  private Perecivel data;
  private boolean isPossible;
  private String sla;

  public void adicionar(Produto p) {
    prods.add(p);
	}
	
	public boolean remover(int codigo) {
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      if(val.confereCodigo(codigo) == true){
        prods.remove(i);
        System.out.println("Removido com sucesso!");
      }
    }
    return false;
	}

  public Produto buscarPorCodigo(int codigo){
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      if(val.confereCodigo(codigo) == true){
        System.out.println(val);
      }
    }
    return val;
  }

  public String listarEletronicos(){
    for(int i = 0; i < prods.size(); i++){
      if(prods.get(i) instanceof Eletronico){
        System.out.println("--"+prods.get(i));
      }
    }
    return " ";
  }

  public String listarPereciveis(){
    for(int i = 0; i < prods.size(); i++){
      if(prods.get(i) instanceof Perecivel){
        System.out.println("--"+prods.get(i));
      }
    }
    return " ";
  }

  public String listarMoveis(){
    for(int i = 0; i < prods.size(); i++){
      if(prods.get(i) instanceof Movel){
        System.out.println("--"+prods.get(i));
      }
    }
    return " ";
  }

  public String listarEstoqueMenorQue(int quantidadeMinima){
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      if(val.confereEstoque(quantidadeMinima) == true){
        System.out.println(val);
      }
    }
    return " ";
  }

  public String listarEstoqueVazio(){
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      if(val.confereEstoqueVazio() == true){
        System.out.println(val);
      }
    }
    return " ";
  }

  public String listarPorFabricante(String fabricante){
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      if(val.confereFabricante(fabricante) == true){
        System.out.println(val);
      }
    }
    return " ";
  }

  //fazer
  public String listarPorValidade(LocalDate validade){
    String dt = validade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      this.sla = val.toString();
      if(sla.contains(dt)){
        System.out.println(val);
      }
    }
      return " ";
  }

  //fazer
  public String listarPorValidade(LocalDate minima, LocalDate maxima){
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      if(prods.get(i) instanceof Perecivel){
        if(val.confereDataValidade(minima, maxima) == true){
          System.out.println(val);
        }
      }
    }
      return " ";
  }

  //corrigir a quantidade ao imprimir após executar
  public double venderProduto(int codigoProduto, int quantidade){
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      if(val.confereCodigo(codigoProduto) == true){
        System.out.println("Valor da venda: " + val.vender(quantidade));
      }
    }
    return -1;
  }

  //corrigir a quantidade ao imprimir após executar
  public boolean comprarProduto(int codigoProduto, int quantidade){
    for(int i = 0; i < prods.size(); i++){
      this.val = prods.get(i);
      if(val.confereCodigo(codigoProduto) == true){
        val.comprar(quantidade);
        this.isPossible = true;
        return isPossible;
      }
      else{
        this.isPossible = false;
        return isPossible;
      }
    }
    return isPossible;
  }

  public String listarTudo(){
    for (int i = 0; i < prods.size(); i++){
      System.out.println("--"+prods.get(i));
    }
    return " ";
  }

  
}
