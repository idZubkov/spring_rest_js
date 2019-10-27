package Delegate;

public class DelegateTest {
    public static void main(String[] args) {
        General general = new General();        //  6. появляется тот самый генерал
        general.setOrder(new Colonel());        //  7. выбирает полковника для делигации (исполнения приказа)
        general.give();                         //  8. приказ отдаётся (изначально генералом, но по факту полковником)

        general.setOrder(new Lieutenant());     //
        general.give();                         //  По
        general.setOrder(new Major());          //     аналогии
        general.give();                         //
    }
}

interface Order {                               //   1. есть некий приказ
    void give();
}

class Major implements Order {

    @Override
    public void give() {
        System.out.println("Приказ от майора");
    }
}

class Lieutenant implements Order {

    @Override
    public void give() {
        System.out.println("Приказ от лейтенанта");
    }
}

class Colonel implements Order {

    @Override
    public void give() {
        System.out.println("Приказ от полковника");
    }
}

class General {                                 // 2. есть некий генерал
    private Order order;                        // 3. у которого есть этот приказ

    public void setOrder(Order order) {         // 4. здесь тот, кому генерал делигирует свой приказ
        this.order = order;
    }

    void give() {                               // 5. отдаёт приказ делигируемому лицу для исполнения
        order.give();
    }
}