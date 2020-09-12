package com.example.mvvmexample;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.mvvmexample.BR;
import com.example.mvvmexample.Model.User;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends BaseObservable
{
    private User user;
    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    private String toastMessage = null;

    public String getToastMessage()
    {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage)
    {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getUserEmail()
    {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword()
    {
        return user.getPassword();
    }

    public void setUserEmail(String email)
    {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }
    public void setUserPassword(String password)
    {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel()
    {
        user = new User("","");
    }

    public void onLoginClicked()
    {
        if (isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }
    public boolean isInputDataValid()
    {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }
}
