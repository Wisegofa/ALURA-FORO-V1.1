package com.alura.foro.AluraForo.Repository;

import com.alura.foro.AluraForo.Modelo.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
