package com.oracle.assignment.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MobileFoodSchedule {

    @JsonProperty("dayorder")
    public String dayorder;
    @JsonProperty("dayofweekstr")
    public String dayofweekstr;
    @JsonProperty("starttime")
    public String starttime;
    @JsonProperty("endtime")
    public String endtime;
    @JsonProperty("permit")
    public String permit;
    @JsonProperty("location")
    public String location;
    @JsonProperty("locationdesc")
    public String locationdesc;
    @JsonProperty("optionaltext")
    public String optionaltext;
    @JsonProperty("locationid")
    public String locationid;
    @JsonProperty("start24")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    public String start24;
    @JsonProperty("end24")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    public String end24;
    @JsonProperty("cnn")
    public String cnn;
    @JsonProperty("addr_date_create")
    public String addrDateCreate;
    @JsonProperty("addr_date_modified")
    public String addrDateModified;
    @JsonProperty("block")
    public String block;
    @JsonProperty("lot")
    public String lot;
    @JsonProperty("coldtruck")
    public String coldtruck;
    @JsonProperty("applicant")
    public String applicant;
    @JsonProperty("x")
    public String x;
    @JsonProperty("y")
    public String y;
    @JsonProperty("latitude")
    public String latitude;
    @JsonProperty("longitude")
    public String longitude;
    @JsonProperty("location_2")
    public Location location2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getDayorder() {
        return dayorder;
    }

    public MobileFoodSchedule setDayorder(String dayorder) {
        this.dayorder = dayorder;
        return this;
    }

    public String getDayofweekstr() {
        return dayofweekstr;
    }

    public MobileFoodSchedule setDayofweekstr(String dayofweekstr) {
        this.dayofweekstr = dayofweekstr;
        return this;
    }

    public String getStarttime() {
        return starttime;
    }

    public MobileFoodSchedule setStarttime(String starttime) {
        this.starttime = starttime;
        return this;
    }

    public String getEndtime() {
        return endtime;
    }

    public MobileFoodSchedule setEndtime(String endtime) {
        this.endtime = endtime;
        return this;
    }

    public String getPermit() {
        return permit;
    }

    public MobileFoodSchedule setPermit(String permit) {
        this.permit = permit;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public MobileFoodSchedule setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getLocationdesc() {
        return locationdesc;
    }

    public MobileFoodSchedule setLocationdesc(String locationdesc) {
        this.locationdesc = locationdesc;
        return this;
    }

    public String getOptionaltext() {
        return optionaltext;
    }

    public MobileFoodSchedule setOptionaltext(String optionaltext) {
        this.optionaltext = optionaltext;
        return this;
    }

    public String getLocationid() {
        return locationid;
    }

    public MobileFoodSchedule setLocationid(String locationid) {
        this.locationid = locationid;
        return this;
    }

    public String getStart24() {
        return start24;
    }

    public MobileFoodSchedule setStart24(String start24) {
        this.start24 = start24;
        return this;
    }

    public String getEnd24() {
        return end24;
    }

    public MobileFoodSchedule setEnd24(String end24) {
        this.end24 = end24;
        return this;
    }

    public String getCnn() {
        return cnn;
    }

    public MobileFoodSchedule setCnn(String cnn) {
        this.cnn = cnn;
        return this;
    }

    public String getAddrDateCreate() {
        return addrDateCreate;
    }

    public MobileFoodSchedule setAddrDateCreate(String addrDateCreate) {
        this.addrDateCreate = addrDateCreate;
        return this;
    }

    public String getAddrDateModified() {
        return addrDateModified;
    }

    public MobileFoodSchedule setAddrDateModified(String addrDateModified) {
        this.addrDateModified = addrDateModified;
        return this;
    }

    public String getBlock() {
        return block;
    }

    public MobileFoodSchedule setBlock(String block) {
        this.block = block;
        return this;
    }

    public String getLot() {
        return lot;
    }

    public MobileFoodSchedule setLot(String lot) {
        this.lot = lot;
        return this;
    }

    public String getColdtruck() {
        return coldtruck;
    }

    public MobileFoodSchedule setColdtruck(String coldtruck) {
        this.coldtruck = coldtruck;
        return this;
    }

    public String getApplicant() {
        return applicant;
    }

    public MobileFoodSchedule setApplicant(String applicant) {
        this.applicant = applicant;
        return this;
    }

    public String getX() {
        return x;
    }

    public MobileFoodSchedule setX(String x) {
        this.x = x;
        return this;
    }

    public String getY() {
        return y;
    }

    public MobileFoodSchedule setY(String y) {
        this.y = y;
        return this;
    }

    public String getLatitude() {
        return latitude;
    }

    public MobileFoodSchedule setLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    public String getLongitude() {
        return longitude;
    }

    public MobileFoodSchedule setLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    public Location getLocation2() {
        return location2;
    }

    public MobileFoodSchedule setLocation2(Location location) {
        this.location2 = location;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}