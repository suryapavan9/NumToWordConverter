package com.example.suryapavan.numtowordconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String output = numToWord(Integer.parseInt(editText.getText().toString()));
                textView.setText(output);
            }
        });
    }
    public static String numToWord(Integer i) {

        final  String[] units = { "Zero", "One", "Two", "Three",
                "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                "Seventeen", "Eighteen", "Nineteen" };
        final  String[] tens = { "", "", "Twenty", "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        if(i < 0)
            return "Minus " + numToWord(-1 * i);

        if (i < 20)
            return units[i];

        if (i < 100)
            return tens[i / 10] + ((i % 10 > 0) ? " " + numToWord(i % 10) : "");

        if (i < 1000)
            return units[i / 100] + " Hundred"
                    + ((i % 100 > 0) ? " and " + numToWord(i % 100) : "");

        if (i < 1000000)
            return numToWord(i / 1000) + " Thousand "
                    + ((i % 1000 > 0) ? " " + numToWord(i % 1000) : "");
        return numToWord(i / 1000000) + " Million "
                + ((i % 1000000 > 0) ? " " + numToWord(i % 1000000) : "");
    }
}
