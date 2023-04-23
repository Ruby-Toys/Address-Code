package ruby.addresscode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.util.List;

@Slf4j
@SpringBootTest
@Import(AddressConfig.class)
class AddressUtilTest {

    @Autowired
    AddressUtil addressUtil;
    
    @Test
    void setUp() throws IOException {
        List<Address> addressListByCSV = addressUtil.getAddressListByCSV();
        addressListByCSV.forEach(address ->
                log.info("address = {}", address)
        );
        log.info("총 주소 개수 = {}", addressListByCSV.size());
    }

}