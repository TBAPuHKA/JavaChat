package ut.websocketbot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ut.websocketbot.model.Message;

@Repository
public interface MessageRepository extends MongoRepository <Message, String> {

}
