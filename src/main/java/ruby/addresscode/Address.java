package ruby.addresscode;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Address {

    private final String bcode;
    private final String sido;
    private final String sigungu;
    private final String eupmyeondong;
    private final String ri;
    private final String fullAddress;

    @Builder
    public Address(String bcode, String sido, String sigungu, String eupmyeondong, String ri) {
        this.bcode = hasValue(bcode) ? bcode : null;
        this.sido = hasValue(sido) ? sido : null;
        this.sigungu = hasValue(sigungu) ? sigungu : null;
        this.eupmyeondong = hasValue(eupmyeondong) ? eupmyeondong : null;
        this.ri = hasValue(ri) ? ri : null;
        this.fullAddress = createFullAddress();
    }

    private String createFullAddress() {
        StringBuilder builder = new StringBuilder();
        if (hasValue(sido)) {
            builder.append(sido).append(" ");
        }
        if (hasValue(sigungu)) {
            builder.append(sigungu).append(" ");
        }
        if (hasValue(eupmyeondong)) {
            builder.append(eupmyeondong).append(" ");
        }
        if (hasValue(ri)) {
            builder.append(ri);
        }

        return builder.toString();
    }

    private boolean hasValue(String value) {
        return value != null && !value.isBlank();
    }
}
