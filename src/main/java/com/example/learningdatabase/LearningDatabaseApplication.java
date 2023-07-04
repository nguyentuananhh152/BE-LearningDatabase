package com.example.learningdatabase;

import com.example.learningdatabase.entity.User;
import com.example.learningdatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

@SpringBootApplication
@EnableJpaRepositories
public class LearningDatabaseApplication {

	private static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		context = SpringApplication.run(LearningDatabaseApplication.class, args);
//		insert_data();
	}
	public static void restart() {
		ApplicationArguments args = context.getBean(ApplicationArguments.class);

		Thread thread = new Thread(() -> {
			context.close();
			context = SpringApplication.run(LearningDatabaseApplication.class, args.getSourceArgs());
		});

		thread.setDaemon(false);
		thread.start();
	}

	public static void checkConnectJDBS(Connection connection) throws SQLException
	{
		if (connection != null && !connection.isClosed()) {
			// run sql statements
		} else {
			restart();
		}
	}

//	public static String random(int n) {
//		Random r = new Random();
//		ArrayList<Integer> arr = new ArrayList<>();
//		int number1;
//		int number2;
//		String str1;
//		str1 = "";
//		number2 = r.nextInt(99) + 1;		// ramdom number id of first ex
//		arr.add(number2);
//		str1 = Integer.toString(number2);
//		for (int i1 = 1; i1 < n; i1++) {		// random and add the rest of list ex
//			number2 = r.nextInt(99) + 1;
//			if (!arr.contains(number2)) {
//				arr.add(number2);
//				str1 += " ," + Integer.toString(number2);
//			}
//		}
//		return str1;
//	}
//	public static void insert_data() {
//		Random r = new Random();
//		int number1;
//		int number2;
//		int number3;
//		String str = "";
//		for (int i = 1; i < 101; i++) {
//			//~~~account~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
////			System.out.println("('" + i + "', 'username" + i + "', 'password" + i + "', '" + i + "', 'email." + i + "@gmail.com', 'false'),");
//
//			//~~~admin~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
////			System.out.println("(" + i + "),");
//
//			//~~~comment~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
////			number1 = r.nextInt(25) + 1;
////			number2 = r.nextInt(20) + 1;
////			number3 = r.nextInt(6) + 1;
////			System.out.println("('" + i + "', '" + Integer.toString(r.nextInt(99) + 1) + "', 'This is comment " + i + "', '" + number1 + "', '" + number2 + "', '" + number3 + "'),");
//
//			//~~~Excercise~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
////			System.out.println("('" + i + "', 'Exercise " + i + "', 'Query " + Integer.toString(r.nextInt(89) + 1) + " entity', 'Answer " + i + "'),");
//
//			//~~~Lesson~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
////			number1 = r.nextInt(10) + 1;
////			number2 = r.nextInt(5) + 1;
////			System.out.println("('" + i + "', 'lesson " + i + "', 'Learn query " + i + "', '[" + random(number1) + "]', '[" + random(number2) + "]'),");
//
//			//~~~Notification~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
////			System.out.println("('" + i + "', 'Notification " + i + "'),");
//
//			//~~~Student~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//			number1 = r.nextInt(2) + 1;
//			number2 = r.nextInt(20) + 1;
//			number3 = r.nextInt(15) + 1;
//			if (number1 == 1) {
//				number1 = r.nextInt(2) + 1;
//				System.out.println("('" + i + "', '[" + number1 + "]', '[" + random(number2) + "]', '[" + random(number3) + "]'),");
//			} else {
//				System.out.println("('" + i + "', '[1, 2]', '[" + random(number2) + "]', '[" + random(number3) + "]'),");
//			}
//
//			//~~~User~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
////			System.out.println("('" + i + "', '" + i + "', '0', 'name " + i + "', 'image" + i + ".jpg', '" + Integer.toString(r.nextInt(10) + 20) + "', 'Ha Noi " + i + "', 'false'),");
//		}
//	}
}

