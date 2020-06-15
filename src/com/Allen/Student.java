package com.Allen;


public class Student {

    String nume;
    int varsta;

    /**
     * Constructorul clasei Student
     * @param nume Seteaza numele studentului
     * @param varsta Seteaza varsta studentului
     */
    public Student(String nume,int varsta)
    {
        this.nume=nume;
        this.varsta=varsta;
    }

    /**
     * Metoda ce suprascrie metoda hashCode din clasa Object dupa algoritmul prezentat in enuntul temei
     */
    @Override
    public int hashCode()
    {
        int h=17;
        h=37*h+nume.hashCode();
        h=37*h+varsta;
        return h;
    }

    /**
     * Metoda ce suprascrie metoda equals din clasa Object si verifica daca datele a doi studenti sunt egale
     */
    @Override
    public boolean equals(Object o)
    {
        if(this.nume.equals(((Student)o).nume))
            if(this.varsta==((Student)o).varsta)
                return true;
        return false;
    }
}
