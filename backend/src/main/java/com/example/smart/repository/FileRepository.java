package main.java.com.example.smart.repository;

import com.example.smart.model.FileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends MongoRepository<FileDocument, String> {
}
