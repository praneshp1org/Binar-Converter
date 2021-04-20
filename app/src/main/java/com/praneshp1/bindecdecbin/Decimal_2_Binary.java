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

public class Decimal_2_Binary extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.decimal_2_binary, container, false);
        Button btn2Binary = view.findViewById(R.id.btn2Binary);
        final EditText etDecimal = view.findViewById(R.id.etDecimal);
        final TextView tvBinary = view.findViewById(R.id.tvBinary);

        btn2Binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    if (etDecimal.getText().toString().isEmpty()){
                        Toast.makeText(getContext(), "Nothing entered!!", Toast.LENGTH_SHORT).show();
                    }else {
                        long number = Long.parseLong(etDecimal.getText().toString());
                        while (number>0){
                            stringBuilder.append(number%2);
                            number = (number/2);
                        }
                        tvBinary.setText(stringBuilder.reverse() + "");
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
