import generating.builder.LicenseInfo;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import generating.builder.LicenseInfo.*;

public class BuilderTest {

    @Test
    public void testBuilder(){

        String licenseKey = "Maximum";
        String licenseType = "Mobile";
        int deviceMax = 5;
        String duration = "180";
        String application = "App";
        Date timeAdded = new Date();

        LicenseInfo licenseInfo1 = new LicenseInfo(licenseKey, licenseType, deviceMax, duration, application, timeAdded);

        LicenseInfo licenseInfo2 = UserLicenseInfo.builder().licenseKey(licenseKey).licenseType(licenseType).application(application).deviceMax(deviceMax)
                .duration(duration).timeAdded(timeAdded).build();

        Assert.assertEquals(licenseInfo1,licenseInfo2);
    }
}
