package diplom.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Материал и его параметры")
public class Material {
    @Schema(description = "Имя материала")
    private String name;
    @Schema(description = "Модуль Юнга")
    private double YoungModule;
    @Schema(description = "Коэф. Пуассона")
    private double PoissonRatio;
}
