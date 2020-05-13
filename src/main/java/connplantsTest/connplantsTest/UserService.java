package connplantsTest.connplantsTest;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
	private List<User> users;

    // Love Java 8
    public List<User> findByUserNameOrEmail(String username) {

    	User user1 = new User("mkyong" + username, String.valueOf(Math.floor(Math.random()*100)).split("\\.")[0], "mkyong@yahoo.com");
        User user2 = new User("yflow" + username, String.valueOf(Math.floor(Math.random()*100)).split("\\.")[0], "yflow@yahoo.com");
    	
        List<User> result = new ArrayList<User>();
        result.add(user1);
        result.add(user2);
        
       /* List<User> result = users.stream()
            .filter(x -> x.getUsername().equalsIgnoreCase(username))
            .collect(Collectors.toList());*/

        return result;

    }

    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<User>();

        User user1 = new User("mkyong", "password111", "mkyong@yahoo.com");
        User user2 = new User("yflow", "password222", "yflow@yahoo.com");
        User user3 = new User("laplap", "password333", "mkyong@yahoo.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);

    }
}
