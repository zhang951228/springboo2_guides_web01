package com.erayt.web01.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.Objects;
import lombok.Data;

/**
 * @Auther: Z151
 * @Date: 2021/8/23 10:35
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote02 {

    private Long id;

    private String quote02;

    @Override
    public String toString() {
        return "Quote02{" +
            "id=" + id +
            '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote02() {
        return quote02;
    }

    public void setQuote02(String quote02) {
        this.quote02 = quote02;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote02 quote02 = (Quote02) o;
        return Objects.equal(id, quote02.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
