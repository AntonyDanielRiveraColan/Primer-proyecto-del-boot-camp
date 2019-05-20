package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Parent;
import com.ejemplo2.ejemplo2.Service.Impl.ParentService;
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
@WebMvcTest(ParentController.class)
public class ParentControllerTest {

    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    ParentController parentController;

    @MockBean
    private ParentService service;

    @Before
    public void setUp() throws Exception {
        LOG.info("INCIIO DEL TEST");
    }

    @After
    public void tearDown() throws Exception {
        LOG.info("FIN DEL TEST");
    }

    @Test
    public void findAllParents() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.ControllerT - findAllParents");
        mockMvc.perform(MockMvcRequestBuilders.get("/apiparent/v1/read"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void addParent() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.ControllerT - addParent");

        Parent parent = new Parent();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/apiparent/v1/create")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(parent)))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateParent() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.ControllerT - updateParent");

        Parent parent = new Parent();
        this.mockMvc.perform(MockMvcRequestBuilders.put("/apiparent/v1/update")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(parent)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteParent() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.ControllerT - deleteParent");
        Parent parent = new Parent();
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/apiparent/v1/delete/{id}",parent.getId()))
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