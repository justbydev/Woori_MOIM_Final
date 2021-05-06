package com.woori.moim.FCM;

import com.google.gson.annotations.SerializedName;
import com.woori.moim.FCM.NotificationModel;

public class Model {
    @SerializedName("to") //  "to" changed to token
    private String token;

    @SerializedName("data")
    private NotificationModel notification;

    public Model(String token, NotificationModel notification) {
        this.token = token;
        this.notification = notification;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public NotificationModel getNotification() {
        return notification;
    }

    public void setNotification(NotificationModel notification) {
        this.notification = notification;
    }

}