package com.example.jang.db_project_admin;
//
//import android.app.Activity;
//import android.graphics.Typeface;
//import android.os.Bundle;
//import android.util.TypedValue;
//import android.view.Gravity;
//import android.widget.TableLayout;
//import android.widget.*;
//
///**
// * Created by Jang on 2016-07-29.
// */
//public class TestActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        super.onCreate(savedInstanceState);
//
//        TableLayout table = new TableLayout(this);
//
//        table.setStretchAllColumns(true);
//        table.setShrinkAllColumns(true);
//
//        TableRow rowTitle = new TableRow(this);
//        rowTitle.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        TableRow rowDayLabels = new TableRow(this);
//        TableRow rowHighs = new TableRow(this);
//        TableRow rowLows = new TableRow(this);
//        TableRow rowConditions = new TableRow(this);
//        rowConditions.setGravity(Gravity.CENTER);
//
//        TextView empty = new TextView(this);
//
//        // title column/row
//        TextView title = new TextView(this);
//        title.setText("Java Weather Table");
//
//        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
//        title.setGravity(Gravity.CENTER);
//        title.setTypeface(Typeface.SERIF, Typeface.BOLD);
//
//        TableRow.LayoutParams params = new TableRow.LayoutParams();
//        params.span = 6;
//
//        rowTitle.addView(title, params);
//
//        // labels column
//        TextView highsLabel = new TextView(this);
//        highsLabel.setText("Day High");
//        highsLabel.setTypeface(Typeface.DEFAULT_BOLD);
//
//        TextView lowsLabel = new TextView(this);
//        lowsLabel.setText("Day Low");
//        lowsLabel.setTypeface(Typeface.DEFAULT_BOLD);
//
//        TextView conditionsLabel = new TextView(this);
//        conditionsLabel.setText("Conditions");
//        conditionsLabel.setTypeface(Typeface.DEFAULT_BOLD);
//
//        rowDayLabels.addView(empty);
//        rowHighs.addView(highsLabel);
//        rowLows.addView(lowsLabel);
//        rowConditions.addView(conditionsLabel);
//
//        // day 1 column
//        TextView day1Label = new TextView(this);
//        day1Label.setText("Feb 7");
//        day1Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
//
//        TextView day1High = new TextView(this);
//        day1High.setText("28°F");
//        day1High.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        TextView day1Low = new TextView(this);
//        day1Low.setText("15°F");
//        day1Low.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        ImageView day1Conditions = new ImageView(this);
//        day1Conditions.setImageResource(R.drawable.book);
//
//        rowDayLabels.addView(day1Label);
//        rowHighs.addView(day1High);
//        rowLows.addView(day1Low);
//        rowConditions.addView(day1Conditions);
//
//        // day2 column
//        TextView day2Label = new TextView(this);
//        day2Label.setText("Feb 8");
//        day2Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
//
//        TextView day2High = new TextView(this);
//        day2High.setText("26°F");
//        day2High.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        TextView day2Low = new TextView(this);
//        day2Low.setText("14°F");
//        day2Low.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        ImageView day2Conditions = new ImageView(this);
//        day2Conditions.setImageResource(R.drawable.book);
//
//        rowDayLabels.addView(day2Label);
//        rowHighs.addView(day2High);
//        rowLows.addView(day2Low);
//        rowConditions.addView(day2Conditions);
//
//        // day3 column
//        TextView day3Label = new TextView(this);
//        day3Label.setText("Feb 9");
//        day3Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
//
//        TextView day3High = new TextView(this);
//        day3High.setText("23°F");
//        day3High.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        TextView day3Low = new TextView(this);
//        day3Low.setText("3°F");
//        day3Low.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        ImageView day3Conditions = new ImageView(this);
//        day3Conditions.setImageResource(R.drawable.book);
//
//        rowDayLabels.addView(day3Label);
//        rowHighs.addView(day3High);
//        rowLows.addView(day3Low);
//        rowConditions.addView(day3Conditions);
//
//        // day4 column
//        TextView day4Label = new TextView(this);
//        day4Label.setText("Feb 10");
//        day4Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
//
//        TextView day4High = new TextView(this);
//        day4High.setText("17°F");
//        day4High.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        TextView day4Low = new TextView(this);
//        day4Low.setText("5°F");
//        day4Low.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        ImageView day4Conditions = new ImageView(this);
//        day4Conditions.setImageResource(R.drawable.book);
//
//        rowDayLabels.addView(day4Label);
//        rowHighs.addView(day4High);
//        rowLows.addView(day4Low);
//        rowConditions.addView(day4Conditions);
//
//        // day5 column
//        TextView day5Label = new TextView(this);
//        day5Label.setText("Feb 11");
//        day5Label.setTypeface(Typeface.SERIF, Typeface.BOLD);
//
//        TextView day5High = new TextView(this);
//        day5High.setText("19°F");
//        day5High.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        TextView day5Low = new TextView(this);
//        day5Low.setText("6°F");
//        day5Low.setGravity(Gravity.CENTER_HORIZONTAL);
//
//        ImageView day5Conditions = new ImageView(this);
//        day5Conditions.setImageResource(R.drawable.book);
//
//        rowDayLabels.addView(day5Label);
//        rowHighs.addView(day5High);
//        rowLows.addView(day5Low);
//        rowConditions.addView(day5Conditions);
//
//        table.addView(rowTitle);
//        table.addView(rowDayLabels);
//        table.addView(rowHighs);
//        table.addView(rowLows);
//        table.addView(rowConditions);
//
//        setContentView(table);
//    }
//}

