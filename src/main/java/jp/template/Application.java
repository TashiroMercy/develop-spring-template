package jp.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.Transactional;

import jp.template.domain.Todo;
import jp.template.mapper.TodoMapper;

@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
    @Autowired
    TodoMapper todoMapper; // Mapper���C���W�F�N�V��������

    // Spring Boot�N������CommandLineRunner#run���\�b�h���Ăяo�����
    @Transactional
    @Override
    public void run(String... args) throws Exception { 
    	
        Todo newTodo = new Todo();
        newTodo.setTitle("TODO1");
        newTodo.setDetails("TODO1�ڍ�");

        todoMapper.insert(newTodo); // �V����Todo���C���T�[�g����
//        for (int i = 0; i < 10000; i++) {
//        	todoMapper.insert(newTodo);
//    }
        Todo loadedTodo = todoMapper.select(newTodo.getId()); // �C���T�[�g����Todo���擾���ĕW���o�͂���
        System.out.println("ID       : " + loadedTodo.getId());
        System.out.println("TITLE    : " + loadedTodo.getTitle());
        System.out.println("DETAILS  : " + loadedTodo.getDetails());
        System.out.println("FINISHED : " + loadedTodo.isFinished());

//        List<Todo> list = todoMapper.selectAll();
//        
//        for (Todo entity : list) {
//        	System.out.println("ID       : " + entity.getId());
//        }
    }
}
