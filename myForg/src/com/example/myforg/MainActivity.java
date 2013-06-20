package com.example.myforg;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	TextView Ev1;
	@Override
	public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);
  
        Ev1 = (TextView)findViewById(R.id.myText);    
  
        Button Btn1 = (Button)findViewById(R.id.button1);//��ȡ��ť��Դ    
        Button BtnGo = (Button)findViewById(R.id.button2);//��ȡ��ť��Դ    
        //Btn1��Ӽ���
        Btn1.setOnClickListener(new Button.OnClickListener(){//��������    
        	int a;
        	@Override
        	public void onClick(View v) {    
        		String strTmp = String.valueOf(a++);    
        		Ev1.setText(strTmp);    
        	}    
        	
        });
        //BtnGo ��Ӽ���������ҳ�����ת
        BtnGo.setOnClickListener(new Button.OnClickListener(){//��������    
            @Override
			public void onClick(View v) {    
                Intent intentGo	= new Intent();
                intentGo.setClass(MainActivity.this, ChronometerActivity.class);
                startActivity(intentGo);
                finish();
            }    
  
        });
        }

}
