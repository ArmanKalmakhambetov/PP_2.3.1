package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {


    public void saveUser(User user);

    public void add(String name, String lastname, byte age);

    public void deleteUser(Long id);


    abstract void updateUser(User user);

    public User findById(Long id);

    public List<User> getAllUsers();


}