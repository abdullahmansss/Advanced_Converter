package mans.abdullah.abdullah_mansour.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TimeActivity extends AppCompatActivity
{
    EditText time;
    TextView converted_time;
    String current_time;
    double curr = 0;
    Spinner spinner_time,spinner_time2;
    String current_spinner,current_spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        time = findViewById(R.id.edit_time_field);
        converted_time = findViewById(R.id.converted_time);
        spinner_time = findViewById(R.id.time_spinner);
        spinner_time2 = findViewById(R.id.time_spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.time, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner_time.setAdapter(adapter);
        spinner_time2.setAdapter(adapter);

        spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                current_spinner = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_time2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                current_spinner2 = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        time.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                current_time = s.toString().trim();

                Mconversions(current_time);
                Hconversions(current_time);
                Sconversions(current_time);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });
    }

    public void fromMtoH(String s)
    {
            current_time = s.toString().trim();

            if (current_time.length() != 0)
            {
                curr = Double.parseDouble(current_time);
                converted_time.setText(curr / 60 + "");
            } else
            {
                //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
                converted_time.setText("");
                converted_time.setHint("Time in Hours");
            }
    }

    public void fromMtoM(String s)
    {
            current_time = s.toString().trim();

            if (current_time.length() != 0)
            {
                curr = Double.parseDouble(current_time);
                converted_time.setText(curr + "");
            } else
            {
                //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
                converted_time.setText("");
                converted_time.setHint("Time in Hours");
            }
    }

    public void fromMtoS(String s)
    {
            current_time = s.toString().trim();

            if (current_time.length() != 0)
            {
                curr = Double.parseDouble(current_time);
                converted_time.setText(curr * 60 + "");
            } else
            {
                //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
                converted_time.setText("");
                converted_time.setHint("Time in Hours");
            }
    }

    public void Mconversions (String s)
    {
        if (current_spinner.equals("M") && current_spinner2.equals("H"))
        {
            fromMtoH(s);
        } else if (current_spinner.equals("M") && current_spinner2.equals("M"))
        {
            fromMtoM(s);
        } else if (current_spinner.equals("M") && current_spinner2.equals("S"))
        {
            fromMtoS(s);
        } else if (current_spinner.equals("") || current_spinner2.equals(""))
        {
            Toast.makeText(getApplicationContext(), "please select time from spinner", Toast.LENGTH_SHORT).show();
        }
    }

    public void fromHtoH(String s)
    {
        current_time = s.toString().trim();

        if (current_time.length() != 0)
        {
            curr = Double.parseDouble(current_time);
            converted_time.setText(curr + "");
        } else
        {
            //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
            converted_time.setText("");
            converted_time.setHint("Time in Hours");
        }
    }

    public void fromHtoM(String s)
    {
        current_time = s.toString().trim();

        if (current_time.length() != 0)
        {
            curr = Double.parseDouble(current_time);
            converted_time.setText(curr *60 + "");
        } else
        {
            //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
            converted_time.setText("");
            converted_time.setHint("Time in Hours");
        }
    }

    public void fromHtoS(String s)
    {
        current_time = s.toString().trim();

        if (current_time.length() != 0)
        {
            curr = Double.parseDouble(current_time);
            converted_time.setText(curr * 3600 + "");
        } else
        {
            //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
            converted_time.setText("");
            converted_time.setHint("Time in Hours");
        }
    }

    public void Hconversions (String s)
    {
        if (current_spinner.equals("H") && current_spinner2.equals("H"))
        {
            fromHtoH(s);
        } else if (current_spinner.equals("H") && current_spinner2.equals("M"))
        {
            fromHtoM(s);
        } else if (current_spinner.equals("H") && current_spinner2.equals("S"))
        {
            fromHtoS(s);
        } else if (current_spinner.equals("") || current_spinner2.equals(""))
        {
            Toast.makeText(getApplicationContext(), "please select time from spinner", Toast.LENGTH_SHORT).show();
        }
    }

    public void fromStoH(String s)
    {
        current_time = s.toString().trim();

        if (current_time.length() != 0)
        {
            curr = Double.parseDouble(current_time);
            converted_time.setText(curr / 3600 + "");
        } else
        {
            //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
            converted_time.setText("");
            converted_time.setHint("Time in Hours");
        }
    }

    public void fromStoM(String s)
    {
        current_time = s.toString().trim();

        if (current_time.length() != 0)
        {
            curr = Double.parseDouble(current_time);
            converted_time.setText(curr / 60 + "");
        } else
        {
            //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
            converted_time.setText("");
            converted_time.setHint("Time in Hours");
        }
    }

    public void fromStoS(String s)
    {
        current_time = s.toString().trim();

        if (current_time.length() != 0)
        {
            curr = Double.parseDouble(current_time);
            converted_time.setText(curr + "");
        } else
        {
            //Toast.makeText(getApplicationContext(), "please enter a currency", Toast.LENGTH_SHORT).show();
            converted_time.setText("");
            converted_time.setHint("Time in Hours");
        }
    }

    public void Sconversions (String s)
    {
        if (current_spinner.equals("S") && current_spinner2.equals("H"))
        {
            fromStoH(s);
        } else if (current_spinner.equals("S") && current_spinner2.equals("M"))
        {
            fromStoM(s);
        } else if (current_spinner.equals("S") && current_spinner2.equals("S"))
        {
            fromStoS(s);
        } else if (current_spinner.equals("") || current_spinner2.equals(""))
        {
            Toast.makeText(getApplicationContext(), "please select time from spinner", Toast.LENGTH_SHORT).show();
        }
    }
}
