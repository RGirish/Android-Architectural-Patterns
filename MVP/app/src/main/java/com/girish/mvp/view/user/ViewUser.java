package com.girish.mvp.view.user;

import com.girish.mvp.model.User;
import com.girish.mvp.view.ViewMvp;

public interface ViewUser extends ViewMvp {
    public interface UserDetailsSubmitListener {
        void onSubmitClick(User user);
    }

    void displayId(String id);

    void setListener(UserDetailsSubmitListener listener);
}
