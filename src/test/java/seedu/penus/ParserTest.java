package seedu.penus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.penus.exceptions.DuplicateModuleException;
import seedu.penus.exceptions.InvalidCommandException;
import seedu.penus.exceptions.InvalidFormatException;
import seedu.penus.exceptions.InvalidGradeException;
import seedu.penus.exceptions.InvalidModuleException;
import seedu.penus.exceptions.InvalidSemesterException;
<<<<<<< HEAD
import seedu.penus.exceptions.CourseIndexOutOfBoundsException;
=======
import seedu.penus.exceptions.InvalidYearException;
import seedu.penus.exceptions.InvalidIndexException;

>>>>>>> ad3d62fd00c02e7fef4e95aa9e3e3d8c4b597461
import seedu.penus.modules.ModuleList;
import seedu.penus.parser.CommandParser;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {
    
    private CommandParser parser;
    private ModuleList list;

    @BeforeEach
    public void setUp() {
        list = new ModuleList();
        parser = new CommandParser(list);
    }

    //parse in taken module with correct format
    @Test
    void parseTaken_expectCodeYearSemAndGrade()
            throws InvalidCommandException, InvalidModuleException, InvalidFormatException,
<<<<<<< HEAD
            InvalidGradeException, DuplicateModuleException, InvalidSemesterException, CourseIndexOutOfBoundsException {
=======
            InvalidGradeException, DuplicateModuleException, InvalidSemesterException, 
            InvalidIndexException, InvalidYearException {
>>>>>>> ad3d62fd00c02e7fef4e95aa9e3e3d8c4b597461
        String inputString = "taken CS2113 y/1 s/1 g/A+";
        String[] input = inputString.split(" ", 2);
        parser.parseCommand(input);
        String code = list.getModule(0).getCode();
        Integer year = list.getModule(0).getYear();
        Integer sem = list.getModule(0).getSem();
        String grade = list.getModule(0).getGrade();
        
        assertEquals("CS2113", code);
        assertEquals(1, year);
        assertEquals(1, sem);
        assertEquals("A+", grade);

    }

    //parse in plan module with correct format
    @Test
    void parsePlan_expectCodeYearAndSem()
            throws InvalidCommandException, InvalidModuleException, InvalidFormatException,
<<<<<<< HEAD
            InvalidGradeException, DuplicateModuleException, InvalidSemesterException, CourseIndexOutOfBoundsException {
=======
            InvalidGradeException, DuplicateModuleException, InvalidSemesterException, 
            InvalidIndexException, InvalidYearException {

>>>>>>> ad3d62fd00c02e7fef4e95aa9e3e3d8c4b597461
        String inputString = "plan CS2113 y/4 s/2";
        String[] input = inputString.split(" ", 2);
        parser.parseCommand(input);
        String code = list.getModule(0).getCode();
        Integer year = list.getModule(0).getYear();
        Integer sem = list.getModule(0).getSem();
        
        assertEquals("CS2113", code);
        assertEquals(4, year);
        assertEquals(2, sem);
    }

    //parse in remove module with module found
    @Test
    void parseRemove_moduleFound_expectTrue()
            throws InvalidCommandException, InvalidModuleException, InvalidFormatException,
<<<<<<< HEAD
            InvalidGradeException, DuplicateModuleException, InvalidSemesterException, CourseIndexOutOfBoundsException {
=======
            InvalidGradeException, DuplicateModuleException, InvalidSemesterException, 
            InvalidIndexException, InvalidYearException {
            
>>>>>>> ad3d62fd00c02e7fef4e95aa9e3e3d8c4b597461
        //add a module to the list and removes it, checks if module list is empty
        String inputString = "plan CS2113 y/4 s/2";
        String[] input = inputString.split(" ", 2);
        parser.parseCommand(input);
        assertEquals(1, list.size());

        String inputStringRemove = "remove CS2113";
        String[] inputRemove = inputStringRemove.split(" ", 2);
        parser.parseCommand(inputRemove);
        assertEquals(0, list.size());
    }

    //parse in remove module with no such module in list
    @Test
    void parseRemove_noModuleFound_expectException() {
        String inputString = "remove CS2113";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidCommandException.class,
            () -> parser.parseCommand(input)
        );
    }

    //parse in an invalid command expecting an InvalidCommandException
    @Test
    void parseInvalidCommand_expectException() {
        String inputString = "hello";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidCommandException.class,
            () -> parser.parseCommand(input)
        );
    }

    //parse in only the command without code, expects InvalidModuleException
    @Test
    void parsePlan_noCode_expectException() {
        String inputString = "plan";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidModuleException.class,
            () -> parser.parseCommand(input)
        );
    }

    //parse in plan module missing y/ or s/, expects InvalidFormatException
    @Test
    void parsePlan_noYearSemester_expectException() {
        String inputString = "plan CS2113";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidFormatException.class,
            () -> parser.parseCommand(input)
        );
    }

    //parse in taken module missing g/, expects InvalidFormatException
    @Test
    void parseTaken_noGrade_expectException() {
        String inputString = "taken CS2113 y/1 s/2";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidFormatException.class,
            () -> parser.parseCommand(input)
        );
    }

    //parse in plan module with g/ included, expected exception
    @Test
    void parsePlan_withGrade_expectException() {
        String inputString = "plan CS2113 y/1 s/2 g/A+";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidFormatException.class,
            () -> parser.parseCommand(input)
        );
    }

    //parse in empty y/ or s/ or g/, expected exception
    @Test
    void parseTaken_emptyYearSemGrade_expectException() {
        String inputString = "taken CS2113 y/ s/";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidFormatException.class,
            () -> parser.parseCommand(input)
        );
    }

    //parse in g/ in unexpected range (A+ to D, S/U)
    @Test
    void parseTaken_wrongGrade_expectException() {
        String inputString = "taken CS2113 y/1 s/2 g/K";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidGradeException.class,
            () -> parser.parseCommand(input)
        );
    }

    //parse in s/ in unexpected range (1 or 2)
    @Test
    void parseTaken_wrongSem_expectException() {
        String inputString = "taken CS2113 y/1 s/4";
        String[] input = inputString.split(" ", 2);
        assertThrows(
            InvalidFormatException.class,
            () -> parser.parseCommand(input)
        );
    }


}
