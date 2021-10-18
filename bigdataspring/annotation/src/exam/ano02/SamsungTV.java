package exam.ano02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("samsung")
public class SamsungTV implements TV{
	@Autowired
	@Qualifier("sony")
	Speaker speaker;
	
	public SamsungTV() {
	}
	
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}


	public void turnOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}

	public void turnOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	public void soundUp() {
		System.out.println("SamsungTV---소리 올린다.");
		speaker.soundUp();
	}

	public void soundDown() {
		System.out.println("SamsungTV---소리 내린다.");
		speaker.soundDown();
	}
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
}
