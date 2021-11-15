package it.unimore.fum.iot.model;

import java.util.Random;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-coap-laboratory
 * @created 12/11/2021 - 12:24
 */
public class CapsulePresenceSensorDescriptor {

    private long timestamp;

    private boolean value;

    private transient Random random;

    public CapsulePresenceSensorDescriptor() {
        this.random = new Random();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public void checkCapsulePresence(){
        this.value = this.random.nextBoolean();
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CapsuleSensorDescriptor{");
        sb.append("timestamp=").append(timestamp);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
