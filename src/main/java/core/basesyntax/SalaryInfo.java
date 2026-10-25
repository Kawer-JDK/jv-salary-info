package core.basesyntax;

public class SalaryInfo {

    public String getSalaryInfo(String[] names,
                                String[] data,
                                String dateFrom,
                                String dateTo) {

        String result = "";

        if (dateFrom != null && dateTo != null) {

            String[] dateFromSplited = dateFrom.split("\\.");
            String[] dateToSplited = dateTo.split("\\.");
            String fullDateFrom = dateFromSplited[2] + dateFromSplited[1] +dateFromSplited[0];
            String fullDateTo = dateToSplited[2] + dateToSplited[1] +dateToSplited[0];
            int dateFromAsNumber = Integer.valueOf(fullDateFrom);
            int dateToAsNumber = Integer.valueOf(fullDateTo);

                    for (int j = 0; j < names.length; j++) {
                        int salary = 0;
                        for (int i = 0; i < data.length; i++) {
                            String[] dataSplited = data[i].split(" ");

                            if (dataSplited[0] != null &&
                                    dataSplited[1] != null &&
                                    dataSplited[2] != null &&
                                    dataSplited[3] != null) {

                        if (names[j].equals(dataSplited[1])) {
                            String[] dataDateSplited = dataSplited[0].split("\\.");
                            String fullDate = dataDateSplited[2] + dataDateSplited[1] + dataDateSplited[0];
                            int dateAsNumber = Integer.valueOf(fullDate);

                            if (dateAsNumber >= dateFromAsNumber && dateAsNumber <= dateToAsNumber) {
                                int hours = Integer.valueOf(dataSplited[2]);
                                int salaryOnHour = Integer.valueOf(dataSplited[3]);
                                salary = hours * salaryOnHour;
                            }
                        }
                    }
                }
                        result += names[j] + " - " + salary + "\n";
            }
        }
        String finalResult = "Report for period " + dateFrom + " - " + dateTo + "\n" + result;

        return finalResult;
    }
}
