package structural.composite;

/**
 * Class for generating a single license
 * */
public class SingleGenerater implements Generater {

    private TaskGenerate taskGenerate;

    public SingleGenerater(TaskGenerate taskGenerate) {
        this.taskGenerate = taskGenerate;
    }

    @Override
    public void generation() {

        System.out.println("Генерируем одну лицензию...");
    }
}
