package com.probeh.navigation.common;
/*
    Created by Yonathan Probeh
    On Wednesday, Jun 24, 2020
*/
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.probeh.navigation.BR;

import java.io.Serializable;

public class BaseViewModel extends BaseObservable implements Serializable {
    
    // Private Fields
    private String title;
    private String actionText;
    private String instructions;
    private String description;
    private boolean footerVisible;
    private boolean headerVisible;
    private boolean actionVisible;
    private boolean actionEnabled;
    // Constructors
    public BaseViewModel() { }
    public BaseViewModel(String title, String instructions, String description) {
        this.title = title;
        this.instructions = instructions;
        this.description = description;
    }
    public BaseViewModel(String title, String instructions, String description, String actionText) {
        this(title, instructions, description);
        this.actionText = actionText;
    }
    public BaseViewModel(String title, String instructions, String description, String actionText, boolean footerVisible, boolean headerVisible, boolean actionVisible, boolean actionEnabled) {
        this(title, instructions, description, actionText);
        this.footerVisible = footerVisible;
        this.headerVisible = headerVisible;
        this.actionVisible = actionVisible;
        this.actionEnabled = actionEnabled;
    }
    // Public Access Modifiers | Getters
    @Bindable
    public String getTitle() {
        return title;
    }
    @Bindable
    public String getActionText() {
        return actionText;
    }
    @Bindable
    public String getInstructions() {
        return instructions;
    }
    @Bindable
    public String getDescription() {
        return description;
    }
    @Bindable
    public boolean isFooterVisible() {
        return footerVisible;
    }
    @Bindable
    public boolean isHeaderVisible() {
        return headerVisible;
    }
    @Bindable
    public boolean isActionVisible() {
        return actionVisible;
    }
    @Bindable
    public boolean isActionEnabled() {
        return actionEnabled;
    }
    // Public Access Modifiers | Setters
    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
    public void setActionText(String actionText) {
        this.actionText = actionText;
        notifyPropertyChanged(BR.actionText);
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
        notifyPropertyChanged(BR.instructions);
    }
    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }
    public void setFooterVisible(boolean footerVisible) {
        this.footerVisible = footerVisible;
        notifyPropertyChanged(BR.footerVisible);
    }
    public void setHeaderVisible(boolean headerVisible) {
        this.headerVisible = headerVisible;
        notifyPropertyChanged(BR.headerVisible);
    }
    public void setActionVisible(boolean actionVisible) {
        this.actionVisible = actionVisible;
        notifyPropertyChanged(BR.actionVisible);
    }
    public void setActionEnabled(boolean actionEnabled) {
        this.actionEnabled = actionEnabled;
        notifyPropertyChanged(BR.actionEnabled);
    }
}
