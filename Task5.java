import java.util.Arrays;
import java.util.Objects;

public class Task5 {
    public static void main(String[] args) {
        Transport[] vehicles = new Transport[4];
        try {
            vehicles[0] = new Car("Toyota", 180);
            vehicles[1] = new Bicycle("Stels", 30);
            vehicles[2] = new Car("BMW", 250);
            vehicles[3] = new Bicycle(null, -5); 
        } catch (IllegalArgumentException e) {
            System.out.println("Поймали ошибку (catch): " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполнился.");
        }
        vehicles[3] = new Bicycle("Aist", 25);
        System.out.println("\nДо сортировки:");
        for (Transport t : vehicles) {
            if (t != null) {
                System.out.println(t.toString());
            }
        }
        Arrays.sort(vehicles);
        System.out.println("\nПосле сортировки по скорости:");
        for (Transport t : vehicles) {
            if (t != null) {
                System.out.println(t.toString());
            }
        }
    }
}

abstract class Transport implements Comparable<Transport> {
    private String name;
    private int maxSpeed;
    public Transport(String name, int maxSpeed) {
        this.name = Objects.requireNonNull(name, "Имя не может быть null!");
        if (maxSpeed < 0) {
            throw new IllegalArgumentException("Скорость не может быть отрицательной!");
        }
        this.maxSpeed = maxSpeed;
    }
    public String getName() { return name; }
    public int getMaxSpeed() { return maxSpeed; }
    public abstract String getDescription();
    @Override
    public int compareTo(Transport other) {
        return Integer.compare(this.maxSpeed, other.maxSpeed);
    }
    @Override
    public String toString() {
        return getDescription() + ", скорость: " + maxSpeed;
    }
}
class Car extends Transport {
    public Car(String name, int maxSpeed) {
        super(name, maxSpeed);
    }
    @Override
    public String getDescription() {
        return "Машина: " + getName();
    }
}
class Bicycle extends Transport {
    public Bicycle(String name, int maxSpeed) {
        super(name, maxSpeed);
    }
    @Override
    public String getDescription() {
        return "Велосипед: " + getName();
    }
}
