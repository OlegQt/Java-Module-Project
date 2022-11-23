public class Commodity {
    // Глобальные поля класса еды
    String name = "";
    double price= 0;

    // Конструктор для создания еды
    Commodity(String name, double price)
    {
        this.name = name;
        this.price=price;
    }

    public void showCommodity()
    {
        // Выводим название и цену

        System.out.println(String.format("%s price %.2f",this.name,this.price));
    }

    // Деструктор не нужен
}
