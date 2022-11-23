import java.util.ArrayList;
import java.util.Scanner;

public class Calc {
    ArrayList<Commodity> pList = new ArrayList<Commodity>();
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
        System.out.println("Добавленные товары");
        for (int i = 0; i < pList.size(); i++) {
            pList.get(i).showCommodity();
        }

    }
}
