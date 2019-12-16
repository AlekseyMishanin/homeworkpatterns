package structural.composite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/**
 * Task for generating a license
 * */
public class TaskGenerate {

    private String licenseLype;
    private String deviceCount;
    private String durationl;
    private int licenseCount;

    public TaskGenerate(String licenseLype, String deviceCount, String durationl, int licenseCount) {
        this.licenseLype = licenseLype;
        this.deviceCount = deviceCount;
        this.durationl = durationl;
        this.licenseCount = licenseCount;
    }

    public TaskGenerate(String licenseLype, String deviceCount, String durationl) {
        this.licenseLype = licenseLype;
        this.deviceCount = deviceCount;
        this.durationl = durationl;
        this.licenseCount = 1;
    }
}
