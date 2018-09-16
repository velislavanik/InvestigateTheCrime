package crimeapp.flatrocktech.com.investigatethecrime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySelectSuspect extends AppCompatActivity {

    private TextView mTextSuspectName;
    private Button mBtnSuspect1, mBtnSuspect2, mBtnSuspect3, mBtnSuspect4;
    private Button mBtnSolveCase;
    private View.OnClickListener mListenerSuspectSelected = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v instanceof TextView) {
                setTextSuspectName(((Button) v).getText().toString());
            }
        }
    };

    public static void newInstance(Context context) {
        Intent intent = new Intent(context, ActivitySelectSuspect.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_suspect);
        initViews();
        setListeners();

        View.OnClickListener btnSolveTheCaseListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView suspectName = findViewById(R.id.text1);
                solveTheCase(suspectName.getText().toString());
            }
        };
        mBtnSolveCase.setOnClickListener(btnSolveTheCaseListener);
    }

    private void initViews() {
        mBtnSuspect1 = findViewById(R.id.btn_1);
        mBtnSuspect2 = findViewById(R.id.btn_2);
        mBtnSuspect3 = findViewById(R.id.btn_3);
        mBtnSuspect4 = findViewById(R.id.btn_4);
        mTextSuspectName = findViewById(R.id.text1);
        mBtnSolveCase = findViewById(R.id.btn_5);
    }

    private void setListeners() {
        mBtnSuspect1.setOnClickListener(mListenerSuspectSelected);
        mBtnSuspect2.setOnClickListener(mListenerSuspectSelected);
        mBtnSuspect3.setOnClickListener(mListenerSuspectSelected);
        mBtnSuspect4.setOnClickListener(mListenerSuspectSelected);
        mBtnSolveCase.setOnClickListener(mListenerSuspectSelected);
    }

    private void setTextSuspectName(String suspectName) {
        mTextSuspectName.setText(suspectName);
    }

    private void solveTheCase(String supsectName) {
        ActivityCaseSolved.newInstance(this, supsectName);
    }
}
