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
 * @version 1.0
 */
public class MsgEventPair {

    private String msg;
    private EventHandler<ActionEvent> event;

    /**
     * makes a message of events
     *
     * @param msg a string message
     * @param event the event
     */
    public MsgEventPair(String msg, EventHandler<ActionEvent> event) {
        this.msg = msg;
        this.event = event;
    }

    /**
     * gets the message
     *
     * @return the message
     */
    public String getMsg() {
        return msg;
    }

    /**
     * gets the event
     *
     * @return the event
     */
    public EventHandler<ActionEvent> getEvent() {
        return event;
    }
}
