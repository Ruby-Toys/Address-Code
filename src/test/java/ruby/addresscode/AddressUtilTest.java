package ruby.addresscode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("getAddressListByCSV test")
    void testGetAddressListByCSV() throws IOException {
        List<Address> addressListByCSV = addressUtil.getAddressListByCSV();
        addressListByCSV.forEach(address -> log.info("address = {}", address));
        log.info("총 주소 개수 = {}", addressListByCSV.size());
    }

    @Test
    @DisplayName("getSidoList test")
    void testGetSidoList() throws IOException {
        List<String> sidoList = addressUtil.getSidoList();
        sidoList.forEach(sido -> log.info("sido = {}", sido));
        log.info("총 시도 개수 = {}", sidoList.size());
    }

    @Test
    @DisplayName("getSigunguList test")
    void testGetSigunguList() throws IOException {
        List<String> sigunguList = addressUtil.getSigunguList("서울특별시");
        sigunguList.forEach(sigungu -> log.info("sigungu = {}", sigungu));
        log.info("총 시군구 개수 = {}", sigunguList.size());
    }

    @Test
    @DisplayName("getEupmyeondongList test")
    void testGetEupmyeondongList() throws IOException {
        List<String> eupmyeondongList = addressUtil.getEupmyeondongList("서울특별시", "종로구");
        eupmyeondongList.forEach(eupmyeondong -> log.info("eupmyeondong = {}", eupmyeondong));
        log.info("총 읍면동 개수 = {}", eupmyeondongList.size());
    }

    @Test
    @DisplayName("getRiList test")
    void testGetRiList() throws IOException {
        List<String> riList = addressUtil.getRiList("강원도", "평창군", "진부면");
        riList.forEach(ri -> log.info("ri = {}", ri));
        log.info("총 리 개수 = {}", riList.size());
    }
}