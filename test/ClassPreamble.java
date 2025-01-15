package test;

import java.lang.annotation.Documented;

@Documented
@interface ClassPreamble {
    String author() default "";

    String date() default "";

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    // Note use of array
    String[] reviewers() default { };
}