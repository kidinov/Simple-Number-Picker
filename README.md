# SimpleNumberPicker

![alt tag](https://github.com/kidinov/SimpleNumberPicker/blob/master/app/publ/ezgif.com-gif-maker.gif)

Simple UI component to make process of picking number faster and better looking . Built upon RecyclerView. Support horizontal and vertical orientation.

# Usage
            <org.kidinov.snp_lib.SimpleNumberPicker
                android:id="@+id/vertical_1"
                android:layout_width="100dp"
                android:layout_height="250dp"
                app:snp_min="100"
                app:snp_max="500"
                app:snp_smallTextColor="#FFC107"
                app:snp_bigTextColor="#ff8a5600"
                app:snp_smallTextSize="5sp"
                app:snp_bigTextSize="12sp"
                app:snp_animationType="slide_in_right"
                app:snp_notchSize="10dp"
                app:snp_notchColor="#ff4a4533"
                app:snp_vertical="true"
                app:snp_delimNumber="5"
                />

        ((SimpleNumberPicker) findViewById(R.id.vertical_1)).setOnNewValueSelectedListener(new                                             OnNewValueSelectedListener() {
            @Override
            public void newValueSelected(int value) {
                // Use selected value as you want
            }
        });
        
# Installation

            compile('com.github.kidinov:snp:1.0.1')
