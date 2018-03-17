package com.yeadev.JavaSpringBootJARAngularSeed.smtpMail;

import lombok.Data;

// a pojo
@Data
public class Email {

    private String from;

    private String[] to;

    private String[] cc;

    private String subject;

    private String message;

    private boolean isHtml;

    private Email() {
        this.to = null;
        this.cc = null;
    }

    public Email(String toList, String subject, String message, boolean isHtml) {
        this();
        this.to = splitEmailAddress(toList);
        this.subject = subject;
        this.message = message;
        this.isHtml = isHtml;

    }

    public Email(String toList, String ccList, String subject, String message, boolean isHtml) {
        this(toList, subject, message, isHtml);
        this.cc = splitEmailAddress(ccList);
    }


    // split email addresses by space, comma or semi-colon
    // [\\s,;]+ = one or more times of either \s , or ;
    private String[] splitEmailAddress(String toMultiple) {
        return toMultiple.trim().split("[\\s,;]+");
    }
}
