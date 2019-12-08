package generating.factory.model.platform.windows;

import generating.factory.interfaces.ManageTariff;
import generating.factory.model.Tariff;
import generating.factory.model.enums.Platform;
import generating.factory.utils.UtilTariff;

import java.util.Collection;

public class WindowsManageTariff implements ManageTariff {

    @Override
    public Collection<Tariff> getAllTariff() {

        return UtilTariff.getTariffsByPlatform(Platform.WINDOWS);
    }

    @Override
    public Tariff getTariff(String[] parameters) {

        return new Tariff();
    }
}
