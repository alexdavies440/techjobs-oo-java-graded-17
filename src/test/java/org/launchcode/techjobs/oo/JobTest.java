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

        String firstChar = String.valueOf(job_five.toString().charAt(0));
        String lastChar = String.valueOf(job_five.toString().charAt(job_five.toString().length()-1));

        // Not sure why this alone didn't work
        //assertEquals(lineSeparator(), firstChar);
        //assertEquals(lineSeparator(), lastChar);

        String nl = lineSeparator();
        assertEquals(String.valueOf(nl.charAt(0)), firstChar);
        assertEquals(String.valueOf(nl.charAt(nl.length()-1)), lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

    }
}
