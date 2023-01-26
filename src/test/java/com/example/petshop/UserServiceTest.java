package com.example.petshop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.petshop.model.User;
import com.example.petshop.model.exceptions.UserNotFoundException;
import com.example.petshop.repository.UserRepository;
import com.example.petshop.service.UserService;
import com.example.petshop.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user1;
    private User user2;
    private List<User> users;

    @Before
    public void setUp() {
        user1 = new User();
        user1.setId(1L);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("johndoe@email.com");
        user1.setBudget(new BigDecimal(5000));

        user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Jane");
        user2.setLastName("Smith");
        user2.setEmail("janesmith@email.com");
        user2.setBudget(new BigDecimal(3000));

        users = Arrays.asList(user1, user2);
    }

    @Test
    public void testListUsers() {
        when(userRepository.findAll()).thenReturn(users);
        List<User> result = userService.ListUsers();
        assertEquals(users, result);
    }
}


