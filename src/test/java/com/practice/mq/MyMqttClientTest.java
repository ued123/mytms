package com.practice.mq;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MyMqttClientTest {

    @Test
    void mqttConnTest() {
        String MqttServer1 = "tcp://127.0.0.1:1883";
        String client_id = "mqts";
        String username = "practice";
        String passwd = "qwer1234";
        String topic = "test";

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

    @Test
    void mqttActiveMq() {



    }
   
}