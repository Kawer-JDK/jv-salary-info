package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {

    private static final int DATE_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int HOURS_INDEX = 2;
    private static final int SALARY_PER_HOUR_INDEX = 3;

    public String getSalaryInfo(String[] names,
                                String[] data,
                                String dateFrom,
                                String dateTo) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateToFormeted = LocalDate.parse(dateTo, formatter);
        LocalDate dateFromFormeted = LocalDate.parse(dateFrom, formatter);

        StringBuilder stringBuilder = new StringBuilder("Report for period ");
        stringBuilder.append(dateFrom)
                .append(" - ")
                .append(dateTo)
                .append("\r\n");

        for (int i = 0; i < names.length; i++) {
            int salary = 0;

            for (int j = 0; j < data.length; j++) {
                String[] splitedData = data[j].split(" ");
                LocalDate actualDate = LocalDate.parse(splitedData[DATE_INDEX], formatter);
                if (names[i].equals(splitedData[NAME_INDEX])) {
                    if ((actualDate.isAfter(dateFromFormeted)
                            || actualDate.isEqual(dateFromFormeted))
                            && (actualDate.isBefore(dateToFormeted)
                            || actualDate.isEqual(dateToFormeted))) {

                        int hourName = Integer.valueOf(splitedData[HOURS_INDEX]);
                        int salaryName = Integer.valueOf(splitedData[SALARY_PER_HOUR_INDEX]);
                        salary += hourName * salaryName;
                    }
                }
            }
            stringBuilder.append(names[i]).append(" - ").append(salary);
            if (i < names.length - 1) {
                stringBuilder.append("\r\n");
            }
        }

        return stringBuilder.toString();
    }
}
