import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

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
    @Override
    protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {

    }

    @Override
    protected void onTextMessage(CharBuffer charBuffer) throws IOException {

    }

    private void broadcast(String message) {

    }
}