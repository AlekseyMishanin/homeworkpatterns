package structural.facade;

/**
 * Service checks for payment
 * */
public class VerifyPayment {

    public boolean verify(License license){

        return checkTransaktion(license);
    }

    private boolean checkTransaktion(License license){

        System.out.println("Проверяем транзакцию...");
        if ("result".equals("true")){
            return true;
        } else {
            return false;
        }
    }
}
