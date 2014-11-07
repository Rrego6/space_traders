/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.TradeGood;

/**
 *
 * @author Raoul
 * @version 1.0
 */
public class TradeLabel extends HBox {

    private static final String SELL_BUTTON_LABEL = "Sell!";
    private static final String BUY_BUTTON_LABEL = "Buy!";
    Label quantityLabel;
    int quantity = 0;
    TradeGood good;

    /**
     * makes a trade label
     *
     * @param good the trade good
     * @param quantity the quantity
     * @param isPlayerOwned if player is owned
     */
    public TradeLabel(TradeGood good, int quantity, boolean isPlayerOwned) {
        super();
        this.good = good;
        Label labelName = new Label(good.toString());
        Label costLabel = new Label(Integer.toString(good.getCost()));
        if (isPlayerOwned) {
            quantityLabel = new Label(Integer.toString(quantity));
            Button button = new Button(SELL_BUTTON_LABEL);
            this.getChildren()
                .addAll(labelName, quantityLabel, costLabel, labelName, button);
        } else {
            Button button = new Button(SELL_BUTTON_LABEL);
            this.getChildren().addAll(labelName, costLabel, labelName, button);
        }
    }

    /**
     * sets the quantity
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        if (quantityLabel != null) {
            this.quantity = quantity;
            quantityLabel.setText(Integer.toString(quantity));
        }
    }

    /**
     * gets the quantity
     *
     * @return the quantity
     */
    public int getQuanitity() {
        return quantity;
    }

    /**
     * gets the trade good
     *
     * @return the trade good
     */
    public TradeGood getTradeGood() {
        return good;

    }

}
