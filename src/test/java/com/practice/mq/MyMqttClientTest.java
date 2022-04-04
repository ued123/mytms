package com.practice.mq;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MyMqttClientTest {

    @Test
    @Disabled
    void mqttConnTest() {
        String MqttServer1 = "tcp://172.16.120.229:1883";
        String client_id = "mqttclienttest323";
        String username = "icent";
        String passwd = "dkdltpsxm";
        String topic = "map";

        MyMqttClient ReadFromOtherMQTT = new MyMqttClient(MqttServer1, client_id, username, passwd);
        ReadFromOtherMQTT.init(topic);

        sleep(1000);

        ReadFromOtherMQTT.subscribe(0);

        sleep(1000);

    }

    static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
}