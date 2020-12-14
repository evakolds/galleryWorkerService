package com.gallery.worker.rabbitmq;

import com.gallery.worker.model.Worker;
import com.gallery.worker.service.WorkerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    WorkerService workerService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(Worker worker) {
        workerService.addWorker(worker);
    }
}
