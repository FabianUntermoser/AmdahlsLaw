package ui.websocket;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint(value = "/chart")
@Singleton
public class ChartSocket {

    private Session session;
    private boolean missedUpdate = false;
    private static Logger logger = Logger.getLogger(ChartSocket.class.getName());

    @OnOpen
    public void onOpen(Session session) {
        logger.log(Level.INFO, "onOpen");
        this.session = session;
        if (missedUpdate) {
            logger.log(Level.INFO, "Missed update");
            sendUpdateMessage(session);
            missedUpdate = false;
        }
    }

    @OnClose
    public void OnClose(Session session) {
        logger.log(Level.INFO, "OnClose");
        this.session = null;
    }

    @OnMessage
    public void OnMessage(String message, Session session) {
        logger.log(Level.INFO, "OnMessage");
    }

    public void onChartUpdate(@Observes Boolean updateChart) {
        if (updateChart) {
            if (session == null) {
                missedUpdate = true;
            } else {
                sendUpdateMessage(session);
            }
        }
    }

    private void sendUpdateMessage(Session session) {
        try {
            logger.log(Level.INFO, "Updating Chart");
            session.getBasicRemote().sendText("updateChart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
