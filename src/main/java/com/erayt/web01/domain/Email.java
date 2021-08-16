package com.erayt.web01.domain;

/**
 * @Auther: Z151
 * @Date: 2021/8/16 23:01
 */
public class Email {

    private String to;

    private String body;

    private String title;

    private String additional;

    public Email() {
    }

    public Email(String to, String body, String title, String additional) {
        this.to = to;
        this.body = body;
        this.title = title;
        this.additional = additional;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    @Override
    public String toString() {
        return "Email{" +
            "to='" + to + '\'' +
            ", body='" + body + '\'' +
            ", title='" + title + '\'' +
            ", additional='" + additional + '\'' +
            '}';
    }
}
