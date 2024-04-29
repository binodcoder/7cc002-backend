package uk.ac.wlv.groupwork;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.ac.wlv.groupwork.dao.UserRepository;
import uk.ac.wlv.groupwork.model.Role;
import uk.ac.wlv.groupwork.model.User;
import uk.ac.wlv.groupwork.service.PasswordEncoder;
import uk.ac.wlv.groupwork.service.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testLogin() {
        String email = "sahan@bcas.lk";
        String password = "123";
        String hashedPassword = "40bd001563085fc35165329ea1ff5c5ecbdbbeef";

        when(PasswordEncoder.encode(password)).thenReturn(hashedPassword);

        User mockUser = new User();
        mockUser.setEmail(email);
        mockUser.setPassword(hashedPassword);

        when(userRepository.findByEmailAndPassword(email, hashedPassword)).thenReturn(mockUser);

        User result = userService.login(email, password);

        assertEquals(mockUser, result);
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User();
        User user2 = new User();
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllTrainers() {
        User trainer1 = new User();
        trainer1.setRole(Role.trainer);
        User trainer2 = new User();
        trainer2.setRole(Role.trainer);

        when(userRepository.findByRole(Role.trainer)).thenReturn(Arrays.asList(trainer1, trainer2));

        List<User> result = userService.getAllTrainers();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetUserById() {
        int userId = 1;
        User mockUser = new User();
        mockUser.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));

        Optional<User> result = userService.getUserById(userId);

        assertEquals(mockUser, result.orElse(null));
    }

//
//    @Test
//    public void testAddUser() {
//        User user = new User();
//        when(userRepository.save(user)).thenReturn(user);
//
//        User result = userService.addUser(user);
//
//        assertEquals(user, result);
//    }
//
//    @Test
//    public void testUpdateUser() {
//        User user = new User();
//        when(userRepository.save(user)).thenReturn(user);
//
//        User result = userService.updateUser(user);
//
//        assertEquals(user, result);
//    }
//
//    @Test
//    public void testDeleteUserById() {
//        int userId = 1;
//
//        userService.deleteUserById(userId);
//
//        verify(userRepository, times(1)).deleteById(userId);
//    }

}
