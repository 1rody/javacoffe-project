package cafeteria.entities;

/**
 * Café do cardápio e item de pedido. A flag lactose significa "contém lactose" no cardápio
 * e "cliente intolerante" no pedido.
 */
public class Coffee {
    private String coffeename;
    private Double price = 0.0;
    private String description;
    private Boolean lactose = false;

    /** Cria o café vazio. */
    public Coffee() {}

    /** Cria o café com nome, preço, descrição e lactose. */
    public Coffee(String coffeename, Double price, String description, Boolean lactose){
        this.coffeename = coffeename;
        this.price = price;
        this.description = description;
        this.lactose = lactose;
    }

    /** Retorna o nome. */
    public String getCoffeename() {
        return coffeename;
    }

    /** Altera o nome. */
    public void setCoffeename(String coffeename) {
        this.coffeename = coffeename;
    }

    /** Retorna o preço. */
    public Double getPrice() {
        return price;
    }

    /** Altera o preço. */
    public void setPrice(Double price) {
        this.price = price;
    }

    /** Retorna a descrição. */
    public String getDescription() {
        return description;
    }

    /** Altera a descrição. */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Retorna a flag de lactose. */
    public Boolean getLactose() {
        return lactose;
    }

    /** Altera a flag de lactose. */
    public void setLactose(Boolean lactose) {
        this.lactose = lactose;
    }

    /** Retorna a mensagem sobre a intolerância à lactose. */
    public String statusLactose(Boolean lactose){
        //status de intolerância (tem ou não)
        if(lactose==true){
            return "Cliente declarou que possui Intolerância à lactose.";
        }else{
            return "Cliente não afirmou Intolerância à lactose.";
        }
    }

    /** Descreve o produto em texto. */
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