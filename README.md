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
  file-path:          # ClassPathResource Path
  start-row:          # 읽을 데이터의 시작 Row
  bcode-col:          # 법정동 코드 Column Index
  sido-col:           # 시/도 Column Index
  sigungu-col:        # 시/군/구 Column Index
  eupmyeondong-col:   # 읍/면/동 Column Index
  ri-col:             # 리 Column Index
```

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