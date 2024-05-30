package diplom.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Schema(description = "Индексы выбранных материала, элемента и мин/макс/сред из списков")
public class IndexesElementData {
    int indexOfMaterial;
    int indexOfElement;
    int indexOfMinMaxAvg;
}
