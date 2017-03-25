package com.girish.mvp.view.user;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.girish.mvp.R;
import com.girish.mvp.model.User;

public class ViewUserImpl implements ViewUser {
    private View rootView;
    private TextView textViewId;
    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextProfession;
    private UserDetailsSubmitListener listener;

    public ViewUserImpl(LayoutInflater inflater, ViewGroup viewGroup) {
        rootView = inflater.inflate(R.layout.activity_main, viewGroup);

        textViewId = (TextView) rootView.findViewById(R.id.textview_id);
        editTextName = (EditText) rootView.findViewById(R.id.edittext_name);
        editTextAge = (EditText) rootView.findViewById(R.id.edittext_age);
        editTextProfession = (EditText) rootView.findViewById(R.id.edittext_profession);
        Button buttonSubmit = (Button) rootView.findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setName(editTextName.getText().toString());
                user.setAge(Integer.parseInt(editTextAge.getText().toString()));
                user.setProfession(editTextProfession.getText().toString());
                listener.onSubmitClick(user);
            }
        });
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void displayId(String id) {
        textViewId.setText(id);
    }

    @Override
    public void setListener(UserDetailsSubmitListener listener) {
        this.listener = listener;
    }
}
