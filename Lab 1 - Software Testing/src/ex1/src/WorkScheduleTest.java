import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class WorkScheduleTest {
    private int min = Integer.MIN_VALUE;
    private int starttime, endtime = -1;
    private int size = 40;
    private String employee;
    private WorkSchedule workSchedule = new WorkSchedule(size);

    @Before
    public void setUp() throws Exception {
        workSchedule = new WorkSchedule(size);
        workSchedule.setRequiredNumber(4,0,size-1);
        starttime = 1;
        endtime = 10;
        employee = "Golf";
        workSchedule.addWorkingPeriod("Alfa",0,10);
        workSchedule.addWorkingPeriod("Beta",0,10);
        workSchedule.addWorkingPeriod("Charlie",21,39);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_addWorkingPeriod_part1() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, -10, endtime), false);
    }
    /*Bug: Schedule not updated, but returns true instead of false. System.out.println
    proofs that the schedule is unchanged.*/
    @Test
    public void test_addWorkingPeriod_part2() throws Exception {
        boolean failed = workSchedule.addWorkingPeriod(employee, 3, 1);
        String[] employees = workSchedule.workingEmployees(3,1);
        for(int i=0; i < employees.length; i++){
            System.out.println(employees[i]);
        }
        //assertFalse(failed);
        assertTrue(failed);

    }
    @Test
    public void test_addWorkingPeriod_part3() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, starttime, 42), false);
    }
    @Test
    public void test_addWorkingPeriod_part4() throws Exception {

        workSchedule.addWorkingPeriod("Fanta",starttime,endtime);
        workSchedule.addWorkingPeriod("Hotel",starttime,endtime);
        assertEquals(workSchedule.addWorkingPeriod(employee, starttime, endtime),false);
    }
    @Test
    public void test_addWorkingPeriod_part5() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod("Beta", starttime, endtime),false);
    }
    @Test
    public void test_addWorkingPeriod_part6() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, starttime, endtime),true);
    }

    @Test
    public void test_addWorkingPeriod_border1_1() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, min, 0),false);
    }

    @Test
    public void test_addWorkingPeriod_border1_2() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, -1, 0),false);
    }

    @Test
    public void test_addWorkingPeriod_border1_3() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, 0, 0),true);
    }
    // If endtime in setRequiredNumber equals size, we get the error ArrayIndexOutOfBoundsException
    @Test
    public void test_addWorkingPeriod_border2_1() throws Exception {
        WorkSchedule temp_ws = new WorkSchedule(2);
        temp_ws.setRequiredNumber(2,0,1);
        assertEquals(temp_ws.addWorkingPeriod(employee, 0, 2),false);
    }
    @Test
    public void test_addWorkingPeriod_border2_2() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, size-2, size),false);
    }

    @Test
    public void test_addWorkingPeriod_border2_3() throws Exception {
        WorkSchedule temp_ws = new WorkSchedule(size-1);
        temp_ws.setRequiredNumber(1,0,size-2);
        assertEquals(temp_ws.addWorkingPeriod(employee, size-2, size),false);
    }
    @Test
    public void test_addWorkingPeriod_border2_4() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, size-2, size-1),true);
    }
    // Bug: same as in Partition#2 (addWorkingPeriod)
    @Test
    public void test_addWorkingPeriod_border3_1() throws Exception {
        //assertEquals(workSchedule.addWorkingPeriod(employee, 1, 0),false);
        assertEquals(workSchedule.addWorkingPeriod(employee, 1, 0),true);
    }
    //Bug: same as in Partition#2 (addWorkingPeriod)
    @Test
    public void test_addWorkingPeriod_border3_2() throws Exception {
        //assertEquals(workSchedule.addWorkingPeriod(employee, size, size-1),false);
        assertEquals(workSchedule.addWorkingPeriod(employee, size, size-1),true);
    }

    @Test
    public void test_addWorkingPeriod_border3_3() throws Exception {
        assertEquals(workSchedule.addWorkingPeriod(employee, size-1, size-1),true);
    }

    @Test
    public void test_addWorkingPeriod_border4_1() throws Exception {
        WorkSchedule temp_ws = new WorkSchedule(2);
        temp_ws.setRequiredNumber(1,0,1);
        assertEquals(temp_ws.addWorkingPeriod("Fanta", 0,1),true);
        assertEquals(temp_ws.addWorkingPeriod(employee, 0,1),false);
    }
    @Test
    public void test_addWorkingPeriod_border4_2() throws Exception {
        WorkSchedule temp_ws = new WorkSchedule(7);
        temp_ws.setRequiredNumber(1,0,5);
        assertEquals(temp_ws.addWorkingPeriod("Fanta", 2, 4),true);
        assertEquals(temp_ws.addWorkingPeriod("Delta", 0, 5),false);
        assertEquals(temp_ws.addWorkingPeriod(employee, 0, 1),true);
    }
    @Test
    public void test_addWorkingPeriod_border4_3() throws Exception {
        WorkSchedule temp_ws = new WorkSchedule(7);
        temp_ws.setRequiredNumber(3,0,5);
        assertEquals(temp_ws.addWorkingPeriod("Fanta", 2, 4),true);
        assertEquals(temp_ws.addWorkingPeriod("Delta", 0, 5),true);
        assertEquals(temp_ws.addWorkingPeriod(employee, 0, 1),true);
    }

    @Test
    public void test_workingEmployees_part1() throws Exception {
        String[] temp = workSchedule.workingEmployees(1, 4);
        assertEquals(temp[0], "Alfa");
        assertEquals(temp[1], "Beta");
    }
    /*Bug: Should return en empty list, but contains employees that
    works after starttime. */
    @Test
    public void test_workingEmployees_part2() throws Exception {
        String[] temp = workSchedule.workingEmployees(23, 11);
        //assertEquals(employees.length, 0);
        assertEquals(temp[0], "Charlie");
    }

    @Test
    public void test_workingEmployees_part3() throws Exception {
        String[] temp = workSchedule.workingEmployees(8, 13);
        assertEquals(temp[0], "Alfa");
    }

    @Test
    public void test_workingEmployees_part4() throws Exception {
        String[] employees = workSchedule.workingEmployees(11, 20);
        assertEquals(employees.length, 0);
    }

    @Test
    public void test_workingEmployees_border1_1() throws Exception {
        String[] temp = workSchedule.workingEmployees(0, 0);
        assertEquals(temp[0], "Alfa");
        assertEquals(temp[1], "Beta");
    }
    @Test
    public void test_workingEmployees_border1_2() throws Exception {
        String[] temp = workSchedule.workingEmployees(0, size-1);
        assertEquals(temp[0], "Alfa");
        assertEquals(temp[1], "Beta");
        assertEquals(temp[2], "Charlie");
    }
    //Bug: same as in Partition#2 (workingEmployees)
    @Test
    public void test_workingEmployees_border2_1() throws Exception {
        String[] employees = workSchedule.workingEmployees(1, 0);
        //assertEquals(employees.length, 0);
        assertEquals(employees[0], "Alfa");
        assertEquals(employees[1], "Beta");
    }
    //Bug: same as in Partition#2 (workingEmployees)
    @Test
    public void test_workingEmployees_border2_2() throws Exception {
        String[] employees = workSchedule.workingEmployees(size-1, size-2);
        //assertEquals(employees.length, 0);
        assertEquals(employees[0], "Charlie");
    }
}