package com.demo.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entities.VisitorEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.repository.VisitorDAO;

@Service("visitorservice") // it provide business functionalities
public class VisitorEntityServiceImp implements VisitorService {

	@Autowired
	VisitorDAO visitorDao;

	@Override
	public List<VisitorEntity> showVisitorEntity() { // delivery list is created which acts like an in memory database
														// for delivery object
		System.out.println("Service layer entity called");
		return (List<VisitorEntity>) visitorDao.findAll();

	}

	public VisitorEntity add(VisitorEntity request) throws DuplicateRecordException {

		Optional<VisitorEntity> visitor = visitorDao.findById(request.getId());
		if (visitor.isPresent()) {

			throw new DuplicateRecordException("Visitor Entity with this name " + request.getId() + "already Exist");
		} else {
			return (VisitorEntity) visitorDao.save(request);

		}

	}

	@Transactional // applies as a default to all methods
	@Override
	public VisitorEntity update(VisitorEntity bean) throws RecordNotFoundException {

		Optional<VisitorEntity> visitor = visitorDao.findById(bean.getId());
		if (visitor.isPresent()) { // values is present ,isPresent()
			return (VisitorEntity) visitorDao.save(bean); // save method will return save entity
		} else {
			throw new RecordNotFoundException("Visitor Entity  id " + bean.getId() + "Doesn't Exist");
		}
	}

	@Override
	public boolean deleteVisitorById(long VisitorId) {
		visitorDao.deleteById(VisitorId);
		return false;
	}

	public VisitorEntity findById(VisitorEntity bean) throws RecordNotFoundException {

		Optional<VisitorEntity> visitor = visitorDao.findById(bean.getId());
		if (visitor.isPresent()) {
			return (VisitorEntity) visitorDao.save(bean);
		} else {
			throw new RecordNotFoundException("Visitor Entity with this Id " + bean.getId() + "Doesn't Exist");
		}
	}

	@Override
	public VisitorEntity findById(long visitorEntityTestId) {
		Optional<VisitorEntity> visitor = visitorDao.findById(visitorEntityTestId);
		return visitor.get();
	}
}
