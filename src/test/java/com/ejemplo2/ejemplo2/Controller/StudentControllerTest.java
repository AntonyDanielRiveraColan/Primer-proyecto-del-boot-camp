package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Student;
import com.ejemplo2.ejemplo2.Service.Impl.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sun.applet.Main;

import java.util.logging.Logger;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    StudentController parentController;

    @MockBean
    private StudentService service;

    @Before
    public void setUp() throws Exception {
        LOG.info("INCIIO DEL TEST");
    }

    @After
    public void tearDown() throws Exception {
        LOG.info("FIN DEL TEST");
    }

    @Test
    public void getAllStudents() throws Exception {
        LOG.info(" com.ejemplo2.ejemplo2.Controller - getAllStudents");
        mockMvc.perform(MockMvcRequestBuilders.get("/apistudent/v1/read"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void addStudent() throws Exception {
        LOG.info(" com.ejemplo2.ejemplo2.Controller - addStudent");
        Student student = new Student();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/apistudent/v1/create")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(student)))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateStudent() throws Exception {
        LOG.info(" com.ejemplo2.ejemplo2.Controller - updateStudent");
        Student student = new Student();
        this.mockMvc.perform(MockMvcRequestBuilders.put("/apistudent/v1/update")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(student)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteStudent() throws Exception {
        LOG.info(" com.ejemplo2.ejemplo2.Controller - deleteStudent");
        Student student = new Student();
        student.setId(4);
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/apistudent/v1/delete/{id}",student.getId()))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        LOG.info("com.ejemplo2.ejemplo2.Controller-asJsonString");
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}