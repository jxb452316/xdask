package restaurant.management.model;


import javax.persistence.*;

/**
 * TotalBill
 * Author: zhe.jiang
 * Desc:
 * Change log:
 * 2017/6/4 - created by zhe.jiang
 */
@Entity
@Table(name = "bill")
@SqlResultSetMapping(
        name = "TotalBill",
        classes = {
                @ConstructorResult(
                        targetClass = TotalBill.class,
                        columns = {
                                @ColumnResult(name = "range", type = String.class),
                                @ColumnResult(name = "amount", type = Double.class)
                        }
                )
        }
)
@NamedNativeQueries(value = {
        @NamedNativeQuery(
                name = "TotalBill.groupByYear",
                query = "select substring(date, 1, 4) as range, sum(pmoney) as amount from bill group by substring(date, 1, 4) order by substring(date, 1, 4)",
                resultSetMapping = "TotalBill"
        ),
        @NamedNativeQuery(
                name = "TotalBill.groupByMonth",
                query = "select substring(date, 1, 7) as range, sum(pmoney) as amount from bill group by substring(date, 1, 7) order by substring(date, 1, 7)",
                resultSetMapping = "TotalBill"
        ),
        @NamedNativeQuery(
                name = "TotalBill.groupByDay",
                query = "select date as range, sum(pmoney) as amount from bill group by date order by date",
                resultSetMapping = "TotalBill"
        )
})

public class TotalBill {
    @Id
    private Long id;
    private String range;
    private Double amount;

    public TotalBill() {}

    public TotalBill(String range, Double amount) {
        this.range = range;
        this.amount = amount;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
