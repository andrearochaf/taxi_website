package ksftaxispringback.PersonTest;

import ksftaxispringback.controller.rest.SecurityController;
import ksftaxispringback.entity.Person;
import ksftaxispringback.entity.dto.AuthRequest;
import ksftaxispringback.repository.PersonDao;
import ksftaxispringback.service.JwtPersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SecurityController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JwtPersonService jwtPersonService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAPerson() throws Exception {
        mockMvc.perform(get("/persons/1"))
                .andExpect(status().isOk());
    }

//    @Test
//    public void createPerson() throws Exception {
//        String uri = "/register";
//        AuthRequest person = new AuthRequest();
//        person.setUsername("test");
//        person.setName("Ginger");
//
//        mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(person)))
//                .andExpect(status().isCreated())
//                .andDo(print());
//    }

}
