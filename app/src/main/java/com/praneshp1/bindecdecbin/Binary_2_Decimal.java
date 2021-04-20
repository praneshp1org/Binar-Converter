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

public class Binary_2_Decimal extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.binary_2_decimal, container, false);
        final EditText etBinary = view.findViewById(R.id.etBinary);
        Button btn2Decimal = view.findViewById(R.id.btn2Decimal);
        final TextView tvDecimal = view.findViewById(R.id.tvDecimal);
        btn2Decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String x;
                int a;
                try {
                    if (etBinary.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "Nothing entered!", Toast.LENGTH_SHORT).show();
                    }else {
                        x = etBinary.getText().toString();
                        a = Integer.parseInt(x, 2);
                        tvDecimal.setText(a + "");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Error Occurred!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}
