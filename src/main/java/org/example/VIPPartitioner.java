package org.example;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;

public class VIPPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        List<PartitionInfo> partitionInfos = cluster.availablePartitionsForTopic(topic);
        String[] split = ((String) value).split("-");
        String lat = split[0];
        String longit = split[1];

        if(lat.equals("37.2431") && longit.equals("15.793")){
            return 3;
        }
        return Utils.murmur2(keyBytes)%partitionInfos.size()-1;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
