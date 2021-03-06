package com.wqb.website.commons.message;

import java.text.MessageFormat;

/**
 * @author Shoven
 * @since 2019-04-24 10:18
 */
public class SmsMessage {

    private String templateString;

    private Object[] variables;

    public SmsMessage(String templateString, Object... variables) {
        this.templateString = templateString;
        this.variables = variables;
    }

    @Override
    public String toString() {
        return MessageFormat.format(templateString, variables);
    }
}
