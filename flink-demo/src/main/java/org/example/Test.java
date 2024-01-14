package org.example;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class Test {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        env.setParallelism(2);
//
//        DataStreamSource<WaterSensor> streamSource = env.fromElements(
//                new WaterSensor("s1", 1L, 1),
//                new WaterSensor("s1", 3L, 3),
//                new WaterSensor("s2", 2L, 2),
//
//                new WaterSensor("s2", 4L, 4),
//                new WaterSensor("s1", 1L, 3)
//        );
//        KeyedStream<WaterSensor, String> keyedStream =
//                streamSource.keyBy(new KeySelector<WaterSensor, String>() {
//                    @Override
//                    public String getKey(WaterSensor waterSensor) throws Exception {
//                        return waterSensor.getId();
//                    }
//                });
//        SingleOutputStreamOperator<WaterSensor> reduceDS =
//                keyedStream.reduce(new ReduceFunction<WaterSensor>() {
//                    @Override
//                    public WaterSensor reduce(WaterSensor waterSensor, WaterSensor t1) throws Exception {
//                        return new WaterSensor("reduceId"+waterSensor.getId(), t1.getTs(), t1.getVc() + waterSensor.getVc());
//                    }
//                });
//        reduceDS.print();
        env.setParallelism(1);
        DataStreamSource<Integer> source1 = env.fromElements(1,2,3,4,5);
        DataStreamSource<Integer> source2 = env.fromElements(11, 22, 33, 44, 55);
        DataStreamSource<String> source3 = env.fromElements("21", "23", "36");

        DataStream<Integer> unionSource1 = source1.union(source2,source3.map(value -> Integer.valueOf(value)));
        DataStream<Integer> unionSource2 = source1.union(source3.map(value -> Integer.valueOf(value)));

        unionSource1.print("source1");
        unionSource2.print("source2");


        env.execute();


    }
}
