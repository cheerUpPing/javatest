package nio.talk_project.entity;

import nio.talk_project.client.TalkClient;

import java.io.IOException;

/**
 * 2017/3/3 10:00.
 * <p>
 * Email: cheerUpPing@163.com
 */
public class ClientMain {


    public static void main(String[] args) throws IOException {

        //TalkClient.buildClient("127.0.0.1",8084,"person_1","person_2");
        TalkClient.buildClient("127.0.0.1",8084,"person_2","person_1");


    }
}
