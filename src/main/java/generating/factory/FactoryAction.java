package generating.factory;

import generating.factory.interfaces.ManageInstaller;
import generating.factory.interfaces.ManagePromotions;
import generating.factory.interfaces.ManageTariff;

public interface FactoryAction {

    ManageInstaller createInstaller();
    ManageTariff createTariff();
    ManagePromotions createPromotion();
}
