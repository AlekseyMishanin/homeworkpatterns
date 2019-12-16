package generating.factory.model.platform.windows;

import generating.factory.interfaces.ManageInstaller;
import generating.factory.model.Installer;
import generating.factory.model.enums.Platform;

public class WindowsManageInstaller implements ManageInstaller {

    @Override
    public Installer getInstaller(String osName, String osVersion) {
        return new Installer(Platform.WINDOWS, osName, osVersion);
    }
}
