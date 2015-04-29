package net.opentsdb.rtpublisher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import net.opentsdb.utils.Config;

public class KafkaProducer {

	private Producer<String, String> producer;
	private Map<String, Byte> alloweds;
	private String topic;

	public void init(Config config) {
		Properties props = new Properties();
		props.put("metadata.broker.list",
				config.getString("tsd.rtpublisher.kafka.brokers")); // "172.16.25.195:9092"
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		// props.put("partitioner.class",
		// "test.kafka.producers.SimplePartitioner");
		props.put("request.required.acks", "1");
		ProducerConfig c = new ProducerConfig(props);
		producer = new Producer<String, String>(c);

		String metrics = config
				.getString("tsd.rtpublisher.kafka.allowedmetrics");
		alloweds = new HashMap<String, Byte>();
		String[] m = metrics.split(":");
		for (int i = 0; i < m.length; i++) {
			alloweds.put(m[i].trim(), (byte) 0x01);
		}

		topic = config.getString("tsd.rtpublisher.kafka.topic");
		if (topic == null)
			topic = "monit_topic";
	}

	public void publish(String metric, long timestamp, double value, Map<String,String> tags){
		if(alloweds.get(metric) != null){
			StringBuffer sb = new StringBuffer();
			sb.append(metric);
			sb.append("\t"+timestamp);
			sb.append("\t"+value);
			
			Iterator<Map.Entry<String, String>> it = tags.entrySet().iterator();
			while(it.hasNext()){
				Entry<String, String> e = it.next();
				sb.append("\t"+e.getKey()+"="+e.getValue());
			}
			KeyedMessage<String, String> data = new KeyedMessage<String, String>(
					topic, "monit", sb.toString());
			
			producer.send(data);
		}
	}
	// public static void main(String args[]){
	// Map<String,String> a = new HashMap<String,String>();
	// a.put("appid", "sdfsfsdfsdf");
	// a.put("appid2", "sdfsfsdfsdf");
	// a.put("appid3", "sdfsfsdfsdf");
	// String s = publish("abc", 12312314, 234, a);
	// System.out.println(s);
	// String[] ss= s.split("\t");
	// System.out.println(ss.length);
	// for(int i=0;i<ss.length;i++){
	// System.out.println(ss[i]);
	// }
	// }

}
