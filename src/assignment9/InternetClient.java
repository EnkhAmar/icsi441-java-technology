package assignment9;

import java.io.*;
import java.util.*;

class InternetClient implements Serializable {
    private String name;
    private double monthlyFee;
    private int monthsOfService;
    private int monthsPrepaid;

    public InternetClient(String name, double monthlyFee, int monthsOfService, int monthsPrepaid) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.monthsOfService = monthsOfService;
        this.monthsPrepaid = monthsPrepaid;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public int getMonthsOfService() {
        return monthsOfService;
    }

    public int getMonthsPrepaid() {
        return monthsPrepaid;
    }

    @Override
    public String toString() {
        return "InternetClient{name='" + name + "', monthlyFee=" + monthlyFee +
                ", monthsOfService=" + monthsOfService + ", monthsPrepaid=" + monthsPrepaid + "}";
    }
}