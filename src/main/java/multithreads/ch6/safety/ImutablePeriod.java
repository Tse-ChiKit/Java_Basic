package multithreads.ch6.safety;

import java.util.Date;

public class ImutablePeriod {

    private final Date start;

    private final Date end;


    public ImutablePeriod(Date start, Date end) {


        this.start = new Date(start.getTime()); // create new object for start and end dates

        this.end  = new Date(end.getTime());


        if (this.start.compareTo(this.end) > 0)

            throw new IllegalArgumentException(this.start + " after " + this.end);

    }


    public static void main(String[] args){

        Date start = new Date();

        Date end = new Date();

        ImutablePeriod p = new ImutablePeriod(start, end);

        end.setYear(2);
        System.out.println(p.start);
        System.out.println(p.end);

    }
}
