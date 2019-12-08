package generating.factory.model.platform.windows;

import generating.factory.FactoryAction;
import generating.factory.interfaces.ManageInstaller;
import generating.factory.interfaces.ManagePromotions;
import generating.factory.interfaces.ManageTariff;

public class WindowsFactory implements FactoryAction {

    @Override
    public ManageInstaller createInstaller() {

        return new WindowsManageInstaller();
    }

    @Override
    public ManageTariff createTariff() {

        return new WindowsManageTariff();
    }

    @Override
    public ManagePromotions createPromotion() {

        return new WindowsManagePromotion();
    }
}
