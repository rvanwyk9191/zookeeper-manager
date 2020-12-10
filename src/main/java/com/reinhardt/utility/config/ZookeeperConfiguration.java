package com.reinhardt.utility.config;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ZookeeperConfiguration {

    private static ZooKeeper zkeeper;
    private static ZKConnection zkConnection;

    public ZookeeperConfiguration(String host) throws IOException, InterruptedException {
        initialize(host);
    }

    private void initialize(String host) throws InterruptedException, IOException {
        zkConnection = new ZKConnection();
        zkeeper = zkConnection.connect(host);
    }

    public void closeConnection() throws InterruptedException {
        zkConnection.close();
    }

    public void create(String path, byte[] data)
            throws KeeperException,
            InterruptedException {

        zkeeper.create(
                path,
                data,
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
    }

    public Object getZNodeData(String path, boolean watchFlag)
            throws KeeperException,
            InterruptedException, UnsupportedEncodingException {

        byte[] b = null;
        b = zkeeper.getData(path, null, null);
        return new String(b, "UTF-8");
    }

    public void update(String path, byte[] data) throws KeeperException,
            InterruptedException {
        int version = zkeeper.exists(path, true).getVersion();
        zkeeper.setData(path, data, version);
    }

}
