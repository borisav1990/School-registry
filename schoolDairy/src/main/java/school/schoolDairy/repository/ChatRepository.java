package school.schoolDairy.repository;

import org.springframework.data.repository.CrudRepository;

import school.schoolDairy.models.ChatMessage;

public interface ChatRepository extends CrudRepository<ChatMessage, Long> {

}
