package org.example;
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    public UserServiceImpl() {
    }
    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public User loadUserDetails(String userName) {
        return userDao.loadUserDetails(userName);
    }
}
