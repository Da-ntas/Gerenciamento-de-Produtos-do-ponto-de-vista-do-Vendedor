import java.util.ArrayList;
import java.time.LocalDate;

abstract class Produto {
    private ArrayList<String> nm = new ArrayList<>();
    private String nome;
    private ArrayList<String> fab = new ArrayList<>();
    private String fabricante;
    private ArrayList<Double> qnt = new ArrayList<>();
    private double quant;
    private ArrayList<Double> val = new ArrayList<>();
    private double valor;
    private ArrayList<Integer> cod = new ArrayList<>();
    private int codigo;
    private boolean isMenorQue;
    private int idxCod;
    private double nvqnt;
    private ArrayList<LocalDate> ld = new ArrayList<>();
    private LocalDate dt;
    private boolean isVdd;

    public Produto(){

    }

    public Produto(int codigo, String nome, String fabricante, double quantidade, double valor, LocalDate val) {
        this.codigo = codigo;
        this.cod.add(codigo);
        this.nome = nome;
        this.nm.add(nome);
        this.fabricante = fabricante;
        this.fab.add(fabricante);
        this.quant = quantidade;
        this.qnt.add(quantidade);
        this.valor = valor;
        this.val.add(valor);
        this.ld.add(val);
        this.dt = val;
    }

  public double vender(int quantidade) {
    this.nvqnt = 0;
    this.nvqnt = qnt.get(idxCod);
    if(nvqnt != 0){
    this.nvqnt = nvqnt - quantidade;
    this.qnt.add(idxCod, nvqnt);
    return quantidade * val.get(idxCod);
    }
    else{
      return -1;
    }
  }

  public double comprar(int quantidade) {
    this.nvqnt = 0;
    this.nvqnt = qnt.get(idxCod);
    this.nvqnt = nvqnt + quantidade;
    this.qnt.add(idxCod, nvqnt);
    return qnt.get(idxCod);
  }

  public String toString() {
      return "Codigo: " + cod.get(idxCod) + " Nome " + nm.get(idxCod) + " Quantidade " + qnt.get(idxCod) + " valor " + val.get(idxCod) ;
  }


    public boolean confereCodigo(int codgin){
      if(cod.contains(codgin)){
        this.idxCod = cod.indexOf(codgin);
        return true;
      }
      else{
        return false;
      }
    }

    public boolean confereEstoque(double etoqzin){
      for(int e = 0; e < qnt.size(); e++){
          if(qnt.get(e) < etoqzin){
            this.isMenorQue = true;
            return isMenorQue;
          }
          else{
            this.isMenorQue = false;
            return isMenorQue;
          }
      }
      return isMenorQue; 
    }

    public boolean confereEstoqueVazio(){
      for(int q = 0; q < qnt.size(); q++){
        if(qnt.get(q) == 0.0){
          this.isMenorQue = true;
            return isMenorQue;
        }
        else{
          this.isMenorQue = false;
          return isMenorQue;
        }
      }
      return isMenorQue;
    }

    public boolean confereFabricante(String fabrizin){
      for(int f = 0; f < fab.size(); f++){
        if(fab.get(f).equals(fabrizin)){
            this.isMenorQue = true;
            return isMenorQue;
        }
        else{
          this.isMenorQue = false;
          return isMenorQue;
        }
      }
      return isMenorQue;
    }

    public boolean confereDataValidade(LocalDate min, LocalDate max){
      for(int vl = 0; vl < ld.size(); vl++){
          if(ld.get(vl).isAfter(min) && ld.get(vl).isBefore(max)){
            this.isVdd = true;
            return isVdd;
          }
          else{
            this.isVdd = false;
            return isVdd;
          }
      }
      return isVdd;
    }

}

