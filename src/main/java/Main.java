import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("////////////////////////////////");
        Scanner pScanner = new Scanner(System.in);
        boolean inputComplete = false; // Флаг для прохождения цикла.
        int num = 0; // Количество персон
        ///////////////////////////////////////////////////////////////////////////
        // Цикличный ввод количества персон (не стал делать отдельным методом, хотя
        // Было бы красиве
        while (!inputComplete){
            System.out.println("How many people you want to share bill with?");
            // Здесь проверяем, если введена строка, а не число
            if (pScanner.hasNextInt()) {
                num = pScanner.nextInt();
                switch (num) {
                    case 0:
                    case 1:
                        System.out.println("You could not be serious. Try again, please");
                        break;
                    default:
                        if(num<0)
                        {
                            System.out.println("Вы ввели отрицательное число, попробуйте еще раз");
                        }
                        else
                        {
                            System.out.println("Запуск калькулятора");
                            inputComplete = true;
                        }
                        break;
                }
            }
            else {
                System.out.println("Wrong number format. Try again, please!");
                pScanner.next();
            }
        }
        /////////////////////////////////////////////////////////////////////
        Calc pCalc = new Calc(); // Создаем указатель на элемент нашего класса
        pCalc.startCalc(); // Вызывем методы цикличного ввода товаров и суммы
        pCalc.showAllCommodities(); // Метод вывода всех товаров на экран
        pCalc.calculate(num); // Метода расчета суммы платежа и его вывод на экран
        System.out.println("////////////////////////////////");
    }
}

