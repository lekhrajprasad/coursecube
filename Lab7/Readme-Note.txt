This example explain the @SpringBootApplication and SpringBootInitializer

Q29) What is the CommandLineRunner interface?
Ans:
1)Implement CommandLineRunner
2)Override run() method
public void run(String... args) throws Exception {
3)write Code to perform some tasks at Boot Application Startup:
 Increare JVM Memory
 Load the cache data
 Check DB Connections
 Insert Some Data into DB
 Cross Chek Third Party Apps Status
etc
Q31) Who is responseible for Launching Spring Boot Application?
Ans:
SpringApplication.run(MyBootApp.class, args);
Parameters of run() method
1)MyBootApp.class => Boot Main class
2)Command Line Args which are comming to main() method.
Q32) What are the StereoType Annotations?
Ans:
@Service
@Controller
@Repository
@Component



