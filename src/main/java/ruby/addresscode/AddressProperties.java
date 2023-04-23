package ruby.addresscode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties("address-util")
public class AddressProperties {

    private final String filePath;
    private final int startRow;
    private final int bcodeCol;
    private final int sidoCol;
    private final int sigunguCol;
    private final int eupmyeondongCol;
    private final int riCol;
}
