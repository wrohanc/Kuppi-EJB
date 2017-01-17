package com.ro.learn.session.singleton;

import javax.ejb.*;
import java.util.Date;

/**
 * Created by rohan on 2016-11-26.
 */
@Startup
@Singleton(name = "TimerEJB")
public class TimerEJB {

    @Schedule(hour = "*", minute = "*", second = "5", info = "Every 5 second timer")
    public void schedule5() {
        System.out.println("Schedule task 5s triggered ! :" + new Date());
    }

    @Schedule(hour = "*", minute = "*", second = "10", info = "Every 10 second timer", persistent = true)
    public void schedule10() {
        System.out.println("Schedule task 10s triggered ! :" + new Date());
    }

    /*@Schedules({
            @Schedule(hour = "*", minute = "*", second = "*//*5", info = "Every 5 second timer"),
            @Schedule(hour = "*", minute = "*", second = "*//*10", info = "Every 10 second timer")
    })
    public void automaticallyScheduled(Timer timer) {
        System.out.println("Schedule task 10s triggered ! :" + new Date());
    }*/
}
