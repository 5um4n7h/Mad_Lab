package com.sumanth.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	//declaring view items
	Button One;
	Button Two;
	Button Three;
	Button Four;
	Button Five;
	Button Six;
	Button Seven;
	Button Eight;
	Button Nine;
	Button Zero;
	Button Plus;
	Button Minus;
	Button Multiply;
	Button Devide;
	Button Clear;
	Button Equal;
	Button Dot;
	EditText Input;
	TextView Result;

	//for calculation
	Double op1;
	Double op2;
	String op;
	Boolean hasOp = false;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		One = findViewById(R.id.btnOne);
		Two = findViewById(R.id.btnTwo);
		Three = findViewById(R.id.btnThree);
		Four = findViewById(R.id.btnFour);
		Five = findViewById(R.id.btnFive);
		Six = findViewById(R.id.btnSix);
		Seven = findViewById(R.id.btnSeven);
		Eight = findViewById(R.id.btnEight);
		Nine = findViewById(R.id.btnNine);
		Zero = findViewById(R.id.btnZero);
		Dot = findViewById(R.id.btnDot);
		Plus = findViewById(R.id.btnPlus);
		Minus = findViewById(R.id.btnMinus);
		Devide = findViewById(R.id.btnDevide);
		Multiply = findViewById(R.id.btnMultiply);
		Equal = findViewById(R.id.btnEqual);
		Clear = findViewById(R.id.btnClear);
		Input = findViewById(R.id.etInput);
		Result = findViewById(R.id.tvResult);


		One.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "1");
		});

		Two.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "2");
		});

		Three.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "3");
		});

		Four.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "4");
		});

		Five.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "5");
		});

		Six.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "6");
		});

		Seven.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "7");
		});

		Eight.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "8");
		});

		Nine.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "9");
		});

		Zero.setOnClickListener(v -> {
			checkForOp();
			Input.setText(Input.getText() + "0");
		});

		Dot.setOnClickListener(v -> {
			Input.setText(Input.getText() + ".");
		});

		Plus.setOnClickListener(v -> {
			if (hasOp) {
				Toast.makeText(this, "Please provide correct Input", Toast.LENGTH_SHORT).show();
			} else {

				op = "plus";
				opPressed();
				hasOp = true;

				Input.setText("+");
			}
		});

		Minus.setOnClickListener(v -> {
			if (hasOp) {
				Toast.makeText(this, "Please provide correct Input", Toast.LENGTH_SHORT).show();
			} else {

				op = "minus";
				opPressed();
				hasOp = true;

				Input.setText("-");
			}
		});
		Multiply.setOnClickListener(v -> {
			if (hasOp) {
				Toast.makeText(this, "Please provide correct Input", Toast.LENGTH_SHORT).show();
			} else {

				op = "multiply";
				opPressed();
				hasOp = true;

				Input.setText("*");
			}
		});

		Devide.setOnClickListener(v -> {
			if (hasOp) {
				Toast.makeText(this, "Please provide correct Input", Toast.LENGTH_SHORT).show();
			} else {

				op = "devide";
				opPressed();
				hasOp = true;

				Input.setText("/");
			}
		});

		Equal.setOnClickListener(v -> {
			String strOp2 = Input.getText().toString();
			try {
				op2 = Double.parseDouble(strOp2);
				Calculate();
			} catch (Exception e) {
				Toast.makeText(this, "Please provide correct Input", Toast.LENGTH_SHORT).show();
			}

		});

		Clear.setOnClickListener(v -> {
			Result.setText("");
			Input.setText("");
			op1 = null;
			op = null;
			op2 = null;
			hasOp = false;
		});
	}

	private void checkForOp() {

		if (Input.getText().toString().equals("+") ||
				Input.getText().toString().equals("-") ||
				Input.getText().toString().equals("*") ||
				Input.getText().toString().equals("/")) {
			Input.setText("");
		}
	}

	private void opPressed() {

		op1 = Double.parseDouble(Input.getText().toString());


	}


	private void Calculate() {
		double result;
		switch (op) {
			case "plus":
				result = op1 + op2;
				break;
			case "minus":
				result = op1 - op2;
				break;
			case "devide":
				result = op1 / op2;
				break;
			default:
				result = op1 * op2;
		}
		Result.setText(Double.toString(result));

		hasOp = false;
	}
}