/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Raoul
 */
public class MsgEventPair {
    private String msg;
    private EventHandler<ActionEvent> event;

    public MsgEventPair(String msg, EventHandler<ActionEvent> event) {
        this.msg = msg;
        this.event = event;
    }

    public String getMsg() {
        return msg;
    }
    
    public EventHandler<ActionEvent> getEvent() {
        return event;
    }
}
