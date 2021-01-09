//package bank;
//import bank.models.Client;
//import bank.services.ClientService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class LoadDatabase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(ClientService clientService) {
//
//        return args -> {
//            log.info("Preloading " + clientService.save(new Client("Bilbo Baggins", "burglar@test.com.br", "12712005031", "23/04/1997")));
//            log.info("Preloading " + clientService.save(new Client("Pietr", "burglar@test.com.br", "95319485000", "23/04/2002")));
//        };
//    }
//}