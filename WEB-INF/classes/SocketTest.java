import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;


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
        String msg;
        msg = "{hexes: [{x: 0, y: 2, type: 'ocean'},{x: 0, y: 4, type: 'ocean'},{x: 0, y: 6, type: 'ocean'}," +
                "{x: 0, y: 8, type: 'ocean'},{x: 1, y: 1, type: 'ocean'},{x: 1, y: 3, type: 'forest'}," +
                "{x: 1, y: 5, type: 'plain'},{x: 1, y: 7, type: 'plain'},{x: 1, y: 9, type: 'ocean'}," +
                "{x: 2, y: 0, type: 'ocean'},{x: 2, y: 2, type: 'forest'},{x: 2, y: 4, type: 'plain'}," +
                "{x: 2, y: 6, type: 'mountain'},{x: 2, y: 8, type: 'valley'},{x: 2, y: 10, type: 'ocean'}," +
                "{x: 3, y: -1, type: 'ocean'},{x: 3, y: 1, type: 'hill'},{x: 3, y: 3, type: 'mountain'}," +
                "{x: 3, y: 5, type: 'valley'},{x: 3, y: 7, type: 'dessert'},{x: 3, y: 9, type: 'forest'}," +
                "{x: 3, y: 11, type: 'ocean'},{x: 4, y: 0, type: 'ocean'},{x: 4, y: 2, type: 'valley'}," +
                "{x: 4, y: 4, type: 'hill'},{x: 4, y: 6, type: 'forest'},{x: 4, y: 8, type: 'valley'}," +
                "{x: 4, y: 10, type: 'ocean'},{x: 5, y: 1, type: 'ocean'},{x: 5, y: 3, type: 'hill'}," +
                "{x: 5, y: 5, type: 'plain'},{x: 5, y: 7, type: 'mountain'},{x: 5, y: 9, type: 'ocean'}," +
                "{x: 6, y: 2, type: 'ocean'},{x: 6, y: 4, type: 'ocean'},{x: 6, y: 6, type: 'ocean'}," +
                "{x: 6, y: 8, type: 'ocean'}],villages: [{x: 3,y: 3,color: 'red'}, {x: 5,y: 4,color: 'orange'}]," +
                "roads: [{x: 3,y: 3,color: 'red'}, {x: 5,y: 4,color: 'orange'}]}";
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
                CharBuffer buffer = CharBuffer.wrap(message);
                connection.getWsOutbound().writeTextMessage(buffer);
            } catch (IOException ignore) {}
        }
    }


}