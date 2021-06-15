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
import cl.uv.ici.arq.labs.demo.dtos.VideoDTO;

@FeignClient(name = "videoClient", url = "${rest.endpoints.video.url}")
public interface VideoClient {

	@GetMapping("/videos")
	public ResponseEntity<List<VideoDTO>> findAll();
	
	@GetMapping("/video/{videoId}")
	public ResponseEntity<VideoDTO> findById(@PathVariable String videoId);
	
	@PutMapping("/playLists/knowledge")
	public ResponseEntity<KnowledgeRequestDTO> saveKnowledge(@RequestBody KnowledgeRequestDTO request);

	@GetMapping("/videos/knowledge")
	public ResponseEntity<List<KnowledgeRequestDTO>> getKnowledge();	
	
	@GetMapping("/videos/{videoId}/knowledge")
	public ResponseEntity<KnowledgeRequestDTO> getKnowledgeByUser(@PathVariable String videoId);
}
