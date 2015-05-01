# SimpleNumberPicker

![alt tag](https://github.com/kidinov/SimpleNumberPicker/blob/master/app/publ/ezgif.com-gif-maker.gif)

Simple UI component to make process of picking number faster and better looking .Built upon of RecycleView. Support horizontal and vertical orientation.

# Usage
            <org.kidinov.snp_lib.SimpleNumberPicker
                android:id="@+id/vertical_1"
                android:layout_width="100dp"
                android:layout_height="250dp"
                app:min="100"
                app:max="500"
                app:smallTextColor="#FFC107"
                app:bigTextColor="#ff8a5600"
                app:smallTextSize="5sp"
                app:bigTextSize="12sp"
                app:animationType="slide_in_right" [scale | alpha | slide_in_bottom | slide_in_right | slide_in_left | slide_in_left]
                app:notchSize="10dp"
                app:notchColor="#ff4a4533"
                app:vertical="true"
                app:delimNumber="5"
                />

        ((SimpleNumberPicker) findViewById(R.id.vertical_1)).setOnNewValueSelectedListener(new                                             OnNewValueSelectedListener() {
            @Override
            public void newValueSelected(int value) {
                ((TextView) findViewById(R.id.vertical_1_v)).setText(String.valueOf(value));
            }
        });
