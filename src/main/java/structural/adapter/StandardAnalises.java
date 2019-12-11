package structural.adapter;

/**
 * read standard report
 * */
public class StandardAnalises implements AnalisedReport{

    private StandardReport standardReport;

    public StandardAnalises(StandardReport standardReport) {

        this.standardReport = standardReport;
    }

    @Override
    public String getReport() {

        return standardReport.toString();
    }
}
