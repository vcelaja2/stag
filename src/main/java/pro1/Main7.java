package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.*;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args) {
        System.out.println(specializationDeadlines(2024));
    }
    public static String specializationDeadlines(int year) {
        String json = Api.getSpecializations(year);
        SpecializationsList specialization= new Gson().fromJson(json, SpecializationsList.class);
        List<LocalDate> dates = new ArrayList<>();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("d.M.yyyy");

        for (Specialization special : specialization.items) {
            if (special.deadline != null && special.deadline.date != null) {
                try {
                    dates.add(LocalDate.parse(special.deadline.date, form));
                } catch (DateTimeParseException e) {
                        System.err.println("Invalid date format: " + special.deadline.date);
                }
            }
        }
        return dates.stream().distinct().sorted().map(d -> d.format(form)).collect(Collectors.joining(","));
    }
}
