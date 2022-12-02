package web.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
@Service
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Transactional
    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
    @Transactional
    @Override
    public void update(int id, User user) {
        userDao.update(id,user);
    }
}
