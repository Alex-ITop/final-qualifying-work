package diplom.web.controller;

import diplom.buisness.service.ParametersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Parameters Controller", description = "Контроллер для задания параметров")
@RestController
@RequestMapping("/api/parameters")
@RequiredArgsConstructor
public class ParametersController {

    @Autowired
    private ParametersService parametersService;

    @PostMapping("/save")
    @Operation(description = "Сохранение выбранных параметров для дальнейших расчетов")
    public List<Double> saveParameters(@RequestBody List<Double> parameters) {
        return parametersService.saveParametersToFile(parameters);
    }
}
