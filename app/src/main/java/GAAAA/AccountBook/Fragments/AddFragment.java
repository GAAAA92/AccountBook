package GAAAA.AccountBook.Fragments;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import GAAAA.AccountBook.R;

public class AddFragment extends BottomSheetDialogFragment{
    private BottomSheetBehavior mBehavior;
    private static AddFragment instance = null;
    private AddFragment(){
        super();
    }
    public static AddFragment getInstance(){
        if (instance == null) {
            synchronized (AddFragment.class) {
                if (instance == null) {
                    instance = new AddFragment();
                }
            }
        }
        return instance;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        BottomSheetDialog dialog = new BottomSheetDialog(getContext(), R.style.BottomSheetDialog);
        View view = View.inflate(getContext(), R.layout.fragment_add, null);
        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;
    }

}