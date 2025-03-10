package test.annotations;

import java.lang.annotation.Repeatable;

@Repeatable(Schedules.class)
public @interface Schedule {
    String dayOfMonth() default "first";

    String dayOfWeek() default "Mon";

    int hour() default 12;
}