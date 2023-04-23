package ruby.addresscode;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import ruby.csvfile.CSVFile;

import java.io.IOException;
import java.util.List;

import static ruby.addresscode.AddressProperties.Column;
import static ruby.addresscode.AddressProperties.Row;

@RequiredArgsConstructor
public class AddressUtil {

    private final AddressProperties addressProperties;

    public List<Address> getAddressListByCSV() throws IOException {
        CSVFile csvFile = getCSVFile();
        List<List<String>> addressList = csvFile.convertToData();

        Column column = addressProperties.getColumn();

        return addressList.stream()
                .map(address -> {
                    String bcode = address.get(column.bcode());
                    String sido = address.get(column.sido());
                    String sigungu = address.get(column.sigungu());
                    String eupmyeondong = address.get(column.eupmyeondong());
                    String ri = address.get(column.ri());
                    return new Address(bcode, sido, sigungu, eupmyeondong, ri);
                })
                .toList();
    }

    private CSVFile getCSVFile() throws IOException {
        ClassPathResource resource = new ClassPathResource(addressProperties.getFilePath());
        Row row = addressProperties.getRow();
        Integer startRow = row.startRow();
        Integer endRow = row.endRow();

        return endRow == null ? new CSVFile(resource.getFile(), startRow)
                : new CSVFile(resource.getFile(), startRow, endRow);
    }

    public List<String> getSidoList() throws IOException {
        CSVFile csvFile = getCSVFile();
        List<List<String>> addressList = csvFile.convertToData();

        int sidoIndex = addressProperties.getColumn().sido();

        return addressList.stream()
                .map(address -> address.get(sidoIndex))
                .filter(this::hasValue)
                .toList();
    }

    public List<String> getSigunguList(String sido) throws IOException {
        CSVFile csvFile = getCSVFile();
        List<List<String>> addressList = csvFile.convertToData();

        int sidoIndex = addressProperties.getColumn().sido();
        int sigunguIndex = addressProperties.getColumn().sigungu();

        return addressList.stream()
                .filter(address -> sido.equals(address.get(sidoIndex)))
                .map(address -> address.get(sigunguIndex))
                .filter(this::hasValue)
                .toList();
    }

    public List<String> getEupmyeondongList(String sido, String sigungu)
            throws IOException {
        CSVFile csvFile = getCSVFile();
        List<List<String>> addressList = csvFile.convertToData();

        int sidoIndex = addressProperties.getColumn().sido();
        int sigunguIndex = addressProperties.getColumn().sigungu();
        int eupmyeondongIndex = addressProperties.getColumn().eupmyeondong();

        return addressList.stream()
                .filter(address -> sido.equals(address.get(sidoIndex))
                        && sigungu.equals(address.get(sigunguIndex))
                )
                .map(address -> address.get(eupmyeondongIndex))
                .filter(this::hasValue)
                .toList();
    }

    public List<String> getRiList(String sido, String sigungu, String eupmyeondong)
            throws IOException {
        CSVFile csvFile = getCSVFile();
        List<List<String>> addressList = csvFile.convertToData();

        int sidoIndex = addressProperties.getColumn().sido();
        int sigunguIndex = addressProperties.getColumn().sigungu();
        int eupmyeondongIndex = addressProperties.getColumn().eupmyeondong();
        int riIndex = addressProperties.getColumn().ri();

        return addressList.stream()
                .filter(address -> sido.equals(address.get(sidoIndex))
                        && sigungu.equals(address.get(sigunguIndex))
                        && eupmyeondong.equals(address.get(eupmyeondongIndex))
                )
                .map(address -> address.get(riIndex))
                .filter(this::hasValue)
                .toList();
    }

    private boolean hasValue(String value) {
        return value != null && !value.isBlank();
    }
}
