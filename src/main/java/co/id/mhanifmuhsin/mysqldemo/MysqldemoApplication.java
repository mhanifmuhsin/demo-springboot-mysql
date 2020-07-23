package co.id.mhanifmuhsin.mysqldemo;

import co.id.mhanifmuhsin.mysqldemo.student.Student;
import co.id.mhanifmuhsin.mysqldemo.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;


@SpringBootApplication
public class MysqldemoApplication {

    private static final Logger log = (Logger) LoggerFactory.getLogger(MysqldemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MysqldemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository repository) {
        return (args) -> {
//			tambah data siswa
			repository.save(new Student("001", "Agus","Jaya","agus@gmail.com", Student.Gender.L));
			repository.save(new Student("002", "Baban","Bandung","baban@gmail.com", Student.Gender.L));
			repository.save(new Student("003", "Cucu","Sugiarto","cucu@gmail.com", Student.Gender.P));
			repository.save(new Student("004", "Deni","Dani","deni@gmail.com", Student.Gender.L));
			repository.save(new Student("005", "Erna","Erni","erna@gmail.com", Student.Gender.P));
			repository.save(new Student("006", "Faishal","Layung","layung@gmail.com", Student.Gender.L));
			repository.save(new Student("007", "Udin","Sedunia","sedunia@gmail.com", Student.Gender.L));

            //menmpilkan semua data siswa
            log.info("========= Data Siswa ==========");
            for (Student datas : repository.findAll()
            ) {
                log.info(datas.toString());
            }
            log.info("===============================");

//            menampilkan data siswa berdasarkan id
            log.info("========= Data Siswa Berdasarkan Id ==========");
            Optional<Student> student = repository.findById("007");
            log.info(student.toString());
            log.info("===============================");

            log.info("========= Data Siswa Berdasarkan Last Name ==========");
            Optional<Student> students = repository.findAllByLastName("Dani");
            log.info(students.toString());
            log.info("===============================");

            //delete data siswa berdasarkan id
//			repository.deleteById("001");

//            delete semua
//            repository.deleteAll();


        };
    }
}
