/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Model;

/**
 *
 * @author nakyumdepzaii
 */
public class pairDTO {
    personDTO person1;
    personDTO person2;
    double debt;

    public pairDTO() {
    }

    public pairDTO(personDTO person1, personDTO person2, double debt) {
        this.person1 = person1;
        this.person2 = person2;
        this.debt = debt;
    }

    public personDTO getPerson1() {
        return person1;
    }

    public personDTO getPerson2() {
        return person2;
    }

    public double getDebt() {
        return debt;
    }

    public void setPerson1(personDTO person1) {
        this.person1 = person1;
    }

    public void setPerson2(personDTO person2) {
        this.person2 = person2;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    } 
}
