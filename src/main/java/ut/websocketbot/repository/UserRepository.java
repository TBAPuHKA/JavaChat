package ut.websocketbot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ut.websocketbot.model.User;

@Repository
public interface UserRepository extends MongoRepository <User, String> {
    User findByName(String name);
}
