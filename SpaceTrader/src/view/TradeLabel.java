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
 */
public class TradeLabel extends HBox {
    private static final String SELL_BUTTON_LABEL = "Sell!";
    private static final String BUY_BUTTON_LABEL  = "Buy!";
    public Label quantityLabel;
    public int quantity = 0;
    TradeGood good;
    
    public TradeLabel(TradeGood good, int quantity, boolean isPlayerOwned ){
        super();
        this.good = good;
        Label labelName = new Label(good.toString());
        Label costLabel = new Label(Integer.toString(good.getCost()));
        if( isPlayerOwned ) {
            quantityLabel = new Label(Integer.toString(quantity));
            Button button = new Button( SELL_BUTTON_LABEL );
            this.getChildren().addAll( labelName, quantityLabel, costLabel, labelName, button);
        } else {
            Button button = new Button( SELL_BUTTON_LABEL );
            this.getChildren().addAll( labelName, costLabel, labelName, button );
        }
    }
    
    public void setQuantity(int quantity) {
        if( quantityLabel != null ) {
            this.quantity = quantity;
            quantityLabel.setText( Integer.toString( quantity ) );
        }
    }

    public int getQuanitity() {
        return quantity;
    }
    
    public TradeGood getTradeGood() {
        return good;
        
    }
    
}
