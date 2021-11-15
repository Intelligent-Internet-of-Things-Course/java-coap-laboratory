package it.unimore.fum.iot.model;

import java.util.Random;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-coap-laboratory
 * @created 12/11/2021 - 12:21
 */
public class TemperatureSensorDescriptor {

    private long timestamp;

    private double value;

    private String unit = "C";

    private static final int TEMPERATURE_VALUE_BOUND = 30;

    private static final int TEMPERATURE_START_VALUE = 20;

    private transient Random random;

    public TemperatureSensorDescriptor() {
        this.random = new Random();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void measureTemperatureValue(){
        this.value = TEMPERATURE_START_VALUE + this.random.nextInt(TEMPERATURE_VALUE_BOUND);
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TemperatureSensorDescriptor{");
        sb.append("timestamp=").append(timestamp);
        sb.append(", value=").append(value);
        sb.append(", unit='").append(unit).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
