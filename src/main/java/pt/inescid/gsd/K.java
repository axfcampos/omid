package pt.inescid.gsd;

public class K implements Comparable<K> {
    private long time;
    private int sequence;
    private double value;

    public K(long time, int sequence, double value) {
        this.time = time;
        this.sequence = sequence;
        this.value = value;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void incSequence() {
        sequence++;
    }

    public void reset() {
        sequence = 0;
        value = -1;
    }

    @Override
    public int compareTo(K o) {
        if (o.sequence > 0 && sequence > o.sequence)
            return 1;

        // TODO value
        return 0;
    }

    @Override
    public String toString() {
        return "K(" + time + ", " + sequence + ", " + value + ")";
    }
}




