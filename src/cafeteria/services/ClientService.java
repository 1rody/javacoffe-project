package cafeteria.services;

import java.util.ArrayList;
import java.util.Comparator;

import cafeteria.entities.Client;

/** Serviço de clientes: lista em memória com cadastro, remoção, alteração e listagem (inicia com 7 clientes). */
public class ClientService {
    private ArrayList <Client> clients = new ArrayList<>();

    /** Adiciona um cliente. */
    public void addClient(Client client){
        clients.add(client);
    }
    /** Remove o cliente pelo CPF; retorna true se removeu. */
    public boolean removeClient(String cpf){
        return clients.removeIf(e -> e.getCpf().equals(cpf));
    }
    /** Retorna os clientes na ordem de cadastro. */
    public ArrayList<Client> getClients(){
        return clients;
    }
    /** Retorna uma cópia ordenada por nome. */
    public ArrayList<Client> getClientsSorted(){
        ArrayList<Client> sorted = new ArrayList<>(clients); //copia para nao alterar a ordem de cadastro
        sorted.sort(Comparator.comparing(c -> c.getName())); //ordena por nome
        return sorted;
    }
    /** Altera nome e e-mail do cliente do CPF; retorna false se não achar. */
    public boolean updateClient(String cpf, String name, String email){
        for (Client client : clients) {
            if (client.getCpf().equals(cpf)) {
                client.setName(name);
                client.setEmail(email);
                return true; //alterou
            }
        }
        return false; //nao achou o cliente
    }

    /** Inicia com 7 clientes de exemplo. */
    public ClientService(){
        clients.add(new Client("Jose", "jose@gmail.com", "000.000.000-01"));
        clients.add(new Client("Claudio","claudio@hotmail.com" ,"000.000.000-02"));
        clients.add(new Client("Aline", "aline@yahoo.com","000.000.000-03"));
        clients.add(new Client("Marilene","marilene@gmail.com","000.000.000-04"));
        clients.add(new Client("Cleiton","cleiton@gmail.com","000.000.000-05"));
        clients.add(new Client("Sara","sara@yahoo.com","000.000.000-06"));
        clients.add(new Client("Adilson", "adilson@hotmail.com", "000.000.000-07"));
    }
}