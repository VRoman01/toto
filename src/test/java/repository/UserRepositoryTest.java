package repository;

import entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    @Test
    public void connection_and_add() {
        Repository<User> repository = new UserRepository();
        repository.add(new User());
    }


}