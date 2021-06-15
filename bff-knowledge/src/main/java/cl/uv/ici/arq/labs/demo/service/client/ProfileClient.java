package cl.uv.ici.arq.labs.demo.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cl.uv.ici.arq.labs.demo.dtos.KnowledgeRequestDTO;
import cl.uv.ici.arq.labs.demo.dtos.PlaylistDTO;
import cl.uv.ici.arq.labs.demo.dtos.UserDTO;

@FeignClient(name = "profileClient", url = "${rest.endpoints.profile.url}")
public interface ProfileClient {

	@GetMapping("/profiles")
	public ResponseEntity<List<PlaylistDTO>> findAll();
	
	@GetMapping("/profile/{profileId}")
	public ResponseEntity<PlaylistDTO> findById(@PathVariable String profileId);
	
	@PutMapping("/profiles/knowledge")
	public ResponseEntity<KnowledgeRequestDTO> saveKnowledge(@RequestBody KnowledgeRequestDTO request);

	@GetMapping("/profiles/knowledge")
	public ResponseEntity<List<KnowledgeRequestDTO>> getKnowledge();	
	
	@GetMapping("/profiles/{userId}/knowledge")
	public ResponseEntity<KnowledgeRequestDTO> getKnowledgeByUser(@PathVariable String profileId);
}
