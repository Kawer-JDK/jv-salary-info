package core.basesyntax;

public class SalaryInfo {
    public String getSalaryInfo(String[] names,
                                String[] data,
                                String dateFrom,
                                String dateTo) {

        String[] dateFromSplited = dateFrom.split("\\.");
        String[] dateToSplited = dateTo.split("\\.");
        String fullDateFrom = dateFromSplited[2] + dateFromSplited[1] +dateFromSplited[0];
        String fullDateTo = dateToSplited[2] + dateToSplited[1] +dateToSplited[0];
        int dateFromAsNumber = Integer.valueOf(fullDateFrom);
        int dateToAsNumber = Integer.valueOf(fullDateTo);



        return null;
    }
}
