package ruby.addresscode;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@RequiredArgsConstructor
@EnableConfigurationProperties(AddressProperties.class)
public class AddressConfig {

    private final AddressProperties addressProperties;

    @Bean
    public AddressUtil addressUtil() {
        return new AddressUtil(addressProperties);
    }

}
