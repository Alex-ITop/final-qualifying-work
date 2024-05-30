package diplom.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Schema(description = "Индексы выбранных материала, линии и силы из списков")
public class IndexesLineData {
    int indexOfMaterial;
    int indexOfLine;
    int indexOfStrength;
}