//import android.app.Activity;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TextView;
//
//public class TestActivity extends Activity {
//    /**
//     * Called when the activity is first created.
//     */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.main);
//
////        MyFrameLayout myFrameLayout = new MyFrameLayout(this);
//        MyTableLayout myTableLayout = new MyTableLayout(this);
//
////        MyLinearLayout myLinearLayout = new MyLinearLayout(this);
//
//        setContentView(myTableLayout);
//    }
//
//}
//
//import android.app.Activity;
//import android.content.Context;
//import android.location.Address;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.TableLayout;
//import android.widget.TableRow;
//import android.widget.TableRow.LayoutParams;
//import android.widget.TextView;
//
//
//public class TestActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//               /* Find Tablelayout defined in main.xml */
//        TableLayout tl = (TableLayout) findViewById(R.id.myTableLayout);
//
//               /* Create a new row to be added. */
//        for (int i = 0; i < 3; i++) {
//            TableRow tr = new TableRow(this);
//            tr.setLayoutParams(new TableRow.LayoutParams(LayoutParams.FILL_PARENT,
//                    LayoutParams.WRAP_CONTENT));
//
//                       /* Create a Button to be the row-content. */
//            Button b = new Button(this);
//            b.setText("Dynamic Button");
//            b.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
//                    LayoutParams.WRAP_CONTENT));
//
//                       /* Add Button to row. */
//
//            tr.addView(b);
//            Button c = new Button(this);
//            c.setText("Dynamic Button2");
//            c.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
//                    LayoutParams.WRAP_CONTENT));
//
//                       /* Add Button to row. */
//            tr.addView(c);
//
//                       /* Add row to TableLayout. */
//            tl.addView(tr, new LayoutParams(
//                    LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
//        }
//    }
//}

