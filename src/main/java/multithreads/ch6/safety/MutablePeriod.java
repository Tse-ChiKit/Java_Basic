package multithreads.ch6.safety;

import java.util.Date;

public class MutablePeriod {
    private final Date start;

    private final Date end;

    /**

     * @param  start the beginning of the period

     * @param  end the end of the period; must not precede start

     * @throws IllegalArgumentException if start is after end

     * @throws NullPointerException if start or end is null

     */

    public MutablePeriod(Date start, Date end) {

        if (start.compareTo(end) > 0)

            throw new IllegalArgumentException(

                    start + " after " + end);

        this.start = start;

        this.end   = end;

    }

    public Date start() {

        return start;

    }

    public Date end() {

        return end;

    }

    public static void main(String[] args){

        Date start = new Date();

        Date end = new Date();

        MutablePeriod p = new MutablePeriod(start, end);

        end.setYear(2);  // Modifies internals of p!

        System.out.println(p.start);
        System.out.println(p.end);

    }
}


