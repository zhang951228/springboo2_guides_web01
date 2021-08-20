package com.erayt.web01.service.iface;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/20 15:45
 */
public interface ReadService {

    List<String> findBooks();

}
