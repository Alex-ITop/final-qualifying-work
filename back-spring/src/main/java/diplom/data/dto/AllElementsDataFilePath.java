package diplom.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Пути к файлам с минимальными, средними или максимальными значениями по каждому материалу")
public class AllElementsDataFilePath {
    @Schema(description = "Пути к файлам с минимальными, средними или максимальными значениями по дентину")
    String dentDataPath;
    @Schema(description = "Пути к файлам с минимальными, средними или максимальными значениями по эмали")
    String emalDataPath;
    @Schema(description = "Пути к файлам с минимальными, средними или максимальными значениями по влкдаке")
    String vklDataPath;
}
