package in.myinnos.customdialogbox;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class CustomAlertDialog {
    private String title, message, positiveBtnText, negativeBtnText,
            imageUrl, checkBoxText, buttonText, shareButtonText;
    private Activity activity;
    private int icon, contentPadding,
            titleTextColor, messageTextColor;
    private in.myinnos.customdialogbox.Icon visibility;
    private in.myinnos.customdialogbox.CheckBox checkBoxVisibility;
    private CustomDialogListener listener, adListener, imgAdListener, desAdListener,
            buttonAdListener, adShareListener;
    private int pBtnColor, color, bgColor, btColor;
    private int titleFontSize, messageFontSize;
    private ImageView.ScaleType scaleType;
    private boolean cancel, buttonVisibility, adShare;
    private float cardCornerRadius;

    private CustomAlertDialog(Builder builder) {
        this.title = builder.title;
        this.message = builder.message;
        this.activity = builder.activity;
        this.icon = builder.icon;
        this.visibility = builder.visibility;
        this.listener = builder.listener;
        this.positiveBtnText = builder.positiveBtnText;
        this.negativeBtnText = builder.negativeBtnText;
        this.pBtnColor = builder.pBtnColor;
        this.color = builder.color;
        this.bgColor = builder.bgColor;
        this.cancel = builder.cancel;
        this.titleFontSize = builder.titleFontSize;
        this.messageFontSize = builder.messageFontSize;
        this.scaleType = builder.scaleType;
        this.adListener = builder.adListener;
        this.checkBoxVisibility = builder.checkBoxVisibility;
        this.checkBoxText = builder.checkBoxText;
        this.cardCornerRadius = builder.cardCornerRadius;
        this.contentPadding = builder.contentPadding;
        this.titleTextColor = builder.titleTextColor;
        this.messageTextColor = builder.messageTextColor;
        this.buttonVisibility = builder.buttonVisibility;
        this.adShare = builder.adShare;
        this.buttonText = builder.buttonText;
        this.buttonAdListener = builder.adShareListener;
        this.adShareListener = builder.adShareListener;
        this.shareButtonText = builder.shareButtonText;
        this.btColor = builder.btColor;
    }

    public static class Builder {
        private String title, message, positiveBtnText, negativeBtnText, imageUrl, checkBoxText,
                buttonText, shareButtonText;
        private Activity activity;
        private int icon, contentPadding,
                titleTextColor, messageTextColor;
        private in.myinnos.customdialogbox.Icon visibility;
        private in.myinnos.customdialogbox.CheckBox checkBoxVisibility;
        private CustomDialogListener listener, adListener, buttonAdListener, adShareListener;
        private int pBtnColor, color, bgColor, btColor;
        private int titleFontSize, messageFontSize;
        private float cardCornerRadius;
        private ImageView.ScaleType scaleType;
        private boolean cancel, buttonVisibility, adShare;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setShareButtonText(String shareButtonText) {
            this.shareButtonText = shareButtonText;
            return this;
        }

        public Builder setTitle(String title, int fontSize) {
            this.title = title;
            this.titleFontSize = fontSize;
            return this;
        }

        public Builder setTitleColor(int titleTextColor) {
            this.titleTextColor = titleTextColor;
            return this;
        }

        public Builder setMessage(String message, int fontSize) {
            this.message = message;
            this.messageFontSize = fontSize;
            return this;
        }

        public Builder setMessageColor(int messageTextColor) {
            this.messageTextColor = messageTextColor;
            return this;
        }

        public Builder setButtonText(String buttonText) {
            this.buttonText = buttonText;
            return this;
        }

        public Builder setImage(String imageUrl, ImageView.ScaleType scaleType) {
            this.imageUrl = imageUrl;
            this.scaleType = scaleType;
            return this;
        }

        //setIcon
        public Builder setIcon(int icon, Icon visibility, CustomDialogListener listener) {
            this.icon = icon;
            this.visibility = visibility;
            this.listener = listener;
            return this;
        }

        public Builder setIsCancellable(boolean cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder buttonVisibility(boolean buttonVisibility) {
            this.buttonVisibility = buttonVisibility;
            return this;
        }

        public Builder adShare(boolean adShare) {
            this.adShare = adShare;
            return this;
        }

        public Builder setCheckBox(String checkBoxText, in.myinnos.customdialogbox.CheckBox checkBoxVisibility) {
            this.checkBoxText = checkBoxText;
            this.checkBoxVisibility = checkBoxVisibility;
            return this;
        }

        public Builder setCheckBoxColor(int color) {
            this.color = color;
            return this;
        }

        public Builder setButtonColor(int btColor) {
            this.btColor = btColor;
            return this;
        }

        public Builder setOnAdClickListener(CustomDialogListener adListener) {
            this.adListener = adListener;
            return this;
        }

        public Builder setOnButtonClickListener(CustomDialogListener buttonAdListener) {
            this.buttonAdListener = buttonAdListener;
            return this;
        }

        public Builder setOnAdShareListener(CustomDialogListener adShareListener) {
            this.adShareListener = adShareListener;
            return this;
        }

        public Builder setContentPadding(int contentPadding) {
            this.contentPadding = contentPadding;
            return this;
        }

        public Builder setContentCornerRadius(float cardCornerRadius) {
            this.cardCornerRadius = cardCornerRadius;
            return this;
        }


        public CustomAlertDialog show() {
            TextView txTitle, txMessage, txCheckBox, txShareButtonMessage;
            Button btClick;
            LinearLayout adShareLayout;
            ImageView imgClose, imgAds;
            RelativeLayout rlCheckBox, rlMain;
            LinearLayout liMain;
            CardView card_layout;
            final CheckBox checkbox;
            final Dialog dialog;
            dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(cancel);
            dialog.setContentView(R.layout.act_alert_dialog);
            txTitle = dialog.findViewById(R.id.txTitle);
            txMessage = dialog.findViewById(R.id.txMessage);
            adShareLayout = dialog.findViewById(R.id.adShareLayout);
            txShareButtonMessage = dialog.findViewById(R.id.txShareButtonMessage);
            btClick = dialog.findViewById(R.id.btClick);
            txCheckBox = dialog.findViewById(R.id.txCheckBox);
            imgClose = dialog.findViewById(R.id.imgClose);
            imgAds = dialog.findViewById(R.id.imgAds);
            checkbox = dialog.findViewById(R.id.checkbox);
            rlCheckBox = dialog.findViewById(R.id.rlCheckBox);
            liMain = dialog.findViewById(R.id.liMain);
            rlMain = dialog.findViewById(R.id.rlMain);
            card_layout = dialog.findViewById(R.id.card_layout);

            if (adShare) {
                adShareLayout.setVisibility(View.VISIBLE);
            } else {
                adShareLayout.setVisibility(View.GONE);
            }

            if (buttonVisibility) {
                btClick.setText(buttonText);
                btClick.setVisibility(View.VISIBLE);
            } else {
                btClick.setVisibility(View.GONE);
            }

            if (btColor != 0) {
                btClick.setBackgroundColor(btColor);
            }

            if (cardCornerRadius != 0) {
                card_layout.setRadius(cardCornerRadius);
            } else {
                card_layout.setRadius(10);
            }
            if (contentPadding != 0) {
                rlMain.setPadding(contentPadding, contentPadding, contentPadding, contentPadding);
            } else {
                rlMain.setPadding(10, 10, 10, 10);
            }
            txTitle.setText(Html.fromHtml(title));
            if (titleFontSize != 0) {
                txTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleFontSize);
            } else {
                txTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            }
            if (titleTextColor != 0) {
                txTitle.setTextColor(titleTextColor);
            }
            txMessage.setText(Html.fromHtml(message));
            if (messageFontSize != 0) {
                txMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, messageFontSize);
            } else {
                txMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
            }
            if (messageTextColor != 0) {
                txMessage.setTextColor(messageTextColor);
            }

            imgClose.setBackgroundDrawable(ContextCompat.getDrawable(activity, icon));
            if (visibility == Icon.Visible) {
                imgClose.setVisibility(View.VISIBLE);
            } else {
                imgClose.setVisibility(View.GONE);
            }
            if (imageUrl != null) {
                imgAds.setVisibility(View.VISIBLE);
                imgAds.setScaleType(scaleType);
                Glide.with(activity)
                        .load(imageUrl)
                        .into(imgAds);
            } else {
                imgAds.setVisibility(View.GONE);
            }
            imgClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(dialog, checkbox.isChecked());
                }
            });
            if (checkBoxVisibility == in.myinnos.customdialogbox.CheckBox.Visible) {
                rlCheckBox.setVisibility(View.VISIBLE);
                txCheckBox.setText(checkBoxText);
                if (color != 0) {
                    txCheckBox.setTextColor(color);
                }

            } else {
                rlCheckBox.setVisibility(View.GONE);
            }
            if (adListener != null) {
                liMain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adListener.onClick(dialog, checkbox.isChecked());
                    }
                });
            }

            if (buttonAdListener != null) {
                btClick.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonAdListener.onClick(dialog, true);
                    }
                });
            }

            txShareButtonMessage.setText(shareButtonText);
            if (adShareListener != null) {
                adShareLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adShareListener.onClick(dialog, true);
                    }
                });
            }

            dialog.show();
            return new CustomAlertDialog(this);
        }
    }
}
