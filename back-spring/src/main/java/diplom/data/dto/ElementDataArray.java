package diplom.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Минимальные, средние и максимальные значения элемента")
public class ElementDataArray {
    @Schema(description = "Минимальные значения элемента")
    List<List<Double>> MinArray;
    @Schema(description = "Средние значения элемента")
    List<List<Double>> AverageArray;
    @Schema(description = "Максимальные значения элемента")
    List<List<Double>> MaxArray;
}
