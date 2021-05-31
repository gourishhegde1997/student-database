package com.springPractice.studentdatabase;

import com.springPractice.studentdatabase.dto.StudentDTO;
import com.springPractice.studentdatabase.service.StudentService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.UUID;

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
//        UUID id = UUID.fromString("4a9f5280-b013-47cc-ab20-dea02d8c4d0e");
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
//        StudentDTO student = service.findByEmailAndName("radhika.hegde@infosys.com", "Radhika Hegde").get(0);
//        service.updateStudentEmail("radhika.hegde@gmail.com", student.getStudentId());
//		logger.info("");

        // Retrieving all the students
        List<StudentDTO> studentList = service.findByEmailAndName("gourisha.hegde@infosys.com", "Gourisha Hegde");
        studentList.forEach(c -> logger.info("Student(s) available is/are : " + c.toString()));
        logger.info("");

		// check whether a student exist or not
        logger.info("Students' existence status : " + service.checkIfStudentExists("Gourisha Hegde", "gourisha.hegde@infosys.com", "9538606818"));
		logger.info("");
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
