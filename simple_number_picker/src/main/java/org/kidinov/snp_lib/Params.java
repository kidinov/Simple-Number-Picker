package org.kidinov.snp_lib;

/**
 * Created by akid on 30/04/15.
 */
public class Params {
    private int smallTextColor;
    private int bigTextColor;
    private float smallTextSize;
    private float bigTextSize;
    private float notchSize;
    private int notchColor;
    private int delimNumber;
    private int min;
    private int max;
    private boolean vertical;

    public Params(int smallTextColor, int bigTextColor, float smallTextSize, float bigTextSize, float notchSize, int notchColor, int delimNumber, int min, int max, boolean vertical) {
        this.smallTextColor = smallTextColor;
        this.bigTextColor = bigTextColor;
        this.smallTextSize = smallTextSize;
        this.bigTextSize = bigTextSize;
        this.notchSize = notchSize;
        this.notchColor = notchColor;
        this.delimNumber = delimNumber;
        this.min = min;
        this.max = max;
        this.vertical = vertical;
    }

    public int getSmallTextColor() {
        return smallTextColor;
    }

    public int getBigTextColor() {
        return bigTextColor;
    }

    public float getSmallTextSize() {
        return smallTextSize;
    }

    public float getBigTextSize() {
        return bigTextSize;
    }

    public float getNotchSize() {
        return notchSize;
    }

    public int getNotchColor() {
        return notchColor;
    }

    public int getDelimNumber() {
        return delimNumber;
    }

    public boolean isVertical() {
        return vertical;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static class Builder {
        private int smallTextColor;
        private int bigTextColor;
        private float smallTextSize;
        private float bigTextSize;
        private float notchSize;
        private int notchColor;
        private int delimNumber;
        private boolean vertical;
        private int min;
        private int max;


        public Builder setSmallTextColor(int smallTextColor) {
            this.smallTextColor = smallTextColor;
            return this;
        }

        public Builder setBigTextColor(int bigTextColor) {
            this.bigTextColor = bigTextColor;
            return this;
        }

        public Builder setSmallTextSize(float smallTextSize) {
            this.smallTextSize = smallTextSize;
            return this;
        }

        public Builder setBigTextSize(float bigTextSize) {
            this.bigTextSize = bigTextSize;
            return this;
        }

        public Builder setNotchSize(float notchSize) {
            this.notchSize = notchSize;
            return this;
        }

        public Builder setNotchColor(int notchColor) {
            this.notchColor = notchColor;
            return this;
        }

        public Builder setDelimNumber(int delimNumber) {
            this.delimNumber = delimNumber;
            return this;
        }

        public Builder setVertical(boolean vertical) {
            this.vertical = vertical;
            return this;
        }

        public Builder setMin(int min) {
            this.min = min;
            return this;
        }

        public Builder setMax(int max) {
            this.max = max;
            return this;
        }

        public Params build() {
            return new Params(smallTextColor, bigTextColor, smallTextSize, bigTextSize, notchSize, notchColor, delimNumber, min, max, vertical);
        }

    }
}
