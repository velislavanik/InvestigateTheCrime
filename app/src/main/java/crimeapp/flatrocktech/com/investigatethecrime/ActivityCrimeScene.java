package crimeapp.flatrocktech.com.investigatethecrime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActivityCrimeScene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button mBtnSolveTheMistery;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_scene);

        mBtnSolveTheMistery = findViewById(R.id.btn_solve_the_mistery);

        View.OnClickListener buttonListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                navigate();
            }
        };
        mBtnSolveTheMistery.setOnClickListener(buttonListener);
    }

    private void navigate() {
        ActivitySelectSuspect.newInstance(this);
    }
}
