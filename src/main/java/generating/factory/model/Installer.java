package generating.factory.model;

import generating.factory.model.enums.Platform;

public class Installer {

    private String url;

    public Installer(Platform platform, String osName, String version) {

        switch (platform){
            case IOS:

                //TODO utility by name and version of the operating system is looking for an installer
                //....

                this.url = "https://...";
                break;
            case ANDROID:
                this.url = "https://...";
                break;
            case WINDOWS:
                this.url = "https://...";
                break;
            default:
                this.url = null;
        }
    }
}
