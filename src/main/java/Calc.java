import java.util.ArrayList;
import java.util.Scanner;

public class Calc {
    ArrayList<Commodity> pList = new ArrayList<Commodity>();
    double sum = 0; // Полная сумма всех товаров
    public void startCalc()
    {
        Scanner pScanner = new Scanner(System.in);
        String str = ""; // Commodity name
        double price = 0; // Commodity price
        boolean flag = false;

        while(!flag)
        {
            System.out.println("Введите название товара");
            str = pScanner.next();

            boolean correctInput = false;
            System.out.println("Введите цену \"" + str +"\" (format xx.xx)");
            while(!correctInput)
            {
                if(pScanner.hasNextDouble())
                {
                    price = pScanner.nextDouble();
                    correctInput =true;
                    pList.add(new Commodity(str,price));
                }
                else
                {
                    System.out.println("Неверный формат, попробуйте снова");
                    pScanner.next();
                }
            }
            System.out.println("Товар успешно добавлен, хотите продолжить? \n для завершения введите \"завершить\" ");
            str = pScanner.next();
            if(str.equalsIgnoreCase("завершить")) break;// Выходим, если введено завершить
        }
    }
    public void showAllCommodities()
    {
        System.out.println("Добавленные товары:");
        this.sum = 0; // Перед расчетом обнулим сумму товаров на всякий случай
        for (int i = 0; i < pList.size(); i++) {
            pList.get(i).showCommodity();
            sum+= pList.get(i).price; //Сразу суммируем стоимость,
            // чтобы не прогонять цикл по второму разу отдельной функцией
        }
    }
    public void calculate(int personQuantity)
    {
        double money = this.sum/personQuantity;
        //double money = 5.9589;
        System.out.println(String.format("Каждый платит по %.2f %s",money,this.getWordEnd(money)));
    }
    public String getWordEnd(double num)
    {
        String strOst="";
        num = Math.floor(num);
        int ost =  (int)(num % 10);
        switch (ost){
            case 1:
                strOst="рубль";
                break;
            case 2:
            case 3:
            case 4:
                strOst="рубля";
                break;
            default:
                strOst="рублей";
                break;
        }
        return strOst;
    }
}
