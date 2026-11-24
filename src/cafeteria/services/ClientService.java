package cafeteria.services;

import java.util.ArrayList;
import cafeteria.entities.Client;

public class ClientService {
    private ArrayList <Client> clients = new ArrayList<>();

    public void addClient(Client client){
        clients.add(client);
    }
    public boolean removeClient(String nameOrCpf){
        return clients.removeIf(e -> e.getCpf().equals(nameOrCpf));
    }
    public ArrayList<Client> getClients(){
        return clients;
    }

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