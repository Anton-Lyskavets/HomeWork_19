package JavaPVT.HW_19_3;

public class Topping {
    private   String id;
    private   String type;

    public Topping() {
    }

    public Topping(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
