package job;

import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timeout;

import interfaces.MandatServiceLocal;

@Singleton
public class AlertJob{
	
	@EJB
	private MandatServiceLocal mandatService;

    @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
    @Timeout
    @AccessTimeout(value = 20, unit = TimeUnit.MINUTES)
    public void atSchedule() throws InterruptedException {
    	mandatService.alerteMandat();
        System.out.println("DeclarativeScheduler:: In atSchedule()");
       Thread.sleep(86400000);
    }

//
//    @Resource
//    TimerService timerService;
//
//    @PostConstruct
//    public void initialize() {
//        timerService.createTimer(30000, 86400000, "");
//    }
//
//    @Timeout
//    @AccessTimeout(value = 20, unit = TimeUnit.MINUTES)
//    public void programmaticTimeout(Timer timer) {
//    	mandatService.alerteMandat();
//      //  System.out.println("ProgrammaticWithDelayScheduler:: in programmaticTimeout");
//    }
}
