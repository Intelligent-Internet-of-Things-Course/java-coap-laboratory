package it.unimore.fum.iot.model;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project java-coap-laboratory
 * @created 12/11/2021 - 12:30
 */
public class CoffeeHistoryDescriptor {

    private int totalCount;

    private int shortCount;

    private int mediumCount;

    private int longCount;

    public CoffeeHistoryDescriptor() {
    }

    public CoffeeHistoryDescriptor(int total_count, int short_count, int medium_count, int long_count) {
        this.totalCount = total_count;
        this.shortCount = short_count;
        this.mediumCount = medium_count;
        this.longCount = long_count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getShortCount() {
        return shortCount;
    }

    public void setShortCount(int shortCount) {
        this.shortCount = shortCount;
    }

    public int getMediumCount() {
        return mediumCount;
    }

    public void setMediumCount(int mediumCount) {
        this.mediumCount = mediumCount;
    }

    public int getLongCount() {
        return longCount;
    }

    public void setLongCount(int longCount) {
        this.longCount = longCount;
    }

    public void increaseLongCoffee(){
        this.totalCount++;
        this.longCount++;
    }

    public void increaseMediumCoffee(){
        this.totalCount++;
        this.mediumCount++;
    }

    public void increaseShortCoffee(){
        this.totalCount++;
        this.shortCount++;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CoffeeHistoryDescriptor{");
        sb.append("totalCount=").append(totalCount);
        sb.append(", shortCount=").append(shortCount);
        sb.append(", mediumCount=").append(mediumCount);
        sb.append(", longCount=").append(longCount);
        sb.append('}');
        return sb.toString();
    }
}
