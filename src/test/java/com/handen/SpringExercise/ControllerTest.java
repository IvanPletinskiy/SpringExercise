package com.handen.SpringExercise;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {
    @Autowired
    AdvertiserController mAdvertiserController;

    @Autowired
    private TestRestTemplate mRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
        assertThat(mAdvertiserController).isNotNull();
    }

    @Test
    public void getAllTest() {
        assertThat(this.mRestTemplate.getForObject("http://localhost:" + port + "/api/advertiser/getAll",
                String.class)).isNotNull();
    }

    @Test
    public void getAdvertiserTest() {
        assertThat(this.mRestTemplate.getForObject("http://localhost:" + port + "/api/advertiser/get?id=1",
                String.class)).isNotNull();
    }

    @Test void canPerformTransactionTest() {
        assertThat(this.mRestTemplate.getForObject("http://localhost:"+port+"/api/advertiser/checkPerformTransaction?id=2&credits=100",
                String.class)).isNotNull();
    }
}
