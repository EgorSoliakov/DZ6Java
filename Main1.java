import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Set<Laptop> set = new HashSet<>();
        set.add(newLaptop());
        set.add(newLaptop());
        set.add(newLaptop());
        set.add(newLaptop());
        set.add(newLaptop());
        set.add(newLaptop());

        System.out.println("Наименование ноутбуков: ");
        System.out.println(set);


        HashMap<Double,Double> map = new HashMap<>();
        HashMap<Integer,Integer> map1 = new HashMap<>();
        //map.put(16.0,32.0);
        System.out.println();
        //System.out.println(searchRAM(set,map));
        //map1.put(500,1000);
        //System.out.println(searchHard(searchRAM(set,map),map1));
        //String os1 = "Win";
        //System.out.println(searchOS(set,os1));
        //String color = "Красный";
        //System.out.println(searchColor(set,color));
        sercher(set);
    }
    public static Laptop newLaptop(){
        Laptop lap1 = new Laptop();
        lap1.manufacturer = lap1.randManuf();
        lap1.color = lap1.randColor();
        lap1.cpu = lap1.randCPU();
        lap1.os = lap1.randOS();
        lap1.hard = lap1.randHard();
        lap1.ram = lap1.randRAM();

        return lap1;
    }
    static Set<Laptop> searchRAM(Set<Laptop> set, HashMap<Double,Double> hashmap){
        Set<Laptop> set1 = new HashSet<>();
        for(Laptop laptop:set){
            if(hashmap.size() != 0) {
                List<Double> keys = new ArrayList<>(hashmap.keySet());
                for (int i = 0; i < keys.size(); i++) {
                    Double min = keys.get(i);
                    Double max = hashmap.get(min);
                    if (laptop.ram >= min && laptop.ram <= max) {
                        set1.add(laptop);
                    }
                }
            }else set1.add(laptop);
        }
        return set1;
    }

    static Set<Laptop> searchHard(Set<Laptop> set, HashMap<Integer,Integer> map){
        Set<Laptop> set1 = new HashSet<>();
        for(Laptop laptop:set){
            if(map.size() != 0) {
                List<Integer> keys = new ArrayList<>(map.keySet());
                for (int i = 0; i < keys.size(); i++) {
                    Integer min = keys.get(i);
                    Integer max = map.get(min);
                    if (laptop.hard >= min && laptop.hard <= max) {
                        set1.add(laptop);
                    }
                }
            }else set1.add(laptop);
        }
        return set1;
    }

    static Set<Laptop> searchOS(Set<Laptop> set, String os1){
        Set<Laptop> set1 = new HashSet<>();
        for(Laptop laptop:set){
            if(laptop.os == os1) {
                set1.add(laptop);
            }
            if(os1 == "0"){
                set1.add(laptop);
            }
        }
        return set1;
    }

    static Set<Laptop> searchColor(Set<Laptop> set, String color1){
        Set<Laptop> set1 = new HashSet<>();
        if(color1 == "0") {
            for(Laptop laptop:set){
                set1.add(laptop);
            }
        }else{
            for(Laptop laptop:set){
                if (laptop.color == color1) {
                    set1.add(laptop);
                }
            }
        }
        return set1;
    }

    public static void sercher(Set<Laptop> set){
        System.out.println("Выберете критерии фильтра: ");
        System.out.println("1-Оперативная память");
        System.out.println("2-Объем жесткого диска");
        System.out.println("3-Операционная систем");
        System.out.println("4-Цвет");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num == 1){
            HashMap<Double,Double> mapRam = searcherRam();
            System.out.println("2-Объем жесткого диска");
            System.out.println("3-Операционная систем");
            System.out.println("4-Цвет");
            System.out.println("5-Показать результат");
            Scanner scanner3 = new Scanner(System.in);
            int num1 = scanner3.nextInt();
            if(num1 == 2){
                HashMap<Integer,Integer> mapHard = searcherHard();
                System.out.println("3-Операционная систем");
                System.out.println("4-Цвет");
                System.out.println("5-Показать результат");
                Scanner scanner4 = new Scanner(System.in);
                int num2 = scanner4.nextInt();
                if(num2 == 3){
                    String os = searcherOS();
                    System.out.println("4-Цвет");
                    System.out.println("5-Показать результат");
                    Scanner scanner5 = new Scanner(System.in);
                    int num3 = scanner5.nextInt();
                    if(num3 == 4){
                        String color = searcherColor();
                        System.out.println(searchColor(searchOS(searchHard(searchRAM(set,mapRam),mapHard),os),color));
                    }
                    if(num3 == 5){
                        System.out.println(searchOS(searchHard(searchRAM(set,mapRam),mapHard),os));
                    }
                if(num2 == 4){
                    String color1 = searcherColor();
                    System.out.println(searchColor(searchHard(searchRAM(set,mapRam),mapHard),color1));
                }
                if(num2 == 5){
                    System.out.println(searchHard(searchRAM(set,mapRam),mapHard));
                }
            if(num1 == 3){
                String os1 = searcherOS();
                System.out.println("4-Цвет");
                System.out.println("5-Показать результат");
                Scanner scanner6 = new Scanner(System.in);
                int num4 = scanner6.nextInt();
                if(num4 == 4){
                    String color2 = searcherColor();
                    System.out.println(searchColor(searchOS(searchRAM(set,mapRam),os1),color2));
                }
                if(num4 == 5){
                    System.out.println(searchOS(searchRAM(set,mapRam),os1));
                }
            }
        if(num == 2){
            HashMap<Integer,Integer> mapHard1 = searcherHard();
            System.out.println("3-Операционная систем");
            System.out.println("4-Цвет");
            System.out.println("5-Показать результат");
            Scanner scanner8 = new Scanner(System.in);
            int num6 = scanner8.nextInt();
            if(num6 == 3){
                String os3 = searcherOS();
                System.out.println("4-Цвет");
                System.out.println("5-Показать результат");
                Scanner scanner9 = new Scanner(System.in);
                int num7 = scanner9.nextInt();
                if(num7 == 4){
                    String color5 = searcherColor();
                    System.out.println(searchColor(searchOS(searchHard(set,mapHard1),os3),color5));
                }
                if(num7 == 5){
                    System.out.println(searchOS(searchHard(set,mapHard1),os3));
                }
            }
            if(num6 == 4){
                String color4 = searcherColor();
                System.out.println(searchColor(searchHard(set,mapHard1),color4));
            }
            if(num6 == 5){
                System.out.println(searchHard(set,mapHard1));
            }
        }
        if(num == 3){
            String os2 = searcherOS();
            System.out.println("4-Цвет");
            System.out.println("5-Показать результат");
            Scanner scanner7 = new Scanner(System.in);
            int num5 = scanner7.nextInt();
            if(num5 == 4){
                String color3 = searcherColor();
                System.out.println(searchColor(searchOS(set,os2),color3));
            }
            if(num5 == 5){
                System.out.println(searchOS(searchHard(searchRAM(set,mapRam),mapHard),os2));
            }
        }
        if(num == 4){
            String color4 = searcherColor();
            System.out.println(searchColor(set,color4));
        }
        if(num == 5){
            System.out.println(set);
        }
            }
            }
        }
    }
    static public HashMap<Double,Double> searcherRam(){
        HashMap<Double,Double> mapRam = new HashMap<>();
        Double min = 0.0;
        Double max = 32.0;
        System.out.println("Введите минимальное кол-во" +
                "оперативной памяти(от 0 до 32): ");
        Scanner scanner1 = new Scanner(System.in);
        min = (double)scanner1.nextInt();
        System.out.println("Введите максимальное кол-во" +
                "оперативной памяти(до 32): ");
        Scanner scanner2 = new Scanner(System.in);
        max = (double)scanner2.nextInt();
        mapRam.put(min,max);
        return mapRam;
    }

    static public HashMap<Integer,Integer> searcherHard(){
        HashMap<Integer,Integer> mapHard = new HashMap<>();
        int min = 0;
        int max = 2000;
        System.out.println("Введите минимальное кол-во" +
                "объема(от 0 до 2000 Gb): ");
        Scanner scanner1 = new Scanner(System.in);
        min = scanner1.nextInt();
        System.out.println("Введите максимальное кол-во" +
                "объема(до 2000 Gb): ");
        Scanner scanner2 = new Scanner(System.in);
        max = scanner2.nextInt();
        mapHard.put(min,max);
        return mapHard;
    }
    static public String searcherOS(){
        String os = "0";
        System.out.println("Выберете ОС:");
        System.out.println("1 - Win ");
        System.out.println("2 - Linux ");
        System.out.println("3 - Без системы ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num == 1){
            os = "Win";
        }
        if(num == 2){
            os = "Linux";
        }
        if(num == 3){
            os = "Без системы";
        }
        return os;
    }

    static public String searcherColor(){
        String col = "0";
        System.out.println("Выберете цвет:");
        System.out.println("1 - Черный");
        System.out.println("2 - Белый");
        System.out.println("3 - Металлик");
        System.out.println("4 - Красный");
        System.out.println("5 - Синий");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num == 1){
            col = "Черный";
        }
        if(num == 2){
            col = "Белый";
        }
        if(num == 3){
            col = "Металлик";
        }
        if(num == 4){
            col = "Красный";
        }
        if(num == 5){
            col = "Синий";
        }
        return col;
    }
}
