package diplom.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("files")
@Getter
@Setter
@ToString
@Component
public class FileProperties {
    private String dataFiles;
    private String coordFiles;
    private String materials;
    private String parameters;
}
