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

@FeignClient(name = "playListClient", url = "${rest.endpoints.playlist.url}")
public interface PlayListClient {

	@GetMapping("/playLists")
	public ResponseEntity<List<PlaylistDTO>> findAll();
	
	@GetMapping("/playlist/{playlistId}")
	public ResponseEntity<PlaylistDTO> findById(@PathVariable String playListId);
	
	@PutMapping("/playLists/knowledge")
	public ResponseEntity<KnowledgeRequestDTO> saveKnowledge(@RequestBody KnowledgeRequestDTO request);

	@GetMapping("/playLists/knowledge")
	public ResponseEntity<List<KnowledgeRequestDTO>> getKnowledge();	
	
	@GetMapping("/playLists/{playlistId}/knowledge")
	public ResponseEntity<KnowledgeRequestDTO> getKnowledgeByUser(@PathVariable String playListId);
}
