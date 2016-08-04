package com.example.jang.db_project_admin;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class MyTableLayout extends TableLayout {
    TableRow  [] tr;
    Button [] btn1;
    Button [] btn2;
    Button [] btn3;
    static int flag = 0;
    public MyTableLayout(Context context) {
        super(context);

        tr = new TableRow[10];
        btn1 = new Button[10];
        btn2 = new Button[10];
        btn3 = new Button[10];

        tr[flag] = new TableRow(context);
        tr[flag].setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT,1.0f));
            /* Create a Button to be the row-content. */
        btn1[flag] = new Button(context);
        btn1[flag].setText("Dynamic Button");
        btn1[flag].setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

			/* Create a Button to be the row-content. */
        btn2[flag] = new Button(context);
        btn2[flag].setText("Dynamic Button");
        btn2[flag].setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

        btn3[flag] = new Button(context);
        btn3[flag].setText("Dynamic Button");
        btn3[flag].setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT, 1.0f));

        Button btnadd = new Button(context);
        btnadd.setText("add button");
        btnadd.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM));
        btnadd.setOnClickListener(new View.OnClickListener() {               //취소할 때 다시 전 activity로 돌아감
            public void onClick(View view) {
                flag++;

                refreshDrawableState();
            }
        });
			/* Add Button to row. */

        tr[flag].addView(btn1[flag]);
        tr[flag].addView(btn2[flag]);
        tr[flag].addView(btn3[flag]);
			/* Add row to TableLayout. */
        this.addView(tr[flag], new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT));

        this.addView(btnadd, new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
                android.widget.TableRow.LayoutParams.WRAP_CONTENT,10.0f));



//		TableRow tr = new TableRow(context);
//		tr.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
//				android.widget.TableRow.LayoutParams.WRAP_CONTENT));
//		/* Create a Button to be the row-content. */
//		Button b = new Button(context);
//		b.setText("Dynamic Button");
//		b.setLayoutParams(new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
//				android.widget.TableRow.LayoutParams.WRAP_CONTENT));
//		/* Add Button to row. */
//		tr.addView(b);
//		/* Add row to TableLayout. */
//		this.addView(tr, new android.widget.TableRow.LayoutParams(android.widget.TableRow.LayoutParams.FILL_PARENT,
//				android.widget.TableRow.LayoutParams.WRAP_CONTENT));
//		


    }




}
