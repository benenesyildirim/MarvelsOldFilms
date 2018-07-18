package com.example.enesyildirim.themoviedb.CustomThings;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.enesyildirim.themoviedb.R;


public class ExitAlertDialog implements View.OnClickListener {

    private DialogClickListener dialogClickListener;
    private Context context;
    private Button yesBtn, noBtn;
    private Dialog dialog;
    private String dialogTitle;

    public ExitAlertDialog(Context context, String dialogTitle, DialogClickListener dialogClickListener) {
        this.dialogClickListener = dialogClickListener;
        this.dialogTitle = dialogTitle;
        this.context = context;

    }

    public void show() {
        dialog = new Dialog(ExitAlertDialog.this.context);
        dialog.setContentView(R.layout.are_u_sure_alertdialog);

        TextView AreUSure = dialog.findViewById(R.id.r_u_sure_text);

        yesBtn = dialog.findViewById(R.id.yes_btn);
        noBtn = dialog.findViewById(R.id.no_btn);

        AreUSure.setText(dialogTitle);

        yesBtn.setOnClickListener(this);
        noBtn.setOnClickListener(this);

        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        if (!((Activity) context).isFinishing()) {
            try {
                dialog.show();
            } catch (Exception e) {
                Log.e("Exception", e.getMessage());
            }
        }
    }

    public void dismiss() {
        dialog.dismiss();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == yesBtn.getId()) {
            if (dialogClickListener != null)// Ya burada null gelmez ki zaten kullancıı veriyor bunu?!?!?!?!?!
                dialogClickListener.onClickListener(yesBtn.getId(), this);
        } else {
            dismiss();
        }
    }

    public interface DialogClickListener {
        void onClickListener(int button_id, ExitAlertDialog exitAlertDialog);
    }
}
