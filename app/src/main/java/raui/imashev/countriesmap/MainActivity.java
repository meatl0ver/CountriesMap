package raui.imashev.countriesmap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCountryShow;
    private EditText editTextInputCountry;
    private EditText editTextInputCapital;
    private TextView texViewCapital;
    private TextView textViewCountriesList;
    private Map<String, String> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextCountryShow = findViewById(R.id.editTextCountryShow);
        editTextInputCountry = findViewById(R.id.editTextInputCountry);
        editTextInputCapital = findViewById(R.id.editTextInputCapital);
        texViewCapital = findViewById(R.id.textViewCapital);
        textViewCountriesList = findViewById(R.id.textViewCountiesList);

        countries = new TreeMap<>();

        editTextCountryShow.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String capital = countries.get(s.toString());
                if (capital != null) {
                    texViewCapital.setText(capital);
                } else {
                    texViewCapital.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void onCliclAddtoMap(View view) {
        String country = editTextInputCountry.getText().toString().trim();
        String capital = editTextInputCapital.getText().toString().trim();
        countries.put(country,capital);
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : countries.keySet()) {
            stringBuilder.append(key).append(" - ").append(countries.get(key)).append("\n");
        }
        textViewCountriesList.setText(stringBuilder);
        editTextInputCountry.setText("");
        editTextInputCapital.setText("");
    }
}