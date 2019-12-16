package structural.facade;

/**
 * Service checks the correctness of filling in the fields
 * */
public class ValidateLicenseFields {

    public boolean verifyFields(License license){

        System.out.println("Проверяем поля на корректность заполнения...");
        if ("result".equals("true")){
            return true;
        } else {
            return false;
        }
    }
}
