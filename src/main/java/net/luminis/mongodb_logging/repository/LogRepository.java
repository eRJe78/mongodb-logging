package net.luminis.mongodb_logging.repository;

import net.luminis.mongodb_logging.domain.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogRepository extends MongoRepository<Log, String> {
    List<Log> findByName(String name);
}
