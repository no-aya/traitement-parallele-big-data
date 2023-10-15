package com.example.springcloudkafka.services;

import com.example.springcloudkafka.entities.PageEvent;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        return (input) -> {
            System.out.println("***********************************");
            System.out.println(input.toString());
            System.out.println("***********************************");
        };
    }
    @Bean
    public Supplier<PageEvent> pageEventSupplier(){
        return () -> new PageEvent(
                    Math.random()>0.5?"P1":"P2",
                    Math.random()>0.5?"U1":"U2",
                    new java.util.Date(),
                    new java.util.Random().nextInt(9000));

    }

    @Bean
    public Function<PageEvent,PageEvent> pageEventFunction(){
        return (input) -> {
            input.setName(input.getName().toUpperCase());
            input.setUser("Aya");
            return input;
        };
    }

    public Function<KStream<String, PageEvent>, KStream<String,Long>> kStreamFunction(){
        return (input) -> input
                .filter((k,v) -> v.getDuration()>100)
                .map((k,v) -> new KeyValue<>(v.getName(),0L))
                .groupByKey(Grouped.with(Serdes.String(),Serdes.Long()))
                .count()
                .toStream();
    }
}
