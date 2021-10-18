package com.example.stpms21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] cars = {"", "Mercedes-Benz S63", "Audi S8", "BMW 7", "Ford Mustang"};
    String[] bundles = {"", "500", "600", "700", "800"};

    private Spinner car;
    private Spinner bundle;
    private EditText name;
    private EditText startDate;
    private EditText orderDays;
    private TextView calcOrder;
    private TextView order;
    private TextView cost;
    private TextView carBundle;
    private TextView nameOrder;
    private TextView dateDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Spinner carsSpinner = (Spinner) findViewById(R.id.carsSpinner);
//        ArrayAdapter<String> adapterCars = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cars);
//        adapterCars.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        carsSpinner.setAdapter(adapterCars);
//
//        Spinner bundleSpinner = (Spinner) findViewById(R.id.bundleSpinner);
//        ArrayAdapter<String> adapterBundle = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bundles);
//        adapterBundle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        bundleSpinner.setAdapter(adapterBundle);
    }

//    public void costOrder(View view) {
//        bundle = (Spinner)findViewById(R.id.bundleSpinner);
//        orderDays = (EditText)findViewById(R.id.orderDaysInput);
//        calcOrder = (TextView)findViewById(R.id.calcCostText);
//        cost = (TextView)findViewById(R.id.costText);
//        order = (TextView)findViewById(R.id.orderView);
//        carBundle = (TextView)findViewById(R.id.carOrder);
//        nameOrder = (TextView)findViewById(R.id.nameOrder);
//        dateDays = (TextView)findViewById(R.id.dateOrder);
//
//        try {
//            int orderSum = Integer.parseInt(bundle.getSelectedItem().toString()) * Integer.parseInt(orderDays.getText().toString());
//            order.setText("ORDER");
//            carBundle.setText("");
//            nameOrder.setText("");
//            dateDays.setText("");
//
//            calcOrder.setText("Example cost");
//            cost.setText(orderSum + "$");
//        } catch (Exception e) {
//            alertFillCost();
//        }
//    }
//
//    public void orderButton(View view) {
//        car = (Spinner)findViewById(R.id.carsSpinner);
//        bundle = (Spinner)findViewById(R.id.bundleSpinner);
//        name = (EditText)findViewById(R.id.nameInput);
//        startDate = (EditText)findViewById(R.id.startDateInput);
//        orderDays = (EditText)findViewById(R.id.orderDaysInput);
//        order = (TextView)findViewById(R.id.orderView);
//        carBundle = (TextView)findViewById(R.id.carOrder);
//        nameOrder = (TextView)findViewById(R.id.nameOrder);
//        dateDays = (TextView)findViewById(R.id.dateOrder);
//        calcOrder = (TextView)findViewById(R.id.calcCostText);
//        cost = (TextView)findViewById(R.id.costText);
//
//        try {
//            calcOrder.setText("");
//            cost.setText("");
//
//            int orderSum = Integer.parseInt(bundle.getSelectedItem().toString()) * Integer.parseInt(orderDays.getText().toString());
//            carBundle.setText("Car / Bundle: " + car.getSelectedItem().toString() + " / " + bundle.getSelectedItem().toString() + "$");
//            nameOrder.setText("Name: " + name.getText().toString());
//            dateDays.setText("Date / days: " + startDate.getText().toString() + " / " + orderDays.getText().toString());
//            order.setText("ORDER - " + orderSum + "$");
//        } catch (Exception e) {
//            alertFill();
//        }
//    }
//
//
//    public void alertFillCost() {
//        AlertDialog.Builder b = new AlertDialog.Builder(this);
//        b.setTitle("Fill bundle and order days").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        AlertDialog ad = b.create();
//        ad.show();
//    }
//
//    public void alertFill() {
//        AlertDialog.Builder b = new AlertDialog.Builder(this);
//        b.setTitle("Fill all required fields").setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        AlertDialog ad = b.create();
//        ad.show();
//    }
}