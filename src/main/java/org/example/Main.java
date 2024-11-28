package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    private static Map<Integer, Employee> employeeMap;

    private static List<Employee> duplicatedEmplayees;

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "orhan", "kalsın"));
        employees.add(new Employee(1, "orhan", "kalsın"));
        employees.add(new Employee(1, "orhan", "kalsın"));
        employees.add(new Employee(2, "ali", "kıraç"));
        employees.add(new Employee(2, "ali", "kıraç"));
        employees.add(new Employee(3, "adnan", "şenses"));
        employees.add(new Employee(4, "selin", "karacehennem"));
        employees.add(new Employee(5, "emin", "çırak"));

        System.out.println(findDuplicates(employees).size());
        System.out.println(findUniques(employees).size());
        System.out.println(removeDuplicates(employees));

        //2.soru

        System.out.println(WordCounter.calculatedWord());


    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        employeeMap = new HashMap<>();
        duplicatedEmplayees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee==null){
                System.out.println("null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())){
                duplicatedEmplayees.add(employee);
            }else{
                employeeMap.put(employee.getId(),employee);
            }
        }
        return duplicatedEmplayees;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        //findDuplicates'ten sonrasını etkilenmemesi için tekrar bir hashMap oluşturmak lazım
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee==null){
                System.out.println("null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(),employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUniques = new LinkedList<>(uniques.values());
        onlyUniques.removeAll(duplicates);
        return onlyUniques;
    }
}