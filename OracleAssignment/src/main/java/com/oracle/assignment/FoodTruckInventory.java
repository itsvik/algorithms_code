package com.oracle.assignment;


import com.oracle.assignment.client.SFGovClient;
import com.oracle.assignment.model.MobileFoodSchedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;

public class FoodTruckInventory {

    private static final SFGovClient client = new SFGovClient();
    public static final LocalDateTime NOW = LocalDateTime.now();

    public static void main(String[] args) throws IOException {

        ScheduleListBufferedReader scheduleListBufferedReader = new ScheduleListBufferedReader(client, NOW);
        scheduleListBufferedReader.fillList();
        printPaginated(scheduleListBufferedReader);
    }

    private static void printPaginated(ScheduleListBufferedReader scheduleListBufferedReader) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nNAME\t\tADDRESS");
        List<MobileFoodSchedule> mobileFoodScheduleList;
        int i = 0;
        do {
            mobileFoodScheduleList = scheduleListBufferedReader.getNext(i);
            mobileFoodScheduleList.forEach(schedule -> System.out.println(schedule.getApplicant() + "\t" + schedule.getLocation()));
            if(mobileFoodScheduleList.size() >= 10)
                System.out.println("\nPress enter for next results");
            else
                System.out.println("\n Result finished");
            br.readLine();
            i += 10;
        } while (mobileFoodScheduleList.size() == 10);
    }

}
