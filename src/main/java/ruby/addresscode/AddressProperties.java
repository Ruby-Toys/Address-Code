package ruby.addresscode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties("address-util")
public class AddressProperties {

    private final String filePath;
    private final Row row;
    private final Column column;
    
    record Row(Integer startRow, Integer endRow) {
        Row(Integer startRow, Integer endRow) {
            this.startRow = startRow == null ? 0 : startRow;
            this.endRow = endRow;
        }
    }

    record Column(int bcode, int sido, int sigungu, int eupmyeondong, int ri) {}
}
