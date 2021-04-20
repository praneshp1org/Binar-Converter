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

public class BinarySub extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.binary_subtract, container, false);
        final EditText etNum1S = view.findViewById(R.id.etNum1S);
        final EditText etNum2S = view.findViewById(R.id.etNum2S);
        Button btnSub = view.findViewById(R.id.btnSub);
        final TextView txtSub = view.findViewById(R.id.tvSub);

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    if (etNum1S.getText().toString().isEmpty() && etNum2S.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "Both input fields are empty!", Toast.LENGTH_SHORT).show();
                    }else if (etNum1S.getText().toString().isEmpty() || etNum2S.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "One of the input fields are empty!", Toast.LENGTH_SHORT).show();
                    }else{
                        String st1 = etNum1S.getText().toString();
                        int st11 = Integer.parseInt(st1, 2);

                        String st2 = etNum2S.getText().toString();
                        int st22 = Integer.parseInt(st2, 2);

                        int st = st11-st22;
                        if (st < 0){
                            txtSub.setText("You entered the binary numbers whose difference is negative!");
                        }else {
                            while (st>0){
                                stringBuilder.append(st%2);
                                st = st/2;
                            }
                            txtSub.setText(stringBuilder.reverse() + "");
                        }

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
