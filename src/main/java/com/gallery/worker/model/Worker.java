package com.gallery.worker.model;

import com.gallery.worker.WorkerRequest;
import com.gallery.worker.WorkerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.UUID;

@EnableAutoConfiguration
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public final class Worker {

    @Id
    private UUID workerId;

    private String name;
    private String surname;
    private int salary;

    @Enumerated(EnumType.STRING)
    private Position position;

    public Worker(String name, String surname, int salary, Position position) {
        workerId = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.position = position;
    }

    public static Worker fromWorkerRequest(WorkerRequest workerRequest) {
        return new Worker(UUID.randomUUID(),
                workerRequest.getName(),
                workerRequest.getSurname(),
                (int) workerRequest.getSalary(),
                Position.valueOf(workerRequest.getPosition().toString()));
    }

    public WorkerResponse toWorkerResponse() {
        return WorkerResponse.newBuilder().
                setId(workerId.toString()).
                setName(name).
                setSurname(surname).
                setSalary(salary).

                setPosition(com.gallery.worker.Position.valueOf(position.name())).
                build();
    }
}
