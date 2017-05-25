package domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name="musics")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Musics {
	
	@XmlElement(name="music")
	private List<Music> list;

	public List<Music> getList() {
		return list;
	}

	public void setList(List<Music> list) {
		this.list = list;
	}
}
