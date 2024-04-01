package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.schedule.Schedule;
import seedu.address.testutil.TypicalSchedule;

public class JsonSerializableScheduleTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableScheduleTest");
    private static final Path TYPICAL_SCHEDULE_FILE = TEST_DATA_FOLDER.resolve("typicalSchedule.json");
    private static final Path INVALID_DATE_SCHEDULE_FILE = TEST_DATA_FOLDER.resolve("invalidDateSchedule.json");
    private static final Path INVALID_PERSON_SCHEDULE_FILE = TEST_DATA_FOLDER.resolve("invalidDateSchedule.json");

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        JsonSerializableSchedule dataFromFile = JsonUtil.readJsonFile(TYPICAL_SCHEDULE_FILE,
                JsonSerializableSchedule.class).get();
        Schedule scheduleFromFile = dataFromFile.toModelType();
        Schedule typicalPersonsSchedule = TypicalSchedule.getTypicalSchedule();
        assertEquals(scheduleFromFile, typicalPersonsSchedule);
    }

    @Test
    public void toModelType_invalidDateFile_throwsIllegalValueException() throws Exception {
        JsonSerializableSchedule dataFromFile = JsonUtil.readJsonFile(INVALID_DATE_SCHEDULE_FILE,
                JsonSerializableSchedule.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableSchedule dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_SCHEDULE_FILE,
                JsonSerializableSchedule.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

}
