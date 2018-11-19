package mans.abdullah.abdullah_mansour.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class SpeedActivity extends AppCompatActivity
{
    EditText speed;
    TextView converted_speed;
    String current_speed;
    double curr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        speed = findViewById(R.id.edit_speed_field);
        converted_speed = findViewById(R.id.converted_speed);

        speed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                current_speed = s.toString().trim();

                if (current_speed.length() != 0)
                {
                    curr = Double.parseDouble(current_speed);
                    converted_speed.setText(curr * 3.6 + "");
                } else
                {
                    //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
                    converted_speed.setText("");
                    converted_speed.setHint("Speed in KM/H");
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
}
