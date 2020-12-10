package com.gallery.worker.service;

import com.gallery.worker.model.Position;
import com.gallery.worker.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
    List<Worker> getAllByPosition(Position position);
}
