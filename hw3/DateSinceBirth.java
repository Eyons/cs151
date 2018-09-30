/**
 * Created by Aaron on 9/30/2018.
 */
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateSinceBirth {
    private ZoneId zoneId = ZoneId.of("America/Los_Angeles");
    private ZonedDateTime dateOfBirth;
    private ZonedDateTime now;

    public DateSinceBirth(){
        this.now = ZonedDateTime.now();
        this.dateOfBirth = ZonedDateTime.of(1996, 9, 14, 20, 32, 5, 0, zoneId);
    }

    public long getDaysSinceBirth(){
        return ChronoUnit.DAYS.between(dateOfBirth, now);
    }
}
