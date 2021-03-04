package in.myinnos.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import in.myinnos.customdialogbox.CheckBox;
import in.myinnos.customdialogbox.CustomAlertDialog;
import in.myinnos.customdialogbox.CustomDialogListener;
import in.myinnos.customdialogbox.Icon;


public class MainActivity extends AppCompatActivity {
    TextView txClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txClick = findViewById(R.id.txClick);
        txClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialog.Builder builder = new CustomAlertDialog.Builder(MainActivity.this);
                builder.setTitle("Big Billion Days", 20)
                        .setMessage("Buy any product and get 20% discout up to Rs 5000", 15)
                        .setNoteMessage("to Rs 5000", 12)
                        .setImage("https://cdn-images-1.medium.com/max/1600/1*j41hMsYft-ifSvXuWOb7Gg.png"
                                , ImageView.ScaleType.FIT_XY)
                        .setCheckBox("Never show", CheckBox.Visible)
                        .setContentCornerRadius(10)
                        .setContentPadding(10)
                        .setButtonText("Test")
                        .buttonVisibility(true)
                        .adShare(true)
                        .setButtonColor(R.color.colorPrimaryDark)
                        .setIcon(R.drawable.close_circle, Icon.Visible, new CustomDialogListener() {
                            @Override
                            public void onClick(Dialog dialog, Boolean check) {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), check + "", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setOnAdClickListener(new CustomDialogListener() {
                            @Override
                            public void onClick(Dialog dialog, Boolean check) {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), "Ad is clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnButtonClickListener(new CustomDialogListener() {
                            @Override
                            public void onClick(Dialog dialog, Boolean check) {

                            }
                        })
                        .setShareButtonText("Telegram")
                        .setOnAdShareListener(new CustomDialogListener() {
                            @Override
                            public void onClick(Dialog dialog, Boolean check) {
                                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
                            }
                        })
                        // temp solution
                        .setShareIcon(R.drawable.close_circle, Icon.Visible, new CustomDialogListener() {
                            @Override
                            public void onClick(Dialog dialog, Boolean check) {
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(), check + "", Toast.LENGTH_SHORT).show();

                            }
                        });
                builder.show();

            }
        });
    }
}
