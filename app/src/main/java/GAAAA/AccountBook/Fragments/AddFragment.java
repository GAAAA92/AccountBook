package GAAAA.AccountBook.Fragments;

import android.app.Dialog;
import android.os.Bundle;

import GAAAA.AccountBook.R;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddFragment extends BottomSheetDialogFragment {
    private static AddFragment instance = new AddFragment();
    private AddFragment(){ }
    public static AddFragment getInstance(){
        return instance;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (getActivity() == null) return super.onCreateDialog(savedInstanceState);
        BottomSheetDialog dialog = new BottomSheetDialog(getActivity(), R.style.Theme_MaterialComponents_BottomSheetDialog);
        View root = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_add, null);
        dialog.setContentView(root);

        Window window = dialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.Add);
        }
        return dialog;
    }
}