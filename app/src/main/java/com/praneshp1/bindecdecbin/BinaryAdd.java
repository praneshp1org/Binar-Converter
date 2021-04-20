package com.praneshp1.bindecdecbin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BinaryAdd extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.binary_addition, container, false);
        final EditText etNum1 = view.findViewById(R.id.etNum1);
        final EditText etNum2 = view.findViewById(R.id.etNum2);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        final TextView txtAdd = view.findViewById(R.id.tvAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    if (etNum1.getText().toString().isEmpty() && etNum2.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "Both input fields are empty!", Toast.LENGTH_SHORT).show();
                    }else if (etNum1.getText().toString().isEmpty() || etNum2.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "One of the input fields are empty!", Toast.LENGTH_SHORT).show();
                    }else{
                        String x1 = etNum1.getText().toString();
                        int x11 = Integer.parseInt(x1, 2);

                        String x2 = etNum2.getText().toString();
                        int x22 = Integer.parseInt(x2, 2);

                        int x = x11+x22;
                        while (x>0){
                            stringBuilder.append(x%2);
                            x = x/2;
                        }
                        txtAdd.setText(stringBuilder.reverse() + "");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return view;
    }
}
