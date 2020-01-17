package multithreads.ch4.StatTask;

import java.util.Map;

public interface StatProcessor {
    void process(String record);

    Map<Long, DelayItem> getResult();
}