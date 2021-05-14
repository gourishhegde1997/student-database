package com.springPractice.studentdatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;

import com.springPractice.studentdatabase.dto.AddressDTO;
import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.exceptions.StudentServiceException;
import com.springPractice.studentdatabase.service.StudentService;


@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class StudentDatabaseApplication implements CommandLineRunner {
	
	@Autowired
	AbstractApplicationContext context;
	
	@Autowired
	StudentService service;
	
	@Autowired
	private Environment messages;
	
	private static final Logger logger = Logger.getLogger(StudentDatabaseApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StudentDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("");
		
		// Performing CRUD operations
		UUID id = UUID.randomUUID();
		AddressDTO address = new AddressDTO(null, "@Uratota", "Karkisaval Post",
				"#241, \"Janani\"", "Siddapura", "Karnataka", "India", 581355);
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse("23-12-1997");
		StudentDTO student = new StudentDTO(null, "Gourisha Hegde", date, 9538606818L, address);
		
		AddressDTO address2 = new AddressDTO(null, "Ronaldo Residence", "Ronaldo Residence",
				"Ronaldo Residence", "Porto", "Lisbon", "Portugal", 9281085);
		Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse("17-09-1987");
		StudentDTO student2 = new StudentDTO(null, "Cristiano Ronaldo", date2, 6338726539L, address2);
		
		// adding a student
		try {
			student = service.addStudent(student);
			student2 = service.addStudent(student2);
		} catch (StudentServiceException ex) {
			logger.error(messages.getProperty(ex.getMessage()), ex);
		}
		
		logger.info("");
		
		// Retrieving all the students
		List<StudentDTO> studentList = service.listAllStudents();
		studentList.forEach(c -> logger.info("Student saved is : " + c.toString()));
		logger.info("");
		
		// updating student contact number 
		service.updateStudentContactNo(student2.getStudentId(), 8338726539L);
		logger.info("");
		
		// Retrieving Student by id
		try {
			service.getStudentById(id);
		} catch (StudentServiceException ex) {
			logger.error(messages.getProperty(ex.getMessage()), ex);
		}
		logger.info("");
		
		// Deleting the student
		service.removeStudent(student2);
		logger.info("");
		
		// Deleting all the students
		service.removeAllStudents();
		
	}

	
}
