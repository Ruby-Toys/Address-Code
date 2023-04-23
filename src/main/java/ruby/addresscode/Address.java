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
        this.bcode = (bcode != null && !bcode.isBlank()) ? bcode : null;
        this.sido = (sido != null && !sido.isBlank()) ? sido : null;
        this.sigungu = (sigungu != null && !sigungu.isBlank()) ? sigungu : null;
        this.eupmyeondong = (eupmyeondong != null && !eupmyeondong.isBlank()) ? eupmyeondong : null;
        this.ri = (ri != null && !ri.isBlank()) ? ri : null;
        this.fullAddress = createFullAddress();
    }

    private String createFullAddress() {
        StringBuilder builder = new StringBuilder();
        if (sido != null && !sido.isBlank()) {
            builder.append(sido).append(" ");
        }
        if (sigungu != null && !sigungu.isBlank()) {
            builder.append(sigungu).append(" ");
        }
        if (eupmyeondong != null && !eupmyeondong.isBlank()) {
            builder.append(eupmyeondong).append(" ");
        }
        if (ri != null && !ri.isBlank()) {
            builder.append(ri);
        }

        return builder.toString();
    }
}
