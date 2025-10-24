import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Clients {
    private List<Client> clients;

    public Clients() {
        this.clients = new ArrayList<>();
    }

    public void addClient(Client c) {
        this.clients.add(c);
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public Client getClient(int id) {
        return this.clients.stream().filter(x -> x.getId() == id)
                .collect(Collectors.toList()).get(0);
    }

}
