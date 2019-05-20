package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Family;
import com.ejemplo2.ejemplo2.model.Family_Member;
import com.ejemplo2.ejemplo2.model.Parent;
import com.ejemplo2.ejemplo2.model.Student;
import com.ejemplo2.ejemplo2.Service.Impl.Family_Member_Service;
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
@WebMvcTest(FamilyMemberController.class)
public class FamilyMemberControllerTest {

    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    FamilyMemberController familyMemberController;

    @MockBean
    private Family_Member_Service service;

    @Before
    public void setUp() throws Exception {
        LOG.info("INCIIO DEL TEST");

    }

    @After
    public void tearDown() throws Exception {
        LOG.info("FIN DEL TEST");

    }

    @Test
    public void getAllFamiliMembers() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - getAllFamiliMembers");

        mockMvc.perform(MockMvcRequestBuilders.get("/apifamily-member/v1/read"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void addFamilyMember() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - addFamilyMember");

        Family_Member family_member = new Family_Member();
        Parent parent = new Parent();
        Student student = new Student();
        Family family = new Family();
        parent.setId(8);
        student.setId(8);
        family.setId(8);
        family_member.setId(5);
        family_member.setParent(parent);
        family_member.setStudent(student);
        family_member.setFamily(family);
        family_member.setParentOrStudentMember("Estudiante");

        /* family.setFamilyName("Familia Nuñez"); */

        this.mockMvc.perform(MockMvcRequestBuilders.post("/apifamily-member/v1/create")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(family_member)))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateFamilyMember() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - updateFamilyMember");

        Family_Member family_member = new Family_Member();
        Parent parent = new Parent();
        Student student = new Student();
        Family family = new Family();
        parent.setId(8);
        student.setId(8);
        family.setId(8);
        family_member.setId(5);
        family_member.setParent(parent);
        family_member.setStudent(student);
        family_member.setFamily(family);
        family_member.setParentOrStudentMember("Estudiante");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/apifamily-member/v1/update")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(family_member)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteFamilyMember() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller - deleteFamilyMember");

        Family_Member family_member = new Family_Member();
        family_member.setId(2);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/apifamily-member/v1/delete/{id}",family_member.getId()))
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