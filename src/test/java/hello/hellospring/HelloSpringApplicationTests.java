package hello.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloSpringApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void 컴파일단계오류못찾는사례() {
		abstract class Info {
			abstract String getName();
		}

		class StudentInfo extends Info {
			private String schoolName;
			public StudentInfo(String schoolName) {
				this.schoolName = schoolName;
			}

			@Override
			String getName() {
				return schoolName;
			}
		}

		class WorkerInfo extends Info {
			private String companyName;
			public WorkerInfo(String companyName) {
				this.companyName = companyName;
			}

			@Override
			String getName() {
				return companyName;
			}
		}

		class Person {
			private Object info;
			public Person(Object info) {
				this.info = info;
			}
		}

		Person student = new Person(new StudentInfo("영동고"));
		Person worker = new Person(new WorkerInfo("아프리카TV"));
		Person wrong = new Person(1);
		WorkerInfo ei = (WorkerInfo) wrong.info; // 런타임시 에러 바랭
		ei.getName();
	}

	@Test
	void 컴파일단계오류찾음() {
		abstract class Info {
			abstract String getName();
		}

		class StudentInfo extends Info {
			private String schoolName;
			public StudentInfo(String schoolName) {
				this.schoolName = schoolName;
			}

			@Override
			String getName() {
				return schoolName;
			}
		}

		class WorkerInfo extends Info {
			private String companyName;
			public WorkerInfo(String companyName) {
				this.companyName = companyName;
			}

			@Override
			String getName() {
				return companyName;
			}
		}

		class Person<T> {
			private T info;
			public Person(T info) {
				this.info = info;
			}
		}

		Person<StudentInfo> student = new Person<>(new StudentInfo("영동고"));
		Person<WorkerInfo> worker = new Person<>(new WorkerInfo("아프리카TV"));
		Person<Integer> wrong = new Person<>(1);
//		WorkerInfo workerinfo = wrong.info; // 오류찾음...
	}

	@Test
	void 함수형인터페이스() {
		abstract class TestFunction {
			public abstract int test(int a, int b);
		}

		TestFunction testFunction = new TestFunction() {
			@Override
			public int test(int a, int b) {
				return a+b;
			}
		};

		int result = testFunction.test(3,5);
		Assertions.assertThat(result).isEqualTo(8);


	}
}
