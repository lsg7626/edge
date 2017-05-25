package domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

/**
 * Music
 * 
 * @since 2016. 9. 25.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */

@XmlRootElement(name="music")
@XmlAccessorType(XmlAccessType.FIELD)
@Component
public class Music {
	//
	private int id;
	private String name;
	private String artist;
	private String album;
	private String image;
	private String agent;

	
	@Override
	public String toString() {
		return "Music [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", image=" + image
				+ ", agent=" + agent + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAgent() {
		if(agent == null)
			return "여긴없는회사";
			
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

}
