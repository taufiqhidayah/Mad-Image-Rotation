package id.co.imastudio.madcetar;

/*
 Aplikasi Oleh Taufiq Hidayah
 visit blog.taufiqhidayah.com

 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img,img1,img2;
    private double mCurrAngle = 0;
    private double mCurrAngle1 = 0;
    private double mPrevAngle1 = 0;
    private double mCurrAngle2 = 0;
    private double mPrevAngle2 = 0;
    private double mPrevAngle = 0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.tentang){
            AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this);
            al.setMessage("Visit blog.taufiqhidayah.com");
            al.setTitle("Aplikasi by Taufiq Hidayah");

            al.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
al.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 =(ImageView)findViewById(R.id.dua);
        img =(ImageView)findViewById(R.id.satu);
        img2 =(ImageView)findViewById(R.id.tiga);
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final float xc = img.getWidth() / 2;
                final float yc = img.getHeight() / 2;

                final float x = event.getX();
                final float y = event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        //    img.clearAnimation();
                        mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        mPrevAngle = mCurrAngle;
                        mCurrAngle = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        animate(mPrevAngle, mCurrAngle, 0);
                        break;
                    }
                    case MotionEvent.ACTION_UP : {
                        mPrevAngle = mCurrAngle;
                        break;
                    }
                }
                return true;
            }
        });
        img2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final float xc = img.getWidth() / 2;
                final float yc = img.getHeight() / 2;

                final float x = event.getX();
                final float y = event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        //    img.clearAnimation();
                        mCurrAngle2 = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        mPrevAngle2 = mCurrAngle2;
                        mCurrAngle2 = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        animateq(mPrevAngle2, mCurrAngle2, 0);
                        break;
                    }
                    case MotionEvent.ACTION_UP : {
                        mPrevAngle2 = mCurrAngle2;
                        break;
                    }
                }

                return true;
            }
        });
        img1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final float xc = img.getWidth() / 2;
                final float yc = img.getHeight() / 2;

                final float x = event.getX();
                final float y = event.getY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        //    img.clearAnimation();
                        mCurrAngle1 = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        mPrevAngle1 = mCurrAngle1;
                        mCurrAngle1 = Math.toDegrees(Math.atan2(x - xc, yc - y));
                        animatea(mPrevAngle1, mCurrAngle1, 0);
                        break;
                    }
                    case MotionEvent.ACTION_UP : {
                        mPrevAngle1 = mCurrAngle1;
                        break;
                    }
                }

                return true;
            }
        });
    }

    private void animateq(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        img2.startAnimation(rotate);
        img2.setSaveEnabled(true);
    }

    private void animatea(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        img1.startAnimation(rotate);
        img1.setSaveEnabled(true);
    }


    private void animate(double fromDegrees, double toDegrees, long durationMillis) {
        final RotateAnimation rotate = new RotateAnimation((float) fromDegrees, (float) toDegrees,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(durationMillis);
        rotate.setFillEnabled(true);
        rotate.setFillAfter(true);
        img.startAnimation(rotate);
        img.setSaveEnabled(true);


    }
}
