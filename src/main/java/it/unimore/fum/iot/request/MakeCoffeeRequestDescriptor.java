package it.unimore.fum.iot.request;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-coap-laboratory
 * @created 12/11/2021 - 12:33
 */
public class MakeCoffeeRequestDescriptor {

    public static final String COFFEE_TYPE_SHORT = "short_coffee";

    public static final String COFFEE_TYPE_MEDIUM = "medium_coffee";

    public static final String COFFEE_TYPE_LONG = "long_coffee";

    private String type;

    public MakeCoffeeRequestDescriptor() {
    }

    public MakeCoffeeRequestDescriptor(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MakeCoffeeRequestDescriptor{");
        sb.append("type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
