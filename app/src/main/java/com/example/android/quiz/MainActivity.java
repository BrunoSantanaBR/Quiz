package com.example.android.quiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score;
    private int count;
    private RadioButton answerRadioButton;
    private CheckBox answerCheckBoxRight1;
    private CheckBox answerCheckBoxRight2;
    private CheckBox answerCheckBoxWrong1;
    private CheckBox answerCheckBoxWrong2;
    private EditText answerEditText;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Submit Quiz button is clicked.
     */
    public void submitQuiz(View view) {

        if (checkQuestions() == 10) {

            //Question 1
            answerRadioButton = findViewById(R.id.question_one_option_two_radioButton);
            radioGroup = findViewById(R.id.question_one_radioGroup);
            checkRadioButtonsQuestions(answerRadioButton, radioGroup);

            //Question 2
            answerRadioButton = findViewById(R.id.question_two_option_two_radioButton);
            radioGroup = findViewById(R.id.question_two_radioGroup);
            checkRadioButtonsQuestions(answerRadioButton, radioGroup);

            //Question 3
            answerCheckBoxRight1 = findViewById(R.id.question_three_option_one_checkBox);
            answerCheckBoxRight2 = findViewById(R.id.question_three_option_four_checkBox);
            answerCheckBoxWrong1 = findViewById(R.id.question_three_option_two_checkBox);
            answerCheckBoxWrong2 = findViewById(R.id.question_three_option_three_checkBox);
            checkCheckBoxQuestions(answerCheckBoxRight1, answerCheckBoxRight2, answerCheckBoxWrong1, answerCheckBoxWrong2);

            //Question 4
            answerRadioButton = findViewById(R.id.question_four_option_one_radioButton);
            radioGroup = findViewById(R.id.question_four_radioGroup);
            checkRadioButtonsQuestions(answerRadioButton, radioGroup);

            //Question 5
            answerRadioButton = findViewById(R.id.question_five_option_one_radioButton);
            radioGroup = findViewById(R.id.question_five_radioGroup);
            checkRadioButtonsQuestions(answerRadioButton, radioGroup);

            //Question 6
            answerEditText = findViewById(R.id.question_six);
            checkEditTextQuestions(answerEditText, getResources().getString(R.string.correctAnswer6));


            //Question 7
            answerRadioButton = findViewById(R.id.question_seven_option_three_radioButton);
            radioGroup = findViewById(R.id.question_seven_radioGroup);
            checkRadioButtonsQuestions(answerRadioButton, radioGroup);

            //Question 8
            answerEditText = findViewById(R.id.question_eight);
            checkEditTextQuestions(answerEditText, getResources().getString(R.string.correctAnswer8));

            //Question 9
            answerRadioButton = findViewById(R.id.question_nine_option_two_radioButton);
            radioGroup = findViewById(R.id.question_nine_radioGroup);
            checkRadioButtonsQuestions(answerRadioButton, radioGroup);

            //Question 10
            answerCheckBoxRight1 = findViewById(R.id.question_ten_option_one_checkBox);
            answerCheckBoxRight2 = findViewById(R.id.question_ten_option_three_checkBox);
            answerCheckBoxWrong1 = findViewById(R.id.question_ten_option_two_checkBox);
            answerCheckBoxWrong2 = findViewById(R.id.question_ten_option_four_checkBox);
            checkCheckBoxQuestions(answerCheckBoxRight1, answerCheckBoxRight2, answerCheckBoxWrong1, answerCheckBoxWrong2);

            findViewById(R.id.submit_button).setEnabled(false);

            displayScore();

        } else {
            alert();
            count = 0;
        }
    }

    /**
     * This method is called to verify if the Radio Button selected in the Quiz is correct
     * if its correct the method changes the color of the text to green and add 1 point to the global variable score
     * if its not correct the method changes the color of the wrong answer text to red and the right answer text to green and do not add any point to the global variable score
     *
     * @param radioButton Radio Button selected on the Quiz
     * @param radioGroup  Radio Group of the Radio Button selected on the Quiz
     */
    private void checkRadioButtonsQuestions(RadioButton radioButton, RadioGroup radioGroup) {
        if (radioButton.isChecked()) {
            setColorText(radioButton, Color.GREEN);
            setStateRadioButtons(radioGroup, false);
            score++;
        } else {
            int radioGroupIdTemp = radioGroup.getCheckedRadioButtonId();
            RadioButton radioButtonTemp = findViewById(radioGroupIdTemp);

            setColorText(radioButtonTemp, Color.RED);
            setColorText(radioButton, Color.GREEN);
            setStateRadioButtons(radioGroup, false);
        }
    }

    /**
     * This method is called to verify if the Check Boxe's selected in the Quiz is correct
     * if its correct, the method changes the color of the texts to green and add 1 point to the global variable score
     * if its not correct, the method changes the color of the wrong answers text to red and the right answers text to green and do not add any point to the global variable score
     *
     * @param checkBoxRight1 Check Box with correct answer in the Quiz
     * @param checkBoxRight2 Check Box with correct answer in the Quiz
     * @param checkBoxWrong1 Check Box with wrong answer in the Quiz
     * @param checkBoxWrong2 Check Box with wrong answer in the Quiz
     */
    private void checkCheckBoxQuestions(CheckBox checkBoxRight1, CheckBox checkBoxRight2, CheckBox checkBoxWrong1, CheckBox checkBoxWrong2) {
        if (checkBoxRight1.isChecked() && checkBoxRight2.isChecked() && checkBoxWrong1.isChecked() && checkBoxWrong2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong1, Color.RED);
            setColorText(checkBoxWrong2, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight1.isChecked() && checkBoxRight2.isChecked() && checkBoxWrong1.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong1, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight1.isChecked() && checkBoxRight2.isChecked() && checkBoxWrong2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong2, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight1.isChecked() && checkBoxWrong1.isChecked() && checkBoxWrong2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxWrong1, Color.RED);
            setColorText(checkBoxWrong2, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight2.isChecked() && checkBoxWrong1.isChecked() && checkBoxWrong2.isChecked()) {
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong1, Color.RED);
            setColorText(checkBoxWrong2, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight1.isChecked() && checkBoxRight2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
            score++;
        } else if (checkBoxRight1.isChecked() && checkBoxWrong1.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong1, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight1.isChecked() && checkBoxWrong2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong2, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight2.isChecked() && checkBoxWrong1.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong1, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight2.isChecked() && checkBoxWrong2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong2, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxWrong1.isChecked() && checkBoxWrong2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong1, Color.RED);
            setColorText(checkBoxWrong2, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight1.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxRight2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxWrong1.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong1, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        } else if (checkBoxWrong2.isChecked()) {
            setColorText(checkBoxRight1, Color.GREEN);
            setColorText(checkBoxRight2, Color.GREEN);
            setColorText(checkBoxWrong2, Color.RED);
            setStateCheckBox(checkBoxRight1, checkBoxRight2, checkBoxWrong1, checkBoxWrong2, false);
        }
    }

    /**
     * This method is called to verify if the text typed in the Edit Text in the Quiz is the same that passed in the variable anwser.
     * if its correct, the method changes the color of the texts to green and add 1 point to the global variable score
     * if its not correct, the method changes the color of the wrong answers text to red and add the right answers text to green on the right of the wrong answer
     * and do not add any point to the global variable score
     *
     * @param editText Text typed in the Quiz
     * @param answer   Right answer
     */
    private void checkEditTextQuestions(EditText editText, String answer) {
        if (editText.getText().toString().trim().toUpperCase().equals(answer)) {
            setColorText(editText, Color.GREEN);
            editText.setInputType(InputType.TYPE_NULL);
            score++;
        } else {
            String stringTemp;
            SpannableStringBuilder builder = new SpannableStringBuilder();

            SpannableString redSpannable = new SpannableString(editText.getText().toString().trim().toUpperCase());
            redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, editText.getText().toString().toUpperCase().trim().length(), 0);
            builder.append(redSpannable);

            stringTemp = "   " + getString(R.string.correct) + " " + answer;

            SpannableString greenSpannable = new SpannableString(stringTemp);
            greenSpannable.setSpan(new ForegroundColorSpan(Color.GREEN), 0, stringTemp.length(), 0);
            builder.append(greenSpannable);

            editText.setText(builder, TextView.BufferType.SPANNABLE);
            editText.setInputType(InputType.TYPE_NULL);
        }
    }

    /**
     * This method is called to disable the Radio Buttons after submit the quiz
     * or
     * This method is called to enable the Radio Buttons after reset the quiz
     *
     * @param radioGroup Radio Group of the Radio Buttons selected on the Quiz
     * @param checked    true to Enable and false to disable
     */
    private void setStateRadioButtons(RadioGroup radioGroup, boolean checked) {
        for (int i = 0; i < radioGroup.getChildCount(); i++) {
            (radioGroup.getChildAt(i)).setEnabled(checked);
        }
    }

    /**
     * This method is called to disable the Check Box's after submit the quiz
     * or
     * This method is called to enable the Check Box's after reset the quiz
     *
     * @param checkBox1 Check Box 1 on the Quiz Question
     * @param checkBox2 Check Box 1 on the Quiz Question
     * @param checkBox3 Check Box 1 on the Quiz Question
     * @param checkBox4 Check Box 1 on the Quiz Question
     * @param state     true to Enable and false to disable
     */
    private void setStateCheckBox(CheckBox checkBox1, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, Boolean state) {
        checkBox1.setEnabled(state);
        checkBox2.setEnabled(state);
        checkBox3.setEnabled(state);
        checkBox4.setEnabled(state);
    }

    /**
     * This method is called to set the color of the text of the Radio Button
     *
     * @param radioButton Radio Button in the Quiz
     * @param color
     */
    private void setColorText(RadioButton radioButton, int color) {
        radioButton.setTextColor(color);
    }

    /**
     * This method is called to set the color of the text of the Check Box
     *
     * @param checkBox Check Box in the Quiz
     * @param color
     */
    private void setColorText(CheckBox checkBox, int color) {
        checkBox.setTextColor(color);
    }

    /**
     * This method is called to set the color of the text of the Edit Text
     *
     * @param editText Edit Text in the Quiz
     * @param color
     */
    private void setColorText(EditText editText, int color) {
        editText.setTextColor(color);
    }

    /**
     * This method is called to show Toast Message saying to answer all questions before submit
     */
    private void alert() {
        Toast.makeText(getApplicationContext(), R.string.alert, Toast.LENGTH_SHORT).show();
    }

    /**
     * This method is called to display the score to the player
     */
    private void displayScore() {

        String displayScore = getString(R.string.finalScore) + " " + String.valueOf(this.score);

        Toast toast = Toast.makeText(getApplicationContext(),
                displayScore, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();


    }

    /**
     * This method is called to check if the all questions were answered
     * If Yes the count global variable return 10
     * If No the count global variable return less than 10
     *
     * @return integer
     */
    private int checkQuestions() {

        //Check Question 1
        radioGroup = findViewById(R.id.question_one_radioGroup);
        if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
            count++;
        }

        //Check Question 2
        radioGroup = findViewById(R.id.question_two_radioGroup);
        if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
            count++;
        }

        //Check Question 3
        answerCheckBoxRight1 = findViewById(R.id.question_three_option_one_checkBox);
        answerCheckBoxRight2 = findViewById(R.id.question_three_option_two_checkBox);
        answerCheckBoxWrong1 = findViewById(R.id.question_three_option_three_checkBox);
        answerCheckBoxWrong2 = findViewById(R.id.question_three_option_four_checkBox);
        if (!answerCheckBoxRight1.isChecked() && !answerCheckBoxRight2.isChecked() && !answerCheckBoxWrong1.isChecked() & !answerCheckBoxWrong2.isChecked()) {
        } else {
            count++;
        }

        //Check Question 4
        radioGroup = findViewById(R.id.question_four_radioGroup);
        if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
            count++;
        }

        //Check Question 5
        radioGroup = findViewById(R.id.question_five_radioGroup);
        if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
            count++;
        }

        //Check Question 6
        answerEditText = findViewById(R.id.question_six);
        if (!(answerEditText.getText().toString().trim().equals(""))) {
            count++;
        }

        //Check Question 7
        radioGroup = findViewById(R.id.question_seven_radioGroup);
        if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
            count++;
        }

        //Check Question 8
        answerEditText = findViewById(R.id.question_eight);
        if (!(answerEditText.getText().toString().trim().equals(""))) {
            count++;
        }

        //Check Question 9
        radioGroup = findViewById(R.id.question_nine_radioGroup);
        if (!(radioGroup.getCheckedRadioButtonId() == -1)) {
            count++;
        }

        //Check Question 10
        answerCheckBoxRight1 = findViewById(R.id.question_ten_option_one_checkBox);
        answerCheckBoxRight2 = findViewById(R.id.question_ten_option_two_checkBox);
        answerCheckBoxWrong1 = findViewById(R.id.question_ten_option_three_checkBox);
        answerCheckBoxWrong2 = findViewById(R.id.question_ten_option_four_checkBox);
        if (!answerCheckBoxRight1.isChecked() && !answerCheckBoxRight2.isChecked() && !answerCheckBoxWrong1.isChecked() & !answerCheckBoxWrong2.isChecked()) {
        } else {
            count++;
        }

        return count;

    }

    /**
     * This method is called to reset the Quiz
     */
    public void resetQuiz(View view) {

        //Reset Question 1
        radioGroup = findViewById(R.id.question_one_radioGroup);
        setStateRadioButtons(radioGroup, true);
        answerRadioButton = findViewById(R.id.question_one_option_one_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_one_option_two_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_one_option_three_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_one_option_four_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        radioGroup.clearCheck();

        //Reset Question 2
        radioGroup = findViewById(R.id.question_two_radioGroup);
        setStateRadioButtons(radioGroup, true);
        answerRadioButton = findViewById(R.id.question_two_option_one_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_two_option_two_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_two_option_three_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_two_option_four_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        radioGroup.clearCheck();

        //Reset Question 3
        answerCheckBoxRight1 = findViewById(R.id.question_three_option_one_checkBox);
        answerCheckBoxRight2 = findViewById(R.id.question_three_option_two_checkBox);
        answerCheckBoxWrong1 = findViewById(R.id.question_three_option_three_checkBox);
        answerCheckBoxWrong2 = findViewById(R.id.question_three_option_four_checkBox);
        answerCheckBoxRight1.setChecked(false);
        answerCheckBoxRight2.setChecked(false);
        answerCheckBoxWrong1.setChecked(false);
        answerCheckBoxWrong2.setChecked(false);
        setColorText(answerCheckBoxRight1, Color.BLACK);
        setColorText(answerCheckBoxRight2, Color.BLACK);
        setColorText(answerCheckBoxWrong1, Color.BLACK);
        setColorText(answerCheckBoxWrong2, Color.BLACK);
        setStateCheckBox(answerCheckBoxRight1, answerCheckBoxRight2, answerCheckBoxWrong1, answerCheckBoxWrong2, true);

        //Reset Question 4
        radioGroup = findViewById(R.id.question_four_radioGroup);
        setStateRadioButtons(radioGroup, true);
        answerRadioButton = findViewById(R.id.question_four_option_one_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_four_option_two_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_four_option_three_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_four_option_four_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        radioGroup.clearCheck();

        //Reset Question 5
        radioGroup = findViewById(R.id.question_five_radioGroup);
        setStateRadioButtons(radioGroup, true);
        answerRadioButton = findViewById(R.id.question_five_option_one_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_five_option_two_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_five_option_three_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_five_option_four_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        radioGroup.clearCheck();

        //Reset Question 6
        answerEditText = findViewById(R.id.question_six);
        answerEditText.setText(null);
        answerEditText.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
        setColorText(answerEditText, Color.BLACK);

        //Reset Question 7
        radioGroup = findViewById(R.id.question_seven_radioGroup);
        setStateRadioButtons(radioGroup, true);
        answerRadioButton = findViewById(R.id.question_seven_option_one_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_seven_option_two_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_seven_option_three_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_seven_option_four_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        radioGroup.clearCheck();

        //Reset Question 8
        answerEditText = findViewById(R.id.question_eight);
        answerEditText.setText(null);
        answerEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        setColorText(answerEditText, Color.BLACK);

        //Reset Question 9
        radioGroup = findViewById(R.id.question_nine_radioGroup);
        setStateRadioButtons(radioGroup, true);
        answerRadioButton = findViewById(R.id.question_nine_option_one_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_nine_option_two_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_nine_option_three_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        answerRadioButton = findViewById(R.id.question_nine_option_four_radioButton);
        setColorText(answerRadioButton, Color.BLACK);
        radioGroup.clearCheck();

        //Reset Question 10
        answerCheckBoxRight1 = findViewById(R.id.question_ten_option_one_checkBox);
        answerCheckBoxRight2 = findViewById(R.id.question_ten_option_two_checkBox);
        answerCheckBoxWrong1 = findViewById(R.id.question_ten_option_three_checkBox);
        answerCheckBoxWrong2 = findViewById(R.id.question_ten_option_four_checkBox);
        answerCheckBoxRight1.setChecked(false);
        answerCheckBoxRight2.setChecked(false);
        answerCheckBoxWrong1.setChecked(false);
        answerCheckBoxWrong2.setChecked(false);
        setColorText(answerCheckBoxRight1, Color.BLACK);
        setColorText(answerCheckBoxRight2, Color.BLACK);
        setColorText(answerCheckBoxWrong1, Color.BLACK);
        setColorText(answerCheckBoxWrong2, Color.BLACK);
        setStateCheckBox(answerCheckBoxRight1, answerCheckBoxRight2, answerCheckBoxWrong1, answerCheckBoxWrong2, true);

        findViewById(R.id.submit_button).setEnabled(true);

        answerRadioButton = null;
        answerCheckBoxRight1 = null;
        answerCheckBoxRight2 = null;
        answerCheckBoxWrong1 = null;
        answerCheckBoxWrong2 = null;
        answerEditText = null;
        radioGroup = null;
        score = 0;
        count = 0;

    }

}
