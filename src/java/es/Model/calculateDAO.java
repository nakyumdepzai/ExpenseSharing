/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Model;

import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author nakyumdepzaii
 */
public class calculateDAO {

    Scanner input = new Scanner(System.in);
    int n;
    int n1 = 0;
    int n2 = 0;
    ArrayList<personDTO> p;
    ArrayList<pairDTO> pair;
    ArrayList<personDTO> plon;
    ArrayList<personDTO> pbe;
    double sumcung = 0;
    double summem = 0;
    double sumflex = 0;
    double sumno = 0;

    public void nhapSoLuong(int n) {
        this.n = n;
        p = new ArrayList<>();
        plon = new ArrayList<>();
        pbe = new ArrayList<>();
        pair = new ArrayList<>();
    }

    public calculateDAO() {

    }

    public void nhapThanhVien(int n) {
        System.out.println("Nhap ten thanh vien(" + n + ")");
        //Nhap ten thanh vien
        for (int i = 0; i < n; ++i) {
            System.out.print("Thanh vien " + (i + 1) + ": ");
            String name = input.nextLine();
            p.add(new personDTO(name)); //them thanh vien vao mang p
        }
    }

    public void nhapTienCung() {//tien cung la tien co dinh(chia deu cho tat ca thanh vien)
        System.out.print("Nhap tien cung ne: ");
        while (true) {
            String nhaptiencung = input.nextLine();
            if (nhaptiencung.equalsIgnoreCase("quit")) {
                break;
            } else {
                try {
                    double parsetiencung = Double.parseDouble(nhaptiencung);
                    sumcung += parsetiencung;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter quit or a valid number");
                }
            }
        }
        for (int i = 0; i < n; i++) {// set tien cung cho tung thanh vien
            p.get(i).setCung(sumcung * 1.0 / n);
        }
    }

    public void nhapTienShareNow(int n, HttpServletRequest request, ArrayList<personDTO> p) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            String name = request.getParameter("person" + (i + 1));
            double flex = Double.parseDouble(request.getParameter("amount" + (i + 1)));
            sum += flex;
            personDTO person = new personDTO();
            person.setName(name);
            person.setFlex(flex);
            p.add(person);
        }
        for (int i = 0; i < n; i++) {
            p.get(i).setDiff(-sum * 1.0 / n + p.get(i).getFlex());
        }
    }

    public void nhapTienMem() {//tien mem la tien cua tung thanh vien phai tra
        System.out.println("Nhap tien mem ne(khong co thi dien so 0): ");
        for (int i = 0; i < n; i++) {
            double sum = 0;
            System.out.print("Tien mem cua " + p.get(i).getName() + " : ");
            while (true) {
                String nhaptienmem = input.nextLine();
                if (nhaptienmem.equalsIgnoreCase("next")) {
                    break;
                } else {
                    try {
                        double parsetienmem = Double.parseDouble(nhaptienmem);
                        sum += parsetienmem;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter next or a valid number");
                    }
                }
            }
            summem += sum;//tong tien mem
            p.get(i).setMem(sum); //set tien mem cho tung thanh vien
        }
    }

    public void nhapTienFlex() {//tien flex la tien can chia deu cho tung thanh vien trong can ho
        System.out.println("Nhap tien flex ne(khong co thi dien so 0): ");
        for (int i = 0; i < n; i++) {
            double sum = 0;
            System.out.print("Tien flex cua " + p.get(i).getName() + ": ");
            while (true) {
                String nhaptienflex = input.nextLine();
                if (nhaptienflex.equalsIgnoreCase("next")) {
                    break;
                } else {
                    try {
                        double parsetienflex = Double.parseDouble(nhaptienflex);
                        sum += parsetienflex;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Please enter next or a valid number");
                    }
                }
            }
            sumflex += sum;//tong tien flex
            p.get(i).setFlex(sum);
        }
        for (int i = 0; i < n; i++) {// set su chenh lech cho tung thanh vien de tinh toan
            p.get(i).setDiff(-sumflex * 1.0 / n + p.get(i).getFlex());
        }
    }

    public void chia2Mang(int n, ArrayList<personDTO> p, ArrayList<personDTO> plon, ArrayList<personDTO> pbe) {//chia 2 mang de tinh toan
        for (int i = 0; i < n; i++) {
            if (p.get(i).getDiff() > 0) {
                plon.add(p.get(i)); //plon bao gom nhung thanh vien duoc nhan tien
                n1++;
            } else if (p.get(i).getDiff() < 0) {
                pbe.add(p.get(i));//pbe bao gom nhung thanh vien phai tra tien
                n2++;
            }
        }
        while (n1 != n2) {//truong hop 2 mang chenh lech do so nguoi le
            if (n1 > n2) {
                pbe.add(new personDTO("newname", false, 0, 0, 0, 0));
                n2++;
            } else if (n1 < n2) {
                plon.add(new personDTO("newname", false, 0, 0, 0, 0));
                n1++;
            }
        }
    }

    public void checkAdmin() {//admin se la nguoi chuyen khoan thanh toan cac khoan chi tieu
        int count = 0;
        boolean check = true;
        System.out.println("Nhap ten admin: ");
        System.out.println("Admin se la nguoi chiu trach nhiem dong cac khoan chi tieu!");
        do {
            String admin = input.nextLine();
            int i;
            for (i = 0; i < n; i++) {
                if (admin.equalsIgnoreCase(p.get(i).getName())) {
                    p.get(i).setAdmin(true);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Ten thanh vien khong ton tai! Xin hay nhap lai ten thanh vien!");
            } else {
                check = false;
            }
        } while (check);
    }

    public void setPair(int n, ArrayList<personDTO> p, ArrayList<pairDTO> pair) {//tao nC2 cap voi so tien no nhat dinh
        pair.ensureCapacity(n * (n - 1) / 2);
        int a = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a < pair.size()) {
                    pair.get(a).setPerson1(p.get(i));
                    pair.get(a).setPerson2(p.get(j));
                } else {
                    pair.add(new pairDTO(p.get(i), p.get(j), 0.0));
                }
                a++;
            }
        }   
