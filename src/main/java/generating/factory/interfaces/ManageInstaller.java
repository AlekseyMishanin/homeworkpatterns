package generating.factory.interfaces;

import generating.factory.model.Installer;

public interface ManageInstaller {

    Installer getInstaller(String osName, String osVersion);
}
