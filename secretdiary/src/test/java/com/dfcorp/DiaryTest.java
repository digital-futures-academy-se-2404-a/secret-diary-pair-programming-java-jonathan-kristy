package com.dfcorp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class DiaryTest {
    Diary testDiary;

    @BeforeEach
    public void setUp() {
        testDiary = new Diary();
    }

    @AfterEach
    public void unset() {
        testDiary = null;
    }

    @Nested
    @DisplayName("Diary AddEntry Tests")
    class DiaryAddEntryTests {

        // User story 1
        public void diaryAddEntry() {
            // Arrange
            // Act
            Entry testEntry = testDiary.addEntry(new Entry());
            // Assert
            assertEquals(testDiary.getEntries.size(), 1);
        }


        // User story 3
        @Test
        @DisplayName("Should display diary entries if unlocked")
        public void getEntriesShouldReturnListOfEntriesIfDiaryUnlocked() {
            // Arrange
            Entry testEntry = new Entry();
            testDiary.addEntry(testEntry);

            // Act
            ArrayList<Entry> entries = testDiary.getEntries();

            // Assert
            assertEquals(entries.get(0), testEntry);
        }
    }
}
