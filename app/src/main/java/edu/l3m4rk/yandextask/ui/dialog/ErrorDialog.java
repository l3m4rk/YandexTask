package edu.l3m4rk.yandextask.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import edu.l3m4rk.yandextask.R;

public final class ErrorDialog extends DialogFragment {

    private static final java.lang.String ARG_MESSAGE = "arg_message";
    private String mMessage;

    public static ErrorDialog newInstance(@NonNull String message) {
        Bundle args = new Bundle();
        args.putString(ARG_MESSAGE, message);
        ErrorDialog fragment = new ErrorDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMessage = getArguments().getString(ARG_MESSAGE);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.error_dialog_title);
        builder.setMessage(mMessage);
        builder.setPositiveButton(android.R.string.ok,
                (DialogInterface dialog, int which) -> dialog.dismiss());
        return builder.create();
    }
}
