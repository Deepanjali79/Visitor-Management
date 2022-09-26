package com.demo.controller.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.demo.controller.VisitorEntityController;
import com.demo.entities.DeliveryEntity;
import com.demo.entities.VisitorEntity;
import com.demo.exception.DuplicateRecordException;
import com.demo.exception.RecordNotFoundException;
import com.demo.service.VisitorService;
	
	@ActiveProfiles("test")
	@SpringBootTest
	class VisitorEntityControllerTest {
		
		@Autowired
		private VisitorService visitorService;

		@MockBean

		private VisitorEntityController vehicleCon;

		@Test
		void deleteVisitorTest() throws ParseException, DuplicateRecordException {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = formatter.parse("08-07-2022");
			
			VisitorEntity testVisitorEntity = new VisitorEntity("Divya","Dev Verma", "09:40:00", date, "09:00:00","21:00:00");
			VisitorEntity testVisitorEntitySaved = visitorService.add(testVisitorEntity);
			long visitorEntityTestId = testVisitorEntitySaved.getId();
			visitorService.deleteVisitorById(visitorEntityTestId);
			Assertions.assertThrows(NoSuchElementException.class, () -> {
				visitorService.findById(visitorEntityTestId);
			});

		}

		@Test
		void saveVisitorTest() throws ParseException, DuplicateRecordException, RecordNotFoundException {

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date = formatter.parse("08-07-2022");

			VisitorEntity testVisitorEntity = new VisitorEntity("Divya","Dev Verma", "09:40:00", date, "09:00:00","21:00:00");
			VisitorEntity testVisitorEntitySaved = visitorService.add(testVisitorEntity);
			long visitorEntityTestId = testVisitorEntitySaved.getId();

			VisitorEntity testVisitorEntityVB = visitorService.findById(visitorEntityTestId);
			Assertions.assertNotNull(testVisitorEntityVB);

			visitorService.deleteVisitorById(visitorEntityTestId);
		}

		@Test
		void TestRecordVisitorByIdShouldThrowDelIdException() throws RecordNotFoundException {
			assertThrows(RecordNotFoundException.class, () -> {
				VisitorEntity d = new VisitorEntity();
				visitorService.update(d);
			});
		}

	}
