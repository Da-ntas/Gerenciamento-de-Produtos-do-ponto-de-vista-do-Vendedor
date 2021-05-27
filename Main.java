import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

public static void main(String[] args) {

  GerenciarProduto prod = new GerenciarProduto();
  DateTimeFormatter dtFormatt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  String data = "31/12/9999";
  LocalDate nd;
  nd = LocalDate.parse(data, dtFormatt);
  String sair = "a";
  Scanner entrada = new Scanner(System.in);
  String opc;
  String fab;
  int cod;
  int qnt;
  

  System.out.println("------------------------------------");
  System.out.println("Iniciando o produtos");
  System.out.println("------------------------------------");

  while(!sair.equals("sair")){
    System.out.println("\nO que deseja fazer?");
    System.out.println("(0) Adicionar produtos");
    System.out.println("(1) Remover produto");
    System.out.println("(2) Listar todos os produtos");
    System.out.println("(3) Listar somente os Eletronicos");
    System.out.println("(4) Listar somente os Moveis");
    System.out.println("(5) Listar somente os Pereciveis");
    System.out.println("(6) Buscar por Código");
    System.out.println("(7) Buscar por Fabricante");
    System.out.println("(8) Buscar Estoque menor que:");
    System.out.println("(9) Buscar Estoque vazio");
    System.out.println("(10) Buscar por data de Validade");
    System.out.println("(11) Vender Produtos");
    System.out.println("(12) Comprar Produtos");
    System.out.println("(sair) para sair\n");
    opc = entrada.next();

    
    // remove produtos
    if(opc.equals("0")){
      Scanner adc = new Scanner (System.in);
      String enc = "a";
      String add;

      //variaveis gerais
      int codigo;
      String nome;
      String fabricante;
      double quantidade;
      double valor;

      //variaveis dos eletronicos
      int voltagem;
      int potencia;
      String classf;

      //variavel dos moveis
      String material;

      //variaveis dos pereciveis
      String validade;
      boolean isRef;
      LocalDate dtBase;

      while(!enc.equals("sair")){
        System.out.println("\nQual tipo de produto deseja adicionar?");
        System.out.println("(0) Adicionar Eletronicos");
        System.out.println("(1) Adicionar Moveis");
        System.out.println("(2) Adicionar Pereciveis");
        System.out.println("(sair) para sair\n");
        add = adc.next();

        //adicionando eletornicos
        if(add.equals("0")){
          //codigo
          System.out.println("\nDigite o código do eletronico: ");
          codigo = adc.nextInt();
          //nome
          System.out.println("Digite o nome do eletronico: ");
          nome = adc.next();
          //fabricante
          System.out.println("Digite o fabricante do eletornico: ");
          fabricante = adc.next();
          //quant
          System.out.println("Digite a quantidade desse eletronico: ");
          quantidade = adc.nextDouble();
          //valor
          System.out.println("Digite o valor desse eletronico: ");
          valor = adc.nextDouble();
          //voltagem
          System.out.println("Digite a voltagem desse eletronico: ");
          voltagem = adc.nextInt();
          //potencia
          System.out.println("Digite a potencia desse eletronico: ");
          potencia = adc.nextInt();
          //classificacao
          System.out.println("Digite a classificação(A, B, C, D, E) desse eletronico: ");
          classf = adc.next();
          Produto elet = new Eletronico(codigo, nome, fabricante, quantidade, valor, voltagem, potencia, classf, nd);
          prod.adicionar(elet);
        }

        //adicionando moveis
        else if(add.equals("1")){
          //codigo
          System.out.println("\nDigite o código do movel: ");
          codigo = adc.nextInt();
          //nome
          System.out.println("Digite o nome do movel: ");
          nome = adc.next();
          //fabricante
          System.out.println("Digite o fabricante do movel: ");
          fabricante = adc.next();
          //quant
          System.out.println("Digite a quantidade desse movel: ");
          quantidade = adc.nextDouble();
          //valor
          System.out.println("Digite o valor desse movel: ");
          valor = adc.nextDouble();
          //material
          System.out.println("Digite o material desse movel: ");
          material = adc.next();
          Produto mv = new Movel(codigo, nome, fabricante, quantidade, valor, material, nd);
          prod.adicionar(mv);
        }

        //adicionando pereciveis
        else if(add.equals("2")){
          //codigo
          System.out.println("\nDigite o código do perecivel: ");
          codigo = adc.nextInt();
          //nome
          System.out.println("Digite o nome do perecivel: ");
          nome = adc.next();
          //fabricante
          System.out.println("Digite o fabricante do perecivel: ");
          fabricante = adc.next();
          //quant
          System.out.println("Digite a quantidade desse perecivel: ");
          quantidade = adc.nextDouble();
          //valor
          System.out.println("Digite o valor desse perecivel: ");
          valor = adc.nextDouble();
          //material
          System.out.println("Digite a data de validade do perecivel (dd/mm/aaaa): ");
          validade = adc.next();
          dtBase = LocalDate.parse(validade, dtFormatt);
          System.out.println("É refrigerado? Se sim, digite 'true', se não, digite 'false' ");
          isRef = adc.nextBoolean();
          Produto prv = new Perecivel(codigo, nome, fabricante, quantidade, valor, dtBase, isRef);
          prod.adicionar(prv);
        }
        enc = add;
  }
    }

    if(opc.equals("1")){
      System.out.println("\nDigite o código que deseja remover:\n");
      cod = entrada.nextInt();
      prod.remover(cod);
    }

    // lista todos os produtos
    if(opc.equals("2")){
      System.out.println("\n--------Listando todos os Produtos--------\n");
      prod.listarTudo();
    }

    //lista os protudos do tipo eletronico
    else if(opc.equals("3")){
      System.out.println("\n--------Listando todos os Eletronicos--------\n");
       prod.listarEletronicos();
    }

    //lista os produtos do tipo movel
    else if(opc.equals("4")){
      System.out.println("\n--------Listando todos os Moveis--------\n");
       prod.listarMoveis();      
    }

    //lista os produtos do tipo perecivel
    else if(opc.equals("5")){
      System.out.println("\n--------Listando todos os Pereciveis--------\n");
       prod.listarPereciveis();
    }

    //busca o produto pelo codigo especificado
    if(opc.equals("6")){//listar por cod
      System.out.println("\nDigite por qual código deseja procurar: \n");
      cod = entrada.nextInt();
      prod.buscarPorCodigo(cod);
    }

    //busca os produtos pelo fabricando especificado
    if(opc.equals("7")){//listar por fabricante
      System.out.println("\nDigite por qual fabricante deseja procurar: \n");
      fab = entrada.next();
      prod.listarPorFabricante(fab);
    }

    //busca estoque menor que
    else if(opc.equals("8")){
      System.out.println("\nDeseja ver o estoque menor à...:\n");
      qnt = entrada.nextInt();
      prod.listarEstoqueMenorQue(qnt);
    }
    
    //buscar estoque vazio
    else if(opc.equals("9")){
      System.out.println("\n--------Listando Estoque Vazio--------\n");
      prod.listarEstoqueVazio();
    }

    //listar por validades
    else if(opc.equals("10")){//listar por data de validade
    Scanner val = new Scanner (System.in);
    String enc = "a";
    String valid;
    String dt1;
    String dt2;
    LocalDate data1;
    LocalDate data2;

    while(!enc.equals("sair")){
      System.out.println("\n(0) Listar entre uma data minima e maxima");
      System.out.println("(1) Listar por uma data de validade");
      System.out.println("(sair) para sair\n");
      valid = val.next();

      if(valid.equals("0")){
        System.out.println("\nDigite a data de validade minima (dd/mm/aaaa)");
        dt1 = val.next();
        data1 = LocalDate.parse(dt1, dtFormatt);

        System.out.println("Digite a data de validade maxima (dd/mm/aaaa)");
        dt2 = val.next();
        data2 = LocalDate.parse(dt2, dtFormatt);
        
        prod.listarPorValidade(data1, data2);
      }
      else if(valid.equals("1")){
        System.out.println("Digite a data de validade (dd/mm/aaaa)");
        dt2 = val.next();
        data2 = LocalDate.parse(dt2, dtFormatt);
        prod.listarPorValidade(data2);
      }

      enc = valid;
    }
      
    }

    //realiza a venda dos produtos
    if(opc.equals("11")){//vender produtos
      System.out.println("\nDigite o código do produto da venda:");
      cod = entrada.nextInt();
      System.out.println("\nDigite a quantidade de produtos a serem vendidos: \n");
      qnt = entrada.nextInt();
      prod.venderProduto(cod, qnt);
    }

    //realiza a compra dos produtos
    if(opc.equals("12")){//comprar produtos
      System.out.println("\nDigite o código do produto da compra:");
      cod = entrada.nextInt();
      System.out.println("\nDigite a quantidade de produtos que foram comprados: \n");
      qnt = entrada.nextInt();
      prod.comprarProduto(cod, qnt);
    }
    sair = opc;
  }
  //Produto p1 = new Movel(cod, prod, marc, quant, val, tipm);
}
}



