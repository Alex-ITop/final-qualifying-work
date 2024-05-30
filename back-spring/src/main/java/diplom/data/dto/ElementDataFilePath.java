package diplom.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Путь к файлам с минимальными, средними и максимальными значениями элемента")
public class ElementDataFilePath {
    @Schema(description = "Путь к файлам с минимальными значениями элемента")
    String minDataPath;
    @Schema(description = "Путь к файлам с средними значениями элемента")
    String averageDataPath;
    @Schema(description = "Путь к файлам с максимальными значениями элемента")
    String maxDataPath;
}
