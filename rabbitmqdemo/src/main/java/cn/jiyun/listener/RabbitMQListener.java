package cn.jiyun.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    //消费者 -使用注解
    @RabbitListener(bindings = @QueueBinding(
            value=@Queue(value = "rabbitMQ.test.queue",durable ="true"),
            exchange =@Exchange(value = "rabbitMQ.test.exchange",ignoreDeclarationExceptions = "true",type = ExchangeTypes.TOPIC),
            key=("*.*")
    ))
    public void rabbitMQTest(String msg){

        System.out.println("我接收到了来自生产者的信息为："+msg);

    }
}
