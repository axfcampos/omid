package pt.inescid.gsd.client;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HConnection;

import java.io.IOException;

public class HBaseAdminPP extends HBaseAdmin {


    public HBaseAdminPP(Configuration c) throws MasterNotRunningException, ZooKeeperConnectionException {

        super(c);

    }

    public HBaseAdminPP(HConnection hc) throws MasterNotRunningException, ZooKeeperConnectionException {

        super(hc);
    }


    /**
     * Abstracting of shadow column family and column for constraints
     * cf = 0x42, column = 0x24
     */
    @Override
    public void createTable(HTableDescriptor desc) throws IOException {

        desc.addFamily(new HColumnDescriptor(new byte[]{0x42}));
        super.createTable(desc);
    }

    @Override
    public void createTable(HTableDescriptor desc,
                            byte[] startKey,
                            byte[] endKey,
                            int numRegions) throws IOException {

        desc.addFamily(new HColumnDescriptor(new byte[]{0x42}));
        super.createTable(desc, startKey, endKey, numRegions);
    }

    @Override
    public void createTable(HTableDescriptor desc,
                            byte[][] splitKeys)
            throws IOException {

         desc.addFamily(new HColumnDescriptor(new byte[]{0x42}));
         super.createTable(desc, splitKeys);
    }


    @Override
    public void createTableAsync(HTableDescriptor desc,
                                 byte[][] splitKeys)
            throws IOException {

        desc.addFamily(new HColumnDescriptor(new byte[]{0x42}));
        super.createTableAsync(desc, splitKeys);
    }





}
