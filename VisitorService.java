package com.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.demo.entities.VisitorEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;

@Service
public interface VisitorService {
	List<VisitorEntity> showVisitorEntity();

	public VisitorEntity add(VisitorEntity bean) throws DuplicateRecordException;

	public VisitorEntity update(VisitorEntity bean) throws RecordNotFoundException;

	public boolean deleteVisitorById(long VisitorId);

	public VisitorEntity findById(long visitorEntityTestId) throws RecordNotFoundException;

	public VisitorEntity findById(VisitorEntity bean) throws RecordNotFoundException;

}