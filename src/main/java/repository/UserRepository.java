package repository;

import entity.User;
import repository.Specification.Specification;

import java.sql.*;
import java.util.List;

public class UserRepository implements Repository<User> {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "root";
    private Connection connection;

    public UserRepository() {

        try {
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("failed to load jdbc driver");
        } catch (SQLException e){
            throw new RuntimeException("failed to get connection",e);
        }

    }

    @Override
    public User add(User user) {

        String query = "insert into user (name, surname, email) values (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getName());
            statement.setString(2,user.getSurname());
            statement.setString(3,user.getEmail());
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            int id = (keys.getInt(1));
            user.setId(id);

            return user;
        } catch (SQLException e) {
            throw new RuntimeException("failed to prepareStatement",e);
        }

    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public List<User> query(Specification specification) {
        return null;
    }
}
