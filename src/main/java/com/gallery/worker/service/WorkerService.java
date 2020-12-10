package com.gallery.worker.service;

import com.gallery.worker.model.Position;
import com.gallery.worker.model.Worker;

import java.util.List;
import java.util.UUID;

public interface WorkerService {

    Worker addWorker(Worker worker);

    List<Worker> getAll();

    Worker getById(UUID id);

    List<Worker> getWorkersByPosition(Position position);

    void deleteWorkerById(UUID id);

}
