package Domain;

import java.util.ArrayList;
import java.util.HashMap;

public class FinancialBook {
    private Float balance;
    private ArrayList<String> financialReports;
    private Team team;

    public FinancialBook(Float balance, ArrayList<String> financialReports, Team team) {
        this.balance = balance;
        this.financialReports = financialReports;
        this.team = team;
    }
}
