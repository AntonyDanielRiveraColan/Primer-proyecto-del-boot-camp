package com.ejemplo2.ejemplo2.Controller;

import com.ejemplo2.ejemplo2.model.Family;
import com.ejemplo2.ejemplo2.model.Parent;
import com.ejemplo2.ejemplo2.Service.Impl.FamilyService;
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
@WebMvcTest(FamilyController.class)
public class FamilyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /** Crea una instancia de la clase e inyecta los simulacros */

    @InjectMocks
    FamilyController familyController;

/** Si existe un bean, compatible con la clase declarada en el contexto, reemplaza por el simulacro.
Si no es el caso, agrega el simulacro en el contexto como un bean. */
    @MockBean
    private FamilyService service;


    private static Logger LOG = Logger.getLogger(String.valueOf(Main.class));

    @Before
    public void setUp() throws Exception {
        LOG.info("INCIIO DEL TEST");
    }

    @After
    public void tearDown() throws Exception {
        LOG.info("FIN DEL TEST");
    }

    @Test
    public void getAllFamilies() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller-getAllFamilies");
        mockMvc.perform(MockMvcRequestBuilders.get("/apifamily/v1/read"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"));
    }

    @Test
    public void findByFamilyId() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller-findByFamilyId");
        mockMvc.perform(MockMvcRequestBuilders.get("/apifamily/v1/read/2"))
                .andExpect(status().isOk());
    }

    @Test
    public void addFamily() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller-addFamily");

        Family family = new Family();
        Parent parent = new Parent();
        parent.setId(8);
        family.setParent(parent);
        family.setFamilyName("Familia Nuñez");

        this.mockMvc.perform(MockMvcRequestBuilders.post("/apifamily/v1/create")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(family)))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateFamily() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller-updateFamily");
        Family family = new Family();
        Parent parent = new Parent();
        parent.setId(8);
        family.setId(11);
        family.setParent(parent);
        family.setFamilyName("Familia Nuñez");

        this.mockMvc.perform(MockMvcRequestBuilders.put("/apifamily/v1/update")
                .accept("application/json")
                .contentType("application/json")
                .content(asJsonString(family)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteFamily() throws Exception {
        LOG.info("com.ejemplo2.ejemplo2.Controller-deleteFamily");
        Family family = new Family();
        family.setId(4);

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/apifamily/v1/delete/{id}",family.getId()))
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