import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Laptop {
    String manufacturer, os, color, cpu;
    int hard;
    double ram;

    public String randManuf(){
        List<String> list1 = new ArrayList<>();
        Random random = new Random();

        list1.add("MSI");//"MSI", "Lenovo", "HP", "Aser"
        list1.add("Lenovo");
        list1.add("HP");
        list1.add("Aser");
        list1.add("Asus");
        list1.add("IBM");

        int i  = random.nextInt(0, list1.size());
        return list1.get(i);
    }

    public String randCPU(){
        List<String> list1 = new ArrayList<>();
        Random random = new Random();

        list1.add("Core i3");
        list1.add("Core i5");
        list1.add("Core i7");
        list1.add("Core Two");
        list1.add("Core i9");

        int i = random.nextInt(0, list1.size());
        return list1.get(i);
    }

    public String randOS(){
        List<String> list1 = new ArrayList<>();
        Random random = new Random();

        list1.add("Win");
        list1.add("Linux");
        list1.add("Без системы");

        int i = random.nextInt(0, list1.size());
        return list1.get(i);
    }

    public Integer randHard(){
        Random random = new Random();
        int i = random.nextInt(1, 5);
        return 500*i;
    }
    public Double randRAM(){
        Random random = new Random();
        int i = random.nextInt(3, 6);
        return Math.pow(2,i);
    }

    public String randColor(){
        List<String> list1 = new ArrayList<>();
        Random random = new Random();

        list1.add("Черный");
        list1.add("Металлик");
        list1.add("Синий");
        list1.add("Красный");
        list1.add("Белый");

        int i = random.nextInt(0, list1.size());
        return list1.get(i);
    }

    @Override
    public String toString() {
        return "Производитель: " + manufacturer + ", цвет: " + color + ", операционная система: " + os + "," + "\n" +
                "процессор: " + cpu + ", оперативная память: " + ram + "Gb, обьем жесткого диска: " + hard + "Gb." + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Laptop)){
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return manufacturer.equals(laptop.manufacturer) && color.equals(laptop.color) &&
                os.equals(laptop.os) && cpu.equals(laptop.cpu) && hard == laptop.hard && ram == laptop.ram;
    }

    @Override
    public int hashCode() {
        return manufacturer.hashCode() + 13*color.hashCode() + 7*os.hashCode() + 11*cpu.hashCode() + 3*hard + 5*(int)ram;
    }
}
