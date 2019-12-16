package behavioral.observer;

public class Meiler implements Observer{

    @Override
    public void update(User user) {

        sendMessage(user);
    }

    public void sendMessage(User user){

        System.out.println("При помощи GeoIp определяем страну/город/устройство и отпралвяем уведомление о логине" +
                "с новой локации/устройства на почту пользователя");
    }
}
