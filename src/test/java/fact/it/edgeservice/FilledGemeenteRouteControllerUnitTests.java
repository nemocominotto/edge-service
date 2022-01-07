//package fact.it.edgeservice;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import fact.it.edgeservice.model.CyclingRoute;
//import fact.it.edgeservice.model.Gemeente;
//import fact.it.edgeservice.model.Review;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.client.ExpectedCount;
//import org.springframework.test.web.client.MockRestServiceServer;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.client.RestTemplate;
//
//import java.net.URI;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
//import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class FilledGemeenteRouteControllerUnitTests {
//
//    @Value("${gemeenteservice.baseurl}")
//    private String gemeenteServiceBaseUrl;
//
//    @Value("${routeservice.baseurl}")
//    private String routeServiceBaseUrl;
//
//    @Value("${reviewservice.baseurl}")
//    private String reviewServiceBaseUrl;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    private MockRestServiceServer mockServer;
//    private ObjectMapper mapper = new ObjectMapper();
//
//    //TEST DATA GEMEENTE
//    private Gemeente gemeente1 = new Gemeente("Tessenderlo", "3980");
//    private Gemeente gemeente2 = new Gemeente("Ham", "3945");
//    private Gemeente gemeente3 = new Gemeente("Paal", "3583");
//    private List<Gemeente> allGemeentes = Arrays.asList(gemeente1, gemeente2, gemeente3);
//
//    //TEST DATA REVIEWS
//    private Review reviewroute1 = new Review("Nemo Cominotto", "Leopoldsburg - hasselt", "een goede rit", "123");
//    private Review reviewroute2 = new Review("Luca Cominotto", "Heppen - Leopodsburg centrum", "een goede rit maar ver", "123");
//    private Review reviewroute3 = new Review("Julian Koppens", "Hasselt", "Fijne rit", "456");
//    private List<Review> allReviews = Arrays.asList(reviewroute1, reviewroute2, reviewroute3);
//
//    //TEST DATA CYCLINGROUTE
//    private CyclingRoute cyclingRoute1 = new CyclingRoute("drieprovincieroute",
//            "url1",
//            "123", "3945");
//    private CyclingRoute cyclingRoute2 = new CyclingRoute("Fietsen door de bomen",
//            "url2",
//            "456", "3980");
//    private CyclingRoute cyclingRoute3 = new CyclingRoute("Fietsen door de bomen",
//            "url2",
//            "456", "3980");
//    private List<CyclingRoute> allCyclingRoutes = Arrays.asList(cyclingRoute1, cyclingRoute2, cyclingRoute3);
//
//
//    @BeforeEach
//    public void initializeMockserver() {
//        mockServer = MockRestServiceServer.createServer(restTemplate);
//    }
//
//    @Test
//    public void GetAllGemeentes() throws Exception {
//        mockServer.expect(ExpectedCount.once(), requestTo(new URI("http://" + gemeenteServiceBaseUrl + "/gemeentes")))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .body(mapper.writeValueAsString(allGemeentes)));
//
//        mockMvc.perform(get("/gemeentes"))
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(3)))
//
//                .andExpect(jsonPath("$[0].naam",is("Tessenderlo")))
//                .andExpect(jsonPath("$[0].postcode",is("3980")))
//
//                .andExpect(jsonPath("$[1].naam",is("Ham")))
//                .andExpect(jsonPath("$[1].postcode",is("3945")))
//
//               .andExpect(jsonPath("$[1].naam",is("Paal")))
//                .andExpect(jsonPath("$[1].postcode",is("3583")));
//    }
//
//
//
//}
