package generating.factory;

import generating.factory.model.enums.Platform;
import generating.factory.model.platform.windows.WindowsFactory;

import java.util.NoSuchElementException;

public class OsFactory {

    private static OsFactory instance = new OsFactory();

    public static OsFactory getInstance() {
        return instance;
    }

    private OsFactory() {
    }

    public FactoryAction createFactory(Platform platform){

        switch (platform){
            case WINDOWS:
                return new WindowsFactory();
            case ANDROID:
            case IOS:
                return null;
            default:
                throw new NoSuchElementException("no implementation for the platform" + platform);
        }
    }

}
