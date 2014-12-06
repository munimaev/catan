import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * Created by Viktor on 05.12.2014.
 */
public class SocketTest extends WebSocketServlet {
    @Override
    protected StreamInbound createWebSocketInbound(String s, HttpServletRequest httpServletRequest) {
        return new SocketInbound();
    }
}

class SocketInbound extends MessageInbound {
    private static final ArrayList<SocketInbound> connections = new ArrayList<SocketInbound>();
    private WsOutbound connection;

    @Override
    protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {

    }

    @Override
    protected void onTextMessage(CharBuffer message) throws IOException {
        String msg = message.toString();
        msg = "(" + System.currentTimeMillis() + ") "+ msg;
        broadcast(msg);
    }

    @Override
    protected void onOpen(WsOutbound outbound) {
        this.connection = outbound;
        connections.add(this);
    }

    private void broadcast(String message) {
        for (SocketInbound connection : connections) {
            try {
                CharBuffer buffer = CharBuffer.wrap(message + "; connections count: " + connections.size() + ";");
                connection.getWsOutbound().writeTextMessage(buffer);
            } catch (IOException ignore) {}
        }
    }


}