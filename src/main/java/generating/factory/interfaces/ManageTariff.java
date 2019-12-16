package generating.factory.interfaces;

import generating.factory.model.Tariff;

import java.util.Collection;

public interface ManageTariff {

    Collection<Tariff> getAllTariff();
    Tariff getTariff(String[] parameters);
}
