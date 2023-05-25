package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
//하이버네이트 구현체를 사용할때만 제공되는 검증
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//javax 는 특정 구현에 관계없는 표준 인터페이스
@Data
public class Item {

    private Long id;

//    @NotBlank //빈값+공백일 경우 허용하지않는다
    private String itemName;
//    @NotNull //null을 허용하지않는다
//    @Range(min=1000,max=1000000)
    private Integer price;
//    @NotNull
//    @Max(9999)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
