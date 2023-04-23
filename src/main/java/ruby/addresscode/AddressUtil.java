package ruby.addresscode;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import ruby.csvfile.CSVFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class AddressUtil {

    private final AddressProperties addressProperties;

    public List<Address> getAddressListByCSV() throws IOException {
        ClassPathResource resource = new ClassPathResource(addressProperties.getFilePath());
        CSVFile csvFile = new CSVFile(resource.getFile(), addressProperties.getStartRow());
        List<List<String>> dataList = csvFile.convertToData();

        return dataList.stream()
                .map(data -> {
                    String bcode = data.get(addressProperties.getBcodeCol());
                    String sido = data.get(addressProperties.getSidoCol());
                    String sigungu = data.get(addressProperties.getSigunguCol());
                    String eupmyeondong = data.get(addressProperties.getEupmyeondongCol());
                    String ri = data.get(addressProperties.getRiCol());
                    return Address.builder()
                            .bcode(bcode)
                            .sido(sido)
                            .sigungu(sigungu)
                            .eupmyeondong(eupmyeondong)
                            .ri(ri)
                            .build();
                })
                .toList();
    }
}
