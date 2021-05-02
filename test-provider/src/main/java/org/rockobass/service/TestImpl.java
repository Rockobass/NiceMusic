package org.rockobass.service;

import org.apache.dubbo.config.annotation.Service;
import org.rockobass.commonapi.ITest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;

@Service
public class TestImpl implements ITest {
    @Value("${server.port}")
    private String port;

//    @PreAuthorize("hasAnyAuthority('user:add')")
    @Override
    public String test1() {
        return port + " test1";
    }

    @Override
    public String test2() {
        return port + " test2";
    }
}
