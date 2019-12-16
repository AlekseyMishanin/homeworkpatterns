package structural.facade;

/**
 * Service checks for cheats
 * */
public class CheackCheats {

    public boolean verifyCheats(License license){

        return checkInBlackList(license) && parameterModification(license);
    }

    private boolean checkInBlackList(License license){

        System.out.println("Проверяем пользователя на наличие в черном списке");
        if ("result".equals("true")){
            return true;
        } else {
            return false;
        }
    }

    private boolean parameterModification(License license){

        System.out.println("Проверяем лицензию на манимуляции с параметрами");
        if ("result".equals("true")){
            return true;
        } else {
            return false;
        }
    }
}
