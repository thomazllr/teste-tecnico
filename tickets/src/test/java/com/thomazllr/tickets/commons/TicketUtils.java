package com.thomazllr.tickets.commons;

import com.thomazllr.tickets.model.Client;
import com.thomazllr.tickets.model.Module;
import com.thomazllr.tickets.model.Ticket;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketUtils {

    public List<Client> createClients() {
        var client1 = Client.builder().id(1L).name("Client A").build();
        var client2 = Client.builder().id(2L).name("Client B").build();
        var client3 = Client.builder().id(3L).name("Client C").build();
        return new ArrayList<>(List.of(client1, client2, client3));
    }

    public Client createClient() {
        return Client.builder().id(1L).name("Client A").build();
    }

    public List<Module> createModules() {
        var module1 = Module.builder().id(1L).name("Module X").build();
        var module2 = Module.builder().id(2L).name("Module Y").build();
        var module3 = Module.builder().id(3L).name("Module Z").build();
        return new ArrayList<>(List.of(module1, module2, module3));
    }

    public Module createModule() {
        return Module.builder().id(1L).name("Module X").build();
    }

    public Ticket createTicket() {
        Client client = createClient();
        Module module = createModule();
        return Ticket.builder()
                .id(1L)
                .title("Sample Ticket")
                .client(client)
                .module(module)
                .openingDate(LocalDate.now())
                .build();
    }

    public List<Ticket> createTickets() {
        List<Client> clients = createClients();
        List<Module> modules = createModules();

        Ticket ticket1 = Ticket.builder()
                .id(1L)
                .title("Ticket 1")
                .client(clients.get(0))
                .module(modules.get(0))
                .openingDate(LocalDate.now())
                .build();

        Ticket ticket2 = Ticket.builder()
                .id(2L)
                .title("Ticket 2")
                .client(clients.get(1))
                .module(modules.get(1))
                .openingDate(LocalDate.now())
                .build();

        return new ArrayList<>(List.of(ticket1, ticket2));
    }
}
