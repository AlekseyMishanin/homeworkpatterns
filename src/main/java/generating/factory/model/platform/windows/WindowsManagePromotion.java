package generating.factory.model.platform.windows;

import generating.factory.interfaces.ManagePromotions;
import generating.factory.model.Promotion;

import java.util.Collection;
import java.util.Locale;

public class WindowsManagePromotion implements ManagePromotions {

    @Override
    public Collection<Promotion> getPromotionCountry(Locale locale) {
        return null;
    }

    @Override
    public Collection<Promotion> getPromotionCity(String ip) {
        return null;
    }
}
