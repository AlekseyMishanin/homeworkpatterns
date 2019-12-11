package structural.composite;

/**
 * Class for generating more than one license
 * */
public class MultiGenerater implements Generater {

    private TaskGenerate taskGenerate;

    public MultiGenerater(TaskGenerate taskGenerate) {
        this.taskGenerate = taskGenerate;
    }

    @Override
    public void generation() {

        int licenseCountForGenerate = taskGenerate.getLicenseCount();

        for (int i = 0; i < licenseCountForGenerate; i++) {
            System.out.println("Генерируем много лицензий...");
        }
    }
}
