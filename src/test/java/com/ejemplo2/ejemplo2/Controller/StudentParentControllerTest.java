package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Parent;
import com.ejemplo2.ejemplo2.model.Student;
import com.ejemplo2.ejemplo2.model.Student_Parent;
import com.ejemplo2.ejemplo2.Service.Impl.StudentParentService;
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
@WebMvcTest(StudentParentController.class)
public class StudentParentControllerTest {
    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    StudentParentController parentController;

    @MockBean
    private StudentParentService service;

    @Before
    public void setUp() throws Exception {
        LOG.info("INCIIO DEL TEST");
    }

    @After
    public void tearDown() throws Exception {
        LOG.info("FIN DEL TEST");
    }

    @Test
    public void getAllStudentParents() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - getAllStudentParents");
        mockMvc.perform(MockMvcRequestBuilders.get("/apistudent-parent/v1/read"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void addStudentParents() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - addStudentParents");
        Student_Parent student_parent = new Student_Parent();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/apistudent-parent/v1/create")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(student_parent)))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateStudentParents() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - updateStudentParents");
        Student_Parent student_parent = new Student_Parent();
        this.mockMvc.perform(MockMvcRequestBuilders.put("/apistudent-parent/v1/update")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(student_parent)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteStudentParents() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - deleteStudentParents");
        Student student = new Student();
        Parent parent = new Parent();
        Student_Parent student_parent = new Student_Parent();
        student_parent.setParent(parent);
        student_parent.setStudent(student);
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/apistudent-parent/v1/delete/studentid/{studentid}/parentid/{parentid}",
                student.getId(),parent.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void getStudentParent() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - getStudentParent");
        Student student = new Student();
        Parent parent = new Parent();
        Student_Parent student_parent = new Student_Parent();
        student_parent.setParent(parent);
        student_parent.setStudent(student);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/apistudent-parent/v1/read/studentid/{studentid}/parentid/{parentid}",
                student.getId(),parent.getId()))
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