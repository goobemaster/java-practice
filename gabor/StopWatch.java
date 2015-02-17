package gabor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class StopWatch {
  Date start;
  Date end;

  public StopWatch() {
    this.start = new Date();
    this.end = new Date();
  }

  public void stop() {
    this.end = new Date();
  }

  public String elapsed() {
    Long ms = (this.end.getTime() - this.start.getTime());
    return String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms)), TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms)));
  }
}
