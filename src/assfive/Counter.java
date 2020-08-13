//322060187
package assfive;

/**
 * add or decrease from count.
 * counting number of blocks and balls remaining in the game .
 **/
public class Counter {
    private int count;

    /**
     * @param number number we got to work with
     **/
    public Counter(int number) {
        this.count = number;
    }

    /**
     * @param number add number to current count.
     **/
    public void increase(int number) {
        count = count + number;
    }

    /**
     * @param number subtract number from current count.
     **/
    public void decrease(int number) {
        count = count - number;
    }

    /**
     * @return get current count.
     **/
    public int getValue() {
        return count;
    }
}
