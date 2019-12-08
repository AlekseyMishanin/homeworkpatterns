package generating.builder;

import java.util.Date;

public class LicenseInfo {

    private String licenseKey;
    private String licenseType;
    private int deviceMax;
    private String duration;
    private String application;
    private Date timeAdded;

    public LicenseInfo(String licenseKey, String licenseType, int deviceMax, String duration, String application, Date timeAdded) {
        this.licenseKey = licenseKey;
        this.licenseType = licenseType;
        this.deviceMax = deviceMax;
        this.duration = duration;
        this.application = application;
        this.timeAdded = timeAdded;
    }

    public LicenseInfo() {
    }

    @Override
    public boolean equals(Object o) {

        if(this == o ) return true;
        if(!(o instanceof LicenseInfo)) return false;

        LicenseInfo licenseInfo = (LicenseInfo)o;

        return this.application == licenseInfo.application &&
                this.deviceMax == licenseInfo.deviceMax &&
                this.duration == licenseInfo.duration &&
                this.licenseKey == licenseInfo.licenseKey &&
                this.licenseType == licenseInfo.licenseType &&
                this.timeAdded == licenseInfo.timeAdded;
    }

    /**
     * builder pattern implementation
     * */
    public static class UserLicenseInfo {

        private static UserLicenseInfo userLicenseInfo;
        private String licenseKey;
        private String licenseType;
        private int deviceMax;
        private String duration;
        private String application;
        private Date timeAdded;

        public static UserLicenseInfo builder(){

            userLicenseInfo = new UserLicenseInfo();
            return userLicenseInfo;
        }

        public UserLicenseInfo licenseKey(String licenseKey) {

            this.licenseKey = licenseKey;
            return this;
        }

        public UserLicenseInfo licenseType(String licenseType) {
            this.licenseType = licenseType;
            return this;
        }

        public UserLicenseInfo deviceMax(int deviceMax) {
            this.deviceMax = deviceMax;
            return this;
        }

        public UserLicenseInfo duration(String duration) {
            this.duration = duration;
            return this;
        }

        public UserLicenseInfo application(String application) {
            this.application = application;
            return this;
        }

        public UserLicenseInfo timeAdded(Date timeAdded) {
            this.timeAdded = timeAdded;
            return this;
        }

        public LicenseInfo build(){
            return new LicenseInfo(licenseKey, licenseType, deviceMax, duration, application, timeAdded);
        }
    }
}
