import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest
{
    Employee worker = new Employee(500, "USD", 0.1f, EmployeeType.Worker);
    Employee supervisor = new Employee(800, "USD", 0.2f, EmployeeType.Supervisor);
    Employee manager = new Employee(1500, "USD", 0.3f, EmployeeType.Manager);

    Employee worker2 = new Employee(500, "EUR", 0.1f, EmployeeType.Worker);
    Employee supervisor2 = new Employee(800, "EUR", 0.2f, EmployeeType.Supervisor);
    Employee manager2 = new Employee(1500, "EUR", 0.3f, EmployeeType.Manager);


    @Test
    @DisplayName("Salario segun el tipo de trabajador 'USD'")
    void salarioSegunElTipoDeTrabajadorUsd() {
        assertAll("SALARIO USD",
                () -> assertEquals(564.3, worker.cs(), 1),
                () ->assertEquals(864.4, supervisor.cs(), 1),
                () ->assertEquals(1564.5, manager.cs(), 1));
    }

    @Test
    @DisplayName("Salario segun tipo de trabajador 'not USD'")
    void salarioSegunTipoDeTrabajadorNotUsd() {

        assertAll("SALARIO NOT USD",
                () -> assertEquals(539.3, worker2.cs(), 1),
                () ->assertEquals(824.4, supervisor2.cs(), 1),
                () ->assertEquals(1489.5, manager2.cs(), 1));
    }

    @Test
    @DisplayName("Bono segun tipo de trabajador 'USD'")
    void bonoSegunTipoDeTrabajadorUsd() {
        assertAll("Bono USD",
                () -> assertEquals(386.0, worker.CalculateYearBonus(), 1),
                () ->assertEquals(993.0, supervisor.CalculateYearBonus(), 1),
                () ->assertEquals(1886.0, manager.CalculateYearBonus(), 1));
    }

    @Test
    @DisplayName("Bono segun tipo de trabajador 'not USD'")
    void bonoSegunTipoDeTrabajadorNotUsd() {
        assertAll("Bono USD",
                () -> assertEquals(386.0, worker2.CalculateYearBonus(), 1),
                () ->assertEquals(953.0, supervisor2.CalculateYearBonus(), 1),
                () ->assertEquals(1811.0, manager2.CalculateYearBonus(), 1));
    }
}
