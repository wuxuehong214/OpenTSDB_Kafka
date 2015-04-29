# OpenTSDB_Kafka
A plugin used for opentsdb to publish the metrics to kafka


There are some config options in opentsdb.conf for opentsdb

tsd.rtpublisher.kafka.topic     #topic you want to publish
tsd.rtpublisher.kafka.allowedmetrics  #the permitted metrics to kafka, each metric should split by ':'
