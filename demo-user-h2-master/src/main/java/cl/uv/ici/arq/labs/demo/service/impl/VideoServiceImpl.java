
import cl.uv.ici.arq.labs.demo.dtos.VideoDTO;
import cl.uv.ici.arq.labs.demo.entities.VideoEntity;
import cl.uv.ici.arq.labs.demo.mapper.MapperUtils;
import cl.uv.ici.arq.labs.demo.repository.VideoRepository;
import cl.uv.ici.arq.labs.demo.service.VideoService;

@Service("videoService")
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoRepository videoRepository;
	
	

	private VideoEntity mapVideoEntity(VideoDTO videoDTO) {
		VideoEntity video= new VideoEntity();		
		video.setFirstName(videoDTO.getFirstName());
		video.setLastName(videoDTO.getLastName());
		return video;
	}
	
	@Override
	public VideoDTO createVideo(VideoDTO videoDTO) {
		VideoEntity videoEntity = this.mapVideoEntity(videoDTO);
		videoEntity =this.videoRepository.save(videoEntity);
		videoDTO=(VideoDTO) MapperUtils.map(videoEntity, VideoDTO.class);
		return videoDTO;
	}


	@Override
	public boolean removeVideo(String idVideo) {
		boolean delete=true;		
		this.videoRepository.deleteById(UUID.fromString(idVideo));		
		return delete;
	}

	@Override
	public VideoDTO updateVideo(VideoDTO videoDTO) {
		VideoEntity videoEntity = this.mapVideoEntity(videoDTO);
		videoEntity.setVideoId(UUID.fromString(videoDTO.getVideoId()));
		videoEntity =this.videoRepository.save(videoEntity);
		videoDTO=(VideoDTO) MapperUtils.map(videoEntity, VideoDTO.class);
		return videoDTO;
	}

	@Override
	public VideoDTO getVideo(String idVideo) {
		return (VideoDTO) MapperUtils.map(this.videoRepository.findById(UUID.fromString(idVideo)).get(), VideoDTO.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<VideoDTO> getVideo() {
		 return (List<VideoDTO>) MapperUtils.mapAsList(videoRepository.getAll(), new TypeToken<List<VideoDTO>>() {}.getType());
		 //return (List<videoDTO>) MapperUtils.mapAsList(videoRepository.findAll(), new TypeToken<List<videoDTO>>() {}.getType());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<VideoDTO> findBylastName(String lastName) {
		 return (List<VideoDTO>) MapperUtils.mapAsList(videoRepository.findByLastName(lastName), new TypeToken<List<VideoDTO>>() {}.getType());
	}

}
