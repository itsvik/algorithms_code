package com.oracle.assignment;

import com.oracle.assignment.client.SFGovClient;
import com.oracle.assignment.model.MobileFoodSchedule;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleListBufferedReader {
    private LocalDateTime now;
    private List<MobileFoodSchedule> scheduleListBuffer;
    private SFGovClient client;

    public ScheduleListBufferedReader(SFGovClient client, LocalDateTime now) {
        this.client = client;
        scheduleListBuffer = new ArrayList<>();
        this.now = now;
    }

    public void fillList() throws IOException {
        long batchLength = 100;
        int offset = 0;
        List<MobileFoodSchedule> mobileFoodSchedule;
        do {
            mobileFoodSchedule = client.getMobileFoodSchedule(offset, now);
            scheduleListBuffer.addAll(mobileFoodSchedule.stream().filter(this::isOpen)
                    .collect(Collectors.toList()));
            offset += batchLength;
        } while (mobileFoodSchedule.size() >= batchLength);
    }


    private boolean isOpen(MobileFoodSchedule schedule) {

        String[] start = schedule.getStart24().split(":");
        String[] end = schedule.getEnd24().split(":");
        int time = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HH"))) * 100 + Integer.parseInt(now.format(DateTimeFormatter.ofPattern("mm")));
        return Integer.parseInt(start[0]) * 100 + Integer.parseInt(start[1]) < time
                && Integer.parseInt(end[0]) * 100 + Integer.parseInt(end[1]) > time;
    }

    public List<MobileFoodSchedule> getNext(int offset) {
        return scheduleListBuffer.subList(offset, Math.min(offset + 10, scheduleListBuffer.size()));
    }

}
