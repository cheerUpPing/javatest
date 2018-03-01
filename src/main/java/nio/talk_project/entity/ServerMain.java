package nio.talk_project.entity;

import nio.talk_project.server.TalkServer;

import java.io.IOException;

/**
 * 2017/3/3 10:00.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class ServerMain {


    public static void main(String[] args) throws IOException {

        TalkServer.buildServer(8084);

    }
}
