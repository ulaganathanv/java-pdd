package com.sample.jmx;

public interface SystemConfigMBean  {
    public int getThreadCount();
    public void setThreadCount(int noOfThreads);

    public String getSchemaName();
    public void setSchemaName(String schemaName);

    public String doConfig();
}
