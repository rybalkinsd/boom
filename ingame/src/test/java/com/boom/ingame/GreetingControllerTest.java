package com.boom.ingame;

import com.boom.ingame.message.Move;
import com.boom.ingame.util.JsonHelper;
import com.boom.ingame.util.V;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;


/**
 * Created by Sergey Rybalkin on 06/02/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT, classes = Game.class, properties = "server.port=8080")
public class GreetingControllerTest {
    private static final String TOPIC = "/app/move";
    private static final String SOCKET_URL = "ws://localhost:8080/gs-guide-websocket";
    private WebSocketStompClient stompClient;

//    @Autowired
//    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        stompClient = new WebSocketStompClient(new SockJsClient(
                singletonList(new WebSocketTransport(new StandardWebSocketClient())))
        );
        //tompClient.setMessageConverter(new StringMessageConverter());
    }




    @Test
    public void shouldReceiveAMessageFromTheServer() throws Exception {
        StompSession session = stompClient
                .connect(SOCKET_URL, new StompSessionHandlerAdapter() {})
                .get(10, TimeUnit.SECONDS);

        Move move = new Move(V.of(100, 500));

        class DefaultStompFrameHandler implements StompFrameHandler {
            @Override
            public Type getPayloadType(StompHeaders stompHeaders) {
                return byte[].class;
            }

            @Override
            public void handleFrame(StompHeaders stompHeaders, Object o) {
                assertThat(o).isInstanceOf( byte[].class);
//                assertThat(o).isEqualTo(move);
            }
        }

        session.subscribe("/topic/greetings", new DefaultStompFrameHandler());
        session.send(TOPIC, JsonHelper.toJson(move).getBytes());
    }

}