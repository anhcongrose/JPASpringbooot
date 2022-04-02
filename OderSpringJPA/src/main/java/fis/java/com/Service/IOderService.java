package fis.java.com.Service;

import org.springframework.stereotype.Component;

import fis.java.com.Entity.Oder;

@Component
public interface IOderService {
	Oder getOderById(Long oderId);

	String creatOder(Oder oder);

	Oder updateOder(Oder oder);

	void deleteById(Long oderId);

}
