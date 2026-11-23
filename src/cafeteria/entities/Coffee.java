package cafeteria.entities;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String coffeename;
    private List<String> coffeeList = new ArrayList<>();
    private Double price =0.0;
    private String description;
    private Boolean lactose = false;

    public Coffee() {
        tipos();
    }

    public Coffee(String coffeename, Double price, String description, Boolean lactose){
        tipos();
        this.coffeename = coffeename;
        this.price = price;
        this.description = description;
        this.lactose = lactose;
    }

    public String getCoffeename() {
        return coffeename;
    }

    public void setCoffeename(String coffeename) {
        this.coffeename = coffeename;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getLactose() {
        return lactose;
    }

    public void setLactose(Boolean lactose) {
        this.lactose = lactose;
    }

    public List<String> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<String> coffeeList) {
        this.coffeeList = coffeeList;
    }

    private void tipos(){
        this.coffeeList.add("Expresso");
        this.coffeeList.add("Macchiato");
        this.coffeeList.add("Mocaccino");
        this.coffeeList.add("Cappuccino");
        this.coffeeList.add("Latte");
    }

    public void exibirTipos(){
        //exibe os tipos.
        if (coffeeList.isEmpty()) {
            System.out.println("|Nenhum tipo disponível no estoque.");
        }
        System.out.println("|Tipos disponíveis:");
        for (int i = 0; i < coffeeList.size(); i++) {
            System.out.println(coffeeList.get(i));
        }
    }

    public void controle(String coffeename){
        double precoBase = 8.0;
        this.coffeename = coffeename;
        //Para o toString exibir o item com o preço certo com base na escolha do cliente na interface do 'Programa.java'
        switch(coffeename){
            //Obs: precisa decidir como precificar
            case "Expresso":
                
                System.out.println("|Expresso (Descrição completa):\nBase: Café extraído sob alta pressão (9 bars) em água quente.\n\nProporção: 100% café concentrado (sem adição de leite).\n\nVolume médio: 30 ml a 40 ml.\n\nPerfil sensorial: Encorpado, intenso, com acidez equilibrada, amargor pronunciado e uma camada densa de espuma dourada na superfície (crema).\n\nServiço: Xícara pequena (demitasse) pré-aquecida.");

                description = "|Expresso[Café muito intenso; 100% de expresso; s/leite; 30-40 ml ; Xícara pequena.]";

                this.price = precoBase;

                break;

            case "Macchiato":
                
                System.out.println("|Macchiato (Descrição completa):\nBase: Café expresso com uma pequena quantidade de leite vaporizado.\n\nProporção: ~85% café expresso e ~15% espuma de leite.\n\nVolume médio: 40 ml a 50 ml.\n\nPerfil sensorial: Mantém a intensidade e o corpo do expresso, mas com a acidez suavizada e um leve toque adocicado da microespuma de leite (\"manchado\" na superfície).\n\nServiço: Xícara pequena (demitasse).");

                description = "|Macchiato[Café intenso; 85% de expresso; c/leite (15% de espuma); 40-50 ml ; Xícara pequena.]";

                this.price = precoBase + 2.0;

                break;

            case "Mocaccino":

                System.out.println("|Mocaccino (Descrição completa):\nBase: Café expresso, calda ou pó de chocolate, leite vaporizado e espuma de leite (ou chantilly).\n\nProporção: ~20% café expresso, ~15% chocolate, ~50% leite vaporizado e ~15% espuma de leite/chantilly.\n\nVolume médio: 200 ml a 250 ml.\n\nPerfil sensorial: Doce, encorpado e achocolatado; combina o amargor do café com a untuosidade do chocolate e a suavidade do leite.\n\nServiço: Copo alto de vidro ou caneca grande.");

                description = "|Mocaccino[Café Suave / Doce; 20% de expresso; c/leite (15% de espuma + 50% de leite vaporizado - 65%); 200-250 ml; 15% de chocolate; Xícara grande ou Copo alto de vidro.]";

                this.price = precoBase + 5.5;

                break;

            case "Cappuccino":

                System.out.println("|Cappuccino (Descrição completa):\nBase: Café expresso, leite vaporizado e camada espessa de espuma de leite.\n\nProporção: 1/3 café expresso, 1/3 leite vaporizado e 1/3 espuma de leite densa.\n\nVolume médio: 150 ml a 180 ml.\n\nPerfil sensorial: Equilibrado e aveludado, com presença marcante do café harmonizada pela cremosidade do leite. (Nota: na variação brasileira, costuma levar canela ou cacau em pó polvilhados).\nServiço: Xícara média de porcelana com boca larga.");

                description = "|Cappuccino[Café Médio; 33% de expresso; c/leite (33,5% de espuma densa + 33,5% de leite vaporizado - 67%); 150 - 180 ml; Xícara média com boca larga.]";

                this.price = precoBase + 4.0;

                break;

            case "Latte":

                System.out.println("|Latte (Descrição completa):\nBase: Café expresso diluído em grande volume de leite vaporizado.\n\nProporção: ~20% café expresso, ~70% leite vaporizado e ~10% camada fina de microespuma.\n\nVolume médio: 240 ml a 300 ml.\n\nPerfil sensorial: Suave, lácteo e cremoso, com o sabor do café em segundo plano e dulçor natural do leite em evidência. Ideal para latte art.\n\nServiço: Xícara grande ou copo alto de vidro.");

                description = "|Latte[Café suave; 20% de expresso; c/leite (70% de leite vaporizado + 10% camada fina de microespuma - 80%); 240-300 ml; Xícara grande ou Copo alto de vidro.]";

                this.price = precoBase + 5.0;

                break;

            default:
                System.out.println("Erro: <Nenhum tipo válido>\n");
                controle(coffeename);
        }
    }

    public String statusLactose(Boolean lactose){
        //status de intolerância (tem ou não)
        if(lactose==true){
            return "|Cliente declarou que possui Intolerância à lactose.";
        }else{
            return "|Cliente não afirmou Intolerância à lactose.";
        }
    }

    @Override
    public String toString() {
        //toString descrevendo informações sobre o produto (nome; preço; descrição do produto; intolerância à lactose.)
        return "Prezado Cliente obtenha informações do produto abaixo.\n|Produto: "+
                coffeename+"\n|Valor do produto: "+
                price+"\n|Descrição do produto: "+
                description+"\n|Situação de Intolerância à lactose:"+
                statusLactose(lactose);
    }

}