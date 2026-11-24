package cafeteria.entities;

public class Coffee {
    private String coffeename;
    private Double price = 0.0;
    private String description;
    private Boolean lactose = false;

    public Coffee() {}

    public Coffee(String coffeename, Double price, String description, Boolean lactose){
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

    public String statusLactose(Boolean lactose){
        //status de intolerância (tem ou não)
        if(lactose==true){
            return "Cliente declarou que possui Intolerância à lactose.";
        }else{
            return "Cliente não afirmou Intolerância à lactose.";
        }
    }

    @Override
    public String toString() {
        //toString descrevendo informações sobre o produto (nome; preço; descrição do produto; intolerância à lactose.)
        return "Prezado Cliente obtenha informações do produto abaixo.\n| Produto: "+
                coffeename+"\n| Valor do produto: "+
                price+"\n| Descrição do produto: "+
                description+"\n| Situação de Intolerância à lactose: "+
                statusLactose(lactose);
    }

}