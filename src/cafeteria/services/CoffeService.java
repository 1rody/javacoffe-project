package cafeteria.services;

import cafeteria.entities.Coffee;

import java.util.ArrayList;

public class CoffeService {
    private ArrayList<Coffee> coffees = new ArrayList<>();

    public CoffeService() {
        coffees.add(new Coffee("Expresso", 8.0,
                "| Expresso:\nBase: Café extraído sob alta pressão (9 bars) em água quente.\n\nProporção: 100% café concentrado (sem adição de leite).\n\nVolume médio: 30 ml a 40 ml.\n\nPerfil sensorial: Encorpado, intenso, com acidez equilibrada, amargor pronunciado e uma camada densa de espuma dourada na superfície (crema).\n\nServiço: Xícara pequena (demitasse) pré-aquecida.",
                false));

        coffees.add(new Coffee("Macchiato", 10.0,
                "| Macchiato:\nBase: Café expresso com uma pequena quantidade de leite vaporizado.\n\nProporção: ~85% café expresso e ~15% espuma de leite.\n\nVolume médio: 40 ml a 50 ml.\n\nPerfil sensorial: Mantém a intensidade e o corpo do expresso, mas com a acidez suavizada e um leve toque adocicado da microespuma de leite (\"manchado\" na superfície).\n\nServiço: Xícara pequena (demitasse).",
                true));

        coffees.add(new Coffee("Mocaccino", 13.5,
                "| Mocaccino:\nBase: Café expresso, calda ou pó de chocolate, leite vaporizado e espuma de leite (ou chantilly).\n\nProporção: ~20% café expresso, ~15% chocolate, ~50% leite vaporizado e ~15% espuma de leite/chantilly.\n\nVolume médio: 200 ml a 250 ml.\n\nPerfil sensorial: Doce, encorpado e achocolatado; combina o amargor do café com a untuosidade do chocolate e a suavidade do leite.\n\nServiço: Copo alto de vidro ou caneca grande.",
                true));

        coffees.add(new Coffee("Cappuccino", 12.0,
                "| Cappuccino:\nBase: Café expresso, leite vaporizado e camada espessa de espuma de leite.\n\nProporção: 1/3 café expresso, 1/3 leite vaporizado e 1/3 espuma de leite densa.\n\nVolume médio: 150 ml a 180 ml.\n\nPerfil sensorial: Equilibrado e aveludado, com presença marcante do café harmonizada pela cremosidade do leite. (Nota: na variação brasileira, costuma levar canela ou cacau em pó polvilhados).\nServiço: Xícara média de porcelana com boca larga.",
                true));

        coffees.add(new Coffee("Latte", 13.0,
                "| Latte:\nBase: Café expresso diluído em grande volume de leite vaporizado.\n\nProporção: ~20% café expresso, ~70% leite vaporizado e ~10% camada fina de microespuma.\n\nVolume médio: 240 ml a 300 ml.\n\nPerfil sensorial: Suave, lácteo e cremoso, com o sabor do café em segundo plano e dulçor natural do leite em evidência. Ideal para latte art.\n\nServiço: Xícara grande ou copo alto de vidro.",
                true));
    }

    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }

    public boolean removeCoffee(String name) {
        return coffees.removeIf(e -> e.getCoffeename().equals(name));
    }

    public Coffee searchCoffee(String name) {
        for (Coffee coffee : coffees) {
            if (coffee.getCoffeename().equalsIgnoreCase(name)) {
                return coffee;
            }
        }
        return null;
    }

    public ArrayList<Coffee> getCoffees() {
        return coffees;
    }
}