//        for (int i = 0; i < pair.size(); i++) {//tien no la tien no
//            System.out.print(pair.get(i).getPerson1().getName() + " no " + pair.get(i).getPerson2().getName() + ": ");
//            double sum = 0;
//            while (true) {
//                String nhaptienno = input.nextLine();
//                if (nhaptienno.equalsIgnoreCase("next")) {
//                    break;
//                } else {
//                    try {
//                        double parsetienno = Double.parseDouble(nhaptienno);
//                        sum += parsetienno;
//                    } catch (NumberFormatException e) {
//                        System.out.println("Invalid input! Please enter next or a valid number");
//                    }
//                }
//            }
//            pair.get(i).setDebt(sum);
//        }
    }

    public void setCungSetMem() {//set tien cung tien mem cho tung cap ---- thu tu cap nhu sau Person1 Person 2 tienno <=> Person1 no Person2: tienno => neu tien no < 0 => Person2 no Person1: Math.abs(tienno)
        for (int i = 0; i < pair.size(); i++) {
            if (pair.get(i).getPerson1().isAdmin()) {//neu admin la Person1
                pair.get(i).setDebt(-pair.get(i).getPerson2().getCung() - pair.get(i).getPerson2().getMem() + pair.get(i).getDebt());
            } else if (pair.get(i).getPerson2().isAdmin()) {//neu admin la Person2
                pair.get(i).setDebt(pair.get(i).getPerson1().getCung() + pair.get(i).getPerson1().getMem() + pair.get(i).getDebt());
            }
        }
    }

    public ArrayList<pairDTO> tinhTien(ArrayList<pairDTO> pair, ArrayList<personDTO> plon, ArrayList<personDTO> pbe) {//tinh tien se cho ra ket qua no giua tat ca cac cap bao gom: tien cung, tien mem, tien flex va tien no
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (plon.get(j).getDiff() <= Math.abs(pbe.get(i).getDiff())) {//check neu 1 trong 2 nguoi trong cap dang xet co so tien check lech = 0 se skip
                    if (plon.get(j).getDiff() == 0 || pbe.get(i).getDiff() == 0) {
                        continue;
                    }
                    for (int k = 0; k < pair.size(); k++) {
                        if (pbe.get(i).equals(pair.get(k).getPerson1())) {//chieu thuan
                            if (plon.get(j).equals(pair.get(k).getPerson2())) {//check cap dang xet = cap trong mang pair
                                pair.get(k).setDebt(plon.get(j).getDiff() + pair.get(k).getDebt());//set tien no + them tien check lech 
                                break;
                            }
                        } else if (plon.get(j).equals(pair.get(k).getPerson1())) {//chieu nguoc 
                            if (pbe.get(i).equals(pair.get(k).getPerson2())) {//check cap dang xet = cap trong mang pair
                                pair.get(k).setDebt(pbe.get(i).getDiff() + pair.get(k).getDebt());//set tien no + them tien check lech 
                                break;
                            }
                        }
                    }
                    pbe.get(i).setDiff(pbe.get(i).getDiff() + plon.get(j).getDiff());
                    plon.get(j).setDiff(0);
                } else {
                    if (plon.get(j).getDiff() == 0 || pbe.get(i).getDiff() == 0) {
                        continue;
                    }
                    for (int k = 0; k < pair.size(); k++) {
                        if (pbe.get(i).equals(pair.get(k).getPerson1())) {//chieu thuan 
                            if (plon.get(j).equals(pair.get(k).getPerson2())) {
                                pair.get(k).setDebt(Math.abs(pbe.get(i).getDiff()) + pair.get(k).getDebt());
                                break;
                            }
                        } else if (plon.get(j).equals(pair.get(k).getPerson1())) {//chieu nguoc
                            if (pbe.get(i).equals(pair.get(k).getPerson2())) {
                                pair.get(k).setDebt(pbe.get(i).getDiff() + pair.get(k).getDebt());
                                break;
                            }
                        }
                    }
                    plon.get(j).setDiff(pbe.get(i).getDiff() + plon.get(j).getDiff());
                    pbe.get(i).setDiff(0);
                }
            }
        }
        for (int i = 0; i < pair.size(); i++) {
            if (pair.get(i).getDebt() < 0) {
                System.out.println(pair.get(i).getPerson1().getName() + " se tra " + pair.get(i).getPerson2().getName() + ": " + pair.get(i).getClass() + " kVND");
                personDTO temp = pair.get(i).getPerson1();
                pair.get(i).setPerson1(pair.get(i).getPerson2());
                pair.get(i).setPerson2(temp);
                pair.get(i).setDebt(Math.abs(pair.get(i).getDebt()));
            }
        }
        return pair;
//        System.out.println("Admin dong tien cung: " + sumcung + " kVND");
//        System.out.println("Admin dong tien mem: " + summem + " kVND");
    }
}
