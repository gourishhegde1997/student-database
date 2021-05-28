package com.springPractice.studentdatabase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.springPractice.studentdatabase.dto.AddressDTO;
import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.exceptions.StudentServiceException;
import com.springPractice.studentdatabase.service.StudentService;

@SpringBootApplication
@PropertySource("classpath:messages.properties")
public class StudentDatabaseApplication implements CommandLineRunner {

	@Autowired
	ApplicationContext context;

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
//
//		// Performing CRUD operations
//		AddressDTO address = new AddressDTO(null, "@Uratota,Karkisaval Post, Siddapura", 581355);
//		LocalDate date = LocalDate.of(1997, Month.DECEMBER, 23);
//		StudentDTO student = new StudentDTO(null, "Gourisha Hegde", date, "9538606818", "gourisha.hegde@infosys.com", address);
//
//		// adding a student
//		try {
//			student = service.addStudent(student);
//		} catch (StudentServiceException ex) {
//			logger.error(messages.getProperty(ex.getMessage()), ex);
//		}
//
//		logger.info("");
//
		// Retrieving all the students
		List<StudentDTO> studentList = service.findByStudentName("Gourisha Hegde");
		studentList.forEach(c -> logger.info("Student(s) available is/are : " + c.toString()));
		logger.info("");
//
//		// updating student contact number
//		service.updateStudentContactNo(student2.getStudentId(), 8338726539L);
//		logger.info("");
//
//		// getting students in a page
//		Long studentsCount = service.getStudentsCount();
//		int numberOfStudentsPerPage = 4;
//		Integer pageCount = (int) (studentsCount / numberOfStudentsPerPage);
//		for (int page = 0; page <= pageCount; page++) {
//			System.out.println("Page index : " + page);
//			Pageable pageable = PageRequest.of(page, numberOfStudentsPerPage);
//			for (StudentDTO studentDto : service.findAll(pageable)) {
//				System.out.println(studentDto);
//			}
//		}
//
//		// sorting the students
//		Sort sort = Sort.by(Sort.Direction.ASC, "studentName");
//		List<StudentDTO> studentsListSorted = service.findAll(sort);
//		for (StudentDTO studentDto : studentsListSorted) {
//			System.out.println(studentDto);
//		}
//
//		// Retrieving Student by id
//		try {
//			service.getStudentById(id);
//		} catch (StudentServiceException ex) {
//			logger.error(messages.getProperty(ex.getMessage()), ex);
//		}
//		logger.info("");
//
//		// Deleting the student
//		service.removeStudent(student2);
//		logger.info("");
//
//		// Deleting all the students
//		service.removeAllStudents();

	}

}
