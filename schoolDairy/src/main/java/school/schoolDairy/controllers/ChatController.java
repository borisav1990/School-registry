package school.schoolDairy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

import org.springframework.stereotype.Controller;

import school.schoolDairy.models.ChatMessage;
import school.schoolDairy.repository.ChatRepository;



@Controller
public class ChatController {
	
	@Autowired
	private ChatRepository chatRep;
	
	/*@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register( @Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		
		return chatMessage;
		
		
	}*/
	
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		chatRep.save(chatMessage);
		
		
	
		
		System.out.println("+++++++++++++++++++++++++" + chatMessage.getContent());
		return chatMessage;
	}

}