//import android.app.Activity;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TableRow;
//import android.widget.TextView;
//import android.widget.TableRow.LayoutParams;
//public class TestActivity extends Activity{
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        View child = (View)getLayoutInflater().inflate(R.layout.child_textview, null);
//        TextView tv = (TextView)child.findViewById(R.id.childtv);
//
//        //AddView
//        rowTitle.addView(child);
//        rowTitle.setBackgroundResource(R.drawable.tableboder);
//
//        View child2 = (View)getLayoutInflater().inflate(R.layout.child_textview02, null);
//        TextView tv2 = (TextView)child2.findViewById(R.id.childtv02);
//        //AddView
//        rowContent.addView(child2);
//        rowContent.setBackgroundResource(R.drawable.tableboder);
//
//        TextView line = new TextView(getApplicationContext());
//        line.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2));
//        line.setBackgroundColor(Color.BLACK);
//
////TableLayout 에 addView
//        _tbLayout02.addView(rowTitle);
//        _tbLayout02.addView(line);  //line 추가
//        _tbLayout02.addView(rowContent);
//
//        //Invalidate
//        _tbLayout02.invalidate();
//    }
//}

//import java.util.ArrayList;
//        import java.util.List;
//        import android.app.Activity;
//        import android.app.AlertDialog;
//        import android.content.Context;
//        import android.content.Intent;
//        import android.database.Cursor;
//        import android.database.sqlite.SQLiteDatabase;
//        import android.graphics.Color;
//        import android.os.Bundle;
//        import android.text.Html;
//        import android.util.Log;
//        import android.view.LayoutInflater;
//        import android.view.MotionEvent;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.view.Window;
//        import android.view.ViewGroup.LayoutParams;
//        import android.widget.Button;
//        import android.widget.ImageButton;
//        import android.widget.LinearLayout;
//        import android.widget.TableLayout;
//        import android.widget.TableRow;
//        import android.widget.TextView;
//
//
//public class TestActivity extends Activity{
//    private static final String DEBUG_TAG = "FullDatabase Log";
//    private DBManager dbManager;
//    private SQLiteDatabase db;
//    Cursor cursor;
//
//    private String PHR_ID = "";
//    private String PAGE_COUNT = "";
//
//    private LinearLayout llayout;
//    private TableLayout tbl;
//    private int i;
//
//    /** Called when the activity is first created. */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 제거
//        setContentView(R.layout.test_layout);
//
//
//        /** 이전 액티비티에서 데이터 받기 */
//        Intent intent = getIntent();
//        PHR_ID = intent.getStringExtra("PHR_ID");
//        PAGE_COUNT = intent.getStringExtra("PAGE_COUNT");
//
//        /** 리스트 가져오기 */
//        try
//        {
//            dbManager = new DBManager(getBaseContext(), "*.sqlite", null, 1);
//            db = dbManager.openDB();
//            String ELEMENT = "'17893','17992','17993'";
//            cursor = dbManager.SqlListNew("Alerts", PHR_ID, ELEMENT);
//            startManagingCursor(cursor);
//            cursor.moveToFirst();
//        }
//        catch (Exception e)
//        {
//            e.getMessage();
//            Log.i(DEBUG_TAG,  "Error: " + e.getMessage());
//        }
//        finally
//        {
//            if(db != null)    db.close();
//        }
//
//        if(cursor.getCount() == 0){
//            alert();
//        }
//        //select Value, Initial_Update,Status_Flag,Advancedirective_ID from advancedirectives where PHR_ID= 1 order by Last_Update Limit 5
//
//        llayout = (LinearLayout) findViewById(R.id.hrviewtowList);
//        tbl = (TableLayout) findViewById(R.id.hrviewtowTable);
//        tbl.removeAllViews();
//
//        List<String> rs1 = new ArrayList<String>();
//        List<String> rs2 = new ArrayList<String>();
//        List<String> rs3 = new ArrayList<String>();
//        List<String> rs4 = new ArrayList<String>();
//        List<String> rs5 = new ArrayList<String>();
//
//        for(i=0; i < cursor.getCount(); i++){
//
//            rs1.add(cursor.getString(0));
//            rs2.add(cursor.getString(1)); // 실제값
//            rs3.add(cursor.getString(3)); // 날짜
//            rs4.add(cursor.getString(4)); // TupleId
//            rs5.add(cursor.getString(5)); // status_flag
//            cursor.moveToNext();
//        }
//
//
//        int lcnt = 3;
//        int cnt = cursor.getCount() / lcnt ;
//        for(i=0; i < cnt ; i++){
//
//            final TableRow tr =  new TableRow(this);
//            tr.setLayoutParams(new LayoutParams(
//                    android.view.ViewGroup.LayoutParams.FILL_PARENT,
//                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
//            tr.setGravity(android.view.Gravity.CENTER);
//
//            //if(i == 0) tr.setBackgroundColor(0xFF32A4FF);
//
//            final LinearLayout ll = new LinearLayout(this);
//            TableRow.LayoutParams lParms=new TableRow.LayoutParams(
//                    android.widget.LinearLayout.LayoutParams.FILL_PARENT,
//                    android.widget.LinearLayout.LayoutParams.FILL_PARENT);
//            ll.setOrientation(LinearLayout.VERTICAL);
//            ll.setLayoutParams(lParms);
//            ll.setPadding(5, 5, 5, 5);
//            ll.setFocusable(true);
//
//            LinearLayout lh = new LinearLayout(this);
//            TableRow.LayoutParams lParmsh=new TableRow.LayoutParams(
//                    android.widget.LinearLayout.LayoutParams.FILL_PARENT,
//                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
//            lh.setOrientation(LinearLayout.HORIZONTAL);
//            lh.setLayoutParams(lParmsh);
//            lh.setPadding(0, 0, 0, 0);
//
//
//            final TextView btn1 = new TextView(this);
//            btn1.setText(Html.fromHtml("<b>"+rs2.get(0 + (i*lcnt))+" : "+rs2.get(1 + (i*lcnt))+"</b>"));
//            btn1.setPadding(0, 0, 0, 0);
//            btn1.setGravity(android.view.Gravity.LEFT);
//            btn1.setLayoutParams(new LayoutParams(330,
//                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
//            btn1.setTextSize(15);
//            if("1".equals(rs5.get(0+(i*lcnt)))) btn1.setTextColor(0xFF1E90FF);
//            else btn1.setTextColor(0xFFCCCCCC);
//
//
//            final TextView btn0 = new TextView(this);
//            btn0.setText(Html.fromHtml(rs3.get(0 + (i*lcnt)).replaceAll("/", ".").substring(0, 10)));
//            btn0.setPadding(0, 0, 0, 0);
//            btn0.setGravity(android.view.Gravity.LEFT);
//            btn0.setLayoutParams(new LayoutParams(100,
//                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
//            btn0.setTextSize(13);
//
//
//
//            final TextView btn2 = new TextView(this);
//            btn2.setText(rs2.get(2 + (i*lcnt)));
//            btn2.setPadding(0, 0, 0, 0);
//            btn2.setGravity(android.view.Gravity.LEFT);
//            btn2.setLayoutParams(new LayoutParams(430,
//                    android.view.ViewGroup.LayoutParams.WRAP_CONTENT));
//            btn2.setTextSize(14);
//            //btn2.setTextColor(0xFF000000);
//
//            if("1".equals(rs5.get(0+(i*lcnt)))) btn2.setTextColor(0xFF000000);
//            else btn2.setTextColor(0xFFCCCCCC);
//
//            TextView btn4 = new TextView(this);
//            btn4.setHeight(10);
//
//            lh.addView(btn1);
//            lh.addView(btn0);
//
//            ll.addView(lh);
//            ll.addView(btn2);
//            //ll.addView(btn4);
//
//            final String SEQ_ID = rs4.get(0 + (i*lcnt));
//
//            ll.setOnClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View v) {
//
//                    Intent intent = new Intent(HrListThr.this,HrViewManager.class);
//                    intent.putExtra("PHR_ID", PHR_ID);
//                    intent.putExtra("SEQ_ID", SEQ_ID);
//                    intent.putExtra("PAGE_COUNT", PAGE_COUNT);
//                    intent.putExtra("CATEGORY_ID", "8");
//                    startActivityForResult(intent, 1);
//
//                }});
//
//            ll.setOnTouchListener(new View.OnTouchListener(){
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    // TODO Auto-generated method stub
//
//                    switch (event.getAction()) {
//
//                        case MotionEvent.ACTION_DOWN:
//                            tr.setBackgroundColor(0xFF32A4FF);
//                            break;
//
//                        case MotionEvent.ACTION_UP:
//                            tr.setBackgroundColor(Color.TRANSPARENT);
//
//                            Intent intent = new Intent(HrListThr.this,HrViewManager.class);
//                            intent.putExtra("PHR_ID", PHR_ID);
//                            intent.putExtra("SEQ_ID", SEQ_ID);
//                            intent.putExtra("PAGE_COUNT", PAGE_COUNT);
//                            intent.putExtra("CATEGORY_ID", "8");
//                            startActivityForResult(intent, 1);
//
//                            break;
//
//                        default: tr.setBackgroundColor(Color.TRANSPARENT);
//                            break;
//
//                    }
//
//
//                    return true;
//                }});
//
//
//            tr.addView(ll);
//            tbl.addView(tr);
//            View vw = new View(this);
//            LayoutParams lParmsv=new LayoutParams(
//                    android.widget.LinearLayout.LayoutParams.FILL_PARENT,3);  // 줄만들기
//            vw.setLayoutParams(lParmsv);
//            vw.setBackgroundResource(R.drawable.img_bg);
//
//
//            if(i !=  cursor.getCount() -1 ) tbl.addView(vw);
//
//            cursor.moveToNext();
//        }
//
//        // 이전버튼 부모항목으로 링크
//        final ImageButton buttonBack =(ImageButton)findViewById(R.id.hrlistthrLeft);
//        buttonBack.setOnClickListener(new ImageButton.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(HrListThr.this, HealthRecordList.class);
//                intent.putExtra("PHR_ID", PHR_ID);
//                intent.putExtra("PAGE_COUNT", PAGE_COUNT);
//                startActivityForResult(intent, 1);
//            }
//        });
//
//
//        // 추가버튼  화면 링크
//        final ImageButton buttonEdit =(ImageButton)findViewById(R.id.hrlistthrRight);
//        buttonEdit.setOnClickListener(new ImageButton.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(HrListThr.this, HrAddManager.class);
//                intent.putExtra("PHR_ID", PHR_ID);
//                intent.putExtra("PAGE_COUNT", PAGE_COUNT);
//                intent.putExtra("CATEGORY_ID", "8");
//                startActivityForResult(intent, 1);
//
//            }
//        });
//
//    }
//
//    AlertDialog ads ;
//    public void alert(){
//
//        Context mContext = getApplicationContext();
//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
//        final View layout = inflater.inflate(R.layout.error_dialog,(ViewGroup) findViewById(R.id.layout_root));
//
//        final AlertDialog.Builder aDialog = new AlertDialog.Builder(HrListThr.this);//여기서buttontest는 패키지이름
//        aDialog.setTitle("데이터가 없습니다.");
//        aDialog.setView(layout);
//
//
//        // 확인 버튼 링크
//        final Button loginy =(Button)layout.findViewById(R.id.loginY);
//        loginy.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//
//                Intent intent = new Intent(HrListThr.this, HealthRecordList.class);
//                intent.putExtra("PHR_ID", PHR_ID);
//                intent.putExtra("PAGE_COUNT", PAGE_COUNT);
//                startActivityForResult(intent, 1);
//
//            }
//        });
//        // 추가 버튼 링크
//        final Button loginn =(Button)layout.findViewById(R.id.loginN);
//        loginn.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//
//                Intent intent = new Intent(HrListThr.this, HrAddManager.class);
//                intent.putExtra("PHR_ID", PHR_ID);
//                intent.putExtra("PAGE_COUNT", PAGE_COUNT);
//                intent.putExtra("CATEGORY_ID", "8");
//                startActivityForResult(intent, 1);
//
//            }
//        });
//
//
//        ads = aDialog.create();
//        ads.show();
//    }
//}

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.app.Activity;
import android.widget.TextView;
//
//public class TestActivity extends Activity{
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test_layout);
//        tableGrid(5,5);
//    }
//
//    public void tableGrid(int trCt, int tdCt) {
//        TableRow.LayoutParams rowLayout = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//        TableLayout table = new TableLayout(this); // 테이블 생성
//        TableRow row[] = new TableRow[trCt];     // 테이블 ROW 생성
//        TextView text[][] = new TextView[trCt][tdCt]; // 데이터
//
//        for (int tr = 0; tr < trCt; tr++) {                  // for문을 이용한 줄수 (TR)
//
//            row[tr] = new TableRow(this);
//
//            for (int td = 0; td < tdCt; td++) {              // for문을 이용한 칸수 (TD)
//
//                text[tr][td] = new TextView(this);
//                text[tr][td].setText("데이터");                   // 데이터삽입
//                text[tr][td].setTextSize(15);                     // 폰트사이즈
//                text[tr][td].setTextColor(Color.BLACK);     // 폰트컬러
//                text[tr][td].setGravity(Gravity.CENTER);    // 폰트정렬
//
//                row[tr].addView(text[tr][td]);
//
//            } // td for end
//
//            table.addView(row[tr], rowLayout);
//
//        } // tr for end
//    }
//}

