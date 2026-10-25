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

        for (int i = 0; i < data.length; i++) {
            String[] dataSplited = data[i].split(" ");
            for (String name : names) {
                if (dataSplited[1].equals(name)) {

                    String[] dataDateSplited = dataSplited[0].split("\\.");
                    String fullDate = dataDateSplited[2] + dataDateSplited[1] + dataDateSplited[0];
                    int dateAsNumber = Integer.valueOf(fullDate);

                    if (dateAsNumber >= dateFromAsNumber && dateAsNumber <= dateToAsNumber) {
                        int salary += Integer.valueOf(dataSplited[2]) * Integer.valueOf(dataSplited[3]);

                    }
                }
            }
        }

        return null;
    }
}
