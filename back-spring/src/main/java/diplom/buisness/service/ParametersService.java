package diplom.buisness.service;

import diplom.buisness.utils.FileUtils;
import diplom.data.dto.FileProperties;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@EnableConfigurationProperties({FileProperties.class})
public class ParametersService {

    @Autowired
    private FileProperties fileProperties;

    public List<Double> saveParametersToFile(List<Double> parameters) {
        FileUtils.writeParametersToFile(fileProperties.getParameters(), parameters);
        return parameters;
    }
}
