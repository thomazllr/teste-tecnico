# Teste II - Client de API (Forkfiy API) ‍👨‍🍳

---

Esse desafio consistia em consumir uma API de receitas. Passando um parâmetro de buscar e retornando o resultado para o client.

Link do Swagger: https://forkfiy-client.onrender.com/

---

## Objetivos 📋:

1 - Consumir a API (https://forkify-api.herokuapp.com/).

2 - Retornar os dados obtidos.

---

## Tecnologias ⚙️:

- **Linguagem**: Java 21
- **Framework**: Spring Boot
- **Testes**: JUnit, Mockito, REST Assured
- **Documentação**: SwaggerUI
- **Extras**: Lombok

--- 

## Proposta de resolução:

O que eu fiz foi criar uma classe para ler as propriedades do arquivo de configuração(application.yml) 
e assim eu poderia ter mais liberdade e dinamismo na hora de consultar essa API

```java
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "forkify-api")
public class ForkifyApiConfigurationProperties {
    private String url;
}

```

Agora bastava eu passar a URL no application.yml e assim eu conseguiria obter essa propriedade para montar meu Rest Client:

```yml
spring:
  application:
    name: forkify-client
forkify-api:
  url: https://forkify-api.herokuapp.com/api
server:
  port: 8081
```

Com a classe RestClientConfiguration, eu já tinha tudo o que era necessário para montar a classe responsável para fazer chamadas nessa API:

```java

@Configuration
public class RestClientConfiguration {

    @Bean("forkifyApiClient")
    public RestClient forkifyApiClient(RestClient.Builder builder,
                                       ForkifyApiConfigurationProperties properties) {
        return builder
                .baseUrl(properties.getUrl())
                .build();
    }
}
```

Bastava então que agora eu passasse o path da requisição com o método correto(get) e o parâmetro necessário (q).

```java

@Service
@RequiredArgsConstructor
public class ForkifyApiService {

    private final RestClient forkifyApiClient;

    public ForkifySearchResponse search(String query) {
        try {
            return forkifyApiClient.get()
                    .uri(uri -> uri.path("/search").queryParam("q", query).build())
                    .retrieve()
                    .body(ForkifySearchResponse.class);
        } catch (RestClientResponseException e) {
            throw new ForkifySearchException(query);
        }
    }


}

```

Meu controller final: 

```java

@RestController
@RequestMapping("/v1/forkify")
@RequiredArgsConstructor
public class ForkifyApiController implements ForkifyApiControllerDocs {

    private final ForkifyApiService forkifyApiService;

    @GetMapping
    public ResponseEntity<ForkifySearchResponse> search(@RequestParam String query) {
        var response = forkifyApiService.search(query);
        return ResponseEntity.ok(response);
    }
}


```

GET localhost:8081/v1/forkify?query=pizza

Resposta:

```json
{
  "count": 28,
  "recipes": [
    {
      "publisher": "101 Cookbooks",
      "title": "Best Pizza Dough Ever",
      "source_url": "http://www.101cookbooks.com/archives/001199.html",
      "recipe_id": "47746",
      "image_url": "http://forkify-api.herokuapp.com/images/best_pizza_dough_recipe1b20.jpg",
      "social_rank": 100.0,
      "publisher_url": "http://www.101cookbooks.com"
    },
    {
      "publisher": "The Pioneer Woman",
      "title": "Deep Dish Fruit Pizza",
      "source_url": "http://thepioneerwoman.com/cooking/2012/01/fruit-pizza/",
      "recipe_id": "46956",
      "image_url": "http://forkify-api.herokuapp.com/images/fruitpizza9a19.jpg",
      "social_rank": 100.0,
      "publisher_url": "http://thepioneerwoman.com"
    },
    {
      "publisher": "Closet Cooking",
      "title": "Pizza Dip",
      "source_url": "http://www.closetcooking.com/2011/03/pizza-dip.html",
      "recipe_id": "35477",
      "image_url": "http://forkify-api.herokuapp.com/images/Pizza2BDip2B12B500c4c0a26c.jpg",
      "social_rank": 99.99999999999994,
      "publisher_url": "http://closetcooking.com"
    },
    {
      "publisher": "Closet Cooking",
      "title": "Cauliflower Pizza Crust (with BBQ Chicken Pizza)",
      "source_url": "http://www.closetcooking.com/2013/02/cauliflower-pizza-crust-with-bbq.html",
      "recipe_id": "41470",
      "image_url": "http://forkify-api.herokuapp.com/images/BBQChickenPizzawithCauliflowerCrust5004699695624ce.jpg",
      "social_rank": 99.9999999999994,
      "publisher_url": "http://closetcooking.com"
    },
    {
      "publisher": "Closet Cooking",
      "title": "Pizza Quesadillas (aka Pizzadillas)",
      "source_url": "http://www.closetcooking.com/2012/11/pizza-quesadillas-aka-pizzadillas.html",
      "recipe_id": "35478",
      "image_url": "http://forkify-api.herokuapp.com/images/Pizza2BQuesadillas2B2528aka2BPizzadillas25292B5002B834037bf306b.jpg",
      "social_rank": 99.99999999999835,
      "publisher_url": "http://closetcooking.com"
    },
    {
      "publisher": "Two Peas and Their Pod",
      "title": "Sweet Potato Kale Pizza with Rosemary & Red Onion",
      "source_url": "http://www.twopeasandtheirpod.com/sweet-potato-kale-pizza-with-rosemary-red-onion/",
      "recipe_id": "54454",
      "image_url": "http://forkify-api.herokuapp.com/images/sweetpotatokalepizza2c6db.jpg",
      "social_rank": 99.9999999991673,
      "publisher_url": "http://www.twopeasandtheirpod.com"
    },
    ...
  ]
}
```

### Implementação de Testes Automatizados

Aqui eu decidi fazer um Test Slice, que é um teste unitário com escopo do Spring limitado.

#### Test Slice

Como nos testes unitários eu preciso ter total controle dos dados mockados, então criei uma classe utilitária para eu
utilizar com auxiliador:

```java

@WebMvcTest(controllers = ForkifyApiController.class)
@Import(FileUtils.class)
class ForkifyApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ForkifyApiService forkifyApiService;

    @Autowired
    private ObjectMapper objectMapper;

    private ForkifySearchResponse response;

    @Autowired
    private FileUtils fileUtils;

    @BeforeEach
    void setUp() {
        response = new ForkifySearchResponse();
    }

    @Test
    @DisplayName("GET /v1/forkify?query=pizza returns ForkifySearchResponse when successful")
    void search_ReturnsForkifySearchResponse_WhenSuccessful() throws Exception {
        var query = "pizza";
        var expectedJson = fileUtils.readResourceFile("forkify/get-recipes-by-query-response-200.json");

        response = objectMapper.readValue(expectedJson, ForkifySearchResponse.class);

        BDDMockito.given(forkifyApiService.search(query)).willReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/forkify")
                        .param("query", query)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJson));
    }

    @Test
    @DisplayName("GET /v1/forkify without query param returns 400 Bad Request")
    void search_ReturnsBadRequest_WhenQueryParamMissing() throws Exception {

        var query = "null";

        BDDMockito.given(forkifyApiService.search(query)).willReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/v1/forkify")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
```

## Desenvolvedor

[Guilherme Thomaz](https://www.linkedin.com/in/thomazllr/)


