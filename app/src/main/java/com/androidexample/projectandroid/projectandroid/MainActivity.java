package com.androidexample.projectandroid.projectandroid;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.os.Handler;
        import android.provider.Settings;
        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;



public class MainActivity extends ActionBarActivity {

    Button intensityButton ;
    private EditText ed1;
    private ImageView im1;
    private ImageView im2;
    private ImageView im3;
    private Button btn1;
    String Name="namekey";
    String Flag="flagkey";
    SharedPreferences sp;
    String mypref="mypref";
    int curBrightnessValue=0;
    EditText t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = (EditText)findViewById(R.id.edit1);
        im1 = (ImageView)findViewById(R.id.img1);
        im2 = (ImageView)findViewById(R.id.img2);
        im3 = (ImageView)findViewById(R.id.img3);
        btn1 = (Button)findViewById(R.id.btn2);
        intensityButton=(Button)findViewById(R.id.intensityButton);
        sp=getSharedPreferences(mypref, Context.MODE_PRIVATE);
        if(sp.contains(Name)){
            btn1.setText(sp.getString(Name, ""));
        }
        if(sp.contains(Flag))
        {
            int f = sp.getInt(Flag,0);
            if(f == 0)
            {
                im3.setImageResource(R.drawable.off);
            }
            else
            {
                im3.setImageResource(R.drawable.on);
            }
        }
    }

    public void click1(View view)
    {

        String btnText1 = "";
        int flag =0;
        String btnText = btn1.getText().toString();
        if(btnText.equalsIgnoreCase("start"))
        {
            btnText1 = "stop";
            flag=0;
        }
        else
        {
            btnText1 = "start";
            flag=1;
        }
        SharedPreferences.Editor editor= sp.edit();
        editor.putString(Name, btnText1);
        editor.putInt(Flag,flag);
        editor.commit();
        btn1.setText(btnText1);
        if(flag == 0)
        {
            im3.setImageResource(R.drawable.off);
        }
        else
        {
            im3.setImageResource(R.drawable.on);
        }
    }

    public void click(View view)
    {
        try {
            String abc = ed1.getText().toString();
            int no = Integer.valueOf(abc);
            if (no > 0 && no < 11) {
                im1.setImageResource(R.drawable.abc1);
                im2.setImageResource(R.drawable.abc1);
            } else if (no > 10 && no < 21) {
                im1.setImageResource(R.drawable.abc3);
                im2.setImageResource(R.drawable.abc3);
            } else {
                im1.setImageResource(R.drawable.abc2);
                im2.setImageResource(R.drawable.abc2);
            }
        }
        catch (Exception e)
        {

        }
        finally {

            int DELAY = 900;
            //code for directly returning to main activity after completion of work
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    im1.setImageResource(R.drawable.abc5);
                    im2.setImageResource(R.drawable.abc5);
                }
            }, DELAY);

        }

        t=(EditText) findViewById(R.id.edit1);
        String abc = t.getText().toString();
        int no = Integer.valueOf(abc);
        try {
            curBrightnessValue=android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        if(curBrightnessValue>no){

            intensityButton.setBackgroundResource(R.drawable.border_radius_red);
        }
        else{


            intensityButton.setBackgroundResource(R.drawable.border_radius_green);
        }

    }


//    public void onButtonClick(View v){
//
//        t=(EditText) findViewById(R.id.edit1);
//        String abc = t.getText().toString();
//        int no = Integer.valueOf(abc);
//        try {
//            curBrightnessValue=android.provider.Settings.System.getInt(getContentResolver(), android.provider.Settings.System.SCREEN_BRIGHTNESS);
//        } catch (Settings.SettingNotFoundException e) {
//            e.printStackTrace();
//        }
//        if(curBrightnessValue>no){
//
//            intensityButton.setBackgroundResource(R.drawable.border_radius_red);
//        }
//        else{
//
//
//                intensityButton.setBackgroundResource(R.drawable.border_radius_green);
//        }
//
//
//    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}

