package com.test.repsitory;





import com.test.entity.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutboxRepository extends JpaRepository<Outbox,Long> {

     List<Outbox> findByProcessedFalse();
}