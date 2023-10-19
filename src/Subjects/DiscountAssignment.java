package Subjects;

public interface DiscountAssignment {
    double assignDiscount(boolean permission);
    double assignDiscountBySituation(String situation, boolean permission);
}
