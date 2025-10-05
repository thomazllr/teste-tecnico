package com.thomazllr.tickets.commons;

import com.thomazllr.tickets.model.Client;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientUtils {

    public Client createClient() {
        return Client.builder()
                .id(1L)
                .name("Client A")
                .build();
    }

    public List<Client> createClients() {
        var client1 = Client.builder().id(1L).name("Client A").build();
        var client2 = Client.builder().id(2L).name("Client B").build();
        var client3 = Client.builder().id(3L).name("Client C").build();
        return new ArrayList<>(List.of(client1, client2, client3));
    }
}