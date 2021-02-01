package com.example.sortex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtNum;
    Button btnInput, btnOutput;
    TextView tvResult;
    int num[]=new int[5];
    int position=0;
    String result;
    int tmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum=findViewById(R.id.edtNum);
        btnInput=findViewById(R.id.btnInput);
        btnOutput=findViewById(R.id.btnOutput);
        tvResult=findViewById(R.id.tvResult);

        //edtNum으로부터 입력을 받아 배열을 넣는 작업.
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num[position]=Integer.parseInt(edtNum.getText().toString());
                position++;
                edtNum.setText("");
            }
        });

        //입력 받은 것을 출력
        btnOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result="소트 전 자료\n";
                for(int i=0; i<num.length; i++){
                    result+=num[i];
                }
                //sort알고리즘 수행
                for (int i=0; i<num.length-1; i++){
                    for (int j=i+1; j<num.length; j++){
                        if (num[i]>num[j]){
                            tmp=num[i];
                            num[i]=num[j];
                            num[j]=tmp;
                        }
                    }
                }
                result+="\nsort 후 자료\n";
                for(int i=0; i<num.length; i++){
                    result+=num[i];
                }
                tvResult.setText(result);
            }
        });
    }
}