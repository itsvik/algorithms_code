package com.oracle.assignment.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.assignment.model.MobileFoodSchedule;
import com.oracle.assignment.model.MobileFoodScheduleError;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class SFGovClient {


    public static final String URL = "https://data.sfgov.org/resource/jjew-r69b.json?" +
            "$select=applicant, location, start24, end24" +
            "&dayorder=%d" +
            "&$limit=100" +
            "&$order=applicant" +
            "&$offset=%s";

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<MobileFoodSchedule> getMobileFoodSchedule(int offset, LocalDateTime time) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String url = String.format(URL, time.getDayOfWeek().getValue(), offset);

        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();

        String body = response.body().string();

        if (response.code() != 200 && response.code() != 202) {
            MobileFoodScheduleError error = objectMapper.readValue(body, MobileFoodScheduleError.class);
            throw new RuntimeException("Error : " + error.getCode() + " Reason :" + error.getMessage());
        }
        return objectMapper.readValue(body, new TypeReference<>() {});
    }
}
