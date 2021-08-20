package com.erayt.web01.service.impl;

import com.erayt.web01.service.iface.ReadService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Z151
 * @Date: 2021/8/20 15:46
 */
@Service
public class ReadServiceImpl implements ReadService {

    @Override
    public List<String> findBooks() {
        System.out.println("这里是获取读书。");
        return null;
    }
}
