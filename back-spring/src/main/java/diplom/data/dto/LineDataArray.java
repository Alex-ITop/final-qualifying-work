package diplom.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "спсики SFRI и PRES значений с соответствующими координатами (первый список координат, второй значений) для визуализации")
public class LineDataArray {

    List<List<Double>> SfriArrays;
    List<List<Double>> PresArrays;
}
