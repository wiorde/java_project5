import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        Transport[] vehicles=new Transport[3];
        vehicles[0]=new Car("Toyota",180);
        vehicles[1]=new Bicycle("Stels",30);
        vehicles[2]=new Car("BMW",250);
        System.out.println("До сортировки:");
        for (Transport t: vehicles) {
            System.out.println(t.toString());
        }
        Arrays.sort(vehicles);
        System.out.println("\nПосле сортировки по скорости (от меньшей к большей):");
        for (Transport t: vehicles) {
            System.out.println(t.toString());
        }
    }
}

abstract class Transport implements Comparable<Transport> {
    private String name;
    private int maxSpeed;
    public Transport(String name,int maxSpeed) {
        this.name=name;
        this.maxSpeed=maxSpeed;
    }
    public String getName() { return name; }
    public int getMaxSpeed() { return maxSpeed; }
    public abstract String getDescription();
    
    @Override
    public int compareTo(Transport other) {
        if (this.maxSpeed<other.maxSpeed) return -1;
        if (this.maxSpeed>other.maxSpeed) return 1;
        return 0;
    }
    @Override
    public String toString() {
        return getDescription()+", скорость: "+maxSpeed;
    }
}

class Car extends Transport {
    public Car(String name,int maxSpeed) {
        super(name,maxSpeed);
    }
    @Override
    public String getDescription() {
        return "Машина: "+getName();
    }
}

class Bicycle extends Transport {
    public Bicycle(String name,int maxSpeed) {
        super(name,maxSpeed);
    }
    @Override
    public String getDescription() {
        return "Велосипед: "+getName();
    }
}