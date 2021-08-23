package com.erayt.web01.controller;

import com.erayt.web01.domain.Quote;
import com.erayt.web01.domain.Quote02;
import com.erayt.web01.domain.response.QuoteResponse;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * @Auther: Z151
 * @Date: 2021/8/23 10:48
 */

@Service
@SuppressWarnings("unused")
public class QuoteService {

    protected static final String ID_BASED_QUOTE_SERVICE_URL = "http://gturnquist-quoters.cfapps.io/api/{id}";
    protected static final String RANDOM_QUOTE_SERVICE_URL = "http://gturnquist-quoters.cfapps.io/api/random";

    private volatile Boolean cacheMiss = false;
    private final RestTemplate quoteServiceTemplate = new RestTemplate();

    public boolean isCacheMiss() {
        boolean cacheMiss = this.cacheMiss;
        this.cacheMiss = false;
        return cacheMiss;
    }

    protected void setCacheMiss() {
        this.cacheMiss = true;
    }

    @Cacheable("Quotes")
    public Quote02 requestQuote(Long id) {
        setCacheMiss();
        return requestQuote(ID_BASED_QUOTE_SERVICE_URL, Collections.singletonMap("id", id));
    }

    /**
     * Requests a random quote.
     *
     * @return a random {@link Quote}.
     */
    @CachePut(cacheNames = "Quotes", key = "#result.id")
    public Quote02 requestRandomQuote() {
        setCacheMiss();
        return requestQuote(RANDOM_QUOTE_SERVICE_URL);
    }

    protected Quote02 requestQuote(String URL) {
        return requestQuote(URL, Collections.emptyMap());
    }

    protected Quote02 requestQuote(String URL, Map<String, Object> urlVariables) {
        return Optional.ofNullable(this.quoteServiceTemplate.getForObject(URL, QuoteResponse.class, urlVariables))
            .map(QuoteResponse::getQuote02)
            .orElse(null);
    }


}
