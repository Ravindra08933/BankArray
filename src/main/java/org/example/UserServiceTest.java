//package org.example;
//import org.junit.jupiter.api.BeforeAll;
//public class UserServiceTest {
//
//    static UserServiceImpl userService = null;
//    static UserDao userDao=null;
//    @BeforeAll
//    static void BeforeClass() throws Exception
//    {
//        userService = new UserServiceImpl();
//        userDao = EasyMock.createMock(UserDao.class);
//        userService.setUserDao(userDao);
//        System.out.println("Before Class");
//    }
//    public void testUserDetails1()
//    {
//        User user = new User("Rob","Van");
//        EasyMock.expert(userDao.loadUserDetails("Rob")).andReturn(user);
//    }
//}
