package com.erayt.web01.domain.response;

import com.erayt.web01.domain.Quote02;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Auther: Z151
 * @Date: 2021/8/23 10:44
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {

    private Quote02 quote02;

    private String status;

    public Quote02 getQuote02() {
        return quote02;
    }

    public void setQuote02(Quote02 quote02) {
        this.quote02 = quote02;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QuoteResponse{" +
            "quote02=" + quote02 +
            ", status='" + status + '\'' +
            '}';
    }
}
