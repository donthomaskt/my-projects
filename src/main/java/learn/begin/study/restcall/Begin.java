package learn.begin.study.restcall;

import learn.begin.study.mongodb.User;
import learn.begin.study.mongodb.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Component
@RestController
public class Begin {

    private static final Logger logger = LogManager.getLogger(Begin.class);

    @Autowired
    UserRepository userRepository;

    int i = 1;

    @GetMapping("/")
    @ResponseBody
    public List<User> call() {
        try {
            System.out.println("Called");
            logger.debug("Debugging log");
            logger.info("Info log");
            logger.warn("Hey, This is a warning!");
            logger.error("Oops! We have an Error. OK");


        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRepository.findAll();
    }

    @GetMapping(value = "/create")
    public User addNewUsers() {

        User user = new User();
        user.setAge(10);
        user.setId(i++);
        user.setDesignation("Developper");
        user.setName("Don");
        return userRepository.save(user);
        //return "called";
    }

}
