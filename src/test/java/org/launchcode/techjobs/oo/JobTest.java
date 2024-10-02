package org.launchcode.techjobs.oo;

import com.sun.source.tree.AssertTree;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job_one = new Job();
        Job job_two = new Job();
        assertNotEquals(job_one.getId(), job_two.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test_job.getName() instanceof String);
        assertEquals("Product tester", test_job.getName());

        assertTrue(test_job.getEmployer() instanceof Employer);
        assertEquals("ACME", test_job.getEmployer().getValue());

        assertTrue(test_job.getLocation() instanceof Location);
        assertEquals("Desert", test_job.getLocation().getValue());

        assertTrue(test_job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", test_job.getPositionType().getValue());

        assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", test_job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job_three = new Job("Test Job", new Employer("Test Employer"), new Location("The Testing Place"), new PositionType("Test Tester"), new CoreCompetency("Testing Tests"));
        Job job_four = new Job("Test Job", new Employer("Test Employer"), new Location("The Testing Place"), new PositionType("Test Tester"), new CoreCompetency("Testing Tests"));

        assertFalse(job_three.equals(job_four));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {

        Job job_five = new Job("Test Job", new Employer("Test Employer"), new Location("The Testing Place"), new PositionType("Test Tester"), new CoreCompetency("Testing Tests"));

        String str = job_five.toString();
        String firstChar = String.valueOf(str.substring(0, lineSeparator().length()));
        String lastChar = String.valueOf(str.substring(str.length()-lineSeparator().length()));

        assertEquals(lineSeparator(), firstChar);
        assertEquals(lineSeparator(), lastChar);
    }

    // It turns out a new line is 2 characters??
//    @Test
//    public void checkLengthOfLineSeparator() {
//        assertEquals(2, lineSeparator().length());
//    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job_six = new Job("Test Job", new Employer("Test Employer"), new Location("The Testing Place"), new PositionType("Test Tester"), new CoreCompetency("Testing Tests"));
        String printResult = lineSeparator() + "ID: " + job_six.getId() + lineSeparator() + "Name: " + "Test Job" + lineSeparator() + "Employer: " + "Test Employer" + lineSeparator() + "Location: " + "The Testing Place" + lineSeparator() + "Position Type: " + "Test Tester" + lineSeparator() + "Core Competency: " + "Testing Tests" + lineSeparator();
        assertEquals(printResult, job_six.toString());
    }
}
