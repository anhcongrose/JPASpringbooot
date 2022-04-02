package fis.java.com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fis.java.com.Entity.Oder;
import fis.java.com.Repository.OderRepository;

@Service
public class OderService implements IOderService {
	@Autowired
	private OderRepository OderRepository;

	@Override
	public Oder getOderById(Long oderId) {

		return OderRepository.findById(oderId).get();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String creatOder(Oder oder) {
		String mesage = "Mã đơn hàng đã tồn tại!";
		Oder oder1 = new Oder();
		if (oder.getOderNumber().equals(OderRepository.existsByOderNumber(oder1.getOderNumber())))
			return mesage;
		if (oder.getOderNumber().length() != 10)
			return "mã đơn hàng không hợp lệ!";
		OderRepository.save(oder);
		return "creat Oder successfully!";
	}

	@Override
	public Oder updateOder(Oder oder) {

		return OderRepository.save(oder);
	}

	@Override
	public void deleteById(Long oderId) {
		
		OderRepository.deleteById(oderId);

	}

}
