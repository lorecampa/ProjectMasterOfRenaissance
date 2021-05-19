package it.polimi.ingsw;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.polimi.ingsw.client.Client;
import it.polimi.ingsw.client.PrintAssistant;
import it.polimi.ingsw.client.data.ResourceData;
import it.polimi.ingsw.exception.JsonFileModificationError;
import it.polimi.ingsw.message.bothArchitectureMessage.ConnectionMessage;
import it.polimi.ingsw.message.bothArchitectureMessage.ConnectionType;
import it.polimi.ingsw.message.clientMessage.ClientMessage;
import it.polimi.ingsw.message.clientMessage.ErrorMessage;
import it.polimi.ingsw.message.clientMessage.ErrorType;
import it.polimi.ingsw.message.serverMessage.*;
import it.polimi.ingsw.model.GameSetting;
import it.polimi.ingsw.model.card.Development;
import it.polimi.ingsw.model.card.Leader;
import it.polimi.ingsw.model.resource.ResourceType;
import it.polimi.ingsw.server.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.IOException;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MastersOfRenaissanceTest
{

    private GameSetting gs;
    private GameSetting gsSinglePlayer;
    @BeforeEach
    void init(){
        assertDoesNotThrow(()-> gs = new GameSetting(4));
        assertDoesNotThrow(()-> gsSinglePlayer = new GameSetting(1));

    }
    @Test
    public void CardPrintTest() throws IOException, JsonFileModificationError {

        LinkedList<Leader> deckLeader = gs.getDeckLeader();
        deckLeader.forEach(System.out::println);

        assertEquals(16, deckLeader.size());

        ArrayList<ArrayList<ArrayList<Development>>> deckDevelopment = gs.getDeckDevelopment();
        deckDevelopment.forEach(System.out::println);


        assertEquals(3, deckDevelopment.size());
        assertEquals(4, deckDevelopment.get(0).size());
        assertEquals(4, deckDevelopment.get(0).get(0).size());



    }
    ObjectMapper mapper;

    @Test
    void test() throws JsonProcessingException {
        mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        /*
        ServerMessage message1 = new ConnectionMessage(ConnectionType.CONNECT,"a");
        String serverSer = mapper.writeValueAsString(message1);
        System.out.println(serverSer);

        ResourceData resource1 = new ResourceData(ResourceType.COIN, 2);
        ServerMessage message2 = new StrongboxModify(resource1);
        String message22 = mapper.writeValueAsString(message2);
        System.out.println(message22);
         */







    }


    @Test
    void gameStartForSetUpServer(){
        Map<Integer, String> points= new HashMap<>();
        points.put(16, "Lorenzo");
        points.put(17, "Teo");
        points.put(2000, "bbbb");
        points.put(1, "aaaaa");


        //TreeMap<Integer, String> test= new TreeMap<>(points);

        TreeMap<Integer, String> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
        reverseSortedMap.putAll(points);


        Set<Map.Entry<Integer, String>> entries = reverseSortedMap.entrySet();
        for(Map.Entry<Integer, String> entry : entries){
            PrintAssistant.instance.printf(entry.getKey()+": "+entry.getValue());
        }

    }


}
