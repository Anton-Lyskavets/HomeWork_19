package JavaPVT.HW_19_3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Donut {
    String id;
    String type;
    String name;
    Double ppu;
    Topping[] topping;

    public Donut() {
    }

    public Donut(String id, String type, String name, Double ppu, Topping[] topping) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.ppu = ppu;
        this.topping = topping;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPpu() {
        return ppu;
    }

    public void setPpu(Double ppu) {
        this.ppu = ppu;
    }

    public Topping[] getTopping() {
        return topping;
    }

    public void setTopping(Topping[] topping) {
        this.topping = topping;
    }

    @Override
    public String toString() {
        return "Donut{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", ppu=" + ppu +
                ", topping=" + Arrays.toString(topping) +
                '}';
    }
}