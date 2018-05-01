package net.ljchen.learn;

import net.ljchen.learn.Controller.StudentController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentControllerTests {

    private MockMvc mockMvc;

    @Mock
    private StudentController controller;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void get_students_test() {
        try {
            //controller.getStudent();
            //mockMvc.perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
