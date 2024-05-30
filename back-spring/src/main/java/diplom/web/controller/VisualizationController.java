package diplom.web.controller;

import diplom.buisness.service.VisualizationElementService;
import diplom.buisness.service.VisualizationLineService;
import diplom.data.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Visualization Controller", description = "Возвращает массивы для отображения")
@RestController
@RequestMapping("/api/visualize")
@RequiredArgsConstructor
public class VisualizationController {

    @Autowired
    private final VisualizationLineService visualizationLineService;

    @Autowired
    private final VisualizationElementService visualizationElementService;

    @Operation(description = "Возвращает массивы данных по линиям для визуализации")
    @PostMapping("/lines")
    public List<LineDataArray> getArraysForVisualizeLine(@RequestBody IndexesLineData indexesLineData) {
        return visualizationLineService.getArraysForVisualizeLines(indexesLineData);
    }

    @Operation(description = "Возвращает массивы данных по элементам (дентин, эмаль, вкладка) для визуализации")
    @PostMapping("/elements")
    public List<ElementDataArray> getArraysForVisualizeElement(@RequestBody IndexesElementData indexesElementData) {
        return visualizationElementService.getArraysForVisualizeElements(indexesElementData);
    }

    @Operation(description = "Возвращает массивы данных по всем элементам, но по определенным значениям (мин, макс, сред) для визуализации")
    @PostMapping("/elements/all")
    public List<AllElementsDataArray> getArraysForVisualizeAllElements(@RequestBody IndexesElementData indexesElementData) {
        return visualizationElementService.getArraysForVisualizeAllElements(indexesElementData);
    }
}
