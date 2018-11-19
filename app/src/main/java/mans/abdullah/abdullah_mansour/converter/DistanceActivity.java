package mans.abdullah.abdullah_mansour.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class DistanceActivity extends AppCompatActivity
{
    EditText distance;
    TextView converted_distance;
    String current_distance;
    double curr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        distance = findViewById(R.id.edit_distance_field);
        converted_distance = findViewById(R.id.converted_distance);

        distance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                current_distance = s.toString().trim();

                if (current_distance.length() != 0)
                {
                    curr = Double.parseDouble(current_distance);
                    converted_distance.setText(curr / 1000 + "");
                } else
                {
                    //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
                    converted_distance.setText("");
                    converted_distance.setHint("Distance in KM");
                }
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }
}
