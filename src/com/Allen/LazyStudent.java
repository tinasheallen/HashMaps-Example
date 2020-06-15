package com.Allen;


public class LazyStudent extends Student {

    /**
     * Constructorul clasei LazyStudent ce apeleaza constructorul clasei Student
     * @param nume Initializeaza numele studentului
     * @param varsta Initializeaza varsta studentului
     */
    public LazyStudent(String nume, int varsta) {
        super(nume, varsta);
    }

    /**
     * Suprascrie metoda hashCode din clasa Object intorcand o valoare constanta intotdeauna
     */
    @Override
    public int hashCode()
    {
        return 1;
    }

    /**
     * Metoda ce suprascrie metoda equals din clasa Object si verifica daca datele a doi studenti sunt egale
     */
    @Override
    public boolean equals(Object o)
    {
        if(this.nume.equals(((LazyStudent)o).nume))
            if(this.varsta==((LazyStudent)o).varsta)
                return true;
        return false;
    }
}

