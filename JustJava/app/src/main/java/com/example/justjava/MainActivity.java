package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method increments the number of coffee by 1.---------------------------------------
     */
    public void increment(View view) {
        if(quantity+1 <= 100)
            quantity = quantity + 1;
        else
            Toast.makeText(this, "Can't order more than 100 cups", Toast.LENGTH_SHORT).show();

        displayQuantity(quantity);
    }


    /**
     * This method decrements the number of coffee by 1.
     */
    public void decrement(View view) {
        if(quantity-1 >= 1)
            quantity = quantity - 1;
        else
            Toast.makeText(this, "Can't order less than 1 cup", Toast.LENGTH_SHORT).show();
        displayQuantity(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }


    /**
     * This method is called when the order button is clicked.---------------------------------
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCb = (CheckBox) findViewById(R.id.Whipped_cream_cb);
        CheckBox chocolateCb = (CheckBox) findViewById(R.id.Chocolate_cb);

        String summary = createOrderSummary(whippedCreamCb.isChecked(), chocolateCb.isChecked());

        int price = calcPrice(whippedCreamCb.isChecked(), chocolateCb.isChecked());
        String priceMessage = "Total: " + NumberFormat.getCurrencyInstance(new Locale("hi", "IN")).format(price) + "\nThank You!";
        summary += priceMessage;

        displayMessage(summary);

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+getName());
//        intent.putExtra(Intent.EXTRA_TEXT, summary);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
    }


    /**
     * This method displays the given text on the screen
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * CALCULATE PRICE
     */
    private int calcPrice(boolean a, boolean b) {
        int price = 25;
        if(a)
            price += 5;
        if(b)
            price += 10;

        return price*quantity;
    }


    /**
     * Creates a summary of the order
     * @return String summary
     */
    private String createOrderSummary(boolean hasWhippedCream, boolean hasChocolate) {

        String summary = "Name: "+getName()+"\nQuantity "+quantity;
        summary += "\nAdd Whipped Cream: "+hasWhippedCream+"\nAdd Chocolate: "+hasChocolate+"\n";

        return summary;
    }


    /**
     * Gets the user's name
     */
    private String getName() {
        EditText name = (EditText) findViewById(R.id.name_text_input);
        return name.getText().toString();
    }
}













