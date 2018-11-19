package mans.abdullah.abdullah_mansour.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CurrencyActivity extends AppCompatActivity
{
    EditText currency;
    TextView converted_currency;
    String current_currency;
    double curr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        currency = findViewById(R.id.edit_currency_field);
        converted_currency = findViewById(R.id.converted_currency);

        currency.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                current_currency = s.toString().trim();

                if (current_currency.length() != 0)
                {
                    curr = Double.parseDouble(current_currency);
                    converted_currency.setText(curr * 17.91 + "");
                } else
                    {
                        //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
                        converted_currency.setText("");
                        converted_currency.setHint("Currency in USD");
                    }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
}
