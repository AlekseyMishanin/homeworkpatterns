package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class LogIn implements Observable{

    private List<Observer> observerList = new ArrayList<>();
    private User user;

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach( item -> item.update(user));
    }

    public void verifyPassword(User user){

        System.out.println("В данном методе проверяется пароль пользователя. Далее из ip вытягиваются: локация, агент пользователя и если эти данные являются уникальными," +
                "т.е. ранее пользователь не авторизовывался через данный ip, то вызывается notifyObservers() для направления уведомления пользователю");
    }
}
