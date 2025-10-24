import java.util.Objects;

public class Client {
    private int id;
    private String nom;

    public Client(int id, String nom) {
        super();
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Client)) {
            return false;
        }
        Client other = (Client) obj;
        return this.id == other.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Client [id=" + this.id + ", nom=" + this.nom + "]";
    }

}
