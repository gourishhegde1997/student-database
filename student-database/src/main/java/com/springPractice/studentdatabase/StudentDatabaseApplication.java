package com.springPractice.studentdatabase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.springPractice.studentdatabase.dto.AddressDTO;
import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.service.StudentService;


@SpringBootApplication
public class StudentDatabaseApplication implements CommandLineRunner {
	
	@Autowired
	AbstractApplicationContext context;
	
	@Autowired
	StudentService service;
	
	private static final Logger logger = Logger.getLogger(StudentDatabaseApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(StudentDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("");
		
		// Performing CRUD operations
		AddressDTO address = new AddressDTO(null, "@Uratota", "Karkisaval Post",
				"#241, \"Janani\"", "Siddapura", "Karnataka", "India", 581355);
		Date date = new SimpleDateFormat("dd-MM-yyyy").parse("23-12-1997");
		StudentDTO student = new StudentDTO(null, "Gourisha Hegde", date, 9538606818L, address);
		
		AddressDTO address2 = new AddressDTO(null, "Ronaldo Residence", "Ronaldo Residence",
				"Ronaldo Residence", "Porto", "Lisbon", "Portugal", 9281085);
		Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse("17-09-1987");
		StudentDTO student2 = new StudentDTO(null, "Cristiano Ronaldo", date2, 6338726539L, address2);
		
		// adding a student
		student = service.addStudent(student);
		student2 = service.addStudent(student2);
		logger.info("");
		
		// Retrieving all the students
		List<StudentDTO> studentList = service.listAllStudents();
		studentList.forEach(c -> logger.info("Student saved is : " + c.toString()));
		logger.info("");
		
		// updating student contact number 
		service.updateStudentContactNo(student2.getStudentId(), 8338726539L);
		logger.info("");
		
		// Retrieving Student by id
		service.getStudentById(student2.getStudentId());
		logger.info("");
		
		// Deleting the student
		service.removeStudent(student2);
		logger.info("");
		
		// Deleting all the students
		service.removeAllStudents();
		
	}

	
}
