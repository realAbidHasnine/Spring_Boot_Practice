package com.DenedencyInjection.Service;

import org.springframework.stereotype.Component;

@Component
public class DemoService {
    private static int instanceCount = 0;
    private int instanceId;

    public DemoService() {
        instanceCount++;
        this.instanceId = instanceCount;
        System.out.println("DemoService instance created: " + instanceId);
    }

    public int getInstanceId() {
        return instanceId;
    }
}
