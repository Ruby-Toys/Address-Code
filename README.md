## Address Code Library
- CSV 파일 기반 법정동 공공 데이터 추출 라이브러리
  - 법정동 파일 다운로드
    - https://www.data.go.kr/data/15063424/fileData.do?recommendDataYn=Y

<br><br>

### Settings
```groovy
dependencies {
    implementation files('libs/addressCode-1.0.0.jar')
}
```
```yaml
address-util:
  file-path:            # ClassPathResource Path
  row:
    start-row:          # 읽을 데이터의 시작 Row
    end-row:            # 읽을 데이터의 끝 Row. 생략 가능
  column:
    bcode:              # 법정동 코드 Column Index
    sido:               # 시/도 Column Index
    sigungu:            # 시/군/구 Column Index
    eupmyeondong:       # 읍/면/동 Column Index
    ri:                 # 리 Column Index
```

<br>

### API
- AddressUtil.getAddressListByCSV()
  - CSV 파일로부터 법정동 관련 데이터를 조회
- AddressUtil.getSidoList()
  - CSV 파일로부터 시/도 목록을 조회
- AddressUtil.getSigunguList(String sido)
  - CSV 파일로부터 시/도 에 해당하는 시/군/구 목록을 조회
- AddressUtil.getEupmyeondongList(String sido, String sigungu)
  - CSV 파일로부터 시/도, 시/군/구 에 해당하는 읍/면/동 목록을 조회
- AddressUtil.getRiList(String sido, String sigungu, String eupmyeondong)
  - CSV 파일로부터 시/도, 시/군/구, 읍/면/동 에 해당하는 리 목록을 조회

<br>

### Example
```java
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
```