//public class TestActivity extends Activity{
//
//    int i = 10; // input no of row
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);  // set here your layout xml name
//
//        //TableLayout tl = new TableLayout(MainScreen.this);
//        TableLayout tl = (TableLayout) findViewById(R.id.myTableLayout);
//        for (int k = 0; k < i; k++) {
//
//            TableRow tr = new TableRow(TestActivity.this);
//            tr.layout(0, 0, 0, 0);
//            TextView ids = new TextView(TestActivity.this);
//            ids.setText("hi");
//            ids.setPadding(30, 15, 30, 15);
//            TextView loc = new TextView(TestActivity.this);
//            loc.setText("d");
//            loc.setPadding(30, 15, 30, 15);
//            tr.setPadding(0, 1, 0, 0);
//            tr.addView(ids);
//            tr.addView(loc);
//            tr.setId(k); // here you can set unique id to TableRow for
//            // identification
////            tr.setOnClickListener(getApplicationContext()); // set TableRow onClickListner
//            tl.addView(tr, new TableLayout.LayoutParams(
//                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//
//        }
//
//        //setContentView(tl);
//    }
//
////    @Override
//    public void onClick(View v) {
//        // TODO Auto-generated method stub
//
//        int clicked_id = v.getId(); // here you get id for clicked TableRow
//
//        // now you can get value like this
//
//        String ids = "2";
//        String loc = "3";
//
//    }
//}


//
//public class TestActivity extends AppCompatActivity{
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Get the ViewPager and set it's PagerAdapter so that it can display items
//        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
//        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),
//                MainActivity.this));
//
//        // Give the TabLayout the ViewPager
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
//        tabLayout.setupWithViewPager(viewPager);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}

public class TestActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tab_host = (TabHost) findViewById(R.id.tabhost);
        tab_host.setup();

        TabHost.TabSpec ts1 = tab_host.newTabSpec("tab1");
        ts1.setIndicator("tab1");
        ts1.setContent(R.id.tab1);
        tab_host.addTab(ts1);

        TabHost.TabSpec ts2 = tab_host.newTabSpec("tab2");
        ts2.setIndicator("tab2");
        ts2.setContent(R.id.tab2);
        tab_host.addTab(ts2);


        tab_host.setCurrentTab(0);
    }
}