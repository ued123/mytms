package com.practice.mq;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyMqttClient implements MqttCallback{

    @Value("${mqtt.domain}")
    private static String Broker;

    @Value("${mqtt.clientId}")
    private static String Client_ID;

    @Value("${mqtt.username}")
    private static String UserName;

    @Value("${mqtt.password}")
    private static String Passwd;

    private static MqttAsyncClient Client;
    private static MqttMessage message;
    private static MemoryPersistence persistence;
    private static MqttConnectOptions connOpts;
    private static String topic;

    public MyMqttClient() {}

    public MyMqttClient(String MqttServerIp, String client_id,String username, String passwd){
        this.Broker = MqttServerIp;
        this.Client_ID = client_id;
        this.UserName = username;
        this.Passwd = passwd;
    }

    public void init(String topic){
        this.topic = topic;
        this.persistence = new MemoryPersistence();
        try {
            Client = new MqttAsyncClient(this.Broker, this.Client_ID, this.persistence);
            Client.setCallback(this);

            connOpts = new MqttConnectOptions();
            connOpts.setUserName(this.UserName);
            connOpts.setPassword(this.Passwd.toCharArray());
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+this.Broker);

            Client.connect(connOpts);

            System.out.println("Connected");

            message = new MqttMessage();
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            Client.disconnect();
            Client.close();
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void publish(String msg, int qos){
        message.setQos(qos);
        message.setPayload(msg.getBytes());

        try {
            Client.publish(topic, message);
        } catch (MqttPersistenceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void subscribe(int qos){
        try {
            Client.subscribe(topic,qos);
        } catch (MqttException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getTopic(){
        return topic;
    }

    /*
        broker로 부터 받은 메시지 찍는 로그
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message arrived : " + new String(mqttMessage.getPayload(), "UTF-8"));
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Lost Connection." + cause.getCause());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("Message with " + iMqttDeliveryToken + " delivered.");
    }


}
