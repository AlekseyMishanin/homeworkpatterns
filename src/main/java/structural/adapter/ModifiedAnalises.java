package structural.adapter;

/**
 * read not standard report
 * */
public class ModifiedAnalises implements AnalisedReport {

    private GoogleReport googleReport;

    public ModifiedAnalises(GoogleReport googleReport) {
        this.googleReport = googleReport;
    }

    @Override
    public String getReport() {

        System.out.println("Конвертируем гугловский отчет в нужный формат");
        String standardReport = convert(googleReport);

        return standardReport;
    }

    private String convert(GoogleReport googleReport){

        return "Convert to standard report";
    }
}
