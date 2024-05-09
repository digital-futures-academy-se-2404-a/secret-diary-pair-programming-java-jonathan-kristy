package com.dfcorp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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

        // User Story 1
        @Test
        @DisplayName("Should add diary entry")
        public void diaryAddEntry() {
            // Arrange
            Entry testEntry = mock(Entry.class);
            // Act
            testDiary.addEntry(testEntry);
            // Assert
            assertEquals(testDiary.getEntries().size(), 1);
        }

        // User Story 2
        @Test
        @DisplayName("Should not add diary entry when it's locked")
        public void diaryNotToAddEntryIfLocked() {
            // Arrange
            Entry testEntry = mock(Entry.class);
            // Act
            testDiary.isLocked(true);
            testDiary.addEntry(testEntry);
            // Assert
            assertNull(testDiary.getEntries());
        }

        // User story 3
        @Test
        @DisplayName("Should display diary entries if unlocked")
        public void getEntriesShouldReturnListOfEntriesIfDiaryUnlocked() {
            // Arrange
            Entry testEntry = mock(Entry.class);
            testDiary.addEntry(testEntry);

            // Act
            ArrayList<Entry> entries = testDiary.getEntries();

            // Assert
            assertEquals(entries.get(0), testEntry);
        }

        // User story 4
        @Test
        @DisplayName("Should not display diary entries if locked")
        public void getEntriesShouldNotReturnListOfEntriesIfDiaryLocked() {
            // Arrange
            Entry testEntry = mock(Entry.class);
            testDiary.addEntry(testEntry);

            // Act
            testDiary.isLocked(true);
            ArrayList<Entry> entries = testDiary.getEntries();

            // Assert
            assertNull(entries);
        }
    }

    @Nested
    @DisplayName("Diary Locking tests")
    class DiaryLockingTests {
        // User story 5
        @Test
        @DisplayName("Should be able to lock the diary")
        public void shouldLockDiary() {
            // Arrange
            // Act
            testDiary.isLocked(true);

            // Assert
            assertTrue(testDiary.isLocked());
        }

        // User Story 6
        @Test
        @DisplayName("Should not unlock diary if pin is incorrect")
        public void diaryStayLockedWithIncorrectPin() {
            // Arrange
            Entry testEntry = mock(Entry.class);
            testDiary.addEntry(testEntry);
            testDiary.isLocked(true);
            // Act
            testDiary.unlock(2345);
            // Assert
            assertNull(testDiary.getEntries());
        }

        // User story 7
        @Test
        @DisplayName("Should unlock diary if pin is correct")
        public void diaryShouldUnlockWithCorrectPin() {
            testDiary.isLocked(true);
            testDiary.unlock(1234);

            assertFalse(testDiary.isLocked());
        }
    }
}
