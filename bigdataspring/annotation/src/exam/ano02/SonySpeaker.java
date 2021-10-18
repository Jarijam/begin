package exam.ano02;

import org.springframework.stereotype.Repository;

@Repository("sony")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("SonySpeaker객체생성");
	}
	public void soundUp() {
		System.out.println("SonySpeaker의 볼륨업~~~~");
	}
	public void soundDown() {
		System.out.println("SonySpeaker의 볼륨다운~~~~");
	}
}
