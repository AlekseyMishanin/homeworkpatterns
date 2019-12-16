package generating.factory.interfaces;

import generating.factory.model.Promotion;

import java.util.Collection;
import java.util.Locale;

public interface ManagePromotions {

    Collection<Promotion> getPromotionCountry(Locale locale);
    Collection<Promotion> getPromotionCity(String ip);
}
