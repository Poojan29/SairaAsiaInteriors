package com.example.sairaasiainteriors;

import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EmployeeNames {

    public String name;
    public String indexno;
    public RadioGroup radioGroup;
    public RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    public EmployeeNames() {
    }

    public EmployeeNames(String name, String indexno, RadioGroup radioGroup, RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4) {
        this.name = name;
        this.indexno = indexno;
        this.radioGroup = radioGroup;
        this.radioButton1 = radioButton1;
        this.radioButton2 = radioButton2;
        this.radioButton3 = radioButton3;
        this.radioButton4 = radioButton4;
    }

    public String getName() {
        if (name.isEmpty()){
            name="";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndexno() {
        if (indexno.isEmpty()){
            indexno="";
        }
        return indexno;
    }

    public void setIndexno(String indexno) {
        this.indexno = indexno;
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    public void setRadioGroup(RadioGroup radioGroup) {
        this.radioGroup = radioGroup;
    }

    public RadioButton getRadioButton1() {
        return radioButton1;
    }

    public void setRadioButton1(RadioButton radioButton1) {
        this.radioButton1 = radioButton1;
    }

    public RadioButton getRadioButton2() {
        return radioButton2;
    }

    public void setRadioButton2(RadioButton radioButton2) {
        this.radioButton2 = radioButton2;
    }

    public RadioButton getRadioButton3() {
        return radioButton3;
    }

    public void setRadioButton3(RadioButton radioButton3) {
        this.radioButton3 = radioButton3;
    }

    public RadioButton getRadioButton4() {
        return radioButton4;
    }

    public void setRadioButton4(RadioButton radioButton4) {
        this.radioButton4 = radioButton4;
    }
}