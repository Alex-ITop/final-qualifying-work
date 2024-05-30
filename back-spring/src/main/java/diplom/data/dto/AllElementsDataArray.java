package diplom.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Минимальные, средние или максимальные значения по каждому элементу")
public class AllElementsDataArray {
    @Schema(description = "Минимальные, средние или максимальные значения по дентину")
    List<List<Double>> DentArray;
    @Schema(description = "Минимальные, средние или максимальные значения по эмали")
    List<List<Double>> EmalArray;
    @Schema(description = "Минимальные, средние или максимальные значения по вкладке")
    List<List<Double>> VklArray;
}
