package marcin.currencyexchange.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ExchangeRateControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnNotFoundWhenNoParameterProvided() throws Exception {
        this.mockMvc.perform(
            MockMvcRequestBuilders.get("/exchange-rate"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    
    @Test
    public void shouldReturnNotFoundWithOnlyOneParameter() throws Exception {
        this.mockMvc.perform(
            MockMvcRequestBuilders.get("/exchange-rate/2021-03-03"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    
    @Test
    public void shouldReturnBadRequestForIncorrectDate() throws Exception {
        this.mockMvc.perform(
            MockMvcRequestBuilders.get("/exchange-rate/xqweqe/USD"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void shouldReturnOkForProperRequest() throws Exception {
        this.mockMvc.perform(
            MockMvcRequestBuilders.get("/exchange-rate/2021-03-03/USD"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("3.7509")));
    }

    
    @Test
    public void shouldReturnBadRequestForFuture() throws Exception {
        this.mockMvc.perform(
            MockMvcRequestBuilders.get("/exchange-rate/2099-03-03/USD"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
