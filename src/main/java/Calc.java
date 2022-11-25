import java.util.ArrayList;
import java.util.Scanner;

public class Calc {
    ArrayList<Commodity> pList = new ArrayList<Commodity>();
    double sum = 0; // Полная сумма всех товаров
    static String inputStop= "завершить";

    // Class functions
    public void startCalc(){
        Scanner pScanner = new Scanner(System.in);
        String str = ""; // Commodity name
        double price = 0; // Commodity price
        boolean flag = false;

        while(!flag){
            System.out.println("Введите название товара");
            str = pScanner.next();

            boolean correctInput = false;
            System.out.println("Введите соимость товара \"" + str +"\" в формате рубли.копейки' [10.45, 11.40]");
            while(!correctInput){
                if(pScanner.hasNextDouble()){
                    price = pScanner.nextDouble();
                    if(price>0) {
                        correctInput = true;
                        pList.add(new Commodity(str, price));
                    }
                    else{
                        System.out.println("Цена не может быть отрицательной или нулевой, введите еще раз");
                    }
                }
                else{
                    System.out.println("Неверный формат, попробуйте снова");
                    pScanner.next();
                }
            }
            System.out.println("Товар успешно добавлен, хотите продолжить? \n для завершения введите \"завершить\" ");
            str = pScanner.next();
            if(str.equalsIgnoreCase(inputStop)) break;// Выходим, если введено завершить
        }
    }
    public void showAllCommodities(){
        System.out.println("Добавленные товары:");
        this.sum = 0; // Перед расчетом обнулим сумму товаров на всякий случай
        for ( Commodity i:pList){
            i.showCommodity();
            sum+= i.price; //Сразу суммируем стоимость,
            // чтобы не прогонять цикл по второму разу отдельной функцией
        }
    }
    public void calculate(int personQuantity){
        double money = this.sum/personQuantity;
        System.out.println(String.format("Каждый платит по %.2f %s",money,this.getWordEnd(money)));
    }
    public String getWordEnd(double num){
        num = Math.floor(num);
        int ost =  (int)(num % 100);
        if(ost>10 && ost <=14) return "рублей";
        else ost =(int)(num % 10);
        switch (ost){
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
