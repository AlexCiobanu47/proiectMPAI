package eu.ase.ro.proiect.model;

import eu.ase.ro.proiect.enums.PriceUnit;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "space_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private float size;
    private int floor;
    private boolean isAvailable;
    private float price;
    @Enumerated(EnumType.STRING)
    private PriceUnit priceUnit;

    public Space() {
    }

    public Space(String name, String type, float size, boolean isAvailable, float price, PriceUnit priceUnit) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.isAvailable = isAvailable;
        this.price = price;
        this.priceUnit = priceUnit;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public float getSize() {
        return size;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public float getPrice() {
        return price;
    }

    public PriceUnit getPriceUnit() {
        return priceUnit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPriceUnit(PriceUnit priceUnit) {
        this.priceUnit = priceUnit;
    }

    public abstract void accept(SpaceVisitor visitor);

    @Override
    public String toString() {
        return "Space{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", isAvailable=" + isAvailable +
                ", price=" + price +
                ", priceUnit='" + priceUnit + '\'' +
                '}';
    }
}


