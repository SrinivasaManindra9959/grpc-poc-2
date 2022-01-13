package com.grpc.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//@Component
public class Constant {
/*
    @Value("timeout")
    private String timeout;

    public Long getTimeout(){
       return Long.valueOf(timeout);
    }*/

    public static final Long timeout = 10000L;

}
