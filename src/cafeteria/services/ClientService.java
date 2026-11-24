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
}