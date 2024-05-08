package com.dfcorp;

import java.util.ArrayList;

public class Diary {
    private ArrayList<Entry> entries;
    private Boolean isLocked;
    private final int defaultPin = 1234;

    Diary() {
        entries = new ArrayList<>();
        isLocked = false;
    }

    public void unlock(int pin) {
        if(pin == defaultPin) this.isLocked = false;
    }

    public void addEntry(Entry entry) {
        if (!this.isLocked) { entries.add(entry); }
    }

    public ArrayList<Entry> getEntries() {
        if(!this.isLocked) return entries;
        else return null;
    }

    public Boolean isLocked() { return this.isLocked; }
    public void isLocked(boolean isLocked) { this.isLocked = isLocked; }

